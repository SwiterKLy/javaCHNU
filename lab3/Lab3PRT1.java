// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Lab3PRT1 {
        public static void main(String[] args) {
            for ( int i = 0; i <  Integer.parseInt(args[0]); i++ ) {
                char c = (char)(Math.random()*26 + 'a');
                System.out.print(c + ": ");
                switch ( c ) {
                    case 'a': case 'e': case 'i':
                    case 'o': case 'u':
                        System.out.println("Голосна");
                        break;
                    case 'y': case 'w':
                        System.out.println("Iнодi голосна");
                        break;
                    default:
                        System.out.println("Приголосна");
            }
        }
    }

}