package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;
import cvut.fel.omo.factory.management.Line;

import java.util.ArrayList;

public class StatData extends AbstractData{
    private ArrayList<LineStatData> lineData;
    private int level;

    public StatData(int level){
        this.level = level;
        lineData = new ArrayList<LineStatData>();
    }
    public void init(ArrayList<Line> lines){
        for(int i=0;i<lines.size();i++){
            LineStatData data = new LineStatData();
            lineData.add(data);
        }
    }
    public void update(Factory f){
        ArrayList<Line> lines = f.getLineManagement().getLines();
        for(int i=0;i<lines.size();i++){
            lineData.get(i).update(lines.get(i));
        }
    }
    public ArrayList<LineStatData> getLineData(){return lineData;}
    @Override
    protected void save(Archive archive) {
        archive.addStat(this);
    }
}
