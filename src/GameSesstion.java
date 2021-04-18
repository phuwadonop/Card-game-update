public class GameSesstion {
    
    private Boolean []statusButton={true,true,true,true};
    private int selectStage ;
    private int limitSelectCards ;
    private int selectCards;
    private int valueCardsSellect;
    private int stageGame;
    private int numPlayerhand;
    private int numCom1hand;
    private int numCom2hand;
    private int numCom3hand;
    private int []playerSelectIndex={0,0,0,0};
    private int []com1SelectIndex={0,0,0,0};
    private int []com2SelectIndex={0,0,0,0};
    private int []com3SelectIndex={0,0,0,0};
    private ComparableCard []CardsOnFieldPlayer={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    private ComparableCard []CardsOnFieldComOne={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    private ComparableCard []CardsOnFieldComTwo={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    private ComparableCard []CardsOnFieldComThree={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    
    public GameSesstion() {
        this.selectStage = 0;
        this.limitSelectCards = 1;
        this.selectCards=0;
        this.stageGame=0;
        this.numPlayerhand = 13;
        this.numCom1hand = 13;
        this.numCom2hand = 13;
        this.numCom3hand = 13;
    }

    public Boolean getStatusButton(int index) {
        return statusButton[index];
    }

    public void setStatusButtonfalse(int index) {
        this.statusButton[index] = false;
    }

    public void setStatusButtontrue(int index) {
        this.statusButton[index] = true;
    }

    public int getSelectStage() {
        return selectStage;
    }

    public void setSelectStage(int selectStage) {
        this.selectStage = selectStage;
    }

    public int getLimitSelectCards() {
        return limitSelectCards;
    }

    public void setLimitSelectCards(int limitSelectCards) {
        this.limitSelectCards = limitSelectCards;
    }

    public int getSelectCards() {
        return selectCards;
    }

    public void setSelectCards(int selectCards) {
        this.selectCards = selectCards;
    }

    
    public void plusSelectCards() {
        this.selectCards++;
    }
    

    public void decreaseSelectCards() {
        this.selectCards--;
    }

    public int getValueCardsSellect() {
        return valueCardsSellect;
    }

    public void setValueCardsSellect(int valueCardsSellect) {
        this.valueCardsSellect = valueCardsSellect;
    }

    public int getStageGame() {
        return stageGame;
    }

    public void setStageGame(int stageGame) {
        this.stageGame = stageGame;
    }

    public ComparableCard getCardsOnFieldPlayer(int index) {
        return CardsOnFieldPlayer[index];
    }

    public void setCardsOnFieldPlayer(ComparableCard cards,int index) {
        CardsOnFieldPlayer[index] = cards;
    }

    public ComparableCard getCardsOnFieldComThree(int index) {
        return CardsOnFieldComThree[index];
    }

    public void setCardsOnFieldComThree(ComparableCard cards,int index) {
        CardsOnFieldComThree[index] = cards;
    }

    public ComparableCard getCardsOnFieldComTwo(int index) {
        return CardsOnFieldComTwo[index];
    }

    public void setCardsOnFieldComTwo(ComparableCard cards,int index) {
        CardsOnFieldComTwo[index] = cards;
    }

    public ComparableCard getCardsOnFieldComOne(int index) {
        return CardsOnFieldComOne[index];
    }

    public void setCardsOnFieldComOne(ComparableCard cards,int index) {
        CardsOnFieldComOne[index] = cards;
    }

    public int getNumPlayerhand() {
        return numPlayerhand;
    }

    public void setNumPlayerhand(int numPlayerhand) {
        this.numPlayerhand = numPlayerhand;
    }

    public int getNumCom1hand() {
        return numCom1hand;
    }

    public void setNumCom1hand(int numCom1hand) {
        this.numCom1hand = numCom1hand;
    }

    public int getNumCom2hand() {
        return numCom2hand;
    }

    public void setNumCom2hand(int numCom2hand) {
        this.numCom2hand = numCom2hand;
    }

    public int getNumCom3hand() {
        return numCom3hand;
    }

    public void setNumCom3hand(int numCom3hand) {
        this.numCom3hand = numCom3hand;
    }

    public int getPlayerSelectIndex(int index) {
        return playerSelectIndex[index];
    }

    public void setPlayerSelectIndex(int index,int indexOfcard) {
        this.playerSelectIndex[index] = indexOfcard;
    }

    public int getCom1SelectIndex(int index) {
        return com1SelectIndex[index];
    }

    public void setCom1SelectIndex(int index,int indexOfcard) {
        this.com1SelectIndex[index] = indexOfcard;
    }

    public int getCom2SelectIndex(int index) {
        return com2SelectIndex[index];
    }

    public void setCom2SelectIndex(int index,int indexOfcard) {
        this.com2SelectIndex[index] = indexOfcard;
    }

    public int getCom3SelectIndex(int index) {
        return com3SelectIndex[index];
    }

    public void setCom3SelectIndex(int index,int indexOfcard) {
        this.com3SelectIndex[index] = indexOfcard;
    }

    public void decreasePlayerhand(int numDecrease) {
        this.numPlayerhand -=numDecrease;
    }

    
    
    
    
    
}
