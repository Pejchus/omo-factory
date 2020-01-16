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
            writer.write("Outage REPORT - FROM TACT " + from + " TO TACT " + to + "\n");
            writer.flush();
            for (int i = from; i <= to; i++) {
                OuttagesData outData = archive.getOutData().get(i);
                writer.write("===============================================\n" +
                        "Outtages in tact " + i + ":\n");

                writer.flush();
                for (Event e : eventData.getData()) {
                    writer.write("\t+++++++++++++++++++++++++++++\n" +
                            "\tEvent type: " + (e.getType()) + " Event source: " + e.getSource()+"\n");
                    writer.flush();
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

}
