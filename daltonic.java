import javax.swing.*;
import java.lang.Object;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.JLabel;
import java.util.Random;
import java.lang.Math.*;

class bottone extends JButton{
//bottoni con coordinate e colore
 //attributi
int riga, colonna;
boolean v;


public bottone(int a, int b) { //costruttore
Random random = new Random();
boolean temp=random.nextBoolean();
this.v=temp;

this.riga=a;
this.colonna=b;


if (v==true) this.setBackground(Color.GREEN);
else this.setBackground(Color.RED);
}
//metodo di cambio di stato
public void cambio(){
if (v==false) {
this.setBackground(Color.GREEN);
v=true;
}
else {
this.setBackground(Color.RED);
v=false;
}
}



}


class griglia extends JPanel implements ActionListener {
//attributi

int i, j;
JButton next=new JButton("Next"); //bottone per andare avanti
bottone[][] bottoni=new bottone[3][3];

public  griglia() { //costruttore

this.setLayout(new GridLayout(3,3));
for (i=0;i<=2; i++) {
for (j=0;j<=2; j++) {
bottoni[i][j]=new bottone(i,j);
this.add(bottoni[i][j]);
bottoni[i][j].addActionListener(this);
}
next.addActionListener(this);
}

}
public void actionPerformed(ActionEvent e){
Object p=e.getSource(); //dice quale pulsante e' stato premuto
bottone premuto;
int r, c;
if (p instanceof bottone) {
premuto=(bottone)p; //casting da object a bottone
r=premuto.riga;
c=premuto.colonna;
flippa(r, c);
haivinto();
}
if (p==this.next) {
this.bottoni[1][1].setBackground(Color.BLACK);
}

}
public void flippa(int r, int c) {
this.bottoni[r][c].cambio();
if (r>0) this.bottoni[r-1][c].cambio();
if (c>0) this.bottoni[r][c-1].cambio();
if (r<2) this.bottoni[r+1][c].cambio();
if (c<2) this.bottoni[r][c+1].cambio();


}



public void haivinto() {
avanti f;

boolean hv=true;
int i=0;
int j;
while (i<=2 && hv) {
j=0;
while (j<=2 && hv) {
 hv=this.bottoni[i][j].v;

j=j+1;
}//while
i=i+1;
}//while
if (hv==true) {
f=new avanti("Hai vinto!!");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
f.setSize(300,300);
f.c.add(this.next);
}//if

}//haivinto


}//griglia

class avanti extends JFrame{
Container c=getContentPane();

public avanti(String s) {
super(s);
}
//JPanel jp=new JPanel();
//c.add(jp);
}//avanti



public class daltonic {


public static void main(String[] args){
JFrame f=new JFrame("Daltonic");
griglia g=new griglia();
Container c=f.getContentPane();
f.setVisible(true);
f.setSize(300,300);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


c.add(g);
}
}

