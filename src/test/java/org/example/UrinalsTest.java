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
        System.out.println("====== Purushothama Shanthappa == TEST ONE EXECUTED =======");
        Assertions.assertEquals( false , ur.goodString("1011A0"));
        Assertions.assertEquals( false , ur.goodString("/"));
        Assertions.assertEquals( true , ur.goodString("1010"));
        Assertions.assertEquals( false , ur.goodString("101120"));
        Assertions.assertEquals( false , ur.goodString("10111111110000000000101010101010000"));
        Assertions.assertEquals( false , ur.goodString("A"));
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.gc();
    }
}