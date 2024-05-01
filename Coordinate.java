/** Generic coordinate class
 *
 * Used for both screen coordinates and city block coordinates. This is a
 * nightmare for type safety, though, so this class should not be used. Instead,
 * use the ScreenCoordinate class or the CityCoordinate class */
public abstract class Coordinate {
    int x;
    int y;
    public int hashCode() {
        return x * 301 + y;
    }
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) o;
        return this.x == other.x && this.y == other.y;
    }
}
