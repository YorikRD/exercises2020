package com.Exercises06.pack.task1;

public class Mountain {
    private String mName;
    private String mCountry;
    private int height;
    static String[] countries ={"Austrian Empire","Mongolia","Bulgaria","Qatar", "Russia"};
    static String[] mNames ={"Everest","Elbrus","Peak of Mars","Vesuvius", "Cilimonjaro"};

    public Mountain(String mName, String mCountry, int height) {
        setmName(mName);
        setmCountry(mCountry);
        setHeight(height);
    }


    public Mountain() {
        this.mName = mNames[(int)(Math.random()*mNames.length)];
        this.mCountry=countries[(int)(Math.random()*countries.length)];
        this.height=(int)(Math.random()*800)+100;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        if (mName.length()<4) throw new IllegalArgumentException("mName must be longer then 3 symbols") ;
        this.mName = mName;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
      if (mCountry.length()<4) throw new IllegalArgumentException("mCountry must be longer then 3 symbols") ;
        this.mCountry = mCountry;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height<100) throw new IllegalArgumentException("height must be greater then 100 metres") ;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "mName='" + mName + '\'' +
                ", mCountry='" + mCountry + '\'' +
                ", height=" + height +
                '}';
    }
}
