package cvut.fel.omo.factory;

import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.events.InspectorObserver;
import cvut.fel.omo.factory.finance.Finance;
import cvut.fel.omo.factory.maintenance.Director;
import cvut.fel.omo.factory.maintenance.Inspector;
import cvut.fel.omo.factory.maintenance.Maintenance;
import cvut.fel.omo.factory.management.Blueprint;
import cvut.fel.omo.factory.management.LineManagement;
import cvut.fel.omo.factory.management.Storage;

public class Factory {
    Time time;
    private Storage storage;
    private Maintenance maintenance;
    private Finance finance;
    private EventCreator eventCreator;
    private LineManagement lineManagement;
    private InspectorObserver inspectorObserver;
    private Inspector inspector;
    private Director director;

    public Factory(Time time) {
        this.eventCreator = new EventCreator(0);
        this.finance = new Finance(10000);
        this.maintenance = new Maintenance(eventCreator,finance);
        this.storage = new Storage(eventCreator);
        this.lineManagement = new LineManagement(eventCreator,storage,finance);
        this.inspector = new Inspector(lineManagement);
        this.director = new Director(lineManagement);
        this.inspectorObserver = new InspectorObserver(eventCreator,inspector,director);
    }

    public void addMaterial(String material, int cost, int amount) {
        finance.addMaterial(material, cost);
        storage.addToStorage(material, amount);
    }

    public void addBlueprint(Blueprint B) {
        lineManagement.addBlueprint(B);
    }
    public void createLine(Blueprint blueprint, int priority, int productNum) {
        lineManagement.createLine(blueprint, priority, productNum);
    }

    public void work(Time time){
        eventCreator.updateTact(time.getTact());
        lineManagement.work();
        //reports
        time.updateTime();
        eventCreator.updateTact(time.getTact());

    }
}
