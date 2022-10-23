package monsterzoo;

import java.util.ArrayList;

public class Main{
	public void run(){
		MonsterZoo monsterZoo = new MonsterZoo();
        ArrayList <String> userMonster = monsterZoo.play();//　ボールがなくなるまでモンスターズーをプレイ
        this.printNoBall();             //　ボールがなくなったことを表示
        this.printGetMonster(userMonster);         //　捕まえたモンスターを表示
	}

	//ボールがなくなったことを表示する
    private void printNoBall(){
        System.out.println("ボールがなくなった！");
    }

    //捕まえたモンスターを表示する処理
    public void printGetMonster(ArrayList<String> userMonster){
        userMonster.forEach(m -> System.out.println(m+"を捕まえた．"));
    }

    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }
}