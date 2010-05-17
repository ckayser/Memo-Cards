package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Card extends Model {
    public String front;
    public String back;

    public Card(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public void flrsfgklsd() {
        System.out.print("");        
    }

}
