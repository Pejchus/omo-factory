package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;

import java.util.ArrayList;

public class Archive {
    ArrayList<StatData> statData;
    ArrayList<ConfigData> configData;
    ArrayList<EventData> eventData;
    ArrayList<OuttagesData> outData;
    private AbstractData config;
    private AbstractData consum;
    private AbstractData event;
    private AbstractData outtage;
    private AbstractData dataChain;

    private AbstractData getDataChain(){
        config = new ConfigData(AbstractData.CONFIG);
         consum = new StatData(AbstractData.CONSUMP);
         event = new EventData(AbstractData.EVENT);
         outtage = new OuttagesData(AbstractData.OUT);

        outtage.setNextData(event);
        event.setNextData(consum);
        consum.setNextData(config);
        return config;
    }

    public Archive(){
        dataChain = getDataChain();
    }

    public void saveData(){
        dataChain.saveData(AbstractData.OUT,this);
    }
    public void update(Factory factory){
        dataChain.updateData(AbstractData.OUT,factory);
    }

    public AbstractData getConfig() { return config; }
    public AbstractData getEvent() { return event; }
    public AbstractData getConsum() { return consum; }
    public AbstractData getOuttage() { return outtage; }
    public Archive getArchive(){ return this; }

    public void addStat(StatData st){
        this.statData.add(st);
    }

    public void addEvent(EventData ev){
        this.eventData.add(ev);
    }

    public void addConf(ConfigData cf){
        this.configData.add(cf);
    }

    public void addOut(OuttagesData out) {this.outData.add(out);}
}
