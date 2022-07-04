package com.example.recycleview;

import android.app.Application;
import android.util.Log;

import java.util.*;

public class Aplicacion extends Application {
    private ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public MiAdaptador getAdaptador() {
        return adaptador;
    }

    public void onCreate(){
        super.onCreate();
        alumnos= Alumno.llenarAlumnos();
        adaptador= new MiAdaptador(alumnos,this);
        Log.d("","onCreate: tamaño array list "+alumnos.size());
    }
}
