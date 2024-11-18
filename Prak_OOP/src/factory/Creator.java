package factory;

import java.io.IOException;

public abstract class Creator {
    public abstract Product createCr(String type) throws IOException;
}
