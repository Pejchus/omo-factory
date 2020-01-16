package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.management.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LineStatData{

    int allElectricity;
    int robotsElectricity;
    int machinesElectricity;
    ArrayList<Integer> robElectricity;
    ArrayList<Integer> robotSerial;
    ArrayList<Integer> machElectricity;
    ArrayList<Integer> machineSerial;
    int wages;


    public LineStatData(){
        this.allElectricity=0;
        this.robotsElectricity = 0;
        this.machinesElectricity = 0;
        robElectricity = new ArrayList<Integer>();
        machElectricity = new ArrayList<Integer>();
        robotSerial = new ArrayList<Integer>();
        machineSerial = new ArrayList<Integer>();
    }

    public int getAllElectricity(){return this.allElectricity;}
    public int getRobotsElectricity(){return this.robotsElectricity;}
    public int getMachinesElectricity(){return this.machinesElectricity;}
    public ArrayList<Integer> getRobElectricity(){return this.robElectricity;}
    public ArrayList<Integer> getMachElectricity(){return this.machElectricity;}
    public ArrayList<Integer> getRobotSerial() { return robotSerial; }
    public ArrayList<Integer> getMachineSerial() { return machineSerial; }

    public void update(Line line){
        for(Robot r:line.getRobots()){
            RobotAPI API = r.getAPI();
            this.allElectricity += API.getElectricity();
            this.robotsElectricity += API.getElectricity();
            this.robotSerial.add(r.getSerialNumber());
            this.robElectricity.add(API.getElectricity());
        }
        for(Machine m: line.getMachines()){
            MachineAPI API = m.getAPI();
            this.allElectricity += API.getElectricity();
            this.machinesElectricity += API.getElectricity();
            this.machineSerial.add(m.getSerialNumber());
            this.machElectricity.add(API.getElectricity());
        }
    }

}
