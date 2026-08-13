class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char current = board[row][col];
              if(current !='.'){
                if(set.contains(current)){
                    return false;
                }
                set.add(current);
              }
            }
            }
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char current = board[row][col];
              if(current !='.'){
                if(set.contains(current)){
                    return false;
                }
                set.add(current);
              }
            }
            }
           for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

        Set<Character> set = new HashSet<>();

        // Now traverse the 3×3 box
        for (int i = row; i < row+3; i++) {

            for (int j = col; j< col+3; j++) {

                char current = board[i][j];
if(current !='.'){
                if(set.contains(current)){
                    return false;
                }
                set.add(current);
              }
                
            }
        }
    }
}
     return true;   

    }
}