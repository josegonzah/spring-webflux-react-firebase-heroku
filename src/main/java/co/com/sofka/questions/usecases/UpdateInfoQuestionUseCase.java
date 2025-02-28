package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UpdateInfoQuestionUseCase implements UpdateQuestion{
    private final QuestionRepository repository;
    private final MapperUtils mapperUtils;


    public UpdateInfoQuestionUseCase(QuestionRepository repository, MapperUtils mapperUtils) {
        this.repository = repository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<QuestionDTO> apply(QuestionDTO questionDTO) {


        return repository.save(mapperUtils.mapperToQuestion(questionDTO.getId()).apply(questionDTO))
                .map(mapperUtils.mapEntityToQuestion());
    }

}
