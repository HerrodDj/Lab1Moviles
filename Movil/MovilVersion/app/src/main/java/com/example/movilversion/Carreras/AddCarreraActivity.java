package com.example.movilversion.Carreras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.movilversion.R;
import com.example.movilversion.data.LogicaNeg.Carrera;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCarreraActivity extends AppCompatActivity {

    private boolean editable = true;
    private FloatingActionButton fBtn;
    private EditText codFld;
    private EditText nomFld;
    private Spinner box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_carrera);

        editable=true;

        fBtn = findViewById(R.id.addCarreraBtn);
        codFld = findViewById(R.id.codigoAddCar);
        nomFld = findViewById(R.id.nombreAddCar);
        codFld.setText("");
        nomFld.setText("");

        box = findViewById(R.id.titulosAddCar);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this,R.array.titulosCarreras, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        box.setAdapter(adap);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Carrera aux = (Carrera) getIntent().getSerializableExtra("carrera");
                codFld.setText(aux.getCodigo());
                codFld.setEnabled(false);
                nomFld.setText(aux.getNombre());
                if(aux.getTitulo().equals("Bachillerato")){
                    box.setSelection(0);
                }if(aux.getTitulo().equals("Licenciatura")){
                    box.setSelection(1);
                }if(aux.getTitulo().equals("Maestria")){
                    box.setSelection(2);
                }
                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editCarrera();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addCarrera();
                    }
                });
            }
        }





    }

    public void editCarrera(){
        if (validateForm()) {
            Carrera car = new Carrera(codFld.getText().toString(), nomFld.getText().toString(), box.getSelectedItem().toString());
            Intent intent = new Intent(getBaseContext(), CarrerasActivity.class);
            //sending carrera data
            intent.putExtra("editCarrera", car);
            startActivity(intent);
            finish(); //prevent go back
        }

    }
    public void addCarrera(){
        if (validateForm()) {
            //do something
            Carrera car = new Carrera(codFld.getText().toString(), nomFld.getText().toString(), box.getSelectedItem().toString());
            Intent intent = new Intent(getBaseContext(), CarrerasActivity.class);
            //sending carrera data
            intent.putExtra("addCarrera", car);
            startActivity(intent);
            finish(); //prevent go back
        }

    }


    public boolean validateForm() {
        int error = 0;
        if (TextUtils.isEmpty(this.nomFld.getText())) {
            nomFld.setError("Nombre requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.codFld.getText())) {
            codFld.setError("Codigo requerido");
            error++;
        }
        if (error > 0) {
            Toast.makeText(getApplicationContext(), "Campos sin completar", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() { //TODO it's not working yet
        /*if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }*/
        Intent a = new Intent(this, CarrerasActivity.class);
        startActivity(a);
        super.onBackPressed();
    }

}
