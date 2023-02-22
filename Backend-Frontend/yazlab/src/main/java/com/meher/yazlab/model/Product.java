package com.meher.yazlab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product")
public class Product {

    @Id
    int _id;
    String marka;               // MARKA
    String modelNo ;             // MODEL NO
    String OS ;                  // İŞLETİM SİSTEMİ
    String modelName ;           // MODEL ADI
    String processorType ;       // İŞLETİM TİPİ
    String processorGeneration ;  //İŞLEMCİ NESLİ
    String ram ;                 //RAM
    String ssdDiscSize ;            //DİSK BOYUTU
    String hardDiscSize ;            //DİSK BOYUTU
    String discType ;            //DİSK TÜRÜ
    String screenSize ;          // EKRAN BOYUTU
    double skor = 0;                // PUANI
    double price =0;              // FİYATI
    String siteName ;            // SİTE İSMİ
    String imageUrl ;
    String title ;
    String productUrl;




}
