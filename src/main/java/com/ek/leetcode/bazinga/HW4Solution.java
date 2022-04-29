package com.ek.leetcode.bazinga;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HW4Solution {
    //Constructor
    public HW4Solution() {

    }

    //Implement the exchange function
    public void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //Implement Fisher-Yates shuffle algorithm
    public void fisherYatesShuffle(int[] A) throws InterruptedException {
//        long seed = System.currentTimeMillis();
        Random rnd = new Random();
        for (int i = A.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i+1);
//            System.out.printf("seed(%d), rnd(%d), %d, %d\n", seed, (i+1), i, j);
            exchange(A, i, j);
        }
    }

    //Implement bad shuffle algorithm
    public void badRandomShuffle(int[] A) {
//        long seed = System.currentTimeMillis();
        Random rnd = new Random();
        for ( int i = 0; i < A.length - 1; i++ ){
            int j = rnd.nextInt(A.length);
//            System.out.printf("%d, %d\n", i, j);
            exchange(A, i, j);
        }
    }

    public int[] generateInitArray(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i + 1;
        }
        return A;
    }

    public void permute(List<int[]> permList, int[] A, int start){
        if (start == A.length) {
            permList.add(Arrays.copyOf(A, A.length));
//            System.out.println(Arrays.toString(A));
        } else {
            for (int i = start; i < A.length; ++i) {
                exchange(A, start, i); //  exchange index
                permute(permList, A, start + 1); // recursion
                exchange(A, start, i); // exchange back
            }
        }
    }

    public void provePermutationProbability(int n, int count, String algorithm) throws InterruptedException, IOException {
        //Generate array with n different elements
        int[] A = this.generateInitArray(n);
        System.out.print("A: ");
        System.out.println(Arrays.toString(A));

        //Generate n! permutation list
        List<int[]> permList = new ArrayList<int[]>();
        this.permute(permList, A,0);

        //run many many times, each time shuffle the array using certain algorithm

        //check the number appears in the certain position, then count+1
        // positionCount[numberIndex][position]
        int[][] positionCount = new int[n][n];
        for (int i = 0; i < positionCount.length; i++) {
            for (int j = 0; j < positionCount[i].length; j++) {
                positionCount[i][j] = 0;
            }
        }

        //check the shuffled array match which permutation, then count+1
        //save all counts into permCount
        //permCount[permIndex]
        int[] permCount = new int[permList.size()];
        for (int i = 0; i < permCount.length; i++) {
            permCount[i] = 0;
        }

        for (int i = 0; i < count; i++) {
            Thread.sleep(1); //Sleep 1 milliseconds for make sure random seed is different
            int[] arr = Arrays.copyOf(A, A.length);
            if (algorithm == "Fisher-Yates") {
                this.fisherYatesShuffle(arr);
//                System.out.println(Arrays.toString(arr));
            } else if (algorithm == "Bad-Shuffle") {
                this.badRandomShuffle(arr);
//                System.out.println(Arrays.toString(arr));
            }

            //save to positionCount
            for (int m = 0; m < arr.length; m++) {
                for (int k = 0; k < A.length; k++) {
                    if (arr[m] == A[k]) {
                        positionCount[k][m] += 1;
                    }
                }
            }

            //save to permCount
            for (int j = 0; j < permList.size(); j++) {
                if (Arrays.equals(arr, permList.get(j))) {
                    permCount[j] += 1;
                }
            }
        }
        for (int i = 0; i < positionCount.length; i++) {
            System.out.printf("Number %d appears in the ith position's count: ", A[i]);
            System.out.println(Arrays.toString(positionCount[i]));
        }
        System.out.printf("Permutation count: ");
        System.out.println(Arrays.toString(permCount));

        //save to file
        String fileName = algorithm + "_" + n + "_" + count + ".dat";
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,false);
            for (int i = 0; i < permCount.length; i++) {
                fw.write(Integer.toString(i+1));
                fw.write(" ");
                fw.write(Integer.toString(permCount[i]));
                fw.write("\r\n");
            }
            fw.flush();
            fw.close();
        } catch(IOException ex) {
            if (fw != null) {
                fw.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        HW4Solution solution = new HW4Solution();

        System.out.println("Bad-Shuffle Algorithm");
        solution.provePermutationProbability(3, 1000, "Bad-Shuffle");
        solution.provePermutationProbability(5, 100000, "Bad-Shuffle");

        System.out.println("Fisher-Yates Algorithm");
        solution.provePermutationProbability(3, 100000, "Fisher-Yates");
        solution.provePermutationProbability(5, 100000, "Fisher-Yates");
    }
}
