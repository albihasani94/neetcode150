# Two Sum Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/two-integer-sum/question?list=neetcode150)

## Rebuild chain

Unsorted values + one valid pair + distinct indices → O(n²) pair search is avoidable → rearrange to `needed = target - current` → hash value to earlier index → check before storing → return earlier/current indices.

## Recognition

- **Decisive clue:** the additive equation can be solved for the missing partner.
- **Constraint goal:** a lookup table replaces the inner scan, taking the solution from O(n²) to O(n) average time.
- **Ordering rule:** because the map contains only earlier indices, the returned pair is naturally smaller index first.

## State and invariant

- The map stores each value from the processed prefix and an index where it occurred.
- At index `i`, a stored complement proves a valid pair with two distinct positions.
- If no complement is stored, recording the current value makes it available only to later positions.

## Reconstruction recipe

1. Start an empty value-to-index map.
2. For each position, compute the value needed to reach the target.
3. If that needed value is in the map, return its index and the current index.
4. Otherwise record the current value and index, then continue.

## Worked transition

For `[3,4,5,6]`, target `7`: at index 0, need `4`, then store `3 → 0`. At index 1, need `3`; the map supplies index 0, so return `[0,1]`.

Boundary: for `[5,5]`, target `10`, the first `5` is stored before the second is checked, so the two equal values still use distinct indices.

## Recall drill

### What equation creates the lookup key?

<details>
<summary>Reveal</summary>

From `current + partner = target`, derive `partner = target - current`.

</details>

### Why must lookup happen before insertion?

<details>
<summary>Reveal</summary>

Otherwise the current element can find itself when it equals its own complement, violating the distinct-index rule.

</details>

## Trap and cost

- **Trap:** inserting before checking permits self-pairing when `target == 2 × current`.
- **Time:** O(n) average from one pass and average O(1) map operations.
- **Space:** O(n) for previously seen values.
