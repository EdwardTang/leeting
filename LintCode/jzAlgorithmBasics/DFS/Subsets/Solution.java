
/*
Link to the problem: http://www.lintcode.com/en/problem/subsets/
*/
public class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
       
        if (nums == null) {
            return results;
        }
       
        if (nums.length == 0)
        {
            results.add(new ArrayList<>());
            return results;
        }
        
        // How to sort arrays with api:
        //  https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }
    
    // Find all the distinct subsets and return it
    public void dfs(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results)
    {

        if(subset.size() <= nums.length)
        {
            results.add(new ArrayList<>(subset));
        }
        // Exit of recursion
        // if(startIndex == nums.length)
        // {
        //     return;
        // } 
        // equal to  for (int i = startIndex; i < nums.length; i++)

        //  The breakdown of recursion
        for (int i = startIndex; i < nums.length; i++)
        {
            subset.add(nums[i]);
            dfs(nums, i+1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}