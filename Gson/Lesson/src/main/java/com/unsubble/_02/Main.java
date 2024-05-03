package com.unsubble._02;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        serializeUser();
        deserializeUser();
        System.out.println("------------------------------");
        serializeUserIgnore();
        deserializeUserIgnore();
    }

    static void serializeUser() {
        UserSimple userSimple = new UserSimple("Norman", "norman@gmail.com", 27, true);
        Gson gson = new Gson();
        System.out.println(gson.toJson(userSimple));;
    }

    static void deserializeUser() {
        String json = """
                {"name":"Norman","email":"norman@gmail.com","age":27,"dev":true}""";
        Gson gson = new Gson();
        UserSimple user = gson.fromJson(json, UserSimple.class);
        System.out.println(user);
    }

    static void serializeUserIgnore() {
        UserIgnored userSimple = new UserIgnored("Norman", "norman@gmail.com", 27, true);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(userSimple));;
    }

    static void deserializeUserIgnore() {
        String json = """
                {"name":"Norman","email":"norman@gmail.com","age":27,"isDeveloper":true}""";
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        UserIgnored user = gson.fromJson(json, UserIgnored.class);
        System.out.println(user);
    }
}
