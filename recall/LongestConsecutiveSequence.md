# Longest Consecutive Sequence Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/longest-consecutive-sequence/question?list=neetcode150)

## Rebuild chain

Longest consecutive run + unsorted + O(n) → hash all values → only start at values with no predecessor → walk successors → each distinct value belongs to one started run → track the maximum length.

## Recognition

- **Decisive clue:** O(n) forbids sorting; consecutive-value membership must be checked without regard to input position.
- **Naive danger:** starting a walk at every value repeats long suffixes and can become O(n²).
- **Start test:** `x` begins a run exactly when `x - 1` is absent.

## State and invariant

- The set contains every distinct input value, so duplicates do not lengthen a sequence.
- A successor walk begins only at the minimum value of a maximal consecutive run.
- Consequently, every distinct value is traversed as part of at most one run.

```text
set: {1,2,3,4,100,200}
      ^───────^  ^   ^
      start=1   starts because each has no predecessor

2, 3, and 4 are never used as starts.
```

## Reconstruction recipe

1. Insert all input values into a set.
2. For each distinct value, skip it when its predecessor exists.
3. Otherwise count upward while successive integers remain in the set.
4. Keep the largest run length found.

## Worked transition

For `[100,4,200,1,3,2]`, only `1`, `100`, and `200` are starts. The walk from `1` reaches `2,3,4`, producing the maximum length `4`.

Boundary: repeated values such as `[1,1,1]` collapse to one set entry and yield length `1`.

## Recall drill

### What gate makes the nested-looking walk linear overall?

<details>
<summary>Reveal</summary>

Walk only when the predecessor is absent, so exactly one walk owns each maximal sequence.

</details>

### Why does input order not matter?

<details>
<summary>Reveal</summary>

The relation is between numeric neighbors, and the set provides those membership checks independent of array position.

</details>

## Trap and cost

- **Trap:** omitting the predecessor check starts one walk per member and degenerates toward O(n²) on a long run.
- **Time:** O(n) average; building the set and all successor walks together touch each distinct value a constant number of times.
- **Space:** O(n) for the set.
