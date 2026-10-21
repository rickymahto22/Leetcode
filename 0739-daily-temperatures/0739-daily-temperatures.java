class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] warmerDays = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                warmerDays[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return warmerDays;
    }
}