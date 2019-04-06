import java.awt.*;

public class CalculatorButton extends Button{
    private int code;

    public CalculatorButton(String label, Calculator cal, int code){
        super(label);
        // 创建该button的调用者同时成为监听者
        this.addActionListener(cal);
        this.code = code;
    }

    public int getCode(){
        return code;
    }

}
