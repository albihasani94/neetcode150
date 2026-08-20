# NeetCode 150

A work-in-progress collection of Java solutions and tests for the [NeetCode 150](https://neetcode.io/roadmap) problem set — a curated list of 150 LeetCode problems.

## Problems

| Category | NeetCode problem | Solution | Status |
| --- | --- | --- | --- |
| Arrays & Hashing | [Contains Duplicate](https://neetcode.io/problems/duplicate-integer/question?list=neetcode150) | [ContainsDuplicate](src/main/java/com/albin/neetcode/ContainsDuplicate.java) | Solved |
| Arrays & Hashing | [Valid Anagram](https://neetcode.io/problems/is-anagram/question?list=neetcode150) | [ValidAnagram](src/main/java/com/albin/neetcode/ValidAnagram.java) | Solved |
| Arrays & Hashing | [Two Sum](https://neetcode.io/problems/two-integer-sum/question?list=neetcode150) | [TwoSum](src/main/java/com/albin/neetcode/TwoSum.java) | Solved |
| Arrays & Hashing | [Group Anagrams](https://neetcode.io/problems/anagram-groups/question?list=neetcode150) | [GroupAnagrams](src/main/java/com/albin/neetcode/GroupAnagrams.java) | Solved |
| Arrays & Hashing | [Top K Frequent Elements](https://neetcode.io/problems/top-k-elements-in-list/question?list=neetcode150) | [TopKFrequentElements](src/main/java/com/albin/neetcode/TopKFrequentElements.java) | Solved |
| Arrays & Hashing | [Encode and Decode Strings](https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150) | [EncodeDecodeStrings](src/main/java/com/albin/neetcode/EncodeDecodeStrings.java) | Solved |
| Arrays & Hashing | [Products of Array Except Self](https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150) | [ProductExceptSelf](src/main/java/com/albin/neetcode/ProductExceptSelf.java) | Solved |
| Arrays & Hashing | [Valid Sudoku](https://neetcode.io/problems/valid-sudoku/question?list=neetcode150) | [ValidSudoku](src/main/java/com/albin/neetcode/ValidSudoku.java) | Solved |
| Arrays & Hashing | [Longest Consecutive Sequence](https://neetcode.io/problems/longest-consecutive-sequence/question?list=neetcode150) | [LongestConsecutiveSequence](src/main/java/com/albin/neetcode/LongestConsecutiveSequence.java) | Solved |
| Two Pointers | [Valid Palindrome](https://neetcode.io/problems/is-palindrome/question?list=neetcode150) | [ValidPalindrome](src/main/java/com/albin/neetcode/ValidPalindrome.java) | Solved |
| Two Pointers | [Two Integer Sum II](https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode150) | [TwoSumII](src/main/java/com/albin/neetcode/TwoSumII.java) | In progress |
| Two Pointers | [3Sum](https://neetcode.io/problems/three-integer-sum/question?list=neetcode150) | [ThreeSum](src/main/java/com/albin/neetcode/ThreeSum.java) | In progress |
| Two Pointers | [Container With Most Water](https://neetcode.io/problems/max-water-container/question?list=neetcode150) | [ContainerWithMostWater](src/main/java/com/albin/neetcode/ContainerWithMostWater.java) | In progress |
| Two Pointers | [Trapping Rain Water](https://neetcode.io/problems/trapping-rain-water/question?list=neetcode150) | [TrappingRainWater](src/main/java/com/albin/neetcode/TrappingRainWater.java) | In progress |
| Sliding Window | [Best Time to Buy and Sell Stock](https://neetcode.io/problems/buy-and-sell-crypto/question?list=neetcode150) | [BestTimeToBuyAndSellStock](src/main/java/com/albin/neetcode/BestTimeToBuyAndSellStock.java) | In progress |

## Setup

Requires Java 25 and Maven.

The full test suite includes tests for in-progress solutions, so it may fail until those implementations are complete.

```sh
mvn test
```

Run a single test class:

```sh
mvn -Dtest=ProblemNameTest test
```

## Project layout

```
src/
├── main/java/com/albin/neetcode/   # solution implementations
└── test/java/com/albin/neetcode/   # JUnit tests
```

## References

- [NeetCode roadmap](https://neetcode.io/roadmap)
- [neetcode-gh/leetcode](https://github.com/neetcode-gh/leetcode) — upstream problem list and reference solutions
