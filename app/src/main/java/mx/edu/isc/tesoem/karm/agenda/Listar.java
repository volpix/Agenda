package mx.edu.isc.tesoem.karm.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {
    private ArrayList<Datos> txtComplet = new ArrayList<Datos>();
    GridView lbljason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        lbljason = findViewById(R.id.lbljason);
        vista();
    }

    public void Regresa(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }

    public void vista(){
        Administrador objFM = new Administrador();
        objFM.Reed(this);
        txtComplet = objFM.getContent();
        String[] data = objFM.fillGV(txtComplet);
        if (!(data.length == 4)) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
            lbljason.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No hay contactos guardados.", Toast.LENGTH_SHORT).show();
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();
        }

    }

}
