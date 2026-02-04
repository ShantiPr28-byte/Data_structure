package DynamicProgramming;

public class thecursedhotelroom {
    public static void main(String[] args) {
        int l=1;
        int r=20;

        l=l-1;
        String s1=String.valueOf(l);
        String s2=String.valueOf(r);
        Integer dp1[][][]=new Integer[s1.length()][2][11];
        Integer dp2[][][]=new Integer[s2.length()][2][11];
        int ans=solve(s2,0,1,10,dp2)-solve(s1,0,1,10,dp1);
        System.out.println(ans);
    }
    public static int solve(String s,int idx,int tight,int n,Integer dp[][][]){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][n]!=null)return dp[idx][tight][n];
        int limit=(tight==1)?s.charAt(idx)-'0':9;

        int ans=0;
        for(int i=0;i<=limit;i++){
            int newtight=(tight==1 && i==limit)?1:0;
            if(i==4)continue;
            if(n==1 && i==7)continue;
            String temp=String.valueOf(i);
            ans=ans+solve(s,idx+1,newtight,i,dp);
        }
        return dp[idx][tight][n]=ans;
    }
}
