class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstack=new Stack<>();
        Stack<String> stringstack=new Stack<>();
        StringBuilder current=new StringBuilder();
        int number=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                number=number*10+(ch-'0');
            }
            else if(ch=='['){
                numstack.push(number);
                stringstack.push(current.toString());
                number=0;
                current.setLength(0);
            }
            else if(ch==']'){
                int repeat=numstack.pop();
                String previous=stringstack.pop();
                StringBuilder temp=new StringBuilder(previous);
                for(int i=0;i<repeat;i++){
                    temp.append(current);
                }
                current=temp;
            }
            else{
                current.append(ch);
            }
        }
        return current.toString();
    }
}