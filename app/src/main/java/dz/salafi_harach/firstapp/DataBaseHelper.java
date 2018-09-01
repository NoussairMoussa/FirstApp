package dz.salafi_harach.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Wael";
    public static final int DATABASE_VERSION = 1;

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
    public static final String NBRATHMAN_M = "nbrAthman_m";
    public static final String NBRARBAA_M = "nbrArbaa_m";
    public static final String NBRPAGE_M = "nbrPage_m";
    public static final String DATEOFINSERT = "date_of_insert";

    public static final String DATEOFMURAJAA = "date_of_murajaa";
    public static final String SURANUM_MURAJAA_TAB = "sura_num";

    private Context c;
    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        c = context;
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
                "   nbrPage_m REAL, " +
                "   date_of_insert INTEGER "
                + " )";
        db.execSQL(rqt);

        String rqt2 = "CREATE TABLE Sura_history "
                + "( "
                +  "sura_num INTEGER, " +
                "   date_of_murajaa INTEGER, " +
                "   CONSTRAINT suraHistory PRIMARY KEY (sura_num, date_of_murajaa) "
                + " )";
        db.execSQL(rqt2);

        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (1,1,0,0,0,1,7,0,'الفاتحة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (2,2,48,19.5,39,1,286,1,'البقرة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (3,50,27,10.5,21,3,200,1,'ال عمران',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (4,77,29,12,24,4,176,1,'النساء',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (5,106,22,8.5,17,6,120,1,'المائدة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (6,128,23,9.5,19,7,165,0,'الانعام',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (7,151,26,10,20,8,206,0,'الاعراف',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (8,177,10,4,8,9,75,1,'الانفال',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (9,187,21,8.5,17,10,129,1,'التوبة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (10,208,13,9.5,19,11,109,0,'يونس',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (11,221,14,9.5,19,11,123,0,'هود',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (12,235,14,9,18,12,111,0,'يوسف',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (13,249,6,3,6,13,43,1,'الرعد',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (14,255,7,2.5,5,13,52,1,'ابراهيم',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (15,262,5,2,4,14,99,0,'الحجر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (16,267,15,10,20,14,128,0,'النحل',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (17,282,11,8,16,15,111,0,'الاسراء',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (18,293,12,9.5,19,15,110,0,'الكهف',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (19,305,7,2.5,5,16,98,0,'مريم',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (20,312,10,4,8,16,135,0,'طه',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (21,322,10,4,8,17,112,0,'الانبياء',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (22,332,10,4,8,17,78,0,'الحج',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (23,342,8,3,6,18,118,0,'المؤمنون',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (24,350,9,4,8,18,64,1,'النور',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (25,359,8,3,6,18,77,0,'الفرقان',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (26,367,10,4,8,19,227,0,'الشعراء',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (27,377,8,3.5,7,19,93,0,'النمل',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (28,385,11,4.5,9,20,88,0,'القصص',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (29,396,8,3,6,20,69,0,'العنكبوت',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (30,404,7,2.5,5,21,60,0,'الروم',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (31,411,4,1.5,3,21,34,0,'لقمان',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (32,415,3,1,2,21,30,0,'السجدة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (33,418,10,4,8,21,73,1,'الاحزاب',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (34,428,6,2,4,22,54,0,'سبأ',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (35,434,6,3,6,22,45,0,'فاطر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (36,440,6,2,4,22,83,0,'يس',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (37,446,7,2.5,5,23,182,0,'الصافات',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (38,453,5,2,4,23,88,0,'ص',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (39,458,9,4,8,23,75,0,'الزمر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (40,467,10,4,8,24,85,0,'غافر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (41,477,6,2.5,5,24,54,0,'فصلت',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (42,483,6,2.5,5,25,53,0,'الشورى',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (43,489,7,3,6,25,89,0,'الزخرف',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (44,496,3,1,2,25,59,0,'الدخان',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (45,499,3,1.5,3,25,37,0,'الجاثية',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (46,502,5,2,4,26,35,0,'الاحقاف',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (47,507,4,1.5,3,26,38,1,'محمد',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (48,511,4,2,1.5,26,29,1,'الفتح',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (49,515,3,1,2,26,18,1,'الحجرات',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (50,518,3,1,2,26,45,0,'ق',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (51,520,2,1,2,26,60,0,'الذاريات',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (52,523,3,1,2,27,49,0,'الطور',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (53,526,3,1,2,27,62,0,'النجم',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (54,528,2,1,2,27,55,0,'القمر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (55,531,3,1,2,27,78,1,'الرحمن',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (56,534,4,1,2,27,96,0,'الواقعة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (57,537,4,2,4,27,29,1,'الحديد',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (58,542,3,1.5,3,28,22,1,'المجادلة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (59,545,4,1.5,3,28,24,1,'الحشر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (60,549,2,1,2,28,13,1,'الممتحنة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (61,551,2,0.5,1,28,14,1,'الصف',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (62,553,1,0.5,1,28,11,1,'الجمعة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (63,554,2,0.5,1,28,11,1,'المنافقون',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (64,556,2,1,2,28,18,1,'التغابن',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (65,558,2,1,2,28,12,1,'الطلاق',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (66,560,2,1,2,28,12,1,'التحريم',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (67,562,2,1,2,29,30,0,'الملك',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (68,564,2,1,2,29,52,0,'القلم',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (69,566,2,1,2,29,52,0,'الحاقة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (70,568,2,0.5,1,29,44,0,'المعارج',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (71,570,2,0.5,1,29,28,0,'نوح',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (72,572,2,1,2,29,28,0,'الجن',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (73,574,1,0.5,1,29,20,0,'المزمل',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (74,575,2,1,2,29,56,0,'المدثر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (75,577,1,0.5,1,29,40,0,'القيامة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (76,578,2,0.5,1,29,31,0,'الانسان',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (77,580,2,0.5,1,29,50,0,'المرسلات',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (78,582,1,0,1,30,40,0,'النبأ',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (79,583,2,0,1,30,46,0,'النازعات',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (80,585,1,0,1,30,42,0,'عبس',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (81,586,1,0,0,30,29,0,'التكوير',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (82,587,1,0,0,30,19,0,'الانفطار',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (83,587,1,0,1,30,36,0,'المطففين',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (84,589,1,0,0,30,25,0,'الانشقاق',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (85,590,1,0,0,30,22,0,'البروج',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (86,591,0,0,0,30,17,0,'الطارق',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (87,591,0,0,0,30,19,0,'الاعلى',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (88,592,0,0,0,30,26,0,'الغاشية',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (89,593,0,0,0,30,30,0,'الفجر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (90,594,0,0,0,30,20,0,'البلد',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (91,595,0,0,0,30,15,0,'الشمس',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (92,595,0,0,0,30,21,0,'الليل',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (93,596,0,0,0,30,11,0,'الضحى',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (94,596,0,0,0,30,8,0,'الشرح',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (95,597,0,0,0,30,8,0,'التين',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (96,597,0,0,0,30,19,0,'العلق',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (97,598,0,0,0,30,5,0,'القدر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (98,598,0,0,0,30,8,1,'البينة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (99,599,0,0,0,30,8,1,'الزلزلة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (100,599,0,0,0,30,11,0,'العاديات',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (101,600,0,0,0,30,11,0,'القارعة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (102,600,0,0,0,30,8,0,'التكاثر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (103,601,0,0,0,30,3,0,'العصر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (104,601,0,0,0,30,9,0,'الهمزة',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (105,601,0,0,0,30,5,0,'الفيل',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (106,602,0,0,0,30,4,0,'قريش',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (107,602,0,0,0,30,7,0,'الماعون',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (108,602,0,0,0,30,3,0,'الكوثر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (109,603,0,0,0,30,6,0,'الكافرون',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (110,603,0,0,0,30,3,0,'النصر',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (111,603,0,0,0,30,5,0,'المسد',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (112,604,0,0,0,30,4,0,'الاخلاص',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (113,604,0,0,0,30,5,0,'الفلق',0,0,0,0,0,0,0)");
        db.execSQL("INSERT INTO Sura (suraNumber,pageNum,nbrOfPages,nbrArbaa,nbrAthman,juz,numberOfAyat,type,suraName, isMahfoud, ayaDeb, ayaFin, nbrAthman_m, nbrArbaa_m, nbrPage_m, date_of_insert) VALUES (114,604,0,0,0,30,6,0,'الناس',0,0,0,0,0,0,0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Sura");
        db.execSQL("DROP TABLE IF EXISTS Sura_history");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Sura");
        db.execSQL("DROP TABLE IF EXISTS Sura_history");
        onCreate(db);
    }

    public int addQuran(int suraNum, int nbrOfPages, int ayaDeb, int ayaFin, double nbrArbaa, double nbrAthman)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //SimpleDateFormat dateFormat  = new SimpleDateFormat("MM/dd/yyyy");
        //String date = dateFormat.format(new Date().getTime());
        Date d = new Date();
        long date = d.getTime();

        ContentValues v = new ContentValues();

        v.put(ISMAHFOUD, 1);
        v.put(NBRARBAA_M, nbrArbaa);
        v.put(NBRATHMAN_M, nbrAthman);
        v.put(NBRPAGE_M, nbrOfPages);
        v.put(AYADEB, ayaDeb);
        v.put(AYAFIN, ayaFin);
        v.put(DATEOFINSERT, date);

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
                        Integer.parseInt(c.getString(c.getColumnIndex(NBRPAGE_M))),
                        Long.parseLong(c.getString(c.getColumnIndex(DATEOFINSERT))));

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
                        Integer.parseInt(c.getString(c.getColumnIndex(NBRPAGE_M))),
                        Long.parseLong(c.getString(c.getColumnIndex(DATEOFINSERT))));

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

    public boolean add_juz(int juz)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Date d = new Date();
        long date = d.getTime();

        ContentValues v = new ContentValues();

        v.put(ISMAHFOUD, 1);
        v.put(DATEOFINSERT, date);

        if(juz == 2)
            juz = 1;
        else if(juz == 5)
            juz = 4;

        db.update("Sura", v, JUZ + "=?", new String[]{String.valueOf(juz)});
        db.close();
        return true;
    }

    public boolean isJuzMahfoud(int juz)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        boolean juzIsMahfoud = true;

        switch (juz)
        {
            case 2: juz = 1; break;
            case 5: juz = 4; break;
        }

        c = db.query(
                "Sura",                                      // The table to query
                new String[]{ISMAHFOUD},                    // The columns to return
                JUZ + "=?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(juz)},        // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                    // The sort order
        );
        c.moveToFirst();
        String string;

        if (c.getCount() > 0)
        {
            do
            {
                string = c.getString(0);
                if(string.equals("0"))
                {
                    juzIsMahfoud = false;
                    break;
                }
            } while (c.moveToNext());
        }
        return juzIsMahfoud;
    }

    public Sura_mahfouda getSura(int sura_num)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c;

        c = db.query(
                "Sura",  // The table to query
                null,                               // The columns to return
                SURANUMBER + "=?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(sura_num)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        Sura s;
        Sura_mahfouda s_m;
        Sura_mahfouda sura_mahfouda_to_return = null;

        if (c.getCount() > 0)
        {
            do
            {
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
                        Integer.parseInt(c.getString(c.getColumnIndex(NBRPAGE_M))),
                        Long.parseLong(c.getString(c.getColumnIndex(DATEOFINSERT))));

                sura_mahfouda_to_return = s_m;
            } while (c.moveToNext());
        }
        c.close();
        return sura_mahfouda_to_return;
    }

    public Sura getSuraB(int sura_num)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c;

        c = db.query(
                "Sura",  // The table to query
                null,                               // The columns to return
                SURANUMBER + "=?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(sura_num)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        Sura s = null;

        if (c.getCount() > 0)
        {
                s = new Sura(Integer.parseInt(c.getString(c.getColumnIndex(SURANUMBER))),
                        c.getString(c.getColumnIndex(SURANAME)),
                        Integer.parseInt(c.getString(c.getColumnIndex(NBROFAYAT))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRARBAA))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBRATHMAN))),
                        Double.parseDouble(c.getString(c.getColumnIndex(NBROFPAGES))),
                        Integer.parseInt(c.getString(c.getColumnIndex(PAGENUM))),
                        Integer.parseInt(c.getString(c.getColumnIndex(JUZ))),
                        Boolean.parseBoolean((c.getString(c.getColumnIndex(TYPE)))) ? type.MADANIYA: type.MAKIYAH);
        }
        c.close();
        return s;
    }

    public boolean edit_sura(int sura_num, String elm, int val)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        if(elm == AYAFIN)
        {
            String a = this.getElement(sura_num,AYADEB);
            String b = this.getElement(sura_num,AYAFIN);

            int newAyaFin = Integer.parseInt(b) - ((Integer.parseInt(b) - Integer.parseInt(a) + 1) - val) ;

            v.put(AYAFIN, newAyaFin);
            db.update("Sura", v, SURANUMBER + "=?", new String[]{String.valueOf(sura_num)});
        }
        else
        {
            v.put(elm, val);
            db.update("Sura", v, SURANUMBER + "=?", new String[]{String.valueOf(sura_num)});
            db.close();
        }
        return true;
    }

    public boolean add_murajaa(int sura_num, int year, int month, int day)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        long date = c.getTimeInMillis();

        ContentValues v = new ContentValues();

        v.put(SURANUM_MURAJAA_TAB, sura_num);
        v.put(DATEOFMURAJAA, date);

        db.insert("Sura_history", null, v);
        v.clear();

        v.put(DATEOFINSERT, date);
        db.update("Sura", v, SURANUMBER + "=?", new String[]{String.valueOf(sura_num)});

        db.close();
        return true;
    }

    public ArrayList get_murajaa_of_sura(int sura_num)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        ArrayList dates_of_murajaa = new ArrayList();

        c = db.query(
                "Sura_history",  // The table to query
                new String[]{DATEOFMURAJAA},                               // The columns to return
                SURANUM_MURAJAA_TAB + "=?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(sura_num)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                DATEOFMURAJAA + " DESC"                                 // The sort order
        );
        c.moveToFirst();
        if (c.getCount() > 0)
        {
            do
            {
                dates_of_murajaa.add(c.getString(0));
            } while (c.moveToNext());
        }
        c.close();
        return dates_of_murajaa;
    }

    public ArrayList<Sura_mahfouda> getLastMurajaa(String sort)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        c = db.query(
                "Sura_history",  // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                DATEOFMURAJAA + " " + sort,                // The sort order
                null                   //Limit
        );

        c.moveToFirst();
        ArrayList<Sura_mahfouda> listQuran = new ArrayList<>();
        if (c.getCount() > 0)
        {
            do
            {
                int suraNum = Integer.parseInt(c.getString(0));
                Sura_mahfouda s_m = new Sura_mahfouda(getSuraB(suraNum),
                        1,
                        Integer.parseInt(getElement(suraNum,AYADEB)),
                        Integer.parseInt(getElement(suraNum,AYAFIN)),
                        Double.parseDouble(getElement(suraNum,NBRATHMAN_M)),
                        Double.parseDouble(getElement(suraNum,NBRARBAA_M)),
                        Integer.parseInt(getElement(suraNum,NBRPAGE_M)),
                        Long.parseLong(c.getString(1)));
                listQuran.add(s_m);
            } while (c.moveToNext());
        }

        c.close();
        return listQuran;
    }
}






















