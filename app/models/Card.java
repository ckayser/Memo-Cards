package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Card extends Model {
	@Required
    public String front;
	@Required
    public String back;

    public Card(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public void flrsfgklsd() {
        System.out.print("");        
    }

}
