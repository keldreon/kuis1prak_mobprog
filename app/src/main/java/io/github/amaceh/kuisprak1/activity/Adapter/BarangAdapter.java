package io.github.amaceh.kuisprak1.activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

import io.github.amaceh.kuisprak1.R;
import io.github.amaceh.kuisprak1.activity.Model.Barang;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {
    private List<Barang> mData;
    private LayoutInflater mInflater;
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public int kode_barang;
        public TextView nama_barang, jenis, harga;
        public LinearLayout ln;

        public ViewHolder(View view) {
            super(view);
            ln = view.findViewById(R.id.data_layout);
            nama_barang = view.findViewById(R.id.nbarang);
            jenis = view.findViewById(R.id.jnis);
            harga = view.findViewById(R.id.harga);
        }
    }

    public BarangAdapter(Context context, List<Barang> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public BarangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rc_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.ViewHolder holder, int position) {
        final Barang br = mData.get(position);
        holder.nama_barang.setText(br.getNama_barang());
        holder.jenis.setText(br.getJenis());;
        holder.harga.setText(br.getHarga());
        holder.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.ln.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popup = new PopupMenu(mInflater.getContext(), v);
                popup.getMenuInflater().inflate(R.menu.menu2,popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.edit:
                                return true;
                            case R.id.delete:
                                return true;
                            default:
                                return true;
                        }
                    }
                });

                popup.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // convenience method for getting data at click position
    public Barang getItem(int id) {
        return mData.get(id);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void swap(List<Barang> data){
        if(mData!=null){
            mData.clear();
            mData.addAll(data);
        }else {
            mData = data;
        }
        notifyDataSetChanged();
    }
}
