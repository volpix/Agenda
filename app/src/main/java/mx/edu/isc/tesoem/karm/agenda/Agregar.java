package mx.edu.isc.tesoem.karm.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Agregar extends AppCompatActivity {

    private ArrayList<Datos> texto = new ArrayList<Datos>();
    EditText edtNombre, edtTelefono, edtCorreo, edtDireccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);



    }
    public void Regresa(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }
    public void Guardar(View v){
        if(edtNombre.getText().toString().length() > 0  && edtTelefono.getText().toString().length() > 0
                && edtDireccion.getText().toString().length() > 0  && edtCorreo.getText().toString().length() > 0){
            Administrador objFM = new Administrador();
            Datos objData = new Datos(edtNombre.getText().toString(), edtTelefono.getText().toString(), edtDireccion.getText().toString(), edtCorreo.getText().toString());
            objFM.Reed(this);
            objFM.add(objData, objFM.getContent());
            texto = objFM.getContent();
            if(objFM.Record(this, texto)){
                Toast.makeText(this, "Guardado correctamente.", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                finish();
            }else{
                Toast.makeText(this, "Error al grabar.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Llene todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }

}
