package cvut.fel.omo.factory;

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.maintenance.Maintainer;
import cvut.fel.omo.factory.management.Blueprint;
import org.junit.*;

import java.util.ArrayList;

public class FactoryTest {

    @Test
    public void youBetterWorkBitch(){
        Time einstein = Time.getInstance();
        Factory britneySpears = new Factory(einstein);
        String[] materials = {"words", "melody"};
        int[] numMaterials = {100,2};
        Blueprint song = new Blueprint("RRMPPMR",materials, numMaterials,10000);
        Blueprint album = new Blueprint("MMMPRPRMPRP",materials, numMaterials,10000);
        britneySpears.addBlueprint(song);
        britneySpears.addBlueprint(album);
        Assert.assertNotNull(britneySpears.getEventCreator());
        Assert.assertNotNull(britneySpears.getFinance());
        Assert.assertNotNull(britneySpears.getLineManagement());
        Assert.assertNotNull(britneySpears.getMaintenance());
        Assert.assertNotNull(britneySpears.getStorage());
        Assert.assertNotNull(britneySpears.getLineManagement().getAll_blueprints());

        //initialization done
        //simulates machine breakdown

        britneySpears.addMaterial("words",1,1);
        britneySpears.addMaterial("melody",100,1);
        britneySpears.createLine(song,1);
        britneySpears.createLine(album,1);
        britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).setFunctionality(false);
        britneySpears.getEventCreator().pushEvent(new Event("neni mu nic",String.valueOf(britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).getSerialNumber()),2));
        britneySpears.work(einstein);
       // Assert.assertFalse(britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).is_functional());
        Assert.assertTrue(checkrep(britneySpears.getMaintenance().getMaintainers()));
        britneySpears.work(einstein);

        //Assert.assertTrue(britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).is_functional());
        //Assert.assertTrue(britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).is_functional());
        britneySpears.createLine(song,2);
       // britneySpears.createLine(song,3);
        for(int i =2;i<100;i++){
            if(i==5){
                //britneySpears.createLine(song,4);
                //britneySpears.createLine(song,5);
                //britneySpears.createLine(song,6);
            }
            britneySpears.work(einstein);

        }
        britneySpears.generateReport("Events",0,0);
        britneySpears.generateReport("Events",1,1);
        britneySpears.generateReport("Events",0,1);
        britneySpears.generateReport("Outtages",0,99);

    }

    private boolean checkrep(Maintainer [] ar){
        for(Maintainer m: ar){
            if(m.getAvailableIn()>0){
                return true;
            }
        }
        return false;
    }

}
