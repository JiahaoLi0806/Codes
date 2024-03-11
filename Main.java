//Name: Jiahao Li
//Course: CS 4440-03 (35717)
//Professor: Ricky Vargas
//Lab: Threads Lab

// Main Java File
public class Main {
    public static void main(String[] args) {
        // Creating shared resource
        SharedResource sharedResource = new SharedResource();

        // Creating and starting Thread 3
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (sharedResource) {
                    int value = sharedResource.getSharedValue();
                    value++;
                    sharedResource.setSharedValue(value);
                    System.out.println("Thread 3: Incremented Value: " + value);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Creating and starting Thread 4
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (sharedResource) {
                    int value = sharedResource.getSharedValue();
                    value--;
                    sharedResource.setSharedValue(value);
                    System.out.println("Thread 4: Decremented Value: " + value);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread3.start();
        thread4.start();

        // Waiting for both threads to complete
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
