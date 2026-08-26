# Valid Sudoku Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/valid-sudoku/question?list=neetcode150)

## Rebuild chain

Validate a partially filled 9×9 board → each filled digit belongs to one row, one column, and one 3×3 box → maintain three families of seen sets → duplicate in any family invalidates immediately.

## Recognition

- **Decisive wording:** validity means uniqueness within three overlapping regions; it does not require solving or completing the board.
- **Required operation:** for each filled cell, test membership in its three regions and then record it.
- **Box identity:** integer division maps `(row, col)` to `(row / 3, col / 3)`.

## State and invariant

- `rowSeen[r]` contains exactly the filled digits processed in row `r`.
- `columnSeen[c]` does the same for column `c`.
- `boxSeen[r/3,c/3]` does the same for the cell's 3×3 box.
- Before recording a digit, membership in any one of those sets proves a violated Sudoku rule.

```text
box coordinates

(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)    cell (7,4) → box (2,1)
(2,0) (2,1) (2,2)
```

## Reconstruction recipe

1. Prepare seen sets for every row, column, and 3×3 box.
2. Scan all 81 cells and ignore empty markers.
3. Compute the filled cell's box coordinates.
4. Reject if its digit already appears in the corresponding row, column, or box set.
5. Otherwise add the digit to all three sets; accept after the scan finishes.

## Worked transition

If a `1` is seen at `(0,0)`, it enters row 0, column 0, and box `(0,0)`. A later `1` at `(2,2)` is rejected through the box set even though its row and column are different.

Boundary: a board containing only `.` is valid because no uniqueness rule is violated; solvability is outside the contract.

## Recall drill

### How many ownership regions does a filled cell affect?

<details>
<summary>Reveal</summary>

Exactly three: its row, its column, and its 3×3 box.

</details>

### How is the box key derived without conditionals?

<details>
<summary>Reveal</summary>

Use integer-division coordinates `(row / 3, column / 3)`.

</details>

## Trap and cost

- **Trap:** mixing box-key conventions can merge distinct boxes; choose one formula and verify corner cells map to the expected box coordinates.
- **Time:** O(1) for the fixed 81-cell board; O(n²) for a generalized n×n grid.
- **Space:** O(1) for fixed-size region sets; O(n²) in the generalized form.
