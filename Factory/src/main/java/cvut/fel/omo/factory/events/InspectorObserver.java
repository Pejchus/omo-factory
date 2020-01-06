package cvut.fel.omo.factory.events;

public class InspectorObserver extends Observer {
    private EventCreator subject;
    private int tact;

    public InspectorObserver(EventCreator subject){
        this.subject = subject;
    }
    @Override
    public void update() {
        this.tact = subject.getTact();
        //TODO Call ispection

    }
}
