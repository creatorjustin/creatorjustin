/*
 * There is no requirement for a file header comment for this 
 * assignment. Spend your time writing good testcases instead!
 */
import java.util.Queue;
import java.util.Stack;

public class Recursion {

	/**
	 * Write a recursive function that finds the index of s2 in s1. Do not use any
	 * string functions except for .length(), .equals(), and .substring(). Do not use
	 * any loops, or any data structures.
	 * @param s1
	 * @param s2
	 * @return Returns the index of the first time that
	 * 			s2 appears in s1 or -1 if s2 is not contained
	 * 			in s1.
	 */
	public static int indexOf(String s1, String s2) {
		if (s1.length() < s2.length() ||
			!s1.contains(s2)) { return -1;
		}else {
			int index = 0;
			return indexOfHelper(s1, s2, index);
		}
	}
	
	private static int indexOfHelper(String s1, String s2, int index) {
		if (s1.equals(s2)) { return index;
		} 
		if (s1.length() == 1 &&
			s1 != s2) { return -1;
		} else {
			int result = 0;
			int frontApproach = indexOfHelper(s1.substring(1), s2, index + 1);
			if (frontApproach != -1) { return frontApproach;
			}
			int backApproach  = indexOfHelper(s1.substring(0, s1.length() -1),s2, index + 1);
			if (backApproach != -1) { return backApproach;
			} return 0;
		}
	}

	/**
	 * Write a recursive function that removes the first k even numbers
	 * from the stack. If there are less than k even elements in the stack,
	 * just remove all even elements. Do not use any loops or data structures
	 * other than the stack passed in as a parameter.
	 * @param stack
	 * @param k
	 * @return Returns the number of elements removed from the stack.
	 */
	public static int removeEvenNumbers(Stack<Integer> stack, int k) {
		int removed = 0;
		return removeHelper(stack, k, removed);
		
	}
	
	private static int removeHelper(Stack<Integer> stack, int k, int numRemoved) {
		if (stack.size() == 1  && 
			stack.lastElement()%2 != 0) { return numRemoved;
		}
		if (stack.size() == 1  && 
			stack.lastElement()%2 == 0) { return numRemoved + 1;
		}else {
			stack.push(stack.lastElement());
			if (stack.pop()%2 == 0) {
				stack.pop();
				return removeHelper(stack, k , numRemoved + 1);
			} else {
				stack.pop();
				return removeHelper(stack, k, numRemoved);
			}
		}
	}

	/**
	 * Write a recursive function that accepts an integer and
	 * returns a new number containing only the even digits, in the same
	 * order. If there are no even digits, return 0. Your function should
	 * work for positive or negative numbers. You are NOT allowed
	 * to use any data structures. You are not allowed to use Strings to
	 * solve this problem either.
	 * @param n
	 * @return The input with only the even digits remaining in the same
	 * order.
	 */
	public static int evenDigits(int n) {
		int temp = 0;
		return evenDigHelper(n, temp, 0);
	}
	
	private static int evenDigHelper(int n, int temp, int newNum) {
		if (n < 10  &&
			n%2 != 0) { return newNum;
		}
		if (n < 10  &&
			n%2 == 0) { return (newNum * 10) + n;
		} else {
    		int num = n % 10;
    		if (num%2 == 0) {
    			newNum = (newNum * 10) + num;
    		}
    		n/= 10;
    		temp = num;
	    	return evenDigHelper(n, temp, newNum);
		}
	}

	/**
	 * Write a recursive function that evaluates a Queue<Character> as a mathematical
	 * expression. This queue can have any of the following characters:
	 * { '(', ')', '+', '*'} or any single digit number. Evaluate this expression and
	 * return the result. For example, for the expression:
	 * "(((1+2)*(3+1))+(1*(2+2)))", each of these characters would be in the
	 * q. As you recursively evaluate characters from the expression, you will
	 * remove the characters from the q. After evaluating the above expression,
	 * you should return 16. You are guaranteed that there are NO two digit numbers,
	 * and that the expression is well formed (parenthesis match, etc...). Do not use any
	 * loops. Do not use any data structures besides the q passed in as a parameter.
	 * @param q
	 * @return The result of the mathematical expression.
	 */
	public static int evaluate(Queue<Character> q) {
		char item  = q.peek();
		q.remove();
		if (Character.isDigit(item)) {
			int num = Character.getNumericValue(item);
			if (q.peek() == ')') {
				return num;
			}
			if (q.peek() == '+') {
				q.remove();
				return num += evaluate(q);
			}
			if (q.peek() == '*') {
				q.remove();
				return num *= evaluate(q);
			}
		} 
		if (item == ')') {
			if (q.peek() == '*') {
				q.remove();
				return 1 * evaluate(q);
			}
			if (q.peek() == '+') {
				q.remove();
				return 0 + evaluate(q);
			}
		}
		return evaluate(q);
	}
	
//	private static int evalHelper(Queue<Character> q, int exp, int answer) {
//		if (q.isEmpty()) { return exp ;
//		} else {
//			char item = q.peek();
//			q.remove();
//			if (Character.isDigit(item)) {
//				int num = Character.getNumericValue(item);
//				if (q.peek() == '+') {
//					q.remove();
//					if (Character.isDigit(q.peek())){
//						int exp2 = evalHelper(q, exp, answer);
//						exp = num + exp2;
//						q.remove();
//					}
//				}
//				if (q.peek() == '*') {
//					q.remove();
//					if (Character.isDigit(q.peek())){
//						int exp2 = evalHelper(q, exp, answer);
//						exp = num * exp2;
//						q.remove();
//					}
//				}else{
//					return num;
//				}
//				return evalHelper(q, exp, answer);
//			}
//			if (item == '+') {
//				q.remove();
//				exp += evalHelper(q, exp, answer);
//			}
//			if (item == '*') {
//				q.remove();
//				exp *= evalHelper(q, exp, answer);
//			}
////				if (q.peek() == '+') {
////					q.remove();
////					exp += evalHelper(q, exp, answer);
////					answer = exp;
////				}
////				if (q.peek() == '*') {
////					q.remove();
////					exp *= evalHelper(q, exp, answer);
////					answer = exp;
////				}
////			}
//			return evalHelper(q, exp, answer);
//		}
//	}
		
	/**
	 * Write a recursive function that accepts a stack of integers and
	 * replaces each int with two copies of that integer. For example,
	 * calling repeatStack and passing in a stack of { 1, 2, 3} would change
	 * the stack to hold { 1, 1, 2, 2, 3, 3}. Do not use any loops. Do not use
	 * any data structures other than the stack passed in as a parameter.
	 * @param stack
	 */
	public static void repeatStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int origLen = stack.size();
			repeatHelper(stack, origLen);
		}
	}
	
	private static void repeatHelper(Stack<Integer> stack, int origLen) {
		if (stack.size() == (origLen * 2)){ return;
		} else {
			stack.push(stack.lastElement());
			stack.push(stack.peek());
			repeatHelper(stack, origLen);
		}
	}

	/**
	 * Write a recursive function that accepts a Queue<Integer>. It
	 * should change every int in this queue to be double its original
	 * value. You may NOT use loops or any other data structures besides
	 * the queue passed in as a parameter. You may use a helper function.
	 * @param q
	 */
	public static void doubleElements(Queue<Integer> q) {
		int count = q.size();
		doubleHelper(q, count);
	}
	
	private static void doubleHelper(Queue<Integer> q, int count) {
		if (count == 0) { return;
		} else {
			int el = q.peek();
			q.remove();
			q.add(el * 2);
			doubleHelper(q, count - 1);
		}
	}

}
