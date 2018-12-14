package com.ketra.carometric;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;

import static com.loopj.android.http.AsyncHttpClient.log;

public class CarDeserializer implements JsonDeserializer<Car> {
    @Override
    public Car deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Car carData = new Car();

        JsonObject temp = (JsonObject) json.getAsJsonObject().getAsJsonObject("fuel");
        JsonArray jsonArray = temp.getAsJsonArray("fuelTankAlerteLabel");
//        JsonArray jsonArray = (JsonArray) temp.getAsJsonArray();

//        JsonArray jsonArray = (JsonArray) json.getAsJsonArray().get(0);


//        for(int i=0; i < jsonArray.size(); i++) {
//            //How do I tell fuel from maintenance?
//            JsonObject object = (JsonObject) jsonArray.get(i);
//            Log.v("JSON", object.toString());
////            Labels labels = new Labels(object.get("label").getAsString(), object.get("groupLabel").getAsString());
////            carData.getFuel().add(labels);
//        }
        return carData;
    }
}
