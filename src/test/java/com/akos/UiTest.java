package com.akos;

import com.akos.ui.UserInterface;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class UiTest {
    public static void main(String[] args) throws IllegalAccessException, IOException, InvocationTargetException {
        UserInterface ui= new UserInterface(new Farm(50));
        ui.run();
    }
}
