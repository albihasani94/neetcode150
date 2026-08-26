# Encode and Decode Strings Reconstruction Card

[NeetCode problem](https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150)

## Rebuild chain

Lossless round trip + payload may contain any character → no delimiter is intrinsically safe → frame each payload with its length → parse `length#payload` repeatedly → boundaries depend on metadata, not contents.

## Recognition

- **Decisive clue:** arbitrary characters make delimiter-only encodings ambiguous.
- **Required property:** decoding must distinguish an empty list, empty strings, delimiter characters, digits, and adjacent values.
- **Framing idea:** a delimiter separates the numeric header from the payload; the declared length locates the payload's end.

## State and invariant

- Each encoded frame has the form `decimal length`, separator, then exactly that many payload characters.
- The decoder's cursor always points to the first digit of the next complete frame.
- After consuming a frame, one original string has been recovered exactly and the cursor points at the next header.

```text
encoded:  5#Hello0#4#4#hi
          └frame 1┘│ └frame 3┘
                   └ frame 2: empty payload

header tells the decoder how many characters belong to the payload,
so `#` and digits inside a payload have no special meaning.
```

## Reconstruction recipe

1. For every input string, append its character length, a chosen header separator, and the string itself.
2. To decode, find the next separator and parse the digits before it as a length.
3. Start after the separator and take exactly that many characters as one output string.
4. Move the cursor to the character after that payload and repeat until the encoded input ends.

## Worked transition

Encoding `['#', 'hi']` yields `1##2#hi`. Decode header `1#`, consume the next one character (`#`), then decode `2#` and consume `hi`.

Boundary: an empty list encodes to the empty string, while one empty string encodes to `0#`; those states remain distinguishable.

## Recall drill

### Why does escaping a delimiter create extra complexity?

<details>
<summary>Reveal</summary>

The escape character can itself occur and must also be escaped; length framing avoids interpreting payload characters entirely.

</details>

### What is the decoder cursor invariant?

<details>
<summary>Reveal</summary>

Before each iteration it points at a length header; after slicing that payload it points at the next header or the end.

</details>

## Trap and cost

- **Trap:** a bare delimiter fails as soon as an input string contains that delimiter; the length prefix removes the ambiguity.
- **Time:** O(N), where N is total encoded size, for both encoding and decoding.
- **Space:** O(N + number of strings) for the encoded representation or reconstructed output metadata.
