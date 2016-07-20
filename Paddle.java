/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package pong;

import java.awt.Color;
import java.awt.Graphics;


public class Paddle {
    
    private int length = 90;
    private int width = 25;
    private int x;
    private int y;
    
    /** Constructor method for the Paddle object
     * @param x - The paddle's x-coordinate
     * @param y - The paddle's initial y-coordinate
     */
    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /** Moves the paddle by changing its y-coordinate
     * @param y - Determines the paddle's new y-coordinate
     */
    public void movePaddle(int y) {
        if (this.y + y > 310) {
            this.y = 310;
        } else if (this.y + y < 0) {
            this.y = 0;
        } else {
            this.y += y;
        }
    }
    
    /** Accessor method for the x-coordinate of the paddle
    * @return Returns the current x-coordinate of the paddle
    */
    public int getX() {
        return this.x;
    }
    
    /** Accessor method for the y-coordinate of the paddle
    * @return Returns the current y-coordinate of the paddle
    */
    public int getY() {
        return this.y;
    }
    
     /** Accessor method for the vertical length of the paddle
    * @return Returns the vertical length of the paddle
    */
    public int getLength() {
        return this.length;
    }
    
    
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.x, this.y, this.width, this.length);
    }
    
}
