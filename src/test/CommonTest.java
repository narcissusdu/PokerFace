package test;

import java.util.ArrayList;

import card.Card;
import card.CardSet;
import card.FiveCards;
import card.FullCardBuilder;
import card.fiveCardsComparator;
import cmn.LogUtils;

public class CommonTest {
	public static void main(String[] args) throws Exception {
		
		LogUtils.setLogLevel(2);
		TestBuildCard();
		
	}

	@SuppressWarnings("unused")
	private static void TestFiveCardsComparator() throws Exception {
		//
		CardSet cardSet = new CardSet();
		cardSet.washCard();
		FiveCards fiveCard1 = new FiveCards();
		FiveCards fiveCard2 = new FiveCards();
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());

		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());

		fiveCard1.showCards();
		fiveCard2.showCards();

		System.out.println(new fiveCardsComparator().compare(fiveCard1,
				fiveCard2));

	}

	private static void TestBuildCard() throws Exception {
		CardSet cardSet = new CardSet();
		cardSet.washCard();

		ArrayList<Card> riverCardList = new ArrayList<Card>();
		riverCardList.add(cardSet.getRandomCard());
		riverCardList.add(cardSet.getRandomCard());
		riverCardList.add(cardSet.getRandomCard());
		riverCardList.add(cardSet.getRandomCard());
		riverCardList.add(cardSet.getRandomCard());
		ArrayList<Card> knownCardList = new ArrayList<Card>();

		knownCardList.add(cardSet.getRandomCard());
		knownCardList.add(cardSet.getRandomCard());
		for (int i = 0; i < riverCardList.size(); i++)
			riverCardList.get(i).showCard();
		System.out.println();
		for (int i = 0; i < knownCardList.size(); i++)
			knownCardList.get(i).showCard();

		FullCardBuilder fcb = new FullCardBuilder();		
		long startTime = System.nanoTime(); // 获取开始时间
		fcb.ProcessCards(riverCardList, knownCardList);
		long endTime = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) / 1000000 + "ms");
	}
}
