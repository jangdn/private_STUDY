package ch5.behavioralpatterns.state;

import java.math.BigDecimal;
import java.util.Optional;

public class DeniedSubmit implements Submit {
    @Override
    public String getLabel() {
        return "제출 거부";
    }

    @Override
    public Optional<BigDecimal> getScore(BigDecimal score) {
        return Optional.of(score);
    }
}
