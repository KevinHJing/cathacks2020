package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Character {
    private String name;
    private ImagePattern icon;
    private String imagePath;
    private Dialog[] characterDialogs;

    public Character(String _name, String imagePath) {
        name = _name;
        this.setIcon(imagePath);
    }

    public void setIcon(String path) {
        this.imagePath = path;
        Image image = new Image(getClass().getResourceAsStream(this.imagePath));
        this.icon = new ImagePattern(image);
    }

    public Dialog getDialog(int index) { return characterDialogs[index]; }
    public String getName() {return name;}
    public String getImagePath() {return imagePath;}

    public void setName(String _name) {name = _name;}
    public void setImagePath(String _image_path) {imagePath = _image_path;}
}
