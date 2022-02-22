package ch5.behavioralpatterns.observer;

public class PhaseUpdateSubmitObserver implements PhaseUpdateObserver {
    @Override
    public void create(String name) {
        System.out.println("단계 제출 도메인 생성");
    }
}
