import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        do { 
            System.out.print("Kaç farklı ürün gireceksiniz: ");
            num = scanner.nextInt();
            scanner.nextLine();
        } while (num < 1);
        


    }
}