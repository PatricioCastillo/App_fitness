package Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    // Constructor para llamar a mi base de datos.

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // OnCreate: me permite definir la configuración inicial de la base de datos.

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE insumos (codigo int primary key, nombre text, precio float, stock int)");
    }

    // OnUpgrade: me permite realizar cambios a nivel de esquema de mi base de datos.

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
