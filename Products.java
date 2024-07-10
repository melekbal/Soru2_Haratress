public class Products {
    private String name;
    private double price;
    private int stock;
    private double rating;

    public Products(String name, double price, int stock, double rating) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getRating() {
        return rating;
    }

    
}
