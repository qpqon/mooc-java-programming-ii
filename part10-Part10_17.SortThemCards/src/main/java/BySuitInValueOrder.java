
import java.util.Comparator;


/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class BySuitInValueOrder implements Comparator<Card> {
    
    @Override
    public int compare(Card c1, Card c2) {
        int suitComparison = Integer.compare(c1.getSuit().ordinal(), c2.getSuit().ordinal());
        if (suitComparison != 0) {
            return suitComparison;
        }
        return Integer.compare(c1.getValue(), c2.getValue());
    }
}
