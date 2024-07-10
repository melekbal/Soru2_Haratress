import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        do { 
            System.out.print("Kaç farklı ürün gireceksiniz: ");
            num = scanner.nextInt();
            scanner.nextLine();
            if (num <= 1) {
                System.out.println("1 adetten fazla ürün girmelisiniz.");
            }
        } while (num <= 1);
        
        ProductManagement productManagement = new ProductManagement();
        productManagement.addProduct(num);

        String criterion;
        System.out.println("\nÜrünleri hangi kritere göre sıralamak istersiniz? (name / stock / rating)");
        do { 
            System.err.print("Seçilen Kriter: ");
            criterion = scanner.nextLine();

            if (!criterion.equals("name") && !criterion.equals("stock") && !criterion.equals("rating")){
                System.out.println("Geçersiz kriter girdiniz. Lütfen tekrar deneyiniz.");
            }
        } while ( !criterion.equals("name") && !criterion.equals("stock") && !criterion.equals("rating") );

        String order;
        System.err.println("Sıralama türü artan mı azalan mı olsun? (artan/azalan)");
        do {
            System.out.print("Seçilen Sıralama Türü: ");
            order = scanner.nextLine();

            if (!order.equals("artan") && !order.equals("azalan")){
                System.out.println("Geçersiz sıralama türü girdiniz. Lütfen tekrar deneyiniz.");
            }
        } while ( !order.equals("artan") && !order.equals("azalan") );


        System.err.println("\nSıralanmış Ürünler:");
        productManagement.sortProducts(criterion, order);
        
        // Sepete ekleme ve sepet gösterimi işlemleri
        productManagement.addToCart();
    }
}