package fr.dawan.projetjaxrs.ws;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("api")
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		
		//packages où se trouvent les classes annotées (ws)
		packages("fr.dawan.projetjaxrs.ws");
		
		//support du JSON / XML
		register(JacksonFeature.class);
		
		//support de l'upload
		register(MultiPartFeature.class);
		
		//propriétés du serveur
		property(ServerProperties.TRACING, "ALL");
	}
}

