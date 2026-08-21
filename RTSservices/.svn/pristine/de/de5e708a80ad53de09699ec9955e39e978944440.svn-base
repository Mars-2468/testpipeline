package com.mars.common.utils;

import java.text.DecimalFormat;

public class NumberToWords
{

    private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety" };

    private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen",
	    " sixteen", " seventeen", " eighteen", " nineteen" };

    private static String convertLessThanOneThousand(int number)
    {
	String soFar;

	if (number % 100 < 20)
	{
	    soFar = numNames[number % 100];
	    number /= 100;
	} else
	{
	    soFar = numNames[number % 10];
	    number /= 10;

	    soFar = tensNames[number % 10] + soFar;
	    number /= 10;
	}
	if (number == 0)
	    return soFar;
	return numNames[number] + " hundred" + soFar;
    }

    public static String convert(double number)
    {
	// 0 to 999 999 999 999
	if (number == 0)
	{
	    return "zero";
	}

	String snumber = Double.toString(number);

	// pad with "0"
	String mask = "000000000000.00";
	DecimalFormat df = new DecimalFormat(mask);
	snumber = df.format(number);

	int crore = Integer.parseInt(snumber.substring(0, 5));
	int lakhs = Integer.parseInt(snumber.substring(5, 7));
	int hundredThousands = Integer.parseInt(snumber.substring(7, 9));
	int thousands = Integer.parseInt(snumber.substring(9, 12));
	int paise = Integer.parseInt(snumber.substring(13, 15));

	String tradCrores;
	switch (crore)
	{
	case 0:
	    tradCrores = "";
	    break;
	case 1:
	    tradCrores = convertLessThanOneThousand(crore) + " crore ";
	    break;
	default:
	    tradCrores = convertLessThanOneThousand(crore) + " crores ";
	}
	String result = tradCrores;

	String tradLakhs;
	switch (lakhs)
	{
	case 0:
	    tradLakhs = "";
	    break;
	case 1:
	    tradLakhs = convertLessThanOneThousand(lakhs) + " lakh ";
	    break;
	default:
	    tradLakhs = convertLessThanOneThousand(lakhs) + " lakhs ";
	}
	result = result + tradLakhs;

	String tradHundredThousands;
	switch (hundredThousands)
	{
	case 0:
	    tradHundredThousands = "";
	    break;
	case 1:
	    tradHundredThousands = "one thousand ";
	    break;
	default:
	    tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
	}
	result = result + tradHundredThousands;

	String tradThousand;
	tradThousand = convertLessThanOneThousand(thousands);
	result = result + tradThousand;

	String tradPaise;
	switch (paise)
	{
	case 0:
	    tradPaise = "";
	    break;
	case 1:
	    tradPaise = convertLessThanOneThousand(paise) + " paise ";
	    break;
	default:
	    tradPaise = convertLessThanOneThousand(paise) + " paise ";
	}
	result = result + tradPaise;
	// remove extra spaces!
	return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    public static void main(String args[]){
	System.out.println(NumberToWords.convert(999999999.455));
    }
}
