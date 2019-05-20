package shop;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import com.microsoft.sqlserver.jdbc.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import javax.naming.Context;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet(
        name="ShoppingCartServlet",
        urlPatterns={
                "/products",
                "/viewProductDetails",
                "/addToCart",
                "/viewCart",
                "/deleteItem"
        }
)
public class ShoppingCartServlet extends HttpServlet {

    private List<Product> products = new ArrayList<Product>();

    private Connection conn = null;

    @Override
    public void init() throws ServletException {

        super.init();

        String sql = "select * from product;";

        try{
            //Class.forName(driver);
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/shop");

            Connection conn = ds.getConnection();
            this.conn = conn;
        }
        catch(Exception e){
            System.out.println("捕获到抛出的异常"+e);
        }

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("在这");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                float price = rs.getFloat(4);
                products.add(new Product(id,name,description,price));
            }
        }
        catch(SQLException e){
            System.out.println("捕获到抛出的异常: "+e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int productId = 0;
        int quantity = 0;
        try{
            productId = Integer.parseInt(req.getParameter("id"));
            quantity = Integer.parseInt(req.getParameter("quantity"));


        }
        catch(NumberFormatException e){
            System.out.println(e);
        }

        Product product = getProduct(productId);
        if(product!=null&&quantity>=0){
            ShoppingItem shoppingItem = new ShoppingItem(product,quantity);
            HttpSession session = req.getSession();
            List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute("cart");

            if(cart==null){
                cart = new ArrayList<ShoppingItem>();
                session.setAttribute("cart",cart);

            }

            cart.add(shoppingItem);
        }

        String requestURL = req.getRequestURI();

        if(requestURL.endsWith("/products")){
            showProductList(resp);
        }
        else if(requestURL.endsWith("/viewProductDetails")){
            showProductDetails(resp,req);
        }
        else if(requestURL.endsWith("viewCart")){
            showCart(req,resp);
        }
        else if(requestURL.endsWith("deleteItem")){

        }

    }



    private void showProductList(HttpServletResponse response)
        throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>商品列表</title></head><body><p>商品列表</p>");
        out.println("<ul>");
        for(Product product: products){
           out.println("<li>"+product.getName()+"("+"" +
                   "" + product.getPrice()+
                   ")(" + "<a href='viewProductDetails?id="
                   + product.getId()+
                   "'>详细信息</a>)");
        }

        out.println("</ul>");
        out.println("<a href='viewCart'>查看购物车</a>");
        out.println("</body></html>");
    }

    private void showProductDetails(HttpServletResponse response,
                                    HttpServletRequest request)
        throws IOException{
        PrintWriter out = response.getWriter();
        int productId = 0;
        try{
            productId = Integer.parseInt(request.getParameter("id"));
        }
        catch(NumberFormatException nfe){
            System.out.println(nfe);
        }

        Product product = getProduct(productId);

        if(product!=null){
            out.println("<html><head>" +
                    "<title>商品详细信息</title></head>" +
                    "<body><p>商品详细信息</p>" +
                    "<form method='post' action='addToCart'>");
            out.println("<input type='hidden' name='id'" +
                    "value='" + productId +"' />");
            out.println("<table>");
            out.println("<tr><td>商品名:</td><td>" +
                    product.getName() + "</td></tr>");


            out.println("<tr><td>说明:</td><td>" +
                    product.getDescription() + "</td></tr>");


            out.println("<tr><td>价格:</td><td>" +
                    product.getPrice() + "</td></tr>");

            out.println("<tr>" + "<tr>" +
                    "<td><input name='quantity'/></td>" +
                    "<td><input type='submit' value='购买'/>" +
                    "</td>" +
                    "</tr>");

            out.println("<tr><td colspan='2'>" +
                    "<a href='products'>商品列表</a>" +
                    "</td></tr>");

            out.println("</table>");
            out.println("</form></body></html>");
        }
        else{
            out.println("No product  found");
        }
    }

    private Product getProduct(int productId){
        for(Product product:products){
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }

    private void showCart(HttpServletRequest request,
                          HttpServletResponse response)
        throws IOException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>购物车</title></head>");
        out.println("<body><a href='products'" +
                "商品列表</a>");

        HttpSession session = request.getSession();
        List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute("cart");

        if(cart!=null){
            out.println("<table>");
            out.println("<tr><td style='width:50px'>数量" +
                    "</td>" +
                    "<td style='width:80px'>商品</td>" +
                    "<td style='width:80px'>价格</td>" +
                    "<td style='width:80px'>小计</td>" +
                    "<td style='width:80px'>是否删除</td>" +
                    "</tr>");

            double total = 0;
            for(ShoppingItem shoppingItem:cart){
                Product product = shoppingItem.getProduct();
                int quantity = shoppingItem.getQuantity();
                if(quantity!=0){
                    float price = product.getPrice();
                    out.println("<tr>");
                    out.println("<td>"+quantity+"</td>");
                    out.println("<td>"+product.getName()+"</td>");
                    out.println("<td>"+price+"</td>");
                    double subtotal = ((int)(price * quantity * 100 + 0.5))/100.00;
                    out.println("<td>"+subtotal+"</td>");
                    out.println("<td><a href='deleteItem?id='" +
                            product.getId()+ ">"+ "删除</a>" + "</td>" +
                            "");

                    total += subtotal;
                    out.println("</tr>");

                }
            }

            out.println("<tr><td colspan='4'" +
                    "style='text-align:right'>" +
                    "总计:"+total+"</td></tr>");

            out.println("</table>");
        }

        out.println("</table></body></html>");

    }


}
