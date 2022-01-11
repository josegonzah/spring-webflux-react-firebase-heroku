package co.com.sofka.questions.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class Question {
    @Id
    private String id;
    private String userId;
    private String question;
    private String type;
    private String category;
    private String userEmail;
    private Integer numberOfRates = 0;
    private Integer sumOfRates = 0;
    private List<String> rates = new ArrayList<>();

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

    public String getUserEmail() {
        return userEmail;
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

    public void setUserEmail(String userEmail) { this.userEmail = userEmail;}
}
