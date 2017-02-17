/*
 * @(#)Tasks.java
 *
 * Copyright (c) No copyright.
 *
 * This program is used to find all natural numbers, which are less then
 * and are mutually simple with the provided number; all natural numbers, 
 * which are less then  * and are mutually amicable with the provided number;
 * provide solution  * for uncommon situation, when You need to  * find all 
 * numbers from array, divided  * by 5 and not divided by 7.
 *
 */

package com.softserve.edu;

/**
 * Class used to provide solution.
 *
 * @version 1.1
 * @author Andrii Mishchuk
 * @since 02.2017
 */

public class Tasks {
    
    /**
     * Simple constructor.
     */
    private Tasks(){
        
    }

    /**
     * Method main used for providing the solution, according to input.
     *
     * @param args Unused.
     *
     */
    
    public static void main(String[] args) {
        /** Provides the size of array.*/
        int j = 7;

        /** Array, which provides all numbers, to be analyzed.*/
        int[] inputNumbers = new int[]{15, 20, 24, 12, 7, 4, 25};
        
        /** Provides input for method findLessAndSimple.*/
        int k = 50;
        
        Solution solut = new Solution();
        System.out.println(solut.findLessAndSimple(k));
        System.out.println(solut.findMutuallyAmicable());
        System.out.println(solut.findNumbersConditionMet(j, inputNumbers));
        

    }

}
