// private static boolean valid(int row,int col,char[][] grid)
    // {
    //     int r=row;
    //     int c=col;
    //     while(row>=0 && col>=0)
    //     {
    //         if(grid[row][col]=='Q')
    //         {
    //             return false;
    //         }
    //         row--;
    //         col--;
    //     }
    //     row=r;
    //     col=c;
    //     while(col>=0)
    //     {
    //         if(grid[row][col]=='Q')
    //         {
    //             return false;
    //         }
    //         col--;
    //     }
    //     col=c;
    //     while(row<grid.length && col>=0)
    //     {
    //         if(grid[row][col]=='Q')
    //         {
    //             return false;
    //         }
    //         row++;
    //         col--;
    //     }
    //     return true;
    // }
    private static void solve(int col,int n,char[][] grid,List<List<String>> ans,boolean[] left,boolean[] uC,boolean[] bC)
    {
        if(col==n)
        {
            ans.add(construct(grid,n));
            return;
        }
        for(int row=0;row<n;row++)
        {
            if(left[row]==false && uC[n-1+col-row]==false && bC[row+col]==false)
            {
                left[row]=true;
                uC[(n-1)+(col-row)]=true;
                bC[row+col]=true;
                 
                grid[row][col]='Q';
                solve(col+1,n,grid,ans,left,uC,bC);
                grid[row][col]='.';
                left[row]=false;
                uC[n-1+col-row]=false;
                bC[row+col]=false;              
           }            
        }
    }
    private static List<String> construct(char[][] grid,int n)
    {
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String s=new String(grid[i]);
            list.add(s);
        }
        return list;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] grid=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]='.';
            }
        }
        boolean[] left=new boolean[n];
        boolean[] uC=new boolean[2*n-1];
        boolean[] bC=new boolean[2*n-1];
        
            solve(0,n,grid,ans,left,uC,bC);
         
        return ans;
    }
}