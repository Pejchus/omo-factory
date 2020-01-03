package cvut.fel.omo.factory.management;

import java.util.*;
public class Storage {
    private HashMap<String, Integer> storageContents;
    private Stack<Robot> robotStack;

    public Storage(String[] materials){
        robotStack = new Stack<Robot>();
        //TODO Discuss how many spare robots should be in storage
        for(int i=0;i<10;i++){robotStack.add(new Robot(0,100));}
        for (String m: materials) {
            this.storageContents.put(m,300);
        }
    }

    public HashMap<String, Integer> getStorageContents(){
        return this.storageContents;
    }

    public String getMaterial(String material){
        return material + storageContents.get(material);
    }

    public int numRobot(){
        if(!robotStack.empty()){return robotStack.size();}
        return 0;
    }

    public Robot getRobot(){
        return robotStack.pop();
    }

    public void returnRobot(Robot robot){
        robotStack.push(robot);
    }
}
