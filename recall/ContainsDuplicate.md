# Contains Duplicate Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/duplicate-integer/question?list=neetcode150)

## Rebuild chain

“Appears more than once” + up to 100,000 values → avoid pairwise comparisons → remember only values already seen → hash set → before each step, the set equals the processed prefix → reject on the first failed insertion.

## Recognition

- **Decisive clue:** the question asks only whether a value has appeared before, not where or how often.
- **Constraint pressure:** checking every pair is O(n²), which does not scale to `n = 10^5`; average O(1) membership makes a linear scan possible.
- **Required operation:** test-and-record one value in a single operation.

## State and invariant

- `seen` represents every distinct value in the prefix already processed.
- Before processing the next value, it is a duplicate exactly when it is already in `seen`.
- If the scan finishes, no two positions held the same value.

## Reconstruction recipe

1. Start with an empty set.
2. Scan values from left to right.
3. Try to add each value; if it was already present, return true immediately.
4. Return false only after the whole input has been processed.

## Worked transition

For `[1, 2, 3, 3]`, the set becomes `{1}`, `{1,2}`, `{1,2,3}`. Adding the final `3` changes nothing, which is the duplicate signal.

Boundary: an empty or one-element input finishes without a failed insertion, so the answer is false.

## Recall drill

### Why is a set enough state?

<details>
<summary>Reveal</summary>

Only prior presence matters; counts and indices do not affect the boolean answer.

</details>

### What does a failed insertion prove?

<details>
<summary>Reveal</summary>

The same value occurred at an earlier index because the set contains exactly the processed prefix's distinct values.

</details>

## Trap and cost

- **Trap:** sorting works but changes the target complexity to O(n log n); hashing is the linear-time pattern this problem is meant to expose.
- **Time:** O(n) average, from one pass with average O(1) set operations.
- **Space:** O(n) in the all-distinct case.
