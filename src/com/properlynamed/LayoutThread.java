package com.properlynamed;

import javax.swing.*;
import java.awt.*;


class LayoutThread implements Runnable {
    private JPanel processingPanel;
    private int currentLayout;
    private boolean threadCycleActive;
    private static final int PANELHASFLOWLAYOUT = 1;
    private static final int PANELHASGRIDLAYOUT = 2;
    private static final int PANELHASBOXLAYOUT = 3;
    private static final int SLEEPTIME=1500;

    public void run() {
        Component[] components = processingPanel.getComponents();
        int componentsCount = components.length;
        while (true) {
            while (!threadCycleActive) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {

                }
            }
            switch (currentLayout) {
                case PANELHASFLOWLAYOUT:
                    toGridLayout(processingPanel, componentsCount);
                    processingPanel.validate();
                    try {
                        Thread.sleep(SLEEPTIME);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, "Already interrupted");
                    }
                    currentLayout = PANELHASGRIDLAYOUT;
                    break;
                case PANELHASGRIDLAYOUT:
                    toBoxLayout(processingPanel);
                    processingPanel.validate();
                    try {
                        Thread.sleep(SLEEPTIME);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, "Already interrupted");
                    }
                    currentLayout = PANELHASBOXLAYOUT;
                    break;
                case PANELHASBOXLAYOUT:
                    toFlowLayout(processingPanel);
                    processingPanel.validate();
                    try {
                        Thread.sleep(SLEEPTIME);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, "Already interrupted");
                    }
                    currentLayout = PANELHASFLOWLAYOUT;
                    break;
                default:
                    currentLayout = PANELHASFLOWLAYOUT;
                    break;
            }

        }
    }

    private void toGridLayout(JPanel panel, int compCount) {
        int gridSize = compCount / 2 + 1;
        panel.setLayout(new GridLayout(gridSize, gridSize));
    }

    private void toFlowLayout(JPanel panel) {
        panel.setLayout(new FlowLayout());
    }

    private void toBoxLayout(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
    }

    void turnOff() {
        threadCycleActive = false;
    }

    void turnOn() {
        threadCycleActive = true;
    }


    LayoutThread(JPanel panel) {
        processingPanel = panel;
        currentLayout = 1;
        threadCycleActive = false;
    }
}
