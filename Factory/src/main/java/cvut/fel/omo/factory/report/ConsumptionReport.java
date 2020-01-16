package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.management.Line;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class ConsumptionReport implements Report {
    private Archive archive;

    public ConsumptionReport(Archive archive){
        this.archive = archive;
    }
    @Override
    public void create(int from, int to) {
        try {
            File f = new File("consumptionReport_from_"+from+"_to_"+to+".txt");
            PrintWriter writer = new PrintWriter(f, StandardCharsets.UTF_8);
            writer.write("CONSUMPTION REPORT - FROM TACT "+from+" TO TACT "+to+"\n");
            writer.flush();
            for(int i=from;i<=to;i++) {
                StatData statData = archive.getStatData().get(i);
                LineStatData lineData = statData.getLineData().get(i);
                writer.write("===============================================\n" +
                        "Consumption in tact " + i + ":\n" +
                        "\tTotal consumption: " + statData.getFactoryElectricity() + "\n");
                writer.flush();
                for (int j = 0; j < statData.getLineData().size(); j++) {
                    writer.write("\t+++++++++++++++++++++++++++++\n" +
                            "\tTotal consumption of line " + (j + 1) + ": "+lineData.getAllElectricity()+"\n" +
                            "\t\tConsumption of all machines: "+lineData.getMachinesElectricity()+"\n"+
                            "\t\tConsumption of all robots: " +lineData.getRobotsElectricity()+"\n"+
                            "\t\tConsumption of every machine: \n");
                    writer.flush();
                    for(int x=0;x<lineData.getMachElectricity().size();x++){
                        writer.write("\t\t\t"+lineData.getMachElectricity().get(i)+"\n");
                        writer.flush();
                    }
                    writer.write("\t\tConusmption of every robot: \n");
                    writer.flush();
                    for(int x=0;x<lineData.getRobElectricity().size();x++){
                        writer.write("\t\t\t"+lineData.getRobElectricity().get(i)+"\n");
                        writer.flush();
                    }
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
