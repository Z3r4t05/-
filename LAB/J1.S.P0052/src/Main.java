
public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        int choice;
        do {//Return to main screen after each after each option
            
            //step 1. Display the menu
            m.displayMenu();
            
            //step 2. Ask user to select option
            choice = m.selectOption("Enter your choice : ");
            
            //step 3. Perform function based on the selected option
            switch (choice) {
                case 1://Add information of 11 countries
                    m.addCountryInformation();
                    break;
                case 2://Display information of country user has just entered
                    try {
                        m.getRecentlyEnteredInformation().display();
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 3://Search information of country by user-entered name
                    try {
                        Utility.displayArray(m.searchInformationByName());
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 4://Display country by ascen1ding order of name
                    try {
                        Utility.displayArray(m.sortInformationByAscendingOrder());
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 5://Exit the program
                    System.exit(0);
            }
        } while (choice != 5);
    }
}
