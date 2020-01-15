package cvut.fel.omo.factory;

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.management.Blueprint;
import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void youBetterWorkBitch(){
        Time einstein = Time.getInstance();
        Factory britneySpears = new Factory(einstein);
        String[] materials = {"words", "melody"};
        int[] numMaterials = {100,2};
        Blueprint song = new Blueprint("SongWriting",materials, numMaterials,10000);
        britneySpears.addBlueprint(song);
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
        britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).setFunctionality(false);
        britneySpears.getEventCreator().pushEvent(new Event("neni mu nic",String.valueOf(britneySpears.getLineManagement().getLines().get(0).getMachines().get(0).getSerialNumber()),2));
        britneySpears.work(einstein);
    }


}
