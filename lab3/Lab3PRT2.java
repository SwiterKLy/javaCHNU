public class Lab3PRT2 {
    public static void main(String[] args) {
        double angle1 = Double.parseDouble(args[0]);
        double angle2 = Double.parseDouble(args[1]);
        double hypot = Math.hypot(angle1,angle2);

        System.out.println("Кут 1 дорівнює :" + Math.toDegrees(Math.asin(angle1 / hypot)) + "градусів");
        System.out.println("Кут 2 дорівнює :" + Math.toDegrees(Math.asin(angle2 / hypot)) + "градусів");
        System.out.println(Math.toDegrees(Math.asin(angle2 / hypot)) + Math.toDegrees(Math.asin(angle1 / hypot)) + 90); //Перевірка на правильну суму кутів
    }
}
