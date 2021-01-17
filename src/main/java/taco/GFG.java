package taco;

import java.io.*;

class GFG {
     
// Returns true if given 
// card number is valid
static boolean checkLuhn(String cardNo)
{
    int nDigits = cardNo.length();
 
    int nSum = 0;
    boolean isSecond = false;
    for (int i = nDigits - 1; i >= 0; i--) 
    {
 
        int d = cardNo.charAt(i) - '0';
 
        if (isSecond == true)
            d = d * 2;
 
        // We add two digits to handle
        // cases that make two digits 
        // after doubling
        nSum += d / 10;
        nSum += d % 10;
 
        isSecond = !isSecond;
    }
    return (nSum % 10 == 0);
}
 
    // Driver code
    static public void main (String[] args)
    {
        String cardNo = "";
        if (checkLuhn(cardNo))
            System.out.println("This is a valid card");
        else
            System.out.println("This is not a valid card");
     
    }
}
