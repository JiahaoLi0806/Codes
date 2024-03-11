package pq;

public abstract class Cryptid implements Comparable<Cryptid> {
    protected String name;

    public abstract void attack();

    @Override
    public int compareTo(Cryptid o) {
        return this.name.compareTo(o.name);
    }
}
