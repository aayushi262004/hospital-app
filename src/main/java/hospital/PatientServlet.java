package hospital;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;

@WebServlet("/patients")
public class PatientServlet extends HttpServlet {

    private PatientManager manager = new PatientManager();

    @Override
    public void init() {

        // Sample patient data
        manager.addPatient(new Patient(1, "Ravi Kumar", 72, "Diabetes"));
        manager.addPatient(new Patient(2, "Anjali Rao", 45, "Fever"));
        manager.addPatient(new Patient(3, "Mohan Das", 65, "Hypertension"));
        manager.addPatient(new Patient(4, "Priya Singh", 30, "Cold"));
        manager.addPatient(new Patient(5, "Arjun Sharma", 80, "Arthritis"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String action = req.getParameter("action");

        List<Patient> result;

        if ("age".equals(action)) {
            result = manager.sortByAge();
        }
        else if ("name".equals(action)) {
            result = manager.sortByName();
        }
        else if ("above60".equals(action)) {
            result = manager.patientsAbove60();
        }
        else {
            result = manager.getAllPatients();
        }

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<html><body>");

        out.println("<h2>Hospital Patient Records</h2>");

        out.println("<a href='?action=all'>All</a> | ");
        out.println("<a href='?action=age'>Sort by Age</a> | ");
        out.println("<a href='?action=name'>Sort by Name</a> | ");
        out.println("<a href='?action=above60'>Above 60</a>");

        out.println("<hr>");

        // Add Patient Form
        out.println("<h3>Add New Patient</h3>");

        out.println("<form method='post'>");

        out.println("ID: <input type='number' name='id' required><br><br>");

        out.println("Name: <input type='text' name='name' required><br><br>");

        out.println("Age: <input type='number' name='age' required><br><br>");

        out.println("Disease: <input type='text' name='disease' required><br><br>");

        out.println("<input type='submit' value='Add Patient'>");

        out.println("</form>");

        out.println("<hr>");

        // Patient List
        out.println("<ul>");

        for (Patient p : result) {
            out.println("<li>" + p.toString() + "</li>");
        }

        out.println("</ul>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");

        int age = Integer.parseInt(req.getParameter("age"));

        String disease = req.getParameter("disease");

        manager.addPatient(new Patient(id, name, age, disease));

        res.sendRedirect("/patients");
    }
}