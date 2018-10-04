package Custom_Renderers;

import java.awt.LayoutManager;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Spaced_Tabbed_Pane_UI extends BasicTabbedPaneUI {
	@Override
	protected LayoutManager createLayoutManager() {
		return new BasicTabbedPaneUI.TabbedPaneLayout() {
			@Override
			protected void calculateTabRects(int tabPlacement, int tabCount) {
				final int spacer = 10; // should be non-negative
				final int indent = -8;

				super.calculateTabRects(tabPlacement, tabCount);

				for (int i = 0; i < rects.length; i++) {
					rects[i].x += i + spacer + indent;
				}
			}
		};
	}
}