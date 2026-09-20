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
2. While `left < right`, skip non-alphanumerics from each end; check `left < right` before every character access in both skip loops.
3. If the pointers meet, accept; otherwise compare the two relevant characters case-insensitively and reject on mismatch.
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

### What stops the scan safely when the remaining characters are all punctuation?

<details>
<summary>Reveal</summary>

Check `left < right` before every character access in both skip loops. One pointer can consume the remaining interval; when the pointers meet, accept without searching beyond it.

</details>

### Rebuild the full algorithm and justify its costs.

<details>
<summary>Reveal</summary>

Start at both ends. While left < right, skip irrelevant characters with an overlap guard on every access; if the pointers meet, accept. Otherwise compare lowercase forms, reject a mismatch, and move inward. Everything outside the interval is ignored or matched. Monotonic movement gives O(n) time and O(1) space.

</details>

## Trap and cost

- **Trap:** skipping punctuation without rechecking `left < right` can run beyond the valid interval on inputs made entirely of ignored characters.
- **Time:** O(n), because each pointer moves only inward.
- **Space:** O(1).
