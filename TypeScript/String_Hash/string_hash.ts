import * as readline from "node:readline";

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

function wordCount(text: string): string[] {
  const words = text.trim().split(/\s+/).filter(Boolean);
  const counts = new Map<string, number>();

  for (const w of words) counts.set(w, (counts.get(w) ?? 0) + 1);
  return [...counts.entries()].map(([w, c]) => `${w}: ${c}`);
}

async function main(): Promise<void> {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  try {
    const input = await question(rl, "文字列を入力してください: ");
    console.log(`{${wordCount(input).join(", ")}}`);
  } finally {
    rl.close();
  }
}

main().catch((err) => {
  console.error(err);
  process.exitCode = 1;
});

