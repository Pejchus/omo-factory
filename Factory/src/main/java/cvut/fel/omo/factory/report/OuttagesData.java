package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;

import java.util.ArrayList;

public class OuttagesData extends AbstractData {
    private int maxOuttage;
    private int minOuttage;
    private float averageOuttage;
    private int level;

    public OuttagesData(int level){
        this.level = level;
        this.maxOuttage = 0;
        this.minOuttage = 0;
        this.averageOuttage = 0;
    }

    public int getMaxOuttage() { return maxOuttage; }
    public int getMinOuttage() { return minOuttage; }
    public float getAverageOuttage() { return averageOuttage; }

    public void update(Factory f){
        ArrayList<Integer> outtages = f.getLineManagement().getOutages();
        int count = 1;
        int sum =0;
        for(int x: outtages){
            if(x>maxOuttage){maxOuttage=x;}
            if(count==0){minOuttage=x;}
            if(x<minOuttage){minOuttage=x;}
            if(x>0){
                sum +=x;
                count++;
            }
        }
        averageOuttage = sum/count;
    }
    @Override
    protected void save(Archive archive) {
        archive.addOut(this);
    }
}
