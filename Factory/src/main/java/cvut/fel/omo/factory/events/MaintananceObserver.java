package cvut.fel.omo.factory.events;



public class MaintananceObserver extends Observer {
    private EventCreator subject;

    public MaintananceObserver(EventCreator subject){
        this.subject = subject;
    }
    @Override
    public void update() {

    }
}