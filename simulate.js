// Mirror of the Java SortAlgorithms/SortExperiment to produce real numbers.

function selectionSort(arr, c) {
  const n = arr.length;
  for (let i = 0; i < n - 1; i++) {
    let minIdx = i;
    for (let j = i + 1; j < n; j++) {
      c.comparisons++;
      if (arr[j] < arr[minIdx]) minIdx = j;
    }
    if (minIdx !== i) { const t = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = t; }
  }
}

function insertionSort(arr, c) {
  const n = arr.length;
  for (let i = 1; i < n; i++) {
    const key = arr[i];
    let j = i - 1;
    while (j >= 0) {
      c.comparisons++;
      if (arr[j] > key) { arr[j + 1] = arr[j]; j--; } else break;
    }
    arr[j + 1] = key;
  }
}

function mergeSort(arr, c) {
  if (arr.length < 2) return;
  const temp = new Array(arr.length);
  (function ms(arr, temp, low, high) {
    if (low < high) {
      const mid = low + ((high - low) >> 1);
      ms(arr, temp, low, mid);
      ms(arr, temp, mid + 1, high);
      merge(arr, temp, low, mid, high);
    }
  })(arr, temp, 0, arr.length - 1);

  function merge(arr, temp, low, mid, high) {
    for (let i = low; i <= high; i++) temp[i] = arr[i];
    let i = low, j = mid + 1, k = low;
    while (i <= mid && j <= high) {
      c.comparisons++;
      if (temp[i] <= temp[j]) arr[k++] = temp[i++]; else arr[k++] = temp[j++];
    }
    while (i <= mid) arr[k++] = temp[i++];
    while (j <= high) arr[k++] = temp[j++];
  }
}

function quickSort(arr, c) {
  (function qs(arr, low, high) {
    if (low < high) {
      const p = partition(arr, low, high);
      qs(arr, low, p - 1);
      qs(arr, p + 1, high);
    }
  })(arr, 0, arr.length - 1);

  function partition(arr, low, high) {
    const pivot = arr[high];
    let i = low - 1;
    for (let j = low; j < high; j++) {
      c.comparisons++;
      if (arr[j] < pivot) { i++; const t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
    }
    const t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
    return i + 1;
  }
}

// Seeded RNG matching Java's java.util.Random(42) for reproducibility.
// Uses BigInt because the 48-bit LCG state exceeds JS 32-bit bitwise limits.
function javaRandom(seed) {
  const MULT = 0x5DEECE66Dn;
  const ADD = 0xBn;
  const MASK = (1n << 48n) - 1n;
  let s = (BigInt(seed) ^ MULT) & MASK;
  function next(bits) {
    s = (s * MULT + ADD) & MASK;
    return s >> (48n - BigInt(bits));
  }
  return function nextInt(bound) {
    const b = BigInt(bound);
    let bits, val;
    do {
      bits = next(31);
      val = bits % b;
    } while (bits - val + (b - 1n) < 0n);
    return Number(val);
  };
}

const algorithms = {
  'Selection Sort': selectionSort,
  'Insertion Sort': insertionSort,
  'Merge Sort': mergeSort,
  'Quick Sort': quickSort,
};

function runExperiment(original) {
  for (const name of Object.keys(algorithms)) {
    const c = { comparisons: 0 };
    const copy = original.slice();
    const start = process.hrtime.bigint();
    algorithms[name](copy, c);
    const end = process.hrtime.bigint();
    const ns = Number(end - start);
    console.log(
      name.padEnd(14) + ' ' + String(original.length).padEnd(14) + ' ' +
      String(c.comparisons).padStart(14) + ' ' + String(ns).padStart(16)
    );
  }
}

function randomArray(nextInt, size) {
  const arr = new Array(size);
  for (let i = 0; i < size; i++) arr[i] = nextInt(1000000);
  return arr;
}

const nextInt = javaRandom(42);
const sizes = [20, 50, 100, 500];

console.log('PART C - ALGORITHM EXPERIMENT (random arrays)');
console.log('===============================================');
console.log('Algorithm      Input Size     Comparisons        Time (ns)');
console.log('----------------------------------------------------------------');

let original100 = null;
for (const size of sizes) {
  const original = randomArray(nextInt, size);
  if (size === 100) original100 = original;
  runExperiment(original);
}

console.log();
console.log('ADDITIONAL TEST - ALMOST-SORTED 100-element array');
console.log('==================================================');
console.log('Algorithm      Input Size     Comparisons        Time (ns)');
console.log('----------------------------------------------------------------');
const almost = original100.slice().sort((a, b) => a - b);
[[0, 1], [2, 3], [4, 5], [6, 7], [8, 9]].forEach(([x, y]) => {
  const t = almost[x]; almost[x] = almost[y]; almost[y] = t;
});
runExperiment(almost);
