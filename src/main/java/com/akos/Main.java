package com.akos;

/**
 * @author VYZH
 * @since 30.11.2017
 */
public class Main {
    public static void main(String[] args) {
        PlantStore ps = null;

        Order order = new Order()
                .add("Carrot", 2)
                .add("Potato", 10);

        Cart cart = ps.buy(order);
    }
}
