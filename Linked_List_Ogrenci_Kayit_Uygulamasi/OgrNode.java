package com.hayati.linked_list_ogrenci_kayit_uygulamasi;

public class OgrNode {
    
    
    int numara;
    String ad;
    String soyad;
    int vize;
    int fin; 
    double ortalama;
    String durum;
    
    OgrNode next;
    
    
    //Constructor
    public OgrNode(int numara, String ad, String soyad, int vize, int fin) {
        this.numara = numara;
        this.ad = ad;
        this.soyad = soyad;
        this.vize = vize;
        this.fin = fin;

        this.ortalama = vize * 0.4 + fin * 0.6;
        
        if (this.ortalama >= 50) {
            this.durum = "Gecti";
        }
        else {
            this.durum = "Kaldi";
        }
        
        this.next = null;
    }
    
}
