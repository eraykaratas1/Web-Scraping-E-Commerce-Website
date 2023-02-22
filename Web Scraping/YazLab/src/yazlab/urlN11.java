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
public class urlN11 {

    public urlN11() {

        for (int i = 1; i < 5; i++) {
            try{
            String html = "https://www.n11.com/bilgisayar/dizustu-bilgisayar?pg="+i;
                org.jsoup.nodes.Document doc = Jsoup.connect(html).get();
                org.jsoup.select.Elements product = doc.select("div[class].catalogView");
                for (Element e : product) {
                    for (Element l : e.getElementsByTag("a")) {
                        featuresN11 featuresN11 = new featuresN11(l.absUrl("href"));
                      
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
