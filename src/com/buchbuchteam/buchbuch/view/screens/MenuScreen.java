package com.buchbuchteam.buchbuch.view.screens;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.buchbuchteam.buchbuch.view.Game;

public class MenuScreen extends ScreenMaster {
	
	//Variables de bouttons
	
	
	public static final int buttonWidth = 250, buttonHeight=40;
	public static final int espaceEntreButton = 15;
	public static final int buttonX = Game.WIDTH/2 - buttonWidth / 2;
	public static final int jouerY = Game.HEIGHT /2, 
							controlY = jouerY - buttonHeight - espaceEntreButton,
							hightscoreY = controlY - buttonHeight - espaceEntreButton, 
							creditsY= hightscoreY - buttonHeight - espaceEntreButton, 
							quitterY = creditsY - buttonHeight - espaceEntreButton ;
	private Sprite jouerSprite, controlSprite, hightscoreSprite, creditsSprite, quitterSprite;
	
	private BoutonMenu boutonJouer, boutonControl, boutonHightScore, boutonCredits, boutonQuitter;
	private CursorMenu curseur;
	

	


	public MenuScreen() {
		super("img/menu/bgmenu.png");
		
		curseur = new CursorMenu("img/menu/cursor.png");
		
		boutonJouer = new BoutonMenu("img/menu/jouerbutton.png", jouerY, true, 1);
		boutonControl = new BoutonMenu("img/menu/controlbutton.png", controlY, false, 2);
		boutonHightScore = new BoutonMenu("img/menu/hightscorebutton.png", hightscoreY, false, 3);
		boutonCredits = new BoutonMenu("img/menu/creditsbutton.png", creditsY, false, 4);
		boutonQuitter = new BoutonMenu("img/menu/quitterbutton.png", quitterY, false, 5);
		
		
		
		
		
	

	
	}
	
	
	public void render(float delta) {
		

		super.bgRender();
		
		curseur.CursorRender();
		curseur.Choose();
		
		boutonJouer.BoutonRender();
		boutonControl.BoutonRender();
		boutonHightScore.BoutonRender();
		boutonCredits.BoutonRender();
		boutonQuitter.BoutonRender();
		
		
		



	
	

	
	
		}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}


	public static int getJouery() {
		return jouerY;
	}
	
	






	
}