package TP.TP2;

public class Observer {
    private int nbOp = 0;
    private int deep = 0;
    private int maxDeep = 0;
    public void enter() {
        ++deep;
        if (deep > maxDeep){
            maxDeep = deep;
        }
    }
    public void exit() {
        --deep;
    }
    public void operate(){
        ++nbOp;
    }
    @Override
    public String toString() {
        return "nb op : [" + nbOp + "] " + "Max deep : [" + maxDeep + "]";
    }
}
