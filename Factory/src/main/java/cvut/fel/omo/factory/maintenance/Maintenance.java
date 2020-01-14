package cvut.fel.omo.factory.maintenance;

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;

public class Maintenance {
    Maintainer[] maintainers;
    EventCreator eventCreator;

    public Maintenance(EventCreator eventCreator){
        this.eventCreator = eventCreator;
        this.maintainers = new Maintainer[10];
        int i;
        for (i = 0; i<=9; i++){
            maintainers[i] = new Maintainer(100);
        }

    }
    public void processRepair(){
        for(int i = 0;i< maintainers.length ; i++){
            maintainers[i].availableIn--;
            if(maintainers[i].availableIn==0){
                eventCreator.pushEvent(new Event("repair done",Integer.toString(maintainers[i].repairs),100));
                maintainers[i].repairs=-1;
            }

        }
    }

    public boolean callMaintenance(int time,int serialNumber){
        for (int i = 0; i <= 9; i++){
            if (maintainers[i].availableIn<=0){
                maintainers[i].availableIn=time;
                maintainers[i].repairs=serialNumber;
                return true;
            }
        }
        return false;
    }
}
