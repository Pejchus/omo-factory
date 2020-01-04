package cvut.fel.omo.factory.events;

import cvut.fel.omo.factory.Main;

public class MaintananceObserver extends Observer {
    private EventCreator subject;

    public MaintananceObserver(EventCreator subject){
        this.subject = subject;
    }
    @Override
    public void update() {

    }
}
