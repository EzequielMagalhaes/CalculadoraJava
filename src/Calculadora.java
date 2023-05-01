import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculadora implements ActionListener{

	JFrame frame;
	JTextField textField;
	JButton[] botoesNumericos = new JButton[10];
	JButton[] botoesFuncionais = new JButton[8]; // pois tem oito botões.
	JButton botaoSoma,botaoSubtracao,botaoMultiplicacao,botaoDivisao;
	JButton botaoDecimal, botaoIgual, botaoDelete, botaoLimpar;
	JPanel panel;
	
//	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, resultado = 0;
	char operador;
	
	Calculadora(){ // Construtor.
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,600); //420, 550
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50); // x, y, width, height
//		textField.setFont(myFont);
		textField.setEditable(false); // Deixa o 'visor' estático. Letras e operações serão implementadas na tela pelo teclado numérico.
		
		botaoSoma = new JButton("+");
		botaoSubtracao = new JButton("-");
		botaoMultiplicacao = new JButton("*");
		botaoDivisao = new JButton("/");
		botaoDecimal = new JButton(".");
		botaoIgual = new JButton("=");
		botaoDelete = new JButton("<-");
		botaoLimpar = new JButton("Limpar");
		
		botoesFuncionais[0] = botaoSoma;
		botoesFuncionais[1] = botaoSubtracao;
		botoesFuncionais[2] = botaoMultiplicacao;
		botoesFuncionais[3] = botaoDivisao;
		botoesFuncionais[4] = botaoDecimal;
		botoesFuncionais[5] = botaoIgual;
		botoesFuncionais[6] = botaoDelete;
		botoesFuncionais[7] = botaoLimpar;
		
		for(int i = 0; i < 8; i++) { //'i < 8' pois 8 é o tamanho do array.
			botoesFuncionais[i].addActionListener(this);
//			botoesFuncionais[i].setFont(myFont);
			botoesFuncionais[i].setFocusable(false); // Desabilita o contorno do botão quando ele é clicado.
		}
		
		for(int i = 0; i < 10; i++) {
			botoesNumericos[i] = new JButton(String.valueOf(i));
			botoesNumericos[i].addActionListener(this);
//			botoesFuncionais[i].setFont(myFont);
			botoesNumericos[i].setFocusable(false);
		}
		
		frame.add(textField);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}