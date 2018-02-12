/*
 Link to the problem: http://www.lintcode.com/en/problem/combination-sum
*/
public class Solution {
    /*
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(candidates.length == 0)
        {
            return results;
        }
        
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, 0, subset, target, results);
        return results;
    }
    
    // Recursion: Among candidates, find all subsets whose sum is remain target,
    // and add the subsets to results
    public void dfs(int[] candidates,
                    int startIndex, 
                    List<Integer> subset, 
                    int remainTarget, 
                    List<List<Integer>> results){
        // Exit of recursion
        if(remainTarget == 0)
        {
            results.add(new ArrayList<>(subset));
            return;
        }
        
        // When there are duplicates in the candidates, solution 1:
        // if(startIndex > 0 && candidates[startIndex] == candidates[startIndex-1])
        // {
        //     startIndex++;
        // }        


        
        // subroutine of recursion
        for(int i = startIndex; i < candidates.length;i++)
        {
            // When there are duplicates in the candidates, solution 2:
            if(i != 0 && candidates[i] == candidates[i-1])
            {
                continue;
            }  
            if (remainTarget < candidates[i])
            {
                break;
            }
            subset.add(candidates[i]);
            dfs(candidates, i, subset, remainTarget - candidates[i], results);
            // Back tracking when reaching to leave nodes but didn't find the result.
            // 为什么要remove:
            //    1. 如果不remove 不正确的 subset, 比如 [2,2,2], 那么subset没法回到 [2,2].
            //       也就没法得到另一个叶节点[2,2,3]
            //    2. 就算是到达正确的叶节点了，也要往回走，去找其他的正确答案。
            subset.remove(subset.size() - 1);
        }
        
    }
}