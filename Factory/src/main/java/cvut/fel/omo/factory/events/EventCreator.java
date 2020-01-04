package cvut.fel.omo.factory.events;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class EventCreator {
    private Queue<Event> events;
    private MaintananceObserver maintanance;
    private InspectorObserver inspections;
    private int tact;

    public EventCreator(int tact){
        events = new PriorityQueue<Event>();
        this.maintanance = new MaintananceObserver(this);
        this.inspections = new InspectorObserver(this);
        this.tact = tact;
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

}
