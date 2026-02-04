package DynamicProgramming;

public class editdistance {
    public static void main(String[] args) {
        String words1="LOVE";
        String words2="MOVIE";
        Integer dp[][]=new Integer[words1.length()][words2.length()];
        System.out.println(solve(0,0,words1,words2,dp));
    }
    public static int solve(int i, int j, String w1, String w2, Integer[][] dp) {
        if (i ==w1.length()) return w2.length()-j ;
        if (j ==w2.length()) return w1.length()-i ;

        if (dp[i][j] != null) return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, w1, w2, dp);
        }

        int insert = solve(i, j + 1, w1, w2, dp);
        int delete = solve(i + 1, j, w1, w2, dp);
        int replace = solve(i + 1, j + 1, w1, w2, dp);

        return dp[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
    }
}
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class editdistance {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String w1 = br.readLine();
//        String w2 = br.readLine();
//
//        int n = w1.length();
//        int m = w2.length();
//
//        int[][] dp = new int[n + 1][m + 1];
//
//        // base cases
//        for (int i = 0; i <= n; i++) dp[i][0] = i;
//        for (int j = 0; j <= m; j++) dp[0][j] = j;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = 1 + Math.min(
//                            dp[i - 1][j - 1],      // replace
//                            Math.min(dp[i - 1][j], // delete
//                                    dp[i][j - 1]) // insert
//                    );
//                }
//            }
//        }
//
//        System.out.println(dp[n][m]);
//    }
//}
//
