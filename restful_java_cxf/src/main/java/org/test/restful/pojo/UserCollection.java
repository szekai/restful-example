/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.restful.pojo;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nithyanandann
 */
@XmlRootElement
public class UserCollection {

    private Collection<User> users;

    public UserCollection() {
    }

    public UserCollection(final Collection<User> users) {
        this.users = users;
    }

    @XmlElement(name = "user")
    @XmlElementWrapper(name = "users")
    public Collection<User> getUsers() {
        return users;
    }
}
