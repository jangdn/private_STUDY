package ch5.behavioralpatterns.observer;

public class PhaseCreateMain {
    public static void main(String[] args) {
        PhaseSubjectImpl phaseSubject = PhaseSubjectImpl.create("1단계");

        PhaseUpdateProgressObserver progressObserver = new PhaseUpdateProgressObserver();
        phaseSubject.register(progressObserver);
        PhaseUpdateRetrievalAuthObserver retrievalAuthObserver = new PhaseUpdateRetrievalAuthObserver();
        phaseSubject.register(retrievalAuthObserver);
        PhaseUpdateSubmitObserver submitObserver = new PhaseUpdateSubmitObserver();
        phaseSubject.register(submitObserver);

        phaseSubject.update("나는 2단계로 변경");

        System.out.println("\n");

        // 설정에 따라 제출 도메인을 제외하게 되었음. (제출 옵션을 끔)
        phaseSubject.remove(submitObserver);

        phaseSubject.update("다시 1단계로 변경");
    }
}
