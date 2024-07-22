import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame {

    private Generator gen;

    public GUI() {

        super("Password Generator");
        setIconImage(new ImageIcon("src/image/logo.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addComponents();
    }

    private void addComponents() {

        // text field
        JTextField passwordField = new JTextField();
        passwordField.setBounds(15, 15, 385, 45);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 16));
        passwordField.setEditable(false);
        passwordField.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
            }
        });
        add(passwordField);

        // scroll pane
        JScrollPane scrollPane = new JScrollPane(passwordField);
        scrollPane.setBounds(15, 15, 385, 45);
        add(scrollPane);

        // lower case button
        JToggleButton lowerCaseBtn = new JToggleButton("Lower case");
        lowerCaseBtn.setBounds(15, 80, 165, 45);
        lowerCaseBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        lowerCaseBtn.setFocusPainted(false);
        lowerCaseBtn.setBackground(Color.WHITE);
        lowerCaseBtn.setBorderPainted(false);
        add(lowerCaseBtn);

        //upper case button
        JToggleButton upperCaseBtn = new JToggleButton("Upper case");
        upperCaseBtn.setBounds(195,80,165,45);
        upperCaseBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        upperCaseBtn.setFocusPainted(false);
        upperCaseBtn.setBackground(Color.WHITE);
        upperCaseBtn.setBorderPainted(false);
        add(upperCaseBtn);

        // nums button
        JToggleButton numsBtn = new JToggleButton("Nums");
        numsBtn.setBounds(15,145,165,45);
        numsBtn.setFont(new Font("Dialog",Font.BOLD,16));
        numsBtn.setFocusPainted(false);
        numsBtn.setBackground(Color.WHITE);
        numsBtn.setBorderPainted(false);
        add(numsBtn);

        //simvols button
        JToggleButton simvolsBtn = new JToggleButton("Simvols");
        simvolsBtn.setBounds(195,145,165,45);
        simvolsBtn.setFont(new Font("Dialog",Font.BOLD,16));
        simvolsBtn.setFocusPainted(false);
        simvolsBtn.setBackground(Color.WHITE);
        simvolsBtn.setBorderPainted(false);
        add(simvolsBtn);

        // pass len
        JLabel passLen = new JLabel("Password length:");
        passLen.setFont(new Font("Dialog", Font.BOLD, 24));
        passLen.setBounds(15,205,225,45);
        add(passLen);

        // pass field
        JTextField passLenField = new JTextField();
        passLenField.setBounds(230,210,150,35);
        passLenField.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(passLenField);

        // generate button
        JButton generateBtn = new JButton("Generate");
        generateBtn.setBounds((450-150)/2,255,150,40);
        generateBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        generateBtn.setFocusPainted(false);
        generateBtn.setBackground(Color.WHITE);
        generateBtn.setBorderPainted(false);
        add(generateBtn);

        onClickGenerate(lowerCaseBtn,upperCaseBtn,numsBtn,
                simvolsBtn,passLenField,generateBtn,passwordField);
    }

    private void getGenerator() { gen = new Generator(); }

    private void onClickGenerate(JToggleButton lowerCaseBtn,
                                 JToggleButton upperCaseBtn,
                                 JToggleButton numsBtn,
                                 JToggleButton simvolsBtn,
                                 JTextField passLenField,
                                 JButton generateBtn,
                                 JTextField passwordField){

        generateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                getGenerator();

                boolean selectOne = (lowerCaseBtn.isSelected() ||
                        numsBtn.isSelected() ||
                        upperCaseBtn.isSelected() ||
                        simvolsBtn.isSelected());

                if(selectOne){

                    try{
                        int len = Integer.parseInt(passLenField.getText());

                        String generateStr = gen.generateString(lowerCaseBtn.isSelected(),
                                upperCaseBtn.isSelected(),
                                numsBtn.isSelected(),simvolsBtn.isSelected(),
                                len);

                        passwordField.setText(generateStr);

                    } catch(Exception error){

                        error.printStackTrace();
                        passwordField.setText("Вы ввели ошибочную длину");
                    }
                    }

            }
        });



    }

}
