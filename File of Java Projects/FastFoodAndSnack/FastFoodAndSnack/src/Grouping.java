import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Grouping {

   public static void main(String[] args) throws IOException {

    byte[] data = Files.readAllBytes(Paths.get("mydatfile.dat"));
    /* set correct required charset */
    String content = new String(data, StandardCharsets.UTF_8);
    // convert/transform here string if required
    Files.write(Paths.get("file.txt"), content.getBytes(StandardCharsets.UTF_8));


// create new array list to store values from txt file
       List<String> fileList = new ArrayList<String>();

// create map to group image and category
       Map<String, String[]> groupMap = new HashMap<String, String[]>();

// reate list to add all images in a perticular catogory(result)
       List<String> resultList = new ArrayList<>();

// create scanner to accept input from user
       Scanner scanner = new Scanner(System.in);

// call to method to read txt file
       fileList = readFromFile();

// print file content in console
       for (String str : fileList) {
           System.out.println(str);
       }

// call method to group image in map
       groupMap = groupList(fileList);

       System.out.println("/n/n");

// ask user for input
       System.out.println("What would you like to search for ?\n");

// store user input
       String searchstr = scanner.nextLine();

// call method to search user input   

resultList = searchImage(searchstr, groupMap);

// print result images in list
       for (String s : resultList) {
           System.out.println(s);
       }

   }
// method to search category to get image name
   private static List<String> searchImage(String searchstr, Map<String, String[]> groupMap) {
       String[] searchFor;
       List<String> resultList = new ArrayList<>();
       if (searchstr.toUpperCase().contains("OR")) {
           searchFor = searchstr.toUpperCase().split(" OR ");
           if (searchFor.length > 2) {
               System.out.println("Invalid search");
           }
           for (String s1 : searchFor) {
               for (String key : groupMap.keySet()) {
                   String[] values = groupMap.get(key);
                   for (String s : values) {
                       if (s1.toUpperCase().equals(s.toUpperCase())) {
                           resultList.add(key);
                       }
                   }
               }
           }

       } else if (searchstr.toUpperCase().contains("AND")) {

           searchFor = searchstr.toUpperCase().split(" AND ");
           if (searchFor.length > 2) {
               System.out.println("Invalid search");
           }

           int count = 0;
           for (String key : groupMap.keySet()) {
               String[] values = groupMap.get(key);
               for (String s : values) {
                   if (searchFor[0].toUpperCase().equals(s.toUpperCase())) {
                       count++;

                   }
                   if (searchFor[1].toUpperCase().equals(s.toUpperCase())) {
                       count++;
                   }
                   if (count == 2) {
                       resultList.add(key);
                   }
               }

           }

       } else {
           for (String key : groupMap.keySet()) {
               String[] values = groupMap.get(key);
               for (String s : values) {
                   if (searchstr.toUpperCase().equals(s.toUpperCase())) {
                       resultList.add(key);
                   }
               }
           }
       }
       return resultList;

   }
// method to read values from txt file and store to list
   public static List<String> readFromFile() {
       List<String> fileList = new ArrayList<String>();
       BufferedReader reader;
       try {
           reader = new BufferedReader(new FileReader("test.txt"));
           String line = reader.readLine();
           while (line != null) {

               // read next line
               fileList.add(line);
               line = reader.readLine();
           }
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return fileList;
   }
// method to group images in txt file to map . in map, image as key and category as array of values
  
   public static Map<String, String[]> groupList(List<String> fileList) {
       Map<String, String[]> groupMap = new HashMap<String, String[]>();
       for (String str : fileList) {
           String[] words = str.split(" ");
           String[] keys = new String[words.length - 1];
           for (int i = 0; i < words.length - 1; i++) {
               keys[i] = words[i + 1];
               groupMap.put(words[0], keys);
           }
       }
       return groupMap;
   }

}