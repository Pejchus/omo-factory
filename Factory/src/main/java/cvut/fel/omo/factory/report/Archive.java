package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;

import java.util.ArrayList;

public class Archive {
    private ArrayList<StatData> statData;
    private ArrayList<ConfigData> configData;
    private ArrayList<EventData> eventData;
    private ArrayList<OuttagesData> outData;
    private AbstractData config;
    private AbstractData consum;
    private AbstractData event;
    private AbstractData outtage;
    private AbstractData dataChain;

    private AbstractData getDataChain(Factory f){
        config = new ConfigData(AbstractData.CONFIG);
         consum = new StatData(AbstractData.CONSUMP);
         //((StatData) consum).init(f.getLineManagement().getLines());
         event = new EventData(AbstractData.EVENT);
         outtage = new OuttagesData(AbstractData.OUT);

        config.setNextData(consum);
        consum.setNextData(event);
        event.setNextData(outtage);
        return config;
    }

    public Archive(Factory f){
        dataChain = getDataChain(f);
        statData = new ArrayList<StatData>();
        configData = new ArrayList<ConfigData>();
        eventData = new ArrayList<EventData>();
        outData = new ArrayList<OuttagesData>();
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

    public ArrayList<ConfigData> getConfigData() { return configData; }
    public ArrayList<StatData> getStatData() { return statData; }
    public ArrayList<EventData> getEventData() { return eventData; }
    public ArrayList<OuttagesData> getOutData() { return outData; }

    public void addStat(StatData st){
        this.statData.add(st);
    }

    public void addEvent(EventData ev){
        System.out.println("kokot");
        System.out.println(ev);
        this.eventData.add(ev);
    }

    public void addConf(ConfigData cf){ this.configData.add(cf); }
    public void addOut(OuttagesData out) {this.outData.add(out);}

}
