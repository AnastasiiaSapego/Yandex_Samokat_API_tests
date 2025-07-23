package ru.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.practicum.model.Order;

import static io.restassured.RestAssured.given;

public class OrderSteps {

    private static final String ORDERS_ENDPOINT = "/api/v1/orders";

    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .body(order)
                .when()
                .post(ORDERS_ENDPOINT)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrders() {
        return given()
                .when()
                .get(ORDERS_ENDPOINT)
                .then();
    }
}
