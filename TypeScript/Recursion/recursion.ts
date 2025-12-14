import * as readline from "node:readline";

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

function sumToZero(n: number, acc = 0): number {
  const next = acc + n;
  if (n > 0) return sumToZero(n - 1, next);
  if (n < 0) return sumToZero(n + 1, next);
  return next;
}

async function main(): Promise<void> {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  try {
    const raw = (await question(rl, "数字を入力してください: ")).trim();
    const n = Number.parseInt(raw, 10);
    if (!Number.isFinite(n)) {
      console.log("数値として解釈できませんでした");
      return;
    }
    console.log(sumToZero(n));
  } finally {
    rl.close();
  }
}

main().catch((err) => {
  console.error(err);
  process.exitCode = 1;
});

