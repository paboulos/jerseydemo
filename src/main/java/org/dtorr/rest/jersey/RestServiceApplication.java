/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dtorr.rest.jersey;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;
/**
 *
 * @author Paul
 */
public class RestServiceApplication extends Application {

    public RestServiceApplication() {
        singletonSet.add(new HelloWorldResource());
        perReqSet.add(HelloWorldResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return perReqSet;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletonSet;

    }

    /**
     * Private Members
     */
     private HashSet<Class<?>> perReqSet = new HashSet<Class<?>>();
     private Set<Object> singletonSet = new HashSet<Object>();
}
