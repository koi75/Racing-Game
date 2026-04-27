package ressources;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static class ChoicePanel extends JPanel {

        private JPanel northPanel;
        private JPanel centerPanel;
        private JPanel southPanel;

        private JLabel titleLabel;

        private JToggleButton toggleButton1;
        private JToggleButton toggleButton2;
        private JToggleButton toggleButton3;
        private JToggleButton toggleButton4;
        private JToggleButton toggleButton5;

        private JButton continueButton;

        private ButtonGroup buttonGroup;

        public ChoicePanel() {

            setLayout(new BorderLayout());

            createNorthPanel();
            createCenterPanel();
            createSouthPanel();

            add(northPanel, BorderLayout.NORTH);
            add(centerPanel, BorderLayout.CENTER);
            add(southPanel, BorderLayout.SOUTH);
        }

        private void createNorthPanel() {

            northPanel = new JPanel();
            northPanel.setLayout(new GridBagLayout());

            titleLabel = new JLabel("Choose Your Car");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 36));

            northPanel.add(titleLabel);
        }

        private void createCenterPanel() {

            centerPanel = new JPanel();
            centerPanel.setLayout(new GridLayout(1, 5, 20, 20));

            toggleButton1 = new JToggleButton("Car 1");
            toggleButton2 = new JToggleButton("Car 2");
            toggleButton3 = new JToggleButton("Car 3");
            toggleButton4 = new JToggleButton("Car 4");
            toggleButton5 = new JToggleButton("Car 5");

            buttonGroup = new ButtonGroup();

            buttonGroup.add(toggleButton1);
            buttonGroup.add(toggleButton2);
            buttonGroup.add(toggleButton3);
            buttonGroup.add(toggleButton4);
            buttonGroup.add(toggleButton5);

            centerPanel.add(toggleButton1);
            centerPanel.add(toggleButton2);
            centerPanel.add(toggleButton3);
            centerPanel.add(toggleButton4);
            centerPanel.add(toggleButton5);
        }

        private void createSouthPanel() {

            southPanel = new JPanel();
            southPanel.setLayout(new GridBagLayout());

            continueButton = new JButton("Continue");
            continueButton.setFont(new Font("Arial", Font.BOLD, 20));

            southPanel.add(continueButton);
        }

        public JButton getContinueButton() {
            return continueButton;
        }

        public JToggleButton getSelectedButton() {

            if (toggleButton1.isSelected()) return toggleButton1;
            if (toggleButton2.isSelected()) return toggleButton2;
            if (toggleButton3.isSelected()) return toggleButton3;
            if (toggleButton4.isSelected()) return toggleButton4;
            if (toggleButton5.isSelected()) return toggleButton5;

            return null;
        }
    }

    public static void main(String[] args) {

        JFrame j = new JFrame();
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        j.add(new ChoicePanel());

        j.setVisible(true);
    }
}