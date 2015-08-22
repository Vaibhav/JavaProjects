/**
 * 
 * CNC Hole Driller
 * 
 *@author Tyler Murphy
 *@author Vaibhav Khaitan
 *@since 08/01/15 
 */

import java.awt.EventQueue;
import java.awt.*;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


@SuppressWarnings("serial")
public class DrawerFrontMaster extends JFrame {

	private JPanel contentPane;
	private JTextField TFjob;
	private JTextField TFlength;
	private JTextField TFheight;
	private JTextField TFhandleCtc;
	private JTextField TFhandleOff;
	private JMenuItem mntmAbout;
	private JMenuItem mntmExit;
	private JMenuItem mntmExport;
	private JSpinner QuantitySpinner;
	private JButton btnEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		initComponets();
		createEvent();
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	String job;
	String Total;
	String Quantity;
	String HandleCtC;
	String HandleOff;
	String Length;
	String Height;
	String Unit = "Imperial";
	String lPM = "\"Press START to Lower Pins\"";

	int count = 1;
	int Quant;
	int total;
	int u = -1;

	double CTC;
	double handleOff;
	double L;
	double W;
	double x = 0, O = 0, OneX = 0, OneY = 0, TwoX = 0, TwoY = 0, xOff = 96,
			yOff = 48, zOff = 0.75, RH = 0.375;

	private JRadioButton rdbtnMetric;
	private JButton btnClear;
	private JTextField TfL;
	private JTextField TfH;
	private JTextField TfJ;
	private JTextField TFnumber;
	private JTextField TfQ;
	private JTextField TfCTC;
	private JTextField TfHO;
	private JButton btnWrite;

	double[] height = new double[50];
	double[] length = new double[50];
	private int[] quantity = new int[50];
	int i = 0;
	
