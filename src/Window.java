import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Window extends JFrame implements ActionListener{
	
	PolynomialProcessor processor;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstPolyInput;
	private JTextField secondPolyInput;
	private JLabel valueLabel;
	private JTextField valueInput;
	private JLabel resultLabel;
	private JTextField polyOutput;
	private JLabel firstPolyLabel;
	private JLabel secondPolyLabel;
	private JButton firstPolyInsert;
	private JButton secondPolyInsert;
	private JButton valueInsert;
	private JButton addButton;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton devideButton;
	private JButton scalarMulButton;
	private JButton scalarDevideButton;
	private JButton integrateButton;
	private JButton differentiateButton;
	private JButton atPointButton;
	private JTextField quoOutput;
	private JTextField remOutput;
	private JLabel quotientLabel;
	private JLabel remainderLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Window() {
		
		processor = new PolynomialProcessor();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 504);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstPolyLabel = new JLabel("Polynomial 1");
		firstPolyLabel.setForeground(Color.GRAY);
		firstPolyLabel.setBackground(Color.LIGHT_GRAY);
		firstPolyLabel.setBounds(26, 24, 86, 21);
		contentPane.add(firstPolyLabel);
		
		secondPolyLabel = new JLabel("Polynomial 2");
		secondPolyLabel.setForeground(Color.GRAY);
		secondPolyLabel.setBounds(26, 88, 86, 21);
		contentPane.add(secondPolyLabel);
		
		valueLabel = new JLabel("Value");
		valueLabel.setForeground(Color.GRAY);
		valueLabel.setBounds(25, 168, 46, 14);
		contentPane.add(valueLabel);
		
		resultLabel = new JLabel("Result");
		resultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		resultLabel.setBounds(59, 284, 99, 26);
		contentPane.add(resultLabel);
		
		firstPolyInput = new JTextField();
		firstPolyInput.setBounds(10, 45, 282, 32);
		contentPane.add(firstPolyInput);
		firstPolyInput.setColumns(10);
		
		secondPolyInput = new JTextField();
		secondPolyInput.setBounds(10, 109, 282, 32);
		contentPane.add(secondPolyInput);
		secondPolyInput.setColumns(10);
		
		valueInput = new JTextField();
		valueInput.setBounds(10, 188, 79, 22);
		contentPane.add(valueInput);
		valueInput.setColumns(10);
		
		polyOutput = new JTextField();
		polyOutput.setDisabledTextColor(Color.BLACK);
		polyOutput.setSelectionColor(Color.DARK_GRAY);
		polyOutput.setEditable(false);
		polyOutput.setBounds(26, 321, 384, 32);
		contentPane.add(polyOutput);
		polyOutput.setColumns(10);
		
		firstPolyInsert = new JButton("Insert Polynomial");
		firstPolyInsert.addActionListener(this);
		firstPolyInsert.setBackground(Color.GRAY);
		firstPolyInsert.setBounds(323, 51, 79, 21);
		contentPane.add(firstPolyInsert);
		
		secondPolyInsert = new JButton("Insert Polynomial");
		secondPolyInsert.setBackground(Color.GRAY);
		secondPolyInsert.addActionListener(this);
		secondPolyInsert.setBounds(323, 115, 79, 21);
		contentPane.add(secondPolyInsert);
		
		valueInsert = new JButton("Insert");
		valueInsert.addActionListener(this);
		valueInsert.setBackground(Color.GRAY);
		valueInsert.setBounds(116, 187, 71, 23);
		contentPane.add(valueInsert);
		
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		addButton.setForeground(Color.WHITE);
		addButton.setBackground(Color.DARK_GRAY);
		addButton.setBounds(472, 50, 89, 23);
		contentPane.add(addButton);
		
		subtractButton = new JButton("Subtract");
		subtractButton.addActionListener(this);
		subtractButton.setForeground(Color.WHITE);
		subtractButton.setBackground(Color.DARK_GRAY);
		subtractButton.setBounds(472, 99, 89, 23);
		contentPane.add(subtractButton);
		
		multiplyButton = new JButton("Multiply");
		multiplyButton.addActionListener(this);
		multiplyButton.setBackground(Color.DARK_GRAY);
		multiplyButton.setForeground(Color.WHITE);
		multiplyButton.setBounds(472, 144, 89, 23);
		contentPane.add(multiplyButton);
		
		devideButton = new JButton("Devide");
		devideButton.addActionListener(this);
		devideButton.setBackground(Color.DARK_GRAY);
		devideButton.setForeground(Color.WHITE);
		devideButton.setBounds(472, 188, 89, 23);
		contentPane.add(devideButton);
		
		scalarMulButton = new JButton("Multiply by scalar");
		scalarMulButton.addActionListener(this);
		scalarMulButton.setForeground(Color.WHITE);
		scalarMulButton.setBackground(Color.DARK_GRAY);
		scalarMulButton.setBounds(604, 50, 115, 23);
		contentPane.add(scalarMulButton);
		
		scalarDevideButton = new JButton("Devide by scalar");
		scalarDevideButton.addActionListener(this);
		scalarDevideButton.setBackground(Color.DARK_GRAY);
		scalarDevideButton.setForeground(Color.WHITE);
		scalarDevideButton.setBounds(604, 99, 115, 23);
		contentPane.add(scalarDevideButton);
		
		integrateButton = new JButton("Integrate");
		integrateButton.addActionListener(this);
		integrateButton.setForeground(Color.WHITE);
		integrateButton.setBackground(Color.DARK_GRAY);
		integrateButton.setBounds(604, 144, 115, 23);
		contentPane.add(integrateButton);
		
		differentiateButton = new JButton("Differentiate");
		differentiateButton.addActionListener(this);
		differentiateButton.setBackground(Color.DARK_GRAY);
		differentiateButton.setForeground(Color.WHITE);
		differentiateButton.setBounds(604, 188, 115, 23);
		contentPane.add(differentiateButton);
		
		atPointButton = new JButton("Value at the point");
		atPointButton.addActionListener(this);
		atPointButton.setForeground(Color.WHITE);
		atPointButton.setBackground(Color.DARK_GRAY);
		atPointButton.setBounds(604, 233, 115, 23);
		contentPane.add(atPointButton);
		
		quoOutput = new JTextField();
		quoOutput.setEditable(false);
		quoOutput.setBounds(26, 411, 188, 26);
		contentPane.add(quoOutput);
		quoOutput.setColumns(10);
		
		remOutput = new JTextField();
		remOutput.setEditable(false);
		remOutput.setBounds(240, 411, 170, 26);
		contentPane.add(remOutput);
		remOutput.setColumns(10);
		
		quotientLabel = new JLabel("Quotient");
		quotientLabel.setBounds(35, 386, 54, 14);
		contentPane.add(quotientLabel);
		
		remainderLabel = new JLabel("Remainder");
		remainderLabel.setBounds(251, 386, 86, 14);
		contentPane.add(remainderLabel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == firstPolyInsert){
			try{
			processor.polyFactoringA(firstPolyInput.getText());
			polyOutput.setText(processor.getA().toString());
			}catch(Exception ex){
				polyOutput.setText("Couldn't parse polynomial 1!");
			}
		}else if(e.getSource() == secondPolyInsert){
			try{
				processor.polyFactoringB(secondPolyInput.getText());
				polyOutput.setText(processor.getB().toString());
				}catch(Exception ex){
					polyOutput.setText("Couldn't parse polynomial 2!");
				}
		}
		if(e.getSource() == valueInsert){
			try{
			processor.setValue(Integer.parseInt(valueInput.getText()));
			polyOutput.setText(processor.getValue()+"");
			}catch(Exception ex){
				polyOutput.setText("Couldn't parse value!");
			}
		}else if(e.getSource() == addButton){
			try{
				processor.add(processor.getA(), processor.getB());
				polyOutput.setText(processor.getRes().toString());
				}catch(Exception ex){
					polyOutput.setText("Addition bug!");
				}
		}else if(e.getSource() == subtractButton){
			try{
				
				polyOutput.setText(processor.subtract(processor.getA(), processor.getB()).toString());
				}catch(Exception ex){
					polyOutput.setText("Subtraction bug!");
				}
		}
		else if(e.getSource() == multiplyButton){
			try{
				polyOutput.setText(processor.multiply(processor.getA(), processor.getB()).toString());
				}catch(Exception ex){
					polyOutput.setText("Multiplication bug!");
				}
		}else if(e.getSource() == devideButton){
			try{
				processor.divide(processor.getA(), processor.getB());
				quoOutput.setText(processor.getQuotient().toString());
				remOutput.setText(processor.getRemainder().toString());
				polyOutput.setText("");
				}catch(Exception ex){
					polyOutput.setText("Division bug!");
				}
		}else if(e.getSource() == scalarDevideButton){
			try{
				processor.scalarDiv(processor.getA(), processor.getValue());
				polyOutput.setText(processor.getA().toString());
				}catch(Exception ex){
					polyOutput.setText("Scalar division problem!");
				}
		}else if(e.getSource() == scalarMulButton){
			try{
				processor.scalarMul(processor.getA(), processor.getValue());
				polyOutput.setText(processor.getA().toString());
				}catch(Exception ex){
					polyOutput.setText("Scalar multiplication problem!");
				}
		}
		else if(e.getSource() == integrateButton){
			try{
				polyOutput.setText(processor.integrate(processor.getA()).toString()+"+ C");
				}catch(Exception ex){
					polyOutput.setText("Integration problem!");
				}
		}else if(e.getSource() == differentiateButton){
			try{
				polyOutput.setText(processor.diff(processor.getA()).toString());
				}catch(Exception ex){
					polyOutput.setText("Differentiation problem!");
				}
		}else if(e.getSource() == atPointButton){
			try{
				polyOutput.setText(processor.atPoint(processor.getA(), processor.getValue())+"");
				}catch(Exception ex){
					polyOutput.setText("Something wrong!");
				}
		}
	}
}
