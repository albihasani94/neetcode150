# Compression Notes

Five bullets per solved problem, drafted via the `compress` skill. Grouped by
roadmap category; problem order within a category mirrors the README table.
Empty categories are the remaining gaps. Final wording belongs to the developer.

## Arrays & Hashing

### ContainsDuplicate
- **Clue:** "return true if any value appears twice" → a set membership test per element; seen-before is all you need
- **Invariant:** every number already in the set appeared at an earlier index; `add` returning false is exactly the duplicate signal
- **Minimal:** one hash set sized to `nums.length`; loop, try `add`, bail on false
- **Cost:** O(n) time for one pass with O(1) average set ops; O(n) space for the set in the worst case
- **Trap:** sorting instead of hashing — O(n log n) works but loses the linear property this pattern exists to teach

### ValidAnagram
- **Clue:** "rearrange t to form s" → character counts must match exactly; length check first as the free early exit
- **Invariant:** anagrams are equal up to permutation, so any canonical form (sorted string or count vector) must be identical
- **Minimal:** length guard, sort both char arrays, compare; a 26-slot int array is the O(n) alternative
- **Cost:** O(n log n) time from the two sorts (O(n) with counting); O(n) space for the char copies
- **Trap:** skipping the length check and relying on sorted comparison alone — fine for correctness here, but it wastes the cheapest possible rejection

### TwoSum
- **Clue:** unsorted array + "exactly one solution, same element not reused" → trade a second scan for a lookup table
- **Invariant:** when index i is reached, the map holds every earlier value's index, so if the complement exists it is behind us — never re-scan forward
- **Minimal:** one pass; compute `target - num`, check the map first, then store `(num → i)`
- **Cost:** O(n) time, single pass with O(1) average map ops; O(n) space for the map
- **Trap:** inserting into the map before checking the complement — that lets an element pair with itself on targets like `2 * nums[i]`

### GroupAnagrams
- **Clue:** "group the anagrams together" → find a canonical key under which all anagrams collide, then bucket by it
- **Invariant:** all anagrams share the same sorted-character sequence, so sorted-string keys land in the same bucket
- **Minimal:** map from canonical key to list; sort each word's chars for the key, `computeIfAbsent(...).add(word)`; return the map's values
- **Cost:** O(m · n log n) time for m words of length n (sorting each); O(m · n) space for keys plus buckets
- **Trap:** forgetting that keys are strings, not char arrays — using the raw array as a map key compares by identity, silently splitting groups

### TopKFrequentElements
- **Clue:** "k most frequent" → frequency count first, then select top k; heap or sort both fit at this scale
- **Invariant:** after counting, only relative frequency order matters; selecting k largest from n distinct keys needs no full ordering of the input
- **Minimal:** `merge(num, 1, sum)` into a map, then stream the entries, sort by descending count, limit k
- **Cost:** O(n + m log m) time for n elements and m distinct values (a size-m min-heap gives O(n + m log k)); O(m) space for the map
- **Trap:** comparing entries with subtraction (`a - b`) instead of `Integer.compare` — large counts overflow and corrupt the ordering

### EncodeDecodeStrings
- **Clue:** design encode/decode round-trip where strings may contain any character → delimiters alone fail; embed the length
- **Invariant:** decoding reads `length#payload` chunks; the declared length makes the payload boundary independent of its contents, so no escaping is needed
- **Minimal:** encode appends `len + "#" + str`; decode scans digits up to `#`, parses the length, slices exactly that many chars, jumps past them
- **Cost:** O(N) time and space for total encoded length N — each character is touched once per direction
- **Trap:** encoding with a bare delimiter like `,` — any input string containing the delimiter breaks the decode; the length prefix is what removes ambiguity

### ProductExceptSelf
- **Clue:** "product of everything except self, no division, O(n)" → each answer is prefix-product × postfix-product around the slot
- **Invariant:** after pass one, `result[i]` = product of all elements left of i; multiplying in running postfix products from the right completes it without ever dividing
- **Minimal:** output array seeded with 1, forward pass fills prefixes, backward pass multiplies in a rolling postfix scalar
- **Cost:** O(n) time for two passes; O(1) extra space beyond the required output array
- **Trap:** reaching for division and special-casing zeros — messy with multiple zeros; the prefix/postfix decomposition handles zeros naturally

### ValidSudoku
- **Clue:** validate a partially filled board → three independent uniqueness checks per filled cell: row, column, 3×3 box
- **Invariant:** a digit is valid iff it hasn't been seen before in its row, column, or box; seeing it twice anywhere is immediate failure
- **Minimal:** three maps of sets keyed by row index, column index, and `(row/3, col/3)`; skip `.`, check-then-add each digit
- **Cost:** O(1) effectively — fixed 81 cells with constant-size sets (O(n²) generalized to n×n)
- **Trap:** wrong box key like `(i/3)*3 + j/3` vs `(i/3, j/3)` mixing conventions — pick one formula and verify corners map to distinct boxes

### LongestConsecutiveSequence
- **Clue:** longest run of consecutive integers, unsorted input, O(n) required → hash set, not sorting
- **Invariant:** only sequence starts (numbers with no `x-1` present) begin walks; each element belongs to exactly one run, so every walk is over fresh territory
- **Minimal:** load all values into a set; for each start, walk upward via `contains(x+1)` counting length
- **Cost:** O(n) time — the predecessor gate ensures each element is visited at most twice; O(n) space for the set
- **Trap:** dropping the `contains(x-1)` check — then every run is walked once per member and degenerates toward O(n²) on long runs

## Two Pointers

### ValidPalindrome
- **Clue:** palindrome check ignoring non-alphanumerics and case → converge pointers from both ends, skipping junk as you go
- **Invariant:** characters outside `[i, j]` have already matched, so only the current pair can falsify the palindrome
- **Minimal:** `i`/`j` from both ends; inner loops skip non-alphanumeric chars, compare lowercased pair, move inward on match
- **Cost:** O(n) time — each index advances at most n steps total; O(1) space, no filtered copy needed
- **Trap:** skipping characters without re-checking pointer overlap (`i < j` inside the skip loops) — out-of-bounds on inputs like `".!"`

### TwoSumII
- **Clue:** sorted input + two-sum → opposite-end pointers; sortedness lets each comparison discard a whole side
- **Invariant:** the answer pair always lies within `[begin, end]`; a too-large sum proves `end` pairs with nothing, a too-small sum proves the same for `begin`
- **Minimal:** pointers at both ends; move `end--` when sum > target, `begin++` when < target, return 1-based indices on equality
- **Cost:** O(n) time, one converging pass; O(1) space
- **Trap:** returning indices without the `+1` offset for the 1-based contract — the algorithm is right and the answer still fails

### ThreeSum
- **Clue:** all unique triplets summing to zero, no duplicate triplets → sort, fix one element, two-pointer the remainder
- **Invariant:** after sorting, skipping equal adjacent values at every level guarantees each triplet is generated exactly once; `nums[i] > 0` ends the search since three positives cannot sum to zero
- **Minimal:** sort; outer loop picks anchor i (skip duplicates); inner two-pointer sweep moves l/r by sign of the sum, skipping duplicates after each hit
- **Cost:** O(n²) time — O(n log n) sort plus n linear sweeps; O(1) extra space ignoring the output and sort's footprint
- **Trap:** deduping only the outer anchor and not l/r after recording a hit — duplicate triplets leak through whenever the inner values repeat

### ContainerWithMostWater
- **Clue:** maximize area between two lines → widest window first, then sacrifice width only when it can buy height
- **Invariant:** moving the taller wall inward can never help — area stays capped by the shorter wall while shrinking; so moving the shorter side never discards the optimum
- **Minimal:** pointers at both ends; record `width × min(heights)`; advance the shorter side each step
- **Cost:** O(n) time, one converging pass; O(1) space
- **Trap:** advancing both pointers or the taller one — either can throw away the optimal pair since only the shorter wall bounds the area

### TrappingRainWater
- **Clue:** water above each bar = `min(maxLeft, maxRight) − height` → track both maxes from the ends instead of precomputing arrays
- **Invariant:** if `leftMax ≤ rightMax`, the water at the left pointer is decided solely by `leftMax` — some wall at least as tall already exists on the right
- **Minimal:** pointers at both ends with running `leftMax`/`rightMax`; advance the side with the smaller max, add `max − height` there each step
- **Cost:** O(n) time, single pass; O(1) space — no prefix/suffix arrays
- **Trap:** adding negative trapped water when a position exceeds its own-side max — update the max *before* adding, or clamp with `max(0, …)`

