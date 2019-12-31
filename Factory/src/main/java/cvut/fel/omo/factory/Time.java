package cvut.fel.omo.factory;

public class Time {
    private static Time obj;
    private Time(){}

    public static Time getInstance(){
        if(obj == null)
            obj = new Time();
        return obj;
    }

}
