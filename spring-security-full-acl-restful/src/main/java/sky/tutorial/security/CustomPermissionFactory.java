/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sky.tutorial.security;

import org.springframework.security.acls.domain.DefaultPermissionFactory;

/**
 *
 * @author szekai
 */
public class CustomPermissionFactory extends DefaultPermissionFactory {
 public CustomPermissionFactory() {
 super();
 registerPublicPermissions(CustomPermission.class);
 }
}