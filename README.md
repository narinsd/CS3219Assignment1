KWIC
====

### Introduction
**KWIC** (Key Word In Context) index system provides a search mechanism for information in a long list of lines, such as movie titles. Given a list of titles and a list of ``words to ignore'', you are to write a program that generates a KWIC (Key Word In Context) index of the titles. In a KWIC-index, a title is listed once for each keyword that occurs in the title. The keyword cannot be in "words to ignore" and the KWIC-index is alphabetized by keyword.

For each input title, it shall be “circularly shifted” exhaustively by removing the first word and appending it at the end of the line to create a set of circularly shifted lines. The first word (not including "words to ignore") will be the keyword. The system shall output on the screen a listing of the circularly shifted lines for all input titles in ascending alphabetical order. Display the keyword in upper case and the rest in lower case.
For example, if the “words to ignore” are is, the, of, and, as, a, after and the titles are The Day after Tomorrow, Fast and Furious, Man of Steel, the output should be as below.

- **Day** after Tomorrow the
- **Fast** and Furious
- **Furious** Fast and
- **Man** of Steel
- **Steel** Man of
- **Tomorrow** the Day After

### Implementation
We use two different architectures. One is Pipe&Filter Architecture, the other one is Shared Repository Architecture.

### Authors
Narinderpal Singh Dhillon & Wang Zhipeng

### Version
1.0


