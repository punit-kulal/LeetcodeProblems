public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int negativeCount = 0;
        for(int element: nums){
            if(element<1){
                negativeCount++;
            }
        }
        int positiveCount = nums.length-negativeCount;
        int temp;
        for(int i=0; i< nums.length; i++){
            while(nums[i] > 0 && nums[i] <= positiveCount && nums[nums[i]-1] != nums[i]){
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=1; i <= positiveCount; i++){
            if(nums[i-1]!=i){
                return i;
            }
        }
        return positiveCount+1;
    }
}
