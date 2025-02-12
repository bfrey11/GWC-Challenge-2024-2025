import java.util.HashMap;

public class Plant {
    private String[] benefits;
    private int water; //inches per day
    private int sun; //hours per day
    private int harm;
    private boolean healthy;
    private int sustain; //sustainability
    private String name;
    private String soil;
    private String[] pollen; //pollinators
    private String[] info;

    public Plant(String name, HashMap<String,String[]> dataMap) {
        this.name = name;
        info = dataMap.get("Tomatoes");
        System.out.println(info[2]);
    }

    public String[] getInfo() {
        return info;
    }

    //would use AI to identify plant
    public static String identify() {
        String plant = "plant";
        return plant;
    }

    public String getName() {return name;}
}
