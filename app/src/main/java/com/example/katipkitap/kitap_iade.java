package com.example.katipkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class kitap_iade extends AppCompatActivity {

    Button okut;
    public static TextView resultTextView;
    public static TextView ogrenci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_iade);
        Intent veri = getIntent();
        okut=findViewById(R.id.btn_scan);
        resultTextView=findViewById(R.id.sonuc);
        ogrenci=findViewById(R.id.ogrnumara);
        String ogr_numara=veri.getStringExtra("ogrenci_numarasi");
        okut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),iade_kitap.class));
            }
        });
    }
}
