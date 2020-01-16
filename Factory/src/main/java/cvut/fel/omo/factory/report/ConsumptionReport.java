package cvut.fel.omo.factory.report;

public class ConsumptionReport implements Report {
    private Archive archive;

    public ConsumptionReport(Archive archive){
        this.archive = archive;
    }
    @Override
    public void create(int from, int to) {
    }

    @Override
    public void print() {

    }
}
