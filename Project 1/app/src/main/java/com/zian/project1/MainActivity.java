package com.zian.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText nama, nim, mtk, bind, bing, fis, bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.etNama);
        nim = findViewById(R.id.etNim);
        mtk = findViewById(R.id.etMtk);
        bind = findViewById(R.id.etBind);
        bing = findViewById(R.id.etBing);
        fis = findViewById(R.id.etFisk);
        bio = findViewById(R.id.etBio);

        Button kirim = findViewById(R.id.kirim);
        kirim.setOnClickListener(v -> {
            if (nama.getText().toString().length()==0){
                nama.setError("Inputan Tidak Boleh Kosong");
            } else if (nim.getText().toString().length() == 0) {
                nim.setError("Inputan Tidak Boleh Kosong");
            } else if (mtk.getText().toString().length() == 0) {
                mtk.setError("Inputan Tidak Boleh Kosong");
            } else if (bind.getText().toString().length() == 0) {
                bind.setError("Inputan Tidak Boleh Kosong");
            } else if (bing.getText().toString().length() == 0) {
                bing.setError("Inputan Tidak Boleh Kosong");
            } else if (fis.getText().toString().length() == 0) {
                fis.setError("Inputan Tidak Boleh Kosong");
            } else if (bio.getText().toString().length() == 0) {
                bio.setError("Inputan Tidak Boleh Kosong");
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putString("NAMA", Objects.requireNonNull (nama.getText()).toString());
                bundle.putString("NIM", Objects.requireNonNull(nim.getText()).toString());
                bundle.putString("MTK", Objects.requireNonNull(mtk.getText()).toString());
                bundle.putString("BIND", Objects.requireNonNull(bind.getText()).toString());
                bundle.putString("BING", Objects.requireNonNull(bing.getText()).toString());
                bundle.putString("FIS", Objects.requireNonNull(fis.getText()).toString());
                bundle.putString("BIO", Objects.requireNonNull(bio.getText()).toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtras(bundle);

                Toast.makeText(getApplicationContext(), "Data Berhasil di Simpan", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }
}