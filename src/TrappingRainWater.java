public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3){
            return 0;
        }
        int leftHeight = height[0];
        int rightHeight = height[height.length - 1];
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left+1) {
            if (rightHeight > leftHeight) {
                int current = height[++left];
                if (current <= leftHeight) {
                    total += leftHeight - current;
                } else {
                    leftHeight = current;
                }
            }else{
                int current = height[--right];
                if (current <= rightHeight) {
                    total += rightHeight - current;
                } else {
                    rightHeight = current;
                }
            }
        }
        return total;
    }

}
