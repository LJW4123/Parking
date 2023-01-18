package Parking;

import java.util.Scanner;

public class assignment2 {
	
	public static Scanner scanner = new Scanner(System.in);
	
	static final int ROW = 4;
	static final int COL = 3;
	
	public static void main(String[] args) {
		
		String [][] parkingSpace = new String [ROW][COL];
		String [][] carName = new String [ROW][COL];
		
		for(int j =0; j<=ROW-1; j++) {
			for(int i =0; i<=COL-1; i++) {
		parkingSpace[j][i] = "♡";
		carName[j][i] = "a";
			}
		}
		while (true) {
			System.out.println("202211946 이재원");
			int loc1,loc2;
			System.out.println("**** 주차 현황 ****");
			System.out.println("  1 2 3");
			int i =1;
			for (String[] a: parkingSpace) {
				
				System.out.print(i);
				i +=1;
				for (String b :a ) {
					
					System.out.print(" "+b);
					
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("1) 주차하기 2) 차량검색 3) 출차하기 4) 종료");
			System.out.print("메뉴를 선택하세요 :");
			int num = scanner.nextInt();
			System.out.println();
			
			switch(num) {
			
			case 1 :
				System.out.println("**** 주차하기 ****");
				System.out.print("주차할 위치를 선택해 주세요(입력예 : 2 1) : ");
				  loc1 = scanner.nextInt();
				  loc2 = scanner.nextInt();
				loc1=loc1-1;
				loc2=loc2-1;				
				try {
				if (parkingSpace[loc1][loc2] == "♥") {
					System.out.println("다른 차량이 주차되어 있습니다. 처음부터 다시 시작해 주세요.");
					System.out.println();
					break;
				}
				}
				catch (Exception e){
					System.out.println("위치 번호를 확인해 주세요. 처음부터 다시 시작해 주세요.");
					System.out.println();
					break;
				}
				
				System.out.print("차량 번호를 입력해 주세요(입력예 : 20가1234 ) : ");
				String car = scanner.next();
				
				System.out.print("차량 번호" + car + "맞습니까(y/n)?");
				String answer = scanner.next();
				if (answer.equals("n")) {
					System.out.println("처음부터 다시 진행해 주세요.");
					System.out.println();
					break;
				}
				System.out.println(car+"차량의 주차를 완료하였습니다.");
				System.out.println();
				
				if (parkingSpace[loc1][loc2] == "♡") {
				parkingSpace[loc1][loc2] = "♥";
				carName[loc1][loc2] = car;
				
				}
				
				break;
				
			case 2 :
				System.out.println("**** 차량검색 ****");
				System.out.print("차량 번호를 입력해 주세요 : ");
				String carNum = scanner.next();
				
				Label : for (int qwe=0; qwe<ROW; qwe++) {
					for(int rty=0; rty<COL; rty++) {
						if(carName[qwe][rty].equals(carNum)) {
							qwe+=1;
							rty+=1;
							System.out.println(carNum+"는"+"("+qwe+","+rty+")"+"에 위치합니다.");
							break Label;
						}
						if((qwe==3)&&(rty==2)) {
							System.out.println("차량이 존재하지 않습니다. 차량번호 확인후 처음부터 다시 진행해 주세요.");
							break Label;
						
					}
				}
				}
				break;
				
			case 3 :
				System.out.println("**** 출차하기 ****");
				System.out.print("차량 번호를 입력해 주세요 : ");
				String car1= scanner.next();
				Label :for (int qwe=0; qwe<ROW; qwe++) {
					for(int rty=0; rty<COL; rty++) {
						if(carName[qwe][rty].equals(car1)) {
							System.out.println(car1+" 차량이 출차되었습니다. 안녕히 가세요.");
							parkingSpace[qwe][rty] = "♡";
							carName[qwe][rty] = "a";
							break Label;
						}
						if((qwe==3)&&(rty==2)) {
							System.out.println("차량이 존재하지 않습니다. 차량번호 확인후 처음부터 다시 진행해 주세요.");
						
						}
					}
				}
				break;
				
			case 4 :
				System.out.println("시스템을 종료합니다.");
				scanner.close();
				System.exit(0);
				
				break;
				
			default :
				System.out.println("메뉴 번호를 확인 후 다시 입력해 주세요.");
				System.out.println();
				break;
			}
			
		}
	}

}
