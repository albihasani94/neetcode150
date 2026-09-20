# Top K Frequent Elements Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/top-k-elements-in-list/question?list=neetcode150)

## Rebuild chain

Top `k` by frequency + answer unique → count first → order distinct `(value, count)` pairs by descending count → take the first `k` → return their values in any order.

## Recognition

- **Decisive clue:** selection depends on aggregate frequency, so raw values must first be reduced to `(value, count)` pairs.
- **Current selection strategy:** sorting all `m` distinct entries costs O(m log m), acceptable with at most 10,000 input elements. NeetCode recommends O(n), but also accepts this sorting approach.
- **Linear alternative:** because no frequency exceeds `n`, bucket values by frequency and scan from `n` downward; a size-`k` min-heap is another O(n + m log k) option.

## State and invariant

- The frequency map is the exact count of every distinct value.
- After descending sort, each entry's count is at least the count of every entry to its right.
- Therefore the first `k` keys are exactly the `k` most frequent values; uniqueness of the answer removes cutoff ties.

```mermaid
flowchart LR
    Input["1,2,2,3,3,3"] --> Counts["1→1, 2→2, 3→3"]
    Counts --> Sorted["descending: (3,3), (2,2), (1,1)"]
    Sorted --> Pick["take first k: 3, 2"]
```

## Reconstruction recipe

1. Count each value in a hash map.
2. Treat the map entries as `(value, frequency)` pairs.
3. Sort the pairs by descending frequency.
4. Take the first `k` pairs and return their values.

## Worked transition

For `[1,2,2,3,3,3]`, the sorted entries are `(3,3), (2,2), (1,1)`. Taking the first two returns `[3,2]`; output order is permitted to vary.

Boundary: when `k` equals the number of distinct values, taking the sorted prefix collects every map key.

## Recall drill

### What property must separate the selected values from the unselected ones?

<details>
<summary>Reveal</summary>

No unselected value may be more frequent than a selected one. Taking the first k entries after sorting by descending frequency guarantees this.

</details>

### If k is small, how could you reduce selection work without ordering every distinct value?

<details>
<summary>Reveal</summary>

Use a size-k min-heap of counted entries, evicting the least frequent when it grows too large. Selection takes O(m log k) for m distinct values and retains only the best k entries.

</details>

### Rebuild the full algorithm and justify its costs.

<details>
<summary>Reveal</summary>

Count values in a hash map, sort distinct entries by descending frequency, and return the first k keys. The map preserves exact counts; after sorting, no unselected entry outranks a selected one. Counting n inputs and sorting m entries costs O(n + m log m) time and O(m) auxiliary space.

</details>

## Trap and cost

- **Trap:** the recorded comparator concern is a useful general habit: prefer `Integer.compare` to subtraction for arbitrary integers. Here counts lie between 1 and 10,000, so their difference cannot overflow; the essential detail is descending frequency order.
- **Time:** O(n + m log m), where `m` is the number of distinct values; counting is linear and sorting dominates selection.
- **Space:** O(m) for the frequency map and entry ordering, apart from the returned array.
