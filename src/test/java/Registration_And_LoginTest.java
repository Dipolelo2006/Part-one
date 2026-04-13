/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.registration_and_login.Registration_And_Login;
/**
 *
 * @author Student
 */
public class Registration_And_LoginTest {
    
    public Registration_And_LoginTest() {
    }

    @Test
    void testValidUsername() {
        Registration_And_Login user = new Registration_And_Login();
        user.username = "De_e";
        assertTrue(user.checkUserName(), "Valid username with underscore should pass");
    }

    @Test
    void testInvalidUsernameNoUnderscore() {
        Registration_And_Login user = new Registration_And_Login();
        user.username = "username";
        assertFalse(user.checkUserName(), "Username without underscore should fail");
    }

    @Test
    void testValidPassword() {
        Registration_And_Login user = new Registration_And_Login();
        user.password = "Pass123!";
        assertTrue(user.checkPasswordComplexity(), "Valid complex password should pass");
    }

    @Test
    void testValidPhoneNumber() {
        Registration_And_Login user = new Registration_And_Login();
        user.phoneNumber = "+27123456789";
        assertTrue(user.checkCellPhoneNumber(), "Valid SA phone number should pass");
    }
}
