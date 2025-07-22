package ru.practicum.tests;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.practicum.model.Courier;
import ru.practicum.steps.CourierSteps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateCourierTest extends BaseTest {

    private CourierSteps courierSteps = new CourierSteps();

    @Test
    public void shouldCreateCourierTest() {
        Courier courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(14))
                .setPassword(RandomStringUtils.randomAlphabetic(14))
                .setFirstName(RandomStringUtils.randomAlphabetic(14));
        courierSteps
                .createCourier(courier)
                .statusCode(201)
                .body("ok", is(true));
        cleanCourier(courier);
    }

    @Test
    public void createCourierWithoutFirstName() {
        Courier courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(14))
                .setPassword(RandomStringUtils.randomAlphabetic(14));
        courierSteps
                .createCourier(courier)
                .statusCode(201)
                .body("ok", equalTo(true));
        cleanCourier(courier);
    }

    @Test
    public void errorWhileCreationCourierWithTheSameLogin() {
        Courier courier = new Courier();
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
        cleanCourier(courier);
    }

    @Test
    public void errorWhileCreationCourierWithoutLogin() {
        Courier courierWithoutLogin = new Courier();
        courierWithoutLogin.setPassword(RandomStringUtils.randomAlphabetic(14))
                .setFirstName(RandomStringUtils.randomAlphabetic(14));

        courierSteps
                .createCourier(courierWithoutLogin)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    public void errorWhileCreationCourierWithoutPassword() {
        Courier courierWithoutPassword = new Courier();
        courierWithoutPassword.setLogin(RandomStringUtils.randomAlphabetic(14))
                    .setFirstName(RandomStringUtils.randomAlphabetic(14));

        courierSteps
                .createCourier(courierWithoutPassword)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    public void cleanCourier(Courier courier) {
        Integer id = courierSteps.loginCourier(courier)
                .extract().body().path("id");
        courier.setId(id);
        Allure.step("Удаление курьера по id", () -> {
            courierSteps.deleteCourier(courier);
        });
    }
}
