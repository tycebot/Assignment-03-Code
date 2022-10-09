/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartC;

public class BlurbGenerator {

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int randomNumberGenerator=(int)(Alphabet.length() * Math.random());
    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        StringBuilder sb=new StringBuilder();

        return null;
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {
        return null;
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString() {
        return null;
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */
    private String makeMultiWhatzits() {
        return null;
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */
    private String makeWhatzit() {
        return null;
    }
}