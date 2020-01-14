package cvut.fel.omo.factory.events;
import java.util.*;

public class EventCreator {
    private Queue<Event> events;
    private MaintananceObserver maintanance;
    private InspectorObserver inspections;
    private int tact;

    public EventCreator(int tact){
        events = new PriorityQueue<Event>(eventComparator);
        //this.maintanance = new MaintananceObserver(this);
       // this.inspections = new InspectorObserver(this);
        this.tact = tact;
    }
    void setMaintanance(MaintananceObserver m){
        maintanance=m;
    }
    public boolean pushEvent(Event event){
        return events.add(event);
    }
    public int getTact(){return this.tact;}
    public void updateTact(){
        this.tact++;
        notifyObservers();
    }

    public void notifyObservers(){
        maintanance.update();
        inspections.update();
    }
    Comparator<Event> eventComparator = new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {
            return e1.getPriority() - e2.getPriority();
        }
    };

    public Queue<Event> getEvents() {
        return events;
    }
}
