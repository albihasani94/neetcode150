# Repository guidance

## Purpose

This is a Java 25 Maven project for working through the [NeetCode 150](https://neetcode.io/roadmap) problems.

The primary way agents should help is by **adding JUnit tests from the upstream NeetCode problems**. Use [neetcode-gh/leetcode](https://github.com/neetcode-gh/leetcode) and the corresponding LeetCode problem pages as the source of truth for examples, edge cases, and expected behavior.

## Adding tests

When adding tests for a problem:

1. Look up the problem in the upstream NeetCode repo (Java solution under `java/` when available) and on LeetCode.
2. Port the published examples and relevant edge cases into focused JUnit 6 tests under `src/test/java/com/albin/neetcode/`.
3. Name test classes `{ProblemName}Test` and keep one test class per problem.
4. Cover the examples from the problem statement, plus meaningful boundaries (empty input, single element, duplicates, etc.) when they apply.
5. Run the new tests with `mvn -Dtest=ProblemNameTest test` before finishing.

Do not invent requirements that are not stated by the problem. Match input types, output types, and ordering rules from the LeetCode specification.

## Solution code

- Solution implementations live under `src/main/java/com/albin/neetcode/`.
- Do not replace the user's solution work unless they explicitly ask for a fix or implementation.
- When reviewing a solution, report findings without editing it unless asked.

## Conventions

- Keep changes scoped to the requested problem.
- Prefer clear, interview-style code that matches existing project style.
- After changes, run the smallest relevant test first, then `mvn test` when touching shared setup.
