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
            //DATA
            int total = 0;
            ArrayList<Integer> line_consumption = new ArrayList<Integer>();
            /////////////////////////////////////////////
            for(int i=from;i<=to;i++){
                StatData statData = archive.getStatData().get(i);
                total += statData.getFactoryElectricity();
                for(int j=0;j<statData.getLineData().size();j++){
                    LineStatData lineData = statData.getLineData().get(j);
                }
            }
            for(int i=from;i<=to;i++) {
                StatData statData = archive.getStatData().get(i);

                writer.write("\tTotal consumption: " + total + "\n");
                writer.flush();
                for (int j = 0; j < statData.getLineData().size(); j++) {
                    LineStatData lineData = statData.getLineData().get(j);
                    writer.write("\t+++++++++++++++++++++++++++++\n" +
                            "\tTotal consumption of line " + (j + 1) + ": "+lineData.getAllElectricity()+"\n" +
                            "\t\tConsumption of all machines: "+lineData.getMachinesElectricity()+"\n"+
                            "\t\tConsumption of all robots: " +lineData.getRobotsElectricity()+"\n"+
                            "\t\tConsumption of every machine: \n");
                    writer.flush();
                    for(int x=0;x<lineData.getMachElectricity().size();x++){
                        writer.write("\t\t\t"+lineData.getMachElectricity().get(x)+"\n");
                        writer.flush();
                    }
                    writer.write("\t\tConusmption of every robot: \n");
                    writer.flush();
                    for(int x=0;x<lineData.getRobElectricity().size();x++){
                        writer.write("\t\t\t"+lineData.getRobElectricity().get(x)+"\n");
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
