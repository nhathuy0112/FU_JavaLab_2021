package P0052;

import java.util.Scanner;

public class CountryMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        int option = 0;

        while (option != 5) {
            menu();
            option = Validation.checkInputLimit(Validation.sc.next());
            Validation.sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter code of country: ");
                    String countryCode = Validation.checkInputString("code of country");
                    System.out.println("Enter name of country: ");
                    String countryName = Validation.checkInputString("name of country");
                    System.out.println("Enter total Area: ");
                    float totalArea = Validation.checkTotalArea(Validation.sc.nextLine());
                    System.out.println("Enter terrain of country: ");
                    String countryTerrain = Validation.checkInputString("terrain of country");
                    // EastAsiaCountries country = manager.getNewCountry();
                    try {
                        manager.addCountryInformation(
                                new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain));
                        // manager.addCountryInformation(country);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 2:
                    System.out.printf("%-15s %-20s %-25s %-20s %n", "ID", "Name", "Total Area", "Terrain");
                    try {
                        manager.getRecentlyEnteredInformation().display();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter name of country: ");
                    String countrySearched = Validation.checkInputString("name of country");
                    try {
                        manager.displayCountries(manager.searchInformationByName(countrySearched));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        manager.displayCountries(manager.sortInformationByAscendingOrder());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("                                    MENU                                  ");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
        System.out.print("Your choice: ");
    }

}
