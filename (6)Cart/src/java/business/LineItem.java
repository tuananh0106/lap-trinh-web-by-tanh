package business;
import java.io.Serializable;
import java.text.NumberFormat;
public class LineItem implements Serializable{
    private Product product;
    private int quantity;
//tác dụng tính giá tiền của sản phẩm
    public LineItem() {}//khởi tạo

    public void setProduct(Product p){
        product = p;//nhận product
    }
    public Product getProduct(){ 
        return product;//lấy product
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;//nhận số lượng
    }

    public int getQuantity(){ 
        return quantity; //lấy số lượng
    }

    public double getTotal(){ 
        double total = product.getPrice() * quantity;//lấy giá 
        return total;
    }
    public String getTotalCurrencyFormat(){//format chuẩn số
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
