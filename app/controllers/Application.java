package controllers;

import models.Card;
import play.mvc.*;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        List<Card> cards = Card.findAll();
        render(cards);
    }

    public static void add(Card c) {
        c.save();
    }

    public static void list() {

    }

}