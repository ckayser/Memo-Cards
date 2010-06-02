package controllers;

import models.Card;
import play.cache.Cache;
import play.db.jpa.JPASupport;
import play.mvc.*;

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

    public static void add(Card c) {
        c.save();
    }

    public static void list() {

    }

}