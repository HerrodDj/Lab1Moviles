package com.example.movilversion.Carreras;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.movilversion.R;
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

import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class CarrerasActivity extends AppCompatActivity implements CarreraAdapter.CarreraAdapterListener{

    private RecyclerView rVLC;
    private Data datos;
    private SearchView searchView;
    private CarreraAdapter carrAdap;


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

        carrAdap = new CarreraAdapter(listaC, this);
        rVLC.setAdapter(carrAdap);

        whiteNotificationBar(rVLC);
        carrAdap.notifyDataSetChanged();

    }

    @Override
    public void onContactSelected(Carrera carrera) {
        Toast.makeText(getApplicationContext(), "Selected: " + carrera.getCodigo() + ", " + carrera.getNombre(), Toast.LENGTH_LONG).show();
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds carreraList to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);

        // Associate searchable configuration with the SearchView   !IMPORTANT
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change, every type on input
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                carrAdap.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                carrAdap.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }*/

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
        /*if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }*/
        Intent a = new Intent(this, HomeActivity.class);
        startActivity(a);
        super.onBackPressed();
    }

}
