package hw01.task1.calc;

import java.io.Serializable;

public class Number implements Calculable, Serializable {

    final private int a, b;

    public Number(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int calc(){
        return a * b;
    }

}
