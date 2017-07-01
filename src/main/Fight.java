package main;

import java.util.Random;
import java.util.TimerTask;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import pokemons.AllPokemons;
import pokemons.Pikachu;

public class Fight extends TimerTask{
	
	
	public AllPokemons m, com;
	public JTextArea textAr;
	public JTextField myHTex, compHTex;
	
	private int myPosition, myAtackPoint, myDefencePoint;
	
	
	public Fight(AllPokemons my, AllPokemons comp, JTextArea textArea, JTextField myHText, JTextField compHText, int pos, int aPoint, int dPoint){
		this.m = my;
		this.com = comp;
		this.textAr = textArea;
		this.myHTex = myHText;
		this.compHTex = compHText;
		
		this.myPosition = pos;
		this.myAtackPoint = aPoint;
		this.myDefencePoint = dPoint;
	}
	
	
	public int start(int timeout, AllPokemons my, AllPokemons comp, JTextArea textArea, JTextField myHText, JTextField compHText, int posit, int aPoint, int dPoint) throws InterruptedException {

		
		Random position = new Random();

			my.setPosition(posit);
			comp.setPosition(position.nextInt(2)+1);
			
			my.setAtackDefPoint(aPoint, dPoint);
			comp.setAtackDefPoint(position.nextInt(3)+1, position.nextInt(3)+1);
			
			my.atacka(comp, textArea);
			comp.atacka(my, textArea);
			
			
			if ((my.getHealth() <= 0) && (comp.getHealth() <= 0)) {
				
				textArea.append(my.getName() + " ÏÎÂÅÐÆÅÍ \n"+comp.getName() + " ÏÎÂÅÐÆÅÍ\n" + "ÍÈ×Üß\n");

			} else if (my.getHealth() <= 0) {
				textArea.append(my.getName() + " ÏÎÂÅÐÆÅÍ \n"+"ÏÎÁÅÄÀ ÇÀ " + comp.getName()+"\n");

			} else if (comp.getHealth() <= 0) {
				textArea.append(comp.getName() + " ÏÎÂÅÐÆÅÍ \n"+"ÏÎÁÅÄÀ ÇÀ " + my.getName()+"\n");

			}
			textArea.append("______________________________________\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
			
			
			
			myHText.setText(String.format("%s(%s) / %s(%s)", my.getHealth(), my.zhizn, my.getVinoslivost(), my.vinoslivost));
			compHText.setText(String.format("%s(%s) / %s(%s)",comp.getHealth(), comp.zhizn, comp.getVinoslivost(), comp.vinoslivost));
			
			
			
			
			
			Thread.sleep(timeout);
			
			if (my.getHealth() <= comp.getHealth()) {
				return my.getHealth();
			} else if (comp.getHealth() < my.getHealth()) {
				return comp.getHealth();
			}
			return 0;
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			out: while (true) {
				int minHealth = start(5000, this.m, this.com, this.textAr, this.myHTex, this.compHTex, this.myPosition, this.myAtackPoint, this.myDefencePoint);
				if (minHealth == 0) {
					break out;
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean oneAtack() {
		try {
				int minHealth = start(0, this.m, this.com, this.textAr, this.myHTex, this.compHTex, this.myPosition, this.myAtackPoint, this.myDefencePoint);
				if (minHealth == 0) {
					return true;
				}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
