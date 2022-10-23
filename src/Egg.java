package monsterzoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

//卵に関する処理をまとめたクラス
public class Egg {
	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，3km移動するとランダムでモンスターが孵る ramda式の中で代入したいので配列ではなくリストを使用
	ArrayList<Boolean> egg = new ArrayList<>();
	//移動するたびにeggDistanceに1.0kmずつ加算される ramda式の中で代入したいので配列ではなくリストを使用
	ArrayList<Double> eggDistance = new ArrayList<>();


	//卵の状態を確認し、eggDistanceが3の時に卵が孵る処理を行う
	public void eggsState(HashMap<Integer, TempMonster> monsterZukan, ArrayList<String> userMonster) {
        IntStream.range(0, this.egg.size())
        .filter(i -> this.eggDistance.get(i) >= 3)
        .forEach(i -> {
        	System.out.println("卵が孵った！");
        	this.newMonster(monsterZukan, userMonster); //新しいモンスターを追加
        	this.egg.remove(i);
        	this.eggDistance.remove(i);
        });
    }


	//モンスターが生まれた時の処理
	private void newMonster(HashMap<Integer,TempMonster> monsterZukan, ArrayList<String> userMonster) {
		int m = (int)(monsterZukan.size()*Math.random());
		System.out.println(monsterZukan.get(m).tempMonster+"が産まれた！");
		if(!userMonster.contains(monsterZukan.get(m).tempMonster))
			userMonster.add(monsterZukan.get(m).tempMonster);
	}


	//卵を1つ以上Getしたらegg[]に新しい卵データをセットする
	public void setEgg(){
		//現在持っている卵の数はリストのサイズでわかるのでif文で分岐をしていない
		IntStream.range(0, this.eggDistance.size()).forEach(i -> this.addEgg());
		if(this.eggDistance.size() == 0) this.addEgg();
    }


	//新しい卵を加える処理
	private void addEgg() {
		this.egg.add(true);
    	this.eggDistance.add(0.0);
	}


	//eggDistanceを増やす処理
	public void updateEggDistance(){
		IntStream.range(0, egg.size())
        .forEach(i -> this.eggDistance.set(i,eggDistance.get(i)+1.0));
	}
}
