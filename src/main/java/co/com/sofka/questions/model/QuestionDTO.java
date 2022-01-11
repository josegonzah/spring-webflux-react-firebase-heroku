package co.com.sofka.questions.model;


import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class QuestionDTO {

    //¿Por que ninguno de los 2 modelos tienen una etiqueta id?, lo demás es lógico que no esté vacío y que esté asociado aa un usuario
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String question;
    @NotBlank
    private String type;
    @NotBlank
    private String category;
    private List<AnswerDTO> answers; //La reactividad se ve reflejada en los Dtos
    private String userEmail;
    private Integer numberOfRates = 0;
    private Integer sumOfRates = 0;
    private List<String> rates = new ArrayList<>();

    public QuestionDTO(String id, String userId, String question, String type, String category, String userEmail, Integer numberOfRates, Integer sumOfRates, List<String> rates) {

    }

    //Constructores que construyenb una pregunta a pqrtir de un userId asociado
    public QuestionDTO(String userId, String question, String type, String category) {
        this.userId = userId;
        this.question = question;
        this.type = type;
        this.category = category;
    }
    //Construye la pregunta desde 0
    public QuestionDTO(String id, String userId, String question, String type, String category, String userEmail) {
        this.id = id;
        this.userId = userId;
        this.question = question;
        this.type = type;
        this.category = category;
        this.userEmail = userEmail;
    }

    public QuestionDTO(String id, String userId, String question, String type, String category, List<AnswerDTO> answers, String userEmail, Integer numberOfRates, Integer sumOfRates, List<String> rates) {
        this.id = id;
        this.userId = userId;
        this.question = question;
        this.type = type;
        this.category = category;
        this.answers = answers;
        this.userEmail = userEmail;
        this.numberOfRates = numberOfRates;
        this.sumOfRates = sumOfRates;
        this.rates = rates;
    }

    public Integer getNumberOfRates() {
        return numberOfRates;
    }

    public Integer getSumOfRates() {
        return sumOfRates;
    }

    public List<String> getRates() {
        return rates;
    }

    public void setNumberOfRates(Integer numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public void setSumOfRates(Integer sumOfRates) {
        this.sumOfRates = sumOfRates;
    }

    public void setRates(List<String> rates) {
        this.rates = rates;
    }

    //Get con maenjo de errores por si la lista de respuestas es nula
    public List<AnswerDTO> getAnswers() {
        this.answers = Optional.ofNullable(answers).orElse(new ArrayList<>());
        return answers;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(question, that.question) && Objects.equals(type, that.type) && Objects.equals(category, that.category) && Objects.equals(answers, that.answers) && Objects.equals(userEmail, that.userEmail) && Objects.equals(numberOfRates, that.numberOfRates) && Objects.equals(sumOfRates, that.sumOfRates) && Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, question, type, category, answers, userEmail, numberOfRates, sumOfRates, rates);
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", question='" + question + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", answers=" + answers +
                ", userEmail='" + userEmail + '\'' +
                ", numberOfRates=" + numberOfRates +
                ", sumOfRates=" + sumOfRates +
                ", rates=" + rates +
                '}';
    }
}
