package midium;

import java.util.HashMap;
import java.util.Map;

public class MayanCalculation {
	public static void main(String[] args) {
		String[] numeral = {
				".oo.o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo....o...oo..ooo.oooo",
				"o..o................____________________________________________________________",
				".oo.....................................________________________________________",
				"............................................................____________________"
		};
		Map<String, Integer > numeralToInt = new HashMap<>();
		Map<Integer, String > intToNumeral = new HashMap<>();
		for (int i=0; i<20; i++) {
			String tempStr = "";
			for (int j=0; j<numeral.length; j++) {
				tempStr += numeral[j].substring(4 * i, 4 * i + 4);
			}
			numeralToInt.put(tempStr, i);
			intToNumeral.put(i, tempStr);
		}
		System.out.println(intToNumeral.get(19));
	}
}
