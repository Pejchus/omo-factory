package cvut.fel.omo.factory.management;

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.finance.Finance;
import org.junit.Test;

public class LineManagementTest {

    @Test
    public void workWellTest(){
        Finance finance = new Finance(1000);
        EventCreator eventCreator = new EventCreator(0);
        Storage storage = new Storage(eventCreator);
        LineManagement man = new LineManagement(eventCreator,storage,finance);
        String[] materials = {"words", "melody"};
        int[] numMaterials = {100,2};
        man.createLine(new Blueprint("hovno",materials,numMaterials,100),1);
    }
}
