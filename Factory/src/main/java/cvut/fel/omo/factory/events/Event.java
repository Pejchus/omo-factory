package cvut.fel.omo.factory.events;

public class Event {
    private String type;
    private String source;
    private int priority;

    public Event(String type,String source, int priority){
        this.type=type;
        this.source=source;
        this.priority=priority;
    }
    public String getType(){return type;}
    public int getPriority() {
        return priority;
    }
    public String getSource(){return source;}
}

