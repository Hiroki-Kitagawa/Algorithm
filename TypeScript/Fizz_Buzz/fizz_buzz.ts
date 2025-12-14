import * as readline from "node:readline";

function fizzBuzz(n: number): string {
  if (n % 15 === 0) return "FizzBuzz";
  if (n % 3 === 0) return "Fizz";
  if (n % 5 === 0) return "Buzz";
  return String(n);
}

function joinFizzBuzz(n: number): string {
  const parts: string[] = [];
  for (let i = 1; i <= n; i++) parts.push(fizzBuzz(i));
  return parts.join(", ");
}

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

async function promptPositiveInt(rl: readline.Interface): Promise<number> {
  const answer = (await question(rl, "数字を入力してください (1以上): ")).trim();
  const n = Number.parseInt(answer, 10);
  if (Number.isFinite(n) && n >= 1) return n;
  return promptPositiveInt(rl);
}

async function main(): Promise<void> {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  try {
    const n = await promptPositiveInt(rl);
    console.log(joinFizzBuzz(n));
  } finally {
    rl.close();
  }
}

main().catch((err) => {
  console.error(err);
  process.exitCode = 1;
});

