package ohtu;

/**
 * Created by marko on 8.4.2017.
 */
public class Course {
    private String name;
    private String term;
    public int week1, week2, week3, week4, week5, week6;

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public int getWeek1() {
        return week1;
    }

    public int getWeek2() {
        return week2;
    }

    public int getWeek3() {
        return week3;
    }

    public int getWeek4() {
        return week4;
    }

    public int getWeek5() {
        return week5;
    }

    public int getWeek6() {
        return week6;
    }

    public int getWeek(int weekNum) throws NoSuchFieldException, IllegalAccessException {
        int exerciseNum = (int) this.getClass().getField("week" + weekNum).get(this);
        return exerciseNum;
    }
}
