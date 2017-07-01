package pokemons;

import java.util.Random;

import javax.swing.JTextArea;

import ability.AbilityInterface;

public class AllPokemons implements AbilityInterface {

	private String name, type;
	//          ����      ��������   ��������  �����
	private int strength, dexterity, instinct, life;
	
	public int zhizn, vinoslivost;
	private int pokazatelZhizni, pokazatelVinoslivosti;
	
	private int krit, antiKrit, uvorot, antiUvorot, minUron, maxUron;
	
	private int position; // 1 - ��������, 2 - ���������
	
	private int atackPoint, defencePoint;
	private int zawita;
	
	
	AllPokemons(int strength, int dexterity, int instinct, int life, int zawita) {
		
		Random rn = new Random();
		
		this.strength = strength;
		this.dexterity = dexterity;
		this.instinct = instinct;
		this.life = life;
		
		this.pokazatelZhizni = this.zhizn = life * 6;
		this.pokazatelVinoslivosti = this.vinoslivost = strength * 6;
		
		this.zawita = zawita;
		
		this.antiKrit = this.krit = instinct * 3;
		this.uvorot = this.antiUvorot = dexterity * 3;
		
		this.minUron = 1;
		this.maxUron = 5;
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}
	
	
	
	
	
	public void atacka(AllPokemons comp, JTextArea textArea) {
		// TODO Auto-generated method stub
		
		
		if (this.position == 1) { //������
			this.antiKrit *=2;
			this.uvorot *=2;
		//	System.out.print("��������� " + this.name);
			textArea.append("��������� " + this.name);
		} else if (this.position == 2) { //���������
			this.krit *=2;
			this.antiUvorot *=2;
		//	System.out.print("������ " + this.name);
			textArea.append("������ " + this.name);
		}
		
		if (comp.position == 1) { //������
			comp.antiKrit *=2;
			comp.uvorot *=2;
		} else if (comp.position == 2) { //���������
			comp.krit *=2;
			comp.antiUvorot *=2;
		}
		
		
		
		Random rn = new Random();
		int rezult = 0;
		
		int uvor = 50;
		
		double atakDef = 1d;
		
		if (this.position == 2) {
			atakDef = 0.8d;
		}
		
		double ras;
		if (comp.pokazatelVinoslivosti / comp.vinoslivost < 0.5d) {
			ras = 40d * atakDef / this.antiUvorot * (comp.uvorot - this.antiUvorot) ;
		} else {
			ras = 100d * atakDef / this.antiUvorot * (comp.uvorot - this.antiUvorot) ;
		}

		
		uvor = (int) ras;
		
		if (uvor <= 0) {
			uvor = 95;
		}
		
		

		
		
		int dex = rn.nextInt(100);
		
		if ((uvor <= dex) || (dex <= 5)) {
		//	System.out.print(" ������, �� ");
			textArea.append(" ������, �� ");
			
			if (comp.position == 1) {
			//	System.out.print(" ��������� " + comp.name + " ���������. ");
				textArea.append(" ��������� " + comp.name + " ���������. ");
			} else if (comp.position == 2) {
			//	System.out.print(" ������ " + comp.name+ " ���������. ");
				textArea.append(" ������ " + comp.name+ " ���������. ");
			}
			
			
		} else {
			double min = 0.75d * this.pokazatelVinoslivosti + this.minUron;
			double max = 0.25d * this.pokazatelVinoslivosti + this.maxUron;
			
			double def = 10000d; 
			
			if (this.atackPoint == comp.defencePoint) {
				def =  ((double) (0.5d + this.pokazatelVinoslivosti / 100d)* comp.zawita / (20d + rn.nextInt(8)));
			} else {
				def =  ((double) (0.5d + this.pokazatelVinoslivosti / 100d)* comp.zawita / (10d + rn.nextInt(8)));
			}
			
			
			
			double t = 3d* (1d + this.instinct / 100d) * (min + rn.nextInt((int)(Math.abs(max-min) + 1))) / def;
			
			int minus = 0;
			if (rn.nextInt(100) >= 90) {
				minus = (int) ( (double)((t + 0.5d * (this.krit - comp.antiKrit))));
				if (minus >= 0) {
				//	System.out.print(" ����� ����������� ���� �");
					textArea.append(" ����� ����������� ���� �");
				}
				
			} else {
				minus = (int) t;
			}

			if (this.position == 1) {  // ��������
				if (rn.nextInt(250) <= 10) {
					minus = 0;
				}
			} else {  // ���������
				if (rn.nextInt(350) <= 10) {
					minus = 0;
				}
			}
			
			
			if (this.atackPoint == comp.defencePoint) {
				//�������� ��������
				if (minus > 0) {
			//		System.out.print(" ������ ");
					textArea.append(" ������ ");
					if (comp.position == 1) {
						//System.out.print(" ������������� " + comp.name + " �� " + minus + ". ");
						textArea.append(" ������������� " + comp.name + " �� " + minus + ". ");
					} else if (comp.position == 2) {
					//	System.out.print(" ��������� " + comp.name + " �� " + minus + ". ");
						textArea.append(" ��������� " + comp.name + " �� " + minus + ". ");
					}
					
					
				} else if (minus < 0) {
					minus = 0;
				//	System.out.print(" �� ������ ���� � " + comp.name + ". ");
					textArea.append(" �� ������ ���� � " + comp.name + ". ");
				} else if (minus == 0) {
					textArea.append(" ����������� (�� ����� �����) �� " + comp.name + ". ");
				}
				rezult = minus;
			} else {
				if (minus <= 0) {
					minus = 0;
				}
				rezult = minus;
				
				if (comp.position == 1) {
					textArea.append(" ����� ������������� " + comp.name + " ���� �� " + minus + ". ");
					//System.out.print(" ����� ������������� " + comp.name + " ���� �� " + minus + ". ");
				} else if (comp.position == 2) {
					//System.out.print(" ����� ��������� " + comp.name + " ���� �� " + minus + ". ");
					textArea.append(" ����� ��������� " + comp.name + " ���� �� " + minus + ". ");
				}
				
				
				
			}
			
			
			
			
			
		}
		
		
		
		
		comp.pokazatelZhizni -= rezult;
		changeVinoslivosti();
		
		if (comp.getHealth() < 0) {
			comp.pokazatelZhizni = 0;
		}
		
		textArea.append(" � " + comp.name+ " �������� " + comp.getHealth() + " ������\n");

		
		
		
		
		
		if (this.position == 1) { //������
			this.antiKrit /=2;
			this.uvorot /=2;
		} else if (this.position == 2) { //���������
			this.krit /=2;
			this.antiUvorot /=2;
		}
		
		if (comp.position == 1) { //������
			comp.antiKrit /=2;
			comp.uvorot /=2;
		} else if (comp.position == 2) { //���������
			comp.krit /=2;
			comp.antiUvorot /=2;
		}
		
		
		
		
		
		
		
	}


	@Override
	public void setPosition(int position) {
		// TODO Auto-generated method stub
		this.position = position;
	}


	@Override
	public void changeVinoslivosti() {
		// TODO Auto-generated method stub
		Random rn = new Random();
		
		if (this.position == 1) {
			this.pokazatelVinoslivosti -= 1+this.vinoslivost/50;
		} else {
			this.pokazatelVinoslivosti -= 2+this.vinoslivost/50;
		}
	}


	@Override
	public void changeZhizni(int count) {
		// TODO Auto-generated method stub
		this.pokazatelZhizni -= count;
	}


	@Override
	public void setAtackDefPoint(int atackPoint, int defencePoint) {
		// TODO Auto-generated method stub
		this.atackPoint = atackPoint;
		this.defencePoint = defencePoint;
	}


	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.pokazatelZhizni;
	}


	@Override
	public int getVinoslivost() {
		// TODO Auto-generated method stub
		return this.pokazatelVinoslivosti;
	}
	
	
	
}
