package cvut.fel.omo.factory.management;

public class Blueprint {
    private String configuration;
    private String[] materials;
    private int[] numMaterial;
    private int value;

    public Blueprint(String configuration, String[] materials,int[] numMaterial, int value){
        this.configuration = configuration;
        this.materials = materials;
        this.numMaterial = numMaterial;
        this.value = value;
    }

    public String getConfiguration(){ return this.configuration;}
    public String[] getMaterials(){ return this.materials;}
    public int[] getNumMaterial(){return  this.numMaterial;}
    public int getValue(){return this.value;}
}
