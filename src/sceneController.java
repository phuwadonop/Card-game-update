
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class sceneController {

    private ArrayList<ComparableCard> playerHand = new ArrayList<ComparableCard>();
    private ArrayList<ComparableCard> Com1Hand = new ArrayList<ComparableCard>();
    private ArrayList<ComparableCard> Com2Hand = new ArrayList<ComparableCard>();
    private ArrayList<ComparableCard> Com3Hand = new ArrayList<ComparableCard>(); 

    private ArrayList<javafx.scene.image.ImageView> imageviewButtonOn = new ArrayList<javafx.scene.image.ImageView>();
    private ArrayList<javafx.scene.image.ImageView> imageviewButtonOff = new ArrayList<javafx.scene.image.ImageView>();
    private ArrayList<javafx.scene.image.ImageView> imageviewButtonPush = new ArrayList<javafx.scene.image.ImageView>();
   
    private GameSesstion game = new GameSesstion();

    @FXML
    private ArrayList<Pane> paneList ;

    @FXML
    private ArrayList<Pane> paneTopList ;

    @FXML
    private ArrayList<Pane> BList ;

    @FXML
    private ArrayList<Pane> CardOnFieldPlayerList ;

    @FXML
    private ArrayList<Pane> CardOnFieldComthreeList ;
    
    @FXML
    private ArrayList<Pane> CardOnFieldComtwoList ;

    @FXML
    private ArrayList<Pane> CardOnFieldComoneList ;

    @FXML
    private Button buttom;

    ComparableCard CardsOnField;
 
    @FXML
    private Button enter;


    @FXML
    private void setUp(ActionEvent event){
       
        RandomHand rand = new RandomHand();
        this.playerHand = rand.getPlayerHand();
        this.Com1Hand = rand.getCom1Hand();
        this.Com2Hand = rand.getCom2Hand();
        this.Com3Hand = rand.getCom3Hand();
       
        for(int loop=0;loop<13;loop++)
        {
            paneTopList.get(loop).getChildren().clear();
            paneList.get(loop).getChildren().add(playerHand.get(loop).imageview);
        }
        
       
        CardsOnField = Com1Hand.get(5);

        game.setCardsOnFieldPlayer(Com1Hand.get(5),0);
        game.setCardsOnFieldPlayer(Com1Hand.get(4),1);
        game.setCardsOnFieldPlayer(Com1Hand.get(3),2);
        game.setCardsOnFieldPlayer(Com1Hand.get(2),3);

        game.setCardsOnFieldComThree(Com3Hand.get(5),0);
        game.setCardsOnFieldComThree(Com3Hand.get(4),1);
        game.setCardsOnFieldComThree(Com3Hand.get(3),2);
        game.setCardsOnFieldComThree(Com3Hand.get(2),3);

        game.setCardsOnFieldComTwo(Com2Hand.get(5),0);
        game.setCardsOnFieldComTwo(Com2Hand.get(4),1);
        game.setCardsOnFieldComTwo(Com2Hand.get(3),2);
        game.setCardsOnFieldComTwo(Com2Hand.get(2),3);

        game.setCardsOnFieldComOne(Com1Hand.get(9),0);
        game.setCardsOnFieldComOne(Com1Hand.get(8),1);
        game.setCardsOnFieldComOne(Com1Hand.get(7),2);
        game.setCardsOnFieldComOne(Com1Hand.get(6),3);
        
        for(int loop=0;loop<4;loop++)
        {
            CardOnFieldPlayerList.get(loop).getChildren().add(game.getCardsOnFieldPlayer(loop).getImageview());
            CardOnFieldComthreeList.get(loop).getChildren().add(game.getCardsOnFieldComThree(loop).getImageview());
            CardOnFieldComtwoList.get(loop).getChildren().add(game.getCardsOnFieldComTwo(loop).getImageview());
            CardOnFieldComoneList.get(loop).getChildren().add(game.getCardsOnFieldComOne(loop).getImageview());
        }

        imageviewButtonOn = SetpicMainPages.setpicOn();
        imageviewButtonOff = SetpicMainPages.setpicOff();
        imageviewButtonPush = SetpicMainPages.setpicPush();

        game.setSelectStage(game.getStageGame());
        for(int loop=0;loop<4;loop++)
        {
            BList.get(loop).getChildren().add(imageviewButtonOn.get(loop));
        }
        BList.get(game.getSelectStage()).getChildren().clear();
        BList.get(game.getSelectStage()).getChildren().add(imageviewButtonPush.get(game.getSelectStage()));
        fethButton();
        checkLimitCards();
        game.setSelectCards(0);  

        // TimeCount.count(3);
    }

    private void fethButton(){
        if(!ComparableCard.twoCardsOnHand(playerHand)){
            BList.get(1).getChildren().clear();
            BList.get(1).getChildren().add(imageviewButtonOff.get(1));
            game.setStatusButtonfalse(1);
        } 
        if(!ComparableCard.threeCardsOnHand(playerHand)){
            BList.get(2).getChildren().clear();
            BList.get(2).getChildren().add(imageviewButtonOff.get(2));
            game.setStatusButtonfalse(2);
        }
        if(!ComparableCard.fourCardsOnHand(playerHand)){
            BList.get(3).getChildren().clear();
            BList.get(3).getChildren().add(imageviewButtonOff.get(3));
            game.setStatusButtonfalse(3);
        } 

        if(game.getStageGame()==0){
            game.setStatusButtonfalse(1);
            BList.get(1).getChildren().clear();
            BList.get(1).getChildren().add(imageviewButtonOff.get(1));
            game.setStatusButtonfalse(3);
            BList.get(3).getChildren().clear();
            BList.get(3).getChildren().add(imageviewButtonOff.get(3));
        }
        else if(game.getStageGame()==1){
            game.setStatusButtonfalse(0);
            BList.get(0).getChildren().clear();
            BList.get(0).getChildren().add(imageviewButtonOff.get(0));
            game.setStatusButtonfalse(2);
            BList.get(2).getChildren().clear();
            BList.get(2).getChildren().add(imageviewButtonOff.get(2));
        }
        else if(game.getStageGame()==2){
            game.setStatusButtonfalse(0);
            BList.get(0).getChildren().clear();
            BList.get(0).getChildren().add(imageviewButtonOff.get(0));
            game.setStatusButtonfalse(1);
            BList.get(1).getChildren().clear();
            BList.get(1).getChildren().add(imageviewButtonOff.get(1));
            game.setStatusButtonfalse(3);
            BList.get(3).getChildren().clear();
            BList.get(3).getChildren().add(imageviewButtonOff.get(3));
        }

    }

    public void checkLimitCards(){ 
        game.setLimitSelectCards(game.getStageGame()+1);
    }

    @FXML
    private void clickonCards(MouseEvent event)
    {   
        fethButton();
        
        int value = Integer.parseInt(((Pane)event.getSource()).getId());
        
        System.out.println("Select : "+game.getSelectCards()+" Limit : "+game.getLimitSelectCards());
       if(game.getSelectCards()<game.getLimitSelectCards()) {
            if(game.getSelectStage()==0)
            {
                if(playerHand.get(value).checkValue1(CardsOnField)==1)
                {
                    paneList.get(value).getChildren().clear();
                    paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
                    game.setPlayerSelectIndex(game.getSelectCards(),value);
                    game.plusSelectCards();
                }
            }
            else if(game.getSelectStage()==1)
            {
               
                if(ComparableCard.isTwoCard(playerHand, playerHand.get(value).getValue())){
                    if((game.getSelectCards()==0&&playerHand.get(value).checkValue1(CardsOnField)==1)||game.getValueCardsSellect()==playerHand.get(value).getValue())
                    {
                        
                        paneList.get(value).getChildren().clear();
                        paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
                        game.setPlayerSelectIndex(game.getSelectCards(),value);
                        game.plusSelectCards();
                        game.setValueCardsSellect(playerHand.get(value).getValue());
                    } 
                }
            }
            else if(game.getSelectStage()==2)
            {
                if(ComparableCard.isThreeCard(playerHand, playerHand.get(value).getValue())){
                    if((game.getSelectCards()==0&&playerHand.get(value).checkValue1(CardsOnField)==1)||game.getValueCardsSellect()==playerHand.get(value).getValue()){
                        paneList.get(value).getChildren().clear();
                        paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
                        game.setPlayerSelectIndex(game.getSelectCards(),value);
                        game.plusSelectCards();
                        game.setValueCardsSellect(playerHand.get(value).getValue());
                    }
                }
            }
            else if(game.getSelectStage()==3)
            {
                if(ComparableCard.isFourCard(playerHand, playerHand.get(value).getValue())){
                    if((game.getSelectCards()==0&&playerHand.get(value).checkValue1(CardsOnField)==1)||game.getValueCardsSellect()==playerHand.get(value).getValue()){
                        paneList.get(value).getChildren().clear();
                        paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
                        game.setPlayerSelectIndex(game.getSelectCards(),value);
                        game.plusSelectCards();
                        game.setValueCardsSellect(playerHand.get(value).getValue());
                    }
                }
            }
       }
        
        
    }

    @FXML
    private void clickonCardsTop(MouseEvent event)
    {
        int value = Integer.parseInt(((Pane)event.getSource()).getId());
        paneTopList.get(value).getChildren().clear();
        paneList.get(value).getChildren().add(playerHand.get(value).imageview);
        game.decreaseSelectCards();
       
    }

    @FXML
    private void selectStange(MouseEvent event)
    {
        for(int loop=0;loop<13;loop++){
            if(playerHand.get(loop).getStatus()==true)
            {
                paneTopList.get(loop).getChildren().clear();
                paneList.get(loop).getChildren().clear();
                paneList.get(loop).getChildren().add(playerHand.get(loop).imageview);
            }
        }
        
        int value = Integer.parseInt(((Pane)event.getSource()).getId());


        if(game.getStatusButton(value))
        {
            BList.get(game.getSelectStage()).getChildren().clear();
            BList.get(game.getSelectStage()).getChildren().add(imageviewButtonOn.get(game.getSelectStage()));
            BList.get(value).getChildren().clear();
            BList.get(value).getChildren().add(imageviewButtonPush.get(value));

            game.setSelectStage(value);
            game.setLimitSelectCards(value+1);
            game.setSelectCards(0);
            System.out.println(game.getSelectStage());
            
        }
        
    }

    @FXML
    private void playerEnterCard(ActionEvent event){
        
        if(game.getStageGame()==0){
            paneTopList.get(game.getPlayerSelectIndex(0)).getChildren().clear();
            CardOnFieldPlayerList.get(0).getChildren().add(playerHand.get(game.getPlayerSelectIndex(0)).imageview);
            CardsOnField = playerHand.get(game.getPlayerSelectIndex(0));
            playerHand.get(game.getPlayerSelectIndex(0)).setStatus(false);
            game.decreasePlayerhand(1);
        }
        else if(game.getStageGame()==1){
            paneTopList.get(game.getPlayerSelectIndex(0)).getChildren().clear();
            paneTopList.get(game.getPlayerSelectIndex(1)).getChildren().clear();
            CardOnFieldPlayerList.get(0).getChildren().add(playerHand.get(game.getPlayerSelectIndex(0)).imageview);
            CardOnFieldPlayerList.get(1).getChildren().add(playerHand.get(game.getPlayerSelectIndex(1)).imageview);
            if(playerHand.get(game.getPlayerSelectIndex(0)).checkValue1(playerHand.get(game.getPlayerSelectIndex(0)))==1){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(0));
            }
            else{
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(1));
            }
            playerHand.get(game.getPlayerSelectIndex(0)).setStatus(false);  
            playerHand.get(game.getPlayerSelectIndex(1)).setStatus(false);  
            game.decreasePlayerhand(2);
        }
        else if(game.getStageGame()==2){
            paneTopList.get(game.getPlayerSelectIndex(0)).getChildren().clear();
            paneTopList.get(game.getPlayerSelectIndex(1)).getChildren().clear();
            paneTopList.get(game.getPlayerSelectIndex(2)).getChildren().clear();
            CardOnFieldPlayerList.get(0).getChildren().add(playerHand.get(game.getPlayerSelectIndex(0)).imageview);
            CardOnFieldPlayerList.get(1).getChildren().add(playerHand.get(game.getPlayerSelectIndex(1)).imageview);
            CardOnFieldPlayerList.get(2).getChildren().add(playerHand.get(game.getPlayerSelectIndex(2)).imageview);
            if(ComparableCard.findMaxSuit3(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)))==1){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(0));
            }
            else if(ComparableCard.findMaxSuit3(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)))==2){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(1));
            }
            else if(ComparableCard.findMaxSuit3(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)))==3){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(2));
            }
            playerHand.get(game.getPlayerSelectIndex(0)).setStatus(false);  
            playerHand.get(game.getPlayerSelectIndex(1)).setStatus(false); 
            playerHand.get(game.getPlayerSelectIndex(2)).setStatus(false);
            game.decreasePlayerhand(3);   
           
        }
        else if(game.getStageGame()==3){
            paneTopList.get(game.getPlayerSelectIndex(0)).getChildren().clear();
            paneTopList.get(game.getPlayerSelectIndex(1)).getChildren().clear();
            paneTopList.get(game.getPlayerSelectIndex(2)).getChildren().clear();
            paneTopList.get(game.getPlayerSelectIndex(3)).getChildren().clear();
            CardOnFieldPlayerList.get(0).getChildren().add(playerHand.get(game.getPlayerSelectIndex(0)).imageview);
            CardOnFieldPlayerList.get(1).getChildren().add(playerHand.get(game.getPlayerSelectIndex(1)).imageview);
            CardOnFieldPlayerList.get(2).getChildren().add(playerHand.get(game.getPlayerSelectIndex(2)).imageview);
            CardOnFieldPlayerList.get(3).getChildren().add(playerHand.get(game.getPlayerSelectIndex(3)).imageview);
            if(ComparableCard.findMaxSuit4(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)),playerHand.get(game.getPlayerSelectIndex(3)))==1){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(0));
            }
            else if(ComparableCard.findMaxSuit4(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)),playerHand.get(game.getPlayerSelectIndex(3)))==2){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(1));
            }
            else if(ComparableCard.findMaxSuit4(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)),playerHand.get(game.getPlayerSelectIndex(3)))==3){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(2));
            }
            else if(ComparableCard.findMaxSuit4(playerHand.get(game.getPlayerSelectIndex(0)), playerHand.get(game.getPlayerSelectIndex(1)), playerHand.get(game.getPlayerSelectIndex(2)),playerHand.get(game.getPlayerSelectIndex(3)))==4){
                CardsOnField = playerHand.get(game.getPlayerSelectIndex(3));
            }
            playerHand.get(game.getPlayerSelectIndex(0)).setStatus(false);  
            playerHand.get(game.getPlayerSelectIndex(1)).setStatus(false); 
            playerHand.get(game.getPlayerSelectIndex(2)).setStatus(false);
            playerHand.get(game.getPlayerSelectIndex(3)).setStatus(false);
            game.decreasePlayerhand(4);   

        }
        game.setSelectCards(0);  
        fethButton();
        System.out.println(CardsOnField);
        System.out.println(game.getNumPlayerhand());
       
       
    }
    
    

    

   

}
