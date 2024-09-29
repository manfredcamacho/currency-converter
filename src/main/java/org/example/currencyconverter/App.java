package org.example.currencyconverter;

import org.example.currencyconverter.controller.ConsoleController;

public class App
{

    public static void main( String[] args )
    {
        ConsoleController console = ConsoleController.getInstance();
        console.start();

    }
}
