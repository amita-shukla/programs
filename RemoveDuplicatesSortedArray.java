/**
Given a sorted array, remove the duplicates in place such that each element appear only once 
and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
**/

public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int duplicateIndex = -1;
        int prvs = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if(prvs==current && duplicateIndex==-1){
                duplicateIndex=i;
            }
            if(prvs!=current && duplicateIndex!=-1){
                nums[duplicateIndex]=current;
                duplicateIndex++;

            }
            if(duplicateIndex==-1){
                prvs=current;
            }else{
                prvs=nums[duplicateIndex-1];
            }
        }
        return duplicateIndex==-1?nums.length:duplicateIndex;
    }