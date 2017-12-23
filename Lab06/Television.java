/**
 * Television Class
 * Contains Fields, Methods and a Constructor
 * @author  Michael Dorfman
 * @version 1.0
 * @since   10/13/2017
 */

public class Television
{
    // Fields
    private String Manufacturer;
    private int SCREEN_SIZE;
    private boolean powerOn;
    private int channel;
    private int volume;

    /***
     * Constructor sets aspects of the Television
     * @param Brand Manufacturer
     * @param size Screen Size
     */
    public Television(String Brand, int size)
    {
        Manufacturer = Brand;
        SCREEN_SIZE = size;
        powerOn = false;
        volume = 20;
        channel = 2;
    }

    /***
     * Powers on the Television
     */
    public void power()
    {
        powerOn = true;
    }

    /***
     * Sets the Channel
     * @param station Channel of the TV
     */
    public void setChannel(int station)
    {
        channel = station;
    }

    /***
     * Increases Volume by 1
     */
    public void increaseVolume()
    {
        volume++;
    }

    /***
     * Decreases the Volume by 1
     */
    public void decreaseVolume()
    {
        volume--;
    }

    /***
     * Returns the Channel
     * @return Channel Value
     */
    public int getChannel()
    {
        return channel;
    }

    /***
     * Returns the Volume
     * @return Volume Value
     */
    public int getVolume()
    {
        return volume;
    }

    /***
     * Returns the Manufacturer
     * @return Manufacturer String
     */
    public String getManufacturer()
    {
        return Manufacturer;
    }

    /***
     * Returns the Screensize
     * @return Screen Size Value
     */
    public int getScreenSize()
    {
        return SCREEN_SIZE;
    }
}