package _05_06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Store {

    // Make this method a synchronized method
    static synchronized void purchase(StockChecker stockChecker, int amount) {
        int stock = stockChecker.getStock();
        if(stock - amount < 0) {
            System.out.println("Out of stock");
        } else {
            System.out.println("Item is in stock");
            stockChecker.updateStock(amount);
            System.out.println(amount + " items purchased");
        }
        System.out.println("Current stock: " + stockChecker.getStock());
    }

    public static void main(String[] args) {
        StockChecker stockChecker = new StockChecker();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> purchase(stockChecker, 20));
        executorService.submit(() -> purchase(stockChecker, 20));
        executorService.submit(() -> purchase(stockChecker, 20));
        executorService.submit(() -> purchase(stockChecker, 20));

        executorService.shutdown();

        // Create a new StockChecker object.

        // Create an ExecutorService with a fixed thread pool of 4 threads

        // Submit 4 tasks to the executor service.

        // In each task you should call the purchase method and pass in 20,
        // to represent a customer purchasing 20 items.

        // Shut down the executor service.

    }

}
