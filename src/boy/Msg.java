package boy;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Msg {
	//method that creates a messafe
	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static String in(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	//method that creates a message with options
	public static int option(String[] options, String msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	//method that creates a message with images as options
	public static int option(ImageIcon[] options, String msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	//method that prints a string and goes to the next line
	public static void println(String msg) {
		System.out.println(msg);
	}
	//method that prints a string
	public static void print(String msg) {
		System.out.println(msg);
	}
}
