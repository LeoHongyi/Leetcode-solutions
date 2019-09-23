 import java.util.ListIterator;
 import java.util.List;
 import java.util.ArrayList;

public class GameAutomator {
	private Deck deck;
	private BlackJackHand[] hands;
	private static final int HIT_UNTIL = 16;
	// generate num of Players
	public GameAutomator(int numPlayers) {
		hands = new BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new BlackJackHand();
		}
	}
	// return winners with max score
	public List<Integer> getWinners() {
		List<Integer> winners = new ArrayList<>();
		int winningScore = 0;
		boolean hasBlackJack = false;
		for (int i = 0; i < hands.length; i++) {
			BlackJackHand hand = hands[i];
			// not busted, score <= 21
			if (!hand.busted()) {
				if (hand.score() > winningScore) {
					// update winningScore, can update score 21.
					winningScore = hand.score();
					winners.clear();
					winners.add(i);

				} else if (hand.score() == winningScore && !hasBlackJack) {
					// equal score
					winners.add(i);
				}
				if (hand.isBlackJack()) {
					// isBlackJack()
					if (hasBlackJack) {
						// multiple isBlackJack()
						winners.add(i);
					} else {
						winningScore = hand.score();
						winners.clear();
						winners.add(i);
						hasBlackJack = true;
					}
				}
			}
		}
		return winners;
	}

	public int getScore(int playerID) {
		return hands[playerID].score();
	}

	// return false if the game cannot be successfully simulated.
	public boolean simulate() {
		//dealHand
		initializeDeck();
		return playAllHands();
	}

	public boolean playAllHands() {
		for (BlackJackHand hand : hands) {
			if (!playHand(hand)) {
				return false;
			}
		}
		return true;
	}
	public boolean playHand(BlackJackHand hand) {
		while (hand.score() < HIT_UNTIL) {
			// get one more card
			Card card = deck.dealCard();
			if (card == null) {
				return false;
			}
			hand.addCard(card);
			System.out.println("hand add Card faceValue: " + card.faceValue + " suit: "  + card.suit);
		}
		return true;
	}
	public void initializeDeck() {
		List<Card> cards = new ArrayList<>();
		// generate 52 cards, 13 in each suit
		for (int i = 1; i <= 13; i++) {
			// loop each suit
			for (int j = 0; j <= 3; j++) {
				Suit suit = Suit.getSuitFromValue(j);
//				System.out.println("faceValue: " + i + " suit value: " + j + " suit: " + suit);
				Card card = new Card(i, suit);
				cards.add(card);
			}
		}
		deck = new Deck();
		// add all cards
		deck.setDeckOfCards(cards);
		// shuffle
		deck.shuffle();
	}
	public void printHandsAndScore() {
		for (int i = 0; i < hands.length; i++) {
			// player index, player score
			 System.out.print("Hand: " + i + " Score: (" + hands[i].score() + "): cards: ");
			// player cards detail
			hands[i].print();
			 System.out.println();
		}
	}
}

/**

 **/