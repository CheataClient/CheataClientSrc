/*
 * Copyright (c) 2013, DarkStorm (darkstorm@evilminecraft.net)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.lunix.cheata.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.concurrent.atomic.AtomicBoolean;

import org.darkstorm.minecraft.gui.AbstractGuiManager;
import org.darkstorm.minecraft.gui.component.Button;
import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.component.basic.BasicButton;
import org.darkstorm.minecraft.gui.component.basic.BasicFrame;
import org.darkstorm.minecraft.gui.component.basic.BasicLabel;
import org.darkstorm.minecraft.gui.layout.GridLayoutManager;
import org.darkstorm.minecraft.gui.layout.GridLayoutManager.HorizontalGridConstraint;
import org.darkstorm.minecraft.gui.listener.ButtonListener;
import org.darkstorm.minecraft.gui.theme.Theme;

import com.lunix.cheata.Client;
import com.lunix.cheata.mod.Mod;
import com.lunix.cheata.utils.Category;
import com.lunix.cheata.utils.mod.ModValue;
import com.lunix.cheata.utils.mod.ModValueManager;

/**
 * Minecraft GUI API
 * 
 * This class is not actually intended for use; rather, you should use this as a
 * template for your actual GuiManager, as the creation of frames is highly
 * implementation-specific.
 * 
 * @author DarkStorm (darkstorm@evilminecraft.net)
 */
public final class GuiManager extends AbstractGuiManager {
	private class ModuleFrame extends BasicFrame {
		private ModuleFrame() {
		}

		private ModuleFrame(String title) {
			super(title);
		}
	}

	private final AtomicBoolean setup;

	public GuiManager() {
		setup = new AtomicBoolean();
	}

	@Override
	public void setup() {
		if (!setup.compareAndSet(false, true))
			return;
		createWindowFrame();
	}

	private Frame windowFrame = new BasicFrame("Windows") {
		@Override
		public void update() {
			windowX = getX();
			windowY = getY();
		}
	};

	public int countX = 1;
	public int countY = 1;
	public int windowX = 0;
	public int windowY = 0;
	public boolean combatWindow = false;
	public int combatX = 0;
	public int combatY = 0;
	public boolean movementWindow = false;
	public int movementX = 0;
	public int movementY = 0;
	public boolean playerWindow = false;
	public int playerX = 0;
	public int playerY = 0;
	public boolean worldWindow = false;
	public int worldX = 0;
	public int worldY = 0;
	public boolean miscWindow = false;
	public int miscX = 0;
	public int miscY = 0;
	public boolean settingsWindow = false;
	public int colorX = 0;
	public int colorY = 0;

