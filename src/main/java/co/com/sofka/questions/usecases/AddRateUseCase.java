package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.model.Rate;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class AddRateUseCase {
    private final QuestionRepository repository;
    private final MapperUtils mapperUtils;
    private final UpdateInfoQuestionUseCase updateInfoQuestionUseCase;

    public AddRateUseCase(QuestionRepository repository, MapperUtils mapperUtils, UpdateInfoQuestionUseCase updateInfoQuestionUseCase) {
        this.repository = repository;
        this.mapperUtils = mapperUtils;
        this.updateInfoQuestionUseCase = updateInfoQuestionUseCase;
    }

    public Mono<QuestionDTO> addRate(Rate rate){
        return repository.findById(rate.getQuestionId()).flatMap(
                question -> {
                    question.setNumberOfRates(question.getNumberOfRates()+1);
                    question.setSumOfRates(question.getSumOfRates()+Integer.parseInt(rate.getScore()));
                    question.getRates().add(rate.getUserId());
                    question.setRates(question.getRates());
                    return updateInfoQuestionUseCase.apply(mapperUtils.mapEntityToQuestion().apply(question));
                }
        );
    }
}
