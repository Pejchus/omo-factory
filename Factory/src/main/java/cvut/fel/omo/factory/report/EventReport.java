package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.events.Event;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class EventReport implements Report {
    Archive archive;

    EventReport(Archive a) {
        archive = a;
    }

    @Override
    public void create(int from, int to) {
        try {
            File f = new File("eventReport_from_" + from + "_to_" + to + ".txt");
            PrintWriter writer = new PrintWriter(f, StandardCharsets.UTF_8);
            writer.write("EVENT REPORT - FROM TACT " + from + " TO TACT " + to + "\n");
            writer.flush();
            for (int i = from; i <= to; i++) {
                EventData eventData = archive.getEventData().get(i);
                writer.write("===============================================\n" +
                        "Events in tact " + i + ":\n");

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
}