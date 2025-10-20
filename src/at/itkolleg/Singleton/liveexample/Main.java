package at.itkolleg.Singleton.liveexample;

public class Main {
    public static void main(String[] args) {
        Singleton singleton0 = Singleton.getInstance("data");
        Singleton singleton1 = Singleton.getInstance("data");
        Singleton singleton2 = Singleton.getInstance("data");
        Singleton singleton3 = Singleton.getInstance("data");
        Singleton singleton4 = Singleton.getInstance("data");
        System.out.println(singleton0.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        System.out.println(singleton3.hashCode());
        System.out.println(singleton4.hashCode());
    }
}
