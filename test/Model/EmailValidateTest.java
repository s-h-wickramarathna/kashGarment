/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class EmailValidateTest {
    
    public EmailValidateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateEmail method, of class EmailValidate.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String email = "sanchitha@gmail.com";
        boolean expResult = false;
        boolean result = EmailValidate.validateEmail(email);
        assertEquals(expResult, result);
    }
    
}
