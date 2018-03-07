package com.gomez.jhond.lab12;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText eFecha;
    EditText eLogin;
    EditText ePass;
    EditText ePass2;
    EditText eCorreo;
    RadioButton rMasculino;
    RadioButton rFemenino;
    Spinner sCiudades;
    CheckBox cNadar;
    CheckBox cCorrer;
    CheckBox cLeer;
    Button bAceptar;
    DatePickerDialog pNacimiento;
    TextView tMostrar;
    String genero;
    String pasatiempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFecha = findViewById(R.id.eFecha);
        eLogin = findViewById(R.id.eLogin);
        eCorreo = findViewById(R.id.eCorreo);
        ePass = findViewById(R.id.ePass);
        ePass2 = findViewById(R.id.ePass2);
        rFemenino = findViewById(R.id.rFemenino);
        rMasculino = findViewById(R.id.rMasculino);
        sCiudades = findViewById(R.id.sCiudades);
        cCorrer = findViewById(R.id.cCorrer);
        cNadar =findViewById(R.id.cNadar);
        cLeer = findViewById(R.id.cLeer);
        bAceptar = findViewById(R.id.bAceptar);
        tMostrar = findViewById(R.id.tMostrar);
        rMasculino.setChecked(true);



        eFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                pNacimiento = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                eFecha.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                pNacimiento.show();
            }
        });
    }

    public void Aceptar(View view) {

        if(!eLogin.getText().toString().isEmpty()&&!ePass.getText().toString().isEmpty()&&!ePass2.getText().toString().isEmpty()&&!eCorreo.getText().toString().isEmpty()&&!eFecha.getText().toString().isEmpty()) {
            if(ePass.getText().toString().equals(ePass2.getText().toString())){

                pasatiempo= " ";
                if (rMasculino.isChecked()) genero = " Masculino ";
                if (rFemenino.isChecked()) genero = " Femenino ";
                if (cCorrer.isChecked()) pasatiempo=pasatiempo + " Correr ";
                if (cLeer.isChecked()) pasatiempo= pasatiempo +  " Leer ";
                if (cNadar.isChecked()) pasatiempo= pasatiempo + "Nadar ";

                tMostrar.setText("Usuario: "+ eLogin.getText().toString()+  " * Contraseña: "+ePass.getText().toString() + " * Genero: "+ genero + " * Fecha de nacimiento: "+eFecha.getText().toString() + " * Lugar de nacimiento: "+ sCiudades.getSelectedItem().toString() + " * Correo: " + eCorreo.getText().toString() + " * Pasatiempo: "+ pasatiempo );
            }else{
                tMostrar.setText("Las contraseñas no coinciden");
            }
        }else{
            tMostrar.setText("ERROR! Faltan campos por completar.");
        }



    }
}
