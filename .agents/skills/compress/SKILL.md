---
name: compress
description: Distill a solved problem into a five-bullet recall entry in the repo's NOTES.md. Use when the user types /compress or asks to "compress" a solved problem.
---

# compress

Turn one solved problem into its durable recall form in `NOTES.md` at the repo root.

## Procedure

1. Read the problem's solution file under `src/main/java/com/albin/neetcode/`. Skim its test file if edge cases matter.
2. Draft exactly five bullets:
   - **Clue:** the signal in the problem statement that selects the pattern.
   - **Invariant:** the property kept true each step; the sentence explaining why this approach beats the naive one.
   - **Minimal:** the fewest moving parts that implement the pattern.
   - **Cost:** time and space, naming what creates each.
   - **Trap:** the easiest mistake — the user's real stumble if known, otherwise the canonical one for the pattern.
3. In `NOTES.md`, find the `##` heading matching the solution Javadoc's `Category: …` line and insert the `### ProblemName` entry, ordered within the section like the README table.
4. Create missing headings in NeetCode roadmap order; keep all 18 headings even when empty — empty means "unsolved gap."

## Ownership

Draft, then stop. The user owns the final wording, especially Trap. Never rewrite, reorganize, or prune existing entries on your own initiative.
