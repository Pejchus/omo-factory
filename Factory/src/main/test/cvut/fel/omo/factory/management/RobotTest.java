package cvut.fel.omo.factory.management;
import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;
import org.junit.Assert;
import org.junit.Test;

public class RobotTest {

    @Test
    public void RunOutOfOilTest() {
        EventCreator e = new EventCreator(0);
        Storage s = new Storage(e);
        Robot r = new Robot(100, 20,e);
        r.functionalityCheck(s);
        Event expected = new Event("run out of oil",r.toString(),1);
        Event result = e.getEvents().remove();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getSource(),expected.getSource());
        Assert.assertEquals(result.getPriority(),expected.getPriority());
    }
}

