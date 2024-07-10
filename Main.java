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


    }
}