package monsterzoo;

public class Distance {
    double distance=0.0;//歩いた距離

    //距離の更新を行う
    public void updateDistance(){
        this.distance++;
    }

    //距離を表示する処理
    public void printDistance(){
        System.out.println(this.distance+"km歩いた．");
    }
}

