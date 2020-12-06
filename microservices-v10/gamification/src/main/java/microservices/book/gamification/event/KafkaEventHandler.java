package microservices.book.gamification.event;

import lombok.extern.slf4j.Slf4j;
import microservices.book.gamification.service.GameService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaEventHandler {
    private GameService gameService;

    KafkaEventHandler(final GameService gameService) {
        this.gameService = gameService;
    }

    @KafkaListener(topics = "${message.topic.name}", groupId = "${kafka.groupId}")
    public void eventListener(MultiplicationSolvedEvent event) {
        log.info("Kafka - Multiplication Solved Event 수신: {}", event.getMultiplicationResultAttemptId());
//        try {
//            gameService.newAttemptForUser(event.getUserId(),
//                    event.getMultiplicationResultAttemptId(),
//                    event.isCorrect());
//        } catch (final Exception e) {
//            log.error("MultiplicationSolvedEvent 처리 시 에러", e);
//            // 해당 이벤트가 다시 큐로 들어가거나 두 번 처리되지 않도록 예외 발생
//            throw new AmqpRejectAndDontRequeueException(e);
//        }
    }
}
