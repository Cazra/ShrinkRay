package shrinkray;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/** A program that reduces the dimensions of all jpg image files in the current directory by 50%.*/
public class ShrinkRay {
  
  public static final String OUT_FOLDER = "shrinkray";
  
  public static void main(String[] args) {
    
    try {
      
      List<File> jpgFiles = new ArrayList<>();
    
      // Get the source directory.
      String targetDirectory = ".";
      if(args.length == 1) {
        targetDirectory = args[0];
      }
      
      // Create the strinkray output directory if needed.
      File destDir = new File(targetDirectory + File.separator + OUT_FOLDER);
      if(!destDir.exists()) {
        destDir.mkdir();
      }
      
      // Get all jpg files in the target directory.
      File dir = new File(targetDirectory);
      for(File file : dir.listFiles()) {
        if(file.getName().endsWith("jpg")) {
          jpgFiles.add(file);
        }
      }
      
      // Resize and write the image files.
      for(File file : jpgFiles) {
        System.out.println("Processing " + file.getPath());
        BufferedImage img = ImageIO.read(file);
        img = reduceImage(img);
        
        File destFile = new File(destDir + File.separator + file.getName());
        System.out.println("Outputing to " + destFile.getPath());
        ImageIO.write(img, "jpg", destFile);
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    
  }
  
  
  public static BufferedImage reduceImage(BufferedImage src) {
    BufferedImage resized = new BufferedImage(src.getWidth()/2, src.getHeight()/2, src.getType());
    Graphics2D g = resized.createGraphics();
    g.scale(0.5, 0.5);
    g.drawImage(src, 0, 0, null);
    g.dispose();
    
    return resized;
  }
  
}
