package com.javarush.test.practice.System;

import java.io.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Rostyslav.Pash on 06-Jan-16.
 */
public class Test
{
    public static void main(String[] args) throws Exception
    {
        BigInteger result = new BigInteger("10");
        BigInteger number = new BigInteger("10");

        System.out.println(number.multiply(result));
    }
}
