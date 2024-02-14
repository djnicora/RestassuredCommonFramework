package utils;

import net.datafaker.Faker;

public class RandomDataGenerator {
    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataTypes dataTypes) {
        switch (dataTypes) {
            case FULLNAME:
                return faker.name().fullName();
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();


            default:return "Data type not available";
        }

    }

}
