package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.events.Event;

import java.util.ArrayList;

public class EventData extends AbstractData{
    private ArrayList<Event> data;
    private int level;

    public EventData(int level){
        this.level = level;
        data=new ArrayList<Event>();
    }

    public void push(Event e){
        data.add(e);
    }
    public ArrayList<Event> getData() {
        return data;
    }
    @Override
    protected void save(Archive archive) {
        archive.addEvent(this);
    }
}
