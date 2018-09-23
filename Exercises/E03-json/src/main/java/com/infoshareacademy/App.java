package com.infoshareacademy;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    private static final String FILE_NAME = "users.json";

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            // <editor-fold desc="Read user's emails">
            ClassLoader classLoader = App.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(FILE_NAME)).getFile());
            Object obj = parser.parse(new FileReader(file.getAbsolutePath()));
            JSONArray users = (JSONArray) obj;
            List<String> emails = (List<String>) users.stream().map(u -> ((JSONObject) u).get("email").toString()).collect(Collectors.toList());
            // </editor-fold>

            // Find users having e-mails in domain .pl
            emails.forEach(mail -> {
                if (mail.contains(".pl")) {
                    System.out.println(mail);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
