package cvut.fel.omo.factory.report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class configReport implements report {
    Archive archive;

    @Override
    public void createReport(int from, int to) {
        try {
            PrintWriter writer = new PrintWriter("configReport.txt", StandardCharsets.UTF_8);
            for (int i = from; i < to; i++) {
                writer.println(archive.configData.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printReport() {

    }
}
