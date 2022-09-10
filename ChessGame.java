import java.util.*;
class Game {
    String A,B;
    String board[][];
    Scanner in;
    Map<String,ArrayList<Integer>>posA;
    Map<String,ArrayList<Integer>>posB;
    Game(String A,String B)
    {
        this.A=A;
        this.B=B;
        board = new String[5][5];
        posA = new HashMap<>();
        posB = new HashMap<>();
        for(String []val:board)
        {
            Arrays.fill(val,"-");
        }
    }
    public void getAPawn()
    {
        in = new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            board[4][i] ="A"+"-"+in.next();
        
        }
        for(int i=0;i<5;i++)
        {
            ArrayList<Integer>coordinates = new ArrayList<>();
            coordinates.add(4);
            coordinates.add(i);
            posA.put(board[4][i],coordinates);
        }

    }
    public void getBPawn()
    {
        in = new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            board[0][i] ="B"+"-"+in.next();
        
        }
        for(int i=0;i<5;i++)
        {
            ArrayList<Integer>coordinates = new ArrayList<>();
            coordinates.add(0);
            coordinates.add(i);
            posB.put(board[0][i],coordinates);
        }
    
    }
    public boolean MoveA(String playerMove)
    {
        int indexColon = playerMove.indexOf(':');
        String entry = playerMove.substring(0,indexColon);
        char hero = entry.charAt(0);
            
        if(hero=='p'||hero=='P')
        {
            return MovePawnA(playerMove);
        }
        else if(hero=='E'||hero=='e')
        {
            return MoveElephantA(playerMove);
        }
        else if(hero=='K'||hero=='k')
        {
            return true;
        }
        return false;
    }
    public boolean MoveB(String playerMove)
    {
        int indexColon = playerMove.indexOf(':');
        String entry = playerMove.substring(0,indexColon);
        char hero = entry.charAt(0);
        System.out.println(hero);
        if(hero=='p'||hero=='P')
        {
            return MovePawnB(playerMove);
        }
        else if(hero=='E'||hero=='e')
        {
            return MoveElephantB(playerMove);
        }
        else if(hero=='K'||hero=='k')
        {
            return true;
        }
        return false;
    }
    public boolean MovePawnA(String playerMove)
    {
        int indexColon = playerMove.indexOf(':');
        String entry = playerMove.substring(0,indexColon);
        entry = "A-"+entry;
        char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
        System.out.println("Move "+move+" Entry "+entry);
        if(!posA.containsKey(entry))
        {
            System.out.println("Invalid Pawn Selected!!\n Try Again");
            return false;
        }
        ArrayList<Integer> coordinates = posA.get(entry);
        int x =coordinates.get(0);
        int y=coordinates.get(1);
        int updateX =x;
        int updateY=y;
        if(move=='F')
        {
            updateX--;
        }
        else if(move=='B')
        {
            updateX++;
        }
        else if(move=='L')
        {
            updateY--;
        }
        else if(move=='R')
        {
            updateY++;
        }
        else
        {
            System.out.println("Invalid Move1!!\nPlease Enter Again:");
            return false;
        }
        if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
        {
            System.out.println("Innvalid Move2!!\nPlease Enter Again:");
            return false;
        }
        
        String currPos = board[x][y];
        String updatePos = board[updateX][updateY];
        if(updatePos.charAt(0)=='A')
        {
            System.out.println("Invalid Move3!!\nPlease Enter Again:");
            return false;
        }
        if(updatePos.equals("-"))
        {
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posA.put(entry,coordinates);
            // return true;
        }
        else if(updatePos.charAt(0)=='A')
        {
            posA.remove(updatePos);
            System.out.println(board[updateX][updateY]+" got attacked!!");
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posA.put(entry,coordinates);
            // return true;
        }
        return true;
    }

    public boolean MovePawnB(String playerMove)
    { 
        int indexColon = playerMove.indexOf(':');
        String entry = playerMove.substring(0,indexColon);
        entry = "B-"+entry;
        char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
        // System.out.println(move);
        if(!posB.containsKey(entry))
        {
            System.out.println("Invalid Pawn Selected!!\n Try Again");
            return false;
        }
        ArrayList<Integer> coordinates = posB.get(entry);
        int x =coordinates.get(0);
        int y=coordinates.get(1);
        int updateX =x;
        int updateY=y;
        if(move=='F')
        {
            updateX++;
        }
        else if(move=='B')
        {
            updateX--;
        }
        else if(move=='L')
        {
            updateY--;
        }
        else if(move=='R')
        {
            updateY++;
        }
        else
        {
            System.out.println("Invalid Move1!!\nPlease Enter Again:");
            return false;
        }
        if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
        {
            System.out.println("Innvalid Move2!!\nPlease Enter Again:");
            return false;
        }
        
        String currPos = board[x][y];
        String updatePos = board[updateX][updateY];
        if(updatePos.charAt(0)=='B')
        {
            System.out.println("Invalid Move3!!\nPlease Enter Again:");
            return false;
        }
        if(updatePos.equals("-"))
        {
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posB.put(entry,coordinates);
            // return true;
        }
        else if(updatePos.charAt(0)=='A')
        {
            posA.remove(updatePos);
            System.out.println(board[updateX][updateY]+" got attacked!!");
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posB.put(entry,coordinates);
            // return true;
        }
        return true;
    }

    public boolean MoveElephantA(String playerMove)
    {
        int indexColon = playerMove.indexOf(':');
        String entry = playerMove.substring(0,indexColon);
        entry = "A-"+entry;
        char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
        // System.out.println(move);
        if(!posA.containsKey(entry))
        {
            System.out.println("Invalid Pawn Selected!!\n Try Again");
            return false;
        }
        ArrayList<Integer> coordinates = posA.get(entry);
        int x =coordinates.get(0);
        int y=coordinates.get(1);
        int updateX =x;
        int updateY=y;
        if(move=='F')
        {
            updateX-=2;
        }
        else if(move=='B')
        {
            updateX+=2;
        }
        else if(move=='L')
        {
            updateY-=2;
        }
        else if(move=='R')
        {
            updateY+=2;
        }
        else
        {
            System.out.println("Invalid Move1!!\nPlease Enter Again:");
            return false;
        }
        if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
        {
            System.out.println("Innvalid Move2!!\nPlease Enter Again:");
            return false;
        }
        
        String currPos = board[x][y];
        String updatePos = board[updateX][updateY];
        if(updatePos.charAt(0)=='A')
        {
            System.out.println("Invalid Move3!!\nPlease Enter Again:");
            return false;
        }
        if(updatePos.equals("-"))
        {
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posA.put(entry,coordinates);
            
        }
        else if(updatePos.charAt(0)=='B')
        {
            posA.remove(updatePos);
            System.out.println(board[updateX][updateY]+" got attacked!!");
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posA.put(entry,coordinates);
            
        }
        return true;
    }
    public boolean MoveElephantB(String playerMove)
    {
        int indexColon = playerMove.indexOf(':');
        String entry = playerMove.substring(0,indexColon);
        entry = "B-"+entry;
        char move =Character.toUpperCase(playerMove.charAt(indexColon+1));
        // System.out.println(move);
        if(!posB.containsKey(entry))
        {
            System.out.println("Invalid Pawn Selected!!\n Try Again");
            return false;
        }
        ArrayList<Integer> coordinates = posB.get(entry);
        int x =coordinates.get(0);
        int y=coordinates.get(1);
        int updateX =x;
        int updateY=y;
        if(move=='F')
        {
            updateX+=2;
        }
        else if(move=='B')
        {
            updateX-=2;
        }
        else if(move=='L')
        {
            updateY-=2;
        }
        else if(move=='R')
        {
            updateY+=2;
        }
        else
        {
            System.out.println("Invalid Move1!!\nPlease Enter Again:");
            return false;
        }
        if(updateX>=5 || updateX<0 || updateY>=5||updateY<0)
        {
            System.out.println("Innvalid Move2!!\nPlease Enter Again:");
            return false;
        }
        
        String currPos = board[x][y];
        String updatePos = board[updateX][updateY];
        if(updatePos.charAt(0)=='B')
        {
            System.out.println("Invalid Move3!!\nPlease Enter Again:");
            return false;
        }
        if(updatePos.equals("-"))
        {
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posB.put(entry,coordinates);
            // return true;
        }
        else if(updatePos.charAt(0)=='A')
        {
            posA.remove(updatePos);
            System.out.println(board[updateX][updateY]+" got attacked!!");
            board[updateX][updateY] = entry;
            board[x][y]="-";
            coordinates.set(0,updateX);
            coordinates.set(1,updateY);
            posB.put(entry,coordinates);
            // return true;
        }
        return true;
    }
   


    public void display()
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(board[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
    

public class ChessGame   {
    static Scanner in;
public static void main(String[] args) {
    in = new Scanner(System.in);
    System.out.println("Enter the Names of Player :");
    System.out.println("Enter Player 1 Name :");
    String A = in.next();
    System.out.println("Enter Player 2 Name :");
    String B = in.next();
    Game ob = new Game(A,B);
    LetsPlay(A,B);
}
public static void LetsPlay(String A,String B)
{
    Game ob = new Game(A,B);
    System.out.println("Enter the Pawn's of A ");
    ob.getAPawn();
    System.out.println("Enter the Pawn's of B ");
    ob.getBPawn();
    

    boolean AMove =true;
    while(ob.posA.size()!=0 && ob.posB.size()!=0)
    {
        boolean isPossible=false;
        System.out.println("Current Grid");
        ob.display();
        while(!isPossible)
        {
            if(AMove)
            {
                System.out.println("Player A's Move : ");
                String move =in.next();
                isPossible=ob.MoveA(move);
                if(!isPossible)
                {
                    continue;
                }
                AMove =!AMove;
            }
            else
            {
                System.out.println("Player B's Move : ");
                String move =in.next();
                isPossible=ob.MoveB(move);
                if(!isPossible)
                {
                    continue;
                }
                AMove =!AMove;
            }
            if(ob.posA.size()==0)
            {
                System.out.println("Congrats "+ob.B+" Won!!");
                System.out.println("Press 1 To Play Again!!");
                int choice =in.nextInt();
                if(choice==1)
                {
                    LetsPlay(A,B);
                }
            }
            if(ob.posB.size()==0)
            {
                System.out.println("Congrats "+ob.A+" Won!!");
                System.out.println("Press 1 To Play Again!!");
                int choice =in.nextInt();
                if(choice==1)
                {
                    LetsPlay(A,B);
                }
            }

        }
    }
}   
}