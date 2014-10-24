package com.me.utils;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.me.gui.TextBox;

public class KeyListener {
	boolean a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, space, backSpace, one, two, three, four, five, six, seven, eight, nine, zero,
			shiftA, shiftB, shiftC, shiftD, shiftE, shiftF, shiftG, shiftH, shiftI, shiftJ, shiftK, shiftL, shiftM, shiftN, shiftO, shiftP, shiftQ, shiftR, shiftS,
			shiftT, shiftU, shiftV, shiftW, shiftX, shiftY, shiftZ = false;
	TextBox tb;
	StringBuilder sb;
	
	public KeyListener() {
		
	}
	
	public KeyListener(TextBox textBox) {
		this.tb = textBox;
	}
	
	public void checkKeyPressed() {
//SPACEBAR
		if(tb.isFocused()) {
			if(Gdx.input.isKeyPressed(Keys.SPACE)) {
				if(space == false) {
					tb.setInputString(tb.getInputString().concat(" "));
					space = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.SPACE) == false) {
				space = false;
			}
			
//BACKSPACE
			if(Gdx.input.isKeyPressed(Keys.BACKSPACE)) {
				if(backSpace == false && tb.getInputString().length() > 0) {
					backSpace = true;
					this.sb = new StringBuilder(tb.getInputString());
					sb.deleteCharAt(tb.getInputString().length() - 1);
					tb.setInputString(sb.toString());
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.BACKSPACE) == false) {
				backSpace = false;
			}
			
	//NUMBERS 0-9
			if(Gdx.input.isKeyPressed(Keys.NUM_0)) {
				if(zero == false) {
					tb.setInputString(tb.getInputString().concat("0"));
					zero = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_0) == false) {
				zero = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
				if(one == false) {
					tb.setInputString(tb.getInputString().concat("1"));
					one = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_1) == false) {
				one = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
				if(two == false) {
					tb.setInputString(tb.getInputString().concat("2"));
					two = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_2) == false) {
				two = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_3)) {
				if(three == false) {
					tb.setInputString(tb.getInputString().concat("3"));
					three = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_3) == false) {
				three = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_4)) {
				if(four == false) {
					tb.setInputString(tb.getInputString().concat("4"));
					four = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_4) == false) {
				four = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_5)) {
				if(five == false) {
					tb.setInputString(tb.getInputString().concat("5"));
					five = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_5) == false) {
				five = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_6)) {
				if(six == false) {
					tb.setInputString(tb.getInputString().concat("6"));
					six = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_6) == false) {
				six = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_7)) {
				if(seven == false) {
					tb.setInputString(tb.getInputString().concat("7"));
					seven = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_7) == false) {
				seven = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_8)) {
				if(eight == false) {
					tb.setInputString(tb.getInputString().concat("8"));
					eight = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_8) == false) {
				eight = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_9)) {
				if(nine == false) {
					tb.setInputString(tb.getInputString().concat("9"));
					nine = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.NUM_9) == false) {
				nine = false;
			}
			
//LETTERS
			if(Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(a == false) {
					tb.setInputString(tb.getInputString().concat("a"));
					a = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.A) == false) {
				a = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.B) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(b == false) {
					tb.setInputString(tb.getInputString().concat("b"));
					b = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.B) == false) {
				b = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.C) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(c == false) {
					tb.setInputString(tb.getInputString().concat("c"));
					c = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.C) == false) {
				c = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.D) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(d == false) {
					tb.setInputString(tb.getInputString().concat("d"));
					d = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.D) == false) {
				d = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.E) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(e == false) {
					tb.setInputString(tb.getInputString().concat("e"));
					e = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.E) == false) {
				e = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.F) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(f == false) {
					tb.setInputString(tb.getInputString().concat("f"));
					f = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.F) == false) {
				f = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.G) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(g == false) {
					tb.setInputString(tb.getInputString().concat("g"));
					g = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.G) == false) {
				g = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.H) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(h == false) {
					tb.setInputString(tb.getInputString().concat("h"));
					h = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.H) == false) {
				h = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.I) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(i == false) {
					tb.setInputString(tb.getInputString().concat("i"));
					i = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.I) == false) {
				i = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.J) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(j == false) {
					tb.setInputString(tb.getInputString().concat("j"));
					j = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.J) == false) {
				j = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.K) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(k == false) {
					tb.setInputString(tb.getInputString().concat("k"));
					k = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.K) == false) {
				k = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.L) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(l == false) {
					tb.setInputString(tb.getInputString().concat("l"));
					l = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.L) == false) {
				l = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.M) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(m == false) {
					tb.setInputString(tb.getInputString().concat("m"));
					m = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.M) == false) {
				m = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.N) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(n == false) {
					tb.setInputString(tb.getInputString().concat("n"));
					n = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.N) == false) {
				n = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.O) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(o == false) {
					tb.setInputString(tb.getInputString().concat("o"));
					o = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.O) == false) {
				o = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.P) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(p == false) {
					tb.setInputString(tb.getInputString().concat("p"));
					p = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.P) == false) {
				p = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.Q) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(q == false) {
					tb.setInputString(tb.getInputString().concat("q"));
					q = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.Q) == false) {
				q = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.R) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(r == false) {
					tb.setInputString(tb.getInputString().concat("r"));
					r = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.R) == false) {
				r = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(s == false) {
					tb.setInputString(tb.getInputString().concat("s"));
					s = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.S) == false) {
				s = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.T) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(t == false) {
					tb.setInputString(tb.getInputString().concat("t"));
					t = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.T) == false) {
				t = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.U) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(u == false) {
					tb.setInputString(tb.getInputString().concat("u"));
					u = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.U) == false) {
				u = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.V) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(v == false) {
					tb.setInputString(tb.getInputString().concat("v"));
					v = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.V) == false) {
				v = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(w == false) {
					tb.setInputString(tb.getInputString().concat("w"));
					w = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.W) == false) {
				w = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.X) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(x == false) {
					tb.setInputString(tb.getInputString().concat("x"));
					x = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.X) == false) {
				x = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.Y) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(y == false) {
					tb.setInputString(tb.getInputString().concat("y"));
					y = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.Y) == false) {
				y = false;
			}
			
			if(Gdx.input.isKeyPressed(Keys.Z) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == false) {
				if(z == false) {
					tb.setInputString(tb.getInputString().concat("z"));
					z = true;
				}
			}
			
			if(Gdx.input.isKeyPressed(Keys.Z) == false) {
				z = false;
			}
			
