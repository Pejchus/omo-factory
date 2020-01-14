package cvut.fel.omo.factory.events;

import cvut.fel.omo.factory.management.LineManagement;

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
        for(Event e:subject.getEvents()){
            if(e.getType()=="repair done"){
                lines.repairDone(Integer.valueOf(e.getSource()));
                subject.getEvents().remove(e);
            }
        }
    }



}
