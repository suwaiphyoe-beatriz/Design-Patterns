public class Game {

    public static void main(String[] args) {
        Game game = new Game();

        // city or wilderness
        Map map = game.createMap("city", 10, 6);
        map.display();
    }

    // FM
    public Map createMap(String type, int width, int height) {
        if (type.equalsIgnoreCase("city")) {
            return new CityMap(width, height);
        } else {
            return new WildernessMap(width, height);
        }
    }
}

