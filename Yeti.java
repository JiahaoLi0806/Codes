package pq;

public class Yeti extends Cryptid {
    private double fangLength;

    public Yeti(String name, double fangLength) {
        this.name = name;
        this.fangLength = fangLength;
    }

    @Override
    public void attack() {
        System.out.println(name + " the Yeti attacks with their " + fangLength + " cm fangs!");
    }

    @Override
    public String toString() {
        return "Yeti[name=" + name + ", fangLength=" + fangLength + "cm]";
    }
}


