package com.gpmall.comment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwx
 * @date 2019/10/8
 */
public class test {
    // 1 核心思路   判断目标值和数组元素值之差的值是否之前放进过map中。如果匹配上就说明两个之和等于目标值，即我们要找的目标
    //  用来map.containsKey方法
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }




   //反转链表，重点是处理各自的前置节点和后置节点之间的关系。  重点是不能够脱链。
    /** 解决核心在于
     * 这个是一个反转链表的基本操作，保障了链表位置的互换。 这里针对m,n之间的元素，多次进行处理就能够达到反转效果
     curNext = cur.next;
     cur.next = curNext.next;
     curNext.next = curPre.next;
     curPre.next = curNext;
     */
    public static LinkNode reverseFromMtoN(LinkNode head, int m, int n){
        // 在头节点之前定义一个新的节点，preHead
        LinkNode preHead = new LinkNode(0);
        preHead.next = head;
        // 定义一个cur节点，让其从preHead开始，先找到第m-1个节点，作为curPre
        LinkNode cur = preHead;
        for(int i = 1; i < m; i++)
            cur = cur.next;
        LinkNode curPre = cur;
        cur = cur.next; // 现在cur为第m个节点
        // 从第m个节点到第n个节点，我们需要将n-m+1个节点进行翻转，那就是将n-m个节点插在第m个节点之前，因此需要n-m次操作
        // 进入循环之前需要定义一个curNext
        LinkNode curNext = null;
        for(int i = 0; i < n-m; i++){
            // 这个地方也可写成 for(int i = m; i < n; i++)
            curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = curPre.next;
            curPre.next = curNext;
        }
        // 结束后，输出preHead.next即可
        return preHead.next;
    }

     static class LinkNode{
        int val;
        LinkNode next;
        LinkNode(int val){
            this.val = val;
        }
    }
}
