package com.example.chino.courselabasico;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chino.courselabasico.ListaMaterias;
import com.example.chino.courselabasico.R;
import com.example.chino.courselabasico.baseDatos.BaseDatos;
import com.example.chino.courselabasico.baseDatos.DataBaseManager;

public class ConfiguracionPorcentajes extends AppCompatActivity {

    TextView tvCorte1;
    TextView tvCorte2;
    TextView tvCorte3;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        //mostramos la toolbar
        Toolbar toolbar =(Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        //habilitamos la navegacion hacia atras en el tolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //comunicandose con  los elementso del archivo xml
        tvCorte1 = (TextView) findViewById(R.id.tvPorcentajeCorte1);
        tvCorte2 = (TextView) findViewById(R.id.tvPorcentajeCorte2);
        tvCorte3 = (TextView) findViewById(R.id.tvPorcentajeCorte3);
        btnGuardar= (Button) findViewById(R.id.btnGuardarCortes);


    }

    public  void  insertarCortes(View v ){
        BaseDatos db = new BaseDatos(this);
        insertarCortes(db);
        //cierra la actividad en curso
        finish();

    }
//    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public  void insertarCortes(BaseDatos db)
    {
        Double Corte1 = Double.parseDouble(tvCorte1.getText().toString());
        Double Corte2 = Double.parseDouble(tvCorte2.getText().toString());
        Double Corte3 = Double.parseDouble(tvCorte3.getText().toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseManager.PORCENTAJECORTES_CORTE1,Corte1);
        contentValues.put(DataBaseManager.PORCENTAJECORTES_CORTE2,Corte2);
        contentValues.put(DataBaseManager.PORCENTAJECORTES_CORTE3,Corte3);


        db.addMateria(DataBaseManager.NOMBRE_TABLA_PORCENTAJECORTES,contentValues);
        Toast.makeText(this, "Se Guardo con exito ", Toast.LENGTH_SHORT).show();
        //cierra la actividad en curso
        finish();
        //llama a la actividad en donde esta el recycler view
        Intent i = new Intent(this,ListaMaterias.class);
        this.startActivity(i);

    }
}