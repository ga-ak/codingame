package midium;

import java.util.*;

public class test {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int H = in.nextInt();
		String[] numeralAr = new String[4];
		for (int i = 0; i < H; i++) {
			String numeral = in.next();
			numeralAr[i] = numeral;
			//System.err.println("\""+numeral+"\", ");
		}
		Map<String, Integer > numeralToInt = new HashMap<>();
		Map<Integer, String > intToNumeral = new HashMap<>();
		for (int i=0; i<20; i++) {
			String tempStr = "";
			for (int j=0; j<numeralAr.length; j++) {
				tempStr += numeralAr[j].substring(4 * i, 4 * i + 4);
			}
			numeralToInt.put(tempStr, i);
			intToNumeral.put(i, tempStr);
		}

		int S1 = in.nextInt();
		String[] tempAr = new String[S1/4];
		for(int i=0; i<tempAr.length; i++) {
			tempAr[i] = "";
		}
		//System.err.println(S1);
		for (int i = 0; i < S1; i++) {
			String num1Line = in.next();
			tempAr[i/4] += num1Line;
		}
		//System.err.println(tempStr);
		long intA = 0;
		//System.err.println(tempAr[0]);
		for(int i=0; i<tempAr.length; i++) {
			intA += (long)(numeralToInt.get(tempAr[i]) * Math.pow(20,tempAr.length - i-1));
		}

		int S2 = in.nextInt();
		tempAr = new String[S2/4];
		for(int i=0; i<tempAr.length; i++) {
			tempAr[i] = "";
		}
		for (int i = 0; i < S2; i++) {
			String num2Line = in.next();
			tempAr[i/4] += num2Line;
		}
		long intB = 0;
		for(int i=0; i<tempAr.length; i++) {
			intB += (long)(numeralToInt.get(tempAr[i]) * Math.pow(20,tempAr.length - i-1));
		}

		String operation = in.next();
		System.err.print(intA+operation+intB+" = ");
		long result = 0l;
		switch(operation) {
			case "+" :
				result = intA + intB;
				break;
			case "-" :
				result = intA - intB;
				break;
			case "*" :
				result = intA * intB;
				break;
			case "/" :
				result = intA / intB;
				break;
		}
		System.err.println(result);
		List<Long> tempBinary = new ArrayList<>();
		if(result < 20) {
			tempBinary.add(result);
		} else {
			while (result > 20) {
				if (result / 20 < 20) {
					tempBinary.add(result%20);
					tempBinary.add(result/20);
					result = result / 20;
				} else {
					tempBinary.add(result%20);
					result = result / 20;
				}
			}
		}

		//System.err.println(tempBinary);

		int[] resultBinary = new int[tempBinary.size()];
		for(int j=0; j<resultBinary.length; j++) {

			String tempStr = intToNumeral.get(tempBinary.get(tempBinary.size() - j -1));
			for(int i=0; i<tempStr.length(); i++) {
				if(i%4 == 0 && i != 0) {
					System.out.println();
				}
				System.out.print(tempStr.substring(i,i+1));
			}
			System.out.println();
		}


		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");


	}
}
