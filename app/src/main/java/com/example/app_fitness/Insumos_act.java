package com.example.app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edprecio, edstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        edcodigo = (EditText)findViewById(R.id.et_codigo);
        ednombre = (EditText)findViewById(R.id.et_nombre);
        edprecio = (EditText)findViewById(R.id.et_precio);
        edstock = (EditText)findViewById(R.id.et_stock);
    }


    // Añadir Insumos

    public void AñadirInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Me permite la sobreescritura de mi base de datos.

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            ContentValues cont = new ContentValues(); // me permite contener mas de un valor.

            cont.put("codigo", edcodigo.getText().toString());
            cont.put("nombre", ednombre.getText().toString());
            cont.put("precio", edprecio.getText().toString());
            cont.put("stock", edstock.getText().toString());

            db.insert("insumos", null, cont);
            db.close();

            Toast.makeText(this, "Has guardado un insumo", Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_LONG).show();
        }
    }

    // Mostrar Insumos

    public void MostrarInsumos(View v)
    {
       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
       SQLiteDatabase db = admin.getWritableDatabase();

       String codigo = edcodigo.getText().toString();

       if(!codigo.isEmpty())
       {
           // Cursor me permite recorrer los campos de la entidad insumos.
           Cursor fila = db.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo="+codigo, null);

           if(fila.moveToFirst()) // Si no hay campos en la entidad insumos devuelvo vacío.
           {
               ednombre.setText(fila.getString(0));
               edprecio.setText(fila.getString(1));
               edstock.setText(fila.getString(2));
           }
           else
           {
               Toast.makeText(this, "No hay campos en insumos", Toast.LENGTH_LONG).show();
           }

       }else
       {
           Toast.makeText(this, "No hay insumo con el codigo asociado.", Toast.LENGTH_SHORT).show();
       }
    }

    // Eliminar Insumos

    public void EliminarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        db.delete("insumos", "codigo="+codigo, null);
        db.close();

        Toast.makeText(this, "Has eliminado un insumo", Toast.LENGTH_SHORT).show();
    }

    // Actualizar Insumos

    public void ActualizarInsumos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();  // obtengo el codigo del cliente.

        ContentValues cont = new ContentValues(); // contener mas de un valor.

        cont.put("codigo", edcodigo.getText().toString());
        cont.put("nombre", ednombre.getText().toString());
        cont.put("precio", edprecio.getText().toString());
        cont.put("stock", edstock.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("insumos", cont, "codigo="+codigo, null);
            db.close();

            Toast.makeText(this, "Has actualizado un campo", Toast.LENGTH_LONG).show();
        }
    }

}