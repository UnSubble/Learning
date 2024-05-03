package com.unsubble._03;

import com.google.gson.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        serializeUser();
        jsonArray();
        jsonObject();
    }

    private static void jsonObject() {
        JsonObject jsonObject = new JsonObject();
        JsonArray arr = new JsonArray();
        arr.add("Norman");
        jsonObject.add("name", arr);
        jsonObject.addProperty("email", "norman@gmail.com");
        Gson gson = new Gson();
        System.out.println(gson.toJson(jsonObject));
    }

    private static void jsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("BS");
        jsonArray.add("MS");
        Gson gson = new Gson();
        System.out.println(gson.toJson(jsonArray));
    }

    private static void serializeUser() {
        UserSimple user = new UserSimple("Norman", new Date());
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH:mm:ss").create();
        System.out.println(gson.toJson(user));
    }
}
