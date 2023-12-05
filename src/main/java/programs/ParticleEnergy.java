package programs;

public class ParticleEnergy {
    public static int findMaxBarrier(int[] initialEnergy, int threshold) {
        int maxEnergy = Integer.MIN_VALUE;
        for (int energy : initialEnergy) {
            maxEnergy = Math.max(maxEnergy, energy);
        }
        
        int left = 0;
        int right = maxEnergy;
        int maxBarrier = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            //final energy 
            for (int energy : initialEnergy) {
                sum += Math.max(energy - mid, 0);
            }
            
            if (sum >= threshold) {
                maxBarrier = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return maxBarrier;
    }
    
    public static void main(String[] args) {
        int[] initialEnergy = {5, 2, 13, 10};
        int threshold = 8;
        int maxBarrier = findMaxBarrier(initialEnergy, threshold);
        System.out.println("Maximum possible barrier value: " + maxBarrier);
    }
}
