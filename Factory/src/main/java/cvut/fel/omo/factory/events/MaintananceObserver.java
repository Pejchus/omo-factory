package cvut.fel.omo.factory.events;
import cvut.fel.omo.factory.maintenance.*;

import java.util.HashMap;
import java.util.Map;


public class MaintananceObserver extends Observer {
    private EventCreator subject;
    private HashMap<String,Integer> repairs;
    private Maintenance maintenance;

    public MaintananceObserver(EventCreator subject,Maintenance m){
        this.subject = subject;
        maintenance =m;
        subject.setMaintanance(this);
    }
    @Override
    public void update() {
        maintenance.processRepair();
        for(Event e:subject.getEvents()){
            for (Map.Entry<String, Integer> entry : repairs.entrySet()) {
                if(entry.getKey()==e.getType()){
                    if(maintenance.callMaintenance(entry.getValue(),Integer.valueOf(e.getSource()))){
                        subject.getEvents().remove(e);
                    }else{break;}

                }

            }
        }
    }
}