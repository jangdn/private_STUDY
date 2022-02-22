package ch5.behavioralpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class PhaseSubjectImpl implements PhaseSubject {
    private List<PhaseUpdateObserver> observers = new ArrayList<>();

    private void setName(String name) {
        this.name = name;
    }

    private String name;

    private PhaseSubjectImpl(String name) {
        this.name = name;
    }

    public static PhaseSubjectImpl create(String name) {
        PhaseSubjectImpl phaseSubject = new PhaseSubjectImpl(name);
        return phaseSubject;
    }
    public void update(String name) {
        System.out.println(name + " 단계 변경 완료");
        this.setName(name);
        this.notifyOther();
    }

    @Override
    public void register(PhaseUpdateObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(PhaseUpdateObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyOther() {
        observers.forEach(observer -> observer.create(this.name));
    }
}
