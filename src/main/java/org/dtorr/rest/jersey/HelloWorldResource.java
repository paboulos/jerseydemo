package org.dtorr.rest.jersey;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import com.sun.jersey.api.json.JSONWithPadding;

/**
 * Hello world!
 *
 */
@Path("/helloworld")
public class HelloWorldResource {
    // The Java method will process HTTP GET requests

    static final List<AircraftType> aircraftTypes = new LinkedList<AircraftType>();

    static {
        aircraftTypes.add(new AircraftType("B737", 42.1, 204));
        aircraftTypes.add(new AircraftType("A330", 58.8, 253));
    }

    @GET @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
     @Path("/list")
    public List<AircraftType> getAircraftTypes() {
        return aircraftTypes;
    }

    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces(MediaType.TEXT_PLAIN)
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
    
    @GET
    @Produces({"application/x-javascript", "application/json", "application/xml"})
    @Path("/jsonp")
    public JSONWithPadding getChanges(@QueryParam("callback") String callback, @QueryParam("type") int type) {
        return new JSONWithPadding(new GenericEntity<List<AircraftType>>(aircraftTypes){}, callback);
    }

    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/text/")
    public Response getClicheResponse() {
        Response resp = null;
        Response.ResponseBuilder builder = Response.status(Status.OK);
        builder.header("Access-Control-Allow-Origin", "*");
        builder.type("application/text");
        builder.entity("Hello from Jersey");
        resp = builder.build();
        // Return some cliched textual content
        return resp;
    }

    @GET   // this method process GET request from client using path parameter
    @Path("/{empno}/")
   @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})   // sends JSON
    public Employee getJson( @PathParam("empno") int empno) {  // empno represents the empno sent from client
        switch(empno) {
          case 1 :
              return new Employee("George Koch",58);
          case 2:
              return new Employee("George Koch",58);
          default:
              return new Employee("Unknown",-1);
        } // end of switch
   } // end of
}
