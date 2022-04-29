package com.ek.leetcode.bazinga.iit.CS430;

import java.util.Arrays;
import java.util.Random;

public class MergeSortSolution {

    //Constructor of merge sort solution
    public MergeSortSolution() {

    }

    //Compare two doubles, if a == b then return true
    public boolean isDoubleEqual(Double a, Double b) {
        if (a > b) {

        }
        return (Math.abs(a-b) < 0.000000000000000001);
    }

    //Compare two doubles, if a <= b then return true
    public boolean isDoubleLessEqual(double a, double b) {
        return (a < b || (Math.abs(a-b) < 0.000000000000000001));
    }

    //Generate random list, the seed is current system time in milliseconds
    public double[] generateRandList(int count, long seed) {
        double[] list = new double[count];
        if (count > 0) {
            Random rnd = new Random(seed);
            for (int i = 0; i < count; i++) {
                list[i] = rnd.nextDouble();
            }
        }
        return list;
    }

    public double[] generateRandListNoSeed(int count) {
        double[] list = new double[count];
        if (count > 0) {
            Random rnd = new Random();
            for (int i = 0; i < count; i++) {
                list[i] = rnd.nextDouble();
            }
        }
        return list;
    }

    //Implenent the merge sort algorithm
    public void mergeSort(double[] A, int p, int r) {
        if (p < r) {
            //calculate the floor of p+r/2
            int q = (int)(Math.floor((p+r)/2.0));
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    //Implement the merge process
    public void merge(double[] A, int p, int q, int r) {
        int n1 = q - p + 1; //size of left array
        int n2 = r - q; //size of right array
        //init left array and right array
        double[] L = new double[n1];
        double[] R = new double[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p+i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q+1+j];
        }
        //merge left array and right array
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (i < L.length && j < R.length) {
                if (this.isDoubleLessEqual(L[i], R[j])) {
                    A[k] = L[i];
                    i = i + 1;
                } else {
                    A[k] = R[j];
                    j = j + 1;
                }
            } else if ( i < L.length) {
                A[k] = L[i];
                i = i + 1;
            } else {
                A[k] = R[j];
                j = j + 1;
            }
        }
    }

    //Prove the random list is uniform distributed
    public void proveRandUniformDistribution(Long seed) {
        System.out.println("Prove random uniform distributed. Avg count of each zone is 100000");
        int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        double[] list;
        if (seed == null) {
            list = this.generateRandListNoSeed(1000000);
        } else {
            list = this.generateRandList(1000000, seed);
        }
        for (int i = 0; i < list.length; i++) {
            if (this.isDoubleLessEqual(list[i], 0.1)) {
                counts[0] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.2)) {
                counts[1] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.3)) {
                counts[2] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.4)) {
                counts[3] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.5)) {
                counts[4] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.6)) {
                counts[5] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.7)) {
                counts[6] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.8)) {
                counts[7] += 1;
            } else if (this.isDoubleLessEqual(list[i], 0.9)) {
                counts[8] += 1;
            } else {
                counts[9] += 1;
            }
        }
        System.out.println(Arrays.toString(counts));
    }

    //Run merge sort one time
    public void runMergeSort(int count) {
        if (count <= 0) return;
        //generate random list
        long seed = System.currentTimeMillis();
        double[] list = this.generateRandList(count, seed);
        System.out.print(count);
        System.out.print(":");
        long t1 = System.currentTimeMillis();
        // run merge sort
        this.mergeSort(list, 0, list.length - 1);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    // Prove merge sort time cost
    public void proveMergeSort() {
        System.out.println("Run merge sort with different size of array. count:time cost");
        for (int i = 1000; i <= 100000000; i = i*10) {
            this.runMergeSort(i);
        }
//        for (int i = 1; i <= 1000000; i++) {
//            this.runMergeSort(i);
//        }
    }

    public static void main(String[] args) throws Exception {
        MergeSortSolution solution = new MergeSortSolution();
        solution.proveRandUniformDistribution(null);
        System.out.println(" have seed :");
        solution.proveRandUniformDistribution(System.currentTimeMillis());
//        solution.proveMergeSort();
    }
}
