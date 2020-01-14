package cvut.fel.omo.factory.finance;

import java.util.HashMap;

public class Finance {
    private int budget;

    private HashMap<String, Integer> materialsCost;

    public Finance(int budget) {
        this.budget = budget;
        this.materialsCost = new HashMap<String, Integer>();
    }

    public void addMaterial(String material, int cost) {
        this.materialsCost.put(material,cost);
    }
    public void removeMaterial(String material) {
        this.materialsCost.remove(material);
    }
    public void pay(int amount){
        budget-=amount;
    }
    public void profit(int amount){
        budget+=amount;
    }
    /*public void purchaseMaterial(Material material, int amount) {
        budget -= (materialsCost.get(material)*amount);
    }
    public void sellMaterial(String material, int amount){

    }*/
}
