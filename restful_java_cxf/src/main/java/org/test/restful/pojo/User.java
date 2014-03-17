/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.test.restful.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{id=%s,name=%s}", id, name);
    }
}
