package be.infernalwhale.service;

import java.util.Scanner;

public class FizzBuzzGame {
    private FizzBuzzLogic logic = new FizzBuzzLogic();

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input a number (press 0 to exit): ");
        Integer input = scanner.nextInt();
        String output = logic.parseInput(input);
        System.out.println(output);
    }
}
