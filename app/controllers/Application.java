package controllers;

import models.Card;
import play.data.validation.Valid;
import play.mvc.Controller;

import java.util.List;
import java.util.Random;

public class Application extends Controller {

    public static void index() {
        List<Card> cards = getRandomCards();
        render(cards);
    }

    public static void cards() {
        List<Card> cards = getRandomCards();
        render(cards);
    }

    private static List<Card> getRandomCards() {
        Random random = new Random();
        List<Card> cards = Card.findAll();
        for (Card card : cards) {
            if (random.nextBoolean())
                card.turnOver();
        }
        return cards;
    }

    public static void getAnswer(Long cardId) {
        Card card = Card.findById(cardId);
        renderText(card.getAnswer());
    }

    public static void add(@Valid Card c) {
    	if (validation.hasErrors()) {
    		params.flash();
    		validation.keep();
    		addCard();
    	} else {
    		c.save();
    		index();
    	}
    }
    
    public static void addCard() {
    	render();
    }

    public static void delete(Long id) {
    	Card.findById(id).delete();
    	index();
    }

}