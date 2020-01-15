package cvut.fel.omo.factory.events;

import cvut.fel.omo.factory.management.LineManagement;

import java.util.ArrayList;

public class LineObserver extends Observer {
    private EventCreator subject;
    private LineManagement lines;

    public LineObserver(EventCreator subject,LineManagement m){
        this.subject = subject;
        this.lines= m;
        subject.setLines(this);
    }
    @Override
    public void update() {
        ArrayList<Event> toremove = new ArrayList<>();
        for(Event e:subject.getEvents()){
            if(e.getType()=="repair done"){
                lines.repairDone(Integer.valueOf(e.getSource()));
                toremove.add(e);
            }
        }
        for (int i = 0; i < toremove.size(); ) {
            subject.remove(toremove.get(0));
            toremove.remove(0);
        }
    }



}
