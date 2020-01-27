class ArrayRotatedAtK {
    public int search(int[] nums, int target) {
        int rotated = getCenter(nums, 0, nums.length-1);
        return Math.max(binarySearch(nums, 0, rotated-1, target), binarySearch(nums, rotated, nums.length-1, target));
    }

    public int getCenter(int[] nums, int start, int end){
        if(nums[start]>nums[start+1]){
            return start+1;
        }
        int mid = (start+end)/2;
        if(start>mid){
            end = mid;
        }else{
            start=mid;
        }
        return getCenter(nums, start, mid);

    }

    public int binarySearch(int[] nums, int start, int end, int target){
        if(start >= end){
            return -1;
        }
        else if(nums[start] == target){
            return start;
        }else if(nums[end] == target){
            return end;
        }

        int mid = (start+end)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return binarySearch(nums, mid, end, target);
        }else if(nums[mid] > target){
            return binarySearch(nums, start, mid, target);
        }
        throw new IllegalStateException("danger");
    }
}