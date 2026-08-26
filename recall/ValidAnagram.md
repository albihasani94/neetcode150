# Valid Anagram Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/is-anagram/question?list=neetcode150)

## Rebuild chain

Same characters, order irrelevant → choose a canonical order → length guard + sort both character sequences → equal canonical forms are exactly the anagram invariant.

## Recognition

- **Decisive clue:** “rearranged” removes order while “exact same characters” preserves multiplicity.
- **Constraint pressure:** sorting handles 50,000-character inputs in O(n log n); the fixed 26-character alphabet also permits an O(n) counting alternative.
- **Fast rejection:** unequal lengths cannot have identical character counts.

## State and invariant

- Sorting erases original positions but preserves every character occurrence.
- Two equal-length strings are anagrams exactly when their sorted character sequences are identical.
- After canonicalization, the first mismatch proves a different character multiplicity.

## Reconstruction recipe

1. Reject strings of different lengths.
2. Copy each string into a sortable character sequence.
3. Sort both sequences into canonical order.
4. Accept exactly when the canonical sequences are equal.

## Worked transition

For `racecar` and `carrace`, both sort to the same character sequence because each contains `a×2, c×2, e×1, r×2`.

Boundary: `aab` versus `abb` has equal length, but the sorted sequences differ, so length alone is insufficient.

## Recall drill

### Which part of the statement says positions do not matter?

<details>
<summary>Reveal</summary>

One string may be rearranged into the other, so only character multiplicities survive.

</details>

### What alternative uses the fixed alphabet?

<details>
<summary>Reveal</summary>

A 26-slot balance vector can add counts from one string and subtract counts from the other, reducing time to O(n) and auxiliary state to O(1).

</details>

## Trap and cost

- **Trap:** skipping the length guard wastes the cheapest rejection and asks the sorter to process strings that cannot possibly match.
- **Time:** O(n log n) for sorting two equal-length character sequences.
- **Space:** O(n) for sortable character copies, plus the sorting implementation's footprint.
