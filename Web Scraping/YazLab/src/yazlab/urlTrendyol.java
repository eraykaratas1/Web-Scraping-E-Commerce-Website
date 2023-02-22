
package yazlab;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class urlTrendyol {

    public urlTrendyol() {
                for (int i = 1; i < 5; i++) {
            String html = "https://www.trendyol.com/sr?wb=105536%2C102324%2C107655%2C111174%2C102932%2C146151%2C110195%2C101470&wc=103108&pi=" + i;
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect(html).get();
                org.jsoup.select.Elements product = doc.select("div[class].prdct-cntnr-wrppr");

                for (Element e : product) {
                    for (Element l : e.getElementsByTag("a")) {
                        featuresTrendyol featuresTrendyol=new featuresTrendyol(l.absUrl("href"));    
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    }
    
    

