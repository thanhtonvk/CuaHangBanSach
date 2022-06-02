package com.example.cuahangbansach.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuahangbansach.Adapter.SanPhamAdapter;
import com.example.cuahangbansach.Database.DBContext;
import com.example.cuahangbansach.Entity.SanPham;
import com.example.cuahangbansach.R;

import java.util.List;

public class QuanLySanPhamActivity extends AppCompatActivity {

    EditText edt_tensp, edt_loaisp, edt_giaban, edt_hinhanh;
    Button btn_them, btn_sua, btn_xoa;
    AutoCompleteTextView edt_timkiem;
    ListView lv_sanpham;
    SanPhamAdapter adapter;
    DBContext dbContext;
    List<SanPham> sanPhamList;
    SanPham sanPham;
    ArrayAdapter<SanPham> sanPhamArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_san_pham);
        dbContext = new DBContext(this);
        anhXa();
        loadDuLieu();
        onClick();
    }

    private void loadDuLieu() {
        sanPhamList = dbContext.getAllSanPhams();
        adapter = new SanPhamAdapter(this, sanPhamList);
        sanPhamArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sanPhamList);

        lv_sanpham.setAdapter(adapter);
        edt_timkiem.setAdapter(sanPhamArrayAdapter);
    }

    private void onClick() {
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sanPham = getSanPham();
                dbContext.updateSanPham(sanPham, false);
                edt_tensp.setText("");
                edt_loaisp.setText("");
                edt_giaban.setText("");
                edt_hinhanh.setText("");
                loadDuLieu();
            }
        });
        lv_sanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sanPham = sanPhamList.get(i);
                edt_tensp.setText(sanPham.getTenSP());
                edt_loaisp.setText(sanPham.getLoaiSP());
                edt_giaban.setText(sanPham.getGiaBan() + "");
                edt_hinhanh.setText(sanPham.getHinhAnh() + "");
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sanPham != null) {
                    int id = sanPham.getId();
                    SanPham sanPham = getSanPham();
                    sanPham.setId(id);
                    dbContext.updateSanPham(sanPham, true);
                    loadDuLieu();
                } else {
                    Toast.makeText(getApplicationContext(), "chưa chọn sản phẩm cần sửa", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sanPham != null) {
                    dbContext.deleteSanPham(sanPham.getId());
                    loadDuLieu();
                } else {
                    Toast.makeText(getApplicationContext(), "chưa chọn sản phẩm cần sửa", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void anhXa() {
        edt_tensp = findViewById(R.id.edt_ten);
        edt_loaisp = findViewById(R.id.edt_loai);
        edt_giaban = findViewById(R.id.edt_gia);
        btn_them = findViewById(R.id.btn_them);
        btn_sua = findViewById(R.id.btn_capnhat);
        btn_xoa = findViewById(R.id.btn_xoa);
        edt_timkiem = findViewById(R.id.edt_timkiem);
        lv_sanpham = findViewById(R.id.lv_sanpham);
        edt_hinhanh = findViewById(R.id.edt_hinhanh);
    }

    private SanPham getSanPham() {
        SanPham sanPham = new SanPham();
        sanPham.setTenSP(edt_tensp.getText().toString());
        sanPham.setGiaBan(Integer.parseInt(edt_giaban.getText().toString()));
        sanPham.setLoaiSP(edt_loaisp.getText().toString());
        sanPham.setHinhAnh(edt_hinhanh.getText().toString());
        return sanPham;
    }
}