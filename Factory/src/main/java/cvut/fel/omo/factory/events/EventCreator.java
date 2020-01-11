package cvut.fel.omo.factory.events;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class EventCreator {
    private Queue<Event> events;
    private MaintananceObserver maintanance;
    private InspectorObserver inspections;
    private int tact;

    public EventCreator(int tact){
        events = new PriorityQueue<Event>(eventComparator);
        this.maintanance = new MaintananceObserver(this);
        this.inspections = new InspectorObserver(this);
        this.tact = tact;
    }
    public boolean pushEvent(Event event){
        return events.add(event);
    }
    public int getTact(){return this.tact;}
    public void updateTact(){
        this.tact++;
        notifyObservers();
    }
    public Queue<Event> getEvents(){
        return events;
    }
    public void notifyObservers(){
        maintanance.update();
        inspections.update();
    }
    Comparator<Event> eventComparator = new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {
            return e2.getPriority() - e1.getPriority();
        }
    };
}
