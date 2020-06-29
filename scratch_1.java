import java.util.LinkedList;
import java.util.Queue;

class Node{
    int start;
    int end;
    int count;
    public Node(int start,int end, int count){
        this.start = start;
        this.end = end;
        this.count = count;
    }
}

class Scratch {
    public static void main(String[] args) {
        System.out.print(solution(3,3));
    }

    public static int solution(int m, int n) {
        // write code here
        if(m<0||m>9||n<1||n>9){
            return 0;
        }
        int[] one = {2,4,5,6,8};
        int[] two = {1,3,4,5,6,7,9};
        int[] three = one;
        int[] four = {1,2,3,5,7,8,9};
        int[] five = {1,2,3,4,6,7,8,9};
        int[] six = four;
        int[] seven = one;
        int[] eight = two;
        int[] nine = one;
        int[][] board = new int[10][];
        board[1] = one;
        board[2] = two;
        board[3] = three;
        board[4] = four;
        board[5] = five;
        board[6] = six;
        board[7] = seven;
        board[8] = eight;
        board[9] = nine;
        int result =0;
        for(int i =m;i<=n;i++){
            //result += calculatePoss(i,board);
        }
        //return result;
        return calculatePoss(3,board);
    }

    public static int calculatePoss(int n,int[][] board){
        int result = 0;
        if(n ==1){
            return 9;
        }
        Queue<Node> queue = new LinkedList<Node>();
        for(int i = 1; i<10;i++){
            int[][] visited = new int[10][10];
            int[] togo = board[i];
            if(i ==3 ){
                var test = 1;
            }
            for(int j = 0;j <togo.length;j++){
                if(visited[i][togo[j]]!=1&&visited[togo[j]][i]!=1){
                    queue.offer(new Node(i,togo[j],1));
                    visited[i][togo[j]] = 1;
                    visited[togo[j]][i]=1;
                }
            }

            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.count== n-1){
                    result++;
                    continue;
                }

                node.start = node.end;
                togo = board[node.start];
                for(int j = 0;j <togo.length;j++){
                    if(visited[node.start][togo[j]]!=1&&visited[togo[j]][node.start]!=1){
                        int count = node.count+1;
                        node.end = togo[j];
                        queue.offer(new Node(node.start,node.end,count));
                    }
                }

            }

        }
        return result;
    }


}