# Container With Most Water Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/max-water-container/question?list=neetcode150)

## Rebuild chain

Maximize `width × shorter height` over all pairs + O(n) target → start at maximum width → the shorter wall is the only endpoint that can be safely discarded → move it inward while tracking the best area.

## Recognition

- **Decisive formula:** area is `(right - left) × min(height[left], height[right])`.
- **Constraint pressure:** 100,000 bars make checking all O(n²) pairs too expensive.
- **Greedy choice:** width always shrinks, so improvement is possible only if the limiting height can increase.

## State and invariant

- The best area seen includes every discarded endpoint's best possible pairing.
- If the left wall is shorter, every later pair that keeps it has smaller width and height capped by that same wall; none can beat the current pair.
- The symmetric argument permits discarding the right wall when it is no taller.

## Reconstruction recipe

1. Put pointers on the two outermost walls and initialize the best area to zero.
2. Compute the current width times the shorter wall.
3. Update the best area.
4. Move only an endpoint whose wall is shortest, then repeat until the pointers meet.

## Worked transition

For `[1,7,2,5,4,7,3,6]`, the outer area is `7×1=7`, so discard height `1`. The new pair uses heights `7` and `6` across width `6`, giving the optimum `36`.

Boundary: with exactly two bars, the initial pair is the only container and is evaluated once.

## Recall drill

### Why is moving the taller wall unjustified?

<details>
<summary>Reveal</summary>

The shorter wall still caps height while width decreases, so keeping the shorter wall cannot improve the current area.

</details>

### What information allows one pair to eliminate an endpoint?

<details>
<summary>Reveal</summary>

The area formula and shrinking width prove that the limiting endpoint has already achieved its maximum possible width.

</details>

## Trap and cost

- **Trap:** advancing both endpoints or the taller endpoint can discard the optimal pair; only a shortest wall is safe to sacrifice.
- **Time:** O(n), because one pointer moves inward per iteration.
- **Space:** O(1).
