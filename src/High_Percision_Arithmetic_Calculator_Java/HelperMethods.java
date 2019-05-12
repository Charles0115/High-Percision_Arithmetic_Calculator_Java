package High_Percision_Arithmetic_Calculator_Java;

abstract class HelperMethods {

    static int CalculateStatus(String number1, String number2)
    {
        String[] array1 = number1.split("[.]");
        String[] array2 = number2.split("[.]");

        if(array1.length == 1 && array2.length == 1)
            return 1;
        else if(array1.length == 1 && array2.length == 2)
            return 2;
        else if(array1.length == 2 && array2.length == 1)
            return 2;
        else if(array1.length == 2 && array2.length == 2)
            return 3;
        else
            return 0;
    }

    static int CheckSign(String number1, String number2)
    {
        if(number1.charAt(0) != '-' && number2.charAt(0) != '-')
            return 1;
        else if(number1.charAt(0) == '-' && number2.charAt(0) != '-')
            return 2;
        else if(number1.charAt(0) != '-' && number2.charAt(0) == '-')
            return 3;
        else
            return 4;
    }

    static boolean isRight(String number1, String number2)
    {
        String[] array1 = number1.split("[.]");
        String[] array2 = number2.split("[.]");

        if(array1.length > 2 || array2.length > 2)
            return false;

        if(!(number1.charAt(0)=='-' || (number1.charAt(0)>='0' && number1.charAt(0)<='9')))
            return false;
        for(int i=1; i<number1.length(); i++)
        {
            if(!(number1.charAt(i)=='.' || (number1.charAt(i)>='0' && number1.charAt(i)<='9')))
                return false;
        }

        if(!(number2.charAt(0)=='-' || (number2.charAt(0)>='0' && number2.charAt(0)<='9')))
            return false;
        for(int i=1; i<number2.length(); i++)
        {
            if(!(number2.charAt(i)=='.' || (number2.charAt(i)>='0' && number2.charAt(i)<='9')))
                return false;
        }

        return true;
    }

    static int[] AddOperation(int[] num1, int[] num2, int ArrayLength)
    {
        int[] finalresult = new int[ArrayLength];
        int[] temp = new int[ArrayLength];
        for(int i=0; i<ArrayLength; i++)
        {
            temp[i] = num1[i];
        }
        int carry = 0;
        int digit =0;
        for(int i=ArrayLength-1; i>0; i--)
        {
            digit = temp[i] + num2[i];
            finalresult[i] = digit % 10;
            carry = digit / 10;
            temp[i-1] = temp[i-1] + carry;
        }

        digit = temp[0] + num2[0];
        finalresult[0] = digit;

        return finalresult;
    }
}
