import java.util.HashSet;

public class longestsubstring {

    static public  int longestSubstring(String s ){
        int start = 0  ; // 开始
        int end = 0 ;  // 结束
        int maxLength = 1;

        // 用set储存unique char
        HashSet<Character>  charSet = new HashSet<>();
        if(s.isEmpty()){
            return 0 ;
        }

        while(end < s.length()){
            Character currentChar = s.charAt(end);

            // 如果不包含， end ++， 把unique char 存进set
            if(!charSet.contains(currentChar)){
                charSet.add(currentChar);
                end++;
                int size = charSet.size();
                if(size >= maxLength){
                    maxLength = size;
                }
            }else{
                charSet.remove(s.charAt(start));    //如果char已经在于 set ，left处的字符从 set 中移除，left ++, 直到重读的被remove
                start++;
            }
        }

        return maxLength;
    }


    public static void main(String[] args){
        String s0 = "";
        int length0 = longestSubstring(s0);
        System.out.println(length0);

        String s1 = "abcabcbb";
        int length1 = longestSubstring(s1);
        System.out.println(length1);

        String s2= "bbbbb";
        int length2 = longestSubstring(s2);
        System.out.println(length2);

        String s3 = "pwwkew";
        int length3 = longestSubstring(s3);
        System.out.println(length3);

    }
}
