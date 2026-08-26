# Products of Array Except Self Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150)

## Rebuild chain

Every index needs all other factors + O(n) + no division → split “everything else” into left prefix and right suffix → store prefixes in output, multiply a rolling suffix from right → zeros require no special cases.

## Recognition

- **Decisive clues:** “except self,” “without division,” and linear time rule out recomputing each product and dividing a total product.
- **Constraint pressure:** O(n²) repeated multiplication does not scale to 100,000 elements.
- **Decomposition:** `answer[i] = product(left of i) × product(right of i)`.

## State and invariant

- After the forward pass, output slot `i` equals the product strictly to its left.
- During the backward pass, the rolling suffix equals the product strictly to the right of the current slot.
- Multiplying those two states completes that slot without including `nums[i]`.

```text
nums:      [ a | b | c | d ]
answer[c] = (a · b) × (d)
             prefix   suffix
```

## Reconstruction recipe

1. Initialize the output so the first slot has the multiplicative identity `1`.
2. Sweep left to right, deriving each slot from the previous prefix and the previous input value.
3. Start a suffix accumulator at `1`.
4. Sweep right to left: multiply the current output by the suffix, then extend the suffix with the current input value.
5. Return the completed output.

## Worked transition

For `[1,2,4,6]`, forward prefixes are `[1,1,2,8]`. Moving right-to-left with suffixes `1,6,24,48` produces `[48,24,12,8]`.

Boundary: `[0,1,2]` naturally becomes `[2,0,0]`; only the zero slot combines nonzero left and right products.

## Recall drill

### What are the two factors for output index `i`?

<details>
<summary>Reveal</summary>

The product of all elements strictly left of `i` and the product of all elements strictly right of `i`.

</details>

### Why is the output array enough to hold prefix state?

<details>
<summary>Reveal</summary>

Each output slot can temporarily store its left product, then be completed in place by the rolling right product.

</details>

## Trap and cost

- **Trap:** division creates awkward zero cases, especially with multiple zeros; prefix/suffix decomposition handles them uniformly.
- **Time:** O(n) from two linear passes.
- **Space:** O(1) auxiliary space beyond the required output array.
