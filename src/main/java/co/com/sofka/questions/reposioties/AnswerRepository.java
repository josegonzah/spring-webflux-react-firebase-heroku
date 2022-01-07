package co.com.sofka.questions.reposioties;

import co.com.sofka.questions.collections.Answer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface AnswerRepository extends ReactiveCrudRepository<Answer, String> {
    //Hay solo dos operaciones en el repository, encontarr las pregunats por Id y borrar una pregunta por el Id, todo tiene sentiudo aca
    Flux<Answer> findAllByQuestionId(String id);

    Mono<Void> deleteByQuestionId(String questionId);
}
