package ru.practicum.steps;

import static io.restassured.RestAssured.*;

import io.restassured.response.ValidatableResponse;
import ru.practicum.model.Courier;
import ru.practicum.model.Order;

public class CourierSteps {
    public ValidatableResponse createCourier(Courier courier) {
        return     given()
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then();
    }
    public ValidatableResponse loginCourier(Courier courier) {
        return      given()
                .body(courier)
                .when()
                .post("/api/v1/courier/login")
                .then();
    }
    public ValidatableResponse deleteCourier(Courier courier) {
        return      given()
                .pathParams("id", courier.getId())
                .when()
                .delete("/api/v1/courier/{id}")
                .then();
    }

    public ValidatableResponse createOrder(Order order) {
        return      given()
                .body(order)
                .when()
                .post("/api/v1/orders")
                .then();
    }

}
