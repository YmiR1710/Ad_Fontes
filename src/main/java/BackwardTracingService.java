import java.util.LinkedList;
import java.util.List;

public class BackwardTracingService {
    public static List getContourPoints(int[][] srcImage) {
        int[][] image = srcImage.clone();
        clearBorder(image);
        List<Point> points = new LinkedList<Point>();
        Point startingPoint = getStartingPoint(image);
        Point endPoint = startingPoint.getClone();
        Point activePoint = startingPoint.getClone();
        points.add(new Point(startingPoint.getX()+1, startingPoint.getY()));
        do{
            Point backup = activePoint.getClone();
            activePoint = BackwardTracingService.getDirection(image, ((LinkedList<Point>) points).getLast(), activePoint).getClone();
            ((LinkedList<Point>) points).add(backup);
        } while (!endPoint.equals(activePoint));
        return points;
    }
    public static Point getDirection(int[][] image, Point c_p, Point a_p){
        if(a_p.getX() == c_p.getX()+1 && a_p.getY() == c_p.getY()+1){
            Point start = new Point(a_p.getX()+1, a_p.getY()-1);
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
        }
        if(a_p.getX() == c_p.getX() && a_p.getY() == c_p.getY()+1){
            Point start = new Point(a_p.getX()+1, a_p.getY());
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
        }
        if(a_p.getX() == c_p.getX()-1 && a_p.getY() == c_p.getY()+1){
            Point start = new Point(a_p.getX()+1, a_p.getY()+1);
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
        }
        if(a_p.getX() == c_p.getX()-1 && a_p.getY() == c_p.getY()){
            Point start = new Point(a_p.getX(), a_p.getY()+1);
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
        }
        if(a_p.getX() == c_p.getX()+1 && a_p.getY() == c_p.getY()){
            Point start = new Point(a_p.getX(), a_p.getY()-1);
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
        }
        if(a_p.getX() == c_p.getX() && a_p.getY() == c_p.getY()-1){
            Point start = new Point(a_p.getX()-1, a_p.getY());
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
        }
        if(a_p.getX() == c_p.getX()-1 && a_p.getY() == c_p.getY()-1){
            Point start = new Point(a_p.getX()-1, a_p.getY()+1);
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
        }
        if(a_p.getX() == c_p.getX()+1 && a_p.getY() == c_p.getY()-1){
            Point start = new Point(a_p.getX()-1, a_p.getY()-1);
            if(image[a_p.getY()-1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()-1);
            }
            if(image[a_p.getY()-1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()-1);
            }
            if(image[a_p.getY()][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY());
            }
            if(image[a_p.getY()+1][a_p.getX()+1] == 1){
                return new Point(a_p.getX()+1, a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()] == 1){
                return new Point(a_p.getX(), a_p.getY()+1);
            }
            if(image[a_p.getY()+1][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY()+1);
            }
            if(image[a_p.getY()][a_p.getX()-1] == 1){
                return new Point(a_p.getX()-1, a_p.getY());
            }
        }
        return new Point(0, 0);
    }
    public static Point getStartingPoint(int[][] image) {

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
