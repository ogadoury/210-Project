package ui;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import model.Date;
import model.Plan;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadJSONFile {
    public static void run () {
        String jsonFilePath = "saved-planner.txt";

        try  {
            FileReader fileReader = new FileReader(jsonFilePath);
            JsonObject json = (JsonObject) Jsoner.deserialize(fileReader);
            JsonArray dates = (JsonArray) json.get("dates");

            for (Object d : dates){
                JsonObject day = (JsonObject) d;
                String date = (String) day.get("date");
                JsonArray plans = (JsonArray) day.get("plans");
                Date newDate = new Date();
                newDate.setDate(date);
                for (Object plan : plans) {
                    Plan p = new Plan();
                    p.setActivity(plan.toString());
                    newDate.addPlan(p);
                }
                Schedule.addDate(newDate);
            }

//            JsonArray dates = (JsonArray) json.get("dates");
//            System.out.println("Current dates: ");
//            System.out.println("\n");
//            for (Object d : dates) {
//                System.out.println(d);
//
//                ArrayList<Plan> plans = new ArrayList<>();
//                for (int i = 0; i<=dates.size(); i++) {
//
//
//                }
//            }
            System.out.println("\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonException e) {
            e.printStackTrace();
        }
    }
}
