package ch5.behavioralpatterns.observer;

public interface PhaseSubject {
    void register(PhaseUpdateObserver observer);
    void remove(PhaseUpdateObserver observer);
    void notifyOther();
}
