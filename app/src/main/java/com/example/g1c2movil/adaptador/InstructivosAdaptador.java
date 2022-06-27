package com.example.g1c2movil.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.g1c2movil.R;
import com.example.g1c2movil.model.AnexoMenu;

import java.util.List;

public class InstructivosAdaptador extends RecyclerView.Adapter<InstructivosAdaptador.ViewHolder> {

    private List<AnexoMenu> anexoList;

    public InstructivosAdaptador(List<AnexoMenu> data) {
        this.anexoList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_instructivos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnexoMenu anexo = anexoList.get(position);

        holder.nombre.setText(anexo.getTitulo());
        holder.openfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_onItemClickListener != null)
                _onItemClickListener.onItemClick(v, anexo.getFile());
            }
        });
    }

    @Override
    public int getItemCount() {
        return anexoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView openfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.tv_titulo_anexo);
            openfile = itemView.findViewById(R.id.img_anexo);
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
