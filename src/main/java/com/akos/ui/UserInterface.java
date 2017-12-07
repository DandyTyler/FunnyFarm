package com.akos.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class UserInterface {

    private Object object;

    public UserInterface(Object object) {
        this.object = object;
    }

    public void run() throws InvocationTargetException, IllegalAccessException, IOException {

        Map<String, Method> availableMethods = new HashMap<>(); // name -> method

        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                availableMethods.put(method.getName(), method);
            }
        }

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Available commands: " + availableMethods.keySet());
            System.out.println("Enter command (\"exit\" to exit): ");
            String commandName = reader.readLine();   /// read from terminal
            if (commandName.equals("exit"))
                return;
            try {
                if (availableMethods.containsKey(commandName)) {
                    Method method = availableMethods.get(commandName);

                    List<Object> argumentValues = new ArrayList<>();

                    List<Class> methodArgumentsTypes = new ArrayList<>(Arrays.asList(method.getParameterTypes()));

                    Command cmd = method.getAnnotation(Command.class);
                    for (
                            CommandArgument argument : cmd.value())

                    {
                        System.out.println(argument.value());
                        String argumentValue = reader.readLine(); /// read from terminal
                        argumentValues.add(Parser.parse(argumentValue, methodArgumentsTypes.remove(0))); // convert type according to method signature
                    }

                    Object result = method.invoke(object, argumentValues.toArray());
                    if (result != null)
                        System.out.println(result + "\n");
                } else System.out.println("This command doesn't exist!");
            } catch (NumberFormatException e) {
                System.out.println("Wrong arguments type");
            }
        }
    }
}
