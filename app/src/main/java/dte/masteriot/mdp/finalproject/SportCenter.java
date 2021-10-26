package dte.masteriot.mdp.finalproject;

public class SportCenter {
    private String name;
    private String district;
    private String cp;

    SportCenter(String name, String district, String cp) {
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

    public String getCp() {
        return cp;
    }
}