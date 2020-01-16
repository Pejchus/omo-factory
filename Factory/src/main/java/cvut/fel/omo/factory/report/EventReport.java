package cvut.fel.omo.factory.report;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class EventReport implements Report {
    Archive archive;

    EventReport(Archive a){
        archive=a;
    }

    @Override
    public void create(int from, int to) {
        try {
            PrintWriter writer = new PrintWriter("EventReport.txt", StandardCharsets.UTF_8);
            for (int i = from; i <= to; i++) {
                writer.println(archive.getEventData().get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
