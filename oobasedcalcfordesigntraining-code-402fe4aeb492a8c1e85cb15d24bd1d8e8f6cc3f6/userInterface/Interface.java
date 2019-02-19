/* Copyright (c) 2014
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import actions.AdditionOperatorAction;
import actions.ClearAction;
import actions.DecimalMarkAction;
import actions.DigitAction;
import actions.EqualsOperatorAction;
import actions.MultiplicationOperatorAction;
import buttons.AdditionOperatorButton;
import buttons.AverageOperatorButton;
import buttons.BackspaceButton;
import buttons.ClearButton;
import buttons.DecimalMarkButton;
import buttons.DigitButton;
import buttons.DivisionOperatorButton;
import buttons.EqualsOperatorButton;
import buttons.MemoryClearButton;
import buttons.MemoryReadButton;
import buttons.MemorySaveButton;
import buttons.MultiplicationOperatorButton;
import buttons.NegationButton;
import buttons.PercentageButton;
import buttons.ReciprocalButton;
import buttons.SqrtButton;
import buttons.SubtractionOperatorButton;
import buttons.TangentButton;
import common.ApplicationState;
import common.NumberStack;
import net.miginfocom.swing.MigLayout;

public class Interface implements ActionListener{

	private JFrame frame;
	private JTextField textWindow;
	private int width = 270;
	private int height = 230;
	
	JPanel ButtonPanel;
	private JTextField historyWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[241px,grow]", "[20px][][37px][118px]"));
		
		historyWindow = new JTextField();
		historyWindow.setHorizontalAlignment(SwingConstants.RIGHT);
		historyWindow.setBackground(Color.WHITE);
		historyWindow.setEditable(false);
		historyWindow.setVisible(false);
		frame.getContentPane().add(historyWindow, "cell 0 0,growx");
		historyWindow.setColumns(10);
		
		textWindow = new JTextField();
		textWindow.setBackground(Color.WHITE);
		textWindow.setEditable(false);
		textWindow.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(textWindow, "cell 0 1,growx,aligny top");
		textWindow.setColumns(10);
		ApplicationState.setTextWindow(textWindow);
		ApplicationState.setHistoryWindow(historyWindow);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "cell 0 2,grow");
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[80px][][][][]", "[23px]"));
		
		BackspaceButton btnBackspace = new BackspaceButton("Backspace");
		panel_2.add(btnBackspace, "cell 0 0");
		
		ClearButton button_clear = new ClearButton("C");
		panel_2.add(button_clear, "cell 1 0,grow");
		
		MemorySaveButton btnMs = new MemorySaveButton("MS");
		panel_2.add(btnMs, "cell 2 0");
		
		MemoryReadButton btnMr = new MemoryReadButton("MR");
		panel_2.add(btnMr, "cell 3 0");
		
		MemoryClearButton btnMc = new MemoryClearButton("MC");
		panel_2.add(btnMc, "cell 4 0");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 3,grow");
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ButtonPanel = new JPanel();
		panel.add(ButtonPanel);
		ButtonPanel.setLayout(new MigLayout("", "[][][][][]", "[][][][]"));
		
		DigitButton button_7 = new DigitButton("7");
		ButtonPanel.add(button_7, "cell 0 0,growx");
		
		DigitButton button_8 = new DigitButton("8");
		ButtonPanel.add(button_8, "cell 1 0,growx");
		
		DigitButton button_9_ = new DigitButton("9");
		ButtonPanel.add(button_9_, "cell 2 0,growx");
		
		DivisionOperatorButton button_division = new DivisionOperatorButton("/");
		ButtonPanel.add(button_division, "cell 3 0,growx");
		
		SqrtButton btnSqrt = new SqrtButton("sqrt");
		ButtonPanel.add(btnSqrt, "cell 4 0,growx");
		
		DigitButton button_4 = new DigitButton("4");
		ButtonPanel.add(button_4, "cell 0 1,growx");
		
		DigitButton button_5 = new DigitButton("5");
		ButtonPanel.add(button_5, "cell 1 1,growx");
		
		DigitButton button_6 = new DigitButton("6");
		ButtonPanel.add(button_6, "cell 2 1,growx");
		
		MultiplicationOperatorButton button_multiplication = new MultiplicationOperatorButton("*");
		ButtonPanel.add(button_multiplication, "cell 3 1,growx");
		
		PercentageButton btnNewButton = new PercentageButton("%");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ButtonPanel.add(btnNewButton, "cell 4 1,growx");
		
		DigitButton button_1 = new DigitButton("1");
		ButtonPanel.add(button_1, "cell 0 2,growx");
		
		DigitButton button_2 = new DigitButton("2");
		ButtonPanel.add(button_2, "cell 1 2,growx");
		
		DigitButton button_3 = new DigitButton("3");
		ButtonPanel.add(button_3, "cell 2 2,growx");
		
		SubtractionOperatorButton button_subtraction = new SubtractionOperatorButton("-");
		ButtonPanel.add(button_subtraction, "cell 3 2,growx");
		
		ReciprocalButton btnx = new ReciprocalButton("1/x");
		ButtonPanel.add(btnx, "cell 4 2,growx");
		
		DigitButton button_0 = new DigitButton("0");
		ButtonPanel.add(button_0, "cell 0 3,growx");
		
		DecimalMarkButton button_decimal = new DecimalMarkButton(",");
		ButtonPanel.add(button_decimal, "cell 1 3,growx");
		
		EqualsOperatorButton button_equals = new EqualsOperatorButton("=");
		ButtonPanel.add(button_equals, "cell 2 3");
		
		AdditionOperatorButton button_addition = new AdditionOperatorButton("+");
		ButtonPanel.add(button_addition, "cell 3 3,growx");
		
		NegationButton button = new NegationButton("+/-");
		ButtonPanel.add(button, "cell 4 3,growx");
		//frame.setSize(width, height);
		
		TangentButton tanButton = new TangentButton("Tan");
		ButtonPanel.add(tanButton, "cell 5 2,growx");
		
		AverageOperatorButton button_average = new AverageOperatorButton("AVG");
		ButtonPanel.add(button_average, "cell 5 3,growx");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnProgram = new JMenu("Program");
		menuBar.add(mnProgram);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ClearAction());
		mnProgram.add(mntmReset);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmHistory = new JMenuItem("History");
		mntmHistory.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
				boolean value = !historyWindow.isVisible();
				historyWindow.setVisible(value);
			}
		});
		mnView.add(mntmHistory);
		setupKeymap();
		ApplicationState.updateTextWindow();
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NumberStack numberStack = ApplicationState.getNumberStack();
		if(numberStack.size() > 0){
			textWindow.setText(numberStack.peek().toString());
			ApplicationState.updateTextWindow();
		}
	}
	
	public void setupKeymap(){
		// Set up digits 0-9
		for(int i = 0; i < 10; ++i){
			String digit = Integer.toString(i);
			ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(digit),
					digit);
			ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD"+digit),
					digit);
			ButtonPanel.getActionMap().put(digit,
							new DigitAction(digit));
		}
		
		// Set up arithmetic operators
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
                0), "plus");
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD,
                0), "plus");
		ButtonPanel.getActionMap().put("plus",
						new AdditionOperatorAction());
		
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY,
                0), "multiply");
		ButtonPanel.getActionMap().put("multiply",
						new MultiplicationOperatorAction());
		
		// Shift + 0 gives "=" on swedish key layout
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0,
				KeyEvent.SHIFT_DOWN_MASK), "equals");
		
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
						0), "equals");

		ButtonPanel.getActionMap().put("equals",
				new EqualsOperatorAction());
		
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA,
				0), "DecimalMark");
		
		ButtonPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD,
				0), "DecimalMark");
		
		ButtonPanel.getActionMap().put("DecimalMark",
				new DecimalMarkAction());		
	}

}
