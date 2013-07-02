/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.*;
import java.util.*;

public class TextFileManager {
    
    private static Random rand = new Random();
    
    public static void SortFile(String fileName) {
        
        TreeSet<String> list = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        list.addAll(readFile(fileName));
        
        writeFile(fileName, list.toArray());
        
    }
    
    public static Collection<String> readFile(String fileName) {
        LinkedList<String> list = new LinkedList<String>();
        
        try {
            FileReader fstream = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fstream);
            String str = "";
            while ((str = in.readLine()) != null) {
                if (!list.contains(str)) {
                    list.add(str.trim());
                }
            }
            in.close();
            fstream.close();
        } catch (Exception ex) {
            System.out.println("error reading file");
        }
        
        return list;
    }
    
    public static void writeFile(String fileName, Object[] list) {
        try {
            FileWriter fstream = new FileWriter(fileName, false);
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (Object str : list) {
                out.write(str.toString());
                out.write(System.getProperty("line.separator"));
            }
            out.close();
            fstream.close();
        } catch (Exception ex) {
        }
    }
    
    public static void clearFile(String fileName) {
        try {
            FileWriter fstream = new FileWriter(fileName, false);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("");
            out.close();
            fstream.close();
        } catch (Exception ex) {
        }
        
    }
    
    public static void appendToFile(String fileName, String appendString) {
        try {
            FileWriter fstream = new FileWriter(fileName, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(appendString);
            out.write(System.getProperty("line.separator"));
            out.close();
            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static void sortedAppendToFile(String fileName, String appendString) {
        TreeSet<String> list = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        list.addAll(readFile(fileName));
        list.add(appendString);
        
        writeFile(fileName, list.toArray());
    }
    
    public static boolean contains(String fileName, String searchString) {
        for (String str : readFile(fileName)) {
            if (str.equals(searchString)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean containsIgnoreCase(String fileName, String searchString) {
        for (String str : readFile(fileName)) {
            if (str.equalsIgnoreCase(fileName)) {
                return true;
            }
        }
        return false;
    }
    
    public static void MakeFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception ex) {
        }
    }
    
    public static void MakeDirectory(String dirName) {
        File file = new File(dirName);
        file.mkdir();
    }
    
    public static void getLine(String fileName, int lineNum) {
    }

    /*
     public static String RandomLine(String fileName) {
     String result = null;
     try{

     Random rand = new Random();
     int n = 0;
     for (Scanner sc = new Scanner(new File(fileName)); sc.hasNext();) {
     ++n;
     String line = sc.nextLine();
     if (rand.nextInt(n) == 0) {
     result = line;
     }            
     }
        

     }catch(Exception ex){}
     return result;  
     }
     */
    public static String RandomLine(String fileName) {
        int i = 0;
        String str = "";
        int n=0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            
            while ((str = in.readLine()) != null) {
                i++;
            }
            in.close();
            
            if (i == 0) {
                return "";
            }
            
            in = new BufferedReader(new FileReader(fileName));
            
            n = rand.nextInt(i);
            for (int ii = -1; ii < n; ii++) {
                str = in.readLine();
            }
            
            in.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return str;
        //return String.valueOf(n);
    }
}
