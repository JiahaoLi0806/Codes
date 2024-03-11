//Name: Jiahao Li
//Course: CS 4440-03 (35717)
//Professor: Ricky Vargas
//Lab: Threads Lab

// SharedResource class
public class SharedResource {
    private int sharedValue = 0;

    // Getter for sharedValue
    public synchronized int getSharedValue() {
        return sharedValue;
    }

    // Setter for sharedValue
    public synchronized void setSharedValue(int value) {
        sharedValue = value;
    }
}

