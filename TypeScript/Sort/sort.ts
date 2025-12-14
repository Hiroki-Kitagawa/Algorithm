function sum(nums: number[]): number {
  return nums.reduce((acc, n) => acc + n, 0);
}

function ave(nums: number[]): number {
  return Math.floor(sum(nums) / nums.length);
}

function descBubbleSort(nums: number[]): number[] {
  const a = nums.slice();
  const tries = (a.length * (a.length - 1)) / 2;

  for (let t = 0; t < tries; t++) {
    for (let i = 0; i < a.length - 1; i++) {
      if (a[i] < a[i + 1]) {
        const tmp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = tmp;
      }
    }
  }
  return a;
}

function ascQuickSort(nums: number[]): number[] {
  if (nums.length <= 1) return nums.slice();
  const [pivot, ...rest] = nums;
  const left: number[] = [];
  const right: number[] = [];
  for (const n of rest) {
    if (n < pivot) left.push(n);
    else right.push(n);
  }
  return [...ascQuickSort(left), pivot, ...ascQuickSort(right)];
}

function main(): void {
  const target = [20, 31, 42, 13, 5, 38];
  const asc = ascQuickSort(target);
  const desc = descBubbleSort(target);

  console.log(`合計   : ${sum(target)}`);
  console.log(`平均   : ${ave(target)}`);
  console.log(`最大値 : ${desc[0]}`);
  console.log(`最小値 : ${asc[0]}`);
  console.log(`小さい順: ${asc.join(", ")}`);
  console.log(`大きい順: ${desc.join(", ")}`);
}

main();

