import java.util.*;

/**
 * The Kana_Quiz class handles the logic for running a Kana quiz game.
 * It generates questions based on the selected mode (hiragana, katakana, or mixed)
 * and evaluates the user's answers.
 */
public class Kana_Quiz {
    private Kana_Data kanaData; // Object to load and manage Kana data.
    private Random random;
    private String mode; // Quiz mode: "hiragana", "katakana", or "mixed".

    /**
     * Constructor initializes the Kana data, random generator, and quiz mode.
     *
     * @param mode The quiz mode: "hiragana", "katakana", or "mixed".
     */
    public Kana_Quiz(String mode) {
        this.kanaData = new Kana_Data();
        this.random = new Random();
        this.mode = mode;
    }

    /**
     * Starts the quiz session, presenting 5 questions to the user.
     * The user is prompted to answer multiple-choice questions, and their score is displayed at the end.
     */
    public void startQuiz() {
        try (Scanner scanner = new Scanner(System.in)){
            List<String[]> words = filterByMode(kanaData.getKanaList()); // Filter words based on the selected mode.
            int score = 0;

            // Loop through 5 questions per session.
            for (int i = 0; i < 5; i++) {
                String[] question = words.get(random.nextInt(words.size()));
                String kana = question[0];
                String correctRomaji = question[1];

                List<String> choices = generateChoices(words, correctRomaji);

                // Display the question and choices to the user.
                System.out.println("\nWhat is the Romaji reading for " + kana + "?");
                for (int j = 0; j < choices.size(); j++) {
                    System.out.println((j + 1) + ". " + choices.get(j));
                }

                // Prompt the user for their answer.
                System.out.print("Your answer (1-4): ");
                int userAnswer = scanner.nextInt();

                // Check if the user's answer is correct and update the score.
                if (choices.get(userAnswer - 1).equals(correctRomaji)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is: " + correctRomaji);
                }
            }
            // Display the user's final score after the quiz ends.
            System.out.println("\nQuiz Over! Your score: " + score + "/5");
        }
    }

    /**
     * Filters the Kana data based on the selected mode.
     *
     * @param words The list of all Kana data entries.
     * @return A filtered list of Kana data entries matching the selected mode.
     *         If the mode is "mixed", all entries are returned.
     */
    private List<String[]> filterByMode(List<String[]> words) {
        if (mode.equals("mixed")) {
            return words;
        }
        List<String[]> filtered = new ArrayList<>();
        for (String[] entry : words) {
            if (entry[2].equals(mode)) {
                filtered.add(entry);
            }
        }
        return filtered;
    }

    /**
     * Generates a list of 4 multiple-choice answers, including the correct answer.
     *
     * @param words The list of all Kana data entries.
     * @param correctRomaji The correct Romaji answer for the current question.
     * @return A shuffled list of 4 multiple-choice answers.
     */
    private List<String> generateChoices(List<String[]> words, String correctRomaji) {
        Set<String> choices = new HashSet<>();
        choices.add(correctRomaji); // Add the correct answer to the choices.

        // Add random incorrect answers until there are 4 choices.
        while (choices.size() < 4) {
            String[] randomWord = words.get(random.nextInt(words.size()));
            choices.add(randomWord[1]); // Add random Romaji
        }

        // Shuffle the choices to randomize their order.
        List<String> shuffledChoices = new ArrayList<>(choices);
        Collections.shuffle(shuffledChoices);
        return shuffledChoices;
    }
}
