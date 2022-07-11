package com.zsl.datastructalgorithm.date20220711;

/**
 * 递归树课后题
 *  $1$个细胞的⽣命周期是$3$⼩时，$1$⼩时分裂⼀次。求$n$⼩时 后，
 *  容器内有多少细胞？请你⽤已经学过的递归时间复杂度的分析⽅ 法，分析⼀下这个递归问题的时间复杂度。
 * @author zsl
 * @date 2022/7/11 21:04
 */
public class RecursionTreeProblem {

    public static void main(String[] args) {
        System.out.println(splitCell(1, 6));
    }

    /**
     * 分裂细胞
     * @param startSize 其实容量
     * @param duration 周期
     * @return 分裂细胞数
     */
    public static int splitCell(int startSize, int duration) {
        if (duration == 0) {
            return startSize;
        }

        int i = --duration;
        return startSize * (split(2, i) + split(3, i));
    }

    /**
     * 分裂
     * @param live 存活时间
     * @param duration 周期
     */
    public static int split(int live, int duration) {
        // 分裂时间为0则返回
        if (duration == 0) {
            return 1;
        }

        // 分裂三次后，停止
        if (live == 0) {
            return 0;
        }

        int duration1 = --duration;
        int live1 = live;

        return split(--live1, duration1) + split(3, duration1);
    }
}
