package io.github.amaceh.kuisprak1.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.amaceh.kuisprak1.R;
import io.github.amaceh.kuisprak1.activity.API.APIClient;
import io.github.amaceh.kuisprak1.activity.API.APIInterface;
import io.github.amaceh.kuisprak1.activity.Adapter.BarangAdapter;
import io.github.amaceh.kuisprak1.activity.Model.ApiData;
import io.github.amaceh.kuisprak1.activity.Model.Barang;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeActivity extends AppCompatActivity {
    private String TAG = HomeActivity.class.getSimpleName();
    private RecyclerView rcBarang;
    private BarangAdapter adapter;
    private List<Barang> lBarang;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_1);
        setSupportActionBar(toolbar);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        rcBarang = findViewById(R.id.rc_barang);

        lBarang = new ArrayList<Barang>();
        adapter = new BarangAdapter(this, lBarang);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcBarang.setLayoutManager(layoutManager);
        rcBarang.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcBarang.getContext(),
                layoutManager.getOrientation());
        rcBarang.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                syncData();
                return true;
            case R.id.tambah:
                Intent intent = new Intent(this, KelolaActivity.class);
                startActivityForResult(intent, 48);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==48){
            if (resultCode==RESULT_OK){
                Toast.makeText(this, "Tambah Data Berhasil", Toast.LENGTH_SHORT).show();
            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this, "Tambah Data DIbatalkan", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private ApiData<List<Barang>> apiBarang;
    private void syncData(){
        showDialog();
        final Context c = this;
        //sp = getSharedPreferences("io.github.amaceh.backend_prak.user", MODE_PRIVATE);
        //String api_key = sp.getString("api_key", "");

        APIInterface apiService = APIClient.getClient().create(APIInterface.class);
        Call<ApiData<List<Barang>>> call = apiService.getBarang();
        call.enqueue(new Callback<ApiData<List<Barang>>>() {
            @Override
            public void onResponse(Response<ApiData<List<Barang>>> response, Retrofit retrofit) {
                apiBarang = response.body();

                Toast.makeText(c, "Sync Selesai", Toast.LENGTH_LONG).show();
                lBarang.addAll(apiBarang.getData());
                //adapter.notifyItemRangeInserted(0, apiKuliah.getData().size());
                adapter.notifyDataSetChanged();
                hideDialog();
                //Log.e("TAG", "response 33: "+new Gson().toJson(response.body()) );
            }

            @Override
            public void onFailure(Throwable t) {
                hideDialog();
                Log.e(TAG, "onFailure: ", t);
                Toast.makeText(c, "connection error", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog(){
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
