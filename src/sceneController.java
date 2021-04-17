
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
                    game.plusSelectCards();
                }
            }
            else if(game.getSelectStage()==1)
            {
               
                if(ComparableCard.isTwoCard(playerHand, playerHand.get(value).getValue())){
                    if(game.getSelectCards()==0||game.getValueCardsSellect()==playerHand.get(value).getValue())
                    {
                        paneList.get(value).getChildren().clear();
                        paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
                        game.plusSelectCards();
                        game.setValueCardsSellect(playerHand.get(value).getValue());
                    } 
                }
            }
            else if(game.getSelectStage()==2)
            {
                if(ComparableCard.isThreeCard(playerHand, playerHand.get(value).getValue())){
                    if(game.getSelectCards()==0||game.getValueCardsSellect()==playerHand.get(value).getValue()){
                        paneList.get(value).getChildren().clear();
                        paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
                        game.plusSelectCards();
                        game.setValueCardsSellect(playerHand.get(value).getValue());
                    }
                }
            }
            else if(game.getSelectStage()==3)
            {
                if(ComparableCard.isFourCard(playerHand, playerHand.get(value).getValue())){
                    if(game.getSelectCards()==0||game.getValueCardsSellect()==playerHand.get(value).getValue()){
                        paneList.get(value).getChildren().clear();
                        paneTopList.get(value).getChildren().add(playerHand.get(value).imageview);
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
            paneTopList.get(loop).getChildren().clear();
            paneList.get(loop).getChildren().clear();
            paneList.get(loop).getChildren().add(playerHand.get(loop).imageview);
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
    
    

    

   

}
