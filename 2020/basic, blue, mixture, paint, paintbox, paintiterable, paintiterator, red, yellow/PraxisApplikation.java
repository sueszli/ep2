public class PraxisApplikation {
    public static void main(String[] args) {
        Paint violet = Red.RED.mixWith(Blue.BLUE);
        Paint orange = Red.RED.mixWith(Yellow.YELLOW);
        Paint green = Blue.BLUE.mixWith(Yellow.YELLOW);
        Paint black = violet.mixWith(Yellow.YELLOW);

        System.out.println(black); // red, blue, yellow
                                   // (order is not specified)

        for (Basic b: black) {
            System.out.println(b);
        }
        // red
        // blue
        // yellow
        // (order is irrelevant)

        System.out.println("------");

        Paintbox box = new Paintbox();
        box.put(black, "black");
        box.put(orange, "orange");
        box.put(green, "green");
        box.put(Red.RED, "red");

        System.out.println((green.mixWith(orange)).equals(black));

        System.out.println(box.get(Red.RED)); //red
    }
}
