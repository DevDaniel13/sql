package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbtnAgregar;
    private Aplicacion app;

    private Alumno alumno;
    private int posicion = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aplicacion app=(Aplicacion) getApplication();
        recyclerView=(RecyclerView) findViewById(R.id.reId);
        recyclerView.setAdapter(app.getAdaptador());

        fbtnAgregar = (FloatingActionButton) findViewById(R.id.agregarAlumno);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        fbtnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumno = null;
                Intent intent = new Intent(MainActivity.this, AlumnoAlta.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alumno", alumno);
                bundle.putInt("posicion", posicion);
                intent.putExtras(bundle);

                startActivityForResult(intent, 0);
            }
        });

        app.getAdaptador().setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int posicion=recyclerView.getChildAdapterPosition(v);
                String dato=app.getAlumnos().get(posicion).getNombre();
                Toast.makeText(MainActivity.this,"Se hizo click en "+dato,Toast.LENGTH_LONG).show();*/
                posicion = recyclerView.getChildAdapterPosition(v);
                alumno = app.getAlumnos().get(posicion);
                Intent intent = new Intent(MainActivity.this, AlumnoAlta.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alumno",alumno);
                intent.putExtra("posicion",posicion);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        recyclerView.getAdapter().notifyDataSetChanged();
        posicion = -1;
    }
}