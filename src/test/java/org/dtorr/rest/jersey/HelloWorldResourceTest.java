/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dtorr.rest.jersey;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.MediaTypes;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class HelloWorldResourceTest  extends JerseyTest {

    public HelloWorldResourceTest()throws Exception {
        super("org.dtorr.rest.jersey");
    }


    /**
     * Test of getClichedMessage method, of class HelloWorldResource.
     */
    @Test
    public void testGetClichedMessage() {
        System.out.println("getClichedMessage");
         WebResource webResource = resource();
        String responseMsg = webResource.path("helloworld").get(String.class);
        assertEquals("Hello World", responseMsg);
    }

}