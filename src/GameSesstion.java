public class GameSesstion {
    
    private Boolean []statusButton={true,true,true,true};
    private int selectStage ;
    private int limitSelectCards ;
    private int selectCards;
    private int valueCardsSellect;
    private int stageGame;
    ComparableCard []CardsOnFieldPlayer={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    ComparableCard []CardsOnFieldComOne={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    ComparableCard []CardsOnFieldComTwo={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    ComparableCard []CardsOnFieldComThree={new ComparableCard(),new ComparableCard(),new ComparableCard(),new ComparableCard()};
    
    public GameSesstion() {
        this.selectStage = 0;
        this.limitSelectCards = 1;
        this.selectCards=0;
        this.stageGame=0;
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

    
    
    
    
}
