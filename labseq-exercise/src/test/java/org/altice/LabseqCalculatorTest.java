package org.altice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class LabseqCalculatorTest {

    private LabseqCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new LabseqCalculator();
    }

    @Test
    public void testInitialValues() {
        assertEquals(BigInteger.ZERO, calculator.calculateLabseq(0));
        assertEquals(BigInteger.ONE, calculator.calculateLabseq(1));
        assertEquals(BigInteger.ZERO, calculator.calculateLabseq(2));
        assertEquals(BigInteger.ONE, calculator.calculateLabseq(3));
    }

    @Test
    public void testLargeIndex() {
        assertDoesNotThrow(() -> calculator.calculateLabseq(10000), "Should handle large indices without errors");
    }

    @Test
    public void testNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateLabseq(-1), "Should throw an exception for negative index");
    }
}
