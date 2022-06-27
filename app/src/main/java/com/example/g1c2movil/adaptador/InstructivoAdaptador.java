package com.example.g1c2movil.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.R;
import com.example.g1c2movil.retrofit.model.ActaDeReunion;
import com.example.g1c2movil.retrofit.model.Anexo;

import java.util.List;

public class InstructivoAdaptador extends RecyclerView.Adapter<InstructivoAdaptador.ViewHolder> {

    private List<ActaDeReunion> actaDeReunions;

    public InstructivoAdaptador(List<ActaDeReunion> data) {
        this.actaDeReunions = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_instructivo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActaDeReunion actaDeReunion = actaDeReunions.get(position);

        holder.nombre.setText(actaDeReunion.getDocActaReunion());
        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_onItemClickListener != null)
                    _onItemClickListener.onItemClick(v, actaDeReunion.getDocActaReunion());
            }
        });

    }

    @Override
    public int getItemCount() {
        return actaDeReunions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView btnDownload;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.textView24);
            btnDownload = itemView.findViewById(R.id.img_download1);
        }
    }

    //  listener
    public static onItemClickListener _onItemClickListener;


    // allows clicks events to be caught
    public void setClickListener(onItemClickListener itemClickListener) {
        _onItemClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface onItemClickListener {
        void onItemClick(View view, String file);
    }

}
