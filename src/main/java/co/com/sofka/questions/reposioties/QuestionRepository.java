package co.com.sofka.questions.reposioties;

import co.com.sofka.questions.collections.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question, String> {
    //La operacion aca es encontrar una pregunta por usuario, segun esto cualquier pregu7nta estara asociada
    //a un usuario pero un usuario púede tener varias preguntas asociadas ya que es un flux
    Flux<Question> findByUserId(String userId);
}
