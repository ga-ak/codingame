package midium;

import java.util.*;

public class Scrabble {
	public static int pointSum(Map<Character, Integer> pointMap, char tempChar) {
		return pointMap.get(tempChar);
	}
	public static void main(String[] args) {
		String[] words = {"arrest", "rarest", "raster", "raters", "sartre", "starer", "waster", "waters", "wrest", "wrase"};
		String LETTERS = "arwtsre";

		Map<Character, Integer> pointMap = new HashMap<>();
		Set<Character> letterSet = new HashSet<>();

		//letterSet에 LETTERS 넣기
		for (int i=0; i<LETTERS.length(); i++) {
			letterSet.add(LETTERS.charAt(i));
		}

		pointMap.put('e', 1);
		pointMap.put('a', 1);
		pointMap.put('i', 1);
		pointMap.put('o', 1);
		pointMap.put('n', 1);
		pointMap.put('r', 1);
		pointMap.put('t', 1);
		pointMap.put('l', 1);
		pointMap.put('s', 1);
		pointMap.put('u', 1);

		pointMap.put('d', 2);
		pointMap.put('g', 2);

		pointMap.put('b', 3);
		pointMap.put('c', 3);
		pointMap.put('m', 3);
		pointMap.put('p', 3);

		pointMap.put('f', 4);
		pointMap.put('h', 4);
		pointMap.put('v', 4);
		pointMap.put('w', 4);
		pointMap.put('y', 4);

		pointMap.put('k', 5);

		pointMap.put('j', 8);
		pointMap.put('x', 8);

		pointMap.put('q', 10);
		pointMap.put('z', 10);

		Map<Character, Integer> letterMap = new HashMap<>();
		Map<Character, Integer> tempMap = new HashMap<>();
		Map<String, Integer> resultMap = new HashMap<>();
		List<String> resultArrayList = new ArrayList<>();
		for (int i=0; i<LETTERS.length(); i++) {
			char tempChar = LETTERS.charAt(i);
			if (!letterMap.containsKey(tempChar)) {
				letterMap.put(tempChar, 1);
			} else {
				letterMap.put(tempChar, letterMap.get(tempChar) + 1);
			}

		}
		System.out.println(letterMap);
		//words 의 단어가 LETTERS의 조건에 맞는지 검사
		for (int i=0; i<words.length; i++) {
			tempMap.clear();
			for(int j=0; j<words[i].length(); j++) {
				char tempChar = words[i].charAt(j);
				if (!letterSet.contains(tempChar)) {
					tempMap.clear();
					break;
				} else {
					//words[i] 알파벳 갯수 세는 조건식
					if (!tempMap.containsKey(tempChar)) {
							tempMap.put(tempChar, 1);
						} else {
							tempMap.put(tempChar, tempMap.get(tempChar) + 1);
						}
				}
			}
			Iterator<Map.Entry<Character, Integer>> itr = tempMap.entrySet().iterator();

			int tempPoint = 0;
			while (itr.hasNext()) {
				Map.Entry<Character, Integer> e = itr.next();
				if (e.getValue() > letterMap.get(e.getKey())) {
					tempPoint = 0;
					break;
				} else {
					tempPoint += pointSum(pointMap, e.getKey()) * e.getValue();
				}
			}
			if (tempPoint != 0) {
				resultMap.put(String.valueOf(words[i]), tempPoint);
				resultArrayList.add(String.valueOf(words[i]));
			}
		}
		//System.out.println(tempMap);
		int maxPoint = Integer.MIN_VALUE;

		Iterator<Map.Entry<String, Integer>> tempItr = resultMap.entrySet().iterator();
		while (tempItr.hasNext()) {
			Map.Entry<String, Integer> e = tempItr.next();
			if (e.getValue() > maxPoint) {
				maxPoint = e.getValue();
			}
		}
		int tempIndex = Integer.MAX_VALUE;
		Iterator<Map.Entry<String, Integer>> resultItr = resultMap.entrySet().iterator();
		while (resultItr.hasNext()) {
			Map.Entry<String, Integer> e = resultItr.next();
			if (e.getValue() == maxPoint && resultArrayList.indexOf(e.getKey()) < tempIndex) {
				tempIndex = resultArrayList.indexOf(e.getKey());
			}
		}

		System.out.println(resultArrayList.get(tempIndex));
	}
}

