package cart;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.*;
import data.*;
public class CartServlet extends HttpServlet{
     protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response)
                       throws ServletException,IOException{
        String productCode = request.getParameter("productCode");//để lấy thông tin trong cart.jsp code
        String quantityString = request.getParameter("quantity");//để lấy thông tin trong cart.jsp phần quatity
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");//lấy thông tin cart của cả phiên cho hiện tại
        if (cart == null) cart = new Cart();
        int quantity = 1;//số lượng hàng
        try{
            quantity = Integer.parseInt(quantityString);//cover từ kiểu String sang int của số lượng nếu có giá trị là null thì thực hiện gắn giá trị là 1
            if (quantity < 0)
            quantity = 1;
        }
        catch(NumberFormatException nfe){
            quantity = 1;
        }
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/products.txt");//lấy địa chỉ đặt hàng trong web
        Product product = ProductIO.getProduct(productCode, path);//chuyền vào productio
        LineItem lineItem = new LineItem();//tạo 1 cái line item mới , để thực hiện lưu trữ trong tin
        lineItem.setProduct(product);//cài đặt sản phẩm vào listitem
        lineItem.setQuantity(quantity);//cài đặt số lượng hàng
        if (quantity > 0) cart.addItem(lineItem);//thêm sản phẩm vào giỏ hàng
        else if (quantity == 0) cart.removeItem(lineItem);//nếu bằng 0 thực hiện xóa item đó đi
        session.setAttribute("cart", cart);//đật lại thông tin của cart trong cả phiên(cập nhật)
        String url = "/cart.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
     }
}
