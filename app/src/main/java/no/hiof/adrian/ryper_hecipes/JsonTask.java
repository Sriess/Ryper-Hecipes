package no.hiof.adrian.ryper_hecipes;

import android.content.SyncStatusObserver;
import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by adrian on 3/14/2015.
 */
public class JsonTask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {
        // Get recipes from server
        String theWholeBunch = getAllRecipesFrom(RecipeListActivity.COOKBOOK);
        return theWholeBunch;
    }

    private String getAllRecipesFrom(String cookbook) {
        String response = "Nothing yet";
        try {
            URL you = new URL(cookbook);
            HttpURLConnection con = (HttpURLConnection) you.openConnection();
            con.setDoInput(true);
            con.setRequestProperty("Content-Type",
                    "application/json;charset=utf-8");
            con.setRequestProperty("Connection","close");

            int status = con.getResponseCode();
            switch (status) {
                case 200:
                    response = readResponse(con);
                    return new JSONArray(response).toString();
            }
            con.disconnect();
        } catch (MalformedURLException e) {
            // The URL is incorrect, probably attempting to use an unknown protocol
            e.printStackTrace();
        } catch (IOException e) {
            // An error occurs while opening the connection
            e.printStackTrace();
        } catch (JSONException e) {
            // If the JSONArray fails to parse the response, print out the response
            e.printStackTrace();
            System.out.println(response);
        }

        return null;
    }

    private String readResponse(HttpURLConnection con) {
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        try{
            Gson gson = new Gson();

            Recipe[] foodList = gson.fromJson(result, Recipe[].class);
            RecipeListActivity.JobDone(foodList);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
