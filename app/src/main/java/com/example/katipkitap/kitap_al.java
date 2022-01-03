package com.example.katipkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class kitap_al extends AppCompatActivity {

    Button okut;
    public static TextView resultTextView;
    public static TextView ogrenci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_al);
        okut=findViewById(R.id.btn_scan);
        Intent veri = getIntent();
        resultTextView=findViewById(R.id.sonuc);
        ogrenci=findViewById(R.id.ogrnumara);
        ogrenci.setText(veri.getStringExtra("ogrenci_numarasi"));
        okut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),alinan_kitap.class));
            }
        });
    }
}
