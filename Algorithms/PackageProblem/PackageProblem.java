/*
 Code Eval: https://www.codeeval.com/public_sc/114/
 
You want to send your friend a package with different things.
Each thing you put inside the package has such parameters as index number, weight and cost.
The package has a weight limit.
Your goal is to determine which things to put into the package so that the total weight is less 
than or equal to the package limit and the total cost is as large as possible.

You would prefer to send a package which weights less in case there is more than one package with the 
same price.

INPUT SAMPLE:

    Your program should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case.

    Each line contains the weight that the package can take (before the colon) and the list of things you need to choose. Each thing is enclosed in parentheses where the 1st number is a thing's index number, the 2nd is its weight and the 3rd is its cost. E.g.

    81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48) 
    8  : (1,15.3,$34) 
    75 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) 
         (8,93.18,$35) (9,89.95,$78) 56 : (1,90.72,$13) (2,33.80,$40) (3,43.15,$10) (4,37.97,$16) (5,46.81,$36) 
         (6,48.77,$79) (7,81.80,$45) (8,19.36,$79) (9,6.76,$64)

OUTPUT SAMPLE:

    For each set of things that you put into the package provide a list (items’ index numbers are separated by comma). E.g.

    4 - 2,7 8,9
CONSTRAINTS:
    Max weight that a package can take is ≤ 100
    There might be up to 15 items you need to choose from
    Max weight and cost of an item is ≤ 100
 */

import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class PackageProblem 
{

    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path");
        String filePath = sc.nextLine();
        try 
        {
            processFileData(filePath);
        } 
        catch (ArrayIndexOutOfBoundsException ex) 
        {
            System.out.println("An error occured " + ex.toString());
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File not found. Please enter a valid path. " + ex.toString());
        } 
        catch (IOException ex) 
        {
            System.out.println("An error occured. " + ex.toString());
        }
        catch(Exception ex)
        {
            System.out.println("An error occured. " + ex.toString());
        }
    }

    //Read and process the specified file data
    private static void processFileData(String filePath) throws IOException 
    {
        ArrayList<PackageElements> elementsArray;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line = br.readLine();
            while (line != null) 
            {
                elementsArray = new ArrayList();
                int pkgWeightLimit = Integer.parseInt(line.split(":")[0].trim());
                elementsArray = getElementsArray(line.split(":")[1], elementsArray);
                int optimalCostArray[][] = getOptimalCostArray(pkgWeightLimit, elementsArray);
                displayOptimalElements(optimalCostArray, elementsArray, pkgWeightLimit);
                line = br.readLine();
            }
        }
    }

    //Get the optimal solution array
    private static int[][] getOptimalCostArray(int pkgWeightLimit, ArrayList<PackageElements> itemsArray) 
    {
        int[][] optimalCostArray = new int[itemsArray.size() + 1][pkgWeightLimit + 1];
        for (int j = 0; j <= pkgWeightLimit; j++) 
        {
            optimalCostArray[0][j] = 0;
        }
        for (int i = 1; i <= itemsArray.size(); i++) 
        {
            PackageElements currentItem = itemsArray.get(i - 1);
            for (int x = 0; x <= pkgWeightLimit; x++) 
            {
                int firstItem = optimalCostArray[i - 1][x];
                int secondItem = 0;
                if (x - currentItem.getWeight() >= 0 && x - currentItem.getWeight() <= pkgWeightLimit) 
                {
                    secondItem = optimalCostArray[i - 1][x - (int) currentItem.getWeight()] + currentItem.getCost();
                }
                optimalCostArray[i][x] = Math.max(firstItem, secondItem);
            }
        }
        return optimalCostArray;
    }
    
    //Returns an arraylist of package elements
    private static ArrayList<PackageElements> getElementsArray(String pkgElements, ArrayList<PackageElements> itemsArray) 
    {
        //Get the content within the brackets
        Matcher m = Pattern.compile("\\(([^\\)]+)\\)").matcher(pkgElements);
        while (m.find()) 
        {
            String elementComponents[] = m.group(1).split(",");
            PackageElements packageElements = new PackageElements(Integer.parseInt(elementComponents[0].trim()), Double.parseDouble(elementComponents[1].trim()), Integer.parseInt(elementComponents[2].substring(1).trim()));
            itemsArray.add(packageElements);
        }
        return itemsArray;
    }

    //Displays the index of elements which are part of optimal solution
    private static void displayOptimalElements(int optimalCostArray[][], ArrayList<PackageElements> itemsArray, int remainingWeight) 
    {
        String indexes = "";
        int noOfElements = itemsArray.size();
        while (noOfElements > 0) 
        {
            PackageElements p = itemsArray.get(noOfElements - 1);
            
            if ((remainingWeight - (int) p.getWeight() > 0) && optimalCostArray[noOfElements][remainingWeight] - optimalCostArray[noOfElements - 1][remainingWeight - (int) p.getWeight()] == p.getCost()) 
            {
                indexes = indexes + "," + noOfElements;
                noOfElements = noOfElements - 1;
                remainingWeight = remainingWeight - (int) p.getWeight();
            } 
            else 
            {
                noOfElements = noOfElements - 1;
            }
        }
        //If none of the elemetns are there in the package display "-"
        if (indexes.isEmpty()) 
        {
            System.out.println("-");
        } 
        else 
        {
            System.out.println(indexes.substring(1));
        }
    }
}
