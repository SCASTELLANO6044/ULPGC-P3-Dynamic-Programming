package package1;

public class JavaProject {

    public static void main(String[] args) {
        int [][] items = new int [4][2];
        
        items [0][0] = 2;
        items [0][1] = 3;
        
        items [1][0] = 3;
        items [1][1] = 4;
        
        items [2][0] = 4;
        items [2][1] = 5;
        
        items [3][0] = 5;
        items [3][1] = 6;
        
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[0].length; j++) {
                System.out.println(items[i][j]);
            }
        }
    }
}
