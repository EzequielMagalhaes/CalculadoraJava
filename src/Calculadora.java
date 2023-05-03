import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculadora implements ActionListener{

	JFrame frame;
	JTextField textField;
	JButton[] botoesNumericos = new JButton[10];
	JButton[] botoesFuncionais = new JButton[9]; // pois tem nove botões.
	JButton botaoSoma,botaoSubtracao,botaoMultiplicacao,botaoDivisao;
	JButton botaoDecimal, botaoIgual, botaoDeletar, botaoLimpar, botaoNegativo;
	JPanel panel;
	
	Font myFont = new Font("Lato", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, resultado = 0;
	char operador;
	
	Calculadora(){ // Construtor.
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,600); //420, 550.
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 35, 300, 60); // x, y, width, height.
		textField.setFont(myFont);
		textField.setEditable(false); // Deixa o 'visor' estático. Letras e operações serão implementadas na tela pelo teclado numérico.
		
		botaoSoma = new JButton("+");
		botaoSubtracao = new JButton("-");
		botaoMultiplicacao = new JButton("*");
		botaoDivisao = new JButton("/");
		botaoDecimal = new JButton(".");
		botaoIgual = new JButton("=");
		botaoDeletar = new JButton("Apagar");
		botaoLimpar = new JButton("Limpar");
		botaoNegativo = new JButton("-/+");
		
		botoesFuncionais[0] = botaoSoma;
		botoesFuncionais[1] = botaoSubtracao;
		botoesFuncionais[2] = botaoMultiplicacao;
		botoesFuncionais[3] = botaoDivisao;
		botoesFuncionais[4] = botaoDecimal;
		botoesFuncionais[5] = botaoIgual;
		botoesFuncionais[6] = botaoDeletar;
		botoesFuncionais[7] = botaoLimpar;
		botoesFuncionais[8] = botaoNegativo;
		
		for(int i = 0; i < 9; i++) { //'i < 9' pois 9 é o tamanho do array.
			botoesFuncionais[i].addActionListener(this);
			botoesFuncionais[i].setFont(myFont);
			botoesFuncionais[i].setFocusable(false); // Desabilita o contorno do botão quando ele é clicado.
		}
		
		for(int i = 0; i < 10; i++) {
			botoesNumericos[i] = new JButton(String.valueOf(i));
			botoesNumericos[i].addActionListener(this);
			botoesNumericos[i].setFont(myFont);
			botoesNumericos[i].setFocusable(false);
		}
		
		botaoNegativo.setBounds(165,440,70,50); // x, y, width, height.
		botaoDeletar.setBounds(50,490,145,50);
		botaoLimpar.setBounds(205,490,145,50);
		
		panel = new JPanel();
		panel.setBounds(50,130,300,300);
		panel.setLayout(new GridLayout(4,4,15,15)); //linhas, colunas, espaçamento, espaçamento.
		//panel.setBackground(Color.gray); //para visualizar onde está esse layout.
		panel.add(botoesNumericos[7]);
		panel.add(botoesNumericos[8]);
		panel.add(botoesNumericos[9]);
		panel.add(botaoDivisao);
		panel.add(botoesNumericos[4]);
		panel.add(botoesNumericos[5]);
		panel.add(botoesNumericos[6]);
		panel.add(botaoMultiplicacao);
		panel.add(botoesNumericos[1]);
		panel.add(botoesNumericos[2]);
		panel.add(botoesNumericos[3]);
		panel.add(botaoSubtracao);
		panel.add(botaoDecimal);
		panel.add(botoesNumericos[0]);
		panel.add(botaoIgual);
		panel.add(botaoSoma);
		
		frame.add(panel);
		frame.add(botaoNegativo);
		frame.add(botaoDeletar);
		frame.add(botaoLimpar);
		frame.add(textField);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == botoesNumericos[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == botaoDecimal) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource() == botaoSoma) {
			num1 = Double.parseDouble(textField.getText());
			operador = '+';
			textField.setText("");
		}
		if(e.getSource() == botaoSubtracao) {
			num1 = Double.parseDouble(textField.getText());
			operador = '-';
			textField.setText("");
		}
		if(e.getSource() == botaoMultiplicacao) {
			num1 = Double.parseDouble(textField.getText());
			operador = '*';
			textField.setText("");
		}
		if(e.getSource() == botaoDivisao) {
			num1 = Double.parseDouble(textField.getText());
			operador = '/';
			textField.setText("");
		}
		if(e.getSource() == botaoIgual) {
			num2 = Double.parseDouble(textField.getText());
			switch(operador) {
			case '+':
				resultado = num1 + num2;
				break;
			case '-':
				resultado = num1 - num2;
				break;
			case '*':
				resultado = num1 * num2;
				break;
			case '/':
				resultado = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(resultado));
			num1 = resultado;
		}
		if(e.getSource() == botaoLimpar) {
			textField.setText("");
		}
		if(e.getSource() == botaoDeletar) {
			String string = textField.getText();
			textField.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		if(e.getSource() == botaoNegativo) {
			double temp = Double.parseDouble(textField.getText()); //Armazena o valor temporariamente, para inverter o sinal.
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}
}