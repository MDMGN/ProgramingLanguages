package com.example.programinglanguages;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Sendinblue {
    String apiKey="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";
    String nombreUsuario;
    int phone;


    public  Sendinblue() {
        this.nombreUsuario="Darren";
        this.phone=958995030;
    }
    public void sendMessage() throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\"sender\":" +
                        "{\"name\":Programing Languages,\"email\":\"michaelmdvrhack@gmail.com\"},\"" +
                        "to\":[{\"email\":\"michaelmdvr@gmail.com\"}],\"" +
                        "params\":{\"nombreUsuario\":\""+this.nombreUsuario+"\",\"telefono\":\""+this.phone+"\"},\"templateId\":2}");
        Request request = new Request.Builder()
                .url("https://api.sendinblue.com/v3/smtp/email")
                .post(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("api-key", this.apiKey)
                .build();

        Response response = client.newCall(request).execute();
    }


}
