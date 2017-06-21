/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which marks a method parameter. JConn will inject the value from
 * the connection object which matches the value passed into the annotation.
 *
 * @author David
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface JConnParameter {

    /**
     * The name of the parameters in the HashMap that this parameter should get.
     *
     * @return the parameters this is associated with.
     */
    String value();
}