	private void createWindowFrame() {
		Theme theme = getTheme();
		windowFrame.setTheme(theme);
		windowFrame.setLayoutManager(new GridLayoutManager(2, 0));

		BasicLabel labelMovement = new BasicLabel("Movement");
		BasicButton movementButton = new BasicButton(movementWindow ? "Close"
				: "Open");

		BasicLabel labelCombat = new BasicLabel("Combat");
		BasicButton combatButton = new BasicButton(combatWindow ? "Close"
				: "Open");

		BasicLabel labelPlayer = new BasicLabel("Player");
		BasicButton playerButton = new BasicButton(playerWindow ? "Close"
				: "Open");

		BasicLabel labelWorld = new BasicLabel("World");
		BasicButton worldButton = new BasicButton(worldWindow ? "Close"
				: "Open");

		BasicLabel labelMisc = new BasicLabel("Misc");
		BasicButton miscButton = new BasicButton(miscWindow ? "Close" : "Open");

		BasicLabel labelSettings = new BasicLabel("Settings");
		BasicButton settingsButton = new BasicButton(settingsWindow ? "Close" : "Open");

		miscButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				if (!miscWindow) {
					miscWindow = true;
					createMiscFrame(true);
				} else {
					miscWindow = false;
					createMiscFrame(false);
				}
				button.setText(miscWindow ? "Close" : "Open");
			}
		});

		combatButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				if (!combatWindow) {
					combatWindow = true;
					createCombatFrame(true);

				} else {
					combatWindow = false;
					createCombatFrame(false);

				}
				button.setText(combatWindow ? "Close" : "Open");
			}
		});

		worldButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				if (!worldWindow) {
					worldWindow = true;
					createWorldFrame(true);

				} else {
					worldWindow = false;
					createWorldFrame(false);

				}
				button.setText(worldWindow ? "Close" : "Open");
			}
		});

		playerButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				if (!playerWindow) {
					playerWindow = true;
					createPlayerFrame(true);

				} else {
					playerWindow = false;
					createPlayerFrame(false);

				}
				button.setText(playerWindow ? "Close" : "Open");
			}
		});

		movementButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				if (!movementWindow) {
					movementWindow = true;
					createMovementFrame(true);

				} else {
					movementWindow = false;
					createMovementFrame(false);

				}
				button.setText(movementWindow ? "Close" : "Open");
			}
		});

		settingsButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				if (!settingsWindow) {
					settingsWindow = true;
					createSettingsFrame(true);

				} else {
					settingsWindow = false;
					createSettingsFrame(false);

				}
				button.setText(settingsWindow ? "Close" : "Open");
			}
		});
		windowFrame.add(new BasicLabel("Mod"));
		windowFrame.add(new BasicLabel(""));
		windowFrame.add(labelCombat);
		windowFrame.add(combatButton, HorizontalGridConstraint.RIGHT);
		windowFrame.add(labelMisc);
		windowFrame.add(miscButton, HorizontalGridConstraint.RIGHT);
		windowFrame.add(labelMovement);
		windowFrame.add(movementButton, HorizontalGridConstraint.RIGHT);
		windowFrame.add(labelPlayer);
		windowFrame.add(playerButton, HorizontalGridConstraint.RIGHT);
		windowFrame.add(labelWorld);
		windowFrame.add(worldButton, HorizontalGridConstraint.RIGHT);
		windowFrame.add(new BasicLabel("Options"));
		windowFrame.add(new BasicLabel(""));
		windowFrame.add(labelSettings);
		windowFrame.add(settingsButton, HorizontalGridConstraint.RIGHT);

		windowFrame.setX(5);
		windowFrame.setY(5);
		Dimension defaultDimension = theme.getUIForComponent(windowFrame)
				.getDefaultSize(windowFrame);
		windowFrame.setWidth(defaultDimension.width + 5);
		windowFrame.setHeight(defaultDimension.height);
		windowFrame.layoutChildren();
		windowFrame.setVisible(true);
		windowFrame.setClosable(false);
		windowFrame.setMinimized(true);
		addFrame(windowFrame);
		resizeComponents();
	}

	private boolean hasMadeMiscFrame = false;
	private Frame miscFrame = new ModuleFrame("Misc") {
		@Override
		public void update() {
			miscX = getX();
			miscY = getY();
		}
	};

	private boolean hasMadeCombatFrame = false;
	private Frame combatFrame = new ModuleFrame("Combat") {
		@Override
		public void update() {
			combatX = getX();
			combatY = getY();
		}
	};

	private boolean hasMadePlayerFrame = false;
	private Frame playerFrame = new ModuleFrame("Player") {
		@Override
		public void update() {
			playerX = getX();
			playerY = getY();
		}
	};

	private boolean hasMadeWorldFrame = false;
	private Frame worldFrame = new ModuleFrame("World") {
		@Override
		public void update() {
			worldX = getX();
			worldY = getY();
		}
	};

	private boolean hasMadeMovementFrame = false;
	private Frame movementFrame = new ModuleFrame("Movement") {
		@Override
		public void update() {
			movementX = getX();
			movementY = getY();
		}
	};

	private boolean hasMadeSettingsFrame = false;
	private Frame settingsFrame = new ModuleFrame("Settings") {
		@Override
		public void update() {
			colorX = getX();
			colorY = getY();
		}
	};

	private void createMiscFrame(boolean making) {
		if (!hasMadeMiscFrame) {
			hasMadeMiscFrame = true;
			miscFrame.setTheme(theme);
			miscFrame.setLayoutManager(new GridLayoutManager(2, 0));
			miscFrame.setVisible(true);
			miscFrame.setClosable(false);
			miscFrame.setMinimized(true);
			miscFrame.setWidth(windowFrame.getWidth());
			miscFrame.setHeight(windowFrame.getHeight());
			miscFrame.setX((windowFrame.getWidth() * 2) + 15);
			miscFrame.setY(5);
			addFrame(miscFrame);
			for (Mod module : Client.getModManager().mods) {
				if (module.isCategory(Category.MISC)) {
					miscFrame.add(new BasicLabel(module.getName()));
					final Mod updateModule = module;
					Button button = new BasicButton(
							module.isEnabled() ? "Disable" : "Enable") {
						@Override
						public void update() {
							setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					};
					button.addButtonListener(new ButtonListener() {
						@Override
						public void onButtonPress(Button button) {
							updateModule.toggle();
							button.setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					});
					miscFrame.add(button, HorizontalGridConstraint.RIGHT);
				}
			}
			resizeComponents();

		}
		if (making) {
			miscFrame.setVisible(true);
			miscFrame.setMinimized(true);
		} else {
			miscFrame.setMinimized(true);
			miscFrame.setVisible(false);
		}
	}

	private void createCombatFrame(boolean making) {
		if (!hasMadeCombatFrame) {
			hasMadeCombatFrame = true;
			combatFrame.setTheme(theme);
			combatFrame.setLayoutManager(new GridLayoutManager(2, 0));
			combatFrame.setVisible(true);
			combatFrame.setClosable(false);
			combatFrame.setMinimized(true);
			combatFrame.setWidth(windowFrame.getWidth());
			combatFrame.setHeight(windowFrame.getHeight());
			combatFrame.setX((windowFrame.getWidth() * 1) + 10);
			combatFrame.setY(5);
			addFrame(combatFrame);
			for (Mod module : Client.getModManager().mods) {
				if (module.isCategory(Category.COMBAT)) {
					combatFrame.add(new BasicLabel(module.getName()));
					final Mod updateModule = module;
					Button button = new BasicButton(
							module.isEnabled() ? "Disable" : "Enable") {
						@Override
						public void update() {
							setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					};
					button.addButtonListener(new ButtonListener() {
						@Override
						public void onButtonPress(Button button) {
							updateModule.toggle();
							button.setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					});
					combatFrame.add(button, HorizontalGridConstraint.RIGHT);
				}
			}
			resizeComponents();

		}
		if (making) {
			combatFrame.setVisible(true);
			combatFrame.setMinimized(true);
		} else {
			combatFrame.setMinimized(true);
			combatFrame.setVisible(false);
		}
	}

	private void createWorldFrame(boolean making) {
		if (!hasMadeWorldFrame) {
			hasMadeWorldFrame = true;
			worldFrame.setTheme(theme);
			worldFrame.setLayoutManager(new GridLayoutManager(2, 0));
			worldFrame.setVisible(true);
			worldFrame.setClosable(false);
			worldFrame.setMinimized(true);
			worldFrame.setWidth(windowFrame.getWidth());
			worldFrame.setHeight(windowFrame.getHeight());
			worldFrame.setX((windowFrame.getWidth() * 1) + 10);
			worldFrame.setY(100);
			addFrame(worldFrame);
			for (Mod module : Client.getModManager().mods) {
				if (module.isCategory(Category.WORLD)) {
					worldFrame.add(new BasicLabel(module.getName()));
					final Mod updateModule = module;
					Button button = new BasicButton(
							module.isEnabled() ? "Disable" : "Enable") {
						@Override
						public void update() {
							setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					};
					button.addButtonListener(new ButtonListener() {
						@Override
						public void onButtonPress(Button button) {
							updateModule.toggle();
							button.setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					});
					worldFrame.add(button, HorizontalGridConstraint.RIGHT);
				}
			}
			resizeComponents();

		}
		if (making) {
			worldFrame.setVisible(true);
			worldFrame.setMinimized(true);
		} else {
			worldFrame.setMinimized(true);
			worldFrame.setVisible(false);
		}
	}

	private void createPlayerFrame(boolean making) {
		if (!hasMadePlayerFrame) {
			hasMadePlayerFrame = true;
			playerFrame.setTheme(theme);
			playerFrame.setLayoutManager(new GridLayoutManager(2, 0));
			playerFrame.setVisible(true);
			playerFrame.setClosable(false);
			playerFrame.setMinimized(true);
			playerFrame.setWidth(windowFrame.getWidth());
			playerFrame.setHeight(windowFrame.getHeight());
			playerFrame.setX(5);
			playerFrame.setY(100);
			addFrame(playerFrame);
			for (Mod module : Client.getModManager().mods) {
				if (module.isCategory(Category.PLAYER)) {
					playerFrame.add(new BasicLabel(module.getName()));
					final Mod updateModule = module;
					Button button = new BasicButton(
							module.isEnabled() ? "Disable" : "Enable") {
						@Override
						public void update() {
							setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					};
					button.addButtonListener(new ButtonListener() {
						@Override
						public void onButtonPress(Button button) {
							updateModule.toggle();
							button.setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					});
					playerFrame.add(button, HorizontalGridConstraint.RIGHT);
				}
			}
			resizeComponents();

		}
		if (making) {
			playerFrame.setVisible(true);
			playerFrame.setMinimized(true);
		} else {
			playerFrame.setMinimized(true);
			playerFrame.setVisible(false);
		}
	}

	private void createMovementFrame(boolean making) {
		if (!hasMadeMovementFrame) {
			hasMadeMovementFrame = true;
			movementFrame.setTheme(theme);
			movementFrame.setLayoutManager(new GridLayoutManager(2, 0));
			movementFrame.setVisible(true);
			movementFrame.setClosable(false);
			movementFrame.setMinimized(true);
			movementFrame.setWidth(windowFrame.getWidth());
			movementFrame.setHeight(windowFrame.getHeight());
			movementFrame.setX((windowFrame.getWidth() * 3) + 20);
			movementFrame.setY(5);
			addFrame(movementFrame);
			for (Mod module : Client.getModManager().mods) {
				if (module.isCategory(Category.MOVEMENT)) {
					movementFrame.add(new BasicLabel(module.getName()));
					final Mod updateModule = module;
					Button button = new BasicButton(
							module.isEnabled() ? "Disable" : "Enable") {
						@Override
						public void update() {
							setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					};
					button.addButtonListener(new ButtonListener() {
						@Override
						public void onButtonPress(Button button) {
							updateModule.toggle();
							button.setText(updateModule.isEnabled() ? "Disable"
									: "Enable");
						}
					});
					movementFrame.add(button, HorizontalGridConstraint.RIGHT);
				}
			}
			resizeComponents();

		}
		if (making) {
			movementFrame.setVisible(true);
			movementFrame.setMinimized(true);
		} else {
			movementFrame.setMinimized(true);
			movementFrame.setVisible(false);
		}
	}

	private void createSettingsFrame(boolean making){
		if(!hasMadeSettingsFrame){
			hasMadeSettingsFrame = true;
			settingsFrame.setTheme(theme);
			settingsFrame.setLayoutManager(new GridLayoutManager(2, 0));
			settingsFrame.setVisible(true);
			settingsFrame.setClosable(false);
			settingsFrame.setMinimized(true);
			settingsFrame.setWidth(windowFrame.getWidth());
			settingsFrame.setHeight(windowFrame.getHeight());
			settingsFrame.setX((windowFrame.getWidth() * 2) + 15);
			settingsFrame.setY(100);
			addFrame(settingsFrame);
			
			BasicButton button = new BasicButton();
			
			for(ModValue value : ModValueManager.values){
				settingsFrame.add(new BasicLabel(value.getValueName()));
				if(value.isBoolean()){
					final ModValue valueUpdate = value;
					button = new BasicButton(Boolean.toString(value.getValueBoolean()));
					button.addButtonListener(new ButtonListener(){
						@Override
						public void onButtonPress(Button button) {
							valueUpdate.setValueBoolean(!valueUpdate.getValueBoolean());
							button.setText(Boolean.toString(valueUpdate.getValueBoolean()));
						}
					});
					settingsFrame.add(button, HorizontalGridConstraint.RIGHT);
				}else{
					final ModValue valueUpdate = value;
					button = new BasicButton(Double.toString(value.getValueDouble()));
					button.addButtonListener(new ButtonListener(){
						@Override
						public void onButtonPress(Button button) {
							if(valueUpdate.getValueDouble() >= valueUpdate.getValueMax()){
								valueUpdate.setValueDouble(valueUpdate.getValueMin());
							}else{
								valueUpdate.setValueDouble(valueUpdate.getValueDouble() + valueUpdate.getValueIncrement());
							}
							button.setText(Double.toString(valueUpdate.getValueDouble()));
						}
					});
					settingsFrame.add(button, HorizontalGridConstraint.RIGHT);
				}
			}
			
			resizeComponents();
			
			
		}
		if(making){
			settingsFrame.setVisible(true);
			settingsFrame.setMinimized(true);
		}else{
			settingsFrame.setMinimized(true);
			settingsFrame.setVisible(false);
		}
	}

	@Override
	protected void resizeComponents() {
		Theme theme = getTheme();
		Frame[] frames = getFrames();
		Button enable = new BasicButton("Enable");
		Button disable = new BasicButton("Disable");
		Dimension enableSize = theme.getUIForComponent(enable).getDefaultSize(
				enable);
		Dimension disableSize = theme.getUIForComponent(disable)
				.getDefaultSize(disable);
		int buttonWidth = Math.max(enableSize.width, disableSize.width);
		int buttonHeight = Math.max(enableSize.height, disableSize.height);
		for (Frame frame : frames) {
			if (frame instanceof ModuleFrame) {
				for (Component component : frame.getChildren()) {
					if (component instanceof Button) {
						component.setWidth(buttonWidth);
						component.setHeight(buttonHeight);
					}
				}
			}
		}
		recalculateSizes();
	}

	private Dimension recalculateSizes() {
		Frame[] frames = getFrames();
		int maxWidth = 0, maxHeight = 0;
		for (Frame frame : frames) {
			Dimension defaultDimension = frame.getTheme()
					.getUIForComponent(frame).getDefaultSize(frame);
			maxWidth = windowFrame.getWidth();
			frame.setHeight(defaultDimension.height);
			if (frame.isMinimized()) {
				for (Rectangle area : frame.getTheme().getUIForComponent(frame)
						.getInteractableRegions(frame))
					maxHeight = Math.max(maxHeight, area.height);
			} else
				maxHeight = Math.max(maxHeight, defaultDimension.height);
		}
		for (Frame frame : frames) {
			frame.setWidth(maxWidth);
			frame.layoutChildren();
		}
		return new Dimension(maxWidth, maxHeight);
	}
}
