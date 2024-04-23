/** Generic coordinate class
 *
 * Used for both screen coordinates and city block coordinates. This is a
 * nightmare for type safety, though, so this class should not be used. Instead,
 * use the ScreenCoordinate class or the CityCoordinate class */
public abstract class Coordinate {
    int x;
    int y;
}
