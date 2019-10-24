package com.leetcode.medium;

public class IntegerToWords {
	private static final String[] words = {
	        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
	        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	    };
	    
	    private static final String[] tens = { "", "",//0, 10 unused
			 "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
	    };
	    
	    private static final int 
	        ONE_HUNDRED  = 100, 
	        ONE_THOUSAND = 1000, 
	        ONE_MILLION  = 1000000, 
	        ONE_BILLION  = 1000000000;
    
    
    public static void main(String[] args) {
		IntegerToWords i = new IntegerToWords();
		
		System.out.println(i.numberToWords(134561231));
	}
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        else return build(new StringBuilder(), num).toString();
    }
    
	/**
	 * The start of the conversion process. A recursive method that appends the remaining number to the given StringBuilder and returns it.
	 */
    private StringBuilder build(StringBuilder sb, int remainingNumber) {
        if(remainingNumber < words.length) {
            return sb.append(words[remainingNumber]);
        } else if(remainingNumber < ONE_HUNDRED) {//is in tens!
            sb.append(tens[remainingNumber/10]);
            int remain = remainingNumber%10;
            if(remain > 0) sb.append(" ");
            return build(sb, remain);
        } else if(remainingNumber < ONE_THOUSAND) {//is in.. capacity string
            return build(sb, remainingNumber, "Hundred", ONE_HUNDRED);
        } else if(remainingNumber < ONE_MILLION) {
            return build(sb, remainingNumber, "Thousand", ONE_THOUSAND);
        } else if(remainingNumber < ONE_BILLION) {
            return build(sb, remainingNumber, "Million", ONE_MILLION);
        } else {//integers only go to billions.. otherwise I'd consider a number : string mapping here for anything > 100
            return build(sb, remainingNumber, "Billion", ONE_BILLION);
        }
    }

	/**
	 * For numbers greater than one hundred, this method is used to append the expected English output. Not to be called outside of build(sb, num).
	 */
    private StringBuilder build(StringBuilder sb, int remainingNumber, String placement, int capacity) {
        build(sb, remainingNumber / capacity);
        sb.append(" ").append(placement);
        int remain = remainingNumber % capacity;
        if(remain > 0) sb.append(" ");
        return build(sb, remain);
    }
}
