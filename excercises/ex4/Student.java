package ap.excercises.ex4;


public class Student {
    private String name;
    private int totalScore;
    private int quizCount;

    public Student(String name) {
        this.name = name;
        this.totalScore = 0;
        this.quizCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addQuiz(int score) {
        totalScore += score;
        quizCount++;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public double getAverageScore() {
        if (quizCount == 0) {
            return 0.0;
        }
        return (double) totalScore / quizCount;
    }
}
