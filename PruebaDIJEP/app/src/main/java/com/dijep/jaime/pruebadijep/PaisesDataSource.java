package com.dijep.jaime.pruebadijep;

/**
 * Created by Jaime on 10/12/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Creado por Hermosa Programación
 */
public class PaisesDataSource {

    //Metainformación de la base de datos
    public static final String PAISES_TABLE_NAME = "Paises";
    public static final String CIUDADES_TABLE_NAME = "ciudades";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Paises
    public static class ColumnPaises {
        public static final String ID_PAIS = BaseColumns._ID;
        public static final String BANDERA_PAIS = "bandera";
        public static final String BODY_PAIS = "body";
    }

    public static class ColumnCiudad{
        public static final String ID_INFO = BaseColumns._ID;
        public static final String INFO_PAIS = "pais";
        public static final String INFO_NOMBRE = "nombre";
        public static final String INFO_HAB = "habitantes";
    }


    //Script de Creación de la tabla
    public static final String CREATE_PAISES_SCRIPT =
            "create table "+PAISES_TABLE_NAME+"(" +
                    ColumnPaises.ID_PAIS+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnPaises.BANDERA_PAIS+" "+STRING_TYPE+" not null,"+
                    ColumnPaises.BODY_PAIS+" "+STRING_TYPE+" not null)";

    public static final String CREATE_INFO_SCRIPT =
            "create table "+CIUDADES_TABLE_NAME+"(" +
                    ColumnCiudad.ID_INFO+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnCiudad.INFO_NOMBRE+" "+STRING_TYPE+" not null,"+
                    ColumnCiudad.INFO_HAB+" "+INT_TYPE+" not null," +
                    ColumnCiudad.INFO_PAIS+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto
    public static final String INSERT_PAISES_SCRIPT =
            "insert into "+PAISES_TABLE_NAME+" values(" +
                    "null," +
                    "\"es\","+
                    "\"España\")," +
                    "(null," +
                    "\"de\","+
                    "\"Alemania\")," +
                    "(null," +
                    "\"br\","+
                    "\"Brasil\")," +
                    "(null," +
                    "\"cn\","+
                    "\"China\")," +
                    "(null," +
                    "\"ar\","+
                    "\"Argentina\")," +
                    "(null," +
                    "\"qa\","+
                    "\"Qatar\")," +
                    "(null," +
                    "\"cl\","+
                    "\"Chile\")," +
                    "(null," +
                    "\"us\","+
                    "\"Estados Unidos\")," +
                    "(null," +
                    "\"fr\","+
                    "\"Francia\")," +
                    "(null," +
                    "\"jp\","+
                    "\"Japón\")";

    public static final String INSERT_INFO_SCRIPT =
            "insert into "+CIUDADES_TABLE_NAME+" values(" +
                    "null," + "\"Cádiz\","+ "\"100\","+ "\"España\")," +
                    "(null," + "\"Munich\","+  "\"100\","+ "\"Alemania\")," +
                    "(null," + "\"Brasilia\","+  "\"100\","+ "\"Brasil\")," +
                    "(null," + "\"Pekin\","+  "\"100\","+ "\"China\")," +
                    "(null," + "\"Buenos Aires\","+  "\"100\","+ "\"Argentina\")," +
                    "(null," + "\"Doha\","+  "\"100\","+ "\"Qatar\")," +
                    "(null," + "\"Tocopila\","+  "\"100\","+ "\"Chile\")," +
                    "(null," + "\"New York\","+  "\"100\","+ "\"Estados Unidos\")," +
                    "(null," + "\"París\","+  "\"100\","+ "\"Francia\")," +
                    "(null," + "\"Tokio\","+  "\"100\","+ "\"Japón\")";


    //Variables para manipulación de datos
    private PaisesReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public PaisesDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new PaisesReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public List<Pais> getAll(){
        List<Pais> list = new ArrayList<>();
        Cursor cursor = database.rawQuery(
                "select * from Paises", null );

        cursor.moveToFirst();
        do {
            Pais p = new Pais();
            p.setImagen(cursor.getString(cursor.getColumnIndex("bandera")));
            p.setNombre(cursor.getString(cursor.getColumnIndex("body")));
            list.add(p);
        }while(cursor.moveToNext());
        cursor.close();
        return list;
    }

    public List<Info> getInfo(String pais){
        List<Info> list = new ArrayList<>();
        Cursor cursor = database.rawQuery(
                "select * from Paises where body=?", new String[]{pais});
        cursor.moveToFirst();
        do {
            Info p = new Info();
            p.setHabitantes(5);
            p.setNombre(cursor.getString(cursor.getColumnIndex("body")));
            list.add(p);
        }while(cursor.moveToNext());
        cursor.close();
        return list;

        /*cursor.moveToFirst();
        do {
            Info i = new Info();
            i.setHabitantes(cursor.getInt(cursor.getColumnIndex("habitantes")));
            i.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            list.add(i);
        }while(cursor.moveToNext());
        cursor.close();
        return list;*/
    }
}
