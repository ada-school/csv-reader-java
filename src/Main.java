import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;

public class Main {
    public static void main(String[] args) {
        List<Product> ProductList = new ArrayList<>();
        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                //System.out.println(productInfo[0]);
                //System.out.println(line);
                //TODO implement the logic to transform this code so it can convert the information in each line into a Product objet
                String name = productInfo[0].toString();
                String description = productInfo[1].toString();
                String category = productInfo[2].toString();
                String tags = productInfo[3].toString();
                Float price = Float.parseFloat(productInfo[4].trim());
                String imageUrl = " ";
                if (productInfo[5].toString() != null) {
                    imageUrl = productInfo[5].toString();
                }
                Product Product = new Product(name, description, category, tags, price, imageUrl);
                ProductList.add(Product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Product product : ProductList) {
            System.out.println(product);
        }
    }
}