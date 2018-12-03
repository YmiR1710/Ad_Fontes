import java.util.LinkedList;
import java.util.List;

public class SqaureTracingService {
    public static List getContourPoints(int[][] srcImage) {
        int[][] image = srcImage.clone();
        clearBorder(image);

        List<Point> points = new LinkedList<Point>();

        Point startingPoint = getStartingPoint(image);
        Point currentPoint = startingPoint.getClone();

        do {
            if (image[currentPoint.getY()][currentPoint.getX()] == 1) {
                points.add(currentPoint.getClone());
                currentPoint.advanceToLeft();
            } else {
                currentPoint.advanceToRight();
            }

        } while (!startingPoint.equals(currentPoint));

        return points;
    }

    private static Point getStartingPoint(int[][] image) {

        for (int y = image.length - 1; y >= 0; y--) {

            for (int x = image[y].length - 1; x >= 0; x--) {

                if (image[y][x] == 1) {
                    return new Point(x, y);
                }

            }
        }

        return null;
    }

    private static void clearBorder(int[][] image) {

        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                if (y == 0 || x == 0 || y == image.length - 1 || x == image[y].length - 1) {
                    image[y][x] = 0;
                }

            }

        }

    }
    public static String getFileExt(String filename)
    {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1)
            return null;
        return filename.substring(dotIndex+1);
    }
    public static boolean rgbRange(int rgb1, int rgb2){
        int r1 = (rgb1 >> 16) & 0xff;
        int g1  = (rgb1 >> 8) & 0xff;
        int b1 = rgb1 & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2  = (rgb2 >> 8) & 0xff;
        int b2 = rgb2 & 0xff;
        int check = 0;
        int measure = 31;
        if(r1 - r2 < measure && r1 - r2 > -measure){
            check++;
        }
        if(g1 - g2 < measure && g1 - g2 > -measure){
            check++;
        }
        if(b1 - b2 < measure && b1 - b2 > -measure){
            check++;
        }

        return check == 3;
    }
}
