//Find minimum elements after considering all possible transformations
//Given an array of three colors. The array elements have a special property. Whenever two elements of different colors become adjacent to each other, they merge into an element of the third color. How many minimum number of elements can be there in array after considering all possible transformations.
//
//Example:
//
//Input : arr[] = {R, G}
//Output : 1
//G B -> {G B} R -> R
//
//Input : arr[] = {R, G, B}
//Output : 2
//Explanation : 
//R G B -> [R G] B ->  B B
//OR
//R G B -> R {G B} ->  R R 

public class MinColor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String colors[] = {"R", "R", "B", "B"};
        int minColors = minColor(colors);
        System.out.println("Min Colors: " + minColors);
        
    }
    
    static int minColor(String[] arrayOfColors)
    {
        int rCount = 0, bCount = 0, gCount = 0, minColor = 0, len = arrayOfColors.length;
        
        for(int i = 0; i < len; i++)
        {
            switch(arrayOfColors[i])
            {
                case "R":
                        rCount++;
                        break;
                case "G" :
                        gCount++;
                        break;
                case "B" :
                        bCount++;
            }                 
        }
        
        if(rCount == len || gCount == len || bCount == len)
        {
            minColor = len;
        }
        else if(rCount % 2 == 0 && gCount % 2 == 0 && bCount % 2 == 0)
        {
            minColor = 2;
        }
        else if (rCount % 2 == 1 && gCount % 2 == 1 && bCount % 2 == 1)
        {
            minColor = 2;
        }
        else 
        {
            minColor = 1;
        }
          return minColor; 
    }
    
}
