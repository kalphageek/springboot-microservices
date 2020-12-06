package microservices.book.multiplication.event;

import lombok.*;

import java.io.Serializable;

/**
 * 시스템에서 {@link microservices.book.multiplication.domain.Multiplication} 문제가 해결되었다는 사실을 모델링한 이벤트.
 * 곱셈에 대한 컨텍스트 정보를 제공.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultiplicationSolvedEvent implements Serializable {

  private Long multiplicationResultAttemptId;
  private Long userId;
  private boolean correct;

}
