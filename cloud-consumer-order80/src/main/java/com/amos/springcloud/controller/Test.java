package com.amos.springcloud.controller;

import java.util.Random;
import java.util.Scanner;

/**
 * @PackageName: com.amos.springcloud.controller
 * @ClaseName: Test
 * @Description: Test
 * @Author: zhaoyg
 * @Date: 2022/3/18 20:18
 * @params *@params $
 */

public class Test {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("请出拳：剪刀或者石头或者布");
            String myChoice = sc.next(); //用户输入
            int randomNumber=new Random().nextInt(3)+1;
            // 默认 1代表剪刀 2代表石头 3代表布
            switch (myChoice) {
                case "石头":
                    System.out.println("你出的是石头");
                    switch (randomNumber){
                        case 1:
                            System.out.println("电脑出的是剪刀\n你赢了！");
                            break;
                        case 2:
                            System.out.println("电脑出的是石头\n平局！");
                            break;
                        case 3:
                            System.out.println("电脑出的是布\n你输了！");
                            break;
                    }
                    break;
                case "剪刀":
                    System.out.println("你出的是剪刀");
                    switch (randomNumber){
                        case 1:
                            System.out.println("电脑出的是剪刀\n平局！");
                            break;
                        case 2:
                            System.out.println("电脑出的是石头\n你输了！");
                            break;
                        case 3:
                            System.out.println("电脑出的是布\n你赢了！");
                            break;
                    }
                    break;
                case "布":
                    System.out.println("你出的是布");
                    switch (randomNumber){
                        case 1:
                            System.out.println("电脑出的是剪刀\n你输了！");
                            break;
                        case 2:
                            System.out.println("电脑出的是石头\n你赢了！");
                            break;
                        case 3:
                            System.out.println("电脑出的是布\n平局！");
                            break;
                    }
                    break;
                default:
                    System.out.println("请按提示正确输入！");
                    break;
            }

    }
}
