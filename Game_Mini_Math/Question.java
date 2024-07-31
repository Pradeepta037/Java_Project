import java.util.Random;

// Class representing a math question
class Question {
    private int num1;
    private int num2;
    private char operator;
    private int answer;

    public Question() {
        Random rand = new Random();
        num1 = rand.nextInt(10) + 1; // Numbers between 1 and 10
        num2 = rand.nextInt(10) + 1;
        operator = rand.nextBoolean() ? '+' : '-'; // Randomly choose + or -
        answer = operator == '+' ? num1 + num2 : num1 - num2;
    }

    public void displayQuestion() {
        System.out.println("What is " + num1 + " " + operator + " " + num2 + "?");
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == answer;
    }

    // Method to get the answer
    public int getAnswer() {
        return answer;
    }
}
