import java.util.ArrayList;

import java.util.Observable;

import java.util.Observer;


public class DataCell extends Observable{

    private String symbol = "";
    public boolean indicator;
    private ArrayList<Observer> observers = new ArrayList<>();


    public void ObservableValue(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return symbol;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
        this.indicator = true;
        setChanged();
        notifyListeners();
    }

    public void registerObserver(Observer obs){
        this.observers.add(obs);
    }

    public void notifyListeners(){

        for (Observer obs : observers){
            obs.update(new DataCell(),symbol);
        }

    }


}
