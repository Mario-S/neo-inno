/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inno.control;

import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schroeder
 */
public class MessageFactoryTest {
    
    private MessageFactory classUnderTest;
    
    @Before
    public void setUp() {
        ResourceBundle bundle = ResourceBundle.getBundle("org.inno.control.test", Locale.GERMAN);
        classUnderTest = new MessageFactory(bundle);
    }
   
    @Test
    public void testGetMessage_Existsing() {
        String result = classUnderTest.getMessage("aKey");
        assertEquals("aValue", result);
    }
    
    @Test
    public void testGetMessage_Missing() {
        String result = classUnderTest.getMessage("x");
        assertEquals("x", result);
    }
}
