package monsterzoo;

//モンスターに関連した処理を行うクラス
import java.util.ArrayList;
import java.util.HashMap;
public class Monster{
    //モンスター図鑑とユーザがゲットしたモンスターを入れる変数
	HashMap<Integer,TempMonster> monsterZukan = new HashMap<>();
    ArrayList<String> userMonster = new ArrayList<>();

    //モンスターデータを図鑑に登録するメソッド
	public void registerMonsterZukan(){
		monsterZukan.put(0,new TempMonster("イガキン",9));
		monsterZukan.put(1,new TempMonster("ナマチュウ",3));
		monsterZukan.put(2,new TempMonster("イガキン",1));
		monsterZukan.put(3,new TempMonster("リョージィ",2));
		monsterZukan.put(4,new TempMonster("アキモトン",5));
		monsterZukan.put(5,new TempMonster("ゴージマ",4));
		monsterZukan.put(6,new TempMonster("チュウデン",6));
		monsterZukan.put(7,new TempMonster("ヅカホン",8));
		monsterZukan.put(8,new TempMonster("ニシムラー",7));
		monsterZukan.put(9,new TempMonster("サコーデン",2));
		monsterZukan.put(10,new TempMonster("ウッチー",5));
		monsterZukan.put(11,new TempMonster("ハヤッシー",4));
		monsterZukan.put(12,new TempMonster("キーチー",3));
		monsterZukan.put(13,new TempMonster("リョクン",1));
		monsterZukan.put(14,new TempMonster("デコポン",6));
		monsterZukan.put(15,new TempMonster("カミサン",5));
		monsterZukan.put(16,new TempMonster("シスイ",1));
		monsterZukan.put(17,new TempMonster("ジョナ",7));
		monsterZukan.put(18,new TempMonster("ギダギダ",2));
		monsterZukan.put(19,new TempMonster("ミッツー",8));
		monsterZukan.put(20,new TempMonster("ゾエサン",5));
		monsterZukan.put(21,new TempMonster("キタバー",3));
    }

	//ユーザがゲットしたモンスターを登録
    public void getMonster(String monsterName) {
    	System.out.println(monsterName+"を捕まえた！");
        if(!this.userMonster.contains(monsterName))
        	this.userMonster.add(monsterName);
    }
}