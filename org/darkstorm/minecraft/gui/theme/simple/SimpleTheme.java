package org.darkstorm.minecraft.gui.theme.simple;

import java.awt.Color;
import java.awt.Font;

import net.minecraft.client.gui.FontRenderer;

import org.darkstorm.minecraft.gui.font.UnicodeFontRenderer;
import org.darkstorm.minecraft.gui.theme.AbstractTheme;

public class SimpleTheme extends AbstractTheme {
	private final FontRenderer fontRenderer;
	
	private static Color mainColor = Color.BLACK;
	public static Color foreground = new Color(mainColor.getRed(), mainColor.getBlue(), mainColor.getGreen(), mainColor.getAlpha());

	public SimpleTheme() {
		fontRenderer = new UnicodeFontRenderer(new Font("Arial", Font.ITALIC, 15));

		installUI(new SimpleFrameUI(this));
		installUI(new SimplePanelUI(this));
		installUI(new SimpleLabelUI(this));
		installUI(new SimpleButtonUI(this));
		installUI(new SimpleCheckButtonUI(this));
		installUI(new SimpleComboBoxUI(this));
		installUI(new SimpleSliderUI(this));
		installUI(new SimpleProgressBarUI(this));
	}

	public FontRenderer getFontRenderer() {
		return fontRenderer;
	}
}
