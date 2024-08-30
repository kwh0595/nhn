import java.util.Iterator;
public class Test {
    public static void main(String []args){
        ShoppingCart cart = new ShoppingCart(1);
        cart.addProduct(new Product(1, "milk", 5000));
        cart.addProduct(new Product(2, "paparo", 2000));
        cart.addProduct(new Product(3, "ramen", 1500));

        Iterator<Product> i = cart.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

    }
}
