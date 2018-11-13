package ui;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import model.Date;
import model.Plan;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile {
    public static void create() throws IOException {
        JsonObject schedule = new JsonObject();
        JsonArray dates = new JsonArray();
        for(Date d : Schedule.getDates()) {
            JsonObject date = new JsonObject();

            JsonArray plans = new JsonArray();

            date.put("date", d.getDate());
            for (Plan p : d.getPlans()) {
                plans.add(p.getActivity());
            }
            date.put("plans", plans);
            dates.add(date);
        }
        schedule.put("dates", dates);

        // try-with-resources statement based on post comment below :)

        FileWriter file = null;
        try {
            file = new FileWriter("saved-planner.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.write(schedule.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
