import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TrafficLight extends JPanel implements ActionListener{
private JRadioButton rl;
private JRadioButton r2;
private JRadioButton r3;
private Color red_c;
private Color green_c;
private Color yellow_c;
public TrafficLight() {
    setBounds (0,0,640,480);
    r1= new JRadioButton("Red");
    r2= new JRadioButton("Yellow");
    r3=new JRadioButton("Green");
    rl.setSelected(true);
    red_c= Color.red;


yellow_c= getBackground();
green_=getBackground();
ButtonGroup gp new ButtonGroup();
gp.add(r1);
gp.add(r2);
gp.add(r3);
add(r1);
add(r2);
add (r3);
rl.addActionListener(this);
r2.addActionListener(this);
r3.addActionListener(this);
public void actionPerformed(ActionEvent e) {
if(rl.isSelected() == true) {
redc Color.red;