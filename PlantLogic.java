import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PlantLogic {
    private HashMap<String,String[]> dataMap;

    public PlantLogic(Layout layout) {
        dataMap = new HashMap<>();
        makeHash();
        layout.setPlantName("Tomatoes");
        layout.setInfo(dataMap.get("Tomatoes"));
    }

    public void makeHash() {
        try {
            Scanner scanner = new Scanner(new File("data.txt"));
            while(scanner.hasNext()) {
                parse(scanner.nextLine());
            }
            System.out.println(dataMap);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public void parse(String line) {
        System.out.println(line);
        String[] data = new String[8];
        String name = line.substring(0,line.indexOf(" "));
        line = line.substring(line.indexOf(" ")+1);
        for(int i=0; i<7; i++) {
            data[i] = line.substring(0,line.indexOf(" "));
            line = line.substring(line.indexOf(" ")+1);
        }
        data[7] = line;
        dataMap.put(name,data);
    }
}
