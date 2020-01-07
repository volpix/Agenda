package mx.edu.isc.tesoem.karm.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Eliminar extends AppCompatActivity {

    private ArrayList<Datos> txtComplet = new ArrayList<Datos>();
    List<String> listContact = new ArrayList<String>();
    Spinner objS;
    ArrayAdapter<String> listContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        try{
            objS = findViewById(R.id.eli);
            Administrador objFM = new Administrador();
            objFM.Reed(this);
            txtComplet = objFM.getContent();
            String[] data = objFM.retNombreTelefono(txtComplet);
            Collections.addAll(listContact, data);
            listContactAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listContact);
            objS.setAdapter(listContactAdapter);
            objS.getSelectedItem().toString();
        }catch (NullPointerException e){
            Toast.makeText(this, "No hay contactos guardados.", Toast.LENGTH_SHORT).show();

        }
    }

    public void Atras(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }

    public void Eliminar(View view){
        Administrador objFM = new Administrador();
        String cadena = objS.getSelectedItem().toString();
        int tam = cadena.length();
        String[] arreglo = new String[]{
                cadena.substring(0, cadena.indexOf(" | ")),
                cadena.substring(cadena.indexOf(" | ") + 3, tam)
        };
        objFM.Reed(this);
        if(objFM.DeleteRow(this, arreglo, objFM.getContent())){
            txtComplet = objFM.getContent();
            if(objFM.Record(this, txtComplet)){
                Toast.makeText(this, "Se ha borrado correctamente.", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                finish();

            }
        }
    }
}
