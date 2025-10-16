package uo.cpm.p5.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.p5.model.Operaciones;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;
	private JButton btMas;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton btMenos;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton btPor;
	private JButton bt0;
	private JButton btIgual;
	private JTextField txtResultado;
	
	private Operaciones op;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Operaciones op) {
		this.op = op;
		setTitle("Calculadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 674);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBt7());
		contentPane.add(getBt8());
		contentPane.add(getBt9());
		contentPane.add(getBtMas());
		contentPane.add(getBt4());
		contentPane.add(getBt5());
		contentPane.add(getBt6());
		contentPane.add(getBtMenos());
		contentPane.add(getBt1());
		contentPane.add(getBt2());
		contentPane.add(getBt3());
		contentPane.add(getBtPor());
		contentPane.add(getBt0());
		contentPane.add(getBtIgual());
		contentPane.add(getTxtResultado());
	}
	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton("7");
			bt7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt7);
				}
			});
			bt7.setForeground(Color.WHITE);
			bt7.setBackground(Color.LIGHT_GRAY);
			bt7.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt7.setBounds(35, 150, 98, 88);
		}
		return bt7;
	}
	
	private JButton getBt8() {
		if (bt8 == null) {
			bt8 = new JButton("8");
			bt8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt8);
				}
			});
			bt8.setBackground(Color.LIGHT_GRAY);
			bt8.setForeground(Color.WHITE);
			bt8.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt8.setBounds(154, 150, 98, 88);
		}
		return bt8;
	}
	
	private JButton getBt9() {
		if (bt9 == null) {
			bt9 = new JButton("9");
			bt9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt9);
				}
			});
			bt9.setForeground(Color.WHITE);
			bt9.setBackground(Color.LIGHT_GRAY);
			bt9.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt9.setBounds(272, 150, 98, 88);
		}
		return bt9;
	}
	
	private JButton getBtMas() {
		if (btMas == null) {
			btMas = new JButton("+");
			btMas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					op.guardarOperador("+", getTxtResultado().getText());
				}
			});
			btMas.setBackground(Color.LIGHT_GRAY);
			btMas.setForeground(Color.WHITE);
			btMas.setFont(new Font("Tahoma", Font.PLAIN, 50));
			btMas.setBounds(392, 150, 85, 79);
		}
		return btMas;
	}
	
	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("4");
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt4);
				}
			});
			bt4.setForeground(Color.WHITE);
			bt4.setBackground(Color.LIGHT_GRAY);
			bt4.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt4.setBounds(35, 261, 98, 88);
		}
		return bt4;
	}
	
	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("5");
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt5);
				}
			});
			bt5.setBackground(Color.LIGHT_GRAY);
			bt5.setForeground(Color.WHITE);
			bt5.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt5.setBounds(154, 261, 98, 88);
		}
		return bt5;
	}
	
	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("6");
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt6);
				}
			});
			bt6.setForeground(Color.WHITE);
			bt6.setBackground(Color.LIGHT_GRAY);
			bt6.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt6.setBounds(272, 261, 98, 88);
		}
		return bt6;
	}
	
	private JButton getBtMenos() {
		if (btMenos == null) {
			btMenos = new JButton("-");
			btMenos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					op.guardarOperador("-", getTxtResultado().getText());
				}
			});
			btMenos.setBackground(Color.LIGHT_GRAY);
			btMenos.setForeground(Color.WHITE);
			btMenos.setFont(new Font("Tahoma", Font.PLAIN, 50));
			btMenos.setBounds(392, 261, 85, 79);
		}
		return btMenos;
	}
	
	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("1");
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt1);
				}
			});
			bt1.setForeground(Color.WHITE);
			bt1.setBackground(Color.LIGHT_GRAY);
			bt1.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt1.setBounds(35, 378, 98, 88);
		}
		return bt1;
	}
	
	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("2");
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt2);
				}
			});
			bt2.setBackground(Color.LIGHT_GRAY);
			bt2.setForeground(Color.WHITE);
			bt2.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt2.setBounds(154, 378, 98, 88);
		}
		return bt2;
	}
	
	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("3");
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt3);
				}
			});
			bt3.setForeground(Color.WHITE);
			bt3.setBackground(Color.LIGHT_GRAY);
			bt3.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt3.setBounds(272, 378, 98, 88);
		}
		return bt3;
	}
	
	private JButton getBtPor() {
		if (btPor == null) {
			btPor = new JButton("x");
			btPor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					op.guardarOperador("x", getTxtResultado().getText());
				}
			});
			btPor.setBackground(Color.LIGHT_GRAY);
			btPor.setForeground(Color.WHITE);
			btPor.setFont(new Font("Tahoma", Font.PLAIN, 50));
			btPor.setBounds(392, 378, 85, 79);
		}
		return btPor;
	}
	
	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("0");
			bt0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarBoton(bt0);
				}
			});
			bt0.setForeground(Color.WHITE);
			bt0.setBackground(Color.LIGHT_GRAY);
			bt0.setFont(new Font("Tahoma", Font.PLAIN, 50));
			bt0.setBounds(35, 493, 98, 88);
		}
		return bt0;
	}
	
	private JButton getBtIgual() {
		if (btIgual == null) {
			btIgual = new JButton("=");
			btIgual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					op.guardarNumero2(getTxtResultado().getText());
					getTxtResultado().setText(String.valueOf(op.calcularOperacion()));
					desactivarBotones();
				}
			});
			btIgual.setBackground(Color.LIGHT_GRAY);
			btIgual.setForeground(Color.WHITE);
			btIgual.setFont(new Font("Tahoma", Font.PLAIN, 50));
			btIgual.setBounds(154, 493, 323, 88);
		}
		return btIgual;
	}
	
	private JTextField getTxtResultado() {
		if (txtResultado == null) {
			txtResultado = new JTextField();
			txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
			txtResultado.setEditable(false);
			txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 50));
			txtResultado.setBounds(35, 28, 442, 93);
			txtResultado.setColumns(10);
		}
		return txtResultado;
	}
	
	private void mostrarBoton(JButton boton) {
		getTxtResultado().setText(boton.getText());
	}
		
	private void desactivarBotones() {
	    bt0.setEnabled(false);
	    bt1.setEnabled(false);
	    bt2.setEnabled(false);
	    bt3.setEnabled(false);
	    bt4.setEnabled(false);
	    bt5.setEnabled(false);
	    bt6.setEnabled(false);
	    bt7.setEnabled(false);
	    bt8.setEnabled(false);
	    bt9.setEnabled(false);
	    btMas.setEnabled(false);
	    btMenos.setEnabled(false);
	    btPor.setEnabled(false);
	    btIgual.setEnabled(false);
	}

}

