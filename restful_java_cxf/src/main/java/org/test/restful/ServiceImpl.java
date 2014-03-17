/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.test.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.test.restful.pojo.User;
import org.test.restful.pojo.UserCollection;

/**
 *
 * @author nithyanandann
 */
@Path("/myservice/")
@Produces({"application/json", "application/xml"})
public class ServiceImpl implements ServiceDefn {
    private static final Map<Integer, User> USERS = new HashMap<Integer, User>();

    static {
        USERS.put(1, new User(1, "foo"));
        USERS.put(2, new User(2, "bar"));
        USERS.put(3, new User(3, "baz"));
    }

    public ServiceImpl() {
    }


    @GET
    @Path("/users")
    @Override
    public UserCollection getUsers() {
        return new UserCollection(USERS.values());
    }

    @GET
    @Path("/user/{id}")
    @Override
    public User getCustomer(@PathParam("id") Integer id) {
        return USERS.get(id);
    }

    @GET
    @Path("/users/bad")
    @Override
    public Response getBadRequest() {
        return Response.status(Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/user/get")
    @Produces("text/plain")
    @Override
    public String get(@Context UriInfo uiInfo) {
        MultivaluedMap<String, String> map = uiInfo.getQueryParameters();
        StringBuilder sb = new StringBuilder("Get\n");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String str : entry.getValue()) {
                sb.append(entry.getKey() + ":" + str + "\n");
            }
        }
        return sb.toString();
    }
}
