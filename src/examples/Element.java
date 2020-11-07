package examples;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import examples.GameStage;

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
            case FLAG_TYPE:
                this.img = FLAG_IMAGE;
                break;
            case BOMB_TYPE:
                this.img = BOMB_IMAGE;
                break;
            case LAND_TYPE:
                this.img = LAND_IMAGE;
                break;
        }
        // call the functions that sets the image and handles the events
        this.setImageView();
//        this.handleEvents;
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


    protected ImageView getImageView(){
        return this.imgView;
    }

    // implement the necessary setters
    private void setImageView(){

    }
    // implement the functions that initializes the image view of this element and the event handlers you need


}
