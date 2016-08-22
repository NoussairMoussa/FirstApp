package dz.salafi_harach.firstapp;

public class Sura {

    private int suraNum;
    private String name;
    private int nbrOfAyat;
    private double nbrOfArbaa;
    private double nbrOfAthman;
    private double nbrOfPages;
    private int pageNum;
    private int juz;
    private type type;

    /**
     * type of sura is enum to define either makiya or madaniya
     */
    public Sura(){}

    public Sura(int suraNum, String name, int nbrOfAyat, double nbrOfArbaa, double nbrOfAthman, double nbrOfPages, int pageNum, int juz, type type)
    {
        this.suraNum = suraNum;
        this.name = name;
        this.nbrOfAyat = nbrOfAyat;
        this.nbrOfArbaa = nbrOfArbaa;
        this.nbrOfAthman = nbrOfAthman;
        this.nbrOfPages = nbrOfPages;
        this.pageNum = pageNum;
        this.juz = juz;
        this.type = type;
    }

    public int getSuraNum()
    {
        return suraNum;
    }

    public void setSuraNum(int suraNum)
    {
        this.suraNum = suraNum;
    }

    public int getJuz()
    {
        return juz;
    }

    public void setJuz(int juz)
    {
        this.juz = juz;
    }

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    public double getNbrOfPages()
    {
        return nbrOfPages;
    }

    public void setNbrOfPages(double nbrOfPages)
    {
        this.nbrOfPages = nbrOfPages;
    }

    public double getNbrOfArbaa()
    {
        return nbrOfArbaa;
    }

    public void setNbrOfArbaa(double nbrOfArbaa)
    {
        this.nbrOfArbaa = nbrOfArbaa;
    }

    public int getNbrOfAyat()
    {
        return nbrOfAyat;
    }

    public void setNbrOfAyat(int nbrOfAyat)
    {
        this.nbrOfAyat = nbrOfAyat;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getNbrOfAthman()
    {
        return nbrOfAthman;
    }

    public void setNbrOfAthman(double nbrOfAthman)
    {
        this.nbrOfAthman = nbrOfAthman;
    }

    public type getType()
    {
        return type;
    }

    public void setType(type type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return suraNum + ": سورة " + name + " ";
    }
}
