
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {

     /**
     * take input option and validate it
     * @param message message to user
     * @param min min value of input
     * @param max max value of input
     * @return the integer that user inputted
     */
    public static int getOption(String message, int min, int max) {
        int input;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(message);
            String s = sc.nextLine();
            //throw exception if the input is empty
            if (s.isEmpty()) {
                throw new Exception("Empty input");
            }
            input = Integer.parseInt(s);
            //throw exception if the input is not in range from min to max
            if (input < min || input > max) {
                throw new Exception("Not in range [" + min + "-" + max + "]");
            }
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getOption(message, min, max);
        }
    }

    public int getInt(String msg, String errorMsg, int min, int max) {
        String input;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Empty input");
                }
                int result = Integer.parseInt(input);
                if (result < min || result > max) {
                    throw new Exception(errorMsg);
                }
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String getString(String msg, String errorMsg, String regex) {
        String input;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Empty input");
                }
                if (regex.isEmpty() || input.matches(regex)) {
                    return input;
                } else {
                    throw new Exception(errorMsg);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public Date getDate(String msg) {
        String input;
        Date date;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(msg);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                input = sc.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Empty input");
                } else if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                    throw new Exception("Wrong format dd--MM-yyyy");
                }
                date = dateFormat.parse(input);
//                if (date.before(new Date())) {
//                    throw new Exception("This date is in the past!");
//                }
                return date;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String getTaskType(String msg) {
        int taskTypeID = getInt(msg, "Task Type must be in range [1-4]", 1, 4);
        switch (taskTypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            default:
                return "Review";
        }
    }
    public double getDouble(String msg, String errorMsg, double min, double max) {
        double result;
        String input;
        do {            
            try {
                input = getString(msg, "Only accept multiples of 0.5 as input", 
                        "(^[\\d]+\\.[05]$)|(^[\\d]+$)");
                result = Double.parseDouble(input);
                if(result < min || result > max) {
                    throw new Exception(errorMsg);
                }
                return result;
            }catch (NumberFormatException e) {
                System.out.println("Not a real number");
            } 
            catch (Exception e) {
                System.out.println(e.getMessage());
            } 
        } while (true);
    }
}
