//Name: Jiahao Li
//Course: CS 4440-03 (35717)
//Professor: Ricky Vargas
//Lab: Threads Lab

// Task 1: Setup and Basic Thread Creation
public class Task1 {
    public static void main(String[] args) {
        // Creating and starting Thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Creating and starting Thread 2
        Thread thread2 = new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println(c);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        // Waiting for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
