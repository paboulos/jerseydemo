/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dtorr.rest.jersey;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author japod
 */
@XmlRootElement
public class AircraftType {
    public String type;
    public double length;
    public int seatingCapacity;

    public AircraftType(){}

    public AircraftType(String type, double length, int seatingCapacity) {
        this.type = type;
        this.length = length;
        this.seatingCapacity = seatingCapacity;
    }
}
