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
import cvut.fel.omo.factory.report.Archive;
import cvut.fel.omo.factory.report.ConfigData;
import cvut.fel.omo.factory.report.ReportFactory;

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
    private Archive archive;
    private ReportFactory reportFactory;

    public Factory(Time time) {
        this.eventCreator = new EventCreator(0);
        this.finance = new Finance(10000);
        this.maintenance = new Maintenance(eventCreator,finance);
        this.storage = new Storage(eventCreator);
        this.lineManagement = new LineManagement(eventCreator,storage,finance);
        this.maintenance = new Maintenance(eventCreator,finance);
        this.inspector = new Inspector(lineManagement);
        this.director = new Director(lineManagement);
        this.inspectorObserver = new InspectorObserver(eventCreator,inspector,director);
        archive=new Archive(this);
        reportFactory = new ReportFactory(archive);
    }

    public void addMaterial(String material, int cost, int amount) {
        finance.addMaterial(material, cost);
        storage.addToStorage(material, amount);
    }

    public void addBlueprint(Blueprint B) {
        lineManagement.addBlueprint(B);
    }
    public void createLine(Blueprint blueprint, int priority) {
        lineManagement.createLine(blueprint, priority);
    }

    public Storage getStorage() {
        return storage;
    }

    public EventCreator getEventCreator() {
        return eventCreator;
    }

    public LineManagement getLineManagement() {
        return lineManagement;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public Finance getFinance() {
        return finance;
    }

    public void work(Time time){
        eventCreator.updateTact(time.getTact());
        lineManagement.work();
        //eventCreator.doEvenets
        archive.update(this);
        archive.save();
        //reports
        time.updateTime();
        eventCreator.updateTact(time.getTact());

    }
    public void generateReport(String s,int from,int to){
        System.out.println(archive.getConfigData().get(0).getNumLines());
        reportFactory.getReport(s,from,to);
    }
    public void make_re(){

    }
}
