package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GetUseCaseTest {
    @MockBean
    private QuestionRepository repository;
    @SpyBean
    private GetUseCase getQuestion;

    @Test
    @DisplayName("Get pregunta por ID")
    public void get(){

        var questionDTO = new QuestionDTO("123456789qwerty", "123456789", "Primer presidente de estados unidos",
                "OPEN (LONG OPEN BOX)", "SOCIAL SCIENCES","josedavid.sofka@gmail.com");
        var resource = new Question();
        resource.setId("123456789qwerty");
        resource.setUserId("123456789");
        resource.setQuestion("Primer presidente de estados unidos");
        resource.setType("OPEN (LONG OPEN BOX)");
        resource.setUserEmail("josedavid.sofka@gmail.com");

        Mockito.when(repository.findById(Mockito.any(String.class))).thenReturn(Mono.just(resource));

        var respuesta = getQuestion.apply("123456789qwerty");
        Assertions.assertEquals(respuesta.block().getQuestion(), "Primer presidente de estados unidos");
    }

}