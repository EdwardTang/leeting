// Link to problem: http://www.lintcode.com/en/problem/subsets-ii/
public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null)
        {
            return results;
        }
        
        if (nums.length == 0)
        {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        dfsTraverse(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    public void dfsTraverse(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results)
    {
        if(subset.size() <= nums.length)
        {
            results.add(new ArrayList<>(subset));
        }
        
        for (int i = startIndex; i < nums.length; i++)
        {
            //为什么会有重复：
            //                                                                                   [       ]
            //                                                                                 //        \\
            //                                                                               [1]          [2]
            //                                                                              //           //
            //   从叶节点[1,2,2] 回溯到[1,2]这一步时，for loop 中 i= startIndex+1， ->      [1,2]         [2, 2]
            //   就会再取一次重复的 nums[ startIndex + 1] = 2                              //                                                                   //
            //                                                                       [1, 2, 2]
            if(i != startIndex && nums[i - 1] == nums[i])
            {
               continue;
            }
            subset.add(nums[i]);
            dfsTraverse(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}