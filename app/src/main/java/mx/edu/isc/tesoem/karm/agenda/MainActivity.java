package mx.edu.isc.tesoem.karm.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3=(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }
    public void onClick(View v) {

        if (v.getId() == btn1.getId()) {
            Intent Meta = new Intent(this, Agregar.class);
            startActivity(Meta);
            finish();
        }
        if (v.getId() == btn2.getId()) {
            Intent Command = new Intent(this, Listar.class);
            startActivity(Command);
            finish();
        }
        if (v.getId() == btn3.getId()) {
            Intent Autentico = new Intent(this, Eliminar.class);
            startActivity(Autentico);
            finish();
        }
    }

}
