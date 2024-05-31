class Solution {
    private static void fun(int idx,int n,int[] arr,Set<List<Integer>> ans,List<Integer> list)
    {
        if(idx==n)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        fun(idx+1,n,arr,ans,list);
        list.remove(list.size()-1);
        fun(idx+1,n,arr,ans,list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        fun(0,n,nums,ans,list);
        List<List<Integer>> res=new ArrayList<>(ans);
        return res;      
    }
}