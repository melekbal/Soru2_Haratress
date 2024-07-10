import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductManagement {
    private List<Products> products;
    private Scanner scanner;
    private List<CartItem> cart;

    public ProductManagement() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(Locale.US);
        this.cart = new ArrayList<>();

    }

    public void addProduct(int num) {
        for(int i = 0; i < num; i++) {
            System.out.println("\nÜrün " + (i + 1) + ":");

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

    public void addToCart() {
        String answer;
        int productsAdded = 0;

        do {
            System.out.println("\nSepete ürün eklemek ister misiniz? (E/H):");
            answer = scanner.nextLine();

            if (!answer.equals("E") && !answer.equals("H")) {
                System.out.println("Geçersiz cevap girdiniz. Lütfen tekrar deneyiniz.");
            } else if (answer.equals("E")) {
                Products productToAdd = null;
                while (productToAdd == null) {
                    System.out.print("Eklemek istediğiniz ürünün adı: ");
                    String productName = scanner.nextLine();
    
                    for (Products product : products) {
                        if (product.getName().equalsIgnoreCase(productName)) {
                            productToAdd = product;
                            break;
                        }
                    }
    
                    if (productToAdd == null) {
                        System.out.println("Ürün bulunamadı. Lütfen geçerli bir ürün adı giriniz.");
                    }
                }
    
                int quantity = 0;
            while (true) {
                System.out.print("Eklemek istediğiniz adet: ");
                quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (quantity <= 0) {
                    System.out.println("Geçersiz adet girdiniz. Lütfen pozitif bir sayı giriniz.");
                    continue;
                } else if (quantity > productToAdd.getStock()) {
                    System.out.println("Yetersiz stok. Maksimum " + productToAdd.getStock() + " adet ekleyebilirsiniz.");
                    continue;
                } else {
                    break;
                }
            }

            double totalPrice = quantity * productToAdd.getPrice();
            cart.add(new CartItem(productToAdd.getName(), quantity, totalPrice));
            System.out.println(productToAdd.getName() + " - Adet: " + quantity + ", Toplam Fiyat: " + totalPrice);
            productsAdded++;
            
        } else if (productsAdded < 2) {
                System.out.println("En az 2 ürün eklemelisiniz.");
            }
            
        } while (productsAdded < 2 || (productsAdded >= 2 && !answer.equals("H")));

        if (!cart.isEmpty()) {
            System.out.println("\nSepetiniz:");
            double cartTotal = 0;
            for (CartItem item : cart) {
                System.out.println(item.getName() + " - Adet: " + item.getQuantity() + ", Toplam Fiyat: " + item.getTotalPrice());
                cartTotal += item.getTotalPrice();
            }
            System.out.println("Sepet Toplamı: " + cartTotal);
        } else {
            System.out.println("Sepetiniz boş.");
        }
        
    }
}