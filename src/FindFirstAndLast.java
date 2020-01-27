public class FindFirstAndLast {

    public static void main(String[] args){
        searchRange(new int[0], 8);
    }

    public static int[] searchRange(int[] nums, int target) {
        nums = new int[]{5,7,7,8,8,10};
        int[] answer = new int[2];
        answer[0] =-1;
        answer[1] =-1;

        int left = 0, right = nums.length-1, mid =  (left+right)/2;
        while(nums[left]!=target && right > left){
            if(nums[left]< target && nums[mid]>=target){
                if (right == mid)
                    break;
                right = mid;
            }else{
                if (left == mid){
                    left = mid+1;
                }else {
                    left = mid;
                }
            }
            mid =  (left+right)/2;
        }
        if(nums[left]==target){
            answer[0] = left;
        }else{
            return answer;
        }

        left = 0;
        right = nums.length-1;
        mid =  (left+right)/2;
        while(nums[right]!=target && right > left){
            if(nums[mid] <= target && nums[right]>target){
                if (left == mid){
                    right = mid;
                }else {
                    left = mid;
                }
            }else{
                right = mid;
            }
            mid =  (left+right)/2;
        }

        answer[1] = right;

        return answer;

    }
}
