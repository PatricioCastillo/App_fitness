package com.example.app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner) findViewById(R.id.spinClientes);
        spin2 = (Spinner) findViewById(R.id.spinPlanes);
        text = (TextView) findViewById(R.id.tv);
        edit = (EditText) findViewById(R.id.et1);

        // <---
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes"); // Recibo mi arreglo.
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);

    }

    public void Calcular(View v)
    {
        Planes pl = new Planes();

        String cliente = spin1.getSelectedItem().toString();
        String plan =  spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString()); // obtengo el monto.

        int resulXtreme = saldo - pl.getXtreme();
        int resulMind = saldo - pl.getMindfullness();


        if(cliente.equals("Roberto") && plan.equals("xtreme"))
        {
            text.setText("El valor xtreme: " + resulXtreme);
        }

        if(cliente.equals("Roberto") && plan.equals("mindfullness"))
        {
            text.setText("El valor mindfullnes: " + resulMind);
        }

        // Inteligencia de Ivan según su plan

        if(cliente.equals("Ivan") && plan.equals("xtreme"))
        {
            text.setText("El valor xtreme: " + resulXtreme);
        }

        if(cliente.equals("Ivan") && plan.equals("mindfullness"))
        {
            text.setText("El valor mindfullnes: " + resulMind);
        }
    }
}