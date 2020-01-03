package cvut.fel.omo.factory.management;

import java.util.*;
public class Storage {
    private HashMap<String, Integer> storageContents;
    private Stack<Robot> robotStack;

    public Storage(/*String[] materials*/){
        robotStack = new Stack<Robot>();
        storageContents = new HashMap<String, Integer>();
        //TODO Discuss how many spare robots should be in storage
        for(int i=0;i<10;i++){robotStack.add(new Robot(0,100));}
    }

    public HashMap<String, Integer> getStorageContents(){
        return this.storageContents;
    }
    /*NECHAPU TUTO FUNKCI
    public String getMaterial(String material){
        return material + storageContents.get(material);
    }*/
    public void addToStorage(String material, int amount){
        if(storageContents.containsKey(material))
            storageContents.put(material, storageContents.get(material)+amount);
        else
            storageContents.put(material,amount);
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
