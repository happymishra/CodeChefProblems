//Given an array containing positive and negative numbers. The array represents checkpoints from one end to other end of street. Positive and negative values represent amount of energy at that checkpoint. Positive numbers increase the energy and negative numbers decrease. Find the minimum initial energy required to cross the street such that Energy level never becomes 0 or less than 0.
//
//Note : The value of minimum initial energy required will be 1 even if we cross street successfully without loosing energy to less than and equal to 0 at any checkpoint. The 1 is required for initial check point.
//
//Examples:
//
//Input : arr[] = {4, -10, 4, 4, 4}
//Output: 7
//Suppose initially we have energy = 0, now at 1st
//checkpoint, we get 4. At 2nd checkpoint, energy gets
//reduced by -10 so we have 4 + (-10) = -6 but at any 
//checkpoint value of energy can not less than equals 
//to 0. So initial energy must be at least 7 because
//having 7 as initial energy value at 1st checkpoint
//our energy will be = 7+4 = 11 and then we can cross 
//2nd checkpoint successfully. Now after 2nd checkpoint,
//all checkpoint have positive value so we can cross 
//street successfully with 7 initial energy.
//
//Input : arr[] = {3, 5, 2, 6, 1}
//Output: 1
//We need at least 1 initial energy to reach first
//checkpoint
//
//Input : arr[] = {-1, -5, -9}
//Output: 16
public class MinEnergy {

    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {4, -10, 4,4,-10};
        
        int initialEnergy = minInitialEnergy(a);
        
        System.out.println(initialEnergy);
    }
    
    static int minInitialEnergy(int[] arrayOfEnergies)
    {
        int initialEnergy = 0, currentEnergy = arrayOfEnergies[0], length = arrayOfEnergies.length;
        boolean flag = false;
        
        for (int i = 1; i < length; i++)
        {
            currentEnergy += arrayOfEnergies[i];
            if(currentEnergy <= 0)
            {
                initialEnergy += (Math.abs(currentEnergy) + 1);
                currentEnergy = 1;
                flag = true;
            }
        }
        
        return flag ? initialEnergy : 1 ;
    }
    
}
