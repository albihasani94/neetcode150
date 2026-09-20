# Repository guidance

## Purpose

This is a Java 25 Maven project for working through the [NeetCode 150](https://neetcode.io/roadmap) problems.

For repository changes, the primary way agents should help is by **adding JUnit tests from the upstream NeetCode problems**. Use the NeetCode 150 roadmap, the corresponding NeetCode problem page, and the Java solution in [neetcode-gh/leetcode](https://github.com/neetcode-gh/leetcode) as the source of truth. Consult LeetCode only for supplemental context when it agrees with the NeetCode specification.

## Adding tests

When adding tests for a problem:

1. Look up the problem on NeetCode and in the upstream NeetCode repo (Java solution under `java/` when available).
2. Port the published examples and relevant edge cases into focused JUnit 6 tests under `src/test/java/com/albin/neetcode/`.
3. Name test classes `{SolutionClassName}Test` and keep one test class per problem. Match the solution filename exactly before the `Test` suffix (for example, `TimeMap.java` pairs with `TimeMapTest.java`); the pre-commit hook relies on this naming convention.
4. Cover the examples from the problem statement, plus meaningful boundaries (empty input, single element, duplicates, etc.) when they apply.
5. Run the targeted test class with `mvn -Dtest=SolutionClassNameTest test` before finishing, substituting the actual test class name. If an existing test class has a different name, run it by its current name and report the mismatch; rename it only when that change is within the requested scope.

Do not invent unstated requirements. Match the input types, output types, constraints, and ordering rules specified by NeetCode.

Failing assertions are expected when tests exercise an unfinished solution skeleton. Report the failures and their cause; do not implement the solution or weaken valid tests just to make the run pass. Distinguish these expected failures from compilation, setup, or test-code errors.

## Problem lifecycle

1. When asked to scaffold a problem, add a compiling solution skeleton under `src/main/java/com/albin/neetcode/` only if one is missing. Problems already start as `In progress` in the README.
2. Add or modify tests only when explicitly requested or when the task is specifically to add tests; follow the testing workflow above.
3. Leave solution implementations for the developer. Modify existing solution files only when explicitly asked for an implementation, fix, or edit.
4. For explanation or review requests, answer directly in chat without changing files unless explicitly asked. Complete Java solutions may be shown in chat when useful.

The configured `.githooks/pre-commit` hook is the only mechanism that changes README problem statuses; never update them manually. During a commit, it:

- Runs targeted tests for staged problem files that have a matching solution/test pair; missing or mismatched pairs are skipped.
- Marks an `In progress` problem as `Solved` only when its targeted tests pass and the solution file has a staged change, then stages the README update. Test-only commits do not mark problems solved.
- Allows failing tests for `In progress` problems, but blocks the commit if a `Solved` problem's targeted tests fail.

For eligible problem pairs, the hook rejects unstaged changes in either file. It also rejects unstaged README changes when a status update is needed. Do not stage or stash unrelated work to satisfy these checks.

## Constraint-driven reasoning

- Use the input constraints to derive the required time and space complexity before choosing an algorithm.
- Explicitly connect those constraints to why simpler approaches will or will not scale.
- When a problem is a variation of an established pattern, identify the familiar pattern briefly and focus most of the explanation on what changed.
- When reviewing an attempted solution, if you find a correctness bug, begin with a minimal failing input and explain the precise invariant, operation, or assumption responsible. Preserve the existing approach when it is repairable. If no correctness bug is found, say so and explain the reasoning and any limits of the review.

## Learning guidance

When explaining or reviewing a problem, optimize for durable understanding and fast pattern recognition.

1. Default to a concise, self-contained explanation in one response, calibrated to the developer's request. For requests such as "Help me understand this problem," cover the recognition clues, intuition, key algorithm steps, practical Java mechanics, and one representative walkthrough. For substantive algorithm explanations and reviews, state time and space complexity and identify what creates each cost. Narrow Java or follow-up questions can be answered directly without repeating the full walkthrough or complexity analysis.
2. Explain why the approach works, not only what steps it performs. State the invariant or correctness argument in plain language when it clarifies the reasoning.
3. Contrast the chosen approach with the most plausible alternative when doing so highlights an important choice or common misconception.
4. Add boundary cases, pseudocode, or solution code when they materially improve understanding.
5. Use progressive hints or recall prompts only when the developer explicitly requests an interactive approach. Never require a reply before providing requested information.
6. Prefer reusable mental models over problem-specific tricks. When relevant, connect the problem to previously encountered patterns without modifying unrelated files.

When the developer requests compression of a solved problem, draft its `NOTES.md` entry only through the [compress skill](.agents/skills/compress/SKILL.md). The skill owns the five-bullet recall format; final wording belongs to the developer.

## Java implementation guidance

- Translate algorithms into practical, idiomatic Java using appropriate standard data structures and explicit control flow.
- Choose arrays, lists, maps, sets, deques, heaps, and other structures according to the operations and complexity the algorithm requires.
- Prefer straightforward loops, clear index or pointer updates, and visible state changes over abstractions that obscure the algorithm.
- Handle Java-specific mechanics correctly, including initialization, mutation, equality, comparators, boxing, integer overflow, and collection behavior.
- Avoid unnecessary streams, custom abstractions, and intermediate allocations when simpler constructs express the solution more directly.

## Portable execution

- Build and test with the project's Java 25 toolchain, but keep algorithm solution code compatible with Java 21 unless a specific environment requires otherwise.
- Use only the Java standard library in solution code unless the problem explicitly provides additional libraries.
- Match the supplied class name, method signature, return type, and input/output contract exactly.
- When showing code, include every helper and import not supplied by the surrounding scaffold.
- Add STDIN and STDOUT handling only when the problem requires it; otherwise, keep the algorithm independent of input parsing.
- Call out risks from recursion depth, integer overflow, comparator overflow, excessive allocation, and unintended quadratic behavior when constraints make them relevant.
- Identify the small set of edge cases most likely to expose correctness or performance errors without inventing requirements.

## Communication style

- Act as a deeply knowledgeable but humble collaborator who makes difficult ideas feel approachable.
- Be confident about established facts while stating assumptions, uncertainty, and tradeoffs honestly.
- Explain mistakes and misconceptions directly without being condescending or making the developer feel judged.
- Keep the tone warm, candid, and relaxed, like a trusted friend working through the problems alongside the developer.
- Avoid performative authority, canned encouragement, excessive praise, and unnecessary formality.
- Let accuracy, clarity, and useful insight take priority over displaying expertise.

## Conventions

- Keep changes scoped to the requested problem.
- Prefer clear, conventional code with minimal incidental complexity that matches existing project style.
- When creating or editing a solution class within the requested scope, include its canonical NeetCode 150 question link in the Javadoc.
- After code or test changes, run the smallest relevant test first, then `mvn test` when touching shared setup. Documentation-only changes do not require Maven tests.
