package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.events.Event;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class OuttagesReport implements Report {

    Archive archive;
    public OuttagesReport(Archive archive){
        this.archive = archive;
    }

    @Override
    public void create(int from, int to) {
        try {
            File f = new File("outageReport_from_" + from + "_to_" + to + ".txt");
            PrintWriter writer = new PrintWriter(f, StandardCharsets.UTF_8);
            writer.write("Outage REPORT - FROM TACT " + from + " TO TACT " + to + "\n" +
                    "================================================\n");
            writer.flush();
           float max = 0;
            int max_count = 0;
            float min = 0;
            int min_count = 0;
            float avarage = 0;
            int a_count = 0;
            for (int i = from; i <= to; i++) {
                OuttagesData outData = archive.getOutData().get(i);
                if (outData.getMaxOuttage() > 0) {
                    max += outData.getMaxOuttage();
                    max_count++;
                }
                if (outData.getMinOuttage() > 0) {
                    min += outData.getMinOuttage();
                    min_count++;
                }
                if (outData.getAverageOuttage() > 0) {
                    avarage += outData.getAverageOuttage();
                    a_count++;
                }
            }
            if (max_count > 0) {
                max = max / max_count;
            } else {
                max = 0;
            }
            if (min_count > 0) {
                min = min / min_count;
            } else {
                min = 0;
            }
            if (a_count > 0) {
                avarage = avarage / a_count;
            } else {
                avarage = 0;
            }
            writer.write("Biggest outtage: " + max + "\n" +
                    "Smallest outtage: " + min + "\n" +
                    "Average outtage: " + avarage + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
