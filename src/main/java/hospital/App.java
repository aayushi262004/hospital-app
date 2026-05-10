package hospital;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class App {

    public static void main(String[] args) throws Exception {

        int port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "9090")
        );

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(port);

        tomcat.getConnector();

        // Create empty context
        Context ctx = tomcat.addContext("", null);

        // Register servlet
        Tomcat.addServlet(ctx, "PatientServlet", new PatientServlet());

        // Map URL
        ctx.addServletMappingDecoded(
                "/patients",
                "PatientServlet"
        );

        tomcat.start();

        tomcat.getServer().await();
    }
}