## Sliding Window

### BestTimeToBuyAndSellStock
- **Clue:** single buy-then-sell pass for max profit → at each day, best sale pairs it with the cheapest price seen so far
- **Invariant:** `minPrice` is always the minimum of prices before index i, so `prices[i] − minPrice` is the best profit selling exactly on day i; taking the running max covers every pair without comparing all n² of them
- **Minimal:** one loop updating both scalars per step: `min(minPrice, p)`, then `max(maxProfit, p − minPrice)`
- **Cost:** O(n) time, single pass; O(1) space — two scalars
- **Trap:** updating profit using the new minPrice after already overwriting it with today's price — that computes profit of 0; update maxProfit from the *old* minPrice first (or evaluate in an order where the min used predates i)

### LongestSubstringWithoutRepeatingCharacters
- **Clue:** longest substring with all-distinct chars → window whose contents are exactly the current distinct set; shrink only when a duplicate forces it
- **Invariant:** `[left, right]` never contains a repeat; each right-char collision shrinks from the left until that char is evicted
- **Minimal:** hash set of window chars; extend right, while the new char is present remove `s[left]` and advance left, then record `window.size()`
- **Cost:** O(n) time — left and right each move forward at most n times; O(k) space for the set, k = alphabet/window size
- **Trap:** clearing or rebuilding the whole window on any duplicate instead of shrinking just past the previous occurrence — that drops valid longer windows

### LongestRepeatingCharacterReplacement
- **Clue:** longest substring after ≤ k replacements → window is feasible iff `(window length − count of its most frequent char) ≤ k`
- **Invariant:** `maxFrequency` holds the highest single-char count seen in *any* window so far; the validity check uses this historical max, which may be stale but never invalidates an already-recorded answer
- **Minimal:** int[26] counts; extend right, increment `maxFrequency`, shrink left only while `length − maxFrequency > k`, record best length
- **Cost:** O(n) time — the window slides monotonically, left never moves backward; O(1) space for the 26-slot array
- **Trap:** recomputing or decreasing `maxFrequency` on shrink and expecting exact tracking — keeping the stale max is what preserves O(n); recomputing per step makes the shrink loop quadratic-ish and adds nothing to correctness of the final answer

### PermutationInString
- **Clue:** does s2 contain a permutation of s1 → permutation = same character multiset, so slide a fixed-length window and compare counts
- **Invariant:** the window always spans exactly `s1.length()` consecutive chars once full; its count vector equals s1's iff that stretch is a permutation
- **Minimal:** two int[26] arrays — target counts and window counts; add entering char, drop leaving char once past length, compare with `Arrays.equals`
- **Cost:** O(26·n) ≈ O(n) time from the comparison at each position; O(1) space for the two arrays
- **Trap:** forgetting to decrement the char exiting the window (`i − s1.length()`) — every subsequent count comparison is polluted and false positives/negatives follow; also skip the compare until the window is full (`i ≥ s1.length() − 1`)

### Minimum Window Substring
- **Clue:** "smallest substring of s containing all of t" → grow right until valid, shrink left while valid; validity tracked by counters, never re-scans
- **Invariant:** `have` = how many *distinct* needed chars currently meet their required count in the window; window is valid ⟺ `have == needs.size()`
- **Minimal:** frequency map for t; right ptr adds a char and increments `have` the moment its count hits the need; while valid, record best and shrink left
- **Cost:** O(|s| + |t|) — both pointers only move forward; O(|t|) for the two maps
- **Trap:** ticking `have` on total matched characters instead of distinct satisfied ones; with duplicates in t that overcounts and the shrink loop corrupts the answer

## Stack

## Binary Search

## Linked List

## Trees

## Tries

## Heap / Priority Queue

## Backtracking

## Graphs

## Advanced Graphs

## 1-D Dynamic Programming

## 2-D Dynamic Programming

## Greedy

## Intervals

## Math & Geometry

## Bit Manipulation
