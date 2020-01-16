package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;
import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.LineManagement;

import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class ConfigData extends AbstractData{
    private int numLines;
    private ArrayList<String> configuration;
    private int level;

    public ConfigData(int level){
        configuration = new ArrayList<String>();
        this.level = level;
    }

    public void update(Factory f){
        ConfigData data = new ConfigData(level);

        ArrayList<Line> lines = f.getLineManagement().getLines();
        numLines = lines.size();
        for(Line l: lines){
            this.configuration.add(l.getBlueprint().getConfiguration());
        }
    }

    public ArrayList<String> getConfig() {
        return configuration;
    }
    public int getNumLines() { return numLines; }

    @Override
    protected void save(Archive archive){
        archive.addConf(this);
    }
}
