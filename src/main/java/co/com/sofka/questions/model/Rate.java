package co.com.sofka.questions.model;

public class Rate {
    private String userId;
    private String score;
    private String questionId;

    public String getUserId() {
        return userId;
    }

    public String getScore() {
        return score;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
