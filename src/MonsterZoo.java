package monsterzoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

//モンスターズーに関する処理前半を行う
public class MonsterZoo {
    Item item = new Item();
    Distance distance = new Distance();
    Monster monster = new Monster();
    Egg egg = new Egg();


    //モンスターズーをプレイし、ボールがなくなったら捕まえたモンスターのリストを返す処理
    ArrayList<String> play(){
        Boolean existBalls = true; //ボールがあるかどうかの判定を入れる変数
		monster.registerMonsterZukan();    //モンスター図鑑に登録する処理

        while(existBalls){ //1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続け、手持ちのボールが無くなったら終了
			try {
				Thread.sleep(1000);
                this.move();
                item.printItems();
	            distance.printDistance();
                existBalls = item.existBalls();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        return monster.userMonster;
    }


	//呼び出すと1km distanceとeggDistaceが増える
	void move(){
		distance.updateDistance();
		egg.updateEggDistance();

		int flg1 = this.randomSelect(10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1 <= 1)
			this.zooStation();
		else if(flg1 >= 7)
			this.encountMonster();
		egg.eggsState(monster.monsterZukan,monster.userMonster); //卵の状態を確認する
	}


	//ズーstationでの処理  ボール、フルーツ、卵をゲットする可能性がある
	void zooStation(){
		int b,f,e;
		System.out.println("ズーstationを見つけた！");
		item.getItems(b=this.randomSelect(3),f=this.randomSelect(2));
		e=this.randomSelect(2);
		System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個，"+"卵を"+e+"個Getした！");
		if(e >= 1 && egg.egg.size() < 10) egg.setEgg();
    }


	//モンスターが出現する時の処理
    void encountMonster(){
    	//nowSituationは0番目に戦闘を続行するか、1番目にモンスターをゲットしたかを保持している
    	ArrayList <Boolean> nowSituation = new ArrayList<Boolean>(Arrays.asList(true,false));
        int m = this.randomSelect(monster.monsterZukan.size());//monsterZukanからランダムにモンスターを出す

        String monsterName = monster.monsterZukan.get(m).tempMonster; //1行が長くなるので変数に入れる
        System.out.println(monsterName+"が現れた！");

        //捕まえる or 3回ボールを投げるまで繰り返す
        IntStream.range(0, item.balls)
        .filter(i -> (i < 3 && nowSituation.get(0)))
        .forEach(i -> {
        	int r = rProbabilitySelect();
            item.throwBalls(monsterName);
            if(monster.monsterZukan.get(m).tempMonsterRare<=r){//monsterRare[m]の値がr以下の場合モンスターをゲットできる
            	monster.getMonster(monsterName);
            	IntStream.range(0, nowSituation.size()).forEach(j -> nowSituation.set(j,!nowSituation.get(j)));
            }
        });

        //モンスターを捕まえられなかった時の処理
        if(!nowSituation.get(1))
        	System.out.println(monsterName+"に逃げられた！");

    }


    //ランダムでモンスターが捕まえられる確率を返す処理
    private int rProbabilitySelect() {
    	int r = this.randomSelect(6);//0~5までの数字をランダムに返す
    	if(item.fruits>0) r = item.throwFruits(r);
    	return r;
    }


    //ランダムで数字を選ぶ処理
	int randomSelect(int num){
		return (int)(num*Math.random());
	}
}
