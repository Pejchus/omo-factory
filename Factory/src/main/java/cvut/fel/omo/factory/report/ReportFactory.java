package cvut.fel.omo.factory.report;

public class ReportFactory {
    private ConfigReport configReport;
    private ConsumptionReport consumptionReport;
    private OuttagesReport outtagesReport;
    private EventReport eventReport;

    public ReportFactory(Archive archive){
        configReport = new ConfigReport(archive);
        consumptionReport = new ConsumptionReport(archive);
        outtagesReport = new OuttagesReport(archive);
        eventReport = new EventReport(archive);
    }
    public Report getReport(String reportType,int from,int to){
        if(reportType == null){
            return null;
        }
        if(reportType.equalsIgnoreCase("Configuration")){
            configReport.create(from,to);
        }
        if(reportType.equalsIgnoreCase("Consumption")){
            consumptionReport.create(from,to);
        }
        if(reportType.equalsIgnoreCase("Events")){
            eventReport.create(from,to);
        }
        if(reportType.equalsIgnoreCase("Outtages")){
            outtagesReport.create(from,to);
        }
        return null;
    }
}
