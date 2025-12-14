import * as readline from "node:readline";

function question(rl: readline.Interface, prompt: string): Promise<string> {
  return new Promise((resolve) => rl.question(prompt, resolve));
}

async function promptHandIndex(rl: readline.Interface): Promise<0 | 1 | 2> {
  const raw = (await question(rl, "> 0.グー 1.チョキ 2.パー : ")).trim();
  const n = Number.parseInt(raw, 10);
  if (n === 0 || n === 1 || n === 2) return n;
  console.log("入力値は 0, 1, 2 のいずれかを入力してください");
  return promptHandIndex(rl);
}

async function main(): Promise<void> {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  try {
    const hands = ["グー", "チョキ", "パー"] as const;

    while (true) {
      console.log("じゃんけん・・・");
      const playerIdx = await promptHandIndex(rl);
      const compIdx = Math.floor(Math.random() * 3) as 0 | 1 | 2;

      const playerHand = hands[playerIdx];
      const compHand = hands[compIdx];

      console.log("ぽん！！");
      console.log(`(コンピューター) ${compHand}`);
      console.log(`(あなた) ${playerHand}`);

      if (playerIdx === compIdx) {
        console.log("アイコでしょ！！");
        continue;
      }

      const playerWin =
        (playerIdx === 0 && compIdx === 1) || (playerIdx === 1 && compIdx === 2) || (playerIdx === 2 && compIdx === 0);

      console.log(playerWin ? "あなたの勝ち！！" : "コンピューターの勝ち！！");
      break;
    }
  } finally {
    rl.close();
  }
}

main().catch((err) => {
  console.error(err);
  process.exitCode = 1;
});
