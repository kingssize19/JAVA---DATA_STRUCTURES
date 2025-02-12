package com.hayati.linked_list_ogrenci_kayit_uygulamasi;

import java.util.Scanner;


public class Linked_List_Ogrenci_Kayit_Uygulamasi {

    public static void main(String[] args) {
        OgrList ogrenci = new OgrList();
        Scanner scanner = new Scanner(System.in);
        int secim = -1;
        
        while (secim != 0) {
            System.out.println("1) Ogrenci Ekleme Islemi");
            System.out.println("2) Ogrenci Silme Islemi");
            System.out.println("3) Ogrenci Bilgileri Goruntuleme Islemi");
            System.out.println("4) En Basarili Ogrenciyi Goruntule");
            System.out.println("0) Cikis Yap");
            
            System.out.print("Lutfen bir islem seciniz : ");
            secim = scanner.nextInt();
            
            if (secim == 1) {
                ogrenci.ekle();
            }
            else if (secim == 2) {
                ogrenci.sil();
            }
            else if (secim == 3) {
                ogrenci.yazdir();
            }
            else if (secim == 4) {
                ogrenci.enBasariliOgrenci();
            }
            else if (secim == 0) {
                System.out.println("Cikis Yapiliyor..");
                
            }
            else {
                System.out.println("Hatali secim yaptiniz!!!");
            }
                
            
        }
    }
}
