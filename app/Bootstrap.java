import models.Card;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        if (Card.count() == 0)
            Fixtures.load("initial-data.yml");
    }
}
