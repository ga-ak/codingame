package midium;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bender_epi1 {
	public static void tempMove(int directionIndex, int[] tempPos) {
		switch (directionIndex) {
			case 0 :
				tempPos[0]++;
				break;
			case 1 :
				tempPos[1]++;
				break;
			case 2 :
				tempPos[0]--;
				break;
			case 3 :
				tempPos[1]--;
				break;
		}
	}

	/*public static int nextDirection() {

		return;
	}*/
	public static int[] nextMove(int directionIndex, int[] curruntPos, String[] curruntDirec,String[] direction, String[][] cityMap, int curruntIMode, int curruntMode) {
		int[] tempPos = Arrays.copyOf(curruntPos, curruntPos.length);
		tempMove(directionIndex, tempPos);
		while (cityMap[tempPos[0]][tempPos[1]].equals("#") || cityMap[tempPos[0]][tempPos[1]].equals("X")) {
			if (curruntMode == 1 && cityMap[tempPos[0]][tempPos[1]].equals("X") ) {
				curruntPos = tempPos;
				curruntDirec[0] = direction[directionIndex];
				return curruntPos;
			}
			// 시계방향 모드일때
			if (curruntIMode == 1) {
				if (directionIndex == 0) {
					directionIndex = 3;
				} else {
					directionIndex--;
				}
			} else {
				// 반시계방향 모드일때
				if (directionIndex == 3) {
					directionIndex = 0;
				} else {
					directionIndex++;
				}
			}
			tempPos = Arrays.copyOf(curruntPos, curruntPos.length);

			tempMove(directionIndex, tempPos);
		}
		curruntPos = tempPos;
		//System.out.println(curruntPos[0]+"  "+curruntPos[1]);
		System.out.println(directionIndex);
		curruntDirec[0] = direction[directionIndex];
		return curruntPos;
	}
	public static void main(String[] args) {
		String[] tempStr = {"########", "# @    #", "#     X#", "# XXX  #", "#   XX #", "#   XX #", "#     $#", "########"};
		String[][] cityMap = new String[tempStr.length][tempStr[0].length()];
		int[] curruntPos = new int[2];
		int[][] teleportPos = new int[2][2];
		int teleCount = 0;
		for (int i=0; i<cityMap.length; i++) {
			for (int j=0; j<cityMap[i].length; j++) {
				cityMap[i][j] = tempStr[i].substring(j, j + 1);
				if (tempStr[i].substring(j, j + 1).equals("@")) {
					curruntPos[0] = i;
					curruntPos[1] = j;
				}
				if (tempStr[i].substring(j, j + 1).equals("T")) {
					teleportPos[teleCount][0] = i;
					teleportPos[teleCount][1] = j;
					teleCount++;
				}
			}
		}


		for (int i=0; i<cityMap.length; i++) {
			for (int j=0; j<cityMap[i].length; j++) {
				System.out.print(cityMap[i][j]+" ");
			}
			System.out.println();
		}

		String[] direction = {"SOUTH", "EAST", "NORTH", "WEST"};
		String[] iMode = {"COUNTERCLOCKWISE", "CLOCKWISE"};
		String[] mode = {"NOMAL", "BREAKER"};
		int directionIndex = 0;
		String[] curruntDirec = new String[1];
		curruntDirec[0] = direction[directionIndex];
		int curruntIMode = 0;
		int curruntMode = 0;
		List<String> result = new ArrayList<>();




		while (!cityMap[curruntPos[0]][curruntPos[1]].equals("$")) {
			//System.out.println(directionIndex);
			curruntPos = nextMove(directionIndex, curruntPos, curruntDirec ,direction ,cityMap, curruntIMode, curruntMode);
			switch (cityMap[curruntPos[0]][curruntPos[1]]) {
				case "S" :
					directionIndex = 0;
					curruntDirec[0] = direction[directionIndex];
					break;
				case "E" :
					directionIndex = 1;
					curruntDirec[0] = direction[directionIndex];
					break;
				case "N" :
					directionIndex = 2;
					curruntDirec[0] = direction[directionIndex];
					break;
				case "W" :
					directionIndex = 3;
					curruntDirec[0] = direction[directionIndex];
					break;
				case "I" :
					if (curruntIMode == 0) {
						curruntIMode = 1;
					} else {
						curruntIMode = 0;
					}
					break;
				case "B" :
					if (curruntMode == 0) {
						curruntMode = 1;
					} else {
						curruntMode = 0;
					}
					break;
				case "T" :
					for (int i=0; i<2; i++) {
						if (curruntPos == teleportPos[i]) {
							if (i == 0) {
								curruntPos = teleportPos[1];
							} else {
								curruntPos = teleportPos[0];
							}
						}
					}
					break;
			}
			result.add(curruntDirec[0]);
		}
		System.out.println(result);
	}
}
