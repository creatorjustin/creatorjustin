<?php
/**
 * 6 PHP functions requiring functions, assert, selection, and repetition.
 * Write asserts to test your code. We will have many  asserts when grading.
 * It is important to be able to test your own code 
 *
 * Programmer: Rick Mercer and Justin Taylor
 */


// function firstOf3Strings
// 
// Given three String arguments, return the String that alphabetically
// precedes or is equal to the other two string arguments
//  firstOf3Strings("a", "b", "c") returns "a"
//  firstOf3Strings("X", "b", "c") returns "X"
//  firstOf3Strings("123", "1232", "123 0") returns "123"
//
function firstOf3Strings($a, $b, $c) {    
    // Test this wth your own asserts
    return min($a, $b, $c);
}

// Write your own tests here.  We have about 50 asserts for these 6 functions.



/////////////////////////////////////////////////////////////////////////
// In mathematics, the greatest common divisor (GCD) of two or more
// integers, which are not all zero, is the largest positive integer
// that divides each of the integers. For example, GCD(2, 12) is 4.
//
// Euclid's solution to finding the GCD is refuted to be the first
// algorithm known to mankind. It is definitely old.
//
// GCD(a, b) can be computed as follows:
//
// while(b != 0):
//    other = a
//    a = b
//    b = other % b
//
// a is the GCD
//
// GCD(378, 378) returns 378
// GCD(378, 0) returns 378
// GCD(0, 378) returns 378
// GCD(11, 5) returns 1
// GCD(10, 5) returns 5
// GCD(25, 10) returns 5
//
// Precondition: a and b are >= 0 a and or b can be 0, but not both. 
// GCD(0, 0) is undefined. We do not have an assert for GCD(0,0).
//
function GCD($a, $b) {
    // Test this wth your own asserts
    if ($a == $b){
        return $a;
    }
    if ($a == 0){
        return $b;
    }
    if ($b == 0){
        return $a;
    }
    if ($a % $b == 0){
        return $b;
    }
    if ($b % $a == 0){
        return $a;
    }else{
        $least = min($a, $b);
        $gcd = 0;
        $i = 0;
        while ($i < $least){
            if ($a%i == 0 && $b%i == 0){
                $gcd = i;
            }
            $i += 1;
        }
        return $gcd;
    }
}

// Write your own tests here.  We have about 50 total asserts.


///////////////////////////////////////////////////////////////////////////////
// Function howSwedish()
//
// ABBA is a band, they have many songs including Dancing Queen, and
// Fernando. ABBA is actually a Swedish band, so if we wanted to find
// out howSwedish a String is, we could simply find out how many times
// the String contains the substring "abba". We want to look for this
// substring in a case insensitive manner. So "abba" counts, and so
// does "aBbA". We also want to check for overlapping abba's such as
// in the String "abbAbba" that contains "abba" twice.
//
// In short, return the number of times 'abba' occurs in sequence.
//
// howSwedish("ABBA a b b a") returns 1
// howSwedish("abbabba!") returns 2
// howSwedish('abbabba') returns 2);
//
// Precondition: The argument to sequence is always a string.
//
function howSwedish($str) {
    // Test this wth your own asserts
    if (strlen($str) < 4){
        return 0;
    }
    $num = 0;
    $i = 0;
    while ($i < strlen($str) - 3){
        if ($str[$i] == "a" || $str[$i] == "A"){
            if ($str[$i + 1] == "b" || $str[$i + 1] == "B"){
                if ($str[$i + 2] == "b" || $str[$i + 2] == "B"){
                    if ($str[$i + 3] == "a" || $str[$i + 3] == "A"){
                        $num += 1;
                    }
                }
            }
        }
        $i += 1;
    }
    return $num;
}

// Add your own tests here. We have about 50 asserts for these 6 functions.
assert(1 == howSwedish('xabbax'));
assert(0 == howSwedish('AbbbA'));
assert(1 == howSwedish('AbbaBb'));
assert(2 == howSwedish('bbAbbaAbbA'));
assert(0 == howSwedish(''));


