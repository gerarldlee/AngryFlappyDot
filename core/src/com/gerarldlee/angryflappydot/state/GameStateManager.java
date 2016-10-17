package com.gerarldlee.angryflappydot.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by datawiz on 16/10/2016.
 */

public class GameStateManager {

    private int score = 0;

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }
}
