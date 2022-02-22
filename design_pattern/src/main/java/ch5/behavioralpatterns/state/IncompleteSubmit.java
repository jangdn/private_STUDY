package ch5.behavioralpatterns.state;

import java.math.BigDecimal;
import java.util.Optional;

public class IncompleteSubmit implements Submit {
    @Override
    public String getLabel() {
        return "제출 미완료";
    }

    @Override
    public Optional<BigDecimal> getScore(BigDecimal score) {
        return Optional.of(score);
    }
}
