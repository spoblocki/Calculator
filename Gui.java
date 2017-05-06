package pl.sp.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener {

	JPanel jpanel;
	JTextField jtextfield;
	JButton jbsilnia;
	JButton jbcalc;
	JButton jbadd;
	JButton jbsubtract;
	JButton jbmulti;
	JButton jbdivide;
	boolean clicked = false;
	double a;
	double b;
	int oper;
	double result;
	double n;

	public Gui() {

		jpanel = new JPanel();
		add(jpanel);
		this.jtextfield = new JTextField(10);

		jbcalc = new JButton("CALCULATE");
		jbcalc.addActionListener(this);
		jbadd = new JButton("+");
		jbadd.addActionListener(this);
		jbsubtract = new JButton("-");
		jbsubtract.addActionListener(this);
		jbmulti = new JButton("*");
		jbmulti.addActionListener(this);
		jbdivide = new JButton("/");
		jbdivide.addActionListener(this);
		jbsilnia = new JButton("!");
		jbsilnia.addActionListener(this);
		jpanel.add(jtextfield);

		jpanel.add(jbadd);
		jpanel.add(jbsubtract);
		jpanel.add(jbmulti);
		jpanel.add(jbdivide);
		jpanel.add(jbsilnia);
		jpanel.add(jbcalc);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("KALKULATOR");
		setSize(550, 80);
		setVisible(true);

	}

	void calculate(int oper) {

		switch (oper) {
		case 1:
			this.result = a + b;
			break;
		case 2:
			this.result = a - b;
			break;
		case 3:
			this.result = a * b;
			break;
		case 4:
			this.result = a / b;
			break;
		case 5:

			this.result = silnia(n);
			break;
		}

		jtextfield.setText(Double.toString(this.result));

	}

	public void actionPerformed(ActionEvent e) {

		if ((clicked == false) && (e.getSource() == jbadd)) {
			this.a = Double.parseDouble(jtextfield.getText());
			this.jtextfield.setText("");
			this.oper = 1;
			this.clicked = true;
		}

		if ((clicked == false) && (e.getSource() == jbsubtract)) {
			this.a = Double.parseDouble(jtextfield.getText());
			this.jtextfield.setText("");
			this.oper = 2;
			this.clicked = true;
		}

		if ((clicked == false) && (e.getSource() == jbmulti)) {
			this.a = Double.parseDouble(jtextfield.getText());
			this.jtextfield.setText("");
			this.oper = 3;
			this.clicked = true;
		}

		if ((clicked == false) && (e.getSource() == jbdivide)) {
			this.a = Double.parseDouble(jtextfield.getText());
			this.jtextfield.setText("");
			this.oper = 4;
			this.clicked = true;
		}

		if ((clicked == true) && (e.getSource() == jbcalc)) {
			this.b = Double.parseDouble(jtextfield.getText());
			this.jtextfield.setText("");
			this.clicked = false;
			calculate(this.oper);

		}

		if (e.getSource() == jbsilnia) {
			this.n = Double.parseDouble(jtextfield.getText());
			this.jtextfield.setText("");
			this.oper = 5;
			calculate(this.oper);

		}

	}

	double silnia(double n) {
		double result;

		if (n == 0) {
			result = 1;
		} else {
			result = n * silnia(n - 1);

		}
		return result;
	}

}
