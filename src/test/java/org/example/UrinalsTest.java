package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {



    @BeforeAll
    static void setUpBeforeClass() throws Exception {

    }


    @Test
    public void goodString() {


        System.out.println("====== Purushothama Shanthappa == TEST TWO EXECUTED =======");

        String str = "====== Purushothama Shanthappa == TEST TWO EXECUTED =======";
        assertEquals("====== Purushothama Shanthappa == TEST TWO EXECUTED =======", str);
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.gc();
    }
}