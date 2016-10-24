package linear;

public class TrappingRainWater {
	
	public static int trap(int[] height) {
		if (height == null || height.length == 0 || 
				height.length == 1 || height.length == 2) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int leftWall = height[l];
        int rightWall = height[r];
        int trapped = 0;
        
        while (l < r) {
            
            if (leftWall < rightWall) {
                l ++;
                if (height[l] < leftWall) 
                    trapped += leftWall - height[l];
                else
                    leftWall = height[l];
            }
            else {
                r --;
                if (height[r] < rightWall)
                    trapped += rightWall - height[r];
                else 
                    rightWall = height[r];
            }
        }
        return trapped;
	}
	
	public static void main(String[] args) {
		System.out.println(TrappingRainWater.trap(new int[] {}));
	}

}
