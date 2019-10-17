import java.util.*;

public class MariaHeresWeek2Homework
{
    // way of generating random strings
    public static String randomString(int length)
    {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd_in_method = new Random();
        StringBuilder temporary_string = new StringBuilder(length);
        for( int i = 0; i < length; i++ )
            temporary_string.append(letters.charAt(rnd_in_method.nextInt(letters.length())));
        return temporary_string.toString();
    }

    public static String getInput1 (Scanner myObj)
    {
        System.out.println("Enter first desired string:");
        return myObj.nextLine();
    }

    public String getInput2 (Scanner myObj)
    {
        System.out.println("Enter second desired string:");
        return myObj.nextLine();
    }

    public static void areEqual(String string_used1, String string_used2)
    {
        System.out.print("The two strings are equal (true/false): ");
        System.out.println(string_used1.equals(string_used2));
    }

    public static void concatenateStrings(String string_used1, String string_used2)
    {
        string_used1=string_used1.concat(string_used2);
        System.out.println("Concatenated: " + string_used1);
    }

    public static void checkPalindrome(Scanner myObj)
    {
        String palindrome_test;
        do
        {
            System.out.println("Please only enter one word: ");
            palindrome_test = myObj.nextLine();
        } while (palindrome_test.contains(" ") | palindrome_test.isEmpty());
        StringBuilder rev = new StringBuilder();
        rev.append(palindrome_test);
        rev = rev.reverse();
        if (palindrome_test.equals(rev.toString()))
            System.out.println("This is a palindrome.");
        else
            System.out.println("This is not a palindrome.");
    }

    public static void iterateListInitial(ListIterator<String> itr)
    {
        System.out.println("Traversing elements in forward direction");
        while(itr.hasNext())
            System.out.println("index:"+itr.nextIndex()+" value:"+itr.next());
    }

    private static String iterateRule1(ListIterator<String> itr, String empty)
    {
        while(itr.hasNext())
        {
            int buf = itr.nextIndex();
            String buffer = itr.next();
            if (buffer.matches("(?i)^[aeiouAIEOU].*$"))
                empty=empty.concat(buffer.toLowerCase());
        }
        return empty;
    }

    private static HashMap iterateRule2(ListIterator<String> itr, String[] empty_array)
    {
        int for_array=0;
        while(itr.hasNext())
        {
            int buf = itr.nextIndex();
            String buffer = itr.next();
            if (buffer.matches("(?i)^[^aeiouAIEOU].*$"))
            {
                empty_array[for_array]=buffer.toUpperCase();
                for_array++;
            }
        }
        HashMap <String[], Integer> array = new HashMap<>();
        array.put(empty_array, for_array);
        return array;
    }

    private static void iterateRule3(ListIterator<String> itr)
    {
        while(itr.hasNext())
        {
            int buf = itr.nextIndex();
            String buffer = itr.next();
            if (buffer.matches("[xX]") || (buffer.length() < 3))
            {
                System.out.print("index: " + buf + ", value: " + buffer + " has been replaced by: ");
                itr.set("skipped");
                System.out.println("skipped");
            }
        }
    }

    public static void getMap(HashMap<String, String> a_map)
    {
        System.out.println("Our default map is ");
        for(Map.Entry<String, String> m:a_map.entrySet())
            System.out.println(m.getKey()+" "+m.getValue());

        System.out.println("Its size is " + a_map.size());
    }

    public static void findNameInMap(Scanner myObj, HashMap<String, String> a_map)
    {
        System.out.println("Enter the name you want to find:");
        String a_name = myObj.nextLine();
        System.out.println("Does it contains the name : " + a_map.containsKey(a_name));

        if (a_map.containsKey(a_name))
        {
            System.out.println("That name is associated with the email: " + a_map.get(a_name));
            System.out.println("Which will be removed");
            a_map.remove(a_name);
        }
    }

    public static void sortMap(HashMap<String, String> a_map)
    {
        System.out.println("Sorted map is: ");
        Map<String, String> treeMap = new TreeMap<>(a_map);
        for (String str : treeMap.keySet())
            System.out.println(str);
    }

    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        Random rnd_length = new Random();
        String empty = "";  //empty string
        String[] empty_array = new String[10]; //empty array of strings
        List <String> a_list_of_strings = new ArrayList<>();
        a_list_of_strings.add(randomString(rnd_length.nextInt(15)));
        a_list_of_strings.add(randomString(rnd_length.nextInt(15)));
        a_list_of_strings.add(randomString(rnd_length.nextInt(15)));
        HashMap <String, String> a_map = new HashMap<>();
        a_map.put("Jane Doe","jdoe@hereyougo.com");
        a_map.put("John Doe","jndoe@hereyougo.com");
        a_map.put("Mary Smith","mary@hereyougo.com");
        String input1 = getInput1 (myObj);
        String input2 = getInput1 (myObj);
        areEqual(input1, input2);
        concatenateStrings (input1, input2);
        checkPalindrome (myObj);
        ListIterator<String> itr = a_list_of_strings.listIterator();
        iterateListInitial (itr);
        itr = a_list_of_strings.listIterator();
        empty= iterateRule1(itr, empty);
        itr = a_list_of_strings.listIterator();
        iterateRule2(itr, empty_array);
        HashMap <String, Integer> buffer_map = new HashMap<>();
        itr = a_list_of_strings.listIterator();
        buffer_map=iterateRule2(itr, empty_array);
        int for_array=buffer_map.get(empty_array);
        itr = a_list_of_strings.listIterator();
        iterateRule3(itr);
        System.out.println("The string is now: "+ empty);
        System.out.println("The array is now: ");
        for ( int j=0; j<for_array; j++)
            System.out.println(empty_array[j] + " ");
        getMap (a_map);
        findNameInMap(myObj, a_map);
        sortMap (a_map);
    }
}
