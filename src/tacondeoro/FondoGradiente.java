/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Arturo
 */
public class FondoGradiente extends JPanel {
    private Color c1;
    private Color c2;
    private int size;

    public FondoGradiente() {
    }

    public FondoGradiente(Color c1, Color c2) {
        this.c1 = c1;
        this.c2 = c2;
        this.size = (c1.getRed() - c2.getRed()) * 2;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(20, 0, c1, 20, h, c2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
