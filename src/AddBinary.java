import java.util.Stack;

/**
 * Created by zsy on 15/3/25.
 */
public class AddBinary {
    public static String addBinary(String a,String b){//278ms
        int la=a.length();
        int lb=b.length();
        int ll=la>lb?la:lb;
        int carry=0;
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<ll;i++){
            char at,bt;
            try{
                at = a.charAt(la-i-1);
            }catch (Exception e){
                at = '0';
            }
            try {
                bt = b.charAt(lb - i - 1);
            }catch (Exception e){
                bt = '0';
            }
            int atNum=Character.getNumericValue(at);
            int btNum=Character.getNumericValue(bt);
            if(atNum+btNum+carry==0){
                stack.push('0');
                carry=0;
            }else if(atNum+btNum+carry==1){
                stack.push('1');
                carry=0;
            }else if(atNum+btNum+carry==2){
                carry=1;
                stack.push('0');
            }else if(atNum+btNum+carry==3){
                carry=1;
                stack.push('1');
            }
        }
        if(carry==1){
            stack.push('1');
        }
        String result="";
        int len=stack.size();
        for (int i = 0; i < len; i++) {
            result += stack.pop();
        }
        return result;
    }

    public static String addBinary2(String a,String b){//247ms
        int la=a.length();
        int lb=b.length();
        int ll=la>lb?la:lb;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ll;i++){
            char at,bt;
            if(la-i-1>=0){
                at = a.charAt(la-i-1);
            }else{
                at = '0';
            }
            if(lb-i-1>=0){
                bt = b.charAt(lb - i - 1);
            }else{
                bt = '0';
            }
            int atNum=Character.getNumericValue(at);
            int btNum=Character.getNumericValue(bt);
            char t=Integer.toString((atNum+btNum+carry)%2).charAt(0);
            carry=(atNum+btNum+carry)/2;
            sb.insert(0,t);
        }
        if(carry==1){
            sb.insert(0, '1');
        }

        return sb.toString();
    }


    public static void main(String[] args){
        String res=addBinary2("11", "1");
        System.out.println(res);
    }
}
