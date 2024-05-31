class Solution {
    private static void fun(int idx,int n,int[] arr,List<List<Integer>> ans,List<Integer> list)
    {
        if(idx==n)
        {
            ans.add(new ArrayList<>(list));
            // if(list.size()==0)
            // {
                
            // }
            return;
        }
        list.add(arr[idx]);
        fun(idx+1,n,arr,ans,list);
        list.remove(list.size()-1);
        fun(idx+1,n,arr,ans,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        fun(0,n,nums,ans,list);
        
        return ans;
        
    }
}