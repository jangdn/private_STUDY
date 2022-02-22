package ch5.behavioralpatterns.observer;

public class PhaseUpdateRetrievalAuthObserver implements PhaseUpdateObserver {
    @Override
    public void create(String name) {
        System.out.println("조회 권한 설정 도메인 생성 완료");
    }
}
