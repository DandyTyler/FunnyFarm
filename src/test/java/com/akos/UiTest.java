package com.akos;

import com.akos.ui.UserInterface;

public class UiTest {

    public static void main(String[] args)  {
        UserInterface ui= new UserInterface(new Farm(50));
        ui.run();
    }
}

