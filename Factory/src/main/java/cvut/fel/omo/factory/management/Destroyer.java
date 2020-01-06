package cvut.fel.omo.factory.management;

 abstract class Destroyer {

    protected int mayDestroy(){
        if(((int)(30.0 * Math.random()))==1){
            // create event severity 2
            return 0;
        }
        if(((int)(75.0 * Math.random()))==1){
            return 0;
        }
        if(((int)(250.0 * Math.random()))==1){
            return 0;
        }
        return 1;
    }
}
