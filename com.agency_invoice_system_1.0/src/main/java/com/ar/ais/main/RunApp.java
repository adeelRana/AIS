package com.ar.ais.main;

import com.ar.ais.components.render.UI;
import com.ar.ais.utililty.Global;
import com.ar.ais.utililty.StartupUtility;
import com.ar.ais.views.dialogs.ProgressDialog;
import com.ar.ais.views.main.MainFrame;

/**
 *
 * @author Adeel rana
 */
public class RunApp {

    public static void main(String[] args) {
        final StartupUtility startup = new StartupUtility();
        Global.progressState = true;
        UI.setUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgressDialog(null, true, 100).setVisible(true);
            }
        });

//        boolean extractData = startup.extractData();
        boolean extractData = true;
        if (extractData) {
//            startup.startDataSource();
            if (startup.connectDataSource()) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Global.progressState = false;
                        MainFrame mf = new MainFrame();
                        Global.setMainFrame(mf);
                        mf.setVisible(true);
                    }
                });
            }
        }
    }

}
