package yazlab;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YazLab {

    public static void main(String[] args) {

        //  addProduct product=new addProduct();
        for (int i = 1; i < 11; i++) {
            String html = "https://www.trendyol.com/sr?wb=105536%2C102324%2C107655%2C111174%2C102932%2C146151%2C110195%2C101470&wc=103108&pi=" + i;
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(html).get();
                org.jsoup.select.Elements product = doc.select("div[class].prdct-cntnr-wrppr");

                for (Element e : product) {
                    for (Element l : e.getElementsByTag("a")) {
                        featuresTrendyol featuresTrendyol = new featuresTrendyol(l.absUrl("href"));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
                        try{
            html = "https://www.n11.com/bilgisayar/dizustu-bilgisayar?pg="+i;
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
                   html = "https://www.hepsiburada.com/hometech-gamegaraj-everest-fujitsu-acer-monster-apple-msi/laptop-notebook-dizustu-bilgisayarlar-c-98?sayfa=" + i;
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
