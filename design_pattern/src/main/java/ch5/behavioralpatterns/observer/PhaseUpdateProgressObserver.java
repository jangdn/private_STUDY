package ch5.behavioralpatterns.observer;

public class PhaseUpdateProgressObserver implements PhaseUpdateObserver {
    @Override
    public void create(String name) {
        System.out.println("단계 진행 여부 도메인 생성");
    }
}
