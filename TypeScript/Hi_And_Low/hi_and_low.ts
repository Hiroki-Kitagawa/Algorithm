import * as readline from "node:readline";

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

async function promptNumberInRange(rl: readline.Interface, min: number, max: number): Promise<number> {
  const raw = (await question(rl, `${min}-${max}で数字を入力してください: `)).trim();
  const n = Number.parseInt(raw, 10);
  if (Number.isFinite(n) && n >= min && n <= max) return n;
  return promptNumberInRange(rl, min, max);
}

async function main(): Promise<void> {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  try {
    const secret = Math.floor(Math.random() * 101); // 0..100
    let attempts = 1;

    while (true) {
      const guess = await promptNumberInRange(rl, 0, 100);
      if (guess === secret) {
        console.log(`正解!! ${attempts}回で当たりました`);
        break;
      }
      if (guess < secret) console.log("もっと上");
      else console.log("もっと下");
      attempts++;
    }
  } finally {
    rl.close();
  }
}

main().catch((err) => {
  console.error(err);
  process.exitCode = 1;
});

