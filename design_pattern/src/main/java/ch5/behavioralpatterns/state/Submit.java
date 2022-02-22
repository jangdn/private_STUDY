package ch5.behavioralpatterns.state;

import java.math.BigDecimal;
import java.util.Optional;

public interface Submit {
    String getLabel();

    Optional<BigDecimal> getScore(BigDecimal score);

}
