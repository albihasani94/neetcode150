# Minimum Window Substring Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/minimum-window-with-characters/question?list=neetcode150)

## Rebuild chain

Shortest substring covering all target multiplicities + up to 100,000 characters → frequency maps avoid rescanning → expand right until all distinct requirements are satisfied → shrink left while valid → remember the shortest valid bounds.

## Recognition

- **Decisive clues:** “substring” requires contiguity, “shortest” requires contracting valid candidates, and duplicates in the target require counts rather than membership.
- **Constraint pressure:** enumerating or revalidating all substrings is quadratic; two monotonic boundaries make the scan linear.
- **Validity summary:** track how many distinct required characters currently meet their exact required count.

## State and invariant

- `need[c]` is the required multiplicity of each target character.
- `window[c]` counts only relevant characters inside `[left, right]`.
- `have` is the number of distinct target characters whose window count is at least their need; the window is valid exactly when `have == number of needed keys`.
- The saved bounds are the shortest valid window seen before each necessary invalidation.

```mermaid
flowchart TD
    E["extend right; update relevant count"] --> H{"a requirement just became satisfied?"}
    H -->|Yes| I["increment have"]
    H -->|No| V{"have equals required?"}
    I --> V
    V -->|No| E
    V -->|Yes| B["record window if shorter"]
    B --> S["remove left character; advance left"]
    S --> L{"a requirement fell below need?"}
    L -->|Yes| D["decrement have"]
    L -->|No| V
    D --> E
```

## Reconstruction recipe

1. Return empty when the target is empty or longer than the source.
2. Build target frequencies and set `required` to the number of distinct target characters.
3. Expand the right boundary; when a relevant count reaches its need exactly, increase `have`.
4. While all requirements are satisfied, save the window if it is the shortest, then remove the left character and advance left.
5. If removal drops a relevant count below its need, decrease `have` and resume expansion.
6. Return the saved slice, or empty if none was saved.

## Worked transition

For `s = OUZODYXAZV`, `t = XYZ`, expansion first satisfies all three at `OUZODYX`. Shrinking removes irrelevant prefix characters until `ZODYX`; later expansion and contraction finds the shorter valid window `YXAZ`.

Boundary: for target `AAB`, a window with one `A` and one `B` is not valid; `have` counts satisfied distinct requirements, not merely present letters.

## Recall drill

### Why does `required` count distinct target characters rather than target length?

<details>
<summary>Reveal</summary>

Each distinct character contributes one requirement whose multiplicity is stored in `need`; satisfaction is tracked once per requirement.

</details>

### At which exact count transitions does `have` change?

<details>
<summary>Reveal</summary>

Increase when a count reaches its requirement; decrease when removal makes it fall below the requirement.

</details>

## Trap and cost

- **Trap:** incrementing `have` for every matched occurrence overcounts duplicate target characters and corrupts the shrink condition.
- **Time:** O(|s| + |t|), because both source boundaries move only forward and the target is counted once.
- **Space:** O(k), where k is the number of distinct target characters.
