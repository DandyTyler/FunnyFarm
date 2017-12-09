package com.akos.ui;

import com.akos.exceptions.IllegalConditionException;
import com.akos.exceptions.NoSuchMoneyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Пользовательский интерфейс, основанный на обработке аннотаций.
 */
public class UserInterface {

    private Object object;

    private Map<String, Method> availableMethods = new HashMap<>(); // name -> method

    public UserInterface(Object object) {
        this.object = object;
    }

    public void run() {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                availableMethods.put(method.getName(), method);
            }
        }

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Available commands: " + availableMethods.keySet());
            System.out.println("Enter command (\"exit\" to exit): ");

            try {
                String commandName = reader.readLine();   /// read from terminal
                if (commandName.equals("exit"))
                    return;
                if (availableMethods.containsKey(commandName)) {
                    Method method = availableMethods.get(commandName);
                    List<Object> argumentValues = new ArrayList<>();
                    List<Class> methodArgumentsTypes = new ArrayList<>(Arrays.asList(method.getParameterTypes()));

                    Command cmd = method.getAnnotation(Command.class);
                    for (CommandArgument argument : cmd.value()) {
                        System.out.println(argument.value());
                        String argumentValue = reader.readLine(); /// read from terminal
                        argumentValues.add(Parser.parse(argumentValue, methodArgumentsTypes.remove(0))); // convert type according to method signature
                    }

                    Object result = method.invoke(object, argumentValues.toArray());
                    if (result != null)
                        System.out.println(result + "\n");
                } else System.out.println("This command doesn't exist!\n");

            } catch (NumberFormatException e) {
                System.out.println("Wrong arguments type\n");
            } catch (InvocationTargetException e) {
                if (e.getTargetException().getClass().equals(NoSuchMoneyException.class) || e.getTargetException().getClass().equals(IllegalConditionException.class)
                        || e.getTargetException().getClass().equals(IllegalArgumentException.class)) {
                    System.out.println(e.getTargetException().getMessage());
                } else e.printStackTrace();
            } catch (IllegalAccessException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
