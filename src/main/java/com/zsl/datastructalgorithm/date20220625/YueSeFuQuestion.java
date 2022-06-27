package com.zsl.datastructalgorithm.date20220625;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫斯问题
 *
 *  约瑟夫问题（有时也称为约瑟夫斯置换），是一个出现在计算机科学和数学中的问题。在计算机编程的算法中，类似问题又称为约瑟夫环。
 *  人们站在一个等待被处决的圈子里。 计数从圆圈中的指定点开始，并沿指定方向围绕圆圈进行。 在跳过指定数量的人之后，执行下一个人。 对剩下的人重复该过程，从下一个人开始，朝同一方向跳过相同数量的人，直到只剩下一个人，并被释放。
 *  问题即，给定人数、起点、方向和要跳过的数字，选择初始圆圈中的位置以避免被处决。
 *
 * @Author zsl
 * @Date 2022/6/25 19:37
 * @Email 249269610@qq.com
 */
public class YueSeFuQuestion {


    public static void main(String[] args) {
        int latestPerson = findLatestPerson(10, 2);
        System.out.println("约瑟夫斯问题, 剩余最后一人编号：" + latestPerson);
    }

    /**
     * 约瑟夫斯问题代码实现
     */
    public static int findLatestPerson(int len, int step) {
        // 创建虚拟编号
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(i + 1);
        }

        // 寻找逻辑
        int index = 0;
        while (list.size() > 1) {
            //  下一位
            index = index + step;

            // 处理边界值
            if (index > list.size() - 1) {
                index = index - list.size();
            }
            list.remove(index);
        }
        return list.get(0);
    }


}
