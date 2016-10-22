package linear;

public class TrappingRainWater {
	
	public static int trap(int[] height) {
		int left = 0;
        int right = left + 1;
        int sum = 0;
        int potentialHold = 0;
        while (right < height.length) {
            
            if (height[right] < height[left]) {
                potentialHold += height[left] - height[right];
            }
            else {
                sum += potentialHold;
                left = right;
            }
            right += 1;
        }
        return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(TrappingRainWater.trap(new int[] {4,2,3}));
	}

}
