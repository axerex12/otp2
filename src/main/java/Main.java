import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OutputGenerator outputGenerator = new OutputGenerator();
        Scanner sc = new Scanner(System.in);
        System.out.println("What language?");
        System.out.println("English: 1, Finnish: 2, Swedish: 3, Japanese: 4");
        int language = sc.nextInt();
        sc.close();

        switch (language) {
            case 1:
                outputGenerator.generateOutput("en_US");
                break;
            case 2:
                outputGenerator.generateOutput("fi_FI");
                break;
            case 3:
                outputGenerator.generateOutput("sv");
                break;
            case 4:
                outputGenerator.generateOutput("ja");
                break;
        }

    }

}
