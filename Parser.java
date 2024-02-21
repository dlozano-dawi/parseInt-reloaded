import java.util.HashMap;

public class Parser {
    
    public static int parseInt(String numStr) {
        // Check special Cases
        if (numStr.equals("zero")){
          return 0;
        } else if (numStr.equals("one million")){
          return 1000000;
        }
      
        // Hashmap with all the words
        HashMap<String, String> hmp = new HashMap<String, String>();
        hmp.put("one", "1");
        hmp.put("two", "2");
        hmp.put("three", "3");
        hmp.put("four", "4");
        hmp.put("five", "5");
        hmp.put("six", "6");
        hmp.put("seven", "7");
        hmp.put("eight", "8");
        hmp.put("nine", "9");

        hmp.put("ten", "10");
        hmp.put("eleven", "11");
        hmp.put("twelve", "12");
        hmp.put("thirteen", "13");
        hmp.put("fourteen", "14");
        hmp.put("fifteen", "15");
        hmp.put("sixteen", "16");
        hmp.put("seventeen", "17");
        hmp.put("eighteen", "18");
        hmp.put("nineteen", "19");

        hmp.put("twenty", "20");
        hmp.put("thirty", "30");
        hmp.put("forty", "40");
        hmp.put("fifty", "50");
        hmp.put("sixty", "60");
        hmp.put("seventy", "70");
        hmp.put("eighty", "80");
        hmp.put("ninety", "90");


        // Split by spaces
        String[] arr = numStr.split(" ");
        int solve = 0;
        int temp = 0;

        // Check each digit
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("hundred")) {
                temp *= 100;
            } else if (arr[i].equals("thousand")) {
                temp *= 1000;
                solve += temp;
                temp = 0;
            } else if (arr[i].contains("-")) {
                String[] splitted = arr[i].split("-");
                temp += Integer.parseInt(hmp.get(splitted[0])) + Integer.parseInt(hmp.get(splitted[1]));
            } else if (hmp.containsKey(arr[i])){
                temp += Integer.parseInt(hmp.get(arr[i]));
            }

        }
        return solve + temp;
    }
}
