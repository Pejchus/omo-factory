package cvut.fel.omo.factory.events;
import cvut.fel.omo.factory.maintenance.*;

import java.util.ArrayList;
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
        repairs = new HashMap<String,Integer>();
        repairs.put("run out of oil",1);
        repairs.put("neni mu nic",2);
        repairs.put("kolecko se polamalo",5);
        repairs.put("to je mu a hodne",10);
    }
    @Override
    public void update() {
        maintenance.processRepair();
        ArrayList<Event> toremove = new ArrayList<>();
        for (Event e : subject.getEvents()) {
            for (Map.Entry<String, Integer> entry : repairs.entrySet()) {
                if (entry.getKey() == e.getType()) {
                    if (maintenance.callMaintenance(entry.getValue(), Integer.valueOf(e.getSource()))) {
                        toremove.add(e);
                    } else {
                        fuckConcurrentException(toremove);
                        return;
                    }

                }

            }

        }
        fuckConcurrentException(toremove);
    }

    private void fuckConcurrentException(ArrayList<Event> toremove){
        for (int i = 0; i < toremove.size(); ) {
            subject.remove(toremove.get(0));
            toremove.remove(0);
        }
    }
}