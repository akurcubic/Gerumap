package raf.dsw.gerumap.gui.swing.view;


import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Getter
@Setter

public class SettingsView extends JDialog {

    private String name = "";
    private int debljina = 3;
    private Color color;

    public SettingsView(Frame parent, String title, boolean modal){
        super(parent,title,modal);

        this.setSize(250,75);
        setLocationRelativeTo(parent);

        JPanel jPanel = new JPanel();

        JButton nazivButton = new JButton("Naziv");
        nazivButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                name = JOptionPane.showInputDialog("Unesite naziv elementa");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jPanel.add(nazivButton,BorderLayout.NORTH);

        JButton debljinaButton = new JButton("Debljina");
        jPanel.add(debljinaButton,BorderLayout.CENTER);
        debljinaButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                debljina = Integer.parseInt(JOptionPane.showInputDialog("Unesite debljinu linije"));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton bojaButton = new JButton("Boja");
        jPanel.add(bojaButton,BorderLayout.SOUTH);
        bojaButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                color= JColorChooser.showDialog(MainFrame.getInstance(),"Izaberite boju elementa", Color.RED);


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        this.add(jPanel,BorderLayout.CENTER);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebljina() {
        return debljina;
    }

    public void setDebljina(int debljina) {
        this.debljina = debljina;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
