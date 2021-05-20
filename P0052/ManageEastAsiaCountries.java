package P0052;

import java.util.Arrays;
import java.util.Comparator;

public class ManageEastAsiaCountries {
    private EastAsiaCountries[] countries = new EastAsiaCountries[11];

    private int countryIndex = 0;

    public EastAsiaCountries getNewCountry() {
        System.out.println("Enter code of country: ");
        String countryCode = Validation.checkInputString("code of country");
        System.out.println("Enter name of country: ");
        String countryName = Validation.checkInputString("name of country");
        System.out.println("Enter total Area: ");
        float totalArea = Validation.checkTotalArea(Validation.sc.nextLine());
        System.out.println("Enter terrain of country: ");
        String countryTerrain = Validation.checkInputString("terrain of country");
        return new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
    }

    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        if (Validation.isDuplicated(countries, country))
            throw new Exception("Country is duplicated");
        countries[countryIndex++] = country;
    }

    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (Validation.isNullArray(countries))
            throw new Exception("Database is empty");
        return countries[countryIndex - 1];
    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        if (Validation.isNullArray(countries))
            throw new Exception("Database is empty");
        EastAsiaCountries[] countriesSearched = new EastAsiaCountries[11];
        int countriesSearchedIndex = 0;
        for (int i = 0; i < 11; i++) {
            if (countries[i] == null)
                continue;
            if (countries[i].getCountryName().contains(name)) {
                countriesSearched[countriesSearchedIndex++] = countries[i];
            }
        }
        return countriesSearched;
    }

    public void displayCountries(EastAsiaCountries[] countries) {
        System.out.printf("%-15s %-20s %-25s %-20s %n", "ID", "Name", "Total Area", "Terrain");
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null)
                continue;
            countries[i].display();
        }
    }

    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        if (Validation.isNullArray(countries))
            throw new Exception("Database is empty");
        Arrays.sort(countries, new Comparator<EastAsiaCountries>() {
            public int compare(EastAsiaCountries countryA, EastAsiaCountries countryB) {
                if (countryA == null || countryB == null)
                    return -1;
                return countryA.getCountryName().compareTo(countryB.getCountryName());
            }
        });
        return countries;
    }
}
