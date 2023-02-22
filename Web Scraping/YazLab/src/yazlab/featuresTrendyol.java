/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author akdme
 */
public class featuresTrendyol extends products {

    public featuresTrendyol(String productUrl) {

        String url = productUrl;

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("Product");

            DBCollection userCollection = db.getCollection("product");
            BasicDBObject bO = new BasicDBObject();
            Document document = Jsoup.connect(url).get();
            String text = null;
            Elements prod = document.getElementsByClass("pr-new-br");
            for (Element p : prod) {
                Elements pr = p.getElementsByTag("h1");
                text = pr.text();

            }
            title = text;
            Elements image = document.select("div[class].gallery-container");
            for (Element e : image) {
                Elements imag = e.getElementsByTag("img");
                imageUrl = imag.attr("src");

            }
            String[] dizi = text.split(" ");
            String marka = dizi[0].toLowerCase();
            if (marka.contains("apple") == true) {
                brand = dizi[0].toLowerCase();
                modelName = dizi[1];
                modelNo = dizi[dizi.length - 1];
            } else if (marka.contains("monster") == true) {

                brand = dizi[0].toLowerCase();
                modelName = dizi[1] + " " + dizi[2];
                modelNo = dizi[3];
            } else if (marka.contains("msı") == true) {

                brand = "msi";
                modelName = dizi[1] + " " + dizi[2];
                modelNo = dizi[3];
            } else if (marka.contains("acer") == true) {

                brand = dizi[0].toLowerCase();
                modelName = dizi[1] + " " + dizi[2];
                modelNo = dizi[dizi.length - 1];
            } else if (marka.contains("everest") == true) {

                brand = dizi[0].toLowerCase();
                modelName = dizi[1];
                modelNo = dizi[2];
            } else if (marka.contains("fujitsu") == true) {

                brand = dizi[0].toLowerCase();
                modelName = dizi[1];
                modelNo = dizi[dizi.length - 1];
            } else if (marka.contains("game") == true) {

                brand = dizi[0].toLowerCase() + dizi[1].toLowerCase();
                modelName = dizi[2];
                modelNo = dizi[3];
            } else if (marka.contains("hometech") == true) {

                brand = dizi[0].toLowerCase();
                modelName = dizi[1];
                modelNo = dizi[2];

            }
            String temp2 = null;
            Elements product = document.select("div[class].pr-in-cn");
            for (Element e : product) {
                Elements pri = e.getElementsByClass("prc-dsc");
                temp2 = pri.text();
            }
            String[] tl = temp2.split(" ");
            temp2 = tl[0].replaceAll("\\.", "");
            temp2 = temp2.replaceAll("\\,", ".");
            price = Double.valueOf(temp2);

            Elements feature = document.getElementsByClass("detail-attr-container");
            int say = 1;
            int ramCaunter = 1;
            int featCounter = 1;
            for (Element f : feature) {

                for (Element feat : f.getElementsByTag("li")) {
                    String write = feat.text();
                    say++;
                    String fe = write.toLowerCase();

                    if (fe.contains("işletim sistemi") == true) {

                        featCounter++;
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];

                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }

                        if (gec.length == 1) {
                            OS = gec[0];
                        } else if (gec.length == 2) {
                            OS = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            OS = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            OS = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            OS = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }
                    } else if (fe.contains("işlemci tipi") == true) {

                        featCounter++;

                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }
                        if (gec.length == 1) {
                            processorType = gec[0];
                        } else if (gec.length == 2) {
                            processorType = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            processorType = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            processorType = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            processorType = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }
                    } else if (fe.contains("işlemci nesli") == true) {

                        featCounter++;
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }
                        if (gec.length == 1) {
                            processorGeneration = gec[0];
                        } else if (gec.length == 2) {
                            processorGeneration = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            processorGeneration = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            processorGeneration = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            processorGeneration = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }
                    } else if (fe.contains("ram") == true) {
                        if (ramCaunter == 1) {
                            featCounter++;
                            String[] temp = fe.split(" ");
                            String[] gec = new String[temp.length - 3];
                            if (temp.length == 5) {
                                for (int i = 3; i < temp.length; i++) {
                                    gec[i - 3] = temp[i];
                                }
                                if (gec.length == 1) {
                                    ram = gec[0];
                                } else if (gec.length == 2) {
                                    ram = gec[0] + gec[1];
                                } else if (gec.length == 3) {
                                    ram = gec[0] + gec[1] +gec[2];
                                } else if (gec.length == 4) {
                                    ram = gec[0] +gec[1] + gec[2] + gec[3];
                                } else if (gec.length == 5) {
                                    ram = gec[0] + gec[1] +  gec[2] + gec[3] + gec[4];
                                }
                            }
                        }
                        ramCaunter++;
                    } else if (fe.contains("ssd kapasitesi") == true) {

                        featCounter++;

                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }

                        if (gec.length == 1) {
                            ssdDiscSize = gec[0];
                        } else if (gec.length == 2) {
                            ssdDiscSize = gec[0] +gec[1];
                        } else if (gec.length == 3) {
                            ssdDiscSize = gec[0] + gec[1] +  gec[2];
                        } else if (gec.length == 4) {
                            ssdDiscSize = gec[0] + gec[1] +gec[2] + gec[3];
                        } else if (gec.length == 5) {
                            ssdDiscSize = gec[0] +  gec[1] +  gec[2] +  gec[3] +gec[4];
                        }

                        discType = "ssd";

                    } else if (fe.contains("harddisk kapasitesi") == true) {

                        featCounter++;
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }

                        if (gec.length == 1) {
                            hardDiscSize = gec[0];
                        } else if (gec.length == 2) {
                            hardDiscSize = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            hardDiscSize = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            hardDiscSize = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            hardDiscSize = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }

                        discType = "hdd";
                    } else if (fe.contains("ekran boyutu") == true) {

                        featCounter++;
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }
                        if (gec.length == 1) {
                            screenSize = gec[0];
                        } else if (gec.length == 2) {
                            screenSize = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            screenSize = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            screenSize = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            screenSize = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }
                    }
                }
            }
            
            
            
            int caunt = userCollection.find().size();

            bO.put("_id", (caunt)+1);
            bO.put("marka", brand);
            bO.put("modelName", modelName);
            bO.put("modelNo", modelNo);
            bO.put("OS", OS);
            bO.put("processorType", processorType);
            bO.put("processorGeneration", processorGeneration);
            bO.put("ram", ram);

            bO.put("ssdDiscSize", ssdDiscSize);
            bO.put("hardDiscSize", hardDiscSize);
            bO.put("discType", discType);
            bO.put("screenSize", screenSize);
            bO.put("siteName", "Trendyol");
            bO.put("skor", skor);
            bO.put("price", price);
            bO.put("imageUrl", imageUrl);
            bO.put("title", title);
            bO.put("productUrl", productUrl);

            userCollection.insert(bO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
