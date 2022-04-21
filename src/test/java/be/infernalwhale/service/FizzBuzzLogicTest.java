package be.infernalwhale.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzLogicTest {
    FizzBuzzLogic logic;

    @BeforeEach
    void init() {
        System.out.println("Running init method...");
        this.logic = new FizzBuzzLogic();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Running cleanup method...");
        this.logic = null;
    }

    @Test
    void testInputOne() {
        String output = logic.parseInput(1);
        assertEquals("1", output);
    }

    @Test
    void testInputThree() {
        String output = logic.parseInput(3);
        assertEquals("FIZZ", output);
    }

    @Test
    void testInputFifteen() {
        String output = logic.parseInput(15);
        assertEquals("FIZZBUZZ", output);
    }
}