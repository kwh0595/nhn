public class Product{
    private int no;
    private String name;
    private int price;
    public Product(int no, String name, int price){
        this.no = no;
        this.name = name;
        this.price = price;
    }
    public int getNo(){
        return this.no;
    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public String toString(){
        return this.no+", "+this.name+", "+this.price;
    }
}