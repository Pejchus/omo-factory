package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.management.Line;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ConfigReport implements Report {
    private Archive archive;
    private ArrayList<ConfigData> configData;

    public ConfigReport(Archive archive){
        this.archive = archive;
    }

    @Override
    public void create(int from, int to) {
        try {
            PrintWriter writer = new PrintWriter("ConfigReport_from_"+from+"_to_"+to+".txt", StandardCharsets.UTF_8);
            writer.write("CONFIGURATION REPORT - FROM TACT "+from+" TO TACT "+to+"\n");
            writer.flush();
            for(int i=from;i<=to;i++) {
                ArrayList<Line> lines = archive.configData.get(i).getLines();
                writer.write("===============================================\n" +
                        "Configuration in tact " + i + ":\n" +
                        "\tTotal number of lines: " + lines.size() + "\n");
                writer.flush();
                for (int j = 0; j < lines.size(); j++) {
                    writer.write("\t+++++++++++++++++++++++++++++\n" +
                            "\tCongiguration of line " + (j + 1) + ":\n" +
                            "\t\t" + lines.get(j).getBlueprint().getConfiguration() + "\n");
                    writer.flush();
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {

    }
}
