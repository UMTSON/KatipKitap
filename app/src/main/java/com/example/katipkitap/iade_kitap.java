package com.example.katipkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class iade_kitap extends AppCompatActivity  implements ZXingScannerView.ResultHandler {


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

        String kitab="";
        kitap_iade.resultTextView.setText(result.getText());
        vt = new database(this);
        SQLiteDatabase db = vt.getWritableDatabase();
        if(kitap_iade.resultTextView.getText().toString().equals("5449000016645")) {
            kitab="Suç ve Ceza";
            Integer x = db.delete("uyeler","alinan_kitap=?",new String[]{kitab});
            Toast.makeText(getApplicationContext(),Integer.toString(x),Toast.LENGTH_LONG).show();
            if(x>0)
            {
                Intent gecis = new Intent(iade_kitap.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"İade işlemi başarıyla yapılmıştır.",Toast.LENGTH_LONG).show();
                startActivity(gecis);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Veri silinemedi",Toast.LENGTH_LONG).show();
            }
        }
        else if(kitap_iade.resultTextView.getText().toString().equals("8699878420038")) {
            kitab="Vadideki Zambak";
            Integer x = db.delete("uyeler","alinan_kitap=?",new String[]{kitab});
            Toast.makeText(getApplicationContext(),Integer.toString(x),Toast.LENGTH_LONG).show();
            if(x>0)
            {
                Intent gecis = new Intent(iade_kitap.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"İade işlemi başarıyla yapılmıştır.",Toast.LENGTH_LONG).show();
                startActivity(gecis);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Veri silinemedi",Toast.LENGTH_LONG).show();
            }
        }
        else if(kitap_iade.resultTextView.getText().toString().equals("8690632031637")) {
            kitab="Araba Sevdası";
            Integer x = db.delete("uyeler","alinan_kitap=?",new String[]{kitab});
            Toast.makeText(getApplicationContext(),Integer.toString(x),Toast.LENGTH_LONG).show();
            if(x>0)
            {
                Intent gecis = new Intent(iade_kitap.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"İade işlemi başarıyla yapılmıştır.",Toast.LENGTH_LONG).show();
                startActivity(gecis);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Veri silinemedi",Toast.LENGTH_LONG).show();
            }
        }
        else {
            kitab=kitap_iade.resultTextView.getText().toString();
            Integer x = db.delete("uyeler","alinan_kitap=?",new String[]{kitab});
            Toast.makeText(getApplicationContext(),Integer.toString(x),Toast.LENGTH_LONG).show();
            if(x>0)
            {
                Intent gecis = new Intent(iade_kitap.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"İade işlemi başarıyla yapılmıştır.",Toast.LENGTH_LONG).show();
                startActivity(gecis);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Veri silinemedi",Toast.LENGTH_LONG).show();
            }
        }


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
