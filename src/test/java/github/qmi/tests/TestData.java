package github.qmi.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    public static String FILE_NAME = "image.jpeg";
    public static String MONTH = "December";
    public static String YEAR = "1953";
    public static String DAY = "09";
    public static String SUBJECT = "Maths";
    public static String STATE = "NCR";
    public static String CITY = "Delhi";

    private final Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().streetAddress();
}
