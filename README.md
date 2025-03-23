# Kana_Quiz
A command-line application designed to help with practicing and testing their knowledge of Japanese Kana (Hiragana and Katakana).

## Features
- Selectable quiz modes:
  - **Hiragana**: Practice only Hiragana characters.
  - **Katakana**: Practice only Katakana characters.
  - **Mixed**: Practice both Hiragana and Katakana.
- Randomly generated multiple-choice questions.
- Displays the user's score at the end of the quiz.

## Requirements
- Java Development Kit (JDK) 17 or higher.
- A terminal or IDE configured to support Unicode (UTF-8) to properly display Japanese Kana characters.

## Setup Instructions
1. Clone or download the repository to your local machine.
2. Ensure you have JDK 17 or higher installed.
3. Compile the project:
   ```bash
   javac -d bin src/*.java
4. Run the application:
   ```bash
   java -cp bin Main

## Configuring Your Terminal for UTF-8
To ensure proper display of Japanese Kana characters, configure your terminal or IDE to use Unicode (UTF-8).

## Project Structure
- Main.java: Entry point of the application. Handles user input and starts the quiz.
- Kana_Quiz.java: Contains the logic for running the quiz, generating questions, and evaluating answers.
- Kana_Data.java: Loads and manages Kana data from a CSV file.
## Kana Data
- The Kana data is stored in a CSV file located at data/kana_romaji.csv. Each entry in the file contains:
  - Kana character.
  - Romaji (Romanized reading).
  - Type (hiragana or katakana).
