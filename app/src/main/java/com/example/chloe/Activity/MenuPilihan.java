package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chloe.Config;
import com.example.chloe.R;
import com.google.android.material.card.MaterialCardView;

public class MenuPilihan extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_DESKRIPSI = "extra_deskripsi";
    public static final String EXTRA_IMGPOSTER = "extra_imageposter";
    public static final String EXTRA_CARA_MERAWAT = "extra_caramerawat";
    public static final String EXTRA_BUDIDAYA = "extra_budidaya";
    public static final String EXTRA_FAKTA = "extra_fakta";
    public static final String EXTRA_REKOMENDASI = "extra_rekomendasi";
    private boolean openPilClick, pilClick;
    TextView tvName, tvNameClick, deskripsiLengkap, caraMerawat, budidaya;
    ImageView imgView, close_pil;
    MaterialCardView open_pil;
    CardView pil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pilihan);
        getSupportActionBar().hide();
        this.openPilClick = true;
        this.pilClick = false;

        tvName = findViewById(R.id.plant_name);
        tvNameClick = findViewById(R.id.plant_name_click);
        deskripsiLengkap = findViewById(R.id.deskripsi_lengkap);
        imgView = findViewById(R.id.img_poster);
        open_pil = findViewById(R.id.open_pil);
        close_pil = findViewById(R.id.close_pil);
        pil = findViewById(R.id.pil);
        pil.setVisibility(View.GONE);


        caraMerawat = findViewById(R.id.caraMerawat);
        budidaya = findViewById(R.id.budidaya);


        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String imgPoster = getIntent().getStringExtra(EXTRA_IMGPOSTER);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);

        tvName.setText(nama);
        tvNameClick.setText(nama);
        deskripsiLengkap.setText(deskripsi);
        Glide.with(MenuPilihan.this)
                .load(Config.IMAGES_URL + imgPoster)
                .into(imgView);

        open_pil.setOnClickListener(this);
        close_pil.setOnClickListener(this);
        caraMerawat.setOnClickListener(this);
        budidaya.setOnClickListener(this);
    }

    public void slideUp(View v){
        v.setVisibility(v.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                v.getHeight(),
                0
        );
        animate.setDuration(500);
        animate.setFillAfter(true);
        v.startAnimation(animate);
    }

    public void slidedown(View v){
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                0,
                v.getHeight()
        );
        animate.setDuration(500);
        animate.setFillAfter(true);
        v.startAnimation(animate);
        v.setVisibility(v.GONE);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.open_pil && this.openPilClick==true){
            slidedown(open_pil);
            slideUp(pil);
            this.openPilClick = false;
            this.pilClick = true;
        }
        if(v.getId() == R.id.close_pil && this.pilClick == true){
            slidedown(pil);
            slideUp(open_pil);
            this.openPilClick = true;
            this.pilClick = false;
        }
        if(v.getId() == R.id.caraMerawat){
            Intent alihkan = new Intent(MenuPilihan.this, DetailPilihan.class);
            alihkan.putExtra(DetailPilihan.EXTRA_LINK, getIntent().getStringExtra(EXTRA_CARA_MERAWAT));
            alihkan.putExtra(DetailPilihan.EXTRA_PILIHAN,"Cara Merawat");
            startActivity(alihkan);
        }
        if(v.getId() == R.id.budidaya){
            Intent alihkan = new Intent(MenuPilihan.this, DetailPilihan.class);
            alihkan.putExtra(DetailPilihan.EXTRA_LINK, getIntent().getStringExtra(EXTRA_BUDIDAYA));
            alihkan.putExtra(DetailPilihan.EXTRA_PILIHAN,"Budidaya");
            startActivity(alihkan);
        }
    }
}