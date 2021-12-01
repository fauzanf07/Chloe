package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.chloe.Adapter.ListPlantsAdapter;
import com.example.chloe.Model.GetPlants;
import com.example.chloe.Model.Plants;
import com.example.chloe.R;
import com.example.chloe.Rest.ApiClient;
import com.example.chloe.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final  String EXTRA_KATEGORI = "extra_kategori";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        mRecycleView = (RecyclerView)  findViewById(R.id.rv_list_tanaman);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        data();

    }

    public void data(){
        Call<GetPlants> PlantsCall = mApiInterface.getPlants("get_plants_"+getIntent().getStringExtra(EXTRA_KATEGORI));
        PlantsCall.enqueue(new Callback<GetPlants>() {
            @Override
            public void onResponse(Call<GetPlants> call, Response<GetPlants> response) {
                List<Plants> listPlants = response.body().getListDataPlants();
                Log.d("Retrofit Get", "Jumlah data Tanaman : " +
                        String.valueOf(listPlants.size()));
                ListPlantsAdapter listPlantsAdapter = new ListPlantsAdapter(listPlants);
                mRecycleView.setAdapter(listPlantsAdapter);
                listPlantsAdapter.setOnItemCallBack(new ListPlantsAdapter.OnItemCallBack() {
                    @Override
                    public void onItemClicked(Plants data) {
                        showSelectedData(data);
                    }
                });
            }

            @Override
            public void onFailure(Call<GetPlants> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void showSelectedData(Plants data){
        Intent kirimData = new Intent(ListActivity.this,MenuPilihan.class);
        kirimData.putExtra(MenuPilihan.EXTRA_NAMA,data.getNama());
        kirimData.putExtra(MenuPilihan.EXTRA_DESKRIPSI,data.getDeskripsi());
        kirimData.putExtra(MenuPilihan.EXTRA_IMGPOSTER,data.getImg_detail());
        kirimData.putExtra(MenuPilihan.EXTRA_CARA_MERAWAT,data.getCara_merawat());
        kirimData.putExtra(MenuPilihan.EXTRA_BUDIDAYA,data.getBudidaya());
        kirimData.putExtra(MenuPilihan.EXTRA_FAKTA,data.getFakta());
        kirimData.putExtra(MenuPilihan.EXTRA_REKOMENDASI,data.getRekomendasi());
        startActivity(kirimData);
    }
}