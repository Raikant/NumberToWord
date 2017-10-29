package maven;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class NumberToWord {

	String w1 = null;
	Map<Integer, String> numbers = new HashMap<Integer, String>();
	Map<Integer, String> position = new HashMap<Integer, String>();
	{
		numbers.put(1, "One");
		numbers.put(2, "Two");
		numbers.put(3, "Three");
		numbers.put(4, "Four");
		numbers.put(5, "Five");
		numbers.put(6, "Six");
		numbers.put(7, "Seven");
		numbers.put(8, "Eight");
		numbers.put(9, "Nine");
		numbers.put(10, "Ten");
		numbers.put(11, "Eleven");
		numbers.put(12, "Tweleve");
		numbers.put(13, "Thirteen");
		numbers.put(14, "Fourteen");
		numbers.put(15, "Fifteen");
		numbers.put(16, "Sixteen");
		numbers.put(17, "Seventeen");
		numbers.put(18, "Eighteen");
		numbers.put(19, "Nineteen");
		position.put(1, "Ten");
		position.put(2, "Twenty");
		position.put(3, "Thirty");
		position.put(4, "Fourty");
		position.put(5, "Fifty");
		position.put(6, "Sixty");
		position.put(7, "Seventy");
		position.put(8, "Eighty");
		position.put(9, "Ninty");
	}

	public static void main(String[] args) {
		NumberToWord app = new NumberToWord();
		String w1 = app.getWords("61616");
		System.out.println(w1);
	}

	public String getWords(String word) {
		int len = word.length();
		if (len == 1) {
			w1 = numbers.get(Integer.valueOf(word));
			return w1;
		} else if (len == 2) {
			int first = Integer.valueOf(word) / 10;
			int second = Integer.valueOf(word) % 10;
			w1 = (Integer.valueOf(word) > 10 && Integer.valueOf(word) < 20) ? numbers.get(Integer.valueOf(word))
					: position.get(first) + (second != 0 ? numbers.get(second) : "");
			return w1;
		} else if (len == 3) {
			int first = Integer.valueOf(word) / 100;
			int remaining = Integer.valueOf(word) % 100;
			if (remaining > 9 && remaining < 19) {
				w1 = numbers.get(first) + " Hundred " + numbers.get(remaining);
				return w1;
			} else if (remaining == 00) {
				w1 = numbers.get(first) + " Hundred ";
				return w1;
			}
			int second = remaining / 10;
			int third = remaining % 10;
			w1 = numbers.get(first) + " Hundred "
					+ (second == 0 ? numbers.get(third)
							: (third == 0) ? position.get(second)
									: (second > 1 && second < 10) ? position.get(second) + numbers.get(third)
											: second + " Hundred " + numbers.get(third));
			return w1;
		} else if (len == 4) {
			int first = Integer.valueOf(word) / 1000;
			int remain3 = Integer.valueOf(word) % 1000;
			int second = Integer.valueOf(remain3) / 100;
			int remain2 = Integer.valueOf(remain3) % 100;
			int third = Integer.valueOf(remain2) / 10;
			int last = Integer.valueOf(remain2) % 10;
			w1 = numbers.get(first) + " Thousand ";

			w1 += 	  (second == 0 && remain2 > 0 && remain2 < 19) ? numbers.get(remain2)
					: (second == 0 && remain3 > 0 && remain3 < 19) ? numbers.get(remain3)
					: (second == 0 && remain2 > 19) ? position.get(third) + numbers.get(last)
					: (second != 0 && remain3 > 19) ? numbers.get(second) + " Hundred "+
					  (remain2>0 && remain2<20 ?numbers.get(remain2):remain2==0?"":position.get(third)+numbers.get(last))
					: (second != 0 && remain3 < 19 ? numbers.get(second) + " Hundred "+position.get(third)+numbers.get(last):"");
					  return w1;
		}else if(len == 5) {
			int first = Integer.valueOf(word) / 1000;
			int remain3 = Integer.valueOf(word) % 1000;
			int second = Integer.valueOf(remain3) / 100;
			int remain2 = Integer.valueOf(remain3) % 100;
			int third = Integer.valueOf(remain2) / 10;
			int last = Integer.valueOf(remain2) % 10;
			w1 = first>19?position.get(first/10)+(numbers.get(first%10)!=null?numbers.get(first%10):"")+ " Thousand ":numbers.get(first) + " Thousand ";

			w1 += 	  (second == 0 && remain2 > 0 && remain2 < 19) ? numbers.get(remain2)
					: (second == 0 && remain3 > 0 && remain3 < 19) ? numbers.get(remain3)
					: (second == 0 && remain2 > 19) ? position.get(third) + numbers.get(last)
					: (second != 0 && remain3 > 19) ? numbers.get(second) + " Hundred "+
					  (remain2>0 && remain2<20 ?numbers.get(remain2):remain2==0?"":position.get(third)+numbers.get(last))
					: (second != 0 && remain3 < 19 ? numbers.get(second) + " Hundred "+position.get(third)+numbers.get(last):"");
		
		}
		return w1;
	}
}
