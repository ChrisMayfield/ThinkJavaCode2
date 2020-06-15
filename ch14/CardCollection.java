import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of playing cards.
 */
public class CardCollection {

    private String label;
    private ArrayList<Card> cards;

    /**
     * Constructs an empty collection.
     */
    public CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<Card>();
    }

    /**
     * Returns the label of the card collection.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Returns a string representation of the card collection.
     */
    public String toString() {
        return label + ": " + cards.toString();
    }

    /**
     * Adds the given card to the collection.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Removes and returns the card with the given index.
     */
    public Card popCard(int i) {
        return cards.remove(i);
    }

    /**
     * Removes and returns the last card.
     */
    public Card popCard() {
        int i = cards.size() - 1;    // from the end of the list
        return popCard(i);
    }

    /**
     * True if the collection is empty, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns the number of cards.
     */
    public int size() {
        return cards.size();
    }

    /**
     * Returns the card with the given index.
     */
    public Card getCard(int i) {
        return cards.get(i);
    }

    /**
     * Returns the last card.
     */
    public Card lastCard() {
        int i = cards.size() - 1;
        return cards.get(i);
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    /**
     * Randomly permute the cards.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapCards(i, j);
        }
    }

    /**
     * Moves n cards from this collection to the given collection.
     */
    public void deal(CardCollection that, int n) {
        for (int i = 0; i < n; i++) {
            Card card = popCard();
            that.addCard(card);
        }
    }

    /**
     * Moves all remaining cards to the given collection.
     */
    public void dealAll(CardCollection that) {
        int n = cards.size();
        deal(that, n);
    }

}
