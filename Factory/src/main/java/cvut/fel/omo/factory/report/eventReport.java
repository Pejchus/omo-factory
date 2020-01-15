package cvut.fel.omo.factory.report;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class eventReport implements report {
    Archive archive;

    eventReport(Archive a){
        archive=a;
    }

    @Override
    public void createReport(int from, int to) {
        try {
            PrintWriter writer = new PrintWriter("eventReport.txt", StandardCharsets.UTF_8);
            for (int i = from; i <= to; i++) {
                writer.println(archive.eventData.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printReport() {

    }
}
