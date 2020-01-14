package cvut.fel.omo.factory.maintenance;

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.events.MaintananceObserver;
import cvut.fel.omo.factory.finance.Finance;

public class Maintenance {
    Maintainer[] maintainers;
    EventCreator eventCreator;
    private MaintananceObserver observer;
    private Finance finance;

    public Maintenance(EventCreator eventCreator,Finance f){
        finance=f;
        this.eventCreator = eventCreator;
        observer = new MaintananceObserver(eventCreator,this);
        this.maintainers = new Maintainer[10];
        int i;
        for (i = 0; i<=9; i++){
            maintainers[i] = new Maintainer(100);
        }

    }
    public void processRepair(){
        for(int i = 0;i< maintainers.length ; i++){
            finance.pay(maintainers[i].wage);
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
