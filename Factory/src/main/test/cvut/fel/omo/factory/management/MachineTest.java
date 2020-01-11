package cvut.fel.omo.factory.management;
import cvut.fel.omo.factory.events.EventCreator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class MachineTest {

    @Test
    public void mayDestroyTest() {
        Machine m = new Machine(100, new EventCreator(0));
        //next tests does not necessarily work but high propability says they should
        m.setOil(1000);
        m.functionalityCheck();//calls maydestroy
        Assert.assertTrue(m.is_functional());
        for(int i = 0; i<100;i++){
            m.functionalityCheck();
        }
        Assert.assertFalse(m.is_functional());
    }
}
