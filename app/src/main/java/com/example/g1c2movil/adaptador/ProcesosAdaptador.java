package com.example.g1c2movil.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.R;
import com.example.g1c2movil.retrofit.model.SolicitudAlumno;

import java.util.List;
import java.util.Objects;

public class ProcesosAdaptador extends RecyclerView.Adapter<ProcesosAdaptador.ViewHolder> {

    private DiffUtil.ItemCallback<SolicitudAlumno> differCallback = new DiffUtil.ItemCallback<SolicitudAlumno>() {

        @Override
        public boolean areItemsTheSame(@NonNull SolicitudAlumno oldItem, @NonNull SolicitudAlumno newItem) {
            return oldItem.getFechaEmision() == newItem.getFechaEmision();
        }

        @Override
        public boolean areContentsTheSame(@NonNull SolicitudAlumno oldItem, @NonNull SolicitudAlumno newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };

    public AsyncListDiffer<SolicitudAlumno> differ = new AsyncListDiffer<SolicitudAlumno>(this, differCallback);

    public ProcesosAdaptador() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_procesos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SolicitudAlumno solicitudAlumno = differ.getCurrentList().get(position);

        holder.nombre.setText(solicitudAlumno.getConvocatoria().getNombreConvocatoria());

    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.tv_titulo_proceso);

        }
    }

    //  listener
    private static onItemClickListener setOnItemClickListener;

    public interface onItemClickListener {
        void imageViewOnClick(View v, int position);
    }

}
