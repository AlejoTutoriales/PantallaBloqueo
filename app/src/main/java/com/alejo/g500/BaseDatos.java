package com.alejo.g500;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    String tablaConfiguracion = "CREATE TABLE configuracion (idConfiguracion INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, estatus TEXT)";
    public static final String BASE_DATOS_NOMBRE = "bd_g500";

    public static final int BASE_DATOS_VERSION = 1;

    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaConfiguracion);
        db.execSQL("INSERT INTO configuracion (nombre, estatus) values ('patron','null')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS configuracion");
    }

    public static String obtenerPatron(Context context) {
        //CREO INSTANCIA A MI BASE DATOS
        BaseDatos conn = new BaseDatos(context, BaseDatos.BASE_DATOS_NOMBRE, null, BaseDatos.BASE_DATOS_VERSION);
        //LA ESTABLESCO EN MODO LECTURA
        SQLiteDatabase db = conn.getReadableDatabase();

        //CREO UN CURSOR PARA RECORRER LOS CAMPOS
        Cursor cursor = db.rawQuery("SELECT estatus from configuracion WHERE nombre='patron'", null);

        //CREO VARIABLES PARA GUARDAR LO QUE ME RETORNE EL CURSOR SEGÚN EL TIPO DE VALOR O DATO
        String patron = "";

        while (cursor.moveToNext()) {
            //GUARDO LOS RESULTADOS EN LAS VARIABLES
            patron = cursor.getString(0);
            //SI EL CAMPO NO TIENE ESE TEXTO, ENTONCES EXISTE UN PATRÓN REGISTRADO
            if (patron.equals("null") == false) {
                return patron;
            }
        }
        //EN CASO DE QUE NO HAYA PATRÓN, RETORNO EL VALOR POR DEFAULT
        return "null";
    }

    public static void actualizarPatron(Context context, String nuevoPatron) {
        try {
            //CREO UN INSTANACIA DE LA BASE DE DATOS
            BaseDatos conn = new BaseDatos(context, BaseDatos.BASE_DATOS_NOMBRE, null, BaseDatos.BASE_DATOS_VERSION);
            //LA ABRO EN MODO ESCRITURA
            SQLiteDatabase db = conn.getWritableDatabase();
            db.execSQL("UPDATE configuracion SET  estatus='" + nuevoPatron + "' where nombre = 'patron'");

        } catch (Exception e) {

        }

    }

}
