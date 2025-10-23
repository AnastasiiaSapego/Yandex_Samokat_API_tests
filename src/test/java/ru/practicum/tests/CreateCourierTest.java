package ru.practicum.tests;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.model.Courier;
import ru.practicum.steps.CourierSteps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateCourierTest extends BaseTest {

    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;
    private Integer courierId;

    @Before
    public void setUp() {
        courier = new Courier();
        courierId = null;
    }

    @Test
    public void shouldCreateCourierTest() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(14))
                .setPassword(RandomStringUtils.randomAlphabetic(14))
                .setFirstName(RandomStringUtils.randomAlphabetic(14));
        courierSteps
                .createCourier(courier)
                .statusCode(201)
                .body("ok", is(true));
    }

    @Test
    public void createCourierWithoutFirstName() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(14))
                .setPassword(RandomStringUtils.randomAlphabetic(14));
        courierSteps
                .createCourier(courier)
                .statusCode(201)
                .body("ok", equalTo(true));
    }

    @Test
    public void errorWhileCreationCourierWithTheSameLogin() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(14))
                .setPassword(RandomStringUtils.randomAlphabetic(14))
                .setFirstName(RandomStringUtils.randomAlphabetic(14));
        courierSteps
                .createCourier(courier)
                .statusCode(201)
                .body("ok", equalTo(true));

        courierSteps
                .createCourier(courier)
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется"));
    }

    @Test
    public void errorWhileCreationCourierWithoutLogin() {
        courier.setPassword(RandomStringUtils.randomAlphabetic(14))
                .setFirstName(RandomStringUtils.randomAlphabetic(14));

        courierSteps
                .createCourier(courier)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    public void errorWhileCreationCourierWithoutPassword() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(14))
                    .setFirstName(RandomStringUtils.randomAlphabetic(14));

        courierSteps
                .createCourier(courier)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @After
    public void tearDown() {
        var response = courierSteps.loginCourier(courier);
        int statusCode = response.extract().response().getStatusCode();
        if (statusCode == 200) {
            courierId = response.extract().path("id");
            courier.setId(courierId);
            Allure.step("Удаление курьера по id", () -> {
                courierSteps.deleteCourier(courier);
            });
        }
    }
}
