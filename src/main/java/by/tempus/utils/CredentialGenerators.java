package by.tempus.utils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CredentialGenerators {

    //email
    public static String getValidEmail() {
        String localPart = getLocalPartOfEmail();
        String domenName = getDomenNamePartOfEmail();
        String domenZone = getDomenZonePartOfEmail();

        String email = String.format("%s@%s.%s", localPart, domenName, domenZone);

        return email;
    }

    public static String getInvalidEmailWithoutDomenZonePart() {
        String localPart = getLocalPartOfEmail();
        String domenName = getDomenNamePartOfEmail();

        String email = String.format("%s@%s", localPart, domenName);

        return email;
    }

    private static String getLocalPartOfEmail() {
        String localPartOfEmail = "";
        int MIN_REQUIRED_LENGTH = 6;
        int MAX_REQUIRED_LENGTH = 32;
        String requiredSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        int size = ThreadLocalRandom.current().nextInt(MIN_REQUIRED_LENGTH, MAX_REQUIRED_LENGTH + 1);

        for (int i = 0; i <= size; i++) {
            localPartOfEmail += requiredSymbols.charAt(ThreadLocalRandom.current().nextInt(requiredSymbols.length()));
        }

        return localPartOfEmail;
    }

    private static String getDomenNamePartOfEmail() {
        List<String> domenNamePartOfEmail = new ArrayList<>(Arrays.asList("google", "yahoo", "example", "microsoft",
                "apple", "amazon", "vk", "mail"));

        return domenNamePartOfEmail.get(ThreadLocalRandom.current().nextInt(domenNamePartOfEmail.size()));
    }

    private static String getDomenZonePartOfEmail() {
        List<String> domenZones = new ArrayList<>(Arrays.asList("com", "ru", "org", "net", "edu", "gov"));


        return domenZones.get(ThreadLocalRandom.current().nextInt(domenZones.size()));
    }

    //phone
    public static String getValidBelarusPhoneNumber() {

        return getValidPhoneNumber("BY", "MTS", 7);
    }

    public static String getInvalidBelarusPhoneNumber() {
        return getValidPhoneNumber("BY" , "Welcome", 3);
    }

    private static String getValidPhoneNumber(String countryCodeValue, String providerName, int phoneLength) {
        String countryCode = getPhoneCountryCode(countryCodeValue);
        String providerCode = getSpecifiedProviderCode(providerName);
        String ownNumber = getOwnPhoneNumber(phoneLength);

        return countryCode + providerCode + ownNumber;
    }

    private static String getPhoneCountryCode(String countryCodeValue) {
        Map<String, String> countryCode = new HashMap<>();
        countryCode.put("BY", "+375");
        countryCode.put("PL", "+48");
        countryCode.put("DE", "+49");

        return countryCode.get(countryCodeValue);
    }

    private static String getSpecifiedProviderCode(String providerName) {
        Map<String, String> providerCode = new HashMap<>();
        providerCode.put("Welcome", "44");
        providerCode.put("MTS", "29");
        providerCode.put("Life", "33");

        return providerCode.get(providerName);
    }

    private static String getOwnPhoneNumber(int phoneLength) {
        String ownNumber = "";

        for (int i = 0; i <= phoneLength; i++) {
            ownNumber += ThreadLocalRandom.current().nextInt(10);
        }

        return ownNumber;
    }

    //password
    public static String getValidPassword() {
        String passwordValue = "";

        int MIN_REQUIRED_LENGTH = 6;
        int MAX_REQUIRED_LENGTH = 10;

        String requiredAlphabeticSymbols = "abcdefghijklmnopqrstuvwxyz";
        String requiredNumericSymbols = "0123456789";
        String requiredSpecialSymbols = "!@#$%^&*()_+";

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(MIN_REQUIRED_LENGTH,MAX_REQUIRED_LENGTH); i++) {
            passwordValue += requiredAlphabeticSymbols.charAt(
                    ThreadLocalRandom
                            .current()
                            .nextInt(requiredAlphabeticSymbols.length() - 1)
            );

            passwordValue = passwordValue.toLowerCase();
        }

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(10); i++) {
            passwordValue += requiredAlphabeticSymbols.charAt(
                    ThreadLocalRandom
                            .current()
                            .nextInt(requiredAlphabeticSymbols.length() - 1)
            );
        }

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(4); i++) {
            passwordValue += requiredNumericSymbols.charAt(
                    ThreadLocalRandom
                            .current()
                            .nextInt(requiredNumericSymbols.length() - 1)
            );
        }

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(4); i++) {
            passwordValue += requiredSpecialSymbols.charAt(
                    ThreadLocalRandom
                            .current()
                            .nextInt(requiredSpecialSymbols.length() - 1)
            );
        }

        return passwordValue;
    }

    public static String getInvalidPassword() {
        int MIN_REQUIRED_LENGTH = 6;

        return getValidPassword().substring(0, MIN_REQUIRED_LENGTH - 1);
    }

    public static String getName() {
        String requiredAlphabeticSymbols = "abcdefghijklmnopqrstuvwxyz";

        String nameValue = String.valueOf(requiredAlphabeticSymbols.charAt(
                    ThreadLocalRandom
                            .current()
                            .nextInt(requiredAlphabeticSymbols.length() - 1)
        ));

        nameValue = nameValue.toLowerCase();

        for (int i = 0; i <= 10; i++) {
            nameValue += requiredAlphabeticSymbols.charAt(ThreadLocalRandom.current().nextInt(requiredAlphabeticSymbols.length() - 1));
        }

        return nameValue;
    }
}
