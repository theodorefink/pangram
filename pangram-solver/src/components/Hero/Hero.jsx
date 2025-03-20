import React, { useState, useRef, useEffect } from "react";
import styles from './Hero.module.css';

export const Hero = () => {
  const [letters, setLetters] = useState(Array(7).fill('')); // 7 letter inputs
  const [validWords, setValidWords] = useState([]); // Store valid words
  const [wordList, setWordList] = useState([]); // Store all words from words.txt
  const inputRefs = useRef([]); // Refs for input boxes

  useEffect(() => {
    fetch("/words.txt")
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.text();
      })
      .then(data => {
        const words = data.split("\n").map(word => word.trim()); // Convert to array
        console.log("Loaded words:", words);
        setWordList(words);
      })
      .catch(error => console.error("Error loading word list:", error));
  }, []);

  const handleInputChange = (index, value) => {
    const newLetters = [...letters];
    newLetters[index] = value.toUpperCase();
    setLetters(newLetters);

    if (value && index < letters.length - 1) {
      inputRefs.current[index + 1].focus();
    }
  };

  const handleSolve = () => {
    console.log("Entered letters:", letters);

    const requiredLetter = letters[0]; // Assuming first letter is mandatory
    const otherLetters = letters.slice(1).join("");

    const filteredWords = wordList.filter(word =>
      word.length > 3 && word.includes(requiredLetter) && [...word].every(char => letters.includes(char))
    );

    setValidWords(filteredWords);
    console.log("Valid words:", filteredWords);
  };

  const handlePangram = () => {
    console.log("Entered letters:", letters);

    const requiredLetter = letters[0];
    const filteredWords = wordList.filter(word =>
      word.includes(requiredLetter) && new Set([...word]).size === 7
    );

    setValidWords(filteredWords);
    console.log("Pangram words:", filteredWords);
  };

  const handleReset = () => {
    setLetters(Array(7).fill(''));
    inputRefs.current[0].focus();
    setValidWords([]);
  };

  return (
    <section className={styles.hero}>
      <div className={styles.title}>
        <h1>Welcome to Spelling Bee Solver!</h1>
        <p>Enter 7 letters below, ensuring that the mandatory letter is in the yellow tile.</p>
      </div>

      <div className={styles.inputContainer}>
        {letters.map((letter, index) => (
          <input
            key={index}
            type="text"
            value={letter}
            onChange={(e) => handleInputChange(index, e.target.value)}
            maxLength={1}
            ref={(el) => (inputRefs.current[index] = el)}
            className={styles.inputBox}
          />
        ))}
      </div>

      <button onClick={handleSolve} className={styles.solveButton}>
        Solve
      </button>

      <button onClick={handlePangram} className={styles.pangramButton}>
        Pangram
      </button>

      <button onClick={handleReset} className={styles.resetButton}>
        Reset
      </button>

      {/* Display valid words */}
      <div className={styles.results}>
        <h2>Valid Words</h2>
        <ul>
          {validWords.map((word, index) => (
            <li key={index}>{word}</li>
          ))}
        </ul>
      </div>
    </section>
  );
};
