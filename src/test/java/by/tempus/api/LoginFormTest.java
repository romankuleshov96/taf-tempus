package by.tempus.api;

import by.tempus.utils.CredentialGenerators;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest {

    private LoginFormController loginFormController;
    private Response response;
    private String email;
    private String password;

    @BeforeEach
    public void setup() {
        loginFormController = new LoginFormController();
        email = CredentialGenerators.getValidEmail();
        password = CredentialGenerators.getValidPassword();
    }


    @Test
    public void testNotExistedCredentials() {
        response = loginFormController.getPostResponseLogin(email, password);

        assertAll(
                () -> assertEquals(200, response.getStatusCode(), "Status code should be 200"),
                () -> assertEquals("Неверные учетные данные или пользователь деактивирован\\заблокирован", loginFormController.getTextErrorMessage(response))
        );
    }

//    @Test
//    public void testInvalidEmailFormat() {
//        LoginFormController loginFormController = new LoginFormController("test", "Qwerty123");
//
//        assertAll(
//                () -> assertEquals(200, loginFormController.getStatusCode()),
//                () -> assertEquals("Некорректный email", loginFormController.getTextErrorMessage())
//        );
//    }
//
    @Test
    public void testEmptyEmailField() {
        response = loginFormController.getPostResponseLoginPasswordOnly(password);

        assertAll(
                () -> assertEquals(200, loginFormController.getStatusCode(response)),
                () -> assertEquals("Не указан Email", loginFormController.getTextErrorMessage(response))
        );
    }
//
//    @Test
//    public void testEmptyPasswordField() {
//        LoginFormController loginFormController = new LoginFormController("test@test.com", "");
//
//        assertAll(
//                () -> assertEquals(200, loginFormController.getStatusCode()),
//                () -> assertEquals("Не указан Пароль", loginFormController.getTextErrorMessage())
//        );
//    }
//
//    @Test
//    public void testEmptyEmailAndPasswordField() {
//        LoginFormController loginFormController = new LoginFormController("", "");
//
//        assertAll(
//                () -> assertEquals(200, loginFormController.getStatusCode()),
//                () -> assertEquals("Не указан Email", loginFormController.getTextErrorMessage())
//        );
//    }







//
//    @Test
//    public void testWithoutEmailKey() {
//        LoginPageController loginPageController = new LoginPageController("Qwerty123!");
//
//        assertAll(
//                () -> assertEquals(200, loginPageController.getStatusCode()),
//                () -> assertEquals("Не указан Email", loginPageController.getTextErrorMessage())
//        );
//    }
//
//    @Test
//    public void testWithoutPasswordKey() {
//        LoginPageController loginPageController = new LoginPageController("test@test.com");
//
//        assertAll(
//                () -> assertEquals(200, loginPageController.getStatusCode()),
//                () -> assertEquals("Не указан Email", loginPageController.getTextErrorMessage())
//        );
//    }
//
//    @Test
//    public void testWithoutEmailAndPasswordKey() {
//        LoginPageController loginPageController = new LoginPageController();
//
//        assertAll(
//                () -> assertEquals(200, loginPageController.getStatusCode()),
//                () -> assertEquals("Не указан Email", loginPageController.getTextErrorMessage())
//        );
//    }
}
