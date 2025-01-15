public class PlantLogic {
    private Plant[] plants;

    public PlantLogic(Layout layout) {
        Plant plant = new Plant(Plant.identify());
        //Layout layout = new Layout(plant.getName());
        System.out.println(plant.getName());
        layout.setPlantName(plant.getName());
    }
}
