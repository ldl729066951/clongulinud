package com.castor.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class LiBrother {

  public static void main(String[] args) {
  	  //ABA -> B
	  //ABAC -> B
	  //ABC -> A
	  //ABAEFGCHBOPCS -> B

	  String value = "ABAEFGCHBOPCS";
	  Map<Character, Integer> map = new HashMap<>();
	  char[] values = value.toCharArray();
	  int index = 0;
	  for(int i=0; i < values.length; i++) {
	  	char tmp = values[i];
	  	if(!map.containsKey(tmp)){
	  		map.put(tmp, i);
	  		continue;
		}
		int tmp_index = map.get(tmp);
		index = tmp_index + 1;
	  	map.put(tmp, i);
		continue;

	  }
	  System.out.println(values[index]);
  }
}
