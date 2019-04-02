package main;

import main.Entity.Order;

import javax.jws.WebService;
import javax.ws.rs.*;

@Path("/order-service")
@WebService
public class OrderService {

    private DBService dbService = new DBService();

    @GET
    @Produces("text/plain")
    @Path("/")
    public String getEndpoints() {

        return "Endpoints:\n\n" +

                "GET | get order by providing Integer orderId as path param:\n" +
                "/order-service/getorder/{orderId}\n\n" +

                "POST | create new order by providing Order obj as request body:\n" +
                "/order-service/createorder\n\n" +

                "PUT | update existing order by providing Order obj as request body:\n" +
                "/order-service/updateorder\n\n" +

                "DELETE | delete order by providing Integer orderId as path param:\n" +
                "/order-service/deleteorder/{orderId}";
    }

    @GET
    @Produces("text/plain")
    @Path("/getorder/{orderId}")
    public String getOrder(@PathParam("orderId") Integer orderId) {
        Order order = dbService.getOrderFromDB(orderId);

        if (order != null) return order.toString();
        else return "Order not found.";
    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/createorder")
    public String createOrder(Order order) {
        dbService.createOrderInDB(order);
        return "Successfully created order:\n\n" + order.toString();
    }

    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/updateorder")
    public String updateOrder(Order order) {
        dbService.updateOrderInDB(order);
        return "Successfully updated order:\n\n" + order.toString();
    }

    @DELETE
    @Produces("text/plain")
    @Path("/deleteorder/{orderId}")
    public String deleteOrder(@PathParam("orderId") Integer orderId) {
        dbService.deleteOrderFromDB(orderId);
        return "Successfully deleted order: " + orderId.toString();
    }
}