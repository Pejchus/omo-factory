package cvut.fel.omo.factory.events;

public abstract class Observer {
    protected EventCreator subject;
    public abstract void update();
}
