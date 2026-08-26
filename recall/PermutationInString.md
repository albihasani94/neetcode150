# Permutation In String Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/permutation-string/question?list=neetcode150)

## Rebuild chain

Does `s2` contain any permutation of `s1` → permutation means identical counts → candidate substring must have fixed length `|s1|` → slide that exact-size window while updating 26 counts → accept on vector equality.

## Recognition

- **Decisive clue:** permutation changes order but not character multiplicity.
- **Contiguity plus fixed size:** only substrings of length `|s1|` can contain exactly the same multiset.
- **Constraint pressure:** sorting every candidate window repeats work; add one entering character and subtract one leaving character instead.

## State and invariant

- The target vector is the exact frequency of every letter in `s1`.
- Once full, the window vector is the exact frequency of the last `|s1|` characters processed from `s2`.
- Equal vectors are necessary and sufficient for that substring to be a permutation.

```text
s2:       l e c a b e e
window:       [ c a b ]     size = |s1| = 3
step right:     [ a b e ]   add e, remove c
```

## Reconstruction recipe

1. Reject immediately when the pattern is longer than the searched string.
2. Count the pattern's lowercase letters into a fixed vector.
3. Move a right boundary across the searched string, adding each entering character.
4. Once the window would exceed the pattern length, subtract the character that just left.
5. When the window is full, return true if its vector equals the target; otherwise return false after all windows.

## Worked transition

For `s1 = abc`, `s2 = lecabee`, the length-three windows progress through `lec`, `eca`, then `cab`; `cab` has the target counts and returns true.

Boundary: if `|s1| > |s2|`, no full candidate window exists.

## Recall drill

### Why is the window length fixed?

<details>
<summary>Reveal</summary>

A permutation contains exactly the same number of characters as the original string.

</details>

### What two updates move the window in O(1) state-change time?

<details>
<summary>Reveal</summary>

Increment the entering character's count and decrement the character leaving from the opposite boundary.

</details>

## Trap and cost

- **Trap:** forgetting to decrement the exiting character pollutes every later count comparison; also compare only after the window reaches full length.
- **Time:** O(26 · |s2|), which is O(|s2|) because the alphabet is fixed.
- **Space:** O(1) for two 26-slot vectors.
