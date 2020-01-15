package cvut.fel.omo.factory.events;
import cvut.fel.omo.factory.report.EventData;

import java.util.*;

public class EventCreator {
    private Queue<Event> events;
    private MaintananceObserver maintanance;
    private InspectorObserver inspections;
    private LineObserver lines;
    private int tact;
    EventData data;

    public EventCreator(int tact){
        events = new PriorityQueue<Event>(eventComparator);
        //this.maintanance = new MaintananceObserver(this);
       // this.inspections = new InspectorObserver(this);
        data = new EventData();
        this.tact = tact;
    }
    void setMaintanance(MaintananceObserver m){
        maintanance=m;
    }
    void setInspections(InspectorObserver i){inspections=i;}
    void setLines(LineObserver l){
        lines=l;
    }
    public boolean pushEvent(Event event){
        return events.add(event);
    }
    void remove(Event e){
        data.push(e);
        events.remove(e);
    }
    public int getTact(){return this.tact;}
    public void updateTact(int tact){
        this.tact = tact;
        notifyObservers();
    }

    public void notifyObservers(){
        maintanance.update();
        inspections.update();
        lines.update();
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
