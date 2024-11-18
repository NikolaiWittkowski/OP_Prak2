package factory;

import java.io.IOException;

public class ConcreteCreator extends Creator {
    @Override
    public Product createCr(String type) throws IOException {
        if ("csv".equalsIgnoreCase(type)) {
            return new ConcreteProductA(type);
        } else if ("txt".equalsIgnoreCase(type)) {
            return new ConcreteProductB(type);
        } else {
            throw new IllegalArgumentException("Unbekannter Dateityp: " + type);
        }
    }
}
