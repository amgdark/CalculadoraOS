package uaz.edu.mx.CalculadoraOS;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class CalculadoraForm extends VerticalLayout{
	private TextField tfResultado;
	private NativeButton nbDel, nbCambiaSigno, nbPorcentaje, nbDividir, nb7, nb8, nb9,nb0,nb1;
	private NativeButton nb2,nb3,nb4,nb5,nb6,nbSuma,nbResta,nbMulti, nbPunto, nbIgual;
	
	private GridLayout gl;
	
	public CalculadoraForm(){
		creaFormulario();
	}
	
	public void creaFormulario(){
		gl = new GridLayout(4, 6);
		gl.setSizeUndefined();
		gl.setStyleName("miGrid");
		gl.setMargin(true);
		
		
		setMargin(true);
		
		addComponent(gl);
		setComponentAlignment(gl, Alignment.TOP_CENTER);
		
		tfResultado = new TextField();
		tfResultado.setValue("0");
		
		
		gl.addComponent(tfResultado, 0, 0, 3, 0);
		
//		
//		nbDel = new NativeButton("AC");
//		nbDel.setStyleName("gris");
//		gl.addComponent(nbDel, 0, 1);
//		
//		nbCambiaSigno = new NativeButton("+/-");
//		nbCambiaSigno.setStyleName("gris");
//		gl.addComponent(nbCambiaSigno, 1, 1);
//		
//		nbPorcentaje = new NativeButton("%");
//		nbPorcentaje.setStyleName("gris");
//		gl.addComponent(nbPorcentaje, 2, 1);
//		
//		nbDividir = new NativeButton("÷");
//		nbDividir.setStyleName("naranja");
//		gl.addComponent(nbDividir, 3, 1);
//		
//		nb7 = new NativeButton("7");
//		gl.addComponent(nb7, 0, 2);
//		
//		nb8 = new NativeButton("8");
//		gl.addComponent(nb8, 1, 2);
//		
//		nb9 = new NativeButton("9");
//		gl.addComponent(nb9, 2, 2);
//		
//		nbMulti = new NativeButton("x");
//		gl.addComponent(nbMulti, 3, 2);
//		nbMulti.setStyleName("naranja");
//		
//		nb4 = new NativeButton("4");
//		gl.addComponent(nb4, 0, 3);
//		
//		nb5 = new NativeButton("5");
//		gl.addComponent(nb5, 1, 3);
//		
//		nb6 = new NativeButton("6");
//		gl.addComponent(nb6, 2, 3);
//		
//		nbResta = new NativeButton("-");
//		gl.addComponent(nbResta, 3,3);
//		nbResta.setStyleName("naranja");
//		
//		nb1 = new NativeButton("1");
//		gl.addComponent(nb1, 0, 4);
//		
//		nb2 = new NativeButton("2");
//		gl.addComponent(nb2, 1, 4);
//		
//		nb3 = new NativeButton("3");
//		gl.addComponent(nb3, 2, 4);
//		
//		nbSuma = new NativeButton("+");
//		gl.addComponent(nbSuma,3,4);
//		nbSuma.setStyleName("naranja");
//		 
//		nb0 = new NativeButton("0");
//		nb0.setWidth("100%");
//		nb0.setStyleName("btnRed4");
//		gl.addComponent(nb0, 0, 5, 1, 5);
//		
//		nbPunto = new  NativeButton(".");
//		gl.addComponent(nbPunto, 2, 5);
//		
//		nbIgual = new NativeButton("=");
//		nbIgual.setStyleName("naranja btnRed3");
		
//		gl.addComponent(nbIgual, 3, 5);
		String [] captions = {"AC","+/-","%","÷","7","8","9","x","4","5","6","-","1","2","3","+","0",".","="};
		ArrayList<NativeButton> botones = new ArrayList<NativeButton>();
		int i=0;
		for (String cap: captions) {
			NativeButton btn = new NativeButton(cap);
			btn.addClickListener(new Operaciones());
			if (i>=0 && i<=2)
				btn.addStyleName("gris");
			if (i==3 || i==7 || i==11 || i==15 || i==18 )
				if (i==18)
					btn.addStyleName("naranja btnRed3");
				else
				btn.addStyleName("naranja");
			if (i==16) {
				btn.setWidth("100%");
				btn.setStyleName("btnRed4");
				gl.addComponent(btn, 0, 5, 1, 5);
			}
			else
				gl.addComponent(btn);
			botones.add(btn);
			i++;
		}
		
		
	}
	class Operaciones implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			ingresaDatos(event.getButton().getCaption().toString());
		}
	}
	public void ingresaDatos(String valor){
		String caja = tfResultado.getValue();
		if (valor.equals("."))
			if (caja.contains("."))
				caja+=valor;
			else
				caja=valor;
		if (caja.equals("0"))
			if (valor.equals("."))
				if (caja.contains("."))
					caja+=valor;
				else
					caja=valor;
		else
			caja+=valor;
		tfResultado.setValue(caja);
	}
	public boolean valida(){
		boolean ok = false;
		if ((tfResultado.getValue().matches("^[0-9]+$")))
			ok= true;
		return ok;
	}
	
}
