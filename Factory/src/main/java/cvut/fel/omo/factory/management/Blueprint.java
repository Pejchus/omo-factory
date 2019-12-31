package cvut.fel.omo.factory.management;

public class Blueprint {
    private String configuration;
    private String materials;
    private int productCost;
    private int value;

    public Blueprint(String configuration, String materials, int productCost, int value){
        this.configuration = configuration;
        this.materials = materials;
        this.productCost = productCost;
        this.value = value;
    }

    public String getConfiguration(){ return this.configuration;}
    public String getMaterials(){ return this.materials;}
    public int getProductCost(){return  this.productCost;}
    public int getValue(){return this.value;}
}