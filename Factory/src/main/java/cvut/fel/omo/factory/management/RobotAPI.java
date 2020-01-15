package cvut.fel.omo.factory.management;

public class RobotAPI {

    Robot robot;

    RobotAPI(Robot robot){
        this.robot = robot;
    }

    public int getOil(){
        return this.robot.get_oil();
    }

    public int getElectricity(){
        return this.robot.get_electricity();
    }
}
