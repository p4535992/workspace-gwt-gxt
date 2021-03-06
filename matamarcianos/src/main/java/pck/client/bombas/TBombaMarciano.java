package pck.client.bombas;

import pck.client.canvas.TCanvas;
import pck.client.mutimedia.TFabricaMultimedia;
import pck.client.recursos.Recursos;
import pck.client.recursos.imagenes.ImagenesBundle;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;

public class TBombaMarciano extends TBomba {
	
	/////////////////////////////////////////CONTRUCTORES////////////////////////////////////////
	public TBombaMarciano(TCanvas _canvas){
		   super(_canvas);
		   ImagenesBundle imagenes=Recursos.instance.imagenes();
		  
		   imgExplosion=new Image(imagenes.explosionMarciano());
		   imgBomba=new Image(imagenes.bombaMarciano());
		   
		   this.w=23;
		   this.h=16;
		
	}//end function
	public TBombaMarciano(TCanvas _canvas,double _x,double _y){
		this(_canvas);
		this.x=_x;
		this.y=_y;
		
	}//end function
	////////////////////////////////////////METODOS PROTECTED ///////////////////////////////////////
	protected void BorrarBomba(){
		context.clearRect(x+10, y, w, h);
	}//end function
	
	protected void MoverBomba(){
		context.beginPath();
			ImageElement imageElement = ImageElement.as(imgBomba.getElement());
			context.drawImage(imageElement, x, y,w,h);
		context.closePath();
		//MOVIMIENTO DE DERECHA A IZQUIERDA
		x=x-10;
	}//end function
	@Override
	protected void SonidoDisparo() {
		// TODO Auto-generated method stub
		TFabricaMultimedia _snd=TFabricaMultimedia.getInstance();
		//TMultimedia _snd=TMultimedia.getInstance();
		_snd.getMultimedia().sonidoBombaMarcianos();
		
	}//end function
	@Override
	protected void SonidoColision() {
		// TODO Auto-generated method stub
		TFabricaMultimedia _snd=TFabricaMultimedia.getInstance();
		//TMultimedia _snd=TMultimedia.getInstance();
		_snd.getMultimedia().sonidoExplosion();
	}
}//end class
