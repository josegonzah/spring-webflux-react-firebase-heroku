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
import java.util.Objects;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpdateUseCaseTest {
    @MockBean
    QuestionRepository questionRepository;

    @SpyBean
    UpdateUseCase updateUseCase;

    @Test
    @DisplayName("Actualizar pregunta use case")
    void UpdateQuestionTest(){
        List<String> listParameter = new ArrayList<>();
        listParameter.add("123456");
        var questionDto = new QuestionDTO("123456789qwerty", "123456789", "Primer presidente de estados unidos",
                "OPEN (LONG OPEN BOX)", "SOCIAL SCIENCES","josedavid.sofka@gmail.com", 1, 1, listParameter);

        var resource = new Question();
        resource.setId("123456789qwerty");
        resource.setUserId("123456789");
        resource.setQuestion("Primer presidente de estados unidos");
        resource.setType("OPEN (LONG OPEN BOX)");
        resource.setUserEmail("josedavid.sofka@gmail.com");
        resource.setRates(listParameter);
        resource.setSumOfRates(1);
        resource.setNumberOfRates(1);

        when(questionRepository.save(Mockito.any(Question.class))).thenReturn(Mono.just(resource));

        var result = updateUseCase.apply(questionDto);

        Assertions.assertEquals(Objects.requireNonNull(result.block()),"123456789qwerty");
    }

}