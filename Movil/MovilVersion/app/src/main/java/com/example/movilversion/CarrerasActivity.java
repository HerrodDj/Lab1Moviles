package com.example.movilversion;

import android.content.Intent;
import android.os.Bundle;

import com.example.movilversion.data.Adapter.CarreraAdapter;
import com.example.movilversion.data.Datos.Data;
import com.example.movilversion.data.LogicaNeg.Carrera;
import com.example.movilversion.ui.login.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class CarrerasActivity extends AppCompatActivity implements CarreraAdapter.CarreraAdapterListener{

    private RecyclerView rVLC;
    private Data datos;
    private SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carreras);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        rVLC = findViewById(R.id.listCarreras);
        rVLC.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        LinearLayoutManager LL = new LinearLayoutManager(this);
        rVLC.setLayoutManager(LL);

        //Datos
        Data datos = new Data();
        ArrayList<Carrera> listaC = datos.getListaCarreras();

        CarreraAdapter carrAdap = new CarreraAdapter(listaC, this);
        rVLC.setAdapter(carrAdap);

        carrAdap.notifyDataSetChanged();


    }

    @Override
    public void onContactSelected(Carrera carrera) {
        Toast.makeText(getApplicationContext(), "Selected: " + carrera.getCodigo() + ", " + carrera.getNombre(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }








    @Override
    public void onBackPressed() { //TODO it's not working yet
        Intent a = new Intent(this, HomeActivity.class);
        startActivity(a);
        super.onBackPressed();
    }

}
