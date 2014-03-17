/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.test.restful;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.test.restful.pojo.User;
import org.test.restful.pojo.UserCollection;

/**
 *
 * @author nithyanandann
 */
public interface ServiceDefn {

    UserCollection getUsers();

    User getCustomer(Integer id);

    Response getBadRequest();

    public String get(UriInfo uiInfo);
}
