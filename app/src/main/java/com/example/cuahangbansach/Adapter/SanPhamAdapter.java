package com.example.cuahangbansach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.cuahangbansach.Entity.SanPham;
import com.example.cuahangbansach.R;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    List<SanPham> sanPhamList;
    Context context;

    public SanPhamAdapter(@NonNull Context context, List<SanPham> sanPhamList) {
        super(context, 0, sanPhamList);
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int getCount() {
        return sanPhamList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_san_pham, parent, false);
        }
        ImageView image = convertView.findViewById(R.id.image);
        TextView tv_ten = convertView.findViewById(R.id.tv_ten);
        TextView tv_loai = convertView.findViewById(R.id.tv_loai);
        TextView tv_gia = convertView.findViewById(R.id.tv_gia);
        SanPham sanPham = sanPhamList.get(position);
        tv_ten.setText(sanPham.getTenSP());
        tv_gia.setText(sanPham.getGiaBan() + " VNĐ");
        tv_loai.setText(sanPham.getLoaiSP());
        Glide.with(context).load(sanPham.getHinhAnh()).error(R.drawable.ic_launcher_background).into(image);
        return convertView;
    }
}
