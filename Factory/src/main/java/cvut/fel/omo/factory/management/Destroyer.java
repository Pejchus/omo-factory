package cvut.fel.omo.factory.management;

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;

abstract class Destroyer {
    protected EventCreator eventCreator;
    protected static int counter;
    protected int serialNumber;
    protected int mayDestroy(int replacement){
        if(((int)(30.0 * Math.random()))==1){
            eventCreator.pushEvent(new Event("neni mu nic",String.valueOf(serialNumber),replacement));
            return 0;
        }
        if(((int)(75.0 * Math.random()))==1){
            eventCreator.pushEvent(new Event("kolecko se polamalo",String.valueOf(serialNumber),replacement));
            return 0;
        }
        if(((int)(250.0 * Math.random()))==1){
            eventCreator.pushEvent(new Event("to je mu a hodne",String.valueOf(serialNumber),replacement));
            return 0;
        }
        return 1;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
