/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Game {

    // screen size
    public static final int X_MAX = 600;    
    public static final int Y_MAX = 400;
    
    private Paddle humanPaddle;
    private Paddle computerPaddle;
    private Ball ball;
    
    // score counters 
    private int humanScore = 0;
    private int computerScore = 0;
    
    
    // Constructor method for the game 
    public Game() {
        humanPaddle = new Paddle(0, 155);
        computerPaddle = new Paddle(575, 155);
        ball = new Ball(290, 190);
    }
    

    // overall screen outlook
    public void paint(Graphics g) {
        this.ball.paint(g);
        this.computerPaddle.paint(g);
        this.humanPaddle.paint(g);
        Font font = new Font("Arial", Font.BOLD, 15);
        g.setFont(font);
        g.setColor(Color.cyan);
        g.drawString("Human: " + humanScore, 50,380);
        g.drawString("Computer: " + computerScore, 450,380);
    }
    
    // Following method displays appropriate score of each player on the screen 
    public void printScore(Graphics g) {
        if (this.ball.getX() < 0) { // out of screen (left)
            computerScore ++; 
        } else if (this.ball.getX() > 600) { // out of screen (right)
            humanScore ++; 
        }       
        g.drawString("Human Player : ", 10, 10);
        g.drawString("" + this.humanScore, 30, 10);
        g.drawString("Computer : ", 40, 10);
        g.drawString("" + this.computerScore, 60, 10);
    }
    
     /** Update method that runs every 5 milliseconds
    * @param change - Represents the change in the ball's position per 5 milliseconds
    */
    public void update(int change){
        
        // computer paddle y-values (top and bottom)
        int computerPaddleRange1 = computerPaddle.getY();
        int computerPaddleRange2 = computerPaddle.getY() + computerPaddle.getLength();
        
        // human paddle y-values (top and bottom)
        int humanPaddleRange1 = humanPaddle.getY();
        int humanPaddleRange2 = humanPaddle.getY() + humanPaddle.getLength();
        
        // ball y-values (top and bottom)
        int ballRange1 = ball.getY();
        int ballRange2 = ball.getY() + ball.getSize();
        
        // checks to see if the ball has hit the computer paddle or not
        if ((ball.getX() + ball.getSize() == 575)) {
             if ((ballRange1 >= computerPaddleRange1) && (ballRange1 <= computerPaddleRange2) 
                     || (ballRange2 >= computerPaddleRange1) && (ballRange2 <= computerPaddleRange2)){     
                 ball.setDirectionX(0);  // ball moves left
             }
            
        // checks to see if the ball has hit the player paddle or not
        } else if (ball.getX() == 25) {
            if ((ballRange1 >= humanPaddleRange1) && (ballRange1 <= humanPaddleRange2) || (ballRange2 >= humanPaddleRange1) && (ballRange2 <= humanPaddleRange2)) {
                 ball.setDirectionX(1);  // right
            }
            
        } else if (ball.getX() == 600) {
               ball.setDirectionX(1); //right
                 humanScore++;
                 ball.setX(290);
                 ball.setY(190);
                System.out.println("Computer: " + this.computerScore + " Human: " + this.humanScore);
            
        } else if (ball.getX() == -20) {
             ball.setDirectionX(0);  // left   
                computerScore ++;
                ball.setX(290);
                ball.setY(190);
                System.out.println("Computer: " + this.computerScore + " Human: " + this.humanScore);
        }
        
        // if the ball touches bottom of the compuuter paddle
        if (ball.getY() > computerPaddle.getY() + 90 && computerPaddle.getX() < (ball.getX() + 20)) {
            ball.setDirectionY(3); // down
            
        // if the ball touches top of the user paddle
        } else if (ball.getY() == humanPaddle.getY() + 90 && ball.getX() < (humanPaddle.getX() + 25)) {
            ball.setDirectionY(3); // down
             
          // if the ball touches top of the compuuter paddle ...
        } else if (ball.getY() + 20 < computerPaddle.getY() && computerPaddle.getX() < (ball.getX() + 20)) {
            ball.setDirectionY(2);  // up
             
        // if the ball touches borrom of the user paddle
        } else if (ball.getY() + 20 == humanPaddle.getY() && ball.getX() < (humanPaddle.getX() + 25)) {
            ball.setDirectionY(2);  // up
             System.out.println("this is 4!");
        }
        
        // upon hitting the top and bottom walls...
        if (ball.getY() + ball.getSize() >= 400) {
           ball.setDirectionY(2);   // up      
        } if (ball.getY() <= 0) {
            ball.setDirectionY(3);  // down
        }
        
        // setting the ball moment 
        if (this.computerScore < 2 && this.humanScore < 2) {
            if(ball.getDirectionX() == 0){ // right
                ball.setX(ball.getX() - change);
            } else {
                ball.setX(ball.getX() + change);           
            } 

            if (ball.getDirectionY() == 2) { // up
                ball.setY(ball.getY() - change);
            } else {
                ball.setY(ball.getY() + change); 
            }
        }

        /* Controlling the moment og the computer paddle 
            Computer paddle starts to move when the ball reaches half way point. */
        if (this.ball.getX() > 300) {
            // if paddle is within the same x-region as the ball ...
            if (this.computerPaddle.getY() <= this.ball.getY() + 20 && 
                    this.ball.getY() <= this.computerPaddle.getY() + 90) {
                if (this.ball.getDirectionY() == 2) { // up
                    this.computerPaddle.movePaddle((-1) * change); // paddle goes up
                } else if (this.ball.getDirectionY() == 3) { // down
                    this.computerPaddle.movePaddle(change);   // paddle goes down
                }
                
            // ball top, computer paddle bottom ...
            } else if (this.computerPaddle.getY() > this.ball.getY() + 20) {
                    this.computerPaddle.movePaddle((-1)*change); // paddle goes up
                    System.out.println("!!!!!1");
                    
            // ball bottom, computer paddle top ...
            } else if (this.computerPaddle.getY() + 90 < this.ball.getY()) {
                    this.computerPaddle.movePaddle(change); // paddle goes down
                    System.out.println("!!!!! 2");

                }
        }
        
    }
    
   /** mutator method for the y-coordinate of the paddle
    * @param changeY - delta value to move the paddle in y direction
    */
    public void humanPaddleUpdate(int changeY) {
        this.humanPaddle.movePaddle(changeY);  
    }

    /** Accessor method for the computer score
    * @return computer score
    */
    public int getComputerScore() {
        return this.computerScore;
    }

    /** Accessor method for the user score
    * @return user score
    */
    public int getHumanScore () {
        return this.humanScore;
    }

    /** Mutator method for the computer's score
    * @param score - computer's score
    */
    public void setComputerScore(int score) {
        this.computerScore = score;
    }

    /** Mutator method for the user's score
    * @param score - user's score
    */
    public void setHumanScore(int score) {
        this.humanScore = score;
    }
   
}
