package business;
import java.io.Serializable;
import java.text.NumberFormat;
public class Product implements Serializable{
    private String code;
    private String description;
    private double price;

    public Product(){
        code = "";
        description = "";
        price = 0;
    }
    public void setCode(String code){//đặt code
        this.code = code;
    }

    public String getCode(){ //lấy code
        return code; 
    }

    public void setDescription(String description){//đặt phần miêu tả
        this.description = description;
    }

    public String getDescription(){ //lấy phần mô tả
        return description; 
    }
    public void setPrice(double price){//đặt giá
        this.price = price;
    }

    public double getPrice(){ //lấy giá
        return price; 
    }

    public String getPriceCurrencyFormat(){//format chuẩn số in ra chữ đô la
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    } 
}
