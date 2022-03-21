# Word-Counter
This project was inspired by Vsauce's "The Zipf Mystery" (https://youtu.be/fCn8zs912OE). This program reads a text file,
counts up every unique word, and prints the results to a seperate page. It's interesting to see Zipf's law in action.
Shorter texts, like the Gettysburg Address, don't seem to work as well. Take a look at Beowulf, War and Peace, or some other text.
I recommend trying a book from Project Gutenburg (https://www.gutenberg.org/), as that's where I got my texts.

One problem is how to define a word. For example, is "Nathan" different from "Nathan's"? Also, I needed to consider letters like
"æ", or words like "hæthcyn" from Beowulf would be split up.
