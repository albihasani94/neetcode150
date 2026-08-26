# Best Time to Buy and Sell Stock Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/buy-and-sell-crypto/question?list=neetcode150)

## Rebuild chain

One buy followed by one future sell → treat each day as the possible sale → best partner is the cheapest price seen on or before that day → carry minimum price and maximum profit → one pass.

## Recognition

- **Decisive clue:** a single ordered transaction asks for the largest later-minus-earlier difference.
- **Constraint target:** comparing every buy day with every later sell day is O(n²); the best prior buy can be summarized by one scalar.
- **No-trade rule:** initialize best profit to zero so a decreasing series never produces a negative answer.

## State and invariant

- After processing a day, `minimum` is the cheapest price seen in the processed prefix.
- The candidate `today - minimum` is the best profit for a sale today; using today itself as the new minimum merely contributes zero.
- `best` is the maximum candidate across all sale days processed so far.

## Reconstruction recipe

1. Initialize the running minimum from the first price and best profit to zero.
2. Scan later prices as candidate sale days.
3. Update the running minimum to include the current price.
4. Compare the best profit with current price minus that minimum.
5. Return the best profit after the scan.

## Worked transition

For `[10,1,5,6,7,1]`, the minimum drops to `1`; subsequent candidate profits are `4`, `5`, and `6`, so the best becomes `6`. The final `1` changes neither answer nor ordering.

Boundary: `[10,8,7,5,2]` repeatedly lowers the minimum and produces only zero candidates, so skipping the transaction yields `0`.

## Recall drill

### If today is the sale day, what is its optimal buy partner?

<details>
<summary>Reveal</summary>

The minimum price among days seen no later than today; when that minimum is today, the zero candidate cannot improve the result.

</details>

### Why are two scalars enough?

<details>
<summary>Reveal</summary>

Only the cheapest eligible buy affects future sales, and only the largest completed profit affects the final answer.

</details>

## Trap and cost

- **Trap:** be consistent about update order. If the invariant says “strictly earlier minimum,” evaluate profit before overwriting it; if current day is included first, recognize that it only adds a harmless zero candidate.
- **Time:** O(n) from one pass.
- **Space:** O(1).
