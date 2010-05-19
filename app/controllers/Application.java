package controllers;

import models.Card;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.mvc.*;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        List<Card> cards = Card.findAll();
        render(cards);
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