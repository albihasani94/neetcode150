# Compression Notes

Five bullets per solved problem, drafted via the `compress` skill. Grouped by
roadmap category; problem order within a category mirrors the README table.
Empty categories are the remaining gaps. Final wording belongs to the developer.

## Arrays & Hashing

## Two Pointers

## Sliding Window

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
