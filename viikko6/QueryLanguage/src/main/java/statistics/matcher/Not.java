package statistics.matcher;

import statistics.Player;

/**
 * Created by Marko Vainio on 29.4.2017.
 */
public class Not implements Matcher{
    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        return matcher.matches(p) ? false : true;
    }
}
