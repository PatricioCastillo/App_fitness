package com.example.app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        // Llamo a los elementos por id.

        spin1 = (Spinner) findViewById(R.id.spnClientes);
        spin2 = (Spinner) findViewById(R.id.spnPlanes);
        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.tv);

        // Recibiré el dato.

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);
        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }


    public void Calcular(View v)
    {
        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        Planes plan = new Planes(); // creas el objeto.

        plan.setXtreme(80000);  // cambia el dato.

        // Añadimos la inteligencia de la resta.
        int monto = Integer.parseInt(edit.getText().toString());
        int resultXtreme = monto-plan.getXtreme();


        // Inteligencia Roberto.

        if(cliente.equals("Roberto") && planes.equals("xtreme"))
        {
            text.setText("El precio del plan es: " + resultXtreme);
        }

        if(cliente.equals("Roberto") && planes.equals("mindfullness"))
        {
            text.setText("El precio del plan es: " + plan.getMindfullness());
        }

    }
}