package com.buchbuchteam.buchbuch.view.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
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
		super("img/menu/bgmenu.png", "img/menu");
		
		curseur = new CursorMenu("img/menu/cursor.png");
		
		
		
		
		
		
		
	

	
	}
	
	private static Animation bgAnim;
	{
				Sprite[] bgFrames = new Sprite[2];
		bgFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/menu/bgmenu.png")), 0,
				0, 128, 128);
		bgFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/menu/bgmenu2.png")), 0,
				0, 128, 128);
		bgAnim = new Animation(0.2F, bgFrames);
		bgAnim.setPlayMode(Animation.LOOP);
	}
	
	
	public void render(float delta) {


		super.bgRender();
		
		curseur.CursorRender();
		curseur.Choose();
		
		
		
		
		



	
	

	
	
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