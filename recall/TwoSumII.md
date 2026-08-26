# Two Integer Sum II Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode150)

## Rebuild chain

Sorted input + exactly one pair → start with smallest and largest → compare sum to target → sortedness proves which endpoint can be discarded → converge → convert positions to 1-based indices.

## Recognition

- **Decisive clue:** sorted order turns a comparison into information about an entire set of pairs.
- **Why not a map:** hashing is linear too, but it spends O(n) space and ignores the ordering advantage.
- **Required output detail:** indices are 1-based and must use two distinct positions.

## State and invariant

- If the solution has not been found, a valid pair remains inside `[left, right]`.
- If the endpoint sum is too small, the left value is too small even with the largest available partner, so discard it.
- If the sum is too large, the right value is too large even with the smallest available partner, so discard it.

## Reconstruction recipe

1. Put pointers on the first and last elements.
2. Compare their sum with the target.
3. Move the left pointer inward for a too-small sum; move the right pointer inward for a too-large sum.
4. On equality, return both positions shifted from zero-based to one-based indexing.

## Worked transition

For `[1,2,3,4]`, target `3`: endpoints sum to `5`, so move right; `1+3=4`, move right again; `1+2=3`, return `[1,2]`.

Boundary: `[5,5]`, target `10`, begins with two distinct positions and returns them directly.

## Recall drill

### Why can a too-small sum discard the left endpoint?

<details>
<summary>Reveal</summary>

It was paired with the largest candidate already; every other partner would make an equal or smaller sum.

</details>

### Which contract detail is unrelated to the pointer logic but still easy to fail?

<details>
<summary>Reveal</summary>

The answer must use 1-based indices.

</details>

## Trap and cost

- **Trap:** returning internal zero-based positions without adding one produces the right pair under the wrong contract.
- **Time:** O(n), because one endpoint is discarded per iteration.
- **Space:** O(1).
