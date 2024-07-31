import java.util.*;

// Abstract class for different types of quizzes
abstract class Quiz {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Quiz(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public abstract boolean checkAnswer(String answer);

    @Override
    public String toString() {
        return question;
    }
}

// Concrete class for Multiple Choice Quiz
class MultipleChoiceQuiz extends Quiz {
    public MultipleChoiceQuiz(String question, String[] options, String correctAnswer) {
        super(question, options, correctAnswer);
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(super.correctAnswer);
    }
}

// Concrete class for True/False Quiz
class TrueFalseQuiz extends Quiz {
    public TrueFalseQuiz(String question, String correctAnswer) {
        super(question, new String[]{"True", "False"}, correctAnswer);
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(super.correctAnswer);
    }
}

// Class to manage quizzes
class QuizManager {
    private List<Quiz> quizzes = new ArrayList<>();

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        for (Quiz quiz : quizzes) {
            System.out.println(quiz);
            String[] options = quiz.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();

            if (quiz.checkAnswer(answer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("Your final score is: " + score + "/" + quizzes.size());
    }
}

// Class representing a user
class User {
    private String name;
    private QuizManager quizManager;

    public User(String name, QuizManager quizManager) {
        this.name = name;
        this.quizManager = quizManager;
    }

    public void takeQuiz() {
        quizManager.takeQuiz();
    }
}

// Main class to run the application
public class QuizApplication {
    public static void main(String[] args) {
        // Create a QuizManager instance
        QuizManager quizManager = new QuizManager();

        // Add quizzes to the manager
        quizManager.addQuiz(new MultipleChoiceQuiz("What is the capital of France?", new String[]{"Paris", "London", "Berlin"}, "Paris"));
        quizManager.addQuiz(new TrueFalseQuiz("The earth is flat.", "False"));

        // Create a user and start the quiz
        User user = new User("John Doe", quizManager);
        user.takeQuiz();
    }
}
