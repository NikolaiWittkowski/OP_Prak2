package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
    private BufferedReader reader;
    
    public ConcreteProductA(String filepath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filepath));
    }

    @Override
    public String[] leseAusDatei() throws IOException {
        String[] cafeData = new String[5];
        
        String line = reader.readLine();  
        if (line != null) {
            cafeData = line.split(";"); 
        } else {
            throw new IOException();
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


