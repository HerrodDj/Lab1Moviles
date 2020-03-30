package com.example.movilversion.Cursos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.movilversion.Carreras.CarrerasActivity;
import com.example.movilversion.R;
import com.example.movilversion.data.Datos.Data;
import com.example.movilversion.data.LogicaNeg.Carrera;
import com.example.movilversion.data.LogicaNeg.Curso;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddCursosActivity extends AppCompatActivity {

    private Spinner boxCar;
    private boolean editable = true;
    private FloatingActionButton fBtn;
    private EditText codFld;
    private EditText nomFld;
    private EditText credFld;
    private EditText horFld;
    private EditText annioFld;
    private Spinner boxCic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cursos);

        editable=true;

        fBtn = findViewById(R.id.addCursosBtn);
        codFld = findViewById(R.id.codigoAddCur);
        nomFld = findViewById(R.id.nombreAddCur);
        credFld = findViewById(R.id.creditosAddCur);
        horFld = findViewById(R.id.horasAddCur);
        annioFld = findViewById(R.id.annioAddCur);
        codFld.setText("");
        nomFld.setText("");
        credFld.setText("");
        horFld.setText("");
        annioFld.setText("");

        //ciclos box
        boxCic = findViewById(R.id.cicloAddCur);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this,R.array.ciclos,android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boxCic.setAdapter(adap);

        //carreras box
        Data carreras = new Data();
        ArrayList<Carrera> arr = carreras.getListaCarreras();
        ArrayList<String> nC = new ArrayList<>();
        for(int i=0; i<arr.size(); i++){
            nC.add(arr.get(i).getCodigo());
        }
        boxCar = findViewById(R.id.carrAddCur);
        ArrayAdapter<String> adap1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, nC);
        adap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boxCar.setAdapter(adap1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Curso aux = (Curso) getIntent().getSerializableExtra("curso");
                codFld.setText(aux.getCodigo());
                codFld.setEnabled(false);
                nomFld.setText(aux.getNombre());
                credFld.setText(aux.getCreditos());
                horFld.setText(aux.getHorasSemanales());
                annioFld.setText(aux.getAnio());
                if(aux.getCiclo()==1){
                    boxCar.setSelection(0);
                }if(aux.getCiclo()==2){
                    boxCar.setSelection(1);
                }
                boxCar.setSelection(nC.indexOf(aux.getCodigoCarrera()));
                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editCurso();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addCurso();
                    }
                });
            }
        }



    }

    public void editCurso(){}
    public void addCurso(){
        if (validateForm()) {
            //do something
            Curso cur = new Curso(codFld.getText().toString(), nomFld.getText().toString(), Integer.parseInt(credFld.getText().toString()), Integer.parseInt(horFld.getText().toString()),boxCar.getSelectedItem().toString(), Integer.parseInt(boxCic.getSelectedItem().toString()),Integer.parseInt(annioFld.getText().toString()));
            Intent intent = new Intent(getBaseContext(), CursosActivity.class);
            //sending curso data
            intent.putExtra("addCurso", cur);
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
        if (TextUtils.isEmpty(this.credFld.getText())){
            credFld.setError("Creditos Requeridos");
            error++;
        }
        if (TextUtils.isEmpty(this.horFld.getText())){
            horFld.setError("Horas Requeridas");
            error++;
        }
        if (TextUtils.isEmpty(this.annioFld.getText())){
            annioFld.setError("Año Requerido");
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
        Intent a = new Intent(this, CursosActivity.class);
        startActivity(a);
        super.onBackPressed();
    }

}
