package dte.masteriot.mdp.finalproject;

public class SportCenter {
    private String name;
    private String district;
    private int cp;

    SportCenter(String name, String district, int cp) {
        this.name = name;
        this.district = district;
        this.cp = cp;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getCp() {
        return cp;
    }
}
