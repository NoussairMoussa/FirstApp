package dz.salafi_harach.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Wael";
    private static final int DATABASE_VERSION = 2;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String rqt = "CREATE TABLE " + WaelContract.Quran_tab.TABLE_NAME
                + "( "
                + WaelContract.Quran_tab.COLUMN_ID_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WaelContract.Quran_tab.COLUMN_SOURA_NAME + " TEXT ,"
                + WaelContract.Quran_tab.COLUMN_AYA_DEB + " NUMERIC ,"
                + WaelContract.Quran_tab.COLUMN_AYA_FIN + " NUMERIC"
                + " )";

        db.execSQL(rqt);
        String rqt2 = "CREATE TABLE " + WaelContract.Moutoun_tab.TABLE_NAME
                + "( "
                + WaelContract.Moutoun_tab.COLUMN_ID_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WaelContract.Moutoun_tab.COLUMN_MATN_NAME + " TEXT"
                + " )";

        db.execSQL(rqt2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + WaelContract.Quran_tab.TABLE_NAME);
        onCreate(db);
    }

    public boolean addQuran(String soura_name, int aya_deb, int aya_fin)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WaelContract.Quran_tab.COLUMN_SOURA_NAME, soura_name);
        values.put(WaelContract.Quran_tab.COLUMN_AYA_DEB, aya_deb);
        values.put(WaelContract.Quran_tab.COLUMN_AYA_FIN, aya_fin);

        db.insert(WaelContract.Quran_tab.TABLE_NAME, null, values);
        db.close();
        return true;
    }

    public Cursor getAllQuran()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = null;

        String[] projection = {
                WaelContract.Quran_tab.COLUMN_ID_NAME,
                WaelContract.Quran_tab.COLUMN_SOURA_NAME,
                WaelContract.Quran_tab.COLUMN_AYA_DEB,
                WaelContract.Quran_tab.COLUMN_AYA_FIN
        };

        c = db.query(
                WaelContract.Quran_tab.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        //db.close();
        return c;
    }

    public boolean addMatn(String matn_name)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WaelContract.Moutoun_tab.COLUMN_MATN_NAME, matn_name);

        db.insert(WaelContract.Quran_tab.TABLE_NAME, null, values);

        db.close();

        return true;
    }


    public Cursor getAllMatn()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = null;

        String[] projection = {
                WaelContract.Quran_tab.COLUMN_ID_NAME,
                WaelContract.Moutoun_tab.COLUMN_MATN_NAME
        };

        c = db.query(
                WaelContract.Moutoun_tab.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        db.close();
        return c;
    }
}


