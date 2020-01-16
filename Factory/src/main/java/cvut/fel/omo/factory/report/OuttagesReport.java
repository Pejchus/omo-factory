package cvut.fel.omo.factory.report;

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
            PrintWriter writer = new PrintWriter("OuttagesReport.txt", StandardCharsets.UTF_8);
            for (int i = from; i < to; i++) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
