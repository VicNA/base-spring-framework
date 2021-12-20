package ru.geekbrains.homework;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8189);
        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        WebAppContext webApp = new WebAppContext();
        webApp.setContextPath("/");
        webApp.setWar(location.toExternalForm());
        server.setHandler(webApp);
        server.start();
        server.join();
    }
}
