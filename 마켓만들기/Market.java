package Market;

import java.util.Scanner;

public class Market {
	String 마켓이름;
	Item[] 물건 = new Item[5];
	Scanner sc = new Scanner(System.in);
	boolean 진행 = true;
	
	public Market(String 마켓이름) {
		this.마켓이름 = 마켓이름;

		물건[0] = new Item("사과", 2000, 20);
		물건[1] = new Item("오렌지", 1000, 100);
		물건[2] = new Item("생선", 5000, 30);
	}

	void 판매(Customer 손님){
		System.out.println("구매 페이지입니다.");
		System.out.println("구매할 물건을 선택하시오.");
		
		for(Item i : 물건) {
			if(i==null) {
				System.out.print(">");
				break;
			}
			System.out.printf("%d.%s  ", i.물건번호 , i.get물건명());
		}
		
		int 구매번호 = sc.nextInt();
		
		
	}
	
	void 재고관리(){
		System.out.println("재고관리 페이지입니다.");
		System.out.print("메뉴를 선택하세요.(1)재고현황, (2)재고수정, (3) 종료");
		int 메뉴 = sc.nextInt();
		
		while(진행) {
			switch (메뉴) {
			case 1: {
				재고현황();
				진행 = false;
				break;
			}
			case 2: {
						System.out.println("수정할 물건을 선택하시오");
						for(Item i : 물건) {
							if(i==null) {
								System.out.print(">");
								break;
							}
							System.out.printf("%d. %s  ", i.물건번호, i.get물건명());
						}
						메뉴 = sc.nextInt();
						
						Item 수정물건 = 물건[메뉴-1];
						
						System.out.printf("< %s > 수정할 항목을 선택하세요. >", 수정물건.get물건명());
						System.out.println("(1)물건명 (2)가격 (3)재고 (4)종료 >");
						int 수정항목 = sc.nextInt();
						
						switch (수정항목) {
						case 1: 
							System.out.printf("물건명의 현재값: %s, 수정할 물건명 > ", 수정물건.get물건명());
							수정물건.set물건명(sc.next());
							continue;
						case 2: 
							System.out.printf("가격의 현재값: %s, 수정할 가격 > ", 수정물건.get가격());
							수정물건.set가격(sc.nextInt());
							continue;
						case 3:
							System.out.printf("재고의 현재값: %s, 수정할 재고 > ", 수정물건.get재고());
							수정물건.set재고(sc.nextInt());
							continue;
						case 4:
							System.out.println("수정창을 종료합니다.");
							break;
						default:
							
						}
					}
			case 3: {
				break;
			}

			default:
				
			}
		}
	}
	
	void 재고현황(){
		System.out.println(마켓이름+" 현재 재고는...");
		System.out.println(Item.물건명번호+" 가지의 물건이 있습니다.");
		
		for(Item i : 물건) {
			if(i==null) break;
			System.out.println(i.물건번호);
			System.out.println(i.get물건명());
			System.out.println(i.get가격());
			System.out.println(i.get재고());			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
