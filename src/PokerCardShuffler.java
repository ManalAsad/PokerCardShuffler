import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.ArrayList;

public class PokerCardShuffler extends JFrame{
    private JPanel cardPanel;
    private ArrayList<ImageIcon> cardImages;
    private ArrayList<JLabel> cardLabels;

    public PokerCardShuffler(){
        setTitle("Poker Card shuffler");
        setSize(1536,1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        


        cardImages = new ArrayList<>();
        cardLabels = new ArrayList<>();

        for(int i=1; i<=67; i++){
            cardImages.add(new ImageIcon("cards/card ("+ i +").png"));

        }


        cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(4,13));

        for(int i=0; i<cardImages.size(); i++){
            Image image =cardImages.get(i).getImage();
            Image scaledImage = image.getScaledInstance(73, 110, Image.SCALE_SMOOTH);
            cardImages.set(i,new ImageIcon(scaledImage));
            JLabel label= new JLabel(cardImages.get(i));
            
            cardLabels.add(label);
            cardPanel.add(label);
        }
        cardPanel.setBackground(Color.RED);
        add(cardPanel, BorderLayout.CENTER);

        JButton shuffleButton = new JButton("Shuffle Cards");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                shuffleCards();
            }
        });
        add(shuffleButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void shuffleCards() {

        Collections.shuffle(cardImages);

        for(int i=0; i < cardLabels.size(); i++){
            cardLabels.get(i).setIcon(cardImages.get(i));
        }
    }

    public static void main(String[] args){
        new PokerCardShuffler();
    }
}

