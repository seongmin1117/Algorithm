import java.util.*;

public class Main {
    static int n,m,k;
    static int[][] A,board;

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    static Deque<Tree> treeList = new LinkedList<>();
    static Queue<Tree> f = new LinkedList<>();

    static Queue<Tree> die = new LinkedList<>();


    static class Tree{
        int x,y,age;
        public Tree (int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static void ss(){
        //봄
        for (int i=0; i<treeList.size(); i++){
            Tree tree = treeList.poll();
            if (board[tree.x][tree.y]<tree.age) {
                die.add(tree);
                i--;
                continue;
            }
            board[tree.x][tree.y] -= tree.age;
            tree.age++;
            treeList.add(tree);
            if (tree.age % 5 ==0) f.add(tree);
        }
        //여름
        while (!die.isEmpty()){
            Tree tree = die.poll();
            int food = tree.age/2;
            board[tree.x][tree.y] += food;
        }
    }
    static void fw(){
        //가을
        while (!f.isEmpty()){
            Tree tree = f.poll();
            for (int d=0; d<8; d++){
                int nx = tree.x + dx[d];
                int ny = tree.y + dy[d];
                if (nx<0||ny<0||nx>=n||ny>=n) continue;
                treeList.addFirst(new Tree(nx,ny,1));
            }
        }
        //겨울
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] += A[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        A = new int[n][n];
        board = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                A[i][j] = sc.nextInt();
                board[i][j] =5;
            }
        }
        for (int i=0; i<m; i++){
            int x = sc.nextInt() -1;
            int y = sc.nextInt() -1;
            int age = sc.nextInt();
            treeList.add(new Tree(x,y,age));
        }

        for (int i=0; i<k; i++){
            ss();
            fw();
        }
        System.out.println(treeList.size());
    }
}
