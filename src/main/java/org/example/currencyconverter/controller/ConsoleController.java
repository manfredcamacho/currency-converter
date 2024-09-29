package org.example.currencyconverter.controller;

import org.example.currencyconverter.model.Currency;
import org.example.currencyconverter.service.ExchangeRateService;
import java.util.Scanner;

public class ConsoleController {

    private static ConsoleController INSTANCE;
    private Scanner scanner = new Scanner(System.in);
    private ExchangeRateService exchangeRateService;

    private ConsoleController(){
        this.exchangeRateService = ExchangeRateService.getInstance();
    }

    public static ConsoleController getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ConsoleController();
        }
        return INSTANCE;
    }

    public void start(){
        Currency from;
        Currency to;

        int option = 0;

        while (option != 7){
            option = askOption();

            switch(option){
                case 1:
                   from = Currency.USD;
                   to = Currency.ARS;
                   break;
                case 2:
                   from = Currency.ARS;
                   to = Currency.USD;
                   break;
                case 3:
                   from = Currency.USD;
                   to = Currency.BRL;
                   break;
                case 4:
                   from = Currency.BRL;
                   to = Currency.USD;
                   break;
                case 5:
                   from = Currency.USD;
                   to = Currency.COP;
                   break;
                case 6:
                   from = Currency.COP;
                   to = Currency.USD;
                   break;
                case 7:
                   continue;
                default:
                   System.out.println("Opción inválida. Intente nuevamente.");
                   continue;
           }

           double amount = askAmout();
           System.out.println("El valor " + amount + " [" + from + "] corresponde al valor final de => " + exchangeRateService.convertCurrency(from, to, amount) + " [" + to + "]");
        }

        System.out.println("Saliendo del programa. Gracias por usar esta App.");
    };

    private int askOption(){
        showMenu();
        return scanner.nextInt();
    }

    private double askAmout(){
        System.out.println("Ingrese el valor que desea convertir:");
        return scanner.nextDouble();
    }

    private void showMenu(){
        System.out.println("""
                
                *************************************************************
                Bienvenido/a al conversor de Monedas
                
                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileño
                4) Real Brasileño => Dólar
                5) Dólar => Peso Colombiano
                6) Peso Colombiano => Dólar
                7) Salir
                
                Elija una opcion válida :
                """);
    }

}
