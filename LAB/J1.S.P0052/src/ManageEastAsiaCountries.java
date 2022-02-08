
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class ManageEastAsiaCountries {

    public ManageEastAsiaCountries() {
    }

    /**
     * Ask user to enter information of country then add it to the list
     *
     * @param countryList list of countries
     * @return
     */
    public EastAsiaCountries addCountryInformation
        (ArrayList<EastAsiaCountries> countryList) {
        EastAsiaCountries country = new EastAsiaCountries();
        //Ask user again if the input is not valid
        while (true) {
            try {
                country.setCountryCode(Utility.findExistedCode(
                        countryList, Utility.inputCode(
                                "Enter code of country: ",
                                Utility.COUNTRY_CODE)));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //ask user again if the input is not valid
        while (true) {
            try {
                country.setCountryName(Utility.findExistedName(
                        countryList, Utility.inputName(
                                "Enter name of country: ",
                                Utility.COUNTRY_NAME)));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //Keep asking for area if the program catches an exception
        while (true) {
            try {
                country.setTotalArea(Utility.inputTotalArea(
                        "Enter total Area: "));
                break;
            } catch (Exception e) {
                //Tell user to enter an float if the input is not a number
                if (e instanceof NumberFormatException) {
                    System.out.println("Invalid input. Area must be "
                            + "a positive float or integer!");
                } else {
                    System.out.println(e.getMessage());
                }
            }
        }
        //Keep asking for terrain if program catches an exception
        while (true) {
            try {
                country.setCountryTerrain(Utility.inputTerrain(
                        "Enter terrain of country: "));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return addCountryInformation(country, countryList);
    }

    /**
     * add country to the list
     *
     * @param country to be added
     * @param countryList
     * @return
     */
    public EastAsiaCountries addCountryInformation
        (EastAsiaCountries country, ArrayList<EastAsiaCountries> countryList) {
        try {
            countryList.add(country);
        } catch (Exception e) {
            //Change the message of the exception
            if (e instanceof IndexOutOfBoundsException) {
                System.out.println("Index out of range");
            } else {
                System.out.println(e.getMessage());
            }
        }
        return country;
    }

    /**
     * Display information of countries you have just inputted.
     *
     * @param country
     * @return the country that you've recently inputted
     * @throws Exception if you haven't entered anything
     */
    public EastAsiaCountries getRecentlyEnteredInformation(
            EastAsiaCountries country) throws Exception {
        //Check if user has entered input at least 1 time or not
        if (country == null) {
            throw new Exception("You haven't entered anything");
        }
        System.out.printf("%-16s%-16s%-16s%-16s\n",
                "ID", "NAME", "Total Area", "Terrain");
        return country;
    }

    /**
     * Search information of countries by user-entered name
     *
     * @param countryList
     * @return array of countries that matches a part of the name
     * @throws Exception if the list is empty or not found any country or the
     * input name is invalid
     */
    public EastAsiaCountries[] searchInformationByName(
            ArrayList<EastAsiaCountries> countryList)
            throws Exception {
        ArrayList<EastAsiaCountries> result = new ArrayList<>();
        //If the data is empty throw new exception
        if (countryList.isEmpty()) {
            throw new Exception("Empty country list!");
        }
        String input = Utility
                .getNonBlankStr("Enter the name you want to search for: ")
                .toLowerCase();
        //If the input is not valid then throw new exception
        if (!Utility.isValid(input, Utility.COUNTRY_NAME)) {
            throw new Exception("Not a valid name!");
        }
        //Searching for name in data that matches the input ignoring case
        for (EastAsiaCountries c : countryList) {
            //add the country in data that matches the input to the result list
            if (c.getCountryName().toLowerCase().contains(input)) {
                result.add(c);
            }
        }
        //If it doesn't found any country then throw new exception
        if (result.isEmpty()) {
            throw new Exception("Not found");
        }

        return result.toArray(new EastAsiaCountries[result.size()]);
    }

    /**
     * Sort information of countries by ascending order of names
     *
     * @param countryList
     * @return the sorted array of countries
     * @throws Exception if the array is empty
     */
    public EastAsiaCountries[] sortInformationByAscendingOrder(
            ArrayList<EastAsiaCountries> countryList)
            throws Exception {
        //throw exception if the list is empty
        if (countryList.isEmpty()) {
            throw new Exception("Empty list!");
        }
        Collections.sort(countryList);
        return countryList.toArray(new EastAsiaCountries[countryList.size()]);
    }
}
