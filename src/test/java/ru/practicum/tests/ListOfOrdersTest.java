package ru.practicum.tests;

import org.junit.Test;
import ru.practicum.model.ListOfOrders;
import ru.practicum.model.Order;
import ru.practicum.steps.CourierSteps;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

public class ListOfOrdersTest extends BaseTest {

    private CourierSteps courierSteps = new CourierSteps();

    @Test
    public void listOfOrdersTest() {
        ListOfOrders listOfOrders = courierSteps.getOrders()
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
