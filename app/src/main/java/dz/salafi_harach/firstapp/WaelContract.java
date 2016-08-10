package dz.salafi_harach.firstapp;


/**
 * وائــــل
 * This class contain names of tables and columns of our dataBase,
 * to use it just type:
 * WaelContract.<tableName>.<fieldName>
 */
public final class WaelContract
{
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public WaelContract(){}

    public static abstract class Quran_tab
    {
        public static final String TABLE_NAME = "Quran_tab";
        public static final String COLUMN_ID_NAME = "Id_quran";
        public static final String COLUMN_SOURA_NAME = "Soura_name";
        public static final String COLUMN_AYA_DEB = "Aya_deb";
        public static final String COLUMN_AYA_FIN = "Aya_fin";
        public static final String COLUMN_DATE = "Date_ajout";
    }

    public static abstract class Moutoun_tab
    {
        public static final String TABLE_NAME = "Moutoun_tab";
        public static final String COLUMN_ID_NAME = "Id_matn";
        public static final String COLUMN_MATN_NAME = "Matn_name";
        public static final String COLUMN_DATE = "Date_ajout";
    }

}
