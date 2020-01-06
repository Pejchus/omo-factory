package cvut.fel.omo.factory.management;

public class RobotAPI {

    Robot robot;

    RobotAPI(Robot robot){
        this.robot = robot;
    }

    Integer getOil(){
        return this.robot.get_oil();
    }

    Integer getElectricity(){
        return this.robot.get_electricity();
    }
}
