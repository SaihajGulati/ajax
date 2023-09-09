package ssgulati_CSCI201_Lab12;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String message = request.getParameter("message");
        String dob = request.getParameter("dob");
        String country = request.getParameter("country");
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        // Validate form data
        /*boolean isValid = true;

        if (name == null || name.length() < 3) {
            isValid = false;
        }

        if (email == null || !email.contains("@")) {
            isValid = false;
        }

        if (gender == null || (!gender.equals("male") && !gender.equals("female"))) {
            isValid = false;
        }

        if (age < 0 || age > 120) {
            isValid = false;
        }

        if (message == null || message.length() == 0) {
            isValid = false;
        }

        if (dob == null || dob.length() == 0) {
            isValid = false;
        }

        if (country == null || country.length() == 0) {
            isValid = false;
        }*/

        // Construct JSON object
        JsonObject jsonObject = new JsonObject();

       // if (isValid) {
            jsonObject.addProperty("name", name);
            jsonObject.addProperty("email", email);
            jsonObject.addProperty("gender", gender);
            jsonObject.addProperty("age", age);
            jsonObject.addProperty("message", message);
            jsonObject.addProperty("dob", dob);
            jsonObject.addProperty("country", country);

            // Set the response content type to application/json
            response.setContentType("application/json");

            // Send the JSON object as a response
            response.getWriter().write(jsonObject.toString());
       /* } else {
            jsonObject.addProperty("error", "Invalid form data");

            response.setContentType("application/json");
            response.getWriter().write(jsonObject.toString());
        }*/
    }
}

