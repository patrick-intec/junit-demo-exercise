package be.infernalwhale.service;

public class FizzBuzzLogic {
    // FizzBuzz has 1 input >> Integer
    // If the number is dividable by 3 >> output "FIZZ"
    // if the number is dividable by 5 >> output "BUZZ"
    // if dividable by 3 and 5 >> output "FIZZBUZZ"

    private Integer[] history = new Integer[10];


    public String parseInput(Integer input) {
        if (input % 3 == 0) return "FIZZ";
        if (input % 5 == 0) return "BUZZ";
        if (input % 3 == 0 && input % 5 == 0) return "FIZZBUZZ";

        return "" + input;
    }
}
