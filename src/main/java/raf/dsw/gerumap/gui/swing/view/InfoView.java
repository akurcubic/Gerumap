package raf.dsw.gerumap.gui.swing.view;



import javax.swing.*;
import java.awt.*;


public class InfoView extends JDialog {



    public InfoView(Frame parent, String title, boolean modal){
        super(parent,title,modal);

        this.setSize(450,450);
        setLocationRelativeTo(parent);

        Dimension dim=new Dimension(120,20);
        Dimension dim2 = new Dimension(50,50);

        JPanel panPrezime1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPrezime=new JLabel("Prezime:");
        lblPrezime.setPreferredSize(dim);
        JLabel lblprezimeAutor1=new JLabel("Kurćubić");
        lblprezimeAutor1.setPreferredSize(dim);
        panPrezime1.add(lblPrezime);
        panPrezime1.add((lblprezimeAutor1));

        JPanel autorPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAutor1=new JLabel("Autor");
        autorPanel1.add(lblAutor1);

        JPanel panIme1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme=new JLabel("Ime:");
        lblIme.setPreferredSize(dim);
        JLabel lblImeAutor1=new JLabel("Aleksandar");
        lblImeAutor1.setPreferredSize(dim);
        panIme1.add(lblIme);
        panIme1.add((lblImeAutor1));

        JPanel indexPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIndex = new JLabel("Indeks:");
        lblIndex.setPreferredSize(dim);
        JLabel lblIndexAutor1 = new JLabel("105/RN");
        lblIndexAutor1.setPreferredSize(dim);
        indexPanel1.add(lblIndex);
        indexPanel1.add(lblIndexAutor1);

        /// SLIKA
        JPanel slikaPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbSlika = new JLabel("Slika:");
        lbSlika.setPreferredSize(dim);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/user.png"));
        JLabel lbSaSlikom1 = new JLabel();
        lbSaSlikom1.setPreferredSize(dim2);
        lbSaSlikom1.setIcon(icon);
        slikaPanel1.add(lbSlika);
        slikaPanel1.add(lbSaSlikom1);


        Box boxCentar=Box.createVerticalBox();
        boxCentar.add(Box.createVerticalStrut(20));
        boxCentar.add(autorPanel1);
        boxCentar.add(panIme1);
        boxCentar.add(panPrezime1);
        boxCentar.add(indexPanel1);
        boxCentar.add(slikaPanel1);
        boxCentar.add(Box.createGlue());
        add(boxCentar,BorderLayout.CENTER);
    }
}
