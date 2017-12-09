package com.akos;

import com.akos.ui.UserInterface;

public class App {
    public static void main(String[] args) {
        Farm farm = new Farm(50);
        farm.setGardenConditions(new Conditions(65, 30, 500, Seasons.SUMMER));
        UserInterface ui = new UserInterface(farm);
        ui.run();
    }
}
