package JavaMultithreading;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CrimeWave {
    Random r = new Random();
    
    Queue<Crime> crimes = new PriorityQueue<>();
        
    Integer committed = 0;
    Integer solved = 0;

    public void meanStreets() {
        Detective d1 = new Detective("d1");
        Detective d2 = new Detective("d2");
        Criminal c1 = new Criminal("c1");
        Criminal c2 = new Criminal("c2");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(d1);
        Thread t4 = new Thread(d2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    
        while (t1.isAlive() || t2.isAlive()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        System.out.println("committed: " + committed);
        System.out.println("solved: " + solved);
    }

    public synchronized void commitCrime(Crime c) {
        crimes.offer(c);
        committed++;
    }

    public synchronized void solveCrimes(String name) {
        try {
            while (crimes.isEmpty())
                Thread.sleep(25);

            Crime crime = crimes.poll();
            int s = crime.seriousness;
            
            solved++;
            System.out.println(name + " solves a crime of seriousness " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CrimeWave c = new CrimeWave();
        c.meanStreets();
        System.exit(0);
    }

    private class Crime implements Comparable<Crime> {
        int seriousness;

        public Crime(int s) {
            this.seriousness = s;
        }

        @Override
        public int compareTo(Crime o) {
            // Sort in descending order so high seriousness crimes are dealt with first
            return o.seriousness - this.seriousness;
        }
    }

    private class Criminal implements Runnable {
        String name;

        private Criminal(String nameIn) {
            name = nameIn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(r.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int s = (r.nextInt(5));
                Crime c = new Crime(s);
                System.out.println(name + " commits a crime of seriousness " + s);
                commitCrime(c);
            }
        }
    }

    private class Detective implements Runnable {
        String name;

        public Detective(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (committed > solved) {
                try {
                    Thread.sleep(60);
                    solveCrimes(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
