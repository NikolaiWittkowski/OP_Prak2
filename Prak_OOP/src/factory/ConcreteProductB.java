package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product {
    private BufferedReader reader;
    
    public ConcreteProductB(String filepath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filepath));
    }
    

/*@Override
public String[] leseAusDatei() throws IOException {
	
	String[] cafe = null;
	
    if ("csv".equals(filepath)) {
        try (BufferedReader ein = new BufferedReader(new FileReader("Cafe.csv"))) {
            String[] zeile = ein.readLine().split(";");
            cafe[0] = zeile[0];
            cafe[1] = zeile[1];
            cafe[2] = zeile[2];
            cafe[3] = zeile[3];
            cafe[4] = zeile[4];
        }
    } else {
        throw new UnsupportedOperationException("Dateityp nicht unterstützt.");
    }
    
    return cafe;
    
}*/

    @Override
    public String[] leseAusDatei() throws IOException {
        String[] cafeData = new String[5];
        
        for (int i = 0; i < cafeData.length; i++) {
            String line = reader.readLine();
            if (line != null) {
                cafeData[i] = line;
            } else {
                throw new IOException("fehler");
            }
        }
        return cafeData;
    }

    @Override
    public void schliesseDatei() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}




