package ru.practicum.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import ru.practicum.model.Courier;
import ru.practicum.steps.CourierSteps;
import static org.hamcrest.Matchers.equalTo;

public class LoginCourierTest extends BaseTest {
    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Test
    public void loginCourierTest() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(14));
        courier.setPassword(RandomStringUtils.randomAlphabetic(14));

        courierSteps
                .createCourier(courier);
        Integer id = courierSteps.loginCourier(courier)
                .statusCode(200)
                .extract().body().path("id");
        courier.setId(id);
        Assert.assertNotNull(id);

        courierSteps.deleteCourier(courier);
    }

    @Test
    public void ErrorWhileLoginCourierWithoutLoginTest() {
        courier = new Courier();
        courier.setPassword(RandomStringUtils.randomAlphabetic(14));

        courierSteps.loginCourier(courier)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    public void ErrorWhileLoginCourierWithoutPasswordTest() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(14));

        courierSteps.loginCourier(courier)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    public void ErrorWhileLoginCourierWithIncorrectPareLoginPasswordTest() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(14));
        courier.setPassword(RandomStringUtils.randomAlphabetic(14));

        courierSteps.loginCourier(courier)
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }
}
