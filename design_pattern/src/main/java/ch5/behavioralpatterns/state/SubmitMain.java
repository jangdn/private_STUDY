package ch5.behavioralpatterns.state;

import java.math.BigDecimal;
import java.util.Optional;

public class SubmitMain {
    public static void main(String[] args) {
        Summary summaryIncomplete = new Summary(new IncompleteSubmit(), BigDecimal.ONE, "안장우");
        Optional<BigDecimal> scoreOptIncomplete = summaryIncomplete.getScore();
        System.out.println(scoreOptIncomplete);
        System.out.println(summaryIncomplete.getLabel());

        Summary summaryComplete = new Summary(new CompleteSubmit(), BigDecimal.ZERO, "안장우");
        Optional<BigDecimal> scoreOptComplete = summaryComplete.getScore();
        System.out.println(scoreOptComplete);
        System.out.println(summaryComplete.getLabel());
    }
}
