package com.example.tavo.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ComfirmarDatos extends AppCompatActivity {

    private TextView tvName;
    private TextView tvfecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    int getfecha_day ;
    int getfecha_month ;
    int getfecha_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String getNombre = parametros.getString("nombre");
        getfecha_day = parametros.getInt("fecha_day");
        getfecha_month = parametros.getInt("fecha_month");
        getfecha_year = parametros.getInt("fecha_year");
        String getTelefono = parametros.getString("telefono");
        String getEmail = parametros.getString("email");
        String getDescripcion = parametros.getString("descripcion");

        tvName = (TextView) findViewById(R.id.textViewNombre);
        tvfecha = (TextView ) findViewById(R.id.textViewFecha);
        tvTelefono = (TextView) findViewById(R.id.textViewTelefono);
        tvEmail = (TextView) findViewById(R.id.textViewEmail);
        tvDescripcion = (TextView) findViewById(R.id.textViewDescripcion);

        String gFecha = String.valueOf(getfecha_day ) +"/"+String.valueOf (getfecha_month) +"/"+ String.valueOf(getfecha_year);
        tvName.setText(getNombre);
        tvfecha.setText(gFecha);
        tvTelefono.setText(getTelefono);
        tvEmail.setText(getEmail);
        tvDescripcion.setText(getDescripcion);

    }
    public void buttonEditar (View v){

        Intent intent = new Intent(ComfirmarDatos.this,MainActivity.class);
        intent.putExtra("editar", 1);
        intent.putExtra("nombre", tvName.getText().toString());
        intent.putExtra("fecha_day", getfecha_day);
        intent.putExtra("fecha_month", getfecha_month);
        intent.putExtra("fecha_year", getfecha_year);
        intent.putExtra("telefono", tvTelefono.getText().toString());
        intent.putExtra("email", tvEmail.getText().toString());
        intent.putExtra("descripcion", tvDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }


}
