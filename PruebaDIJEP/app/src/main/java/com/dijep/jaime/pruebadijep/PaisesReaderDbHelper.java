package com.dijep.jaime.pruebadijep;

/**
 * Created by Jaime on 10/12/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaisesReaderDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Paises.db";
    public static final int DATABASE_VERSION = 1;

    public PaisesReaderDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + PaisesDataSource.PAISES_TABLE_NAME);
        db.execSQL(PaisesDataSource.CREATE_PAISES_SCRIPT);
        db.execSQL(PaisesDataSource.INSERT_PAISES_SCRIPT);

        db.execSQL("DROP TABLE IF EXISTS " + PaisesDataSource.CIUDADES_TABLE_NAME);
        db.execSQL(PaisesDataSource.CREATE_INFO_SCRIPT);
        db.execSQL(PaisesDataSource.INSERT_INFO_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PaisesDataSource.PAISES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PaisesDataSource.CIUDADES_TABLE_NAME );
        onCreate(db);
    }
}
