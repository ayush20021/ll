package com.example.kyakare;

import Flipkart.Flipkartdata;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin

public class product_scrarer {

    @GetMapping("/search/flipkart/{keyword}")

    public List<Flipkartdata> search (@PathVariable  String keyword) throws IOException {

        String prfix ="https://www.flipkart.com/search?q=";
        String subfix = keyword;
        List<Flipkartdata> fdata = new ArrayList<Flipkartdata>();

        String   s = prfix+subfix;

        Document doc = Jsoup.connect(s).get();

        Elements productElements = doc.select("._4rR01T");

        ArrayList a = new ArrayList<>();

        ArrayList b = new ArrayList<>();

        ArrayList d = new ArrayList<>();






        for (Element productElement : productElements) {
            String productName = productElement.text();
            //System.out.println(productName);
            String a1 = productName;
           // System.out.println("https://www.flipkart.com/search?q="+productName);
            a.add(a1);

        }
        Elements elements = doc.select("._30jeq3._1_WHN1");
        for (Element element : elements) {
            String text = element.text();
            //System.out.println(text);
            b.add(text);

        }

        for (int i= 0;i<=3;i++){
//                System.out.print(a.get(i)+ " ");
//                System.out.print(b.get(i));
//
//                System.out.println();
            //String b1 = (String) a.get(i);
            String url = "https://www.flipkart.com/search?q=";
            String prefix = (String) a.get(i);;
//            String full = url+prefix;
//            System.out.println(full);
            String c1 = prefix.replaceAll(" ","");
            //String c2 = c1.replaceAll("","");
            //System.out.println(url+prefix.replaceAll(" ",""));
            //d.add(url);
         //   System.out.println(url+"Final Added url");
            String a1 = (String) a.get(i);
            String a2 = (String) b.get(i);
            String a3 = "https://www.flipkart.com/search?q="+c1;
            //String c1 = (String) d.get(i);


            fdata.add(new Flipkartdata(a1,a2,a3));






        }

        return fdata;

















    }

    @GetMapping("/search/amazon/{keyword}")

    public List<data> search1 (@PathVariable String keyword) throws IOException {
        //String url = "https://www.amazon.in/s?k=iphone";
       // Scanner sc = new Scanner(System.in);
        String prefix = "https://www.amazon.in/s?k=";
        System.out.println("Enter the product name to search");
        String suffix = keyword;
        String   search = prefix+suffix;
        List<Proxy> proxyList = getProxies();
        int try1 =0;
        ArrayList a = new ArrayList<>();
        ArrayList b = new ArrayList<>();
        ArrayList d = new ArrayList<>();
        List<data> data1 = new ArrayList<data>();

//        String Name;
//        int Price;

        for (int i = 0; i < proxyList.size(); i++) {
            Proxy proxy = proxyList.get(i);
            try {
                try1++;
                Document doc = Jsoup.connect(search)
                        .proxy(proxy)
                        .get();
                Elements titleElements = doc.select(".a-size-medium.a-color-base.a-text-normal");
                String title = titleElements.get(0).text();

                for (Element titleElement:titleElements) {
                    String productName = titleElement.text();
                    //System.out.println(productName);
                    a.add(productName);

                }

                Elements priceElements = doc.select("span.a-price-whole");
                String price = priceElements.get(0).text();
                //ArrayList b = new ArrayList<>();
                for (Element priceElement:priceElements) {
                    String price1 = priceElement.text();
                    //System.out.println(productName);
                    b.add(price1);

                }
                //ArrayList d = new ArrayList<>();

//                System.out.println("Title: " + title);
//                System.out.println("Price: " + price);
                System.out.println(try1);

                for (int j= 0;j<=3;j++){
//                    System.out.print(a.get(j)+ " ");
//                    System.out.print(b.get(j));
                   // String url = "https://www.amazon.in/s?k=";
                    String prefix1 = (String) a.get(i);;
                    String data = a.get(j)+" "+b.get(j);
                    String c1 = prefix1.replaceAll(" ","");
                    String a3 = "https://www.amazon.in/s?k="+c1;
                    d.add(data);
                    //sdata.add( new data((String) a.get(j), (Integer) b.get(j)));
                    String a1 = (String) a.get(j);
                    String a2 = (String) b.get(j);
                    data1.add(new data(a1,a2,a3));



                }
                System.out.println("Data Found On IP :"+proxy);

//                for(int i = 0;i<10;i++){
//
//                    // sdata.add(new data(a1,a2));
//                    //System.out.println(sdata);
//                    //System.out.println("OK");
//
//                }

                break;


  //
//
//                break;
//                Elements productElements = doc.select("span.a-size-medium.a-color-base");
//
//                ArrayList a = new ArrayList<>();
//
//                ArrayList b = new ArrayList<>();
//
//
//                ArrayList d = new ArrayList<>();
//
//
//                // adding tittle Scrapedata
//                for (Element productElement : productElements) {
//                    String productName = productElement.text();
//                    //System.out.println(productName);
//                    a.add(productName);
//
//                }
//
//                // adding  price Scrapedata
//                Elements elements = doc.select("span.a-price-whole");
//                for (Element element : elements) {
//                    String text = element.text();
//                    //System.out.println(text);
//                    b.add(text);
//
//                }
//
//                // Adding  Scrapedata to single array
//
//                for (int j= 0;i<=3;i++){
//                System.out.print(a.get(j)+ " ");
//                System.out.print(b.get(j));
//
//                System.out.println();

//                    String Scrapedata = a.get(j)+" "+b.get(j);
//                    d.add(Scrapedata);










            } catch (Exception e) {
                System.out.println("Failed to connect using proxy: " + proxy);
                //ArrayList c = new ArrayList<>();

                if (i == proxyList.size() - 1) {
                    System.out.println("All proxies  failed, exiting...");
                    d.add("All proxies are failed, exiting");
                   // break;
                    //return  c;
                }
            }

        }












        return data1;
    }

    private List<Proxy> getProxies() throws IOException {

        String url = "https://www.sslproxies.org/";
        Document doc = Jsoup.connect(url).get();
        Elements ipElements = doc.select("td:nth-child(1)");
        Elements portElements = doc.select("td:nth-child(2)");
        List<Proxy> proxies = new ArrayList<>();
        for (int i = 0; i < ipElements.size()-12; i++) {
            String ip = ipElements.get(i).text();
            String port = portElements.get(i).text();
            proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, Integer.parseInt(port))));
//
//        }

//        for (int i = 0; i < 20; i++) {
//            String ip = ipElements.get(i).text();
//            String port = portElements.get(i).text();
//            System.out.println("IP: " + ip + ", Port: " + port);}
//
        }
        return proxies;
    }





}
