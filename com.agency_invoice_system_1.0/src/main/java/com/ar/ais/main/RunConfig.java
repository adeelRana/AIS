package com.ar.ais.main;

import com.ar.ais.views.config.ConfigFrame;

/**
 *
 * @author Adeel rana
 */
public class RunConfig {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigFrame().setVisible(true);
            }
        });
    }

}
