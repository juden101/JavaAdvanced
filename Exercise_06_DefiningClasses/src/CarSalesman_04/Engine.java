package CarSalesman_04;

public class Engine {
    private String model;
    private int power;
    private int displacements;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacements = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacements) {
        this(model, power);
        this.displacements = displacements;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacements, String efficiency) {
        this(model, power);
        this.displacements = displacements;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacements() {
        return displacements;
    }

    public void setDisplacements(int displacements) {
        this.displacements = displacements;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
