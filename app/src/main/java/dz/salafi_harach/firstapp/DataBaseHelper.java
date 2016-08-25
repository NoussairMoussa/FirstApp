package dz.salafi_harach.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Wael";
    public static final int DATABASE_VERSION = 9;
/*
    "suraNumber INTEGER PRIMARY KEY, " +
            "   pageNum INTEGER, " +
            "   nbrOfPages INTEGER, " +
            "   nbrArbaa REAL, " +
            "   nbrAthman REAL, " +
            "   juz INTEGER, " +
            "   numberOfAyat INTEGER, " +
            "   type INTEGER, " +
            "   suraName TEXT, " +
            "   isMahfoud INTEGER, " +
            "   ayaDeb INTEGER, " +
            "   ayaFin INTEGER, " +
            "   nbrAthman_m REAL, " +
            "   nbrArbaa_m REAL, " +
            "   nbrPage_m REAL "
    */
    public static final String SURANUMBER = "suraNumber";
    public static final String PAGENUM = "pageNum";
    public static final String NBROFPAGES = "nbrOfPages";
    public static final String NBRARBAA = "nbrArbaa";
    public static final String NBRATHMAN = "nbrAthman";
    public static final String JUZ = "juz";
    public static final String NBROFAYAT = "numberOfAyat";
    public static final String TYPE = "type";
    public static final String SURANAME = "suraName";
    public static final String ISMAHFOUD = "isMahfoud";
    public static final String AYADEB = "ayaDeb";
    public static final String AYAFIN = "ayaFin";
    public static final String NBRATHMAN_M = "nbrAthman";
    public static final String NBRARBAA_M = "nbrArbaa_m";
    public static final String NBRPAGE_M = "nbrPage_m";

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String rqt = "CREATE TABLE Sura "
                + "( "
                +  "suraNumber INTEGER PRIMARY KEY, " +
                "   pageNum INTEGER, " +
                "   nbrOfPages INTEGER, " +
                "   nbrArbaa REAL, " +
                "   nbrAthman REAL, " +
                "   juz INTEGER, " +
                "   numberOfAyat INTEGER, " +
                "   type INTEGER, " +
                "   suraName TEXT, " +
                "   isMahfoud INTEGER, " +
                "   ayaDeb INTEGER, " +
                "   ayaFin INTEGER, " +
                "   nbrAthman_m REAL, " +
                "   nbrArbaa_m REAL, " +
                "   nbrPage_m REAL "
                + " )";
        db.execSQL(rqt);

        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (1,1,0,0,0,1,7,0,'الفاتحة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (2,2,0,0,0,1,286,1,'البقرة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (3,50,0,0,0,3,200,1,'ال عمران',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (4,77,0,0,0,4,176,1,'النساء',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (5,106,0,0,0,6,120,1,'المائدة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (6,128,0,0,0,7,165,0,'الانعام',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (7,151,0,0,0,8,206,0,'الاعراف',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (8,177,0,0,0,9,75,1,'الانفال',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (9,187,0,0,0,10,129,1,'التوبة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (10,208,0,0,0,11,109,0,'يونس',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (11,221,0,0,0,11,123,0,'هود',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (12,235,0,0,0,12,111,0,'يوسف',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (13,249,0,0,0,13,43,1,'الرعد',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (14,255,0,0,0,13,52,1,'ابراهيم',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (15,262,0,0,0,14,99,0,'الحجر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (16,267,0,0,0,14,128,0,'النحل',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (17,282,0,0,0,15,111,0,'الاسراء',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (18,293,0,0,0,15,110,0,'الكهف',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (19,305,0,0,0,16,98,0,'مريم',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (20,312,0,0,0,16,135,0,'طه',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (21,322,0,0,0,17,112,0,'الانبياء',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (22,332,0,0,0,17,78,0,'الحج',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (23,342,0,0,0,18,118,0,'المؤمنون',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (24,350,0,0,0,18,64,1,'النور',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (25,359,0,0,0,18,77,0,'الفرقان',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (26,367,0,0,0,19,227,0,'الشعراء',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (27,377,0,0,0,19,93,0,'النمل',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (28,385,0,0,0,20,88,0,'القصص',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (29,396,0,0,0,20,69,0,'العنكبوت',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (30,404,0,0,0,21,60,0,'الروم',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (31,411,0,0,0,21,34,0,'لقمان',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (32,415,0,0,0,21,30,0,'السجدة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (33,418,0,0,0,21,73,1,'الاحزاب',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (34,428,0,0,0,22,54,0,'سبأ',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (35,434,0,0,0,22,45,0,'فاطر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (36,440,0,0,0,22,83,0,'يس',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (37,446,0,0,0,23,182,0,'الصافات',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (38,453,0,0,0,23,88,0,'ص',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (39,458,0,0,0,23,75,0,'الزمر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (40,467,0,0,0,24,85,0,'غافر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (41,477,0,0,0,24,54,0,'فصلت',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (42,483,0,0,0,25,53,0,'الشورى',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (43,489,0,0,0,25,89,0,'الزخرف',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (44,496,0,0,0,25,59,0,'الدخان',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (45,499,0,0,0,25,37,0,'الجاثية',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (46,502,0,0,0,26,35,0,'الاحقاف',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (47,507,0,0,0,26,38,1,'محمد',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (48,511,0,0,0,26,29,1,'الفتح',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (49,515,0,0,0,26,18,1,'الحجرات',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (50,518,0,0,0,26,45,0,'ق',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (51,520,0,0,0,26,60,0,'الذاريات',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (52,523,0,0,0,27,49,0,'الطور',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (53,526,0,0,0,27,62,0,'النجم',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (54,528,0,0,0,27,55,0,'القمر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (55,531,0,0,0,27,78,1,'الرحمن',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (56,534,0,0,0,27,96,0,'الواقعة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (57,537,0,0,0,27,29,1,'الحديد',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (58,542,0,0,0,28,22,1,'المجادلة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (59,545,0,0,0,28,24,1,'الحشر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (60,549,0,0,0,28,13,1,'الممتحنة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (61,551,0,0,0,28,14,1,'الصف',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (62,553,0,0,0,28,11,1,'الجمعة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (63,554,0,0,0,28,11,1,'المنافقون',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (64,556,0,0,0,28,18,1,'التغابن',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (65,558,0,0,0,28,12,1,'الطلاق',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (66,560,0,0,0,28,12,1,'التحريم',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (67,562,0,0,0,29,30,0,'الملك',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (68,564,0,0,0,29,52,0,'القلم',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (69,566,0,0,0,29,52,0,'الحاقة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (70,568,0,0,0,29,44,0,'المعارج',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (71,570,0,0,0,29,28,0,'نوح',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (72,572,0,0,0,29,28,0,'الجن',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (73,574,0,0,0,29,20,0,'المزمل',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (74,575,0,0,0,29,56,0,'المدثر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (75,577,0,0,0,29,40,0,'القيامة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (76,578,0,0,0,29,31,0,'الانسان',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (77,580,0,0,0,29,50,0,'المرسلات',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (78,582,0,0,0,30,40,0,'النبأ',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (79,583,0,0,0,30,46,0,'النازعات',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (80,585,0,0,0,30,42,0,'عبس',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (81,586,0,0,0,30,29,0,'التكوير',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (82,587,0,0,0,30,19,0,'الانفطار',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (83,587,0,0,0,30,36,0,'المطففين',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (84,589,0,0,0,30,25,0,'الانشقاق',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (85,590,0,0,0,30,22,0,'البروج',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (86,591,0,0,0,30,17,0,'الطارق',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (87,591,0,0,0,30,19,0,'الاعلى',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (88,592,0,0,0,30,26,0,'الغاشية',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (89,593,0,0,0,30,30,0,'الفجر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (90,594,0,0,0,30,20,0,'البلد',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (91,595,0,0,0,30,15,0,'الشمس',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (92,595,0,0,0,30,21,0,'الليل',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (93,596,0,0,0,30,11,0,'الضحى',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (94,596,0,0,0,30,8,0,'الشرح',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (95,597,0,0,0,30,8,0,'التين',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (96,597,0,0,0,30,19,0,'العلق',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (97,598,0,0,0,30,5,0,'القدر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (98,598,0,0,0,30,8,1,'البينة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (99,599,0,0,0,30,8,1,'الزلزلة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (100,599,0,0,0,30,11,0,'العاديات',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (101,600,0,0,0,30,11,0,'القارعة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (102,600,0,0,0,30,8,0,'التكاثر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (103,601,0,0,0,30,3,0,'العصر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (104,601,0,0,0,30,9,0,'الهمزة',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (105,601,0,0,0,30,5,0,'الفيل',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (106,602,0,0,0,30,4,0,'قريش',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (107,602,0,0,0,30,7,0,'الماعون',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (108,602,0,0,0,30,3,0,'الكوثر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (109,603,0,0,0,30,6,0,'الكافرون',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (110,603,0,0,0,30,3,0,'النصر',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (111,603,0,0,0,30,5,0,'المسد',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (112,604,0,0,0,30,4,0,'الاخلاص',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (113,604,0,0,0,30,5,0,'الفلق',0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m) VALUES (114,604,0,0,0,30,6,0,'الناس',0,0,0,0,0,0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + WaelContract.Quran_tab.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + WaelContract.Moutoun_tab.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS Sura");
        onCreate(db);
    }

    public int addQuran(int suraNum, int nbrOfPages, int ayaDeb, int ayaFin, double nbrArbaa, double nbrAthman)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues v = new ContentValues();

        v.put(ISMAHFOUD, 1);
        v.put(NBRARBAA_M, nbrArbaa);
        v.put(NBRATHMAN_M, nbrAthman);
        v.put(NBRPAGE_M, nbrOfPages);
        v.put(AYADEB, ayaDeb);
        v.put(AYAFIN, ayaFin);


        int rowUpdate = db.update("Sura", v, SURANUMBER + "=?", new String[]{String.valueOf(suraNum)});

        db.close();
        return rowUpdate;
    }

    public String getElement(long suraNumber, String elm)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c;

        c = db.query(
                "Sura",  // The table to query
                null,                               // The columns to return
                SURANUMBER + "=?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(suraNumber)},        // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        String string = null;

        if (c.getCount() > 0)
        {
            do
            {
                string = c.getString(c.getColumnIndex(elm));
            } while (c.moveToNext());
        }
        return string;
    }

    public ArrayList<Sura_mahfouda> getAllQuran()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c;

        c = db.query(
                "Sura",  // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        Sura s;
        Sura_mahfouda s_m;
        ArrayList<Sura_mahfouda> listQuran = new ArrayList<>();
        if (c.getCount() > 0)
        {
            do
            {
                //listQuran.add(QuranFromDb);
                s = new Sura(Integer.parseInt(c.getString(c.getColumnIndex(SURANUMBER))),
                        c.getString(c.getColumnIndex(SURANAME)),
                        Integer.parseInt(c.getString(c.getColumnIndex(NBROFAYAT))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRARBAA))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRATHMAN))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBROFPAGES))),
                        Integer.parseInt(c.getString(c.getColumnIndex(PAGENUM))),
                        Integer.parseInt(c.getString(c.getColumnIndex(JUZ))),
                        Boolean.parseBoolean((c.getString(c.getColumnIndex(TYPE)))) ? type.MADANIYA: type.MAKIYAH);

                s_m = new Sura_mahfouda(s,
                        Integer.parseInt(c.getString(c.getColumnIndex(ISMAHFOUD))),
                        Integer.parseInt(c.getString(c.getColumnIndex(AYADEB))),
                        Integer.parseInt(c.getString(c.getColumnIndex(AYAFIN))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRATHMAN_M))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRARBAA_M))),
                        Integer.parseInt(c.getString(c.getColumnIndex(NBRPAGE_M))));

                listQuran.add(s_m);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return listQuran;
    }

    public ArrayList<Sura_mahfouda> getAllSuraMahfouda()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c;

        c = db.query(
                "Sura",  // The table to query
                null,                               // The columns to return
                ISMAHFOUD + "=?",                                // The columns for the WHERE clause
                new String[]{"1"},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        Sura s;
        Sura_mahfouda s_m;
        ArrayList<Sura_mahfouda> listQuran = new ArrayList<>();
        if (c.getCount() > 0)
        {
            do
            {
                //listQuran.add(QuranFromDb);
                s = new Sura(Integer.parseInt(c.getString(c.getColumnIndex(SURANUMBER))),
                        c.getString(c.getColumnIndex(SURANAME)),
                        Integer.parseInt(c.getString(c.getColumnIndex(NBROFAYAT))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRARBAA))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRATHMAN))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBROFPAGES))),
                        Integer.parseInt(c.getString(c.getColumnIndex(PAGENUM))),
                        Integer.parseInt(c.getString(c.getColumnIndex(JUZ))),
                        Boolean.parseBoolean((c.getString(c.getColumnIndex(TYPE)))) ? type.MADANIYA: type.MAKIYAH);

                s_m = new Sura_mahfouda(s,
                        Integer.parseInt(c.getString(c.getColumnIndex(ISMAHFOUD))),
                        Integer.parseInt(c.getString(c.getColumnIndex(AYADEB))),
                        Integer.parseInt(c.getString(c.getColumnIndex(AYAFIN))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRATHMAN_M))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRARBAA_M))),
                        Integer.parseInt(c.getString(c.getColumnIndex(NBRPAGE_M))));

                listQuran.add(s_m);
            } while (c.moveToNext());
        }
        c.close();
        return listQuran;
    }

    public int getNumberOfAya(int suraNum)
    {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(
                "Sura",  // The table to query
                new String[]{NBROFAYAT},         // The columns to return
                SURANUMBER + "=?",                            // The columns for the WHERE clause
                new String[]{String.valueOf(suraNum)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        int nbrOfAyat = 0;
        if (c.getCount() > 0)
        {
            do {
                nbrOfAyat = Integer.parseInt(c.getString(0));
            }while (c.moveToNext());
        }
        c.close();
        return nbrOfAyat;
    }

}















