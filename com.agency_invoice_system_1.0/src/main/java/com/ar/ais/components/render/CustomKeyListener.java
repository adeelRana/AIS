/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.components.render;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Adi Rana
 */
public abstract class CustomKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public abstract void keyReleased(KeyEvent ke);

}
