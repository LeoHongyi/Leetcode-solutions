import java.util.List;

public class BlackJack {
	public static void main(String[] args) {
		int numHands = 20;
		int decksOfCards = 1;
		System.out.println("numHands: " + numHands + " decksOfCards: " + decksOfCards);
		GameAutomator automator = new GameAutomator(numHands);
		System.out.println("simulate status: " + automator.simulate());
		List<Integer> winnerList = automator.getWinners();
		for (Integer i : winnerList) {
			System.out.println("Winner index: " + i);
		}
		automator.printHandsAndScore();
	}
}