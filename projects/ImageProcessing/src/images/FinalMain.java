package images;

import images.controller.BasicController;
import images.controller.Controllers;
import images.controller.FeatureController;
import images.controller.Features;
import images.model.BasicModel;
import images.model.ImageModel;
import images.view.BasicView;
import images.view.ImageView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Driver class of my mvc project. To show how my code works.
 */
public class FinalMain {
  /**
   * Main method to help run the code.
   *
   * @param args args
   */
  public static void main(String[] args) throws FileNotFoundException {

    ImageModel model = new BasicModel();
    ImageView view = new BasicView();
    if (args[0].equals("interactive")) {
      Features featureControl = new FeatureController(model);
      featureControl.setView(view);

    }
    else {
      Readable reader = new FileReader(args[0]);
      Controllers control = new BasicController(reader, System.out);
      try {
        control.start(model);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
