/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sky.restful;

import sky.model.Todo;
import sky.model.TodoDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sky.tutorial.domain.AdminPost;
import sky.tutorial.domain.Post;
import sky.tutorial.service.GenericService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 *
 * @author szekai
 */
@Component
@Path("/admin")
public class AdminResource {

    @Resource(name = "adminService")
    private GenericService adminService;

    // Return the list of todos to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<AdminPost> getAdminPost() {
        List<AdminPost> todos = new ArrayList<AdminPost>();
        List<Post> posts = adminService.getAll();
        for (Post post : posts) {
            todos.add((AdminPost) post);
        }
        return todos;
    }

    // Return the list of todos for applications
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AdminPost> getPost() {
        List<AdminPost> todos = new ArrayList<AdminPost>();
        List<Post> posts = adminService.getAll();
        for (Post post : posts) {
            todos.add((AdminPost) post);
        }
        return todos;
    }
}
