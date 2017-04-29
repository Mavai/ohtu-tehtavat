package statistics.matcher;

/**
 * Created by Marko Vainio on 29.4.2017.
 */
public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder() {
        matcher = new And();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int count, String param) {
        this.matcher = new And(matcher, new HasAtLeast(count, param));
        return this;
    }

    public QueryBuilder hasFewerThan(int count, String param) {
        this.matcher = new And(matcher, new HasFewerThan(count, param));
        return this;
    }

    public QueryBuilder Not(Matcher matcher) {
        this.matcher = new And(this.matcher, new Not(matcher));
        return this;
    }

    public QueryBuilder Or(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    public Matcher build() {
        Matcher newMatcher = matcher;
        matcher = new And();
        return newMatcher;
    }
}
