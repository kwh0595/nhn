import java.util.Iterator;
public class ShoppingCartIterator implements Iterator<Product>{
    ShoppingCart cart;
    int index= 0;
    public ShoppingCartIterator(ShoppingCart cart){
        this.cart = cart;
    }
    @Override
    public boolean hasNext() {
        if(index+1>=cart.getSize()){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public Product next() {
       return cart.get(index++);
    }
}
