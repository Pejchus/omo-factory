package cvut.fel.omo.factory.report;

import java.util.ArrayList;

public class Archive {

    ArrayList<StatData> statData;
    ArrayList<ConfigData> configData;
    ArrayList<EventData> eventData;

    public Archive(){
    }

    public Archive getArchive(){
        return this;
    }

    public void addStat(StatData st){
        this.statData.add(st);
    }

    public void addEvent(EventData ev){
        this.eventData.add(ev);
    }

    public void addConf(ConfigData cf){
        this.configData.add(cf);
    }
}
