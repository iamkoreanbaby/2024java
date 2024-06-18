package MK;

public class C_MK {
		
		String 마켓이름;
		item[] 물건 = new item[5];
		
		
		public C_MK(String 마켓이름) {
			this.마켓이름 = 마켓이름;
			
			물건[0] = new item("사과",2000,20);
			물건[1] = new item("오렌지",1000,100);
			물건[2] = new item("생선",5000,30);
			
		}
		
		void 판매() {
			System.out.println();
		}


		void 재고관리() {
			
		}
		
		void 재고현황() {
			System.out.println(마켓이름+" 현재 재고는...");
			System.out.println(item.물건명번호+" 가지의 물건이 있습니다.");

			for(item i : 물건) {
				if(i==null)break;
				System.out.println(i.물건번호);
				System.out.println(i.get물건명());
				System.out.println(i.get가격());
				System.out.println(i.get재고());
			}
		}
		
	

}
