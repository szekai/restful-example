
import sky.model.Todo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.representation.Form;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author szekai
 */
public class PostTest {

    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
//        client.addFilter(new HTTPBasicAuthFilter("johndoe", "password"));
//        // Get the Todos
//        System.out.println(service.path("services").path("admin")
//                .accept(MediaType.TEXT_XML).get(String.class));

        client.addFilter(new HTTPBasicAuthFilter("john", "admin"));
        // Get the Todos
        System.out.println("john >> " + service.path("services").path("admin")
                .accept(MediaType.APPLICATION_JSON).get(String.class));

        System.out.println("john >> " + service.path("services").path("admin")
                .accept(MediaType.TEXT_XML).get(String.class));
        
        client.addFilter(new HTTPBasicAuthFilter("jane", "user"));
        // Get the Todos
        System.out.println("jane >> " +service.path("services").path("admin")
                .accept(MediaType.APPLICATION_JSON).get(String.class));

        System.out.println("jane >> " +service.path("services").path("admin")
                .accept(MediaType.TEXT_XML).get(String.class));
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/spring-security-full-acl-restful").build();
    }
}
