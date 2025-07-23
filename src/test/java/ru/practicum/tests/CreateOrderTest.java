package ru.practicum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.model.Order;
import ru.practicum.steps.CourierSteps;
import ru.practicum.steps.OrderSteps;

import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

@RunWith(Parameterized.class)
public class CreateOrderTest extends BaseTest {
    private CourierSteps courierSteps = new CourierSteps();
    private OrderSteps orderSteps = new OrderSteps();
    private static final String firstName = "Ivan";
    private static final String lastName = "Ivanov";
    private static final String address = "Ivanov, 5";
    private static final String metroStation = "Kovalevskaya";
    private static final String phone = "123456789";
    private static final int rentTime = 5;
    private static final String deliveryDate = "2020-01-01";
    private static final String comment = "Very important comment";
    private final List<String> color;

    public CreateOrderTest(List<String> color) {
        this.color = color;
    }

    @Parameterized.Parameters(name = "Проверка цвета(ов): {0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {List.of("BLACK")},
                {List.of("GREY")},
                {List.of("BLACK", "GREY")},
                {List.of()}
        };
    }

    @Test
    public void createOrder() {
        Order order = new Order();
        order.setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .setRentTime(rentTime)
                .setDeliveryDate(deliveryDate)
                .setComment(comment)
                .setColor(color);

        orderSteps
                .createOrder(order)
                .statusCode(201)
                .body("track", notNullValue());
    }
}
