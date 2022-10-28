package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {


    static Urinals ur;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        ur = new Urinals();
    }

    @Test
    void goodString() {
        System.out.println("====== Purushothama Shanthappa == TEST ONE EXECUTED ======= GOOD STRINGS");
        Assertions.assertEquals(true, ur.goodString("10001"));
        Assertions.assertEquals(true, ur.goodString("1001"));
        Assertions.assertEquals(true, ur.goodString("00000"));
        Assertions.assertEquals(true, ur.goodString("0000"));
        Assertions.assertEquals(true, ur.goodString("01000"));
        Assertions.assertEquals(true, ur.goodString("011"));
    }

    @Test
    void badString() {
        System.out.println("====== Purushothama Shanthappa == TEST TWO EXECUTED ======= BAD STRINGS");
        Assertions.assertEquals(false, ur.goodString("1011A0"));
        Assertions.assertEquals(false, ur.goodString("/"));
        Assertions.assertEquals(false, ur.goodString("101120"));
        Assertions.assertEquals(false, ur.goodString("10111111110000000000101010101010000"));
        Assertions.assertEquals(false, ur.goodString("A"));
    }

    @Test
    void cardinalExpected() {
        System.out.println("====== Purushothama Shanthappa == TEST THREE EXECUTED ======= CARDINAL COUNT EXPECTED");
        Assertions.assertEquals(1, ur.countUrinals("10001"));
        Assertions.assertEquals(0, ur.countUrinals("1001"));
        Assertions.assertEquals(3, ur.countUrinals("00000"));
        Assertions.assertEquals(2, ur.countUrinals("0000"));
        Assertions.assertEquals(1, ur.countUrinals("01000"));
        Assertions.assertEquals(-1, ur.countUrinals("/"));
        Assertions.assertEquals(-1, ur.countUrinals("1234"));
        Assertions.assertEquals(-1, ur.countUrinals("0022"));
        Assertions.assertEquals(-1, ur.countUrinals("1133"));
    }

    @Test
    void createFile() throws Exception {
        System.out.println("====== Purushothama Shanthappa == TEST FOURTH EXECUTED =======  File creation");
        Assertions.assertEquals(true, ur.createfile("rule.txt"));
        Assertions.assertEquals(false, ur.createfile("rule1.txt"));
        Assertions.assertEquals( true, ur.createfile("rule2.txt"));

    }


    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.gc();
    }
}