package data;

import business.Product;
import java.io.*;
import java.util.*;


public class ProductIO {

    public static Product getProduct(String code, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));//đọc file

            String line = in.readLine();//đọc dòng
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");//tách từ
                String productCode = t.nextToken();//productCode là phần tử đầu tiên
                if (code.equalsIgnoreCase(productCode)) {//nếu code có giá trị bằng productCode thì ...
                    String description = t.nextToken();//lấy phần miêu tả
                    double price = Double.parseDouble(t.nextToken());//lấy phần giá 
                    Product p = new Product();//Gắn bằng 1 cái product mới
                    p.setCode(code);//cài đặt các thuộc tính như là code, miêu tảm,giá cho sản phẩm đó
                    p.setDescription(description);
                    p.setPrice(price);
                    in.close();
                    return p;//trả về sản phẩm
                }
                line = in.readLine();//nếu không phải thì đọc dòng tiếp theo
            }
            in.close();//đóng luồng
            return null;//không có sản phẩm trả về null
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);
                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
}