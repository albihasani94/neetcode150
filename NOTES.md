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
- **Trap:** reversing the meaning of `Set.add` — true means a new value was inserted; false means the value was already present and a duplicate was found

### ValidAnagram
- **Clue:** "rearrange t to form s" → character counts must match exactly; length check first as the free early exit
- **Invariant:** anagrams are equal up to permutation, so any canonical form (sorted string or count vector) must be identical
- **Minimal:** length guard, sort both char arrays, compare; a 26-slot int array is the O(n) alternative
- **Cost:** O(n log n) time from the two sorts (O(n) with counting); O(n) space for the char copies
- **Trap:** comparing sorted char arrays with `==` or their `.equals` method — both compare array identity; use `Arrays.equals` or convert to strings and compare their contents

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
- **Clue:** "k most frequent" → count first, then select by frequency; sorting works here, while frequencies bounded by input length also allow linear-time buckets
- **Invariant:** the map counts each distinct value exactly once per occurrence; sorting these entries by descending count puts the k most frequent values first without repeatedly counting the input
- **Minimal:** `merge(num, 1, Integer::sum)` into a map; sort entries by descending count, take k, return their keys
- **Cost:** O(n + m log m) time for n elements and m distinct values; O(m) auxiliary space for the map and sorting, plus O(k) output; a size-k min-heap instead gives O(n + m log(k + 1)) time
- **Trap:** sorting by the numbers themselves rather than their counts — for `[9, 1, 1]`, k = 1, the answer is 1, not 9

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
- **Minimal:** three maps of sets keyed by row, column, and box; use `(row/3, col/3)` or `(row/3)*3 + col/3` for the box; skip `.`, check-then-add each digit
- **Cost:** O(1) time and O(1) space — the board has exactly 81 cells, and all row, column, and box sets have fixed bounds
- **Trap:** treating `.` as a digit — repeated empty cells are allowed, so skip them before checking or updating any set

### LongestConsecutiveSequence
- **Clue:** longest run of consecutive integers, unsorted input, O(n) required → hash set, not sorting
- **Invariant:** each distinct number is considered once as a possible start; only numbers with no `x-1` begin walks, so each run is traversed once
- **Minimal:** load all values into a set; iterate that deduplicated set, skip numbers with a predecessor, and walk upward from each start via `contains(x+1)`, tracking the longest run
- **Cost:** O(n) expected time — building the set and visiting each distinct number a constant number of times use average O(1) set operations; O(n) space for the set
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
- **Invariant:** sorted order lets each sum comparison discard an impossible endpoint; unique anchors and skipping repeated left values after a hit prevent duplicate triplets; a positive anchor ends the search
- **Minimal:** sort; pick each distinct anchor i; sweep l/r by the sum's sign; on a hit, record it, move both pointers, then skip duplicate left values
- **Cost:** O(n²) time from n linear sweeps, plus the smaller O(n log n) sorting cost; the sweep uses O(1) auxiliary space, excluding sorting workspace and the output
- **Trap:** skipping duplicate anchors alone can still repeat a triplet, as in `[-2, 0, 0, 2, 2]`; after a hit and moving both pointers, deduplicating either inner pointer suffices

### ContainerWithMostWater
- **Clue:** maximize area between two lines → widest window first, then sacrifice width only when it can buy height
- **Invariant:** after recording the current area, no narrower pair retaining the shorter wall can improve it; discarding that wall preserves every opportunity to beat the best so far
- **Minimal:** pointers at both ends; record `width × min(heights)`; advance the shorter side each step
- **Cost:** O(n) time, one converging pass; O(1) space
- **Trap:** discarding the taller wall when heights differ can lose the optimum; move the shorter side, while equal heights allow moving either side or both

### TrappingRainWater
- **Clue:** water above each bar = `min(maxLeft, maxRight) − height` → track both maxes from the ends instead of precomputing arrays
- **Invariant:** if `leftMax ≤ rightMax`, the water at the left pointer is decided solely by `leftMax` — some wall at least as tall already exists on the right
- **Minimal:** pointers at both ends with running `leftMax`/`rightMax`; advance the side with the smaller max, add `max − height` there each step
- **Cost:** O(n) time, single pass; O(1) space — no prefix/suffix arrays
- **Trap:** adding negative trapped water when a position exceeds its own-side max — update the max *before* adding, or clamp with `max(0, …)`

## Sliding Window

### BestTimeToBuyAndSellStock
- **Clue:** single buy-then-sell pass for max profit → at each day, best sale pairs it with the cheapest price seen so far
- **Invariant:** after updating `minPrice`, it is the minimum through today; today's candidate uses the cheapest earlier buy or yields harmless zero at a new minimum; the running best covers all sale days without testing every pair
- **Minimal:** initialize `minPrice = prices[0]`, `maxProfit = 0`; scan forward, update `minPrice = min(minPrice, p)`, then `maxProfit = max(maxProfit, p - minPrice)`
- **Cost:** O(n) time, single pass; O(1) space — two scalars
- **Trap:** subtracting the global minimum from the global maximum ignores buy-before-sell order — `[2, 1]` permits no profit, even though its maximum minus minimum is 1

### LongestSubstringWithoutRepeatingCharacters
- **Clue:** longest substring with all-distinct chars → window whose contents are exactly the current distinct set; shrink only when a duplicate forces it
- **Invariant:** after shrinking and inserting the right character, the set contains exactly the distinct characters in `[left, right]`; shrinking just past a collision preserves the longest valid window ending there
- **Minimal:** hash set of window chars; for each right character, remove `s[left]` and advance left while that character is already present; then add it and update the best with `window.size()`
- **Cost:** O(n) time — left and right each move forward at most n times; O(k) space for the set, k = alphabet/window size
- **Trap:** clearing or rebuilding the whole window on any duplicate instead of shrinking just past the previous occurrence — that drops valid longer windows

### LongestRepeatingCharacterReplacement
- **Clue:** longest substring after ≤ k replacements → window is feasible iff `(window length − count of its most frequent char) ≤ k`
- **Invariant:** `maxFrequency` is a historical maximum; once stale, it only preserves a length already achieved by a valid window, and a new frequency record is needed for further growth, so the best length remains sound
- **Minimal:** int[26] counts; extend right with `maxFrequency = max(maxFrequency, ++counts[index])`; while `length - maxFrequency > k`, decrement the departing count and advance left; record best length
- **Cost:** O(n) time because both pointers only advance; O(1) space for 26 counts; recomputing the maximum over those 26 counts would also be O(26n) = O(n)
- **Trap:** treating the historical maximum as the current window's true count — a stale value can retain an invalid window, so this method certifies the best length, not every retained substring

### PermutationInString
- **Clue:** does s2 contain a permutation of s1 → permutation = same character multiset, so slide a fixed-length window and compare counts
- **Invariant:** the window always spans exactly `s1.length()` consecutive chars once full; its count vector equals s1's iff that stretch is a permutation
- **Minimal:** two int[26] arrays — target counts and window counts; add the entering char, drop the leaving char once past the target length, and compare with `Arrays.equals` once the window is full
- **Cost:** O(m + 26n) = O(m + n) time for m = s1.length() and n = s2.length(); this Java implementation uses O(m) auxiliary space for `s1.toCharArray()`, plus O(1) for the two count arrays
- **Trap:** forgetting to decrement the exiting char at `i - s1.length()` accumulates counts instead of sliding them — s1 = `"ab"`, s2 = `"cab"` then misses the valid `"ab"` window

### MinimumWindowSubstring
- **Clue:** "smallest substring of s containing all of t" → grow right until valid, shrink left while valid; validity tracked by counters, never re-scans
- **Invariant:** `have` = how many *distinct* needed chars currently meet their required count in the window; window is valid ⟺ `have == needs.size()`
- **Minimal:** count t; track needed chars as right grows, incrementing `have` when a count reaches its requirement; while valid, record the best bounds and remove left, decrementing `have` if a needed count falls below its requirement
- **Cost:** O(|s| + |t|) time because both pointers only advance; O(|t|) auxiliary space for needed-character maps and `t.toCharArray()`, plus O(L) for the returned substring of length L
- **Trap:** mixing counting units — distinct satisfied characters must be compared with `needs.size()`; counting matched occurrences is a valid alternative only when capped by each requirement and compared with `t.length()`

### SlidingWindowMaximum
- **Clue:** maximum of every fixed-size window under linear-time constraints → keep only candidates in a monotonic decreasing deque
- **Invariant:** deque indices stay inside the window and their values decrease front-to-back, so the front is the maximum; an older value no larger than the new one can never win again and is discarded instead of rescanned
- **Minimal:** allocate `n - k + 1` results; for each right index, evict front indices `<= right - k`, pop back values `<= nums[right]`, append right, then emit the front once the window is full
- **Cost:** O(n) time because every index is appended and removed at most once; O(k) auxiliary space for candidate indices, excluding the O(n - k + 1) output array
- **Trap:** the number of windows is `n - k + 1`, not `n / k + 1`; the windows overlap rather than partitioning the array

## Stack

### ValidParentheses
- **Clue:** nested brackets must close in reverse order — the most recent unmatched opener must be handled first, which signals a stack
- **Invariant:** the stack holds the closing brackets still expected, with the next required one on top; each closer is checked once instead of repeatedly removing matched pairs
- **Minimal:** push the matching closer for every opener; for a closer, reject if the stack is empty or its top differs; after the scan, require an empty stack
- **Cost:** O(n) time because each character is pushed or popped once; O(n) space for a string containing only opening brackets
- **Trap:** the in-loop empty check catches an unexpected closer and prevents `pop()` from failing; the final empty check catches openers that were never closed

## Binary Search

### BinarySearch
- **Clue:** a sorted array plus a target lookup — the ordering is what lets each comparison discard half the remaining elements, demanding O(log n)
- **Invariant:** if the target exists, it lies in the closed interval [low, high]; every update discards a half provably incapable of containing it, and an empty interval (low > high) proves absence
- **Minimal:** `while (low <= high)` with `mid = low + (high - low) / 2`; move `low = mid + 1` or `high = mid - 1` on mismatch, `return mid` on match, `return -1` after the loop
- **Cost:** O(log n) time because the interval halves each iteration; O(1) space for three index variables
- **Trap:** the "not found" return belongs after the loop, not inside it — only the exhausted interval proves absence, and a stray early return turns the search into a single midpoint check

## Linked List

### LRUCache
- **Clue:** key-value lookup plus eviction by recent use, with both `get` and `put` required in O(1) average time → combine a hash map with a doubly linked list
- **Invariant:** the map points each key to its one list node, while `left.next` is LRU and `right.prev` is MRU; direct node access and pointer rewiring avoid the naive O(n) search for the oldest entry
- **Minimal:** use two sentinel nodes; on every hit, unlink the node and insert it before `right`; on a new key, insert there too, then remove `left.next` if capacity is exceeded
- **Cost:** O(1) average time per `get` and `put` from one hash lookup plus constant pointer updates; O(capacity) space for the map and linked nodes
- **Trap:** when reusing an existing node in `put`, update its `value` as well as moving it to MRU; moving it alone preserves the stale value

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
