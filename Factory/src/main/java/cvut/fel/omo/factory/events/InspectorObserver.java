package cvut.fel.omo.factory.events;

public class InspectorObserver extends Observer {
    private EventCreator subject;

    public InspectorObserver(EventCreator subject){
        this.subject = subject;
    }
    @Override
    public void update() {

    }
}
