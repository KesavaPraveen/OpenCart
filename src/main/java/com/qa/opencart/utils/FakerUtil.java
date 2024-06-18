package com.qa.opencart.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    public static String generateFirstName()
    {
        Faker faker=new Faker();
        return "First" +faker.regexify("[A-Za-z]{10}");
    }

    public static String generateLastName()
    {
        Faker faker=new Faker();
        return "Last" +faker.regexify("[A-Za-z]{10}");
    }

    public static String generateEmail()
    {
        Faker faker=new Faker();
        return "Test" +faker.regexify("[A-Za-z]")+"@"+"test.com";
    }

    public static String generateTelePhoneNumber()
    {
        Faker faker=new Faker();
        return faker.regexify("[0-9]{10}");
    }

    public static String generatePassword()
    {
        Faker faker=new Faker();
        return "Test"+"@"+faker.regexify("[0-9]{4}");
    }
}
