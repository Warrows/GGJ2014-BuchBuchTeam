package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.view.GameScreen;

public class BuchBuch extends MoveableEntity
{
	private float x, y;
	private boolean running, jumping;
	private int jumpingState;
	private boolean attacking;
	private boolean leaving;
	private boolean crouching;
	private int crouchingState;

	public BuchBuch(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.running = true;
		this.jumping = false;

	}

	public void setRunning(boolean bool)
	{
		this.running = bool;
	}

	public void setJumping(boolean bool)
	{
		this.jumping = bool;
		this.jumpingState = 0;
		resetJackJumping();
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		TextureRegion frame = null;
		if (running && !Team.getInstance().ahead(x))
			frame = run(stateTime);
		else if (!leaving)
			frame = walk(stateTime);
		
		if( attacking ) {
			frame = attack(stateTime);
			if(frame == jackAttackSprite[7]){
				setAttacking(false);
				setLeaving(true);
			}
		}
		
		if (leaving){
			frame = leaving(stateTime);
			x -= 1.5;
			if (x<-64)
				x = -64;
		}	
		
		if(crouching)
		{
			crouchingState++;
			frame = jackCrouching.getKeyFrames()[crouchingState/10];
			if (crouchingState >= 19)
				crouching = false;
		}
			
		
		if (jumping)
		{
			jumpingState ++;
			frame = jackJumping.getKeyFrames()[jumpingState/10];
			if (jumpingState >= 49)
				jumping = false;
		}
		return frame;
	}

	public void setLeaving(boolean b) {
		
		this.leaving= b; 
		if (leaving)
			running = false;
		Team.getInstance().setToLeave(true);
		
	}

	private TextureRegion walk(float stateTime)
	{
		x -= 0.5;
		if (x <= 0)
			x = 0;
		return jackWalking.getKeyFrame(stateTime);
	}

	private TextureRegion run(float stateTime)
	{
		x += 1.5;
		if (x >= GameScreen.getInstance().getTree().getX())
		{
			setRunning(false);
			setAttacking(true);
		}
		return jackRunning.getKeyFrame(stateTime);
	}
	
	private TextureRegion attack(float stateTime) {
		
		return jackAttacking.getKeyFrame(stateTime);
		
	}
	
	private TextureRegion leaving(float stateTime) {
		
		return jackLeaving.getKeyFrame(stateTime);
		
	}

	private void setAttacking(boolean b) {

		this.attacking = b;
		resetJackAttack();
		
	}

	public TextureRegion getRunningFrame(float animTime)
	{
		return jackRunning.getKeyFrame(animTime);
	}

	@Override
	public float getX()
	{
		return x;
	}

	@Override
	public float getY()
	{
		return y;
	}

	private static Animation jackWalking;
	{
		Sprite[] jackFrames = new Sprite[4];
		jackFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				0, 0, 64, 64);
		jackFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				64, 0, 64, 64);
		jackFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				128, 0, 64, 64);
		jackFrames[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/char_jackMarche.png")),
				192, 0, 64, 64);
		jackWalking = new Animation(0.2F, jackFrames);
		jackWalking.setPlayMode(Animation.LOOP);
	}
	
	private static Animation jackLeaving;
	{
		Sprite[] jackFrames = new Sprite[4];
		jackFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/marcheBuche/char_jackMarchBuch_01.png")),
				0, 0, 64, 92);
		jackFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/marcheBuche/char_jackMarchBuch_02.png")),
				0, 0, 64, 92);
		jackFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/marcheBuche/char_jackMarchBuch_03.png")),
				0, 0, 64, 92);
		jackFrames[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/jack/marcheBuche/char_jackMarchBuch_04.png")),
				0, 0, 64, 92);
		jackLeaving = new Animation(0.2F, jackFrames);
		jackLeaving.setPlayMode(Animation.LOOP);
	}
	
	private static Animation jackAttacking;
	private static Sprite[] jackAttackSprite;
	{
		jackAttackSprite = new Sprite[8];
		jackAttackSprite[0] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_01.png")),
				0, 0, 64, 92);
		jackAttackSprite[1] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_02.png")),
				0, 0, 64, 92);
		jackAttackSprite[2] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_03.png")),
				0, 0, 64, 92);
		jackAttackSprite[3] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_04.png")),
				0, 0, 64, 92);
		jackAttackSprite[4] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_05.png")),
				0, 0, 64, 92);
		jackAttackSprite[5] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_06.png")),
				0, 0, 64, 92);
		jackAttackSprite[6] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_07.png")),
				0, 0, 64, 92);
		jackAttackSprite[7] = new Sprite(
				new Texture(
						Gdx.files
								.internal("img/characters/jack/hit/char_jackHitTake_08.png")),
				0, 0, 64, 92);
		jackAttacking = new Animation(0.2F, jackAttackSprite);
		jackAttacking.setPlayMode(Animation.LOOP);
	}
	private static Animation jackRunning;
	{
		Sprite[] jackFrames = new Sprite[3];
		jackFrames[0] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackCours_01.png")),
				0, 0, 64, 64);
		jackFrames[1] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackCours_02.png")),
				0, 0, 64, 64);
		jackFrames[2] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackCours_03.png")),
				0, 0, 64, 64);
		jackRunning = new Animation(0.2F, jackFrames);
		jackRunning.setPlayMode(Animation.LOOP);
	}
	private static Animation jackJumping;
	private static Sprite[] jackJumpingSprite;
	{
		jackJumpingSprite = new Sprite[5];
		jackJumpingSprite[0] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackJump_01.png")),
				0, 5, 64, 92);
		jackJumpingSprite[1] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackJump_02.png")),
				0, 10, 64, 92);
		jackJumpingSprite[2] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackJump_03.png")),
				0, 15, 64, 92);
		jackJumpingSprite[3] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackJump_04.png")),
				0, 10, 64, 92);
		jackJumpingSprite[4] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/char_jackJump_05.png")),
				0, 5, 64, 92);
	}
	
	private static Animation jackCrouching;
	private static Sprite[] jackCrouchingSprite;
	{
		jackCrouchingSprite = new Sprite[2];
		jackCrouchingSprite[0] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/crouch/char_jackEsquive_01.png")),
				0, 0, 64, 64);
		jackCrouchingSprite[1] = new Sprite(
				new Texture(Gdx.files
						.internal("img/characters/jack/crouch/char_jackEsquive_02.png")),
				0, 0, 64, 64);
	}

	private void resetJackJumping()
	{
		jackJumping = new Animation(0.2F, jackJumpingSprite);
		jackJumping.setPlayMode(Animation.LOOP);
	}
	
	private void resetJackCrouching(){
		jackCrouching = new Animation(0.2F, jackCrouchingSprite);
		jackCrouching.setPlayMode(Animation.LOOP_PINGPONG);
	}
	
	private void resetJackAttack(){
		jackAttacking = new Animation(0.2F, jackAttackSprite);
		jackAttacking.setPlayMode(Animation.LOOP);
	}

	public void cry()
	{
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/buch.wav"));
		sound.play(0.5f);
	}

	public boolean isRunning()
	{
		return running;
	}

	public boolean isJumping()
	{
		return jumping;
	}
	
	public boolean isAttacking(){
		return attacking;
	}

	public void jumpCry()
	{
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/jump.wav"));
		sound.play(0.5f);		
	}

	public void setCrouch(boolean bool) {
		
		this.crouching = true;
		this.crouchingState = 0;
		resetJackCrouching();
	}
}
