import java.util.*;  //Scanner, Arrays, StringTokenizer, Random
public class JBGW08_014_Tictactoe{
  public static char[][] board= new char[3][3];

  public static void printBoard(char[][] board){     //보드 작성
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            if(j!=board[i].length-1){
               System.out.print(" "+board[i][j]+" |");
            }
            else{
               System.out.print(" "+board[i][j]+" ");
            }
            
      }if(i!=board.length-1){
        System.out.println("\n-----------");
      }else{
        System.out.println();
      }
    }
  }

  public static boolean isAvailable(int x, int y){    //좌표 검증
    if(board[x][y]!=' '){   //예외처리 추가하기
      return false;
    }return true;
  }
  public static int isMax(){    //보드가 다 찼을 경우
    int isMax=1;
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[i].length;j++){
        if(board[i][j]==' '){
          isMax=0;
        }
      }  
    }
    return isMax;
  }
  public static void draw(User user,int x,int y)throws Exception{   //오버로딩
    if(!isAvailable(x,y)){
      throw new Exception();
    }
    else{
      user.setXY(x,y);
      board[x][y] = 'o';
    }
  }

  public static void draw(Computer computer,int x,int y){  //오버로딩
    
    while(true){
      x = new Random().nextInt(3);
      y = new Random().nextInt(3);

      if(isAvailable(x,y)){
        computer.setXY(x,y);
        board[x][y] = 'x';
        break;
      }
    }
  }
  public static boolean whoisWinner(){  
    for(int i=0;i<board.length;i++){
      if(board[i][0]==board[i][1] && board[i][1]==board[i][2]&&board[i][0]==board[i][2]&&board[i][0]!=' '){    //가로
        return true;
      }
      if(board[0][i]==board[1][i]&& board[1][i]==board[2][i]&&board[0][i]==board[2][i]&&board[0][i]!=' '){    //세로
        return true;
      }
    }
    if(board[0][0]==board[1][1]&&board[1][1]==board[2][2] && board[0][0]==board[2][2]&&board[1][1]!=' '){   //대각선1
      return true;
    }
    if(board[0][2]==board[1][1]&& board[1][1]==board[2][0] && board[0][2]==board[2][0]&&board[1][1]!=' '){  //대각선2
      return true;
    }
    return false;
  }
  
  
  public static void main(String []args) throws Exception{
    for (char[] i : board) Arrays.fill(i, ' ');
    while(true){ //게임 실행
      try{
        System.out.print("Press your x,y(Enter Exit to exit): ");
        Scanner sc = new Scanner(System.in);
        String xy = sc.nextLine();

        if(xy.equals("Exit")){        //게임 종료
          System.out.println("game quit");
          break;
        }

        StringTokenizer str = new StringTokenizer(xy);
        int x = Integer.parseInt(str.nextToken());    
        int y = Integer.parseInt(str.nextToken());
        
        draw(new User(),x,y);
        printBoard(board);
        if(whoisWinner()){
          System.out.println("You win!");
          break;
        }
        System.out.println();

        if(isMax()==1){
          System.out.println("No winner");
          break;
        }
        draw(new Computer(),x,y);
        printBoard(board);
        if(whoisWinner()){
          System.out.println("Computer win!");
          break;
        }
      }
      catch(Exception e){
        System.out.println("error! 다시 입력하세요");
      }
      
    }
  }
}

class User{ 
  private int x;
  private int y;

  User(){};
  public void setXY(int x, int y){
    this.x = x;
    this.y = y;
  }
}

class Computer{
  private int x;
  private int y;
  Computer(){};
  public void setXY(int x, int y){
    this.x = x;
    this.y = y;
  }

}
