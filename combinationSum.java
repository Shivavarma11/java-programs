class Solution {
    private static void fun(int idx,int tar,int[] arr,List<List<Integer>> ans,List<Integer> list,int n)
    {
        if(idx==n || tar<0)
        {
            if(tar==0)
            {
                ans.add(new ArrayList<>(list));
            }
            return ;
        }
        list.add(arr[idx]);
        fun(idx,tar-arr[idx],arr,ans,list,n);
        list.remove(list.size()-1);
        fun(idx+1,tar,arr,ans,list,n);

    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int n=arr.length;
        fun(0,target,arr,ans,list,n);
        return ans;
        
    }
}