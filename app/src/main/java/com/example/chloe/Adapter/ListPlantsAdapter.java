package com.example.chloe.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.chloe.Config;
import com.example.chloe.Model.Plants;
import com.example.chloe.R;

import java.util.List;

public class ListPlantsAdapter extends RecyclerView.Adapter<ListPlantsAdapter.ListViewHolder> {
    List<Plants> listPlants;
    private OnItemCallBack onItemCallBack;

    public void setOnItemCallBack(OnItemCallBack onItemCallBack) {
        this.onItemCallBack = onItemCallBack;
    }

    public ListPlantsAdapter(List<Plants> listPlants) {
        this.listPlants = listPlants;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tanaman, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(Config.IMAGES_URL+listPlants.get(position).getImg_thumb())
                .apply(new RequestOptions().override(100,150))
                .into(holder.imgPhoto);
        holder.tvNama.setText(listPlants.get(position).getNama());
        holder.tvDeskripsi.setText(listPlants.get(position).getDeskripsi());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemCallBack.onItemClicked(listPlants.get(holder.getAdapterPosition()));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listPlants.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama, tvDeskripsi;
        public ListViewHolder(View view) {
            super(view);
            imgPhoto = view.findViewById(R.id.img_thumb);
            tvNama = view.findViewById(R.id.nama_tanaman);
            tvDeskripsi = view.findViewById(R.id.deskripsi_tanaman);
        }
    }

    private interface OnItemCallBack {
        void onItemClicked(Plants data);
    }
}
