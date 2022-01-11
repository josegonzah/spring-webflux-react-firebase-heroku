package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteUseCaseTest {
    @MockBean
    private AnswerRepository answerRepository;
    @MockBean
    private QuestionRepository questionRepository;

    @SpyBean
    DeleteUseCase deleteUseCase;

    @Test
    @DisplayName("Eliminar pregunta por ID")
    void delete(){
        List<String> listParameter = new ArrayList<>();
        listParameter.add("123456");
        var questionDto = new QuestionDTO("123456789qwerty", "123456789", "Primer presidente de estados unidos",
                "OPEN (LONG OPEN BOX)", "SOCIAL SCIENCES","josedavid.sofka@gmail.com", 1, 1, listParameter);

        var answer = new AnswerDTO();
        answer.setQuestionId("123456789qwerty");
        answer.setUserId("123456789");
        answer.setAnswer("George Washington");

        Mockito.when(questionRepository.deleteById("123456789qwerty")).thenReturn(Mono.empty());
        Mockito.when(answerRepository.deleteByQuestionId("123456789qwerty")).thenReturn(Mono.empty());

        var result = deleteUseCase.apply("123456789qwerty").block();

        Assertions.assertEquals(result,null);
    }

}