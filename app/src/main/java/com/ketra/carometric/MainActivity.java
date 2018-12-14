package com.ketra.carometric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;


import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {
    final static int vinLength = 17;
    final static String apiKey = "0e5d4d6d-7fd3-4081-9b0e-3d63fe97c776";
    final static String baseURL = "https://api.groupe-psa.com/connectedcar/v1/dev/";

    //Currently only carsf from the french region are supported
    final static String locale = "fr_FR";

    Button sendBtn;
    EditText vinEntry;
    EditText contractEntry;
    String brand;
    String msg;
    Car carData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendbtn);
        vinEntry = findViewById(R.id.vinNum);
        contractEntry = findViewById(R.id.contractNum);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String vin = vinEntry.getText().toString().toUpperCase();

                //Check if number is valid
                // through a series of basic checks
                // Through wikipedia and ISO standards
                // it was discovered a vin needs to be 17 characters long
                // Exclude Q, I and O to avoid confusion with 0 or 1
                if(vin.length() != vinLength ) {
                    vinEntry.setError("Vin number must be exactly 17 characters long");
                } else if(vin.contains("I") ||
                        vin.contains("O") ||
                        vin.contains("Q")) {
                    vinEntry.setError("Vin number must not contain the letters I, O, Q.");
                } else {

                    // pattern for Citroën VIN is VF7xxxxxxxxxxxxxx.
                    // pattern for Peugeot VIN is VF3xxxxxxxxxxxxxx.
                    // DS specific vin pattern could not be found as of yet.
                    // Source: http://www.citroenpeugeot.com/en/content/vin-vehicle-identification-number
                    switch(brand) {
                        case "":
                            msg = "It seems you have not picked a brand, Please choose to proceed.";
                            break;
                        case "C":
                            msg = "Your vin number does not match with brand you picked, please verify your choice of brand (Citroen vins start with VF7).";

                            if(!vin.startsWith("VF7")) {
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "P":
                            msg = "Your vin number does not match with brand of choice, please verify your choice of brand (Peugeot vins start with VF3).";

                            if(!vin.startsWith("VF3")) {
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                        default:
                            break;
                    }

                    if(!contractEntry.getText().toString().isEmpty()) {
                        //https://api.groupe-psa.com/connectedcar/v1/dev/maintenance/VF73AAHXTFJ807314?contract=620324101&locale=fr_FR&brand=C&client_id=0e5d4d6d-7fd3-4081-9b0e-3d63fe97c776
                        StringBuilder sb = new StringBuilder();
                        sb.append(baseURL);
                        sb.append("maintenance/");
                        sb.append(vin);
                        sb.append("?");
                        sb.append("contract=" + contractEntry.getText().toString());
                        sb.append("&");
                        sb.append("locale=" + locale);
                        sb.append("&");
                        sb.append("brand=" + brand);
                        sb.append("&");
                        sb.append("client_id=" + apiKey);
                        String url = sb.toString();
                        apiCall(url);
                    }
                }

            }
        });


    }

    // Perform a JSON Request to PSA Group Connected Car API
    // Takes a url as a string
    // Uses AsyncHttp library
    private void apiCall(String url) {
        carData = new Car();

        AsyncHttpClient client = new AsyncHttpClient();
        final Type type = new TypeToken<Car>(){}.getType();

        client.get(
                url,
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.v("Error", responseString);
                        Toast.makeText(getApplicationContext(), "The api call was unsuccessful. This may be due to a network error", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.v("Json response", responseString);
//                        GsonBuilder gsonBuilder = new GsonBuilder();
//                        gsonBuilder.registerTypeAdapter(type, new CarDeserializer());
//                        Gson gson = gsonBuilder.create();
//                        Map jsonJavaRootObject = new Gson().fromJson(type, Map.class);
                        HashMap<String, Object> jsonMap = new Gson().fromJson(responseString, HashMap.class);

                        if(jsonMap != null) {
                            Log.v("JSON", jsonMap.toString());
                            Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                            intent.putExtra("map", jsonMap);
                            startActivity(intent);
                        }

//                        carData = gson.fromJson(responseString, type);
//                        if (carData != null) {
//                            Log.v("Info", carData.toString());
////                            Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
////
////                            intent.putExtra("data", carData.toString());
////
////                            startActivity(intent);
//                        }
                    }
                }
        );

//        carData = new Car();
//        RequestQueue queue = Volley.newRequestQueue(this);
//        JSONObject tmp = new JSONObject();
//
//        final Type type = new TypeToken<Car>(){}.getType();
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( url, tmp, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.v("Json respone", response.toString());
//                GsonBuilder gsonBuilder = new GsonBuilder();
//                gsonBuilder.registerTypeAdapter(type, new CarDeserializer());
//                Gson gson = gsonBuilder.create();
//                carData = gson.fromJson(response.toString(), type);
//                if (carData != null) {
//                    Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
//
//                    intent.putExtra("data", carData.toString());
//
//                    startActivity(intent);
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.v("Error",error.toString());
//                Toast.makeText(getApplicationContext(), "The api call was unsuccessful. This may be due to a network error", Toast.LENGTH_SHORT).show();
//            }
//        });
//        queue.add(jsonObjectRequest);

    }

    //Retrieve user choice in brand
    //Currently on Peugeot, Citroen and DS cars are supported
    public void onRadioButtonClicked(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_citroen:
                if(isChecked) {
                    brand = "C";
                }
                break;
            case R.id.radio_ds:
                if(isChecked) {
                    brand = "ds";
                }
                break;
            case R.id.radio_peugeot:
                if(isChecked) {
                    brand = "P";
                }
                break;
        }
    }

    // Perform basic form validation on all elements of the UI requiring user input
//    private void formValidation(String vin, String contract) {
//
//        //Check if number is valid
//        // through a series of basic checks
//        // Through wikipedia and ISO standards
//        // it was discovered a vin needs to be 17 characters long
//        // Exclude Q, I and O to avoid confusion with 0 or 1
//        if(vin.length() > vinLength || vin.length() < vinLength) {
//            vinEntry.setError("Vin number must be exactly 17 characters long");
//        } else if(vin.contains("I") || vin.contains("O") || vin.contains("Q")) {
//            vinEntry.setError("Vin number must not contain the letters I, O, Q.");
//        }
//
//        // pattern for Citroën VIN is VF7xxxxxxxxxxxxxx.
//        // pattern for Peugeot VIN is VF3xxxxxxxxxxxxxx.
//        // DS specific vin pattern could not be found as of yet.
//        // Source: http://www.citroenpeugeot.com/en/content/vin-vehicle-identification-number
//        switch(brand) {
//            case "":
//                msg = "It seems you have not picked a brand, Please choose to proceed.";
//                break;
//            case "C":
//                msg = "Your vin number does not match with brand you picked, please verify your choice of brand (Citroen vins start with VF7).";
//
//                if(!vin.startsWith("VF7")) {
//                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case "P":
//                msg = "Your vin number does not match with brand of choice, please verify your choice of brand (Peugeot vins start with VF3).";
//
//                if(!vin.startsWith("VF3")) {
//                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
//                }
//            default:
//                break;
//        }
//
//    }
}
