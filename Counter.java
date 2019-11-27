/*
* Counter.java
* Created by Nathan Newcomer
* Date: 10/26/2019
* Counts how many unique words are in a text file and
* sorts them by count in decreasing order.
* Inspired by https://youtu.be/fCn8zs912OE.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class MapComparator implements Comparator<Map.Entry<String, Integer>> {
  
    @Override
    public int compare(Map.Entry<String, Integer> first, Map.Entry<String, Integer> second) {
       return (second.getValue() - first.getValue());
    }
}

public class Counter {

    public static void main(String[] args) throws IOException {

        String filename = "beowulf";
        int totalWords = 0;

        // Read the file
        File file = new File(filename);
        Map<String, Integer> list = new TreeMap<String, Integer>();
  
        // Read each line
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            // Split lines by non characters
            String[] words = currentLine.split("('s)|[^A-Za-zÀ-ÿ]+");
            // Add word to list if it's not there
            for (String word : words) {
                String lWord = word.toLowerCase();
                if (!list.containsKey(lWord)) {
                    if (lWord.length() > 0) {
                        list.put(lWord, 1);
                        totalWords++;
                    }
                // Increment number of words
                } else {
                    totalWords++;
                    list.replace(lWord, list.get(lWord) + 1);
                }
            }
        }
        reader.close();

        // Put the map into a TreeSet to sort it by value
        MapComparator mapComp = new MapComparator();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(list.entrySet());
        sortedList.sort(mapComp);

        // Create the file to write to
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename + "results"));

        // Print total number of words & unique words
        writer.write("Total # of words = " + totalWords);
        writer.newLine();
        writer.write("Total # of unique words = " + sortedList.size());
        writer.newLine();

        // Print results to file
        for (Map.Entry<String, Integer> word: sortedList) {
            writer.write(word.toString());
            writer.newLine();
        }

        writer.close();

    }

}