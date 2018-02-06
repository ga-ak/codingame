package midium;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		char[] strAr = new char[2];
		List<String> stringList = new ArrayList<>();
		stringList.add(Character.toString('a'));
		System.out.println(stringList.get(0));

		strAr[0] += 'a';
		strAr[1] += 'b';

		System.out.println(strAr[0]);
	}
}
