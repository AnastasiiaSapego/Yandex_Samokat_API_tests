package ru.practicum.tests;

import org.junit.Test;
import ru.practicum.model.ListOfOrders;
import ru.practicum.model.Order;
import ru.practicum.steps.OrderSteps;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

public class ListOfOrdersTest extends BaseTest {

    private OrderSteps orderSteps = new OrderSteps();

    @Test
    public void listOfOrdersTest() {
        ListOfOrders listOfOrders = orderSteps.getOrders()
                .statusCode(200)
                .extract().as(ListOfOrders.class);

        assertNotNull(listOfOrders.getOrders());
        assertFalse(listOfOrders.getOrders().isEmpty());

        Order firstOrder = listOfOrders.getOrders().get(0);
        assertNotNull(firstOrder.getId());
        assertNotNull(firstOrder.getTrack());
        assertNotNull(listOfOrders.getPageInfo());
        assertNotNull(listOfOrders.getAvailableStations());

    }
}
