package v;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Composite;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class V {
	int num = (int)(Math.random()*9);
	protected Shell shell;
	private Text input;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			V window = new V();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		num++;
		shell = new Shell();
		shell.setImage(null);
		shell.setSize(450, 300);
		shell.setText("Guss the number");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("abc");
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(164, 129, 75, 25);
		btnNewButton.setText("Submit");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblNewLabel.setBounds(122, 31, 175, 48);
		lblNewLabel.setText("Guss the number");
		
		input = new Text(shell, SWT.BORDER);
		input.setBounds(164, 85, 76, 21);
		
		Label lblWriteTheNumber = new Label(shell, SWT.NONE);
		lblWriteTheNumber.setBounds(62, 88, 96, 15);
		lblWriteTheNumber.setText("Write the number:");
		
		Label output = new Label(shell, SWT.NONE);
		output.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		output.setBounds(122, 202, 197, 25);
		
		
		
			Listener ab = new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				
				
				String inputText =input.getText();
				if (inputText.equalsIgnoreCase("")) {
					output.setText("Error");
					return;
				}
				System.out.println(inputText);
				int gussNo; 
				try {
					 gussNo = Integer.parseInt(inputText);
				} catch (Exception e) {
					output.setText("Error");
					input.setText("");
					return;
				}
				
				
				if (gussNo>num) 
				{
					output.setText("The number is high");
					input.setText("");
				} else if (gussNo<num) {
					output.setText("The number is low");
					input.setText("");
				}
				
				else if (gussNo==num) {
					Success second = new Success();
					
					output.setText("success");
					shell.close();
					second.setVisible(true);
				}
				
			}
		};
		btnNewButton.addListener(SWT.Selection, ab);
		
		
		
	}
}
