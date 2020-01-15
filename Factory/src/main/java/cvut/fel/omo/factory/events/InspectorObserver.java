package cvut.fel.omo.factory.events;

import cvut.fel.omo.factory.maintenance.Director;
import cvut.fel.omo.factory.maintenance.Inspector;
import cvut.fel.omo.factory.maintenance.Maintenance;
import cvut.fel.omo.factory.management.LineManagement;

public class InspectorObserver extends Observer {
    private EventCreator subject;
    private Inspector inspector;
    private Director director;
    private int tact;

    public InspectorObserver(EventCreator subject, Inspector inspector, Director director){
        this.subject = subject;
        this.inspector = inspector;
        this.director = director;
        subject.setInspections(this);
    }

    @Override
    public void update() {
        this.tact = subject.getTact();
        if(this.tact%10 ==0){
            this.director.visit();
            this.inspector.visit();
        }

    }
}
