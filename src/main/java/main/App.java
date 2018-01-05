package main;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App
{
	Properties 	properties 	= null;

    @SuppressWarnings("unused")
	public static void main(String[] args)
    {
    	System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n");
		SimpleFormatter sf = new SimpleFormatter();
    	for (Handler handler : Logger.getGlobal().getHandlers()) handler.setFormatter(sf);

    	System.out.println("---------------------------------------------------- START ------------------------------------------------------");

    	Logger.getGlobal().info( "This is a demo to demonstrate that the jar is a jar of jars. ");
    	Logger.getGlobal().info("Included jars are included in dependenciesLib folder and MANIFEST.MF references them");
    	Logger.getGlobal().info("");
    	Logger.getGlobal().info("");
    	Logger.getGlobal().info("Test if following method can be called");
    	Logger.getGlobal().info("org.hibernate.annotations.common.util.StringHelper.isEmpty() : ");
    	Logger.getGlobal().info("");

    	// If hibernates jar are not included, execution of this jar will fail
    	try
    	{
    		boolean testUseOfHibernateClasses = true;
    		Logger.getGlobal().info("this demonstrate jars in jar  with maven-assembly-plugin 3.0.0");
    	}
    	catch (Throwable e)
    	{
    		Logger.getGlobal().info("Hibernates annotation jar have not been found by classLoader. ");
    		Logger.getGlobal().info("This jar is certainly not included in dependenciesLib internal folder"); }

    	App app	= new App();
    	app.loadProperties();


    	System.out.println("----------------------------------------------------  END  ------------------------------------------------------");
    }

    public void loadProperties()
    {
    	try {
    		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("afile.properties");
    		properties = new Properties();
        	properties.load(stream);
		}
    	catch (Exception e) { properties = null; }
    }

	public Properties getProperties() { return properties; }
}
