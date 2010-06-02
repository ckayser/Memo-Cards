package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Card extends Model {
    public String front;
    public String back;

    public static Card newCard(String front, String back) {
        Card card = new Card();
        card.front = front;
        card.back = back;
        return card;
    }

    /**
     * Face visible de la carte Vaut true si la carte est à l'endroit (ie: la
     * face avant est visible)
     */
    @Transient
    public boolean turnedOver;
    @Transient
    private String answer;

    /**
     * Retourne la carte
     */
    public void turnOver() {
        if (turnedOver) {
            answer = back;
            turnedOver = false;
        } else {
            answer = front;
            turnedOver = true;
        }

    }

    public String getAnswer() {
        if (answer == null)
            answer = back;
        return answer;
    }
}
