public class Demo130121 {
    public static void main(String[] args) {
        helloWorld();

        int[][] array = initializeNewArray(3, 4);
        // array = new int[3][4]
        fillArray(array);
        System.out.println(array[2][3]);

        demonstratePrint();
    }

    private static void helloWorld() {
        System.out.printf("Hello World! 2+2=%d", 2 + 2);
    }

    private static int[][] initializeNewArray(int size1, int size2) {
        return new int[size1][size2];
    }// Remember, the 'array' variable here is just a reference to a memory area,

    // where the data lies. So if you change data, it changes in the caller.
    // But if you changes the variable itself, it won't affect environment.
    private static void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = i + j;

        // The following lines do nothing
        array = new int[1][1];
        array[0][0] = 239;
    }

    private static void demonstratePrint() {
        String s = "a" + Integer.toString(2) + "b";
        int minusTwo = Integer.parseInt("-2");
        double floatingPointNumber = 1.0 / 239.0;
        //
        System.out.printf("s=%s, minusTwo=%d, floatingPointNumber=%.4f=%f", s, minusTwo,
                floatingPointNumber, floatingPointNumber);
    }
}