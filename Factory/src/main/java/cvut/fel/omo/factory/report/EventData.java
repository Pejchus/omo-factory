package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.events.Event;

import java.util.ArrayList;

public class EventData {
    private ArrayList<Event> data;

    public EventData(){
        data=new ArrayList<Event>();
    }

    public void push(Event e){
        data.add(e);
    }
    public ArrayList<Event> getData() {
        return data;
    }
}
