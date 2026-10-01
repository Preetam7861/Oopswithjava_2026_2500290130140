import java.util.*;

class Product {
    int id;
    String name;
    int price;

    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return id + " " + name + " " + price;
    }
}

public class Sorting2 {
    public static void main(String[] args) {

        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product(101, "Laptop", 60000));
        list.add(new Product(102, "Mobile", 60000));
        list.add(new Product(103, "Tablet", 30000));
        list.add(new Product(104, "Mouse", 1000));

        Collections.sort(list, new Comparator<Product>() {

            public int compare(Product p1, Product p2) {

                // Price: highest to lowest
                if (p1.price != p2.price) {
                    return Integer.compare(p2.price, p1.price);
                }

                // Same price: name A-Z
                return p1.name.compareTo(p2.name);
            }
        });

        for (Product p : list) {
            System.out.println(p);
        }
    }
}