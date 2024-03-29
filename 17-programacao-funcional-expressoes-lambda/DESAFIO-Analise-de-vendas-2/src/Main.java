import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = null;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEntre com o caminho do arquivo: ");
            filePath = sc.next();
            //filePath = "C:\\Users\\Pichau\\Desktop\\java-spring-ultimate\\nelio-object-oriented-programing\\Java-Object-Oriented-Programming-Expert\\17-programacao-funcional-expressoes-lambda\\base-de-dados\\base-de-dados.csv";

            Map<String, Double> totalSalesBySeller = calculateTotalSalesBySeller(filePath);

            displayTotalSalesBySeller(totalSalesBySeller);
            sc.close();
        } catch (IOException e) {
            System.out.printf("Erro: %s (O sistema não pode encontrar o arquivo especificado)", filePath);
        }
    }

    private static Map<String, Double> calculateTotalSalesBySeller(String filePath) throws IOException {
        Map<String, Double> totalSalesBySeller = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming the structure of the CSV file matches the Sale class
                Integer month = Integer.parseInt(data[0]);
                Integer day = Integer.parseInt(data[1]);
                String seller = data[2];
                Integer items = Integer.parseInt(data[3]);
                Double total = Double.parseDouble(data[4]);

                Sale sale = new Sale(month, day, seller, items, total);

                // Accumulate total sales for each seller
                totalSalesBySeller.merge(seller, sale.getTotal(), Double::sum);

                // Display details for each sale
                System.out.println(sale.saleDetails());
                System.out.println("Média de preço: R$ " + sale.averagePrice());
                System.out.println("-----------------------------------------");
            }
        }
        return totalSalesBySeller;
    }

    private static void displayTotalSalesBySeller(Map<String, Double> totalSalesBySeller) {
        System.out.println("\nTotal de vendas por vendedor:");

        totalSalesBySeller.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.printf("%s - R$ %.2f%n", entry.getKey(), entry.getValue()));
    }
}