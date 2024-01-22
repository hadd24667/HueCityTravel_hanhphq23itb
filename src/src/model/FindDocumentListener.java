package model;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.relicsView;

public class FindDocumentListener implements DocumentListener {
   private relicsView cacDiTichView;
   private findList findList;
public FindDocumentListener(relicsView cacDiTichView) {
	this.cacDiTichView = cacDiTichView;
	this.findList = new findList();
}
@Override
public void insertUpdate(DocumentEvent e) {
	updateSuggestionList();
	
}
@Override
public void removeUpdate(DocumentEvent e) {
	updateSuggestionList();
	
}
@Override
public void changedUpdate(DocumentEvent e) {
	updateSuggestionList();
	
}
public void updateSuggestionList()
{
      DefaultListModel<String> suggestions = findList.findRelics(cacDiTichView);
      cacDiTichView.getSuggestionList().setModel(suggestions);
   }
}