package Bs;
import java.util.*;
import java.io.*;

public class BaseBall {
	 public static int playGame() throws IOException {
		 Random r = new Random();
		 
		 int  x,y,z;
		 
		 x = Math.abs (r.nextInt() % 9) +1;
				do { y= Math.abs(r.nextInt() % 9 )+1;} while (x==y);
				do { z= Math.abs(r.nextInt() % 9 )+1;} while ((x==y) || (z==y));
				
				return playGame(x,y,z);
	 }
    public static int playGame(int x, int y, int z) throws IOException {
    
        int count;
        int strike, ball;
        int[] usr = new int[3]; //usr 배열에 int3칸짜리 배열 생성
        int[] com = { x, y, z };
        
        System.out.println("숫자 야구 게임 시작");
        
        count = 0; 

        do {
            count++;
            do {
                System.out.println("\n카운트: " + count);
                
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
                String user;
                
                System.out.print("1번째 숫자: ");
                user = in.readLine(); //사용자 입력
                usr[0] = new Integer(user).intValue();
                System.out.print("2번째 숫자: ");
                user = in.readLine();//사용자 입력
                usr[1] = new Integer(user).intValue();
                System.out.print("3번째 숫자: ");
                user = in.readLine();//사용자 입력
                usr[2] = new Integer(user).intValue();

                if ((usr[0] == 0) || (usr[1] == 0) || (usr[2] == 0)) { //0입력방지
                    System.out.println("0은 입력하지 마세요. 다시 입력해주세요.");
                } else if ((usr[0] > 9) || (usr[1] > 9) || (usr[2] > 9)) { //9초과 방지
                    System.out.println("1부터 9까지의 숫자 중 하나를 입력해주세요. 다시 입력해주세요.");
                } else if ((usr[0] == usr[1]) || (usr[1] == usr[2]) || (usr[0] == usr[2])) { //중복 숫자 방지
                    System.out.println("모두 다른 숫자를 입력해주세요. 다시 입력해주세요.");
                }
            } while ((usr[0] == 0) || (usr[1] == 0) || (usr[2] == 0) || (usr[0] > 9) || (usr[1] > 9) || (usr[2] > 9) || (usr[0] == usr[1]) || (usr[1] == usr[2]) || (usr[0] == usr[2]));

            strike = ball = 0; // 스트라이크와 볼을 0으로 세팅

            if (usr[0] == com[0]) strike++; // 스트라이크와 볼 판정
            if (usr[1] == com[1]) strike++;
            if (usr[2] == com[2]) strike++;
            if (usr[0] == com[1]) ball++;
            if (usr[0] == com[2]) ball++;
            if (usr[1] == com[0]) ball++;
            if (usr[1] == com[2]) ball++;
            if (usr[2] == com[0]) ball++;
            if (usr[2] == com[1]) ball++;

            System.out.println("Strike: " + strike + " Ball: " + ball);
        } while ((strike < 3) && (count < 11));

        return count;
    }

    public static void main(String[] args) throws IOException {
        int result;
        if (args.length == 3) {
            int x = Integer.valueOf(args[0]).intValue();
            int y = Integer.valueOf(args[1]).intValue();
            int z = Integer.valueOf(args[2]).intValue();
            result = playGame(x, y, z);
        } else {
            result = playGame();
        }
        System.out.println();
        if (result <= 2) {
            System.out.println("참 잘했어요!");
        } else if (result <= 5) {
            System.out.println("잘했어요!");
        } else if (result <= 9) {
            System.out.println("보통이네요!");
        } else {
            System.out.println("분발하세요!");
        }

} }
