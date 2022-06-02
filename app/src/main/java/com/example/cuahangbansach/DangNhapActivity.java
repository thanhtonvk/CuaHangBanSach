package com.example.cuahangbansach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuahangbansach.Database.DBContext;

public class DangNhapActivity extends AppCompatActivity {

    EditText edt_tk, edt_mk;
    DBContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        edt_tk = findViewById(R.id.edt_tk);
        edt_mk = findViewById(R.id.edt_mk);
        dbContext = new DBContext(this);
        findViewById(R.id.btn_dangky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DangKyActivity.class));
            }
        });
        findViewById(R.id.btn_dangnhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edt_tk.getText().toString();
                String mk = edt_mk.getText().toString();
                if (dbContext.dangNhap(tk, mk)) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Tài khoản mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}