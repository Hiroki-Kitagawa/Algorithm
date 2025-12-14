import * as readline from "node:readline";

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

function createRand4DifferentDigits(): number[] {
  const digits = new Set<number>();
  while (digits.size < 4) digits.add(Math.floor(Math.random() * 10));
  return [...digits];
}

function arraysEqual(a: number[], b: number[]): boolean {
  if (a.length !== b.length) return false;
  for (let i = 0; i < a.length; i++) if (a[i] !== b[i]) return false;
  return true;
}

function computeHitsAndBlows(secret: number[], guess: number[]): { hits: number; blows: number } {
  let hits = 0;
  for (let i = 0; i < secret.length; i++) {
    if (secret[i] === guess[i]) hits++;
  }

  let blows = 0;
  for (let i = 0; i < secret.length; i++) {
    for (let j = 0; j < guess.length; j++) {
      if (i !== j && secret[i] === guess[j]) blows++;
    }
  }
  return { hits, blows };
}

async function prompt4Digits(rl: readline.Interface): Promise<number[]> {
  const raw = await question(rl, "4桁の数字を入力してください: ");
  const digits = raw.match(/\d/g);
  if (!digits || digits.length !== 4) return prompt4Digits(rl);
  return digits.map((d) => Number.parseInt(d, 10));
}

async function main(): Promise<void> {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  try {
    const secret = createRand4DifferentDigits();
    let attempts = 1;

    while (true) {
      const guess = await prompt4Digits(rl);
      if (arraysEqual(secret, guess)) {
        console.log(`${attempts}回で正解!!`);
        break;
      }

      const { hits, blows } = computeHitsAndBlows(secret, guess);
      console.log(`外れ!! ${hits}Hits, ${blows}Blow`);
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

