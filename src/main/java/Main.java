import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) throws IOException {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        File imgPath = new File("sources\\" + name);
        File newimgPath = new File("my_algo_results\\" + name);
        String fileExt = BackwardTracingService.getFileExt(newimgPath.getName());
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        final int w = bufferedImage.getWidth();
        final int h = bufferedImage.getHeight();
        int[][] image = new int[h][w];
        int[][] im = new int[4*w*h][4];
        int[] rgb = bufferedImage.getRGB(0, 0, w, h, null, 0, w);
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(BackwardTracingService.rgbRange(rgb[(i*w)+j], rgb[10])){
                    image[i][j] = 0;
                }
                else{
                    image[i][j] = 1;
                }
            }
        }
        List<Point> b = BackwardTracingService.getContourPoints(image);
        for(int i=0; i<b.size(); i++){
            rgb[(w * b.get(i).getY()) + b.get(i).getX()] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() + 1] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() - 1] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() + 2] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() - 2] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() + 3] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() - 3] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() + 4] = -16726016;
            rgb[(w * b.get(i).getY()) + b.get(i).getX() - 4] = -16726016;

        }
        BufferedImage newImage = new BufferedImage(w, h, bufferedImage.getType());
        newImage.setRGB(0, 0, w, h, rgb, 0, w);
        ImageIO.write(newImage, fileExt, newimgPath);
    }
}
