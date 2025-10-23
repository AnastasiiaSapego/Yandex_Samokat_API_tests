package ru.practicum.steps;

import static io.restassured.RestAssured.*;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.practicum.model.Courier;

public class CourierSteps {
    private static final String COURIER_ENDPOINT = "/api/v1/courier";
    private static final String COURIER_DETAIL_ENDPOINT = "/api/v1/courier/{id}";
    private static final String COURIER_LOGIN_ENDPOINT = "/api/v1/courier/login";


    @Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return     given()
                .body(courier)
                .when()
                .post(COURIER_ENDPOINT)
                .then();
    }

    @Step("Логин курьера")
    public ValidatableResponse loginCourier(Courier courier) {
        return      given()
                .body(courier)
                .when()
                .post(COURIER_LOGIN_ENDPOINT)
                .then();
    }

    @Step("Удаление курьера")
    public void deleteCourier(Courier courier) {
        given()
                .pathParams("id", courier.getId())
                .when()
                .delete(COURIER_DETAIL_ENDPOINT)
                .then();
    }
}
