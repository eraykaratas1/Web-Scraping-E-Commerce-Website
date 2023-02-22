/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 *
 * @author akdme
 */
public class urlHepsiburada {

    public urlHepsiburada() {
        for (int i = 1; i < 5; i++) {
            String html = "https://www.hepsiburada.com/hometech-gamegaraj-everest-fujitsu-acer-monster-apple-msi/laptop-notebook-dizustu-bilgisayarlar-c-98?sayfa=" + i;
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(html).get();
                org.jsoup.select.Elements product = doc.select("li[class].productListContent-zAP0Y5msy8OHn5z7T_K_");
                for (Element e : product) {
                    for (Element l : e.getElementsByTag("a")) {

                        featuresHepsiburada featuresHepsiburada = new featuresHepsiburada(l.absUrl("href"));

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
