package TestMixedQuestions;

/*
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:
Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.

Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */

//from concept and coding

/*
Time complexity: O(n!)
Space complexity: O(n!)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Splitwise Simplify Debt Algorithm
//LLD of Splitwise
//Optimal Account Balancing
//using DFS and backtracking
public class OptimalAccountBalancing {

    public static void main(String[] args) {
        int[][] transactions = new int[][] {
                {0, 1, 10},
                {1, 0, 1},
                {1, 2, 5},
                {2, 0, 5}
        };

        int min = minTransactions(transactions);
        System.out.println(min);
    }

    static int minTransactions(int[][] transactions) {
        Map<Integer, Integer> memberVsBalanceMap = new HashMap<>();

        for(int[] transaction: transactions) {
            int from = transaction[0]; //give
            int to = transaction[1]; //get
            int amount = transaction[2];

            memberVsBalanceMap.put(from, memberVsBalanceMap.getOrDefault(from, 0) - amount); //'-' since from is giving
            memberVsBalanceMap.put(to, memberVsBalanceMap.getOrDefault(to, 0) + amount); //'+' since to is getting
        }

        List<Integer> balances = new ArrayList<>();
        for(int amount: memberVsBalanceMap.values()) {
            if(amount != 0) {
                balances.add(amount);
            }
        }

        return dfs(balances, 0);
    }

    static int dfs(List<Integer> balances, int currentIndex) {
        if(balances.size() == 0 || currentIndex >= balances.size()) {
            return 0;
        }

        if(balances.get(currentIndex) == 0) {
            return dfs(balances, currentIndex+1);
        }

        int currentValue = balances.get(currentIndex);
        int minTransactions = Integer.MAX_VALUE;

        for(int i = currentIndex+1; i < balances.size(); i++) {
            int nextValue = balances.get(i);
            if(currentValue*nextValue < 0) {
                balances.set(i, currentValue + nextValue);
                minTransactions = Math.min(minTransactions, 1 + dfs(balances, currentIndex+1));
                balances.set(i, nextValue); //backtracking to check if any other positive negative combination gives minimum result
            }

            if(currentValue + nextValue == 0) {
                break;
            }
        }

        return minTransactions;
    }
}
