package cvut.fel.omo.factory.management;

public class MachineAPI {
    Machine  machine;

    MachineAPI(Machine machine){
        this.machine = machine;
    }

    public int getOil(){
        return this.machine.get_oil();
    }

    public int getElectricity(){
        return this.machine.get_electricity();
    }
}
