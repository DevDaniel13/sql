package com.example.recycleview;

import android.content.*;
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.*;
import java.util.*;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> implements View.OnClickListener {
    protected ArrayList<Alumno> listaAlumnos;
    private View.OnClickListener listener;
    private Context context;
    private LayoutInflater inflater;

    public MiAdaptador(ArrayList<Alumno> listaAlumnos, Context context) {
        this.listaAlumnos = listaAlumnos;
        this.context=context;
        this.inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public MiAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= inflater.inflate(R.layout.alumnos_items,null);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(MiAdaptador.ViewHolder holder, int position){
        Alumno alumno=listaAlumnos.get(position);
        holder.txtMatricula.setText(alumno.getMatricula());
        holder.txtNombre.setText(alumno.getNombre());
        holder.idImagen.setImageResource(alumno.getImg());
    }

    public int getItemCount(){
        return listaAlumnos.size();
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public void onClick(View v){
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private LayoutInflater inflater;
        private TextView txtNombre;
        private TextView txtMatricula;
        private TextView txtCarrera;
        private ImageView idImagen;

        public ViewHolder(View itemView){
            super(itemView);
            txtNombre=(TextView) itemView.findViewById(R.id.txtAlumnoNombre);
            txtMatricula=(TextView) itemView.findViewById(R.id.txtMatricula);
            txtCarrera=(TextView) itemView.findViewById(R.id.txtCarrera);
            idImagen=(ImageView) itemView.findViewById(R.id.foto);

        }
    }
}

