package cvut.fel.omo.factory.finance;

import java.util.HashMap;

public class Finance {
    private HashMap<String, Integer> materials;

    public Finance(String[] materials, Integer[] price){
        for (int i = 0; i<=materials.length; i++) {
            this.materials.put(materials[i], price[i]);
        }
    }

    public void purchaseMaterial(String material, Integer price){
        this.materials.put(material, price);
    }
}
