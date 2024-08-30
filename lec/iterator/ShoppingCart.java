import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ShoppingCart implements Iterable<Product>{
    int shoppingCartNo;
    List<Product> list;
    public ShoppingCart(int shoppingCartNo){
       this.shoppingCartNo = shoppingCartNo;
       list= new ArrayList<Product>();
    }
    public int getShoppingCartNo(){
        return this.shoppingCartNo;
    }
    public void addProduct(Product p){
        list.add(p);
    }
    public Iterator<Product> iterator(){
        return this.list.iterator();
    }
}
