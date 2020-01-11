package cvut.fel.omo.factory.events;


import org.junit.Assert;
import org.junit.Test;

public class EventCreatrorTest {




        @Test
        public void QueueInCorrectOrderByPriority() {
            EventCreator buh = new EventCreator(0);
            Event[] evs = new Event[5];
            for(int i=0;i<5;i++){
                evs[i]= new Event("StepanJeDement","DuroToRikal",i);
                buh.pushEvent(evs[i]);
            }
            int k=4;
            for(int i= 0; i<5;i++){
                Event control =buh.getEvents().remove();
                Assert.assertEquals(control,evs[k]);
                Assert.assertEquals(control.getPriority(),k);
                k--;
            }
        }

    @Test
    public void QueueInCorrectOrderByTact() {
        EventCreator buh = new EventCreator(0);
        Event e1 = new Event("StepanJeDement","DuroToRikal",1);
        Event e2 = new Event("SlovenskoNeexistuje","SputnikNews",1);
        buh.pushEvent(e1);
        buh.updateTact();
        buh.pushEvent(e2);
        Assert.assertEquals(buh.getEvents().remove(),e1);
        buh.updateTact();
        buh.pushEvent(e1);
        Assert.assertEquals(buh.getEvents().remove(),e2);
        Assert.assertEquals(buh.getEvents().remove(),e1);
    }
}

