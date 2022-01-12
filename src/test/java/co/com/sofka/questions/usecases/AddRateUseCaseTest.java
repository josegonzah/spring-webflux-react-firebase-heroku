package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.model.Rate;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AddRateUseCaseTest {
    @MockBean
    QuestionRepository repository;

    @Mock
    UpdateInfoQuestionUseCase updateInfoQuestionUseCase;

    @SpyBean
    AddRateUseCase addRateUseCase;

    @Test
    @DisplayName("Add rating of a question")
    void setAddReviewTest(){
        List<String> listParameter = new ArrayList<>();
        listParameter.add("123456");
        var questionDTO = new QuestionDTO("123456789qwerty", "123456789", "Primer presidente de estados unidos",
                "OPEN (LONG OPEN BOX)", "SOCIAL SCIENCES","josedavid.sofka@gmail.com", 1, 1, listParameter);

        var question = new Question();
        question.setId("123456789qwerty");
        question.setUserId("123456789");
        question.setQuestion("Que es un Primer presidente de estados unidos");
        question.setType("OPEN (LONG OPEN BOX)");
        question.setCategory("SOCIAL SCIENCES");
        question.setUserEmail("josedavid.sofka@gmail.com");
        question.setNumberOfRates(1);
        question.setSumOfRates(1);
        question.setRates(listParameter);
        Mockito.when(repository.findById(Mockito.any(String.class))).thenReturn(Mono.just(question));
        Mockito.when(updateInfoQuestionUseCase.apply(questionDTO)).thenReturn(Mono.just(questionDTO));
        Mockito.when(repository.save(Mockito.any(Question.class))).thenReturn(Mono.just(question));

        var rate = new Rate();
        rate.setUserId("123456789");
        rate.setScore("3");
        rate.setQuestionId("123456789qwerty");

        var resultQuestionDTO = addRateUseCase.addRate(rate);
        System.out.println(resultQuestionDTO);
        assert resultQuestionDTO != null;
        Assertions.assertEquals(resultQuestionDTO.block().getId(), question.getId());
        Assertions.assertEquals(resultQuestionDTO.block().getCategory(), question.getCategory());
        Assertions.assertEquals(resultQuestionDTO.block().getQuestion(), question.getQuestion());
    }
}
