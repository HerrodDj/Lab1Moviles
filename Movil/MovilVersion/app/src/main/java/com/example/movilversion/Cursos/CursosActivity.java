package com.example.movilversion.Cursos;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.movilversion.data.Adapter.CarreraAdapter;
import com.example.movilversion.data.Adapter.CursoAdapter;
import com.example.movilversion.data.Datos.Data;
import com.example.movilversion.data.LogicaNeg.Carrera;
import com.example.movilversion.data.LogicaNeg.Curso;
import com.example.movilversion.ui.login.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.example.movilversion.R;

import java.util.ArrayList;

public class CursosActivity extends AppCompatActivity implements CursoAdapter.CursoAdapterListener{

    private RecyclerView rVLC;
    private Data datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
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

        rVLC = findViewById(R.id.listCursos);
        rVLC.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        LinearLayoutManager LL = new LinearLayoutManager(this);
        rVLC.setLayoutManager(LL);

        //Datos
        Data datos = new Data();
        ArrayList<Curso> listaC = datos.getListaCursos();

        CursoAdapter carrAdap = new CursoAdapter(listaC, this);
        rVLC.setAdapter(carrAdap);

        whiteNotificationBar(rVLC);
        carrAdap.notifyDataSetChanged();
    }

    @Override
    public void onContactSelected(Curso curso) {
        Toast.makeText(getApplicationContext(), "Selected: " + curso.getCodigo() + ", " + curso.getNombre(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }
    @Override
    public void onBackPressed() { //TODO it's not working yet
        Intent a = new Intent(this, HomeActivity.class);
        startActivity(a);
        super.onBackPressed();
    }

}
