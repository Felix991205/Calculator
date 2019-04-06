import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;


public class Calculator extends Frame implements ActionListener{

    //part 1 Frame上面的部分
    private Label resultWindow;


    //part 2 Frame中间的部分（包括一个panel和5个按钮）
    private Panel middlePanel;
    private CalculatorButton buttonMemoryPlus;
    private CalculatorButton buttonMemoryMinus;
    private CalculatorButton buttonMemorySave;
    private CalculatorButton buttonMemoryRead;
    private CalculatorButton buttonMemoryClear;

    private CalculatorButton buttonExp10;
    private CalculatorButton buttonExp;
    private CalculatorButton buttonSin;
    private CalculatorButton buttonCos;
    private CalculatorButton buttonTan;

    private CalculatorButton buttonLog;
    private CalculatorButton buttonLn;
    private CalculatorButton buttonArcsin;
    private CalculatorButton buttonArccos;
    private CalculatorButton buttonArctan;

    private CalculatorButton buttonPower;
    private CalculatorButton buttonFact;
    private CalculatorButton buttonMod;
    private CalculatorButton buttonPi;
    private CalculatorButton buttonE;


    //part 3 Frame下面的部分（包括一个panel和24个按钮）
    private Panel bottomPanel;
    private CalculatorButton[] buttonNum;
    private CalculatorButton buttonAdd;
    private CalculatorButton buttonSub;
    private CalculatorButton buttonMul;
    private CalculatorButton buttonDiv;
    private CalculatorButton buttonPoint;
    private CalculatorButton buttonEqual;
    private CalculatorButton buttonPercent;
    private CalculatorButton buttonSquareRoot;
    private CalculatorButton buttonSquare;
    private CalculatorButton buttonReciprocal;
    private CalculatorButton buttonClearEntry;
    private CalculatorButton buttonClear;
    private CalculatorButton buttonBackspace;
    private CalculatorButton buttonPosiOrNega;

    // Other members 其他的一些属性、包括第一个操作数、第二个操作数、操作符、历史结果、小数点、小数点位数
    private Double operand1;
    private Double operand2;
    private Integer operator;
    private Double history;
    private Boolean point;
    private Integer point_bit;
    private Stack<Double> memory;

    // 类构造方法
    public Calculator(){
        super("Calculator");
        //调用成员变量初始化方法
        Initialization();
        //调用GUI界面设置方法
        FrameLayout();

        this.pack();
        this.setVisible(true);
    }


    // 成员变量初始化方法
    private void Initialization(){
        operand1 = null;
        operand2 = null;
        operator = null;
        history = null;
        point = false;
        point_bit = 0;
        memory = new Stack<Double>();

        resultWindow = new Label("", 2);

        middlePanel = new Panel();
        buttonMemoryClear = new CalculatorButton("MC", this, 10);
        buttonMemoryRead = new CalculatorButton("MR", this, 11);
        buttonMemoryPlus = new CalculatorButton("M+", this, 12);
        buttonMemoryMinus = new CalculatorButton("M-", this, 13);
        buttonMemorySave = new CalculatorButton("MS", this, 14);

        buttonExp10 = new CalculatorButton("10^x", this, 60);
        buttonExp = new CalculatorButton("e^x", this, 61);
        buttonSin = new CalculatorButton("sin(x)", this, 62);
        buttonCos = new CalculatorButton("cos(x)", this, 63);
        buttonTan = new CalculatorButton("tan(x)", this, 64);

        buttonLog = new CalculatorButton("log(x)", this, 65);
        buttonLn = new CalculatorButton("ln(x)", this, 66);
        buttonArcsin = new CalculatorButton("arcsin(x)", this, 67);
        buttonArccos = new CalculatorButton("arccos(x)", this, 68);
        buttonArctan = new CalculatorButton("arctan(x)", this, 69);

        buttonPower = new CalculatorButton("pow(x,y)", this, 70);
        buttonFact = new CalculatorButton("x!", this, 71);
        buttonMod = new CalculatorButton("x mod y", this, 72);
        buttonPi = new CalculatorButton("Pi", this, 73);
        buttonE = new CalculatorButton("e", this, 74);


        bottomPanel = new Panel();
        buttonNum = new CalculatorButton[10];
        for(int i = 0; i < 10; i++){
            buttonNum[i] = new CalculatorButton(String.valueOf(i), this, i);
        }
        buttonAdd = new CalculatorButton("+", this, 20);
        buttonSub = new CalculatorButton("-", this, 21);
        buttonMul = new CalculatorButton("*", this, 22);
        buttonDiv = new CalculatorButton("/", this, 23);

        buttonEqual = new CalculatorButton("=", this, 30);
        buttonPoint = new CalculatorButton(".", this, 31);
        buttonPosiOrNega = new CalculatorButton("+/-", this, 32);
        buttonPercent = new CalculatorButton("%", this, 33);

        buttonSquareRoot = new CalculatorButton("x^(1/2)", this, 40);
        buttonSquare = new CalculatorButton("x^2", this, 41);
        buttonReciprocal = new CalculatorButton("1/x", this, 42);

        buttonClearEntry = new CalculatorButton("CE", this, 50);
        buttonClear = new CalculatorButton("C", this, 51);
        buttonBackspace = new CalculatorButton("backspace", this, 52);
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

    }

    // GUI界面设置方法
    private void FrameLayout(){
        // 设定布局
        this.setLayout(new GridLayout(3, 1));

        // 在GUI上增加元件
        this.add(resultWindow);
        this.add(middlePanel);
        this.add(bottomPanel);

        middlePanel.setLayout(new GridLayout(4, 5));
        middlePanel.add(buttonMemoryClear);
        middlePanel.add(buttonMemoryRead);
        middlePanel.add(buttonMemoryPlus);
        middlePanel.add(buttonMemoryMinus);
        middlePanel.add(buttonMemorySave);
        middlePanel.add(buttonExp10);
        middlePanel.add(buttonExp);
        middlePanel.add(buttonSin);
        middlePanel.add(buttonCos);
        middlePanel.add(buttonTan);
        middlePanel.add(buttonLog);
        middlePanel.add(buttonLn);
        middlePanel.add(buttonArcsin);
        middlePanel.add(buttonArccos);
        middlePanel.add(buttonArctan);
        middlePanel.add(buttonPower);
        middlePanel.add(buttonFact);
        middlePanel.add(buttonMod);
        middlePanel.add(buttonPi);
        middlePanel.add(buttonE);

        bottomPanel.setLayout(new GridLayout(6, 4));
        bottomPanel.add(buttonPercent);
        bottomPanel.add(buttonSquareRoot);
        bottomPanel.add(buttonSquare);
        bottomPanel.add(buttonReciprocal);
        bottomPanel.add(buttonClearEntry);
        bottomPanel.add(buttonClear);
        bottomPanel.add(buttonBackspace);
        bottomPanel.add(buttonDiv);
        bottomPanel.add(buttonNum[7]);
        bottomPanel.add(buttonNum[8]);
        bottomPanel.add(buttonNum[9]);
        bottomPanel.add(buttonMul);
        bottomPanel.add(buttonNum[4]);
        bottomPanel.add(buttonNum[5]);
        bottomPanel.add(buttonNum[6]);
        bottomPanel.add(buttonSub);
        bottomPanel.add(buttonNum[1]);
        bottomPanel.add(buttonNum[2]);
        bottomPanel.add(buttonNum[3]);
        bottomPanel.add(buttonAdd);
        bottomPanel.add(buttonPosiOrNega);
        bottomPanel.add(buttonNum[0]);
        bottomPanel.add(buttonPoint);
        bottomPanel.add(buttonEqual);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof CalculatorButton){
            CalculatorButton source = (CalculatorButton) e.getSource();
            switch(source.getCode()){
                // 如果按钮是数字
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    //todo:当数字太大了进行处理！
                    if(point == true){
                        point_bit++;
                        if(operand2 == null && operator == null){
                            if(operand1 == null)
                                operand1 = 0.0;

                            //if (operand1 * 10 + source.getCode() < 10000000)
                            operand1 = operand1 + Math.pow(10, -1 * point_bit) * source.getCode();
                            this.resultWindow.setText(String.format("%8.5f", operand1));
                            break;
                        }else if(operator != null){
                            if(operand2 == null)
                                operand2 = 0.0;

                            //if (operand2 * 10 + source.getCode() < 10000000)
                            operand2 = operand2 + Math.pow(10, -1 * point_bit) * source.getCode();
                            this.resultWindow.setText(String.format("%8.5f", operand2));
                            break;
                        }
                    }else{
                        if(operand2 == null && operator == null){

                            if(operand1 == null)
                                operand1 = 0.0;

                            //if (operand1 * 10 + source.getCode() < 10000000)
                            operand1 = operand1 * 10 + source.getCode();
                            this.resultWindow.setText(String.format("%8.5f", operand1));
                            break;
                        }else if(operator != null){
                            if(operand2 == null)
                                operand2 = 0.0;
                            //if (operand2 * 10 + source.getCode() < 10000000)
                            operand2 = operand2 * 10 + source.getCode();
                            this.resultWindow.setText(String.format("%8.5f", operand2));
                            break;
                        }
                    }

                    // 如果按钮是运算符
                case 20:
                case 21:
                case 22:
                case 23:
                case 70:
                case 72:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;

                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 != null){
                        if(operator == 20){
                            operand1 = operand1 + operand2;
                        }else if(operator == 21){
                            operand1 = operand1 - operand2;
                        }else if(operator == 22){
                            operand1 = operand1 * operand2;
                        }else if(operator == 23){
                            operand1 = operand1 / operand2;
                        }else if(operator == 70){
                            operand1 = Math.pow(operand1, operand2);
                        }else if(operator == 72){
                            operand1 = Main.Modulo(operand1, operand2);
                        }
                        operand2 = null;
                        operator = source.getCode();
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operator = source.getCode();
                    }
                    break;

                // 如果运算符是等号
                case 30:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand2 != null){
                        if(operator == 20){
                            operand1 = operand1 + operand2;
                        }else if(operator == 21){
                            operand1 = operand1 - operand2;
                        }else if(operator == 22){
                            operand1 = operand1 * operand2;
                        }else if(operator == 23){
                            operand1 = operand1 / operand2;
                        }else if(operator == 70){
                            operand1 = Math.pow(operand1, operand2);
                        }else if(operator == 72){
                            operand1 = Main.Modulo(operand1, operand2);
                        }
                        operand2 = null;
                        operator = null;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                        history = operand1;
                        operand1 = null;

                    }
                    break;
                // 小数点
                case 31:
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null && operand1 != null){
                        if(operand1 - operand1.intValue() >= 1e-6){
                            operand1 = 0.0;
                            this.resultWindow.setText(String.format("%8.5f", operand1));
                        }
                    }else if(operand2 != null){
                        if(operand2 - operand2.intValue() >= 1e-6){
                            operand2 = 0.0;
                            this.resultWindow.setText(String.format("%8.5f", operand2));
                        }
                    }
                    point = true;
                    point_bit = 0;
                    break;
                // 正负变换
                case 32:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = -1 * operand1;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else if(operand2 != null){
                        operand2 = -1 * operand2;
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                // 百分号
                case 33:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = 0.01 * operand1;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else if(operand2 != null){
                        operand2 = 0.01 * operand2;
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;

                // 平方根、平方、倒数
                case 40:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.pow(operand1, 0.5);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.pow(operand2, 0.5);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 41:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.pow(operand1, 2);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.pow(operand2, 2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 42:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        if(operand1 != null)
                            operand1 = Math.pow(operand1, -1);
                        else
                            operand1 = Math.pow(operand1, -1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.pow(operand2, -1);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;

                // "CE"
                case 50:
                    if(operand1 == null){
                        history = 0.0;
                        this.resultWindow.setText(String.format(""));
                    }
                    if(operand1 != null && operand2 == null){
                        operand1 = 0.0;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else if(operand2 != null){
                        operand2 = 0.0;
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    point = false;
                    point_bit = 0;
                    break;
                // "C"
                case 51:
                    point = false;
                    point_bit = 0;
                    operand1 = null;
                    operand2 = null;
                    operator = null;
                    history = null;
                    this.resultWindow.setText("");
                    memory.clear();
                    break;
                // "BackSpace"
                case 52:
                    if(operand1 == null){
                        history = 0.0;
                        this.resultWindow.setText(String.format(""));
                    }
                    if(operand1 != null && operand2 == null){
                        operand1 = 0.0;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else if(operand2 != null){
                        operand2 = 0.0;
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    point = false;
                    point_bit = 0;
                    // 科学计算60-74
                case 60:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.pow(10, operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.pow(10, operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 61:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.exp(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.exp(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 62:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.sin(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.sin(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 63:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.cos(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.cos(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 64:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.tan(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.tan(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 65:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.log10(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.log10(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 66:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.log1p(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.log1p(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 67:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.asin(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.asin(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 68:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.acos(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.acos(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 69:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.atan(operand1);
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.atan(operand2);
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;

                case 71:
                    if(history == null && operand1 == null)
                        return;
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        if(operand1 - operand1.intValue() <= 1e-6){
                            operand1 = Main.Factorial(operand1.intValue()).doubleValue();
                            this.resultWindow.setText(String.format("%8.5f", operand1));
                        }
                    }else{
                        if(operand2 - operand2.intValue() <= 1e-6){
                            operand2 = Main.Factorial(operand2.intValue()).doubleValue();
                            this.resultWindow.setText(String.format("%8.5f", operand2));
                        }
                    }
                    break;
                case 73:
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.PI;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.PI;
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 74:
                    point = false;
                    point_bit = 0;
                    if(operand1 == null)
                        operand1 = history;
                    if(operand2 == null){
                        operand1 = Math.E;
                        this.resultWindow.setText(String.format("%8.5f", operand1));
                    }else{
                        operand2 = Math.E;
                        this.resultWindow.setText(String.format("%8.5f", operand2));
                    }
                    break;
                case 10:
                    memory.clear();
                    break;
                case 11:
                    if(history == null && operand1 == null)
                        break;
                    else if(history != null && operand1 == null){
                        if(!memory.empty()){
                            operand1 = memory.peek();
                            this.resultWindow.setText(String.format("%8.5f", operand1));
                        }
                    }else if(operand1 != null && operand2 == null && operator == null){

                        if(!memory.empty()){
                            operand1 = memory.peek();
                            this.resultWindow.setText(String.format("%8.5f", operand1));
                        }
                    }else if(operand1 != null && operand2 == null && operator != null){
                        if(!memory.empty()){
                            operand2 = memory.peek();
                            this.resultWindow.setText(String.format("%8.5f", operand2));
                        }
                    }else if(operand2 != null){
                        if(!memory.empty()){
                            operand2 = memory.peek();
                            this.resultWindow.setText(String.format("%8.5f", operand2));
                        }
                    }
                    break;
                case 12:
                    if(history == null && operand1 == null || memory.empty())
                        break;
                    else if(history != null && operand1 == null){
                        double temp = memory.pop() + history;
                        memory.push(temp);
                    }else if(operand1 != null && operand2 == null){
                        double temp = memory.pop() + operand1;
                        memory.push(temp);
                    }else if(operand2 != null){
                        double temp = memory.pop() + operand2;
                        memory.push(temp);
                    }
                    break;
                case 13:
                    if(history == null && operand1 == null || memory.empty())
                        break;
                    else if(history != null && operand1 == null){
                        double temp = memory.pop() - history;
                        memory.push(temp);
                    }else if(operand1 != null && operand2 == null){
                        double temp = memory.pop() - operand1;
                        memory.push(temp);
                    }else if(operand2 != null){
                        double temp = memory.pop() - operand2;
                        memory.push(temp);
                    }
                    break;
                case 14:
                    if(history == null && operand1 == null)
                        break;
                    else if(history != null && operand1 == null)
                        memory.push(history);
                    else if(operand1 != null && operand2 == null)
                        memory.push(operand1);
                    else if(operand2 != null)
                        memory.push(operand2);
                    break;
            }

        }else{

        }
    }
}
