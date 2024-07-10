import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private List<Products> products;
    private Scanner scanner = new Scanner(System.in);

    public ProductManagement() {
        this.products = new ArrayList<>();
    }

    public void addProduct(int num) {
        for(int i = 0; i < num; i++) {
            System.out.println("Ürün " + (i + 1) + ":");
            System.out.print("Ürün Adı: ");
            String name = scanner.nextLine();
            System.out.print("Birim Fiyatı: ");
            double price = scanner.nextDouble();
            System.out.print("Stok Miktarı: ");
            int stock = scanner.nextInt();
            System.out.print("Değerlendirme Puanı: ");
            double rating = scanner.nextDouble();
            scanner.nextLine();
            products.add(new Products(name, price, stock, rating));
        }
    }
}

