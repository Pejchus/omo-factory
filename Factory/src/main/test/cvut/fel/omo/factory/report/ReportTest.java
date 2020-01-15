package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.events.Event;
import org.junit.Test;

import java.io.*;

public class ReportTest {


    @Test
    public void printReportTest() throws IOException {
        Archive a = new Archive();
        Event e1 = new Event("kokot", "hovno", 0);
        EventData ed = new EventData();
        ed.push(e1);
        a.addEvent(ed);
        eventReport evr = new eventReport(a);
        evr.createReport(0, 0);
        String st;
        File file = new File("eventReport.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        ed.push(e1);
        a.addEvent(ed);
        evr.createReport(1, 1);
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }

}

