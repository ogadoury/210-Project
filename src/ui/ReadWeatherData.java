package ui;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWeatherData {

    public static void main() throws IOException {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?id=6173331&APPID=610eb61b2ea81c0a65074e44ee3bbeb4");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            JsonObject json = (JsonObject) Jsoner.deserialize(br);
            JsonObject city = (JsonObject) json.get("city");
            JsonArray list = (JsonArray) json.get("list");
            JsonObject weatherCont = (JsonObject) list.get(0);
            JsonArray weather = (JsonArray) weatherCont.get("weather");
            JsonObject weatherObj = (JsonObject) weather.get(0);
            String curWeather = (String) weatherObj.get("description");


            //Print current weather to console
            System.out.println("The current weather in " + city.get("name") + " is " + curWeather + ".");
        } catch (JsonException e) {
            e.printStackTrace();
        }


    }
}

