/*

COPYLIST
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example:
Given list
   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. 
The returned answer should not contain the same node as the original list, but a copy of them. 
The pointers in the returned list should not link to any node in the original input list.


*/
/*
Use a hashmap to store the mapping from oldListNode to the newListNode. 
Whenever you encounter a new node in the oldListNode (either via random pointer or through the next pointer ), 
create the newListNode, store the mapping. 
and update the next and random pointers of the newListNode using the mapping from the hashmap.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        HashMap<RandomListNode,RandomListNode> mappings = new HashMap<>();
        
        while(p!=null){
            if(!mappings.containsKey(p)){
                RandomListNode newNode = new RandomListNode(p.label);
                mappings.put(p,newNode);
                p=p.next;
            }
        }
        
        RandomListNode q = head;
        RandomListNode copyHead = null;
        while(q!=null){
            RandomListNode newNode = mappings.get(q);
            newNode.next = mappings.get(q.next);
            newNode.random = mappings.get(q.random);
            if(q==head)
                copyHead = newNode;
            q=q.next;
        }
        return copyHead;
    }
}

/* Another approach is as follows.

	
	Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A’->B->B’->C->C’
		i.e. make a copy of each node just ahead of every node in the original list.
	Step2: copy the random links: for each new node n’, n’.random = n.random.next
		i.e. take random pointers of node in original list and assign random nodes for the next node 
		(which is actually going to be the new list) in a similar manner.
	Step3: detach the list: basically n.next = n.next.next; n’.next = n’.next.next
	
	Here is a C++ implementation of the above approach:
	class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(head == NULL){
            return NULL;
        }

        // Step 1: create a new node for each existing node and join them together 
        // eg: A->B->C will be A->A'->B->B'->C->C'
        RandomListNode* node = head;
        while (node != NULL) {
            RandomListNode* copyNode = new RandomListNode(node->label);
            RandomListNode* nextNode = node->next;
            node->next = copyNode;
            copyNode->next = nextNode;
            node = nextNode;
        }

        // Step2: copy the random links: for each new node n', 
        // n'.random = n.random.next
        node = head;
        while(node != NULL) {
            RandomListNode* copyNode = node->next;
            if(node->random != NULL)
                copyNode->random = node->random->next;
            else
                copyNode->random = NULL;
            node = copyNode->next;
        }

        // Step3: detach the list: 
        // basically n.next = n.next.next; n'.next = n'.next.next
        node = head;
        RandomListNode* copyNode = node->next;
        RandomListNode* copyHead = head->next;
        while(copyNode != NULL && node != NULL) {
            node->next = node->next->next;
            if (copyNode->next == NULL) {
                break;
            }
            copyNode->next = copyNode->next->next;

            copyNode = copyNode->next;
            node = node->next;
        }

        return copyHead;
    }
};

*/