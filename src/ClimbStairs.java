/**
 * Created by zsy on 15/3/26.
 * DP动态规划初级
 */
public class ClimbStairs {
    public static int climbStairs_0(int n) {
        if(n<3){
            return n;
        }else{
            int s[]=new int[n+1];//每一个子步骤计算结果都保存
            s[1]=1;
            s[2]=2;
            for(int i=3;i<n+1;i++){
                s[i] = s[i-1]+s[i-2];
            }
            return s[n];
        }
//        if(n==0){
//            return 0;
//        }else if(n==1){
//            return 1;
//        }else{
//            return climbStairs(n-1)+climbStairs(n-2);
//        }
    }

    public static int climbStairs_1(int n){
        int map[] = new int[n + 1];//暂存1到n的结果值；
        return climbStairs(n , map);
    }

    public static int climbStairs(int n, int[] map){
        if(n <= 2){
            map[n] = n;
            return map[n];
        }
        if(map[n] == 0){//如果map[n]!=0,则直接返回, 在递归中所有值只要计算一遍，如果直接像上面方法那样递归，则。。。额。。，
            map[n] = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        }
        return map[n];
    }

    public static void main(String[] args){
       int res = climbStairs_0(44);

        System.out.println(res);

    }
}
