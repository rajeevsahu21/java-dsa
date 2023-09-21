class Backtracking {
    static void changeArr(int[] arr, int i, int val) {
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1); // fnc call step
        arr[i] = arr[i] - 2; // backtracking step
    }

    static void findSubsets(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        findSubsets(str, ans + str.charAt(i), i + 1);
        findSubsets(str, ans, i + 1);
    }

    static void findPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newString, ans + curr);
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    static void nQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printBoard(char[][] board) {
        System.out.println("-----chess board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        findSubsets("abc", "", 0);
        findPermutation("abc", "");
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
    }
}