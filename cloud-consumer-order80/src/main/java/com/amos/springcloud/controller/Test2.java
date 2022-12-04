package com.amos.springcloud.controller;

import java.util.Random;

/**
 * @PackageName: com.amos.springcloud.controller
 * @ClaseName: Test2
 * @Description: Test2
 * @Author: zhaoyg
 * @Date: 2022/3/23 23:16
 * @params *@params $
 */

public class Test2 {

    public static void main(String[] args) {
        // 乱数の初期化処理です。以下の１行は編集しないでください。
        Random rand = new Random();
        // 以下に解答を入力してください。
        int comA = new Random().nextInt(3)+1;
        // 1为石头  2为剪刀  3为布
        switch (comA) {
            case 1:
                System.out.println("コンピュータA:石头");
                break;
            case 2:
                System.out.println("コンピュータA:剪刀");
                break;
            case 3:
                System.out.println("コンピュータA:布");
                break;
        }
        int comB = new Random().nextInt(3)+1;
        switch (comB) {
            case 1:
                System.out.println("コンピュータB:石头");
                break;
            case 2:
                System.out.println("コンピュータB:剪刀");
                break;
            case 3:
                System.out.println("コンピュータB:布");
                break;
        }

        int mp =  comA - comB;

        switch (mp) {
            case -1:
            case 2:
                System.out.println("comA赢了！");
                break;
            case 0:
                System.out.println("平局");
                break;
            case 1:
            case -2:
                System.out.println("comB赢了！");
                break;
        }

    }
}
