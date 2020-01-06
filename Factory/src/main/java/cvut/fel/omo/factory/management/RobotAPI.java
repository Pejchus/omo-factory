package cvut.fel.omo.factory.management;

public class RobotAPI {
    boolean functionality;
    int oil;
    int electricity;
    Robot robot;

    RobotAPI(Robot robot){
        this.robot = robot;
    }

    int getOil(){
        return this.robot.get_oil();
    }

    int getElectricity(){
        return this.robot.get_electricity();
    }
}
