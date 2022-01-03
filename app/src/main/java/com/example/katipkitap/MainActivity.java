package com.example.katipkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button kitap_al,kitap_iade,yonetici,yazilim;
    EditText ogr_numara,yonetici1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kitap_al=findViewById(R.id.button3);
        kitap_iade=findViewById(R.id.button4);
        ogr_numara=findViewById(R.id.editText);
        yonetici=findViewById(R.id.button);
        yonetici1=findViewById(R.id.editText2);
        yazilim=findViewById(R.id.button2);
        kitap_al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ogr_numara.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Lütfen öğrenci numaranızı giriniz..", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent kitap_al = new Intent(MainActivity.this,kitap_al.class);
                    kitap_al.putExtra("ogrenci_numarasi", ogr_numara.getText().toString());
                    startActivity(kitap_al);
                }
            }
        });
        yonetici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yonetici1.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Lütfen geçerli şifreyi giriniz..", Toast.LENGTH_LONG).show();
                }
                else {
                    if(yonetici1.getText().toString().equals("kutuphane81")) {
                        Intent giriss = new Intent(MainActivity.this,kayitlar_1.class);
                        startActivity(giriss);
                        yonetici1.setText("");
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Yanlış şifreyi girdiniz.", Toast.LENGTH_LONG).show();
                        yonetici1.setText("");
                    }
                }


            }
        });
        kitap_iade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent kitap_iade = new Intent(MainActivity.this,kitap_iade.class);
                    kitap_iade.putExtra("ogrenci_numarasi", ogr_numara.getText().toString());
                    startActivity(kitap_iade);
            }
        });
        yazilim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()," Kadir ÇOLAK - Sertan UĞUZLAR - Ümit SÖNMEZ ",Toast.LENGTH_LONG).show();
            }
        });
    }
}
