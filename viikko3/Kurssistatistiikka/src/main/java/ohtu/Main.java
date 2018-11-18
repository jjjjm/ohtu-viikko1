package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String urlSubmission = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String urlCourse = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyTextSubmission = Request.Get(urlSubmission).execute().returnContent().asString();
        String bodyTextCourse = Request.Get(urlCourse).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyTextSubmission, Submission[].class);
        Course[] courses = mapper.fromJson(bodyTextCourse, Course[].class);

        System.out.println("opiskelijanumero: " + studentNr + "\n");
        for (Course course : courses) {

            String statsResponse = Request.Get("https://studies.cs.helsinki.fi/courses/" + course.getName() + "/stats").execute().returnContent().asString();
            JsonParser parser = new JsonParser();
            JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
            String toPrint = "";
            int time = 0;
            int exercises = 0;
            
            for (Submission submission : subs) {
                if (submission.getCourse().equals(course.getName())) {
                    toPrint += ("viikko " + submission.getWeek() + ":\n " + "tehtyjä tehtäviä " + submission.getExercises().size() + "/" + course.getExercises().get(submission.getWeek()) + submission + "\n");
                    time += submission.getHours();
                    exercises += submission.getExercises().size();
                }
            }
            //System.out.println(parsittuData.get("1"));
            if (toPrint.length() > 0) {
                System.out.println(course.toString() + "\n" + toPrint + "\nyhteensä: " + exercises + "/" + course.getExercises().stream().mapToInt(exe -> exe).sum() + " tehtävää " + time + " tuntia\n");
            }
        }
    }
}
