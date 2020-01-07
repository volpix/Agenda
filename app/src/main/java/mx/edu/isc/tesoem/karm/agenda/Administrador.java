package mx.edu.isc.tesoem.karm.agenda;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class Administrador {
    private ArrayList<Datos> TextCompletData = new ArrayList<Datos>();
    private final String nomArch = "Datos.txt";

    public boolean Record(Context context, ArrayList<Datos> dato){
        try{
            Gson gson = new Gson();
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(nomArch, Activity.MODE_PRIVATE));
            for(Datos e: dato){
                Datos data = new Datos(e.getNombre(),e.getTelefono(),e.getDireccion(),e.getCorreo());
                String cjson = gson.toJson(data);
                archivo.write(cjson + "\n");
            }
            archivo.flush();
            archivo.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean Reed(Context context){
        try{
            Gson gson = new Gson();
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(nomArch));
            BufferedReader br = new BufferedReader(archivo);
            String cadena = br.readLine();
            while(cadena != null){
                Datos objDa = gson.fromJson(cadena, Datos.class);
                Datos obj= new Datos();
                obj.setNombre(objDa.getNombre());
                obj.setTelefono(objDa.getTelefono());
                obj.setDireccion(objDa.getDireccion());
                obj.setCorreo(objDa.getCorreo());
                TextCompletData.add(obj);
                cadena = br.readLine();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Datos> getContent(){
        return TextCompletData;
    }

    public void add(Datos dato, ArrayList<Datos> textComplet){
        this.TextCompletData = textComplet;
        this.TextCompletData.add(dato);
    }

    public boolean DeleteRow(Context context, String[] cadena, ArrayList<Datos> data){
        ArrayList<Datos> temp = new ArrayList<Datos>();
        for(Datos e: data){
            if(!(e.getNombre().equals(cadena[0]) && e.getTelefono().equals(cadena[1]))){
                Datos obj = new Datos(e.getNombre(),e.getTelefono(),e.getDireccion(),e.getCorreo());
                temp.add(obj);
            }
        }
        TextCompletData = temp;
        return true;
    }

    public String[] fillGV(ArrayList<Datos> txtComplet){
        String[] datos = new String[(txtComplet.size() * 4) + 4];
        int col = 4;

        datos[0] = "Nombre";
        datos[1] = "Telefono";
        datos[2] = "Direccion";
        datos[3] = "Correo";

        for(Datos e: txtComplet){
            datos[col] = e.getNombre();
            datos[col + 1] = e.getTelefono();
            datos[col + 2] = e.getDireccion();
            datos[col + 3] = e.getCorreo();
            col += 4;
        }
        return datos;
    }

    public String[] retNombreTelefono(ArrayList<Datos> txtComplet){
        String[] data = new String[txtComplet.size()];
        int i = 0;
        for(Datos e: txtComplet){
            data[i] = e.getNombre() + " | " + e.getTelefono();
            i++;
        }
        return data;
    }
}

