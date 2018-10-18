import java.util.Observer;

public class Player {

    private String name;
    private DataCell[] cells = new DataCell[9];
    private String symbol;


    //TODO -- Determine the winner here.
    public boolean winner(){
        if ((cells[0].indicator && cells[1].indicator && cells[2].indicator)
        || (cells[3].indicator && cells[4].indicator && cells[5].indicator)
        ||(cells[6].indicator && cells[7].indicator && cells[8].indicator)
        ||(cells[0].indicator && cells[3].indicator && cells[6].indicator)
        ||(cells[1].indicator && cells[4].indicator && cells[7].indicator)
        ||(cells[2].indicator && cells[5].indicator && cells[8].indicator)
        ||(cells[0].indicator && cells[4].indicator && cells[8].indicator)
        ||(cells[2].indicator && cells[4].indicator && cells[6].indicator)){
            return true;
        }
        return false;
    }


    public Player(){
        this.name = "";
        this.symbol = "";
    }

    public Player(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
        for (int i = 0; i < 9; i++) {
            cells[i] = new DataCell();
        }
    }

    public void MarkCell( int cellNumber){
        cells[cellNumber].setSymbol(this.symbol);


    }
    public void register(Observer obs, int cellNumber){
        cells[cellNumber].registerObserver(obs);
    }


    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
  public DataCell[] getCells(){
        return cells;
  }
  public void setDataCell(DataCell[] cells){
        this.cells = cells;
  }
  public String getSymbol(){
        return symbol;
  }
  public void setSymbol(String symbol){
      this.symbol = symbol;
  }

}
