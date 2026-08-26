# Sliding Window Maximum Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/sliding-window-maximum/question?list=neetcode150)

## Rebuild chain

Maximum for every overlapping width-`k` window + linear target → rescanning each window is too costly → decreasing deque of candidate indices → evict expired front and dominated back → front is always the current maximum.

## Recognition

- **Decisive clues:** adjacent windows overlap heavily, so their maximum candidates should be reused.
- **Constraint pressure:** O(nk) rescanning can approach O(n²) for `n = 1,000`; a monotonic deque gives O(n).
- **Why indices:** values alone cannot tell when a candidate has left the window.

## State and invariant

- Deque indices are ordered from oldest to newest and all lie in the current window.
- Their values are strictly decreasing from front to back.
- Therefore the front is the window maximum.
- A candidate removed from the back is no larger than a newer value, so it can never become maximum before that newer value expires.

```text
window values:  [ 4, 2, 6 ]
deque indices:        [6]
deque values:         [6]      front = maximum

Both 4 and 2 are dominated by the newer 6 and can never win again.
```

## Reconstruction recipe

1. Allocate one result slot per window: `n - k + 1`.
2. Scan indices from left to right.
3. Remove front indices that are no longer inside the width-`k` window.
4. Remove back indices whose values are no greater than the entering value.
5. Append the entering index.
6. Once the first full window exists, emit the value at the deque's front for every step.

## Worked transition

For `[1,2,1,0,4,2,6]`, `k=3`, the first window's deque represents values `[2,1]`, so emit `2`. When `4` enters, it removes smaller back candidates and becomes the front, producing the next maxima until `6` replaces it.

Boundary: with `k=1`, each old index expires as the next arrives, so every element is its own window maximum.

## Recall drill

### Why are smaller values removed from the back permanently?

<details>
<summary>Reveal</summary>

The new value is at least as large and expires later, so the older smaller value can never be the best remaining candidate.

</details>

### Why store indices instead of values?

<details>
<summary>Reveal</summary>

An index reveals both a candidate's value and whether it lies before the current window boundary.

</details>

## Trap and cost

- **Trap:** overlapping windows number `n - k + 1`, not `n / k + 1`.
- **Time:** O(n), because every index enters once and leaves the deque at most once.
- **Space:** O(k) for at most one window's candidates, plus O(n - k + 1) required output.
