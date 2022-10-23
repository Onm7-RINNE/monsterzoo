package monsterzoo;

//ボールとフルーツに関する処理
public class Item{
    int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ


	//手持ちのボールとフルーツの数を表示する処理
    public void printItems(){
    	System.out.println("手持ちのボールは"+this.balls+"個，フルーツは"+this.fruits+"個");
    }


    //ボールが存在するか判断する処理　あればtrue、なければfalseを返す
    public Boolean existBalls(){
    	Boolean flg = true;
        if(balls == 0) flg = false;
        return flg;
    }


    //アイテムを追加する処理
    public void getItems(int b,int f){
        this.balls=this.balls+b;
        this.fruits=this.fruits+f;
    }


    //フルーツを投げて、捕獲確率を上げる処理
    public int throwFruits(int r) {
    	System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
         this.fruits--;
         return r * 2;
    }


    //ボールを投げる処理
    public void throwBalls(String monsterName) {
    	System.out.println(monsterName+"にボールを投げた");
        this.balls--;
    }

}