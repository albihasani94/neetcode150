# Trapping Rain Water Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/trapping-rain-water/question?list=neetcode150)

## Rebuild chain

Water at a bar is `min(maxLeft, maxRight) - height` → avoid two auxiliary max arrays → maintain maxima from both ends → whichever maximum is smaller fixes that side's water now → advance that side and accumulate.

## Recognition

- **Decisive relation:** a position's water level is limited by the shorter of its tallest walls on either side.
- **Naive cost:** searching both sides for every position repeats work and becomes O(n²).
- **Space refinement:** prefix/suffix arrays give O(n) time; two pointers preserve the same information needed at the next unresolved endpoints in O(1) space.

## State and invariant

- `leftMax` and `rightMax` are the tallest walls seen from their respective ends.
- If `leftMax ≤ rightMax`, the right side already supplies a wall at least as high as `leftMax`, so the next left position's water is decided by `leftMax` alone.
- Symmetrically, a smaller `rightMax` fixes the next right position.

```text
left processed       unresolved       right processed
      leftMax  →  [ . . . . . ]  ←  rightMax

smaller boundary max decides which side can be finalized next
```

## Reconstruction recipe

1. Place pointers at both ends and initialize each side's running maximum from its endpoint.
2. Compare the two running maxima.
3. Advance the side with the smaller maximum.
4. Update that side's maximum, then add the difference between it and the new bar height.
5. Repeat until the pointers meet.

## Worked transition

In `[4,2,0,3,2,5]`, left maximum `4` is bounded by right maximum `5`, so left-side positions finalize as `2`, `4`, `1`, and `2` units, totaling `9`.

Boundary: a monotonic or flat elevation never has a bar below a confirmed enclosing level, so the accumulated water remains zero.

## Recall drill

### Why can the smaller side be finalized without knowing the interior's future maximum?

<details>
<summary>Reveal</summary>

The opposite side already has a boundary at least as high, so the smaller known maximum is the limiting water level.

</details>

### In what order should a side's state be updated?

<details>
<summary>Reveal</summary>

Advance, update that side's maximum with the new height, then add `maximum - height` so the contribution cannot be negative.

</details>

## Trap and cost

- **Trap:** adding before updating the side maximum can create negative “water” when the new bar is taller.
- **Time:** O(n), because each pointer crosses the array once.
- **Space:** O(1).
