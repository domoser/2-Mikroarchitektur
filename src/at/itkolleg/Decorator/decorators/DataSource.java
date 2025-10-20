package at.itkolleg.Decorator.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}
