package io.github.amaceh.kuisprak1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import io.github.amaceh.kuisprak1.R;
import io.github.amaceh.kuisprak1.activity.Model.Barang;

public class KelolaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola);
        Spinner sp_jenis = findViewById(R.id.sp_jenis);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.l_jenis, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sp_jenis.setAdapter(adapter);

    }

    public void doSomething(Barang baru){

    }
}
