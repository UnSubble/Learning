package com.unsubble._01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<UserSimple> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        serializeUser();
        deserializeUser();
        deserializeUserFromFile();
        System.out.println("-----------------------------");
        serializeUserNested();
        deserializeUserNested();
        System.out.println("-----------------------------");
        list.add(new UserSimple("Norman", "norman@gmail.com", 27, true));
        list.add(new UserSimple("Norman1", "norman1@gmail.com", 28, false));
        list.add(new UserSimple("Norman2", "norman2@gmail.com", 29, true));
        list.add(new UserSimple("Norman3", "norman3@gmail.com", 30, true));
        serializeList();
        System.out.println("-----------------------------");
        serializeArray();
        System.out.println("-----------------------------");
        deserializeList();
        System.out.println("-----------------------------");
        deserializeNull();
        System.out.println("-----------------------------");
        serializeNull();
    }

    static void serializeUser() {
        UserSimple user = new UserSimple("Norman", "norman@gmail.com", 27, true);
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);
    }

    static void deserializeUser() {
        String userJson = """
                          {"name":"Norman","email":"norman@gmail.com","age":27,"isDeveloper":true}""";
        Gson gson = new Gson();
        UserSimple user = gson.fromJson(userJson, UserSimple.class);
        System.out.println(user.getName());
    }

    static void deserializeUserFromFile() throws IOException {
        Gson gson = new Gson();
        UserSimple user = gson.fromJson(Files.newBufferedReader(new File("UserSimple.json").toPath()), UserSimple.class);
        System.out.println(user.getName());
    }

    static void serializeUserNested() {
        UserNested userNested = new UserNested("Norman", "norman@gmail.com", 27, true,
                new UserAddress("Main Street", "42A", "Magdeburg", "Germany"));
        Gson gson = new Gson();
        String json = gson.toJson(userNested);
        System.out.println(json);
    }

    static void deserializeUserNested() {
        String json = """
                {"name":"Norman","email":"norman@gmail.com","age":27,"isDeveloper":true,\
                "userAddress":{"street":"Main Street","houseNumber":"42A","city":"Magdeburg","country":"Germany"}}""";
        Gson gson = new Gson();
        UserNested user = gson.fromJson(json, UserNested.class);
        System.out.println(user.getUserAddress().getCountry());
    }

    static void serializeList() {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }

    static void serializeArray() {
        UserSimple[] arr = list.toArray(new UserSimple[0]);
        Gson gson = new Gson();
        String json = gson.toJson(arr);
        System.out.println(json);
    }

    static void deserializeList() {
        Gson gson = new Gson();
        String json = """
                [{"name":"Norman","email":"norman@gmail.com","age":27,"isDeveloper":true},\
                {"name":"Norman1","email":"norman1@gmail.com","age":28,"isDeveloper":false},\
                {"name":"Norman2","email":"norman2@gmail.com","age":29,"isDeveloper":true},\
                {"name":"Norman3","email":"norman3@gmail.com","age":30,"isDeveloper":true}]""";
        List<UserSimple> list = Arrays.asList(gson.fromJson(json, UserSimple[].class));
        System.out.println(list.get(0).getName());

        Type token = new TypeToken<ArrayList<UserSimple>>(){}.getType();
        List<UserSimple> list2 = gson.fromJson(json, token);
        System.out.println(list2.get(0).getName());
    }

    static void deserializeNull() {
        String json = """
                {"name":null,"email":"norman@gmail.com","age":null,"isDeveloper":true,\
                "userAddress":{"street":"Main Street","houseNumber":"42A","city":"Magdeburg","country":"Germany"}}""";
        Gson gson = new Gson();
        UserSimple user = gson.fromJson(json, UserSimple.class);
        System.out.println(user);
    }

    static void serializeNull() {
        UserSimple user = new UserSimple("Norman", null, 27, true);
        Gson gson = new GsonBuilder().serializeNulls().create(); // -> Normalde boolean'ın Wrapper class'ı olsaydı ve null
                                                                // girseydik default value veriyordu fakat biz builder ile
                                                                // null yapmasını sağladık
        System.out.println(gson.toJson(user));
    }
}
