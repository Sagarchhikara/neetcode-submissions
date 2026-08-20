class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        String[] parts=path.split("/");
        for(String part:parts){
            if(part.equals("")||part.equals(".")){
                continue;
            }
            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(part);
            }
        }
        StringBuilder ans=new StringBuilder();
         for (String dir : stack) {
            ans.append("/");
            ans.append(dir);
        }

        if (ans.length() == 0) {
            return "/";
        }

        return ans.toString();
    }
}