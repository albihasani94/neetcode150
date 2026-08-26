# Binary Search Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/binary-search/question?list=neetcode150)

## Rebuild chain

Target lookup in sorted distinct values + O(log n) → keep a closed candidate interval → midpoint comparison discards a provably impossible half → include equality in the loop → empty interval proves absence.

## Recognition

- **Decisive clue:** sorted order turns one comparison into permission to eliminate half the remaining indices.
- **Constraint goal:** O(log n) means the unresolved search space must shrink by a constant factor each iteration.
- **Boundary convention:** a closed interval `[low, high]` is nonempty while `low ≤ high`.

## State and invariant

- If the target exists, its index lies in `[low, high]` before every iteration.
- When target exceeds the midpoint value, all indices through midpoint are too small; when it is smaller, all indices from midpoint onward are too large.
- `low > high` means no candidate index remains and is the only proof of absence.

```text
target = 4

[0..5]  mid=2, value=2  → discard indices [0..2]
[3..5]  mid=4, value=6  → discard indices [4..5]
[3..3]  mid=3, value=4  → found
```

## Reconstruction recipe

1. Initialize a closed interval covering the entire array.
2. While it is nonempty, choose a midpoint without adding the two endpoints directly.
3. Return the midpoint on equality.
4. Otherwise exclude the midpoint and the impossible half by moving `low` to `mid + 1` or `high` to `mid - 1`.
5. Return `-1` only after the interval becomes empty.

## Worked transition

For `[-1,0,2,4,6,8]`, target `4`, midpoint value `2` is too small, so indices `0..2` are discarded. The next midpoint is index `4` with value `6`, so discard `4..5`; index `3` remains and matches.

Boundary: for one element, `low == high` still represents a real candidate, which is why the loop condition includes equality.

## Recall drill

### What must remain true about a target that exists?

<details>
<summary>Reveal</summary>

Its index remains inside the current closed interval after every justified half-discard.

</details>

### Why is `mid = low + (high - low) / 2` preferred?

<details>
<summary>Reveal</summary>

It avoids overflow from directly adding large endpoint indices.

</details>

## Trap and cost

- **Trap:** returning “not found” inside the loop turns binary search into a premature midpoint check; only the exhausted interval proves absence.
- **Time:** O(log n), because the interval roughly halves each iteration.
- **Space:** O(1).
