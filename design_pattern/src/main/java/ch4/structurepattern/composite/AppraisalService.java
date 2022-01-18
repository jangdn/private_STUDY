package ch4.structurepattern.composite;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppraisalService {

    public void appraisal() {
        // 한 대상자에 대해 이미 평가가 완료된 상태
        AppraisalSet appraisalSet = new AppraisalSet(new ArrayList<>(Arrays.asList(
            new FirstAppraisal("최영진", "일을 잘하나요?", BigDecimal.ZERO),
            new SecondAppraisal("손성현", "일을 잘하나요?", "S"))));

        // 현재 점수
        BigDecimal calculatedScore = appraisalSet.appraisal();
        System.out.println(calculatedScore);
        // 1 단계 완료

        // 새로운 평가 진행
        Appraisal 안장우_평가 = new FirstAppraisal("안장우", "일을 잘하나요?", BigDecimal.TEN);
        System.out.println(안장우_평가.appraisal());
        // 2 단계 완료

        // 한 대상자에 대해 종합 점수를 산출하고 싶음
        ArrayList<Appraisal> appraisals = new ArrayList<Appraisal>();
        appraisals.add(appraisalSet);
        appraisals.add(안장우_평가);
        AppraisalSet newAppraisalSet = new AppraisalSet(appraisals);
        BigDecimal newCalculatedScore = newAppraisalSet.appraisal();
        System.out.println(newCalculatedScore);
        // 종합점수 산출 완료
    }

    // for typeSafety
    // 컴포넌트
    interface Appraisal {
        BigDecimal appraisal();
    }

    // for Uniformity
    // 어떤 장점이 있을까?
    // 컴포넌트
    interface AppraisalForUniformity {
        BigDecimal appraisal();
        void add(Appraisal appraisal);
    }

    // composite
    @AllArgsConstructor
    class AppraisalSet implements Appraisal {
        private List<Appraisal> appraisals;

        @Override
        public BigDecimal appraisal() {
            BigDecimal result = BigDecimal.ZERO;
            for (Appraisal appraisal : appraisals) {
                result.add(appraisal.appraisal());
            }
            return result.divide(BigDecimal.valueOf(this.appraisals.size()));
        }

        public void add(Appraisal appraisal) {
            this.appraisals.add(appraisal);
        }
    }

    // leaf
    @AllArgsConstructor
    class FirstAppraisal implements Appraisal {
        private String assessorName;
        private String question;
        private BigDecimal score;

        @Override
        public BigDecimal appraisal() {
            return score;
        }
    }

    // leaf
    @AllArgsConstructor
    class SecondAppraisal implements Appraisal {
        private String assessorName;
        private String select;
        private String grade;

        @Override
        public BigDecimal appraisal() {
            switch (grade) {
                case "S":
                    return BigDecimal.TEN;
                case "A":
                    return BigDecimal.ONE;
                default:
                    return BigDecimal.ZERO;
            }
        }
    }
}
