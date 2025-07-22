package ru.practicum.steps;

import static io.restassured.RestAssured.*;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.practicum.model.Courier;
import ru.practicum.model.Order;

public class CourierSteps {

    @Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return     given()
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then();
    }

    @Step("Логин курьера")
    public ValidatableResponse loginCourier(Courier courier) {
        return      given()
                .body(courier)
                .when()
                .post("/api/v1/courier/login")
                .then();
    }

    @Step("Удаление курьера")
    public void deleteCourier(Courier courier) {
        given()
                .pathParams("id", courier.getId())
                .when()
                .delete("/api/v1/courier/{id}")
                .then();
    }

    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return      given()
                .body(order)
                .when()
                .post("/api/v1/orders")
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrders() {
        return      given()
                .when()
                .get("/api/v1/orders")
                .then();
    }
}
