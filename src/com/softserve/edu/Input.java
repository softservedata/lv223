 /*
 * @(#)Input.java
 *
 * Copyright (c) No copyright.
 *
 * This class is used to provide us all the needed inputs and
 * to guide customer or user through functionality.
 *
 */

package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class used to provide input and guidance.
 *
 * @version 1.0
 * @author Andrii Mishchuk
 * @since 02.2017
 */


public class Input {
/**Contains input from BufferedReader.*/
private String thisLine;
/** Used for replacing unnneeded characters from the input. */
private String replace;
/** provides us with the number for analysis. */
private int inputNumber;
/**Contains results of method use.*/
private ArrayList<Integer> list;
/**Contains converted data from input.*/
private ArrayList<Integer> numbersList;
/** Contains input from BufferedReader.*/
private ArrayList<String> stringList;
/** Contains results of method use.*/
private ArrayList<String> resultingList;
/** Provides us with object Solution to run it's methods.*/
private Solution solut;
/** Provides us with BufferedReader for getting input.*/
private BufferedReader br;

    /**

     * Simple constructor.

     */
    public Input() {
    }

    /**

     * Method is used to provide user with guide,
     * getting user inputs and calling methods for
     * analysis.

     *

     *

     */

    public void scanInput() {

        solut = new Solution();
        System.out.println("Hi there. Please specify action,"
                + " You want to do.\n Type \"A\" "
                + "to find Less and Simple Numbers;\n "
                + "Type \"B\" to find Mutually Amicable numbers;\n Type"
                + " \"C\" to find count and summ of numbers, divided by 5"
                + " and not divided by 7.\n Enter:");
        br = new BufferedReader(new InputStreamReader(System.in));
    try {
        while ((thisLine = br.readLine()) != null) {
        switch (thisLine.toUpperCase()) {
            case "A":
            System.out.println("Please enter natural (>0) number,"
                    + " which should be analyzed. \n Enter:");
                thisLine = br.readLine();
                inputNumber = Integer.parseInt(thisLine);
                System.out.println("Less and simple numbers of "
                        + "the input numbers are: "
                        + solut.findLessAndSimple(inputNumber));
                System.out.println("To quit the app, type "
                        + "\"Q\", to make other analysis, type \"N\"");
                break;
            case "B":
                System.out.println("Please enter two natural (>0) numbers "
                        + "to set the range to analyze. \n Enter:");
                System.out.println("Please enter the start number"
                        + " and the end number.\n Separate them "
                        + "with comma (200, 300) \n Enter:");
                thisLine = br.readLine();
                replace = thisLine.replace("[", "");
                stringList = new ArrayList<String>(Arrays.asList(
                        replace.split(",")));
                numbersList = new ArrayList<Integer>();
                for (String fav:stringList) {
                    numbersList.add(Integer.parseInt(fav.trim()));
                    }
                resultingList = solut.findMutuallyAmicable(numbersList);
                System.out.println("Mutually amicable numbers in range are: ");
                for (int i = 0; i < resultingList.size(); i++) {
                    System.out.println(resultingList.get(i));
                }
                System.out.println("To quit the app, type \"Q\","
                        + " to make other analysis, type \"N\"");
                break;
            case "C":
                    System.out.println("Please enter natural (>0) elements, "
                            + "You want to analyze.\n Separate them "
                        + "with comma (2, 3, 4) \n Enter:");
                    thisLine = br.readLine();
                    replace = thisLine.replace("[", "");
                    stringList = new ArrayList<String>(Arrays.asList(
                            replace.split(",")));
                numbersList = new ArrayList<Integer>();
                for (String fav:stringList) {
                    numbersList.add(Integer.parseInt(fav.trim()));
                }
                list = solut.findNumbersConditionMet(numbersList);
                System.out.println("Count of numbers, divided by 5"
                        + " and not divided by 7 is " + list.get(0) + ". Summ "
                        + "of numbers, divided by 5 and not divided by 7 are: "
                        + list.get(1) + ".");
                System.out.println("To quit the app, type \"Q\", to make "
                        + "other analysis, type \"N\"");
                break;
            case "Q":
                System.out.println("Operation ended.");
                throw new Exception();
            case "N":
                System.out.println("Hi there. Please specify action, "
                        + "You want to do.\n Type \"A\" "
                        + "to find Less and Simple Numbers;\n "
                        + "Type \"B\" to find Mutually Amicable numbers;\n Type"
                        + " \"C\" to find count and summ of "
                        + "numbers, divided by 5"
                        + " and not divided by 7.\n Enter:");
                break;
            default:
                    break;
            }
            }
        } catch (Exception e) {
        } finally {
            try {
                br.close();
                } catch (IOException z) {
            }
    }
        }
}
