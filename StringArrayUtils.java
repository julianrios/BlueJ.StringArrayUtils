/**
 * Created by leon on 1/29/18.
 */

import java.util.Arrays;  
import java.util.List;  
import java.util.ArrayList;  

public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        String s = array[0];
        return s;
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        String s = array[1];
        return s;
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        String s = array[array.length-1];
        return s;
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        String s = array[array.length-2];
        return s;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean contains = false;
        for (String s : array) {
            s.contains(value);
            contains = true;
        }
        return contains;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        // for (int i = 0; i <= array.length/2; i++) {
        //     String temp = array[i];
        //     array[i] = array[array.length-1-i];
        //     array[array.length-1-i] = temp;
        //     System.out.println("Array after Reverse : " + Arrays.toString(array));
        // }
        String[] reverse = new String[array.length];
        int j = 0;
        for (int i = array.length-1; i >= 0; i--) {
            reverse[j] = array[i];
            j++;
        }
        return reverse;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] reverse = StringArrayUtils.reverse(array);
        if(Arrays.equals(reverse, array)) {
            return true;
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String sentence = "";
        for (String s : array) {
            sentence += s;
        }
        sentence = sentence.replaceAll("\\s+","").toLowerCase();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(char letter : alphabet) {
            if(!sentence.contains(String.valueOf(letter))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for (String s : array) {
            if(s.contains(value)) {
                counter++;    
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        // int counter = 0;
        // ArrayList<String> convertedArray = new ArrayList(Arrays.asList(array));
        // for (String s : convertedArray) {
        //     if(s.equals(valueToRemove)) {
        //         System.out.println(s);
        //         convertedArray.remove(s);
        //     } else {
        //         convertedArray.add(s);
        //     }
        // }
        // String[] backToString = new String[convertedArray.size()];
        // backToString = convertedArray.toArray(backToString);

        // for (String s : backToString) {
        //     System.out.println(s);
        // }

        // return backToString;

        String[] truncated = new String[array.length-1]; //taking one out so array.length - 1 
        int j = 0;

        for (int i = 0; i <= array.length-1; i++) {
            String str = array[i];
            if(!(str.equals(valueToRemove))) {
                // if str. doesn't equal
                truncated[j] = str;
                j++;
            }
        }
        return truncated;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        // converted array into a list
        List<String> l = Arrays.<String>asList(array);
        // converted list into an arraylist
        ArrayList<String> original = new ArrayList<String>(l);
        // created a new list to add only add only non consecutive pairs
        List<String> withoutConsects = new ArrayList<String>();
        // add the first one since any following elements would be consecutive
        withoutConsects.add(original.get(0));
        for(int i = 1; i< original.size(); i++) {
            // compare the current value to the previous
            if(!(original.get(i-1).equals(original.get(i))))
            {   
                withoutConsects.add(original.get(i));
            }
        }
        String[] arr = new String[withoutConsects.size()];
        // passed in an array in which the list is stored returns an array containing the elements
        arr = withoutConsects.toArray(arr);
        return arr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        int size = 1;
        for (int currentIndex = 0; currentIndex < array.length -1; currentIndex++) {
            if(array[currentIndex] != array[currentIndex + 1]) size++;
        }
        String[] answer = new String[size];
        String temp = array[0];
        int placeholder = 0;

        for (int currentIndex = 1;currentIndex < array.length; currentIndex++) {
            if(array[currentIndex] == array[currentIndex-1]) {
                temp = temp + array[currentIndex];
            } else {
                answer[placeholder++] = temp;
                temp = array[currentIndex];
            }
        }
        answer[answer.length-1] = temp;
        return answer;
    }
}
