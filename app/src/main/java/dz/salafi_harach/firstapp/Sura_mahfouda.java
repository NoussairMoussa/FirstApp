package dz.salafi_harach.firstapp;

public class Sura_mahfouda {

    private Sura sura;
    private int isMahfoud;
    private int ayaDeb;
    private int ayaFin;
    private double nbrAthman_m;
    private double nbrArbaa_m;
    private int nbrPage_m;

    public Sura_mahfouda()
    {
    }

    public Sura_mahfouda(Sura sura, int isMahfoud, int ayaDeb, int ayaFin, double nbrAthman_m, double nbrArbaa_m, int nbrPage_m)
    {
        this.sura = sura;
        this.isMahfoud = isMahfoud;
        this.ayaDeb = ayaDeb;
        this.ayaFin = ayaFin;
        this.nbrAthman_m = nbrAthman_m;
        this.nbrArbaa_m = nbrArbaa_m;
        this.nbrPage_m = nbrPage_m;
    }


    public int getIsMahfoud() {
        return isMahfoud;
    }

    public void setIsMahfoud(int isMahfoud) {
        this.isMahfoud = isMahfoud;
    }

    public int getAyaDeb() {
        return ayaDeb;
    }

    public void setAyaDeb(int ayaDeb) {
        this.ayaDeb = ayaDeb;
    }

    public int getAyaFin() {
        return ayaFin;
    }

    public void setAyaFin(int ayaFin) {
        this.ayaFin = ayaFin;
    }

    public double getNbrAthman_m() {
        return nbrAthman_m;
    }

    public void setNbrAthman_m(double nbrAthman_m) {
        this.nbrAthman_m = nbrAthman_m;
    }

    public double getNbrArbaa_m() {
        return nbrArbaa_m;
    }

    public void setNbrArbaa_m(double nbrArbaa_m) {
        this.nbrArbaa_m = nbrArbaa_m;
    }

    public int getNbrPage_m() {
        return nbrPage_m;
    }

    public void setNbrPage_m(int nbrPage_m) {
        this.nbrPage_m = nbrPage_m;
    }


    public Sura getSura() {
        return sura;
    }

    public void setSura(Sura sura) {
        this.sura = sura;
    }

    @Override
    public String toString()
    {
        return sura.toString() + createRowOfSura(this);
    }

    private String createRowOfSura(Sura_mahfouda sura_mahfouda)
    {
        String s = "";
        if(sura_mahfouda.getNbrPage_m() != 0)
            s += sura_mahfouda.getNbrPage_m() + " صفحــة ";
        else if(sura_mahfouda.getNbrArbaa_m() != 0)
        {
            if(sura_mahfouda.getNbrArbaa_m() == 1)
                s += " ربع ";
            else if(sura_mahfouda.getNbrArbaa_m() == 2)
                s += sura_mahfouda.getNbrArbaa_m() + " ربعان ";
            else if(sura_mahfouda.getNbrArbaa_m() > 2 && sura_mahfouda.getNbrArbaa_m() <= 10)
                s += sura_mahfouda.getNbrArbaa_m() + " أرباع ";
            else if(sura_mahfouda.getNbrArbaa_m() > 10)
                s += sura_mahfouda.getNbrArbaa_m() + " ربع ";
        }
        else if(sura_mahfouda.getNbrAthman_m() != 0)
        {
            if(sura_mahfouda.getNbrAthman_m() == 1)
                s += " ثمن ";
            else if(sura_mahfouda.getNbrAthman_m() == 2)
                s += " ثمنان ";
            else if(sura_mahfouda.getNbrAthman_m() > 2 && sura_mahfouda.getNbrAthman_m() <= 10)
                s += sura_mahfouda.getNbrAthman_m() + " أثمان ";
            else if(sura_mahfouda.getNbrAthman_m() > 10)
                s += sura_mahfouda.getNbrAthman_m() + " ثمن ";
        }
        else if(sura_mahfouda.getAyaDeb() != 0)
        {
            int nbrOfAyat = sura_mahfouda.getAyaFin() - sura_mahfouda.getAyaDeb();

            if(nbrOfAyat == 1)
                s += " آيـــة ";
            else if(nbrOfAyat == 2)
                s += " آيتــــان ";
            else if(nbrOfAyat > 2 && nbrOfAyat <= 10)
                s += nbrOfAyat + " آيــــات ";
            else if(nbrOfAyat > 10)
                s += nbrOfAyat + " آيــــة ";
        }
        return s;
    }
}
