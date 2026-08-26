# Valid Palindrome Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/is-palindrome/question?list=neetcode150)

## Rebuild chain

Palindrome ignoring case and non-alphanumerics → compare the filtered sequence symmetrically → two pointers skip irrelevant characters in place → every accepted pair shrinks the unresolved interval.

## Recognition

- **Decisive clue:** a palindrome is defined by mirrored pairs, so opposite-end pointers match the structure directly.
- **Space choice:** constructing a filtered lowercase copy works, but skipping in place preserves O(1) auxiliary space.
- **Allowed characters:** letters and digits participate; all others are ignored.

## State and invariant

- Everything outside the closed interval `[left, right]` has already been ignored or matched correctly.
- After both pointers land on alphanumeric characters, unequal lowercase forms disprove the palindrome.
- If the pointers meet or cross, every required pair matched.

## Reconstruction recipe

1. Place one pointer at each end of the string.
2. While they have not crossed, advance the left pointer past non-alphanumerics and retreat the right pointer past them.
3. Compare the two relevant characters case-insensitively; reject on mismatch.
4. Move both inward after a match; accept when the interval is exhausted.

## Worked transition

For `Was it a car or a cat I saw?`, the first relevant pair is `W/w`; spaces and `?` are skipped as pointers converge, leaving all mirrored alphanumeric pairs equal.

Boundary: a string containing only punctuation is valid because its filtered sequence is empty.

## Recall drill

### What does the unresolved interval contain?

<details>
<summary>Reveal</summary>

Only characters not yet classified as irrelevant or proven to match their mirror.

</details>

### Why must skip loops check pointer overlap?

<details>
<summary>Reveal</summary>

One pointer can consume the remaining interval when it contains only ignored characters; continuing past the other pointer risks invalid access.

</details>

## Trap and cost

- **Trap:** skipping punctuation without rechecking `left < right` can run beyond the valid interval on inputs made entirely of ignored characters.
- **Time:** O(n), because each pointer moves only inward.
- **Space:** O(1).
