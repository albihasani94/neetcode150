# Repository guidance

## Purpose

This is a Java 25 Maven project for working through the [NeetCode 150](https://neetcode.io/roadmap) problems.

The primary way agents should help is by **adding JUnit tests from the upstream NeetCode problems**. Use the NeetCode 150 roadmap, the corresponding NeetCode problem page, and the Java solution in [neetcode-gh/leetcode](https://github.com/neetcode-gh/leetcode) as the source of truth. Consult LeetCode only for supplemental context when it agrees with the NeetCode specification.

## Adding tests

When adding tests for a problem:

1. Look up the problem on NeetCode and in the upstream NeetCode repo (Java solution under `java/` when available).
2. Port the published examples and relevant edge cases into focused JUnit 6 tests under `src/test/java/com/albin/neetcode/`.
3. Name test classes `{ProblemName}Test` and keep one test class per problem.
4. Cover the examples from the problem statement, plus meaningful boundaries (empty input, single element, duplicates, etc.) when they apply.
5. Run the new tests with `mvn -Dtest=ProblemNameTest test` before finishing.

Do not invent unstated requirements. Match the input types, output types, constraints, and ordering rules specified by NeetCode.

## Problem lifecycle

1. Add a compiling solution skeleton. Problems already start as `In progress` in the README.
2. Add focused tests based on the NeetCode specification.
3. Leave the solution implementation for the developer unless they explicitly ask for an implementation, fix, or edit.
4. Default to explaining the algorithm, identifying issues, and offering hints without modifying solution files.
5. Do not add or modify tests unless the user explicitly asks for those changes, or the task is specifically to add tests. Do not change README problem statuses manually.
6. Run the targeted test class with `mvn -Dtest=ProblemNameTest test`.
7. Do not mark a problem as `Solved` manually; the pre-commit hook makes that change after its targeted test class passes during a commit.

The configured `.githooks/pre-commit` hook runs targeted tests for staged problem files, changes passing problems from `In progress` to `Solved`, and stages the README update. The hook is the only mechanism that changes problem statuses; do not update them manually when the hook has not run.

## Solution code

- Solution implementations live under `src/main/java/com/albin/neetcode/`.
- Never modify solution files unless the user explicitly asks for aa fix or edit. When reviewing, implementing or debugging, give findings, explanations, and hints in the chat response only.

## Conventions

- Keep changes scoped to the requested problem.
- Prefer clear, interview-style code that matches existing project style.
- Add the canonical NeetCode 150 question link to each solution class's Javadoc. Leave README problem-status changes to the pre-commit hook.
- After changes, run the smallest relevant test first, then `mvn test` when touching shared setup.
