package cvut.fel.omo.factory.maintenance;

public class Maintainer {

    int wage;
    int availableIn;
    int repairs;

    public Maintainer(int wage){
        this.availableIn = 0;
        this.wage = wage;
        repairs =-1;
    }

    public int getAvailableIn() {
        return availableIn;
    }
}
