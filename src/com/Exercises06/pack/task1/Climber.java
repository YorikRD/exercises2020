package com.Exercises06.pack.task1;

public class Climber {

    private String name;
    private String adress;
    static String[] names ={"Petr","Julia","Pavel","Michael","John","Syao","Olga","Marta"};
    static String[] countries ={"3427 Hamilton Ave","1903 N Mill St","214 44th St W","250 Autumn Way", "319 N I St"};

    public Climber(String name, String adress) {
        setName(name);
        setAdress(adress);
    }

    public Climber() {
        this.name = names[(int)(Math.random()*names.length)];
        this.adress =countries[(int)(Math.random()*countries.length)];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()<4) throw new IllegalArgumentException("name must be longer then 3");
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        if (name.length()<6) throw new IllegalArgumentException("Adress must be longer then 5");
        this.adress = adress;
    }

    public static String[] getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "Сlimber{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
