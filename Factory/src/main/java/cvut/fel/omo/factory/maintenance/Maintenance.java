package cvut.fel.omo.factory.maintenance;

public class Maintenance {
    Maintainer[] maintainers;

    public Maintenance(){
        this.maintainers = new Maintainer[10];
        int i;
        for (i = 0; i<=9; i++){
            maintainers[i] = new Maintainer(100);
        }

    }
    public boolean callMaintenance(){
        for (int i = 0; i <= 9; i++){
            if (maintainers[i].availability){
                maintainers[i].availability = false;
                return true;
            }
        }
        return false;
    }
}
