package cvut.fel.omo.factory.report;

import java.util.ArrayList;
public interface report {

    public report createReport(int from, int to );

    public void printReport();
}