//CAPITAL LETTERS
			if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) == true) {
				if(Gdx.input.isKeyPressed(Keys.A)) {
					if(shiftA == false) {
						tb.setInputString(tb.getInputString().concat("A"));
						shiftA = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.A) == false) {
					shiftA = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.B)) {
					if(shiftB == false) {
						tb.setInputString(tb.getInputString().concat("B"));
						shiftB = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.B) == false) {
					shiftB = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.C)) {
					if(shiftC == false) {
						tb.setInputString(tb.getInputString().concat("C"));
						shiftC = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.C) == false) {
					shiftC = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.D)) {
					if(shiftD == false) {
						tb.setInputString(tb.getInputString().concat("D"));
						shiftD = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.D) == false) {
					shiftD = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.E)) {
					if(shiftE == false) {
						tb.setInputString(tb.getInputString().concat("E"));
						shiftE = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.E) == false) {
					shiftE = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.F)) {
					if(shiftF == false) {
						tb.setInputString(tb.getInputString().concat("F"));
						shiftF = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.F) == false) {
					shiftF = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.G)) {
					if(shiftG == false) {
						tb.setInputString(tb.getInputString().concat("G"));
						shiftG = true;
					}
				}
	
				if(Gdx.input.isKeyPressed(Keys.G) == false) {
					shiftG = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.H)) {
					if(shiftH == false) {
						tb.setInputString(tb.getInputString().concat("H"));
						shiftH = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.H) == false) {
					shiftH = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.I)) {
					if(shiftI == false) {
						tb.setInputString(tb.getInputString().concat("I"));
						shiftI = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.I) == false) {
					shiftI = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.J)) {
					if(shiftJ == false) {
						tb.setInputString(tb.getInputString().concat("J"));
						shiftJ = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.J) == false) {
					shiftJ = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.K)) {
					if(shiftK == false) {
						tb.setInputString(tb.getInputString().concat("K"));
						shiftK = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.K) == false) {
					shiftK = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.L)) {
					if(shiftL == false) {
						tb.setInputString(tb.getInputString().concat("L"));
						shiftL = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.L) == false) {
					shiftL = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.M)) {
					if(shiftM == false) {
						tb.setInputString(tb.getInputString().concat("M"));
						shiftM = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.M) == false) {
					shiftM = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.N)) {
					if(shiftN == false) {
						tb.setInputString(tb.getInputString().concat("N"));
						shiftN = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.N) == false) {
					shiftN = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.O)) {
					if(shiftO == false) {
						tb.setInputString(tb.getInputString().concat("O"));
						shiftO = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.O) == false) {
					shiftO = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.P)) {
					if(shiftP == false) {
						tb.setInputString(tb.getInputString().concat("P"));
						shiftP = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.P) == false) {
					shiftP = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.Q)) {
					if(shiftQ == false) {
						tb.setInputString(tb.getInputString().concat("Q"));
						shiftQ = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.Q) == false) {
					shiftQ = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.R)) {
					if(shiftR == false) {
						tb.setInputString(tb.getInputString().concat("R"));
						shiftR = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.R) == false) {
					shiftR = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.S)) {
					if(shiftS == false) {
						tb.setInputString(tb.getInputString().concat("S"));
						shiftS = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.S) == false) {
					shiftS = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.T)) {
					if(shiftT == false) {
						tb.setInputString(tb.getInputString().concat("T"));
						shiftT = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.T) == false) {
					shiftT = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.U)) {
					if(shiftU == false) {
						tb.setInputString(tb.getInputString().concat("U"));
						shiftU = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.U) == false) {
					shiftU = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.V)) {
					if(shiftV == false) {
						tb.setInputString(tb.getInputString().concat("V"));
						shiftV = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.V) == false) {
					shiftV = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.W)) {
					if(shiftW == false) {
						tb.setInputString(tb.getInputString().concat("W"));
						shiftW = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.W) == false) {
					shiftW = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.X)) {
					if(shiftX == false) {
						tb.setInputString(tb.getInputString().concat("X"));
						shiftX = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.X) == false) {
					shiftX = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.Y)) {
					if(shiftY == false) {
						tb.setInputString(tb.getInputString().concat("Y"));
						shiftY = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.Y) == false) {
					shiftY = false;
				}
				
				if(Gdx.input.isKeyPressed(Keys.Z)) {
					if(shiftZ == false) {
						tb.setInputString(tb.getInputString().concat("Z"));
						shiftZ = true;
					}
				}
				
				if(Gdx.input.isKeyPressed(Keys.Z) == false) {
					shiftZ = false;
				}
			}
		}
	}
}