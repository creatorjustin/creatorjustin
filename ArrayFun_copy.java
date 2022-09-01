/*
 * This class has three methods related by the fact that CSC 210 students are
 * learning the Java array object. The unit test has three @Test methods
 * that barely test methods below. You will have to write as many assertions as
 * needed to ensure the methods here are correct. Use EclEmma for code coverage.
 * 
 * @author Rick Mercer and Justin Taylor
 */
public class ArrayFun {

	///////////////////////////////////////////////////////////////////////////////
	// public static int numberOfPairs(String[] array)
	//
	// Return the number of times a pair occurs in array. A pair is any two String
	// values that are equal (case sensitive) in consecutive array elements. The
	// array may be empty or have only one element, in these cases return 0.
	//
	// numberOfPairs( {"a", "b", "c" } ) returns 0
	// numberOfPairs( {"abc", "abc", "abc"} ) returns 2
	// numberOfPairs( {"123", "123", "def", "def" } ) returns 2
	// numberOfPairs( {"a", "A", "B", "b" } ) returns 0 (case sensitive)
	// numberOfPairs( { } ) returns 0
	// numberOfPairs( {"a"} ) returns 0
	//
	public static int numberOfPairs(String[] array) {
		// TODO Complete this method
		if (array == null || array.length < 2) {
			return 0;
		}
		int numPairs = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].equals(array[i + 1])) {
				numPairs++;
			}
		}
		return numPairs;
	}

	///////////////////////////////////////////////////////////////////////////////
	// public static int howMany(String[] array, String valueToFind)
	//
	// Complete method howMany to return the number of elements in an array of
	// Strings that equals valueToFind. Do not use ==. This is case sensitive.
	// The array may be empty.
	//
	// howMany( {"A", "a", "A", "a" }, "A" ) returns 2
	// howMany( {"Abc", "abc", "Abc", "abc", "Abc" }, "Abc" ) returns 3 (case
	/////////////////////////////////////////////////////////////////////////////// sensitive)
	// howMany( {"And", "there", "goes", "another"}, "another" ) returns 1
	// howMany( {"And", "there", "goes", "another"}, "Not Here" ) returns 0
	// howMany( { }, "empty array" ) returns 0
	//
	public static int howMany(String[] array, String valueToFind) {
		// TODO Complete this method
		if (array.length == 0) {
			return 0;
		}
		int howMany = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(valueToFind)) {
				howMany++;
			}
		}
		return howMany;
	}

	///////////////////////////////////////////////////////////////////////////////
	// public static int maxSpan(int[] nums)
	//
	// Consider the leftmost and rightmost appearances of some value in an array.
	// We'll say that the "span" is the number of elements between the two
	// inclusive. A single value has a span of 1. Return the largest span found
	// in the given array.
	//
	// maxSpan({ 1, 2, 1, 1, 3 }) returns 4 (index 0 through index 3)
	// maxSpan({ 1, 4, 2, 1, 4, 1, 4 }) returns 6 (index 0 through index 5)
	// maxSpan({ 5, 5, 5, 5 }) returns 4 (index 0 through index 3)
	// maxSpan({ 99 }) returns 1 (index 0 through index 0)
	// maxSpan({ }) returns 0 (an empty array)
	//
	public static int maxSpan(int[] nums) {
		// TODO Complete this method
		if (nums.length == 0) {
			return 0;
		}
		int maxSpan = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > -1; j--) {
				if (nums[j] == nums[i]) {
					if (j - i > maxSpan) {
						maxSpan = j - i;
					}
				}
			}
		}
		return maxSpan + 1;
	}

}
