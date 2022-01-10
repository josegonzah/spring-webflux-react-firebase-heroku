package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
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
class AddAnswerUseCaseTest {
    @SpyBean
    AddAnswerUseCase addAnswerUseCase;

    @MockBean
    GetUseCase getUseCase;

    @MockBean
    AnswerRepository answerRepository;

    @Test
    @DisplayName("Probando agregar una respuesta")
    void addAnswerTest(){
        var questionDto = new QuestionDTO("123456789qwerty", "123456789", "Primer presidente de estados unidos",
                "OPEN (LONG OPEN BOX)", "SOCIAL SCIENCES","josedavid.sofka@gmail.com");
        var answerDto = new AnswerDTO("123456789qwerty", "123456789", "George Washington");
        var answer = new Answer();
        answer.setId("123456789asdf");
        answer.setQuestionId("123456789qwerty");
        answer.setUserId("123456789qwerty");
        answer.setAnswer("George Washington");
        Mockito.when(answerRepository.save(Mockito.any(Answer.class))).thenReturn(Mono.just(answer));
        Mockito.when(getUseCase.apply(Mockito.anyString())).thenReturn(Mono.just(questionDto));
        var reusultDTO = addAnswerUseCase.apply(answerDto);
        var resultQuestionDTO = reusultDTO.block();
        assert resultQuestionDTO != null;
        Assertions.assertEquals(resultQuestionDTO.getId(),questionDto.getId());
        Assertions.assertEquals(resultQuestionDTO.getQuestion(),questionDto.getQuestion());
        Assertions.assertEquals(resultQuestionDTO.getAnswers().get(0).getQuestionId(),answerDto.getQuestionId());
    }

}