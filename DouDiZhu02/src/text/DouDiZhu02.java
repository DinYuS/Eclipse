package text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
public class DouDiZhu02 {
		public static void main(String[] args) {
			/*
			 * 
			 */
			//1.1 创建Map集合存储牌
			HashMap<Integer,String> pokerMap = new HashMap<Integer,String>();
			//1.2 创建花色和数字的集合
			ArrayList<String> colors=
					new ArrayList<>();
			ArrayList<String> numbers=
					new ArrayList<>();
			
			Collections.addAll(colors,"♣","♥","♠","♦");
			Collections.addAll(numbers,"2","A","K","Q","J","10","9","8","7","6","5","4","3");
			
			//1.3 设置Map存储牌
			int count=1;
			pokerMap.put(count++, "大王");
			pokerMap.put(count++, "小王");
			
			for(String number:numbers) {
				for(String color:colors) {
					String card=color+number;
					pokerMap.put(count++, card);
				}
			}
			//System.out.println(pokerMap);
			
			
			//2. 洗牌
			//2.1 取出索引->List.add(a) .add(a) 靠下标来区分
			//			Map put(1,"a") put(2,"a") 靠键值来区分
			//			Set add("a") add("b") 集合元素
			Set<Integer> numberSet = pokerMap.keySet();
			
			/**
			 * Set中会自动为重复元素去重，适用于大数据中对重复数据进行去重
			 */
//			Set<Integer> sets = new HashSet<Integer>();
//			sets.add(1);
//			sets.add(2);
//			sets.add(3);
//			//自动去重
//			System.out.println(sets);
			
			//因为要将编号打乱顺序，所以应该转换到List集合中
			ArrayList<Integer> numberList = 
					new ArrayList<>();
			numberList.addAll(numberSet);
			//打乱顺序
			Collections.shuffle(numberList);
			
			//发票
			
			ArrayList<Integer> nop1 = new ArrayList<>();
			ArrayList<Integer> nop2 = new ArrayList<>();
			ArrayList<Integer> nop3 = new ArrayList<>();
			ArrayList<Integer> dipaiNo = new ArrayList<>();
			
			
			//3.2 发牌的编号
			for(int i=0;i<numberList.size();i++) {
				//获取该编号
				Integer no = numberList.get(i);
				if(i>=51) {
					dipaiNo.add(no);
				}else {
					if(i%3==0) {
						nop1.add(no);
					}else if(i%3==1) {
						nop2.add(no);
					}else{
						nop3.add(no);
					}
				}
			}
			
			//排序->排编号
			Collections.sort(nop1);
			Collections.sort(nop2);
			Collections.sort(nop3);
			Collections.sort(dipaiNo);
			
			//看牌
			//System.out.println(nop1);
			
			//4.3 转换
			ArrayList<String> player1 = new ArrayList<String>();
			ArrayList<String> player2 = new ArrayList<String>();
			ArrayList<String> player3 = new ArrayList<String>();
			ArrayList<String> dipai = new ArrayList<String>();
			
			for(Integer i:nop1) {
				//根据编号找到牌面（对应值）
				String card = pokerMap.get(i);
				//添加到对应的牌的集合
				player1.add(card);				
			}
			for(Integer i:nop2) {
				//根据编号找到牌面（对应值）
				String card = pokerMap.get(i);
				//添加到对应的牌的集合
				player2.add(card);				
			}
			for(Integer i:nop3) {
				//根据编号找到牌面（对应值）
				String card = pokerMap.get(i);
				//添加到对应的牌的集合
				player3.add(card);				
			}
			for(Integer i:dipaiNo) {
				//根据编号找到牌面（对应值）
				String card = pokerMap.get(i);
				//添加到对应的牌的集合
				dipai.add(card);
			}
			
			//4.5 查看
			System.out.println("令狐冲"+player1);
			System.out.println("石破天"+player2);
			System.out.println("段誉"+player3);
			System.out.println("底牌"+dipai);

			
					
		}
}
