public class Ball {
    private final String value;

    public Ball(String value) {
        this.value = value;
    }

    public boolean isWicket() {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return true;
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }

    public int getRun() {
        return !isWicket() ? Integer.parseInt(value) : 0;
    }

    public int getWicket() {
        return isWicket() ? 1 : 0;
    }
}