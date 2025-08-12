package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numeroAleatorio = (int) (Math.random() * 100) + 1;

        ArrayList<Integer> intentos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean numeroAdivinado = false;

        System.out.println("He generado un número entre 1 y 100. ¡Trata de adivinarlo!");

        while (!numeroAdivinado) {
            System.out.print("Por favor ingresa un número entre 1 - 100: ");
            int numeroUsuario = scanner.nextInt();
            if (numeroUsuario < 1 || numeroUsuario > 100) {
                System.out.println("Debe ingresar un numero entre 1 y 100.");
                continue;
            }
            intentos.add(numeroUsuario);

            String resultado = compararNumeros(numeroUsuario, numeroAleatorio);
            System.out.println(resultado);

            if (numeroUsuario == numeroAleatorio) {
                numeroAdivinado = true;

                mostrarEstadisticasFinales(intentos);
            }
        }

        scanner.close();
        System.out.println("¡Gracias por jugar!");
    }


    public static String compararNumeros(int numeroUsuario, int numeroAleatorio) {
        if (numeroUsuario == numeroAleatorio) {
            return "¡Has conseguido adivinar el número!";
        }
        else if (numeroUsuario < numeroAleatorio) {
            return "Intenta con un número más grande.";
        }
        else {
            return "Intenta con un número más pequeño.";
        }
    }

    private static void mostrarEstadisticasFinales(ArrayList<Integer> intentos) {
        System.out.println("Te tomó " + intentos.size() + " veces adivinar el número.");

        boolean primero = true;
        for (int intento : intentos) {
            if (!primero) {
                System.out.print(" ");
            }
            System.out.print(intento);
            primero = false;
        }
        System.out.println();
    }
}