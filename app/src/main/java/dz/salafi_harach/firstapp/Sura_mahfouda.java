package dz.salafi_harach.firstapp;

import java.text.SimpleDateFormat;

public class Sura_mahfouda {

    private Sura sura;
    private int isMahfoud;
    private int ayaDeb;
    private int ayaFin;
    private double nbrAthman_m;
    private double nbrArbaa_m;
    private int nbrPage_m;
    private long dateOfInsert;

    public Sura_mahfouda(){}

    public Sura_mahfouda(Sura sura, int isMahfoud, int ayaDeb, int ayaFin, double nbrAthman_m, double nbrArbaa_m, int nbrPage_m, long dateOfInsert)
    {
        this.sura = sura;
        this.isMahfoud = isMahfoud;
        this.ayaDeb = ayaDeb;
        this.ayaFin = ayaFin;
        this.nbrAthman_m = nbrAthman_m;
        this.nbrArbaa_m = nbrArbaa_m;
        this.nbrPage_m = nbrPage_m;
        this.dateOfInsert = dateOfInsert;
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
        SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/MMM/yyyy");
        String date = dateFormat.format(getDateOfInsert());

        return sura.toString() + " " ;//+ String.valueOf(new Date().getTime() - getDateOfInsert());
    }

    public String createRowOfSura()
    {
        String s = "";
        if(isMahfoud == 1)
        {
            if(getNbrPage_m() != 0)
            {
                if(getNbrPage_m() > 10)
                    s += getNbrPage_m() + " صفحــة ";
                else if(getNbrPage_m() <= 10 && getNbrPage_m() > 2)
                    s += getNbrPage_m() + " صفحــات ";
                else if(getNbrPage_m() == 2)
                    s +=  " صفحتـــان ";
                else
                    s += " صفحــة ";
            }
            else if(getNbrArbaa_m() != 0)
            {
                if(getNbrArbaa_m() == 1)
                    s += " ربع ";
                else if(getNbrArbaa_m() == 2)
                    s += getNbrArbaa_m() + " ربعان ";
                else if(getNbrArbaa_m() > 2 && getNbrArbaa_m() <= 10)
                    s += getNbrArbaa_m() + " أرباع ";
                else if(getNbrArbaa_m() > 10)
                    s += getNbrArbaa_m() + " ربع ";
            }
            else if(getNbrAthman_m() != 0)
            {
                if(getNbrAthman_m() == 1)
                    s += " ثمن ";
                else if(getNbrAthman_m() == 2)
                    s += " ثمنان ";
                else if(getNbrAthman_m() > 2 && getNbrAthman_m() <= 10)
                    s += getNbrAthman_m() + " أثمان ";
                else if(getNbrAthman_m() > 10)
                    s += getNbrAthman_m() + " ثمن ";
            }
            else if(getAyaDeb() != 0)
            {
                int nbrOfAyat = getAyaFin() - getAyaDeb() + 1;

                if(nbrOfAyat == 1)
                    s += " آيـــة ";
                else if(nbrOfAyat == 2)
                    s += " آيتــــان ";
                else if(nbrOfAyat > 2 && nbrOfAyat <= 10)
                    s += nbrOfAyat + " آيــــات ";
                else if(nbrOfAyat > 10)
                    s += nbrOfAyat + " آيــــة ";
            }
            else
                s = "كــاملة";
        }
        return s;
    }

    public long getDateOfInsert() {
        return dateOfInsert;
    }

    public void setDateOfInsert(long dateOfInsert) {
        this.dateOfInsert = dateOfInsert;
    }
}
