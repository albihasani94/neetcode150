---
name: reconstruct-algorithm
description: Create a visual reconstruction card for a solved algorithm problem, or run a progressive recall drill from an existing card. Use when the developer wants to derive an algorithm again from clues, constraints, invariants, state diagrams, and operation flows rather than memorize solution code.
---

# reconstruct-algorithm

Make a solved algorithm reproducible from its reasoning. Keep `$compress` as the short recall index; this skill owns the richer visual artifact under `recall/` and must not edit `NOTES.md`.

## Select the mode

- **Card mode:** default when the developer asks to create, capture, draw, or reconstruct a solved problem. Create `recall/{ProblemName}.md`.
- **Drill mode:** use only when the developer explicitly asks for a drill, quiz, practice, or progressive hints. Teach interactively in chat and do not edit files.

Infer the target problem from the conversation. Ask only when it is ambiguous.

## Source material

Read the solution and focused test under `src/main/java/com/albin/neetcode/` and `src/test/java/com/albin/neetcode/`. Use the canonical problem specification for constraints or semantics that are not evident locally. If `NOTES.md` already contains a compressed entry, use its recognition clue and especially the developer's recorded trap without changing that entry.

## Card mode

Before writing, check whether `recall/{ProblemName}.md` exists. Do not overwrite or revise an existing card unless the developer asks.

Build the card in the following reasoning order:

1. **Rebuild chain:** one line connecting problem clues to required complexity, operations, data structures, invariant, and pseudocode.
2. **Recognition:** identify the decisive wording and constraints, the complexity they require, and why the plausible naive approach cannot meet them.
3. **State and invariant:** name what each data structure or variable represents and state the property that remains true after every operation.
4. **Structure drawing:** use one compact Mermaid diagram for relationships, ownership, ordering, boundaries, or pointer structure. Use an ASCII diagram only when it communicates the state more clearly.
5. **Operation flow:** use a Mermaid flowchart or state diagram to show meaningful branches and state transitions. Omit it when the algorithm has no meaningful branching or transition sequence.
6. **Reconstruction recipe:** derive minimal language-neutral steps from the invariant. Do not copy or transliterate the Java implementation.
7. **Worked transition:** trace one representative example and one boundary only when the boundary changes or clarifies behavior.
8. **Recall drill:** add a short set of prompts that can rebuild the algorithm without exposing the answer in the question. Put answers inside Markdown `<details>` blocks.
9. **Trap and cost:** preserve the developer's actual stumble when known; state time and space complexity and what creates each cost.

Use only diagrams that materially help reconstruct the algorithm. Label semantic roles such as `LRU`, `MRU`, `window start`, or `visited`, not incidental variable names alone. A reader should be able to cover the recipe and derive it by following recognition → invariant → transitions.

Keep the artifact concise enough to review in a few minutes. Do not change solution files, tests, `README.md`, or `NOTES.md`. Final wording belongs to the developer.

## Drill mode

Use `recall/{ProblemName}.md` when available. Otherwise read the local solution and test privately to establish the expected reasoning.

Do not reveal the complete algorithm at the start. Ask one reconstruction prompt at a time and wait for the developer's answer. Progress in this order:

1. What constraint rules out the naive approach?
2. Which operations must be efficient?
3. Which data structure supports each operation?
4. What invariant connects those structures?
5. What state changes on each operation?
6. Which boundary or trap is easiest to miss?
7. Can the developer now state minimal pseudocode and complexity?

When an answer is incomplete, give the smallest useful hint at the current level before advancing. At the end, summarize only the gaps that mattered and ask the developer to restate the reconstruction in their own words. Do not write their final wording for them.
