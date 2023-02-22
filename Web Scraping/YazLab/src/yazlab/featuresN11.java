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
public class featuresN11 extends products {

    public featuresN11(String productUrl) {

        String url = productUrl;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("Product");

        // get the User collection from DB
        DBCollection userCollection = db.getCollection("product");
        BasicDBObject bO = new BasicDBObject();
        try {
            Document document = Jsoup.connect(url).get();
            String text = null;
            Elements prod = document.getElementsByClass("proName");
            for (Element p : prod) {
                Elements pr = p.getElementsByTag("h1");
                text = pr.text();

            }
            title = text;

            String temp3 = null;
            Elements puan = document.getElementsByClass("unf-p-title");
            for (Element p : puan) {
                Elements pr = p.getElementsByClass("ratingScore");
                temp3 = pr.text();

            }
            temp3 = temp3.replaceAll("\\.", ".");
            skor = Double.valueOf(temp3);

            Elements image = document.select("div[class].unf-p-img-box");
            for (Element e : image) {
                for (Element l : e.getElementsByTag("a")) {
                    imageUrl = l.absUrl("href");

                }
            }
            String temp2 = null;
            Elements product = document.getElementsByClass("unf-p-detail");
            for (Element e : product) {
                Elements pri = e.getElementsByClass("unf-p-summary-price");
                temp2 = pri.text();

            }
            temp2 = temp2.replaceAll("\\.", "");
            temp2 = temp2.replaceAll("\\,", ".");
            price = Double.valueOf(temp2);

            Elements processor = document.getElementsByClass("unf-attribute-cover");
            for (Element e : processor) {
                Element pro = e.getElementsByClass("unf-attribute-label").first();
                String write = pro.text();
                String p = write.toLowerCase();
                if (p.contains("işlemci") == true) {
                    String[] temp = p.split(" ");
                    String[] gec = new String[temp.length - 1];

                    for (int i = 1; i < temp.length; i++) {
                        gec[i - 1] = temp[i];
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
                }
            }
            Elements feature = document.getElementsByClass("unf-prop-context");
            for (Element f : feature) {
                for (Element feat : f.getElementsByTag("li")) {

                    String write = feat.text();
                    String fe = write.toLowerCase();
                    if (fe.contains("işletim sistemi") == true) {

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

                    } else if (fe.contains("bellek kapasitesi") == true) {
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }
                        if (gec.length == 1) {
                            ram = gec[0];
                        } else if (gec.length == 2) {
                            ram = gec[0] + gec[1];
                        } else if (gec.length == 3) {
                            ram = gec[0] +  gec[1] +  gec[2];
                        } else if (gec.length == 4) {
                            ram = gec[0] + gec[1] +  gec[2] + gec[3];
                        } else if (gec.length == 5) {
                            ram = gec[0] +  gec[1] +  gec[2] + gec[3] + gec[4];
                        }

                    } else if (fe.contains("disk kapasitesi") == true) {
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }

                        if (gec.length == 1) {
                            ssdDiscSize = gec[0];
                        } else if (gec.length == 2) {
                            ssdDiscSize = gec[0] + gec[1];
                        } else if (gec.length == 3) {
                            ssdDiscSize = gec[0] +gec[1] + gec[2];
                        } else if (gec.length == 4) {
                            ssdDiscSize = gec[0] + gec[1]+ gec[2] +  gec[3];
                        } else if (gec.length == 5) {
                            ssdDiscSize = gec[0] + gec[1] +gec[2] +gec[3] + gec[4];
                        }

                    } else if (fe.contains("işlemci modeli") == true) {
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }
                        String gen=gec[gec.length-1];
                        String[] gener=gen.split("-");
                       
                        String gecici=gener[gener.length-1];
                        
                        char[] charr=gecici.toCharArray();
                            if(charr[0]=='1')
                            {
                            processorGeneration=charr[0]+""+charr[1]+".Nesil";
                                
                            }else{
                                 processorGeneration=charr[0]+".Nesil";
                            }


                    } else if (fe.contains("disk türü") == true) {
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 2];
                        for (int i = 2; i < temp.length; i++) {
                            gec[i - 2] = temp[i];
                        }

                        if (gec.length == 1) {
                            discType = gec[0];
                        } else if (gec.length == 2) {
                            discType = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            discType = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            discType = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            discType = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }

                    } else if (fe.contains("ekran boyutu") == true) {
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

                    } else if (fe.contains("marka") == true) {
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 1];
                        for (int i = 1; i < temp.length; i++) {
                            gec[i - 1] = temp[i];
                        }

                        if (gec.length == 1) {
                            brand = gec[0];
                        } else if (gec.length == 2) {
                            brand = gec[0] + " " + gec[1];
                        } else if (gec.length == 3) {
                            brand = gec[0] + " " + gec[1] + " " + gec[2];
                        } else if (gec.length == 4) {
                            brand = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                        } else if (gec.length == 5) {
                            brand = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3] + " " + gec[4];
                        }

                    } else if (fe.contains("model") == true) {
                        String[] temp = fe.split(" ");
                        String[] gec = new String[temp.length - 1];
                        for (int i = 1; i < temp.length; i++) {
                            gec[i - 1] = temp[i];
                        }
                        String gecici = temp[0];
                        if (gecici.equals("model")) {
                            if (gec.length == 1) {

                                modelNo = gec[0];
                            } else if (gec.length == 2) {

                                modelName = gec[0];
                                modelNo = gec[1];
                            } else if (gec.length == 3) {

                                modelName = gec[0] + " " + gec[1];
                                modelNo = gec[2];
                            } else if (gec.length == 4) {

                                modelName = gec[0] + " " + gec[1] + " " + gec[2];
                                modelNo = gec[3];
                            } else if (gec.length == 5) {

                                modelName = gec[0] + " " + gec[1] + " " + gec[2] + " " + gec[3];
                                modelNo = gec[4];
                            }
                        }

                    }

                }
            }
            int caunt = userCollection.find().size();
            if(brand=="msı"){
                brand="msi";
            }
             if(brand=="game garaj"){
                brand="gamegaraj";
            }

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
            bO.put("siteName", "n11");
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
