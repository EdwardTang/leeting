public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    int min(int a, int b) {
        if(a > b)
            return b;
        return a;
    }
    // Dynamic Programming:
    // 因为0后面只能跟0，所以如果出现了0，那么这个0后面所有的数都是0。
    // 所以变换后的数组是前面是一段1，后面是1段0。
    // 所以我们可以枚举分割的这一位，allOnes-currentOnes是将该位后面的所有1变成0，i-currentOnes+1是将前面的0变成1。最终的答案就是这里面的最小值
    public int flipDigit(int[] nums) {
        int allOnes = 0, currentOnes = 0, answer;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                allOnes ++;
            }      
        }
        answer = allOnes;
        for (int i = 0; i < nums. length; i++){
            if (nums[i] == 1){
                currentOnes ++;
            }
            
            answer = min(answer, (allOnes - currentOnes) + (i - currentOnes + 1));
        }
        return answer;
    }
}