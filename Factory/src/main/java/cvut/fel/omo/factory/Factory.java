package cvut.fel.omo.factory;

import cvut.fel.omo.factory.finance.Finance;
import cvut.fel.omo.factory.maintenance.Maintenance;
import cvut.fel.omo.factory.management.LineManagement;

public class Factory {
    Time time;
    Maintenance maintenance;
    Finance finance;
    LineManagement lineManagement;

    public Factory(){
        this.maintenance = new Maintenance();
        this.finance = new Finance();
        this.lineManagement = new LineManagement();
    }
}
