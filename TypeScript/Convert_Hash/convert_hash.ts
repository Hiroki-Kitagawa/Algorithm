const KEY_TEXT = "text";

type JsonValue = string | number | boolean | null | JsonObject | JsonValue[];
type JsonObject = { [key: string]: JsonValue };

function toUry(beforeConversion: JsonObject): JsonObject {
  for (const [key, value] of Object.entries(beforeConversion)) {
    if (key === KEY_TEXT && typeof value === "string") {
      beforeConversion[key] = value.replace(/foo/g, "uryyyy!!");
      continue;
    }

    if (value && typeof value === "object" && !Array.isArray(value)) {
      toUry(value as JsonObject);
    }
  }
  return beforeConversion;
}

function main(): void {
  const beforeConversion: JsonObject = {
    main: {
      first: { text: "foobar" },
      second: { text: "fizzbuzz", child: { text: "foobar" } },
    },
    sub: {
      first: { text: "fizzbuzz", child: { text: "foobar" } },
      second: {
        third: { text: "barfoo", child: { text: "foobar" } },
        forth: { child: { text: "jit_foo_foo" } },
      },
    },
    text: "foofava",
  };

  const converted = toUry(beforeConversion);
  console.log(JSON.stringify(converted, null, 2));
}

main();

