package com.infoshareacademy;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@WebServlet(name = "ListServlet", urlPatterns = "/users")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<title>List</title>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h2>Users older that 8 years</h2>");

        InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/users.json");
        try (Scanner scanner = new Scanner(inputStream)) {
            String jsonString = scanner.useDelimiter("\\A").next().replaceAll("\\n", "");

            // Reading json object from string
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);

            for (Object aJsonArray : jsonArray) {
                JSONObject obj = (JSONObject) aJsonArray;
                String ageString = (obj).get("age").toString();
                int age = Integer.valueOf(ageString);
                if (age > 8) {
                    String userText = obj.get("name") + " " + obj.get("surname") + ", age: " + obj.get("age");
                    stringBuilder.append("<div>").append(userText).append("</div>");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        resp.getWriter().write(stringBuilder.toString());
    }
}
