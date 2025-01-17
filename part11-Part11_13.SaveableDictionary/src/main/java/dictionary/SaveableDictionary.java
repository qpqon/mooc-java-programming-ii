
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private String file;
    
    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }
    
    public boolean load() {
        try {
            Files.lines(Paths.get(this.file)) // Files.lines() liest eine String-Datei Zeile für Zeile, erwartet einen file PATH als parameter und gibt einen Stream<String> aus. Paths.get() wandelt einen String als Parameter in einen PATH um. 
                    .map(l -> l.split(":")) // Hier wird das Element des streams, eine line, gesplittet an der Stelle des Doppelpunktes.
                    .forEach(parts -> { // Es ergeben sich String[] parts (0, 1), welche im folgenden in die HashMap dictionary geladen werden.
                        this.dictionary.put(parts[0], parts[1]);
                        this.dictionary.put(parts[1], parts[0]);
                    });
            return true;
        } catch (IOException e) {
            System.out.println("Error loading file" + e.getMessage());
            return false;
        }
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(new File(file));
            ArrayList<String> redundantTranslation = new ArrayList<>();
            
            this.dictionary.keySet().stream()
                    .forEach(k -> {
                        if (redundantTranslation.contains(k)) {
                            return;
                        }
                        redundantTranslation.add(k);
                        redundantTranslation.add(this.dictionary.get(k));
                        writer.println(k + ":" + dictionary.get(k));
                    });
                    writer.close();
                    return true;
                    
        } catch (FileNotFoundException e) {
            System.out.println("Error file not found" + e.getMessage());
            return false;
        }
    }
    
    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, translation);
        this.dictionary.putIfAbsent(translation, word);
    }
    
    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } 
        return null;
    }
    
    public void delete(String word) {
        if (this.dictionary.containsKey(word)) {
            String translation = this.dictionary.get(word);
            this.dictionary.remove(word);
            this.dictionary.remove(translation);
        }
    }
}
