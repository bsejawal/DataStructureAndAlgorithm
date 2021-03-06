package com.bsejawal.algorithms.leetcode;

import com.bsejawal.algorithms.leetcode.node.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetcodeEasyAlgorithm {

    /**
     * https://leetcode.com/problems/two-sum/
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map<Integer, Integer> num_map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(num_map.containsKey(complement)){
                result[0] = num_map.get(complement);
                result[1] = i;
                return result;
            }else{
                num_map.put(nums[i], i);
            }
        }
        return result;
    }


    /**
     * https://leetcode.com/problems/reverse-integer/
     * @param n
     * @return reversed integer
     */
    public  int reverseInteger(int n) {
        int reversed = 0 ;
        while(n!=0){
            int tempReversed = (reversed * 10) + (n%10);
            if(tempReversed/10 != reversed)
                return 0;
            reversed = tempReversed;
            n = n/10;
        }
        return reversed;
    }

    /**
     * https://leetcode.com/problems/palindrome-number/
     * @param n
     * @return
     */
    public boolean isPalindromeNumber(int n) {
        if(n==0) // return true since only zero is palindrome
            return true;
        if(n<0 || n%10 == 0) // return false if any negative numbers and number divisible by 10
            return false;

        //reversing number
        int initialNumber = n;
        int reversed = 0;
        while(n!=0){
            int tempReversed = reversed * 10 + n%10;
            if(tempReversed/10 != reversed)
                return false;
            reversed = tempReversed;
            n/=10;
        }
        if(initialNumber == reversed)
            return true;


        return false;
    }

    /**
     * https://leetcode.com/problems/roman-to-integer/
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if(s.length()==0 || s.length()>15)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=0;
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(i>0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1)))
                    result += map.get(s.charAt(i)) - (2 * map.get(s.charAt(i-1)));
                else
                    result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    /**
     * https://leetcode.com/problems/longest-common-prefix/
     * @param strings
     * @return
     */
    public String longestCommonPrefix(String[] strings) {
        String prefix = "";
        if(strings.length == 0 || strings == null)
            return prefix;
        prefix = strings[0];

        for(int i=1; i<strings.length; i++){
            while(strings[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    /**
     * https://leetcode.com/problems/valid-parentheses/
     * @param s
     * @return
     */
    public boolean isValidParentheses(String s) {
        if(s.length()<2)
            return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if(c.equals('(') || c.equals('{') || c.equals('['))
                stack.push(c);
            else if(c.equals(')') && !stack.isEmpty() && stack.peek().equals('('))
                stack.pop();
            else if(c.equals('}') && !stack.isEmpty() && stack.peek().equals('{'))
                stack.pop();
            else if(c.equals(']') && !stack.isEmpty() && stack.peek().equals('['))
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }



    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoSortedLinkedLists(Node l1, Node l2) {
        Node headNode = new Node(0);
        Node currentNode = headNode;

        while(l1 !=null && l2 !=null){

            if(l1.val < l2.val){
                currentNode.next = l1;
                l1 = l1.next;
            }else{
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if(l1!=null){
            currentNode = l1;
        }
        if(l2 !=null){
            currentNode = l2;
        }
        return headNode.next;
    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * @param input
     * @return
     */
    public int removeDuplicatesFromSortedArray(int[] input) {

        int index=1;
        for(int i=0;i<input.length-1; i++){
            if(input[i] != input[i+1]){
                input[index++] = input[i+1];
            }
        }
        return index;
    }

    public int removeElement(int[] input, int i) {

        return 0;
    }
}
