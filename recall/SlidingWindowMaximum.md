# Sliding Window Maximum Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/sliding-window-maximum/question?list=neetcode150)

## Rebuild chain

Maximum for every overlapping width-`k` window + linear target → rescanning each window is too costly → decreasing deque of candidate indices → evict expired front and dominated back → front is always the current maximum.

## Recognition

- **Decisive clues:** adjacent windows overlap heavily, so their maximum candidates should be reused.
- **Constraint pressure:** with up to 100,000 elements and `k` near `n/2`, rescanning all windows takes O(n²). A monotonic deque achieves O(n), improving on NeetCode's recommended O(n log n) or better.
- **Why indices:** values alone cannot tell when a candidate has left the window.

## State and invariant

- Deque indices are ordered from oldest to newest and all lie in the current window.
- Their values are strictly decreasing from front to back.
- Therefore the front is the window maximum.
- A candidate removed from the back is no larger than a newer value, so it can never become maximum before that newer value expires.

```text
window indices:  [ 4, 5, 6 ]
window values:   [ 4, 2, 6 ]

before index 6 enters:
deque indices:  front → [4, 5] ← back
deque values:           [4, 2]

index 6 (value 6) dominates both back candidates:
deque indices:  front → [6] ← back
deque values:           [6]       maximum = 6
```

## Reconstruction recipe

1. Allocate one result slot per window: `n - k + 1`.
2. Scan indices from left to right.
3. Remove front indices that are no longer inside the width-`k` window.
4. Remove back indices whose values are no greater than the entering value.
5. Append the entering index.
6. Once the first full window exists, emit the value at the deque's front for every step.

## Worked transition

For `[3,1,2]`, `k=2`, the first window has deque indices `[0,1]`, values `[3,1]`, so emit `3`. When index `2` enters:

1. The new window starts at index `1`: expire index `0` from the front, even though its value `3` is still largest.
2. The new value `2` dominates value `1`: remove index `1` from the back.
3. Append index `2` and emit `2`. The result is `[3,2]`.

Expiry and domination are separate reasons to discard a candidate; without front expiry, the second maximum would incorrectly remain `3`.

Boundary: with `k=1`, each old index expires as the next arrives, so every element is its own window maximum.

## Recall drill

### When can an unexpired candidate be discarded permanently?

<details>
<summary>Reveal</summary>

When a newer value is at least as large: it expires later, so the older candidate cannot be needed as the maximum. Remove such candidates from the back of the deque.

</details>

### What information must each candidate retain as the window moves?

<details>
<summary>Reveal</summary>

Its value and its position, to detect expiry. Storing an index provides both: look up the value in the input and compare the index with the current window boundary.

</details>

### Rebuild the full algorithm and justify its costs.

<details>
<summary>Reveal</summary>

Allocate n - k + 1 outputs. For each index, expire old front indices, discard back candidates no larger than the entering value, then append it. Indices stay in window order and values strictly decrease. Emit the front value once the window is full. Each index enters and leaves once: O(n) time, O(k) auxiliary space, plus output.

</details>

## Trap and cost

- **Trap:** overlapping windows number `n - k + 1`, not `n / k + 1`.
- **Time:** O(n), because every index enters once and leaves the deque at most once.
- **Space:** O(k) for at most one window's candidates, plus O(n - k + 1) required output.
