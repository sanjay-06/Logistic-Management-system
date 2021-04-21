package transport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Landing extends JFrame {

	private JPanel contentPane;

	public void callclose()
	{
		this.hide();
	}
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing frame = new Landing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Landing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 2000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Signup");
		button.setForeground(SystemColor.window);
		button.setFont(new Font("Consolas", Font.PLAIN, 15));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(1150, 644, 202, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callclose();
				 Signup frame = new Signup();
                 frame.setVisible(true);
			}
		});
		
		Button button_1 = new Button("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callclose();
				  try {
			            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			                if ("Nimbus".equals(info.getName())) {
			                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                    break;
			                }
			            }
			        } catch (ClassNotFoundException ex) {
			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (InstantiationException ex) {
			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (IllegalAccessException ex) {
			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        }
			        //</editor-fold>

			        /* Create and display the form */
			        java.awt.EventQueue.invokeLater(new Runnable() {
			            public void run() {
			               Loginsignup l= new Loginsignup();
			                l.setVisible(true);
			            }
			        });
			}
		});
		button_1.setForeground(SystemColor.window);
		button_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setBounds(736, 644, 202, 40);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\transport\\images\\images\\trans.jpg"));
		lblNewLabel.setBounds(0, 0, 593, 845);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java\\transport\\images\\images\\image.jpg"));
		lblNewLabel_1.setBounds(795, 299, 543, 284);
		contentPane.add(lblNewLabel_1);
	}
	
}
