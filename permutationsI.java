class Solution {
    private static void fun(int n,int[] arr,boolean[] map,List<List<Integer>> ans,List<Integer> list)
    {
        if(list.size()==n)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(!map[i])
            {
                map[i]=true;
                list.add(arr[i]);
                fun(n,arr,map,ans,list);
                list.remove(list.size()-1);
                map[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] map=new boolean[n];
        fun(n,nums,map,ans,list);
        return ans;
        
    }
}