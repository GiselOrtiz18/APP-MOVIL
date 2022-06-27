package com.example.g1c2movil.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.R;
import com.example.g1c2movil.retrofit.model.Convocatoria;
import com.example.g1c2movil.retrofit.model.Persona;
import com.example.g1c2movil.retrofit.model.SolicitudEmpresa;

import java.util.List;

public class Convocatorias2Adaptador extends RecyclerView.Adapter<Convocatorias2Adaptador.ViewHolder> {

    private List<Convocatoria> listConvocatoria;

    public Convocatorias2Adaptador(List<Convocatoria> data) {
        this.listConvocatoria = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_convocatoria2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Convocatoria convocatoria = listConvocatoria.get(position);

        SolicitudEmpresa solicitudEmpresa = convocatoria.getSolicitudEmpresa();

        Persona _responsable = solicitudEmpresa.getResponsablePPP().getDocente().getPersona();
        String responsable = _responsable.getPrimerApellido() + " " + _responsable.getSegundoApellido() + ", " + _responsable.getPrimerNombre() + " " + _responsable.getSegundoNombre();

        holder.nombre.setText(convocatoria.getNombreConvocatoria());
        holder.responsable.setText("Responsable: " + responsable);
        holder.carrera.setText("Carrera: " + solicitudEmpresa.getCarrera().getNombre());
        holder.ciclo.setText("Ciclo: " + convocatoria.getIdConvocatoria().toString());
        holder.entidad.setText("Entidad: " + solicitudEmpresa.getEmpleado().getEmpresa().getNombreEmpresa());
        holder.fechaMax.setText("Fecha máxima: " + convocatoria.getFechaMaxima().toString());
        holder.fechaE.setText("Fecha emisión: " + convocatoria.getFechaEmision().toString());
    }

    @Override
    public int getItemCount() {
        return listConvocatoria.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, responsable, carrera, ciclo, entidad, fechaMax, fechaE;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.textView8);
            responsable = itemView.findViewById(R.id.textView9);
            carrera = itemView.findViewById(R.id.textView10);
            ciclo = itemView.findViewById(R.id.textView11);
            entidad = itemView.findViewById(R.id.textView12);
            fechaMax = itemView.findViewById(R.id.textView13);
            fechaE = itemView.findViewById(R.id.textView14);

        }
    }
}
