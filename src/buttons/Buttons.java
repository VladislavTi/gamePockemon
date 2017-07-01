package buttons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import main.Fight;
import pokemons.AllPokemons;
import pokemons.Charizar;
import pokemons.Chikorita;
import pokemons.Golem;
import pokemons.Pikachu;
import pokemons.Wartortle;




public class Buttons extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton choiseHero, startFigth, automaticFight, clear;
	
	public JLabel labBlock, labAtack, picMyHero, picCompHero, myHero, compHero, picTop, picTop2;
	public JLabel vs, empty, empty1, empty2, empty3, empty4, empty5, emp2, emp, emp1, emp3, myHealth, compHealth;
	
	public JLabel positionLabel;
	public JCheckBox positionAtack, positionBlock;
	
	public JTextField myHText, compHText;
	
	public JCheckBox headBlock, korpusBlock, legBlock, headAtack, korpusAtack, legAtack;

	public JTextArea tf;
	
	String [] pokemons = {"pikachu", "wartortle", "сharizar", "chikorita", "golem"};
	
	public JComboBox box;
	
	
	public Buttons(String s) {
		
		eHandler handler = new eHandler();
		
		setLayout(new FlowLayout());

		
		Font font = new Font(null, Font.BOLD, 25);
		
		myHText = new JTextField(10);
		
		compHText = new JTextField(10);
		
		positionLabel = new JLabel("Выберите позицию: ");
		
		positionAtack = new JCheckBox("Атакующая ");
		positionBlock = new JCheckBox("Защитная ");
		
		clear = new JButton("Clear");
		choiseHero = new JButton("Выберать");
		automaticFight = new JButton("Автоматичексий бой");
		
		startFigth = new JButton("Ударить");
		
		labBlock = new JLabel("Выберите один блок");
		labAtack = new JLabel("Выберите одну атаку");
		
		myHealth = new JLabel("Жизни:      ");
		compHealth = new JLabel("Жизни:      ");
		

		myHero = new JLabel("Ваш покемон");
		myHero.setFont(font);
		
		compHero = new JLabel("Покемон противника");
		compHero.setFont(font);
		
		headBlock = new JCheckBox("Блок головы");
		korpusBlock = new JCheckBox("Блок корпуса");
		legBlock = new JCheckBox("Блок ног");
		headAtack = new JCheckBox("Атака в голову");
		korpusAtack = new JCheckBox("Атака в корпус");
		legAtack = new JCheckBox("Атака в ноги");
		
		picMyHero = new JLabel((Icon) configButtons("pic/pikachuLife.png", 300, 300));
		picCompHero = new JLabel((Icon) configButtons("pic/wartortleLife.png", 300, 300));
		picTop = new JLabel((Icon) configButtons("pic/li.png", 300, 100));
		picTop2 = new JLabel((Icon) configButtons("pic/li.png", 300, 100));
		
		empty = new JLabel((Icon) configButtons("pic/empty.png", 50, 30));
		empty1 = new JLabel((Icon) configButtons("pic/empty.png", 200, 30));
		empty2 = new JLabel((Icon) configButtons("pic/empty.png", 100, 30));
		empty3 = new JLabel((Icon) configButtons("pic/empty.png", 220, 30)); 
		empty4 = new JLabel((Icon) configButtons("pic/empty.png", 85, 30));
		empty5 = new JLabel((Icon) configButtons("pic/empty.png", 215, 30));
		vs = new JLabel((Icon) configButtons("pic/vs.png", 200, 100));
		
		emp = new JLabel((Icon) configButtons("pic/empty.png", 100, 30));
		emp1 = new JLabel((Icon) configButtons("pic/empty.png", 240, 30));
		emp2 = new JLabel((Icon) configButtons("pic/empty.png", 240, 30));
		emp3 = new JLabel((Icon) configButtons("pic/empty.png", 300, 30)); 
		
		box = new JComboBox(pokemons);
		
		
		tf = new JTextArea(9, 70);
		
		
		JScrollPane scroll = new JScrollPane(tf);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setAutoscrolls(true);
		
		
		add(picTop);
		add(box);
		add(choiseHero);
		add(picTop2);
		
		add(labBlock);
		add(headBlock);
		add(korpusBlock);
		add(legBlock);
		add(empty);
		
		add(positionLabel);
		add(positionAtack);
		add(positionBlock);
		
		add(emp);
		add(labAtack);
		add(headAtack);
		add(korpusAtack);
		add(legAtack);
		add(empty1);

		add(empty2);
		add(myHero);
		add(empty3);
		add(compHero);
		add(empty4);

		add(myHealth);
		add(myHText);
		
		add(empty5);
		
		add(compHealth);
		add(compHText);
		
		add(emp1);
		add(startFigth);
		add(automaticFight);
		add(clear);
		add(emp2);
		add(scroll, BorderLayout.CENTER);
		
		
		
		add(picMyHero);
		add(vs);
		add(picCompHero);
		
		
		setEnableTop(true);
		setEnableBody(false);
		setEnableHealth(false);
		setEnableStartFight(false);
		setEnableAutoFight(false);
		setEnableClear(false);

		box.addActionListener(handler);
		choiseHero.addActionListener(handler);

		headBlock.addActionListener(handler);
		korpusBlock.addActionListener(handler);
		legBlock.addActionListener(handler);


		headAtack.addActionListener(handler);
		korpusAtack.addActionListener(handler);
		legAtack.addActionListener(handler);



		myHText.addActionListener(handler);
		compHText.addActionListener(handler);

		startFigth.addActionListener(handler);
		automaticFight.addActionListener(handler);
		clear.addActionListener(handler);
		
		
		positionAtack.addActionListener(handler);
		positionBlock.addActionListener(handler);
	}
	
	
	

	private void setEnableStartFight(boolean ans) {
		startFigth.setEnabled(ans);
	}
	
	private void setEnableAutoFight(boolean ans) {
		automaticFight.setEnabled(ans);
	}
	
	private void setEnableHealth(boolean ans) {
		myHText.setEnabled(ans);
		compHText.setEnabled(ans);
	}
	
	private void setEnableTop(boolean ans) {
		box.setEnabled(ans);
		choiseHero.setEnabled(ans);
	}
	
	private void setEnableClear(boolean ans) {
		clear.setEnabled(ans);
	}
	
	private void setEnableBody(boolean ans) {

		headBlock.setEnabled(ans);
		korpusBlock.setEnabled(ans);
		legBlock.setEnabled(ans);


		headAtack.setEnabled(ans);
		korpusAtack.setEnabled(ans);
		legAtack.setEnabled(ans);



		myHText.setEnabled(ans);
		compHText.setEnabled(ans);

		positionAtack.setEnabled(ans);
		positionBlock.setEnabled(ans);
	}

	

	
	
	
	
	public Object configButtons(String s, int x, int y) {
		ImageIcon icon = new ImageIcon(s);
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( x, y,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);
		
		return icon;
	}
	
	
	
	public class eHandler implements ActionListener {
		
		String myPokemon, compPokemon;
		int pos = 0; // 1 - защитная, 2 - атакующая
		int aPoint = 0, dPoint = 0;
		AllPokemons myPok, compPok;

		public void actionPerformed(ActionEvent act) {
			try {	
				
				whatButtonClick(act);
			} catch (Exception ex) {
				if (ex.getLocalizedMessage().equals("War is over")) {
					setEnableTop(false);
					setEnableBody(false);
					setEnableHealth(false);
					setEnableStartFight(false);
					setEnableAutoFight(false);
					setEnableClear(true);
				}
				JOptionPane.showMessageDialog(null, ex.getLocalizedMessage()); 
			}

		}
		

		private String choiseCompPokemon() {
			Random rn = new Random();
			int k = rn.nextInt(5);
			String pokemon = "pikachu";
			
			switch (k) {
			case 0:
				pokemon = "pikachu";
				this.compPok = createFighter(pokemon);
			break;
			case 1:
				pokemon = "wartortle";
				this.compPok = createFighter(pokemon);
			break;
			case 2:
				pokemon = "сharizar";
				this.compPok = createFighter(pokemon);
			break;
			case 3:
				pokemon = "chikorita";
				this.compPok = createFighter(pokemon);
			break;
			case 4:
				pokemon = "golem";
				this.compPok = createFighter(pokemon);
			break;
			}
			
			return pokemon;
		}
		
		
		private JLabel setCompPokemon(String who) {
			switch (who){
			case "pikachu":
				return new JLabel((Icon) configButtons("pic/pikachuLife.png", 300, 300));
			case "wartortle":
				return new JLabel((Icon) configButtons("pic/wartortleLife.png", 300, 300));
			case "сharizar":
				return new JLabel((Icon) configButtons("pic/charizard.png", 300, 300));
			case "chikorita":
				return new JLabel((Icon) configButtons("pic/chikorita.png", 300, 300));
			case "golem":
				return new JLabel((Icon) configButtons("pic/golem.png", 300, 300));
			}
			
			return null;
		}
		
		private void showHeros(String hero, JLabel label) {
			vs.setVisible(false);
			picCompHero.setVisible(false);
			
			this.myPokemon = hero;				
			
			this.compPokemon = choiseCompPokemon();
			
			picCompHero = setCompPokemon(this.compPokemon);
			
			vs = new JLabel((Icon) configButtons("pic/vs.png", 200, 100));
			
			add(label);
			add(vs);
			add(picCompHero);
		}


		private AllPokemons showMyHero(String hero){
			switch (hero){
			case "pikachu":
				picMyHero.setVisible(false);
				picMyHero = new JLabel((Icon) configButtons("pic/pikachuLife.png", 300, 300));
				showHeros(hero, picMyHero);
				return createFighter(hero);
			case "wartortle":
				picMyHero.setVisible(false);
				picMyHero = new JLabel((Icon) configButtons("pic/wartortleLife.png", 300, 300));
				showHeros(hero, picMyHero);
				return createFighter(hero);
			case "сharizar":
				picMyHero.setVisible(false);
				picMyHero = new JLabel((Icon) configButtons("pic/charizard.png", 300, 300));
				showHeros(hero, picMyHero);
				return createFighter(hero);
			case "chikorita":
				picMyHero.setVisible(false);
				picMyHero = new JLabel((Icon) configButtons("pic/chikorita.png", 300, 300));
				showHeros(hero, picMyHero);
				return createFighter(hero);
			case "golem":
				picMyHero.setVisible(false);
				picMyHero = new JLabel((Icon) configButtons("pic/golem.png", 300, 300));
				showHeros(hero, picMyHero);
				return createFighter(hero);
			}
			return null;
		}
		
		private AllPokemons createFighter(String who) {
			switch (who){
			
			case "pikachu":
				return new Pikachu(who, 100, 100, 100, 100);
			case "wartortle":
				return new Wartortle(who, 100, 100, 100, 100);
			case "сharizar":
				return new Charizar(who, 100, 100, 100, 100);
			case "chikorita":
				return new Chikorita(who, 100, 100, 100, 100);
			case "golem":
				return new Golem(who, 100, 100, 100, 100);
			}
			
			
			return null;
			
		}
		
		
		private void whatButtonClick(ActionEvent e) throws InterruptedException {
			
			// выбор героя
			if (e.getSource() == choiseHero) {
				
				setEnableTop(false);
				setEnableBody(true);
				setEnableHealth(false);
				setEnableStartFight(true);
				setEnableAutoFight(true);
				setEnableClear(false);
				
				
				String hero = (String) box.getSelectedItem();
				
				this.myPok = showMyHero(hero);
				
				tf.setText("Начался бой между " + this.myPok.getName() + "(" + this.myPok.getHealth() + ") и " + this.compPok.getName() + "(" + this.compPok.getHealth() + ")\n");
				
				myHText.setText(String.format("%s(%s) / %s(%s)", this.myPok.zhizn, this.myPok.zhizn, this.myPok.vinoslivost, this.myPok.vinoslivost));
				compHText.setText(String.format("%s(%s) / %s(%s)",this.compPok.zhizn, this.compPok.zhizn, this.compPok.vinoslivost, this.compPok.vinoslivost));
				
			}
			
			if (e.getSource() == positionAtack) {
				this.pos = 2;
				positionBlock.setSelected(false);
			}
			
			if (e.getSource() == positionBlock) {
				this.pos = 1;
				positionAtack.setSelected(false);
			}
			
			
			if (e.getSource() == headAtack) {
				this.aPoint = 1;
				korpusAtack.setSelected(false);
				legAtack.setSelected(false);
			}
			
			if (e.getSource() == korpusAtack) {
				this.aPoint = 2;
				headAtack.setSelected(false);
				legAtack.setSelected(false);
			}
			
			if (e.getSource() == legAtack) {
				this.aPoint = 3;
				korpusAtack.setSelected(false);
				headAtack.setSelected(false);
			}
			
			if (e.getSource() == headBlock) {
				this.dPoint = 1;
				korpusBlock.setSelected(false);
				legBlock.setSelected(false);
			}
			
			if (e.getSource() == korpusBlock) {
				this.dPoint = 2;
				headBlock.setSelected(false);
				legBlock.setSelected(false);
			}
			
			if (e.getSource() == legBlock) {
				this.dPoint = 3;
				headBlock.setSelected(false);
				korpusBlock.setSelected(false);
			}
			
			if (e.getSource() == automaticFight) {
				
				setEnableTop(false);
				setEnableBody(false);
				setEnableHealth(false);
				setEnableStartFight(false);
				setEnableAutoFight(false);
				setEnableClear(true);
				
				AllPokemons my = this.myPok;
				AllPokemons comp = this.compPok;
				
				Random rn = new Random();
				
			//	Fight fight = new Fight();
				
				Timer tim = new Timer();
				tim.schedule(new Fight(my, comp, tf, myHText, compHText, rn.nextInt(2)+1, rn.nextInt(3)+1, rn.nextInt(3)+1), 0, TimeUnit.SECONDS.toMillis(1));
				
				Thread.sleep(1000);
				tim.cancel();
				
				
			}
			
			
			if (e.getSource() == startFigth) {
				
				
				setEnableTop(false);
				setEnableBody(true);
				setEnableHealth(false);
				setEnableStartFight(true);
				setEnableAutoFight(true);
				setEnableClear(false);
				
				headAtack.setSelected(false);
				korpusAtack.setSelected(false);
				legAtack.setSelected(false);
				
				headBlock.setSelected(false);
				korpusBlock.setSelected(false);
				legBlock.setSelected(false);
				
				positionAtack.setSelected(false);
				positionBlock.setSelected(false);
				
				
				if ((this.pos != 0) && (this.aPoint != 0) && (this.dPoint != 0)) {
					
					
					
				Fight oneFight = new Fight(this.myPok, this.compPok, tf, myHText, compHText, this.pos, this.aPoint, this.dPoint);
					
				if (oneFight.oneAtack()) {
					throw new InterruptedException("War is over");
				}
					
					
				} else if (this.pos == 0) {
					throw new InterruptedException("Выберите позицию");
				} else if (this.aPoint == 0) {
					throw new InterruptedException("Выберите атаку");
				} else if (this.dPoint == 0) {
					throw new InterruptedException("Выберите защиту");
				}
				

				
				
			}
			
			
			if (e.getSource() == clear) {
				tf.setText("");
				myHText.setText("");
				compHText.setText("");
				
				setEnableTop(true);
				setEnableBody(false);
				setEnableHealth(false);
				setEnableStartFight(false);
				setEnableAutoFight(false);
				setEnableClear(false);
			}
			

			
		}
		

		
		
	}
	
	
	
	
}
