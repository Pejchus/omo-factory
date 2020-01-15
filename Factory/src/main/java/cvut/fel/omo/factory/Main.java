package cvut.fel.omo.factory;

import cvut.fel.omo.factory.management.Blueprint;

public class Main {
    public static void main(String args[]){
        Time time = Time.getInstance();

        Factory factory = new Factory(time);
        factory.addMaterial("metal",10,500);
        String[] materials = {"metal", "wood"};
        int[] numMaterials = {20,10};
        Blueprint b = new Blueprint("RRMPPMR",materials, numMaterials,10);
        factory.addBlueprint(b);
        factory.createLine(b,1);
        factory.work(time);

    }
}
