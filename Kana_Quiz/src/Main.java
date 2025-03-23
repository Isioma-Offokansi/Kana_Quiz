import java.util.Scanner;
import java.io.IOException;

/**
 * The Main class serves as the entry point for the Kana Quiz application.
 * It allows the user to select a quiz mode (Hiragana, Katakana, or Mixed)
 * and starts the quiz based on the selected mode.
 */
public class Main {
    /**
     * The main method initializes the application, prompts the user to select a mode,
     * and starts the Kana Quiz.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        // Allow user to select test mode
        System.out.println("Select Mode: (1) Hiragana, (2) Katakana, (3) Mixed");
        try (Scanner scanner = new Scanner(System.in)){
            // Read the user's choice for quiz mode
            int choice = scanner.nextInt();

            // Determine the quiz mode based on the user's input
            String mode = switch (choice) {
                case 1 -> "hiragana";
                case 2 -> "katakana";
                default -> "mixed";
            };

            // Create a new Kana_Quiz instance with the selected mode and start the quiz
            Kana_Quiz quiz = new Kana_Quiz(mode);
            quiz.startQuiz();
        }
    }
}
