/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dtorr.rest.jersey;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Paul
 */
@XmlRootElement
public class Employee {
    public String name;
    public int age;

    public Employee(String nam, int ag){
        this.age=ag;
        this.name=nam;
    }

     public Employee(){}

      public boolean equals(Object o) {
        if (!(o instanceof Employee))
            return false;
        return ((Employee) o).name.equals(name);
    }
}
