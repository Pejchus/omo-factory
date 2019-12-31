package cvut.fel.omo.factory.management;

import java.util.HashMap;

public class Storage {
    private HashMap<String, Integer> storageContents;

    public Storage(String[] materials){
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
}
