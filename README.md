# Brainfuck
Brainfuck is an esoteric programming language created in 1993 by Urban Müller.

Notable for its extreme minimalism, the language consists of only eight simple commands, a data pointer and an instruction pointer. While it is fully Turing complete, it is not intended for practical use, but to challenge and amuse programmers. Brainfuck simply requires one to break commands into microscopic steps.

The language's name is a reference to the slang term brainfuck, which refers to things so complicated or unusual that they exceed the limits of one's understanding.

* `>` = Increment the data pointer
* `<` = Decrement the data pointer
* `+` = Increment (increase by one) the byte at the data pointer
* `-` = Decrement (decrease by one) the byte at the data pointer
* `.` = Output the byte at the data pointer
* `,` = Accept one byte of input, storing its value in the byte at the data pointer
* `[` = If the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching `]` command
* `]` = If the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching `[` command

![image](https://user-images.githubusercontent.com/58489322/145904609-d8eb8bfc-0f80-4862-8464-3a25bfe0bc3b.png)
