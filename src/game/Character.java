package game;

import javafx.scene.image.Image;

public class Character {
    private String name;
    private Image image;

    public Character(String _name, Image _image) {
        name = _name;
        image = _image;
    }

    public String getName() {return name;}
    public Image getImage() {return image;}

    public void setName(String _name) {name = _name;}
    public void setImage(Image _image) {image = _image;}
}
