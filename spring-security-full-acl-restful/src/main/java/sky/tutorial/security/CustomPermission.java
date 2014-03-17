/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sky.tutorial.security;

import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.model.Permission;

/**
 *
 * @author szekai
 */
public class CustomPermission extends BasePermission {
 
 public static final Permission REPORT   = new CustomPermission(1<<5,'O');
 public static final Permission AUDIT    = new CustomPermission(1<<6,'T');
 
 protected CustomPermission(int mask) {
   super(mask);
 }
 
 protected CustomPermission(int mask, char code) {
   super(mask, code);
 }
}