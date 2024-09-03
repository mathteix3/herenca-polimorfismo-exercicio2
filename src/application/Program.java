package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("\nProduct #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            String ops = scanner.next();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();

            if(ops.charAt(0) == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = scanner.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));

            }else if (ops.charAt(0) == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                products.add(new UsedProduct(name, price, date));

            }else {
                products.add(new Product(name, price));
            }
        }

        System.out.println("\nPRICE TAGS: ");
        for(Product product: products){
            System.out.println(product);
        }

        scanner.close();
    }
}
