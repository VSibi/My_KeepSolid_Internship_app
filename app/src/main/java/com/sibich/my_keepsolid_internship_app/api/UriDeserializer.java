package com.sibich.my_keepsolid_internship_app.api;


import android.net.Uri;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UriDeserializer implements JsonDeserializer<Uri> {

    @Override
    public Uri deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
/*
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray articles = jsonObject.getAsJsonArray("articles");
        String url = articles.getAsString();

        Uri uri = Uri.parse(url);*/

        String urlString = json.getAsString();
        Uri uri = Uri.parse(urlString);

        return uri;
    }
}