	private void initComponets() {

		setTitle("Drawer Front Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 518);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
			
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(144,195,212));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(161,212,144));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(144,195,212));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1344,
						Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1344,
										Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
						gl_contentPane
						.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92,
								GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 107,
										GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 468,
												Short.MAX_VALUE).addContainerGap()));

		JLabel lblDataInput = new JLabel("Data Input");

		JLabel lblQuantity = new JLabel("Quantity");

		QuantitySpinner = new JSpinner();
	

		JLabel lblLength = new JLabel("Length");

		TFlength = new JTextField();

		TFlength.setColumns(10);

		JLabel lblHeight = new JLabel("Height");

		TFheight = new JTextField();

		TFheight.setColumns(10);

		btnEnter = new JButton("Enter");
		
			

		btnClear = new JButton("Clear");
		
		btnWrite = new JButton("Write");
	
	
		
		
	

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataInput)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblQuantity)
							.addGap(10)
							.addComponent(QuantitySpinner, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLength)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TFlength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblHeight)
							.addGap(4)
							.addComponent(TFheight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnWrite)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnEnter)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnClear)))))
					.addContainerGap(823, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDataInput)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(QuantitySpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLength)
						.addComponent(TFlength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeight)
						.addComponent(TFheight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnter)
						.addComponent(btnClear))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnWrite)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblJobName = new JLabel("Job Name & Number");

		TFjob = new JTextField();
		

		TFjob.setColumns(10);

		JLabel lblHandleCentertocenter = new JLabel("Handle Center-To-Center");

		TFhandleCtc = new JTextField();

		TFhandleCtc.setColumns(10);

		JLabel lblHandleOffset = new JLabel("Handle Off-Set");

		TFhandleOff = new JTextField();

		TFhandleOff.setColumns(10);

		JLabel label = new JLabel("");

		rdbtnMetric = new JRadioButton("Metric");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblJobName)
						.addComponent(lblHandleCentertocenter)
						.addComponent(lblHandleOffset))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(TFjob, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFhandleOff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(TFhandleCtc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(69)
									.addComponent(label))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(rdbtnMetric)))))
					.addContainerGap(935, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFjob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJobName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHandleCentertocenter)
						.addComponent(label)
						.addComponent(TFhandleCtc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnMetric))
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFhandleOff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHandleOffset))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		TfL = new JTextField();

		TfL.setColumns(10);

		TfH = new JTextField();
		TfH.setColumns(10);

		TfJ = new JTextField();
		TfJ.setColumns(10);

		TFnumber = new JTextField();
		TFnumber.setColumns(10);

		TfQ = new JTextField();
		TfQ.setColumns(10);

		TfCTC = new JTextField();
		TfCTC.setColumns(10);

		TfHO = new JTextField();
		TfHO.setColumns(10);

		JLabel lblJob = new JLabel("Job");

		JLabel lblQuantity_1 = new JLabel("Quantity");

		JLabel lblLength_1 = new JLabel("Length");

		JLabel lblHeight_1 = new JLabel("Height");

		JLabel lblCtc = new JLabel("CTC");

		JLabel lblOffset = new JLabel("Off-Set");
		
		JLabel lblEntry = new JLabel("Entry");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(TFnumber, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(TfJ)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TfQ, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TfL, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TfH, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(TfCTC, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TfHO, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblEntry)
							.addGap(31)
							.addComponent(lblJob, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(94)
							.addComponent(lblQuantity_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addGap(52)
							.addComponent(lblLength_1)
							.addGap(53)
							.addComponent(lblHeight_1, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addGap(81)
							.addComponent(lblCtc, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addGap(68)
							.addComponent(lblOffset, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addGap(25)))
					.addGap(725))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEntry)
						.addComponent(lblJob)
						.addComponent(lblHeight_1)
						.addComponent(lblOffset)
						.addComponent(lblQuantity_1)
						.addComponent(lblLength_1, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
						.addComponent(lblCtc))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TfL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TfCTC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TfHO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TfH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TfQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TfJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(422))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);

	}

	// Menu item exit
	private void createEvent() {

		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// Menu item about
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo) {
				JOptionPane.showConfirmDialog(null,
						"Program Created by Tyler Murphy & Vaibhav Khaitan", "About",
						JOptionPane.DEFAULT_OPTION);
			}
		});
		
			
		
		
		// job 
		TFjob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				job = TFjob.getText();

			}
		});
		// Handle CtC
		TFhandleCtc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HandleCtC = TFhandleCtc.getText();
				CTC = Double.parseDouble(HandleCtC);
			}
		});

		// metric
		rdbtnMetric.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					CTC = (CTC * 0.0394);
					Unit = "Metric";
				
			}
			}
		});

		// Handle off set
		TFhandleOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HandleOff = TFhandleOff.getText();
				handleOff = Double.parseDouble(HandleOff);
			}
		});
		// Total

		/*TFtotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Total = TFtotal.getText();
				total = Integer.parseInt(Total);
			}
		});*/

					
		//height
		TFheight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Height = TFheight.getText();
				W = Double.parseDouble(Height);
			
				
			}

		});
		//length

		TFlength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Length = TFlength.getText();
				L = Double.parseDouble(Length);
				
			}
		});

		// get Quant
		QuantitySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				
			}		
		});
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Quant = (Integer) QuantitySpinner.getValue();
				height[i]= W;
				length[i] = L;
				quantity[i] = Quant;
				total += quantity[i];
				
				/*
				JOptionPane.showConfirmDialog(null, total, "total",
						JOptionPane.DEFAULT_OPTION);
				
				JOptionPane.showConfirmDialog(null, length[0], "Length",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, height[0], "Height",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, quantity[0], "Quant",
						JOptionPane.DEFAULT_OPTION);
				
				JOptionPane.showConfirmDialog(null, length[1], "Length",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, height[1], "Height",					
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, quantity[1], "Quant",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, i, "i",
						JOptionPane.DEFAULT_OPTION);
				*/
				i++;
			}
		});
		
		//resets text fields 
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String c = String.valueOf(count);
				Quantity = String.valueOf(Quant);
				QuantitySpinner.setValue(1);
				TFlength.setText(" ");
				TFheight.setText(" ");
				TfJ.setText(job);

				TfQ.setText(Quantity);
				TfL.setText(Length);
				TfH.setText(Height);
				TfCTC.setText(HandleCtC);
				TfHO.setText(HandleOff);
				TFnumber.setText(c);
			
				
				count++;
				
			//confirms data
				/*JOptionPane.showConfirmDialog(null, job, "Job",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, CTC, "Ctc",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, Unit, "Unit",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, handleOff, "Off-set",
						JOptionPane.DEFAULT_OPTION);
				
				JOptionPane.showConfirmDialog(null, Quant, "Quantity",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, L, "Length",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showConfirmDialog(null, W, "Height",
						JOptionPane.DEFAULT_OPTION);
			*/
			
		
				}
		});
				btnWrite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				
		
		try {
			//JOptionPane.showConfirmDialog(null, total, "total",
				//	JOptionPane.DEFAULT_OPTION);
			int T = 0, G = 0;

			BufferedWriter out = new BufferedWriter(new FileWriter("Change Name.CNC"));
			out.write("%" + job);
			out.newLine();
			out.write("%Version 4.0");
			out.newLine();
			out.write("");
			out.newLine();
			out.write("[window on]");
			out.newLine();
			out.write("[CLS]");
			out.newLine();
			out.write("M00");
			out.newLine();
		
			
			for (T = 0; T < total;) {
				u++;
				//JOptionPane.showConfirmDialog(null, total, "Final i",
					//	JOptionPane.DEFAULT_OPTION);
			
				/*
				 * 
				 * 
				 * Quantity = JOptionPane
				 * .showInputDialog("Drawer Front Sizes and Quantity \nQuantity"
				 * ); Quant = Integer.parseInt(Quantity);
				 */
				if (G >= Quant)
					G = 0;
					
				
				/*
				 * Length =
				 * JOptionPane.showInputDialog("Enter Length for DF #: " + (T +
				 * 1)); L = Double.parseDouble(Length);
				 * 
				 * Height =
				 * JOptionPane.showInputDialog("Enter Height for DF #: " + (T +
				 * 1)); W = Double.parseDouble(Height);
				*/
				
				
				
				
				
				
				//double len = length[i];
				do {
					
					
					//double hi = height[i];
					//JOptionPane.showConfirmDialog(null, length[i], "Length",
						//	JOptionPane.DEFAULT_OPTION);
				
					x = CTC / 2; // half of CtC

					OneX = ((length[u] / 2) - x); // Fist hole X
					OneY = ((height[u] / 2) - O); // First hole Y

					TwoX = ((length[u] / 2) + x); // Second hole X
					TwoY = ((height[u] / 2) - O); // Second hole Y

					OneX = xOff - OneX; // adds sheet offset X to the first hole
					OneY = yOff - OneY; // adds sheet offset Y to the first hole

					TwoX = xOff - TwoX; // adds sheet offset X to the 2nd hole
					TwoY = yOff - TwoY; // adds sheet offset Y to the 2nd hole

					out.write("M61L1"); // Raise Pins, doesn't work if not sent home
					// first
					out.newLine();
					out.write("(Load DF #" + (T + 1) + ": " + length[u] + " X " + height[u] + ")"); // Next DF to load
					out.newLine();
					out.write("[PRINT " + lPM + "]");
					out.newLine();
					out.write("M00");
					out.newLine();
					out.write("M62L1"); // Lower pins
					out.newLine();
					out.write("G70"); // Inches
					out.newLine();
					out.write("SET ZSHIFT=" + zOff);
					out.newLine();
					out.write("SET XSHIFT=" + xOff);
					out.newLine();
					out.write("SET YSHIFT=" + yOff);
					out.newLine();
					out.write("G902"); // G902
					out.newLine();
					out.write("G90"); // Absolute
					out.newLine();

					out.write("S6000"); // Spinde speed
					out.newLine();
					out.write("T4M3"); // Tool number and spindle start
					out.newLine();
					out.write("M31"); // Spindle up to speed
					out.newLine();
					out.write("G00X" + OneX + "Y" + OneY); // moves to First
					// hole cooridants
					out.newLine();
					out.write("G00Z" + RH); // drops to 3/8" above piece
					out.newLine();
					out.write("G01Z-" + (zOff + 0.007) + "70F100"); // Drill to
					// depth
					out.newLine();
					out.write("G00Z" + RH); // Back to Retract Height
					out.newLine();
					out.write("G00X" + TwoX + "Y" + TwoY); // Move to 2nd hole
					out.newLine();
					out.write("G00Z" + RH); // drops to 3/8 above
					out.newLine();
					out.write("G01Z-" + (zOff + 0.007) + "F100"); // Drill to
					// depth
					out.newLine();
					out.write("G00Z" + RH); // back to Retract Height
					out.newLine();

					out.write("M51"); // Spindle Stop
					out.newLine();
					out.write("G90");
					out.newLine();
					out.write("G990");
					out.newLine();
					out.write("  ");
					out.newLine();

					out.write("G90 G00Z0"); // rapid to Z0
					out.newLine();
					out.write("G90 G00 X0 Y0"); // Rapid to home
					out.write("G90");
					out.newLine();
					out.write("G990");
					out.newLine();

			
					  System.out.println("   "); System.out.println("DF #: " +
					  (T + 1)); // Drawer Front // number
					  System.out.println("Length: " + L);
					  System.out.println("Width: " + W);
					 System.out.println("Center to Center:" + CTC);
					  System.out.println("------------");
					 System.out.println("First hole: " + OneX + ", " + OneY);
					 System.out.println("Second hole: " + TwoX + ", " + TwoY);
					  System.out.println("  ");
					 

					T++;
					G++;
					//JOptionPane.showConfirmDialog(null, u, "u",
						//	JOptionPane.DEFAULT_OPTION);
					
				} while ((G + 1) <= quantity[u] && T<total);
				}
			
			
			if(T==total){
				
				out.write("G90 G00Z0"); // rapid to Z0
				out.newLine();
				out.write("G90 G00 X0 Y0"); // Rapid to home
				out.newLine();
				out.write("M02"); // full stop
				out.newLine();
				out.close();
				}
		}
		catch (IOException e) {
		}
		JOptionPane.showConfirmDialog(null, "File Ready", "DONE",
			JOptionPane.DEFAULT_OPTION);
		//Path filePath = Paths.get("V4.CNC");
		
		//("V4.CNC");
		
		
		
					}
				});
	}
}
