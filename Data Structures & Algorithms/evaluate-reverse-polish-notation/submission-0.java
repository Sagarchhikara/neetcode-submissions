class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String op:tokens){
        if (!op.equals("+") && !op.equals("-") &&
        !op.equals("*") && !op.equals("/")) {

        st.push(Integer.parseInt(op));

    }
      else{
        if(op.equals("+")) {
    int a = st.pop();
    int b = st.pop();
    st.push(a + b);
}
else if(op.equals("-")) {
    int a = st.pop();
    int b = st.pop();
    st.push(b - a);
}
else if(op.equals("*")) {
    int a = st.pop();
    int b = st.pop();
    st.push(a * b);
}
else if(op.equals("/")) {
    int a = st.pop();
    int b = st.pop();
    st.push(b / a);
}
      }
        } 
      return st.pop();
    }
}
