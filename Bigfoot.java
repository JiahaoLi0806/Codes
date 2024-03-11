package pq;

public class Bigfoot extends Cryptid {
    private int shoeSize;

    public Bigfoot(String name, int shoeSize) {
        this.name = name;
        this.shoeSize = shoeSize;
    }

    @Override
    public void attack() {
        System.out.println(name + " the Bigfoot stomps with their size " + shoeSize + " feet!");
    }

    @Override
    public String toString() {
        return "Bigfoot[name=" + name + ", shoeSize=" + shoeSize + "]";
    }
}