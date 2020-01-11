package cvut.fel.omo.factory.events;

public class LineObserver extends Observer {
    private EventCreator subject;

    public LineObserver(EventCreator subject){
        this.subject = subject;
    }
    @Override
    public void update() {

    }

}
