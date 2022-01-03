package com.example.katipkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class alinan_kitap extends AppCompatActivity  implements ZXingScannerView.ResultHandler {


    ZXingScannerView ScannerView;
    database vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
        Toast.makeText(getApplicationContext(),"QR kodu veya BARKODU alana yerleştiriniz.",Toast.LENGTH_LONG).show();
    }

    @Override
    public void handleResult(Result result) {

        String kitab;
        Date tarih = new Date();
        SimpleDateFormat bugun = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        kitap_al.resultTextView.setText(result.getText());
        vt = new database(this);
        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ogr_numara",kitap_al.ogrenci.getText().toString());
        cv.put("kitap_tarih",bugun.format(tarih).toString());
        if(kitap_al.resultTextView.getText().toString().equals("5449000016645")) {
            kitab="Suç ve Ceza";
            cv.put("alinan_kitap", "Suç ve Ceza");
        }
        else if(kitap_al.resultTextView.getText().toString().equals("8699878420038")) {
            kitab="Vadideki Zambak";
            cv.put("alinan_kitap", "Vadideki Zambak");
        }
        else if(kitap_al.resultTextView.getText().toString().equals("8690632031637")) {
            kitab="Araba Sevdası";
            cv.put("alinan_kitap", "Araba Sevdası");
        }
        else {
            kitab=kitap_al.resultTextView.getText().toString();
            cv.put("alinan_kitap", kitap_al.resultTextView.getText().toString());
        }
        db.insert("uyeler",null,cv);
        Intent gecis = new Intent(alinan_kitap.this, MainActivity.class);
        Toast.makeText(getApplicationContext(),kitap_al.ogrenci.getText().toString()+" numaralı öğrecinin  "+kitab.toString()+" adlı kitap kaydı başarıyla yapılmıştır",Toast.LENGTH_LONG).show();
        startActivity(gecis);
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }
}
