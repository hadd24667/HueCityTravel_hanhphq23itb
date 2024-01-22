package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

import model.findList;
import view.relicsView;

public class insertFindResult extends findList{

	private relicsView cacDiTichView;

	public insertFindResult(view.relicsView cacDiTichView) {
		this.cacDiTichView = cacDiTichView;
		attachMouseListener();
	}
	public void attachMouseListener() {
		cacDiTichView.getSuggestionList().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				findListMouseListener(e);
			}
		});
	}
	
	public void findListMouseListener(MouseEvent e)
	{
			JList<String> list = (JList<String>) e.getSource();
			if(e.getClickCount() == 1) {
				int index = list.locationToIndex(e.getPoint());
				if(index != -1)
				{
					String selectedValue = list.getModel().getElementAt(index);
					cacDiTichView.getSearchTextField().setText(selectedValue);
				}
			} 
	}
	
}