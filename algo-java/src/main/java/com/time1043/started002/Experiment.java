package com.time1043.started002;

import java.util.Arrays;

/*
一开始有100个人，每个人都有100元
在每一轮都做如下的事情 :
每个人都必须拿出1元钱给除自己以外的其他人，给谁完全随机
如果某个人在这一轮的钱数为0，那么他可以不给，但是可以接收
发生很多很多轮之后，这100人的社会财富分布很均匀吗？
******************************************************
一个社会的基尼系数是一个在0~1之间的小数
基尼系数为0代表所有人的财富完全一样
基尼系数为1代表有1个人掌握了全社会的财富
基尼系数越小，代表社会财富分布越均衡；越大则代表财富分布越不均衡
在2022年，世界各国的平均基尼系数为0.44
目前普遍认为，当基尼系数到达 0.5 时
就意味着社会贫富差距非常大，分布非常不均匀
社会可能会因此陷入危机，比如大量的犯罪或者经历社会动荡
 */
public class Experiment {
    public static double calculateGini(double[] wealth) {
        double sumOfAbsoluteDifferences = 0;
        double sumOfWealth = 0;
        int numberOfPeople = wealth.length;
        for (double v : wealth) {
            sumOfWealth += v;
            for (double value : wealth) {
                sumOfAbsoluteDifferences += Math.abs(v - value);
            }
        }
        return sumOfAbsoluteDifferences / (2 * numberOfPeople * sumOfWealth);
    }

    private static void experiment(int numberOfPeople, int epoch) {
        double[] wealth = new double[numberOfPeople];
        Arrays.fill(wealth, 100);
        System.out.println("wealth before: " + Arrays.toString(wealth));

        boolean[] hasMoney = new boolean[numberOfPeople];
        for (int i = 0; i < epoch; i++) {
            Arrays.fill(hasMoney, false);
            for (int j = 0; j < numberOfPeople; j++) {
                if (wealth[j] > 0) hasMoney[j] = true;
            }
            for (int j = 0; j < numberOfPeople; j++) {
                if (hasMoney[j]) {
                    int other;
                    do {
                        other = (int) (Math.random() * numberOfPeople);
                    } while (other == j);
                    wealth[j]--;
                    wealth[other]++;
                }
            }
        }

        Arrays.sort(wealth);
        System.out.println("wealth after: " + Arrays.toString(wealth));
        System.out.println("Gini: " + calculateGini(wealth));

    }

    public static void main(String[] args) {
        int numberOfPeople = 100;
        int epoch = 10;
        experiment(numberOfPeople, epoch);
    }
}
