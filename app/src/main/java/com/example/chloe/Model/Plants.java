package com.example.chloe.Model;

import com.google.gson.annotations.SerializedName;

public class Plants {
    @SerializedName("id")
    public String id;
    @SerializedName("nama")
    public String nama;
    @SerializedName("deskripsi")
    public String deskripsi;
    @SerializedName("img_thumb")
    public String img_thumb;
    @SerializedName("img_detail")
    public String img_detail;
    @SerializedName("kategori")
    public String kategori;
    @SerializedName("cara_merawat")
    public String cara_merawat;
    @SerializedName("budidaya")
    public String budidaya;
    @SerializedName("fakta")
    public String fakta;
    @SerializedName("rekomendasi")
    public String rekomendasi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImg_thumb() {
        return img_thumb;
    }

    public void setImg_thumb(String img_thumb) {
        this.img_thumb = img_thumb;
    }

    public String getImg_detail() {
        return img_detail;
    }

    public void setImg_detail(String img_detail) {
        this.img_detail = img_detail;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getCara_merawat() {
        return cara_merawat;
    }

    public void setCara_merawat(String cara_merawat) {
        this.cara_merawat = cara_merawat;
    }

    public String getBudidaya() {
        return budidaya;
    }

    public void setBudidaya(String budidaya) {
        this.budidaya = budidaya;
    }

    public String getFakta() {
        return fakta;
    }

    public void setFakta(String fakta) {
        this.fakta = fakta;
    }

    public String getRekomendasi() {
        return rekomendasi;
    }

    public void setRekomendasi(String rekomendasi) {
        this.rekomendasi = rekomendasi;
    }
}
