package org.inno.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author spindizzy
 */
public class ProjectTest {
   
    @Test
    public void testEquals() {
        Project first = new Project();
        first.setName("a");
        first.setVersion("1");
        
        Project second = new Project();
        second.setName("a");
        second.setVersion("1");
        assertTrue(first.equals(second));
    }
    
}
