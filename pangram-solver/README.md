# Selling Bee Solver

This app works to solve the New York times spelling bee, and was created using Vite + React and deployed using Vercel.

## How it works

The code takes 7 letters as input and then filters out words from a dictionary (words.txt) which don't contain the mandatory letter, and contain letters from outside of the 7 given ones. To find only the pangram it filters out words that don't contain all of the seven letters. Words must be greater than 4 letters long as well. The remaining words are displayed in the Valid Words section.

### Known errors

The dictionary used contains a lot of words that just clearly do not exist, I don't know how they got there but this was the best dictionary I could find. It very rarely however doesn't find the pangram. Also there is no handling for when the user enters a double letter or something.
