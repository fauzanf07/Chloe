package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
        Call<GetPlants> PlantsCall = mApiInterface.getPlants("get_plants_indoor_daun");
        PlantsCall.enqueue(new Callback<GetPlants>() {
            @Override
            public void onResponse(Call<GetPlants> call, Response<GetPlants> response) {
                List<Plants> listPlants = response.body().getListDataPlants();
                Log.d("Retrofit Get", "Jumlah data Tanaman : " +
                        String.valueOf(listPlants.size()));
                ListPlantsAdapter listPlantsAdapter = new ListPlantsAdapter(listPlants);
                mRecycleView.setAdapter(listPlantsAdapter);

            }

            @Override
            public void onFailure(Call<GetPlants> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}