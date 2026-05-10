package hospital;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "9090"));

        Tomcat tomcat = new Tomcat();
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "9090"));

tomcat.setPort(port);
        tomcat.getConnector(); // required in newer Tomcat versions

        // Point to webapp directory
        Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        Tomcat.addServlet(ctx, "PatientServlet", new PatientServlet());
        ctx.addServletMappingDecoded("/patients", "PatientServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
