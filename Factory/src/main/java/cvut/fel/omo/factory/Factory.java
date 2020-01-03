package cvut.fel.omo.factory;

import cvut.fel.omo.factory.finance.Finance;
import cvut.fel.omo.factory.maintenance.Maintenance;
import cvut.fel.omo.factory.management.Blueprint;
import cvut.fel.omo.factory.management.LineManagement;
import cvut.fel.omo.factory.management.Storage;

public class Factory {
    Time time;
    private Storage storage;
    private Maintenance maintenance;
    private Finance finance;
    private LineManagement lineManagement;

    public Factory(){
        this.maintenance = new Maintenance();
        this.finance = new Finance(10000);
        this.storage = new Storage();
        this.lineManagement = new LineManagement();
    }

    public void addMaterial(String material, int cost, int amount){
        finance.addMaterial(material,cost);
        storage.addToStorage(material,amount);
    }
    public void addBlueprint(Blueprint B){
        lineManagement.addBlueprint(B);
    }
    public void createLine(Blueprint blueprint, int priority, int productNum) {
        lineManagement.createLine(blueprint,priority,productNum);
    }
    public void functionalityCheck(Storage storage){
        lineManagement.functionalityCheck(storage);
    }
    public void work(){
    }
}
