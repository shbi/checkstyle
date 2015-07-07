////////////////////////////////////////////////////////////////////////////////
// Test case file for checkstyle.
// Created: 2001
////////////////////////////////////////////////////////////////////////////////
package com.puppycrawl.tools.checkstyle;

/**
   Contains boolean logic that can be simplified.

   @author lkuehne
 */
public class InputSimpleEmptyLine
{

    public static boolean oneEmptyLine()
    {
        boolean even = System.currentTimeMillis() % 2 == 0;

        // can be simplified to "if (even)"
        if (even == true) {

            return false;

        }

        else {

            return true;

        }
        // return can be simplified to "return !even"
    }

    public static boolean oneToThreeEmptyLine()
    {

        boolean even = System.currentTimeMillis() % 2 == 0;


        // can be simplified to "if (even)"



        if (even == true) {


            return false;

        }


        else {



            return true;


        }

        // return can be simplified to "return !even"



    }

    public static boolean noEmptyLine()
    {
        boolean even = System.currentTimeMillis() % 2 == 0;
        // can be simplified to "if (even)"
        if (even == true) {
            return false;
        }
        else {
            return true;
        }
        // return can be simplified to "return !even"
    }
}
