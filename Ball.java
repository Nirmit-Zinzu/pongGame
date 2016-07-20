/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;


public class Ball {

    private int x;
    private int y;
    private int directionX;
    private int directionY;
    private static final int SIZE = 20;
    private static final int RIGHT = 1;
    private static final int LEFT = 0;
    private static final int UP = 2;
    private static final int DOWN = 3;
    
    /** Constructor method for the Ball object
    * @param x - The initial x-coordinate for the ball
    * @param y - The initial y-coordinate for the ball
    */
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.directionX = Ball.RIGHT;
        this.directionY = Ball.DOWN;
    }

    /** Accessor method for the x-coordinate of the ball
    * @return Returns the current x-coordinate of the ball
    */
    public int getX() {
        return this.x;
    }
    
    /** Accessor method for the y-coordinate of the ball
    * @return Returns the current y-coordinate of the ball
    */
    public int getY() {
        return this.y;
    }
    
    /** Accessor method for the size (side length) of the ball
    * @return Returns the size (side length) of the ball
    */
    public int getSize() {
        return Ball.SIZE;
    }
    
    /** Accessor method for the ball's horizontal heading
    * @return Returns the ball's horizontal heading (0 is left, 1 is right)
    */
    public int getDirectionX() {
        return this.directionX;
    }
    
    /** Accessor method for the ball's vertical heading
    * @return Returns the ball's vertical heading (2 is up, 3 is down)
    */
    public int getDirectionY() {
        return this.directionY;
    }
    
    /** Mutator method for the ball's horizontal heading
    * @param direction - Sets the direction of the ball's horizontal heading (0 is left, 1 is right)
    */
    public void setDirectionX(int direction) {
        this.directionX = direction;
    }
    
    /** Mutator method for the ball's vertical heading
    * @param direction - Sets the direction of the ball's vertical heading (2 is up, 3 is down)
    */
    public void setDirectionY(int direction) {
        this.directionY = direction;
    }
    
    /** Mutator method for the ball's x-coordinate
    * @param xCoordinate - Determines the ball's new x-coordinate
    */
    public void setX(int xCoordinate) {
        this.x = xCoordinate;
    }
    
    /** Mutator method for the ball's y-coordinate
    * @param yCoordinate - Determines the ball's new y-coordinate
    */
    public void setY(int yCoordinate) {
        this.y = yCoordinate;
    }

    
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(this.x, this.y, 20, 20);
    }
}
