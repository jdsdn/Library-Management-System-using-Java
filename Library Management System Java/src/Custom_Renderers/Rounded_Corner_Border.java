package Custom_Renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

import javax.swing.JPopupMenu;
import javax.swing.border.AbstractBorder;

@SuppressWarnings("serial")
public class Rounded_Corner_Border extends AbstractBorder {

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Area round = new Area(new RoundRectangle2D.Float(x, y, width - 1, height - 1, 12, 12));
		if (c instanceof JPopupMenu) { g2.fill(round); } 
		else 
		{
			Container parent = c.getParent();

			if (Objects.nonNull(parent)) 
			{
				g2.setPaint(Color.white);
				Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
				corner.subtract(round);
				g2.fill(corner);
			}
		}

		g2.setPaint(Color.gray);
		g2.draw(round);
		g2.dispose();
	}

	@Override
	public Insets getBorderInsets(Component c) { return new Insets(4, 8, 4, 8); }
	@Override
	public Insets getBorderInsets(Component c, Insets insets) { insets.set(4, 8, 4, 8); return insets; }
}