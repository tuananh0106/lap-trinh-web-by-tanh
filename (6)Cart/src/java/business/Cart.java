package business;
import java.io.Serializable;
import java.util.ArrayList;
public class Cart implements Serializable{
    private ArrayList<LineItem> items;
//giỏ hàng của chúng ta
    public Cart(){
        items = new ArrayList<LineItem>();//giỏ hàng được hiểu là list của lineitem
    }

    public ArrayList<LineItem> getItems(){ 
        return items;//lấy item
    }
    public int getCount(){ 
        return items.size();//lấy số lượng hàng hóa
    }

    public void addItem(LineItem item){//thêm vào giỏ hàng
        String code = item.getProduct().getCode();//lấy code của sản phẩm
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++){
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)){
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    public void removeItem(LineItem item){
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++){
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)){
                items.remove(i);
                return;
            }
        }
    }
}
