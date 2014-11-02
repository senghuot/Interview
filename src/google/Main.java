package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Calculator cal = new Calculator("9*1+2*9");
//		System.out.println(cal.read());
//		System.out.println(cal.read());
//		System.out.println(cal.read());
//		System.out.println(cal.read());
//		System.out.println(cal.read());
//		System.out.println(cal.getInt());
		
		Stack<Integer> num = new Stack<Integer>();
		Stack<Integer> operator = new Stack<Integer>();
		
		int value;
		while((value = cal.read()) != 1){
			switch (value){
				case 3:
					operator.push(value);
               break;
				case 4:
					cal.read();
					int intFromNum = num.pop();
					int intFromCal = cal.getInt();
					int finalValue = intFromNum * intFromCal;
					num.push(finalValue);
               break;
				default:
					num.push(cal.getInt());
			}
		}
		
		while(!operator.isEmpty()){
			operator.pop();
			int v1 = num.pop();
			int v2 = num.pop();
			num.push(v1+v2);
		}
		
		System.out.println(num);
	}
	
	// fast way to multiply by 4.
	public static int multiply4(int num) {
		return num << 2;
	}

}
