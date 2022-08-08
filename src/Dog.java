import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
//
//        if (this.size < uddaDog.size) {
//            return -1;
//        } else if (this.size == uddaDog.size) {
//            return 0;
//        }
//        return 1;
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

}
