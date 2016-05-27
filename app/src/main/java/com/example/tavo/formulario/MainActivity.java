package com.example.tavo.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText campNombre;
    DatePicker campFecha;
    TextInputEditText campTelefono;
    TextInputEditText campEmail;
    TextInputEditText campDescripcion;

    int getfecha_day;
    int getfecha_month;
    int getfecha_year;
    String getNombre = "";
    String getTelefono = "";
    String getEmail = "";
    String getDescripcion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
        Bundle parametros = getIntent().getExtras();

            getNombre = parametros.getString("nombre");
            getfecha_day = parametros.getInt("fecha_day");
            getfecha_month = parametros.getInt("fecha_month");
            getfecha_year = parametros.getInt("fecha_year");
            getTelefono = parametros.getString("telefono");
            getEmail = parametros.getString("email");
            getDescripcion = parametros.getString("descripcion");

            campNombre = (TextInputEditText) findViewById(R.id.editTextNombre);
            campFecha = (DatePicker) findViewById(R.id.datePicker);
            campTelefono = (TextInputEditText) findViewById(R.id.editTextTelefono);
            ;
            campEmail = (TextInputEditText) findViewById(R.id.editTextEmail);
            campDescripcion = (TextInputEditText) findViewById(R.id.editTextDescripcion);

            campNombre.setText(getNombre);

            campFecha.updateDate(getfecha_year, getfecha_month, getfecha_day);

            campTelefono.setText(getTelefono);
            campEmail.setText(getEmail);
            campDescripcion.setText(getDescripcion);
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public void buttonSiguiente(View v) {

        campNombre = (TextInputEditText) findViewById(R.id.editTextNombre);
        Log.d("Valor Nombre", campNombre.getText().toString());

        campFecha = (DatePicker) findViewById(R.id.datePicker);
        String fecha = String.valueOf(campFecha.getDayOfMonth()) + "/" + String.valueOf(campFecha.getMonth()) + "/" + String.valueOf(campFecha.getYear());
        Log.d("Valor fecha", fecha);

        campTelefono = (TextInputEditText) findViewById(R.id.editTextTelefono);
        Log.d("Valor Telefono", campTelefono.getText().toString());

        campEmail = (TextInputEditText) findViewById(R.id.editTextEmail);
        Log.d("Valor Email", campEmail.getText().toString());

        campDescripcion = (TextInputEditText) findViewById(R.id.editTextDescripcion);
        Log.d("Valor Descripcion", campDescripcion.getText().toString());

        Intent intent = new Intent(MainActivity.this, ComfirmarDatos.class);
        intent.putExtra("nombre", campNombre.getText().toString());
        intent.putExtra("fecha_day", campFecha.getDayOfMonth());
        intent.putExtra("fecha_month", campFecha.getMonth());
        intent.putExtra("fecha_year", campFecha.getYear());
        intent.putExtra("telefono", campTelefono.getText().toString());
        intent.putExtra("email", campEmail.getText().toString());
        intent.putExtra("descripcion", campDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}
