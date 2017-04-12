package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

	public static void main(String[] args) {
		List unboundList = new ArrayList<Integer>();
		List<?> ubl2 = new ArrayList<Integer>();
		List sList = new ArrayList<String>();
		ubl2.addAll(sList);
		sList.add("wwewewewe");
		List<Integer> iList = new ArrayList<>();
		iList.addAll(sList);
		System.out.println(iList.get(0));
	}
}
