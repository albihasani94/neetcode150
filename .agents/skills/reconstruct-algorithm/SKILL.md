---
name: reconstruct-algorithm
description: Create saved visual reconstruction cards for solved algorithm problems when the developer explicitly requests a card, or run an explicitly requested progressive recall drill. Do not use for ordinary algorithm explanations or reviews.
---

# reconstruct-algorithm

Make a solved algorithm reproducible from its reasoning. Keep `$compress` as the short recall index; this skill owns the richer visual artifact under `recall/` and must not edit `NOTES.md`.

## Select the mode and targets

- **Single-card mode:** use when an explicit skill invocation names one problem, or when the developer explicitly asks to create, save, capture, or update one reconstruction card. Create `recall/{ProblemName}.md`.
- **Batch-card mode:** use when an explicit skill invocation names multiple problems or a selector, or when the developer explicitly requests multiple cards. Create one card per resolved problem.
- **Drill mode:** use only when the developer explicitly asks for a drill, quiz, practice, or progressive hints. Teach interactively in chat and do not edit files.

An ordinary request to explain, understand, or review an algorithm does not authorize a reconstruction artifact. Answer that request in chat without editing `recall/`.

Resolve card targets as follows:

- Resolve every target through the `README.md` problem table and use its solution class as `{ProblemName}`. Preserve the requested order.
- Require every target to have status `✓`. For an explicit in-progress target, report that it is not eligible for reconstruction and do not create a card. In a batch, record the target as ineligible and continue. Do not infer solved status from implementation completeness or a passing ad hoc test; the repository's pre-commit hook owns that status.
- For `all solved problems`, read the problem table in `README.md` and select exactly the solution classes whose status is `✓`, preserving table order.
- For `all compressed problems`, read every `###` problem entry in `NOTES.md`, preserving roadmap and section order. Resolve each heading to its solution class and verify its `✓` status through the `README.md` table because a note may use either the display name (`Minimum Window Substring`) or class name (`LRUCache`).
- De-duplicate targets while preserving the first occurrence.

Infer a single target from the conversation when possible. Ask only when the target or selector is genuinely ambiguous.

Examples:

```text
$reconstruct-algorithm LRUCache
$reconstruct-algorithm LRUCache TwoSum GroupAnagrams
$reconstruct-algorithm all solved problems
$reconstruct-algorithm all compressed problems
```

## Source material

Before creating a card, require and read its solution and focused test under `src/main/java/com/albin/neetcode/` and `src/test/java/com/albin/neetcode/`. For a missing input in single-card mode, report it and stop; in batch-card mode, record it and continue. Use the canonical problem specification for constraints or semantics that are not evident locally. If `NOTES.md` already contains a compressed entry, use its recognition clue and especially the developer's recorded trap without changing that entry.

## Card creation

Before writing each card, check whether `recall/{ProblemName}.md` exists. Skip existing cards by default. Revise an existing card only when the developer explicitly asks to refresh or update it, preserving their wording and making targeted changes instead of replacing it wholesale.

Build the card in the following reasoning order:

1. **Rebuild chain:** one line connecting problem clues to required complexity, operations, data structures, invariant, and pseudocode.
2. **Recognition:** identify the decisive wording and constraints, the complexity they require, and why the plausible naive approach cannot meet them.
3. **State and invariant:** name what each data structure or variable represents and state the property that remains true after every operation.
4. **Structure drawing:** when relationships, ownership, ordering, boundaries, or pointer structure are materially easier to understand visually, use one compact Mermaid diagram. Use an ASCII diagram instead when it communicates the state more clearly; omit the drawing when neither adds reconstruction value.
5. **Operation flow:** use a Mermaid flowchart or state diagram to show meaningful branches and state transitions. Omit it when the algorithm has no meaningful branching or transition sequence.
6. **Reconstruction recipe:** derive minimal language-neutral steps from the invariant. Do not copy or transliterate the Java implementation.
7. **Worked transition:** trace one representative example and one boundary only when the boundary changes or clarifies behavior.
8. **Recall drill:** add a short set of prompts that can rebuild the algorithm without exposing the answer in the question. Put answers inside Markdown `<details>` blocks.
9. **Trap and cost:** preserve the developer's actual stumble when known; state time and space complexity and what creates each cost.

Use only diagrams that materially help reconstruct the algorithm. Label semantic roles such as `LRU`, `MRU`, `window start`, or `visited`, not incidental variable names alone. A reader should be able to cover the recipe and derive it by following recognition → invariant → transitions.

Keep the artifact concise enough to review in a few minutes. Do not change solution files, tests, `README.md`, or `NOTES.md`. Final wording belongs to the developer.

## Verify each card

After creating or revising a card:

1. Read the saved artifact back and confirm its path uses the resolved solution class, its problem link matches the `README.md` entry, and its reasoning progresses from recognition through invariant and any meaningful transitions to a language-neutral recipe and cost.
2. Check that every included diagram is necessary, semantically labeled, and syntactically valid. Render Mermaid with an available renderer when practical; otherwise inspect the fence and syntax directly and disclose that it was not rendered.
3. Confirm that the invocation changed only its authorized `recall/{ProblemName}.md` files and did not overwrite unrelated existing work. Treat a failed check as an error for that card and report it rather than claiming successful creation.

## Batch-card mode

Resolve the complete target set before writing. Briefly report the number of selected, eligible, ineligible, already-existing, and missing cards, then process eligible missing cards in the resolved order using the card-creation and verification workflows above.

Treat each problem independently:

- Read that problem's current solution, focused test, compressed note when present, and canonical specification before drafting its card.
- If a target is ineligible, lacks required local source material, or cannot be mapped confidently, record the reason, skip it, and continue with the remaining targets.
- Do not let one failed or ambiguous target discard cards already created for other targets.
- Do not silently refresh an existing card during a batch.

Finish with a summary of cards created, skipped because they already existed, skipped as ineligible, and skipped because of verification errors or missing inputs. A batch invocation authorizes only the reconstruction artifacts; preserve the same prohibition on editing solutions, tests, `README.md`, and `NOTES.md`.

## Drill mode

Resolve each drill target through the `README.md` table and require status `✓`, using the same eligibility rule as card creation. Use `recall/{ProblemName}.md` when available. Otherwise require and read the local solution and test privately to establish the expected reasoning; report a missing input instead of inventing the expected algorithm.

Drill one problem at a time. If the developer supplies multiple drill targets, preserve their order and begin the next problem only after the current drill is complete; never interleave their questions.

Do not reveal the complete algorithm at the start. Ask one reconstruction prompt at a time and wait for the developer's answer. Progress in this order:

1. What constraint rules out the naive approach?
2. Which operations must be efficient?
3. Which data structure supports each operation?
4. What invariant connects those structures?
5. What state changes on each operation?
6. Which boundary or trap is easiest to miss?
7. Can the developer now state minimal pseudocode and complexity?

When an answer is incomplete, give the smallest useful hint at the current level before advancing. At the end, summarize only the gaps that mattered and ask the developer to restate the reconstruction in their own words. Do not write their final wording for them.
