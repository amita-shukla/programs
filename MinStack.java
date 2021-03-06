/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.

Take another stack minStack, that is supposed to track the minimum element fro every push and pop.
When pushing, check if the element is less than the min element
When popping, check if the minimum element is popped out.
*/
class Solution {
    Stack<Integer> s;
    Stack<Integer> minStack;
    
    Solution(){
        s = new Stack<>();
        minStack = new Stack<>();
       
    }
    public void push(int x) {
        int minimum;
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            minimum = minStack.peek();
            if(x<minimum){
                minStack.push(x);    
            }
        }
        s.push(x);
    }

    public void pop() {
        int minimum;
        if(!minStack.isEmpty()){
            minimum = minStack.peek();
        if(minimum == s.peek())
            minStack.pop();
        if(!s.isEmpty())
            s.pop();
        }
    }

    public int top() {
        if(!s.isEmpty())
            return s.peek();
        else
            return -1;
    }

    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
