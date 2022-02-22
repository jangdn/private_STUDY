package ch5.behavioralpatterns.state;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
public class Summary {
    private Submit submit;
    private BigDecimal score;
    private String recipient;

    public Optional<BigDecimal> getScore() {
        return this.submit.getScore(this.score);
    }

    public String getLabel() {
        return this.submit.getLabel();
    }
}
