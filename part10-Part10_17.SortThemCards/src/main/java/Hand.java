
import java.util.ArrayList;
import java.util.Collections;


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        this.cards.stream()
                .forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand other) {
        int thisSum  = this.cards.stream().mapToInt(Card::getValue).sum();
        int otherSum = other.cards.stream().mapToInt(Card::getValue).sum();
        
        return Integer.compare(thisSum, otherSum);
    }
    
    
}
