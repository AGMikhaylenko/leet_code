package easy.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * Runtime 100% Memory 51.82%
 */
public class ImplementStackUsingQueues {

    class MyStack {

        private Queue<Integer> queue;
        private Queue<Integer> buf;

        public MyStack() {
            queue = new LinkedList<>();
            buf = new LinkedList<>();
        }

        public void push(int x) {
            fillQueueFromQueue(queue, buf);
            queue.add(x);
            fillQueueFromQueue(buf, queue);
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

        private void fillQueueFromQueue(Queue<Integer> q1, Queue<Integer> q2){
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
        }
    }
}
