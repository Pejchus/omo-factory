package cvut.fel.omo.factory;

public class Time {
    int tact;
    private static Time obj;
    private Time(){}

    public static Time getInstance(){
        if(obj == null) {
            obj = new Time();
            obj.tact = 0;
        }
        return obj;
    }

}