/////////////////////////////////////////////////////////////////////////
// Function mirrorEnds()
//
// Complete method mirrorEnds that given a string, looks for a mirror
// image (backwards) string at both the beginning and end of the given
// string. In other words, zero or more characters at the very beginning
// of the given string, and at the very end of the string in reverse order
// (possibly overlapping). For example, "abXYZba" has the mirror end "ab".
//
// mirrorEnds("") returns ""
// mirrorEnds("abcde") returns ""
// mirrorEnds("a") returns "a"
// mirrorEnds("abca") "a"
// mirrorEnds("abba") returns "abba"
// mirrorEnds("abbA")) returns "" (case sensitive 'a' != 'A')
//
// Precondition: The argument to sequence is always a string.
function mirrorEnds($str) {
    // Test this wth your own asserts
    if (strlen($str) < 2){
        return $str;
    }
    $mirrorStr = "";
    $firstStr = "";
    $i = 0;
    while ($i < strlen($str)){
        $firstStr .= $str[$i];
        $secStr = "";
        $j = strlen($str) - 1;
        while ($j > -1){
            $secStr .= $str[$j];
            if ($secStr == $firstStr){
                $mirrorStr = $secStr;
            }
            $j -= 1;
        }
        $i += 1;
    }
    return $mirrorStr;
}

// Add your own tests here (reuse your own JS asserts maybe?)
assert('ab' == mirrorEnds('ab12ba'));
assert('racecar' == mirrorEnds('racecar'));
assert('' == mirrorEnds(''));
assert('l' == mirrorEnds('l'));
assert('' == mirrorEnds('ab12bA'));


/////////////////////////////////////////////////////////////////////////
// function isStringSorted
//
// Given a String, return true if the letters are in ascending order.
// Note: 'a' < 'b' and '5' < '8'
// isStringSorted("") returns true
// isStringSorted("a") returns true
// isStringSorted("abbcddef") returns true
// isStringSorted("123456") returns true
// isStringSorted("12321") returns false
function isStringSorted($str) {
    // Test this wth your own asserts
    if (strlen($str) < 2){
        return true;
    }
    $prev = $str[0];
    $i = 1;
    while ($i < strlen($str)){
        if ($str[$i] < $prev){
            return false;
        }
        $prev = $str[$i];
        $i += 1;
    }
    return true;
}

// Add your own tests here.



/////////////////////////////////////////////////////////////////////////
// Function maxBlock()
//
// Given a string argument, return the length of the largest "block" in the
// string sequence. A block is a run of adjacent characters that are the same.
//
// maxBlock("hoopla") returns 2 (has 'o's)
// maxBlock("abbCCCddBBBxx") returns 3  (has three 'C's and 3 'B's)
// maxBlock("BBbBbBCCC") returns 3 (thee 'C's, case sensitive)
// maxBlock("") returns 0
// maxBlock("1") returns 1
//
// Precondition: The argument to sequence is always a valid string.
// 
function maxBlock($str) {
    // Test this wth your own asserts
    if ($str == ""){
        return 0;
    }
    if (strlen($str) == 1){
        return 1;
    }
    
    $num = 0;
    $i = 0;
    while ($i < strlen($str)){
        $max = 0;
        $j = $i;
        while ($str[$j] == $str[$i] && $j < strlen($str)){
            $max += 1;
            if ($max > $num){
                $num = $max;
            }
            $j += 1;
        }
        $i += 1;
    }
    return $num;
}

// Add your own tests here (reuse your own JS asserts maybe?)

assert(1 == maxBlock('abc'));
assert(3 == maxBlock('abbbc'));
assert(4 == maxBlock('abbbcccc'));
assert(2 == maxBlock('droopy'));
assert(0 == maxBlock(''));


?>