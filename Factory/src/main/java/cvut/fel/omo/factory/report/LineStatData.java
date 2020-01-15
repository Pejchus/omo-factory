package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.management.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LineStatData{

    int allElectricity;
    int robotsElectricity;
    int machinesElectricity;
    ArrayList<String> robElectricity;
    ArrayList<String> machElectricity;
    int wages;


    public LineStatData(){
        this.allElectricity=0;
        this.robotsElectricity = 0;
        this.machinesElectricity = 0;
        robElectricity = new ArrayList<String>();
        machElectricity = new ArrayList<String>();
    }

    public int getAllElectricity(){return this.allElectricity;}
    public int getRobotsElectricity(){return this.robotsElectricity;}
    public int getMachinesElectricity(){return this.machinesElectricity;}
    public ArrayList<String> getRobElectricity(){return this.robElectricity;}
    public ArrayList<String> getMachElectricity(){return this.machElectricity;}

    public void update(Line line){
        for(Robot r:line.getRobots()){
            RobotAPI API = r.getAPI();
            this.allElectricity += API.getElectricity();
            this.robotsElectricity += API.getElectricity();
            this.robElectricity.add("Serial number: "+r.getSerialNumber()+" Consumption this tact: "+API.getElectricity());
        }
        for(Machine m: line.getMachines()){
            MachineAPI API = m.getAPI();
            this.allElectricity += API.getElectricity();
            this.machinesElectricity += API.getElectricity();
            this.machElectricity.add("Serial number: "+m.getSerialNumber()+" Consumption this tact: "+API.getElectricity());
        }
    }

}
