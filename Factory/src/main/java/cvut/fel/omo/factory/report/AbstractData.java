package cvut.fel.omo.factory.report;

public abstract class AbstractData {
    public static int CONFIG = 1;
    public static int CONSUMP = 2;
    public static int EVENT = 3;
    public static int OUT = 3;

    protected int level;
    protected AbstractData nextData;

    public void setNextData(AbstractData nextData){
        this.nextData = nextData;
    }

    public void saveData(int level,Archive archive){
        if(this.level <= level){save(archive);}
        if(nextData != null){
            nextData.saveData(level,archive);
        }
    }

    abstract protected void save(Archive archive);
}
