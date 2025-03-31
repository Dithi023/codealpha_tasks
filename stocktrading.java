import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class stocktrading
 {
    private static double cashBalance = 10000.0;
    private static final Map<String, Double> stockPrices = new HashMap<>();
    private static final Map<String, Integer> stockPortfolio = new HashMap<>();
    public static void main(String[] args) 
    {
        stockPrices.put("APPLE", 150.0);
        stockPrices.put("GOOGLE", 2800.0);
        stockPrices.put("AMAZON", 3400.0);
        stockPrices.put("TESLA", 650.0);
        Scanner sc = new Scanner(System.in);
        int choice;
        do
         {
            System.out.println("\nWelcome to the Stock Trading Platform!");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Cash Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    viewStocks();
                    break;
                case 2:
                    buyStock(sc);
                    break;
                case 3:
                    sellStock(sc);
                    break;
                case 4:
                    viewPortfolio();
                    break;
                case 5:
                    viewCashBalance();
                    break;
                case 6:
                    System.out.println("Exiting the platform. Thank you for using our service!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        sc.close();
    }
    private static void viewStocks()
     {
        System.out.println("\nAvailable Stocks:");
        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) 
        {
            System.out.printf("%s: $%.2f\n", entry.getKey(), entry.getValue());
        }
    }
    private static void buyStock(Scanner scanner) 
    {
        System.out.print("Enter the stock symbol you want to buy (e.g., APPLE): ");
        String stockSymbol = scanner.next();
        if (!stockPrices.containsKey(stockSymbol))
        {
            System.out.println("Stock symbol not found.");
            return;
        }
        System.out.print("Enter the quantity of " + stockSymbol + " you want to buy: ");
        int quantity = scanner.nextInt();
        double stockPrice = stockPrices.get(stockSymbol);
        double totalCost = stockPrice * quantity;

        if (totalCost > cashBalance) 
        {
            System.out.println("Insufficient funds! You need $" + totalCost + " but only have $" + cashBalance);
            return;
        }
        cashBalance -= totalCost;
        stockPortfolio.put(stockSymbol, stockPortfolio.getOrDefault(stockSymbol, 0) + quantity);

        System.out.printf("Successfully bought %d shares of %s for $%.2f each. Total cost: $%.2f\n", 
                          quantity, stockSymbol, stockPrice, totalCost);
    }
    private static void sellStock(Scanner scanner) 
    {
        System.out.print("Enter the stock symbol you want to sell (e.g., APPLE): ");
        String stockSymbol = scanner.next();
        if (!stockPortfolio.containsKey(stockSymbol)) {
            System.out.println("You don't own any shares of " + stockSymbol);
            return;
        }
        System.out.print("Enter the quantity of " + stockSymbol + " you want to sell: ");
        int quantity = scanner.nextInt();
        int ownedQuantity = stockPortfolio.get(stockSymbol);
        if (quantity > ownedQuantity) 
        {
            System.out.println("You don't have enough shares of " + stockSymbol + " to sell.");
            return;
        }
        double stockPrice = stockPrices.get(stockSymbol);
        double totalRevenue = stockPrice * quantity;
        stockPortfolio.put(stockSymbol, ownedQuantity - quantity);
        cashBalance += totalRevenue;
        System.out.printf("Successfully sold %d shares of %s for $%.2f each. Total revenue: $%.2f\n",  quantity, stockSymbol, stockPrice, totalRevenue);
    }
    private static void viewPortfolio()
     {
        System.out.println("\nYour Portfolio:");
        if (stockPortfolio.isEmpty()) 
        {
            System.out.println("You don't own any stocks.");
        } else 
        {
            for (Map.Entry<String, Integer> entry : stockPortfolio.entrySet())
             {
                System.out.printf("%s: %d shares\n", entry.getKey(), entry.getValue());
            }
        }
    }
    
    private static void viewCashBalance()
     {
        System.out.printf("\nYour Cash Balance: $%.2f\n", cashBalance);
    }
}