# Valid Parentheses Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/validate-parentheses/question?list=neetcode150)

## Rebuild chain

Brackets must close in matching reverse order → last unmatched opener must be resolved first → stack → push the closer each opener requires → each actual closer must equal the top → stack must end empty.

## Recognition

- **Decisive wording:** nesting creates a last-opened, first-closed dependency.
- **Why a stack:** only the most recent unmatched expectation can legally be satisfied next.
- **Useful representation:** storing expected closers makes the closing branch a direct equality check.

## State and invariant

- From bottom to top, the stack contains closers still required by unmatched openers.
- The top is the only valid next closer.
- An empty stack during a close means no opener exists; a nonempty stack after the scan means some opener never closed.

```text
input prefix:  ( [ {
stack top:       } ] )
                 ^ next required closer
```

## Reconstruction recipe

1. Start an empty stack.
2. For an opening bracket, push its matching closing bracket.
3. For a closing bracket, reject if the stack is empty or its top differs; otherwise pop it.
4. After processing all characters, accept only if the stack is empty.

## Worked transition

For `([{}])`, expectations become `)`, then `])`, then `}])`; the closers pop exactly in reverse order until the stack is empty.

Boundary: `(` reaches the end with `)` still expected, while `]` fails immediately because the stack is empty.

## Recall drill

### What does the top of the stack mean?

<details>
<summary>Reveal</summary>

It is the one closing bracket allowed next by the most recent unmatched opener.

</details>

### Why are there two different empty-stack checks?

<details>
<summary>Reveal</summary>

The in-loop check detects an unexpected closer; the final check detects unmatched openers.

</details>

## Trap and cost

- **Trap:** checking only during the scan misses leftover opening brackets; checking only at the end risks popping an empty stack on an early closer.
- **Time:** O(n), with one push or pop per character.
- **Space:** O(n) in the all-openers case.
