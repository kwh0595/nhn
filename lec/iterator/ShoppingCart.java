
import java.util.Iterator;
public class ShoppingCart implements Iterable<Product>{
    int shoppingCartNo;
    Product [] list;
    int index = 0;
   // List<Product> list;
    public ShoppingCart(int shoppingCartNo){
       this.shoppingCartNo = shoppingCartNo;
       list = new Product[100];
    }
    public int getShoppingCartNo(){
        return this.shoppingCartNo;
    }
    public void addProduct(Product p){
        list[index++] = p;
    }
    public Product get(int index){
        return list[index];
    }
    public int getSize(){
        return index+1;
    }
    @Override
    public Iterator<Product> iterator() {
        return new ShoppingCartIterator(this);
    }
}
