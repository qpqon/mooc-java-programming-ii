package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Dictionary {
    
    private List<String> words;
    private HashMap<String, String> translations;
    
    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
    }
    
    public String get(String word) {
        return this.translations.get(word);
    }
    
    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }        
        this.translations.put(word, translation);
    }
    
    public boolean contains(String word) {
        return this.words.contains(word);
    }
    
    public boolean isEmpty() {
        return this.words.isEmpty();
    }
    
    public boolean isSparse() {
        return this.words.size() == 1;
    }
    
    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(words.size()));
    }
    
}
