package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "014445334";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url1 = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        String url2 = "https://ohtustats2017.herokuapp.com/courses/1.json";

        String bodyText1 = Request.Get(url1).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText1 );
        System.out.println(bodyText2);


        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText1, Submission[].class);
        Course course = mapper.fromJson(bodyText2, Course.class);

        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm());
        for (Submission submission : subs) {
            System.out.println(submission + "(maksimi " + course.getWeek(submission.getWeek()) + ")");
        }

    }
}
