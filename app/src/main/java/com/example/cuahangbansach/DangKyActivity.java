package com.example.cuahangbansach;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuahangbansach.Database.DBContext;
import com.example.cuahangbansach.Entity.TaiKhoan;

public class DangKyActivity extends AppCompatActivity {

    EditText edt_tk, edt_mk, edt_ngaysinh, edt_diachi, edt_hoten;
    DBContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        edt_tk = findViewById(R.id.tv_taikhoan);
        edt_mk = findViewById(R.id.tv_matkhau);
        edt_ngaysinh = findViewById(R.id.tv_ngaysinh);
        edt_diachi = findViewById(R.id.tv_diachi);
        edt_hoten = findViewById(R.id.tv_hoten);
        dbContext = new DBContext(this);
        findViewById(R.id.btn_dangky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edt_tk.getText().toString();
                String mk = edt_mk.getText().toString();
                String ngaysinh = edt_ngaysinh.getText().toString();
                String diachi = edt_diachi.getText().toString();
                String hoten = edt_hoten.getText().toString();
                TaiKhoan taiKhoan = new TaiKhoan(tk, mk, hoten, ngaysinh, diachi);
                if (dbContext.dangKy(taiKhoan) > 0) {
                    Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Đăng ký thất bại", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}