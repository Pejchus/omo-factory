package cvut.fel.omo.factory.events;
import cvut.fel.omo.factory.maintenance.*;

import java.util.HashMap;


public class MaintananceObserver extends Observer {
    private EventCreator subject;
    private HashMap<String,Integer> repairs;

    public MaintananceObserver(EventCreator subject,Maintenance m){
        this.subject = subject;
        subject.setMaintanance(this);
    }
    @Override
    public void update() {
        for(Event e:subject.getEvents()){
            for(String s: repairs){

            }
        }
    }
}