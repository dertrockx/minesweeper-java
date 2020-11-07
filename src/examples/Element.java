package examples;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Element {
    private String type;
    protected Image img;
    protected ImageView imgView;
    protected GameStage gameStage;
    protected int row, col;


    public final static Image FLAG_IMAGE = new Image("images/flag.png",GameStage.CELL_WIDTH,GameStage.CELL_WIDTH,false,false);
    public final static Image BOMB_IMAGE = new Image("images/bomb.gif",GameStage.CELL_WIDTH,GameStage.CELL_WIDTH,false,false);
    public final static Image LAND_IMAGE = new Image("images/land.png",GameStage.CELL_WIDTH,GameStage.CELL_WIDTH,false,false);
    public final static int IMAGE_SIZE = 70;

    public final static String FLAG_TYPE = "flag";
    public final static String BOMB_TYPE = "bomb";
    public final static String LAND_TYPE = "land";
    public final static String LAND_FLAG_TYPE = "landToFlag";

    public Element(String type, GameStage gameStage) {
        this.type = type;
        this.gameStage = gameStage;

        // load the images depending on the type
        switch(type){
            case FLAG_TYPE: this.img = Element.FLAG_IMAGE; break;
            case BOMB_TYPE: this.img = Element.BOMB_IMAGE; break;
            case LAND_TYPE: this.img = Element.LAND_IMAGE; break;
        }
        // call the functions that sets the image and handles the events
        this.setImageView();
        this.setEventHanlders();
    }

    private void setEventHanlders(){
        Element el = this;
        this.imgView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                switch(el.getType()){
                    case Element.FLAG_TYPE:
                        System.out.println("Flag clicked!");
                        gameStage.setFlagClicked(true);
                        break;
                    case Element.LAND_TYPE:
                        System.out.println("Land clicked!");
                        if(!gameStage.isFlagClicked()){
                            if( !gameStage.isBomb(el)){
                                clearImage(el);
                            } else {
                                changeImage(el, Element.BOMB_IMAGE);
                                gameStage.flashGameOver();
                            }
                        } else {
                            changeImage(el, Element.FLAG_IMAGE);
                            el.setType(LAND_FLAG_TYPE);
                            gameStage.setFlagClicked(false);
                        }
                        break;
                    case Element.LAND_FLAG_TYPE:
                        changeImage(el, Element.LAND_IMAGE);
                        el.setType(LAND_TYPE);
                        break;
                }
            }
        });
    }

    private void setType(String type) {
        this.type = type;
    }

    private void clearImage(Element el){
        this.imgView.setImage(null);
    }

    private void changeImage(Element el, Image image){
        this.imgView.setImage(image);
    }


    String getType(){
        return this.type;
    }

    int getRow() {
        return this.row;
    }

    int getCol() {
        return this.col;
    }

    void initRowCol(int row, int col){
        this.row = row;
        this.col = col;
    }

    protected ImageView getImageView(){
        return this.imgView;
    }

    // implement the necessary setters
    private void setImageView(){
        this.imgView = new ImageView();
        this.imgView.setImage( this.img );
        this.imgView.setLayoutX(0);
        this.imgView.setLayoutY(0);
        this.imgView.setPreserveRatio(true);

        if( this.type.equals(Element.FLAG_TYPE)){
            this.imgView.setFitWidth(GameStage.FLAG_WIDTH);
            this.imgView.setFitHeight(GameStage.FLAG_HEIGHT);
        } else {
            this.imgView.setFitHeight(GameStage.CELL_HEIGHT);
            this.imgView.setFitWidth(GameStage.CELL_WIDTH);
        }

    }
    // implement the functions that initializes the image view of this element and the event handlers you need


}
