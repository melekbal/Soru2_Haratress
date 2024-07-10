import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductManagement {
    private List<Products> products;
    private Scanner scanner;

    public ProductManagement() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US);

    }

    public void addProduct(int num) {
        for(int i = 0; i < num; i++) {
            System.out.println("Ürün " + (i + 1) + ":");

            String name;
            do {
                System.out.print("Ürün Adı: ");
                name = scanner.nextLine();

                if(name.length() <= 0 || name.length() > 20){
                    System.out.println("Ürün adı en az 1 en fazla 20 karakter olmalıdır. Lütfen tekrar giriniz.");
                }
            } while(name.length() <= 0 || name.length() > 20);

            double price;
            do {
                System.out.print("Birim Fiyatı: ");
                price = scanner.nextDouble();

                if(price <= 1 || price >= 100){
                    System.out.println("Birim fiyat 1 ile 100 arasında olmalıdır. Lütfen tekrar giriniz.");
                }
            } while(price <= 1 || price >= 100);
            
            int stock;
            do { 
                System.out.print("Stok Miktarı: ");
                stock = scanner.nextInt();
                if (stock < 1) {
                    System.out.println("Stok miktarı en az 1 adet olmalıdır. Lütfen tekrar giriniz.");
                }
            } while (stock < 1);

            double rating;
            do {
                System.out.print("Değerlendirme Puanı: ");
                rating = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over

                if(rating < 0 || rating > 5){
                    System.out.println("Puan 0 ile 5 arasında olmalıdır. Lütfen tekrar giriniz.");
                }
            } while(rating < 0 || rating > 5);

            products.add(new Products(name, price, stock, rating));
        }
    }

    public void sortProducts(String criterion, String order) {
        if(criterion.equals("name")) {
            if(order.equals("artan")) {
                products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
            } else {
                products.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
            }
        } else if(criterion.equals("stock")) {
            if(order.equals("artan")) {
                products.sort((p1, p2) -> p1.getStock() - p2.getStock());
            } else {
                products.sort((p1, p2) -> p2.getStock() - p1.getStock());
            }
        } else {
            if(order.equals("artan")) {
                products.sort((p1, p2) -> Double.compare(p1.getRating(), p2.getRating()));
            } else {
                products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
            }
        }

        for(Products product : products) {
            System.out.println(product.getName() + " - Fiyat: " + product.getPrice() + " ,  Stok: " + product.getStock() + " , Değerlendirme: " + product.getRating());
        }
    }
}