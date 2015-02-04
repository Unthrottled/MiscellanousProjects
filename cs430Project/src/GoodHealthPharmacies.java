import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;


public class GoodHealthPharmacies {
	
	private JFrame frame;
	private DataController dataManager;
	private JTextField docLastName;
	private JTextField docFirstName;
	private JTextField docSSN;
	private JTextField docSpecialty;
	private JTextField docLastNameShow;
	private JTextField docFirstNameShow;
	private JTextField docSSNShow;
	private JTextField docSpecialtyShow;
	private JTextField patientFirstName;
	private JTextField patientLastName;
	private JTextField patientSSN;
	private JTextField patientAddress;
	private JTextField patientBirthday;
	private JTextField patientFirstNameShow;
	private JTextField patientLastNameShow;
	private JTextField patientSSNShow;
	private JTextField patientAddressShow;
	private JTextField patientAgeShow;
	private JTextField drugName;
	private JTextField drugFormula;
	private JTextField drugFormulaChange;
	private JTextField pharmCompName;
	private JTextField pharmCompPhone;
	private JTextField pharmCompPhoneShow;
	private JTextField pharmName;
	private JTextField pharmAddress;
	private JTextField pharmPhone;
	private JTextField pharmAddressChange;
	private JTextField pharmPhoneChange;
	private JTextField supervisorLastName;
	private JTextField supervisorFirstName;
	private JTextField supervisorChangeLastName;
	private JTextField supervisorChangeFirstName;
	private JTextField notPricedDrug;	
	private JTextField contractEndDateChange;
	private JTextField contractStartDateChange;
	
	private DefaultTableModel patientPerscriptionTableModel;
	private DefaultTableModel mainPatientTableModel;
	private DefaultTableModel mainDoctorTableModel;	
	private DefaultTableModel mainPharmacyCompanyTableModel;
	private DefaultTableModel patientPerscriptionPharmacyListTableModel;
	private DefaultTableModel pharmacyDrugsViewTableModel;//For view all drugs and non-priced drugs query
	private DefaultTableModel pharmacyDrugsViewCompetitorsTableModel;//for view competitors drugs query
	private DefaultTableModel mainContractTableModel;
	private DefaultTableModel mainDrugTableModel;
	private DefaultTableModel mainDrugTableModelMostExpensive;
	private DefaultTableModel patientPerscriptionListTableModel;
	private DefaultTableModel mainPharmacyTableModel;
	private DefaultTableModel pharmacyPerscriptionsViewTableModel;
	private DefaultTableModel pharmacyPerscriptionMangerTableModel;
	
	private JTable patientPerscriptionListTable;
	private JTable pharmacyPerscriptionsViewTable;
	private JTable pharmacyPerscriptionMangerTable;
	private JTable pharmacyDrugsViewTable;
	private JTable patientPerscriptionPharmacyListTable;
	private JTable mainPatientTable;
	private JTable mainDoctorTable;
	private JTable mainPharmacyTable;
	private JTable mainDrugTable;
	private JTable mainPharmacyCompanyTable;			
	private JTable mainContractTable;
	
	private JComboBox<ComboItem> comboBoxPatientPerscribe;
	private JComboBox<ComboItem> comboBoxPerscriptionManagerCurrentPerscription;	
	private JComboBox<ComboItem> comboBoxCurrentPatient;
	private JComboBox<ComboItem> comboBoxCurrentPatientGen;	
	private JComboBox<ComboItem> comboBoxCurrentDoctorGen;	
	private JComboBox<ComboItem> comboBoxPerscriptionManagerCurrentPatient;	
	private JComboBox<ComboItem> comboBoxCurrentPharmacyPerscriptions;	
	private JComboBox<ComboItem> comboBoxCurrentPharmacyPerscriptionManager;
	private JComboBox<ComboItem> comboBoxCurrentPharmacyDrugs;
	private JComboBox<ComboItem> comboBoxPharmContract;
	private JComboBox<ComboItem> comboBoxPharmInfo;
	private JComboBox<ComboItem> comboBoxPharmacyCompany;
	private JComboBox<ComboItem> comboBoxPharmCompContract;
	private JComboBox<ComboItem> comboBoxPharmContractChange;
	private JComboBox<ComboItem> comboBoxPharmCompContractChange;
	private JComboBox<ComboItem> comboBoxPrimaryPhysician;
	private JComboBox<ComboItem> comboBoxDoctorPerscribe;
	private JComboBox<ComboItem> comboBoxDrugPerscribe;
	private JComboBox<ComboItem> comboBoxPharmacyCompanyChange;
	private JComboBox<ComboItem> comboBoxPharmacyCompanyChangeDrug;
	private JComboBox<ComboItem> comboBoxDrugChange;
	private JComboBox<ComboItem> comboBoxChangePatientPrimaryPhysician;
		
	private DefaultComboBoxModel<ComboItem> perscripDrugComboBoxModel;
	private DefaultComboBoxModel<ComboItem> allDoctorComboBoxModel;
	private DefaultComboBoxModel<ComboItem> allPatientComboBoxModel;
	private DefaultComboBoxModel<ComboItem> allPharmacyComboBoxModel;
	private DefaultComboBoxModel<ComboItem> allPharmacyCompanyComboBoxModel;
	private DefaultComboBoxModel<ComboItem> allPerscriptionComboBoxModel;
	private DefaultComboBoxModel<ComboItem> allContractComboBoxModel;
	private DefaultComboBoxModel<ComboItem> perscripPatientComboBoxModel;
	private DefaultComboBoxModel<ComboItem> perscripPatientCurrentComboBoxModel;
	private DefaultComboBoxModel<ComboItem> perscripManagerPatientCurrentComboBoxModel;
	private DefaultComboBoxModel<ComboItem> currentPerscriptionsComboBoxModel;
	private DefaultComboBoxModel<ComboItem> perscriptionManagerCurrentPerscriptionComboBoxModel;
	private DefaultComboBoxModel<ComboItem> currentPatientComboBoxModel;
	private DefaultComboBoxModel<ComboItem> perscriptionManagerCurrentPatientComboBoxModel;
	private DefaultComboBoxModel<ComboItem> currentPharmacyPerscriptionsComboBoxModel;
	private DefaultComboBoxModel<ComboItem> currentPharmacyDrugsComboBoxModel;	
	private DefaultComboBoxModel<ComboItem> pharmCompContractChangeComboBoxModel;
	
	private JSpinner perscriptionQuantity;
	private JSpinner doctorExperience;
	private JSpinner drugPrice;
	private JSpinner contractStartDate;	
	private JSpinner contractEndDate;
	
	private JSpinner doctorExperienceShow;
	
	private ButtonGroup drugViewGroup;
	private ButtonGroup maindrugViewGroup;
	private ButtonGroup viewPerscriptionGroup;
	private ButtonGroup managePerscriptionGroup;	
	
	private JButton btnPriceDrug;
	
	private JTextArea contractTerms;
	private JTextArea contractTermsChange;
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodHealthPharmacies window = new GoodHealthPharmacies();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GoodHealthPharmacies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	/**
	 * Things to do:
	 * Drugs are made by pharmacy companies. Pharmacies can sell drugs from contracted pharmacy companies. Pharmacy companies don't determine the price.
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1180, 853);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dataManager = new DataController();		
		
		allPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPatients());
		allPharmacyComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPharmacies());
		allPharmacyCompanyComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPharmacyCompanies());
		
		//JLabel lblLogo = new JLabel("logo");
		//lblLogo.setBounds(12, 0, 1656, 99);
		//frame.getContentPane().add(lblLogo);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 15, 1680, 900);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainTabbedPane.addChangeListener(new TabListener());
		mainTabbedPane.setBounds(12, 72, 1142, 732);
		mainPanel.add(mainTabbedPane);
		
		JTabbedPane patientsTab = new JTabbedPane(JTabbedPane.TOP);
		patientsTab.addChangeListener(new TabListener());
		mainTabbedPane.addTab("Patients", null, patientsTab, null);
		
		JPanel generalPatientsTab = new JPanel();
		patientsTab.addTab("General", null, generalPatientsTab, null);
		generalPatientsTab.setLayout(null);
		
		JPanel generalPatientsPanel = new JPanel();
		generalPatientsPanel.setBounds(12, 12, 1108, 654);
		generalPatientsPanel.setBorder(BorderFactory.createTitledBorder("General Patient Information"));
		generalPatientsTab.add(generalPatientsPanel);
		generalPatientsPanel.setLayout(null);
		
		JPanel mainPatientPanel = new JPanel();
		mainPatientPanel.setBounds(12, 35, 806, 561);
		mainPatientPanel.setBorder(BorderFactory.createTitledBorder("Patient Portal"));
		generalPatientsPanel.add(mainPatientPanel);
		mainPatientPanel.setLayout(null);
		
		JScrollPane mainPatientScrollPanel = new JScrollPane();
		mainPatientScrollPanel.setBounds(12, 62, 782, 429);	
		mainPatientPanel.add(mainPatientScrollPanel);
		
		mainPatientTableModel = new DefaultTableModel();		
		mainPatientTable = new JTable(mainPatientTableModel);			
		mainPatientTable.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		mainPatientScrollPanel.setViewportView(mainPatientTable);		
		
		mainPatientTableModel.addColumn("Patient\'s SSN");
		mainPatientTableModel.addColumn("Patient\'s Name");
		mainPatientTableModel.addColumn("Age");
		mainPatientTableModel.addColumn("Address");
		mainPatientTableModel.addColumn("Primary Physician");		
		setMainPatientTable();
		
		JButton btnRemovePatient = new JButton("Remove Patient");
		btnRemovePatient.setBounds(12, 25, 145, 25);
		btnRemovePatient.addActionListener(new ButtonListener("removePatient"));
		mainPatientPanel.add(btnRemovePatient);
		
		//JButton btnViewDetails = new JButton("View Details");
		//btnViewDetails.setBounds(640, 503, 154, 25);
		//mainPatientPanel.add(btnViewDetails);
		
		JTabbedPane patientSpecificTab = new JTabbedPane(JTabbedPane.TOP);
		//patientSpecificTab.setVisible(false);		
		patientSpecificTab.addChangeListener(new TabListener());
		patientsTab.addTab("Patient Details", null, patientSpecificTab, null);				
		
		JPanel patientsPerscriptionTab = new JPanel();
		patientSpecificTab.addTab("Patient's Perscriptions", null, patientsPerscriptionTab, null);
		patientsPerscriptionTab.setLayout(null);
		
		JPanel patientPerscriptionGeneralPanel = new JPanel();
		patientPerscriptionGeneralPanel.setBounds(12, 12, 908, 627);
		patientPerscriptionGeneralPanel.setBorder(BorderFactory.createTitledBorder("Patient Perscription Information"));
		patientsPerscriptionTab.add(patientPerscriptionGeneralPanel);
		patientPerscriptionGeneralPanel.setLayout(null);
		
		JPanel patientPerscriptionPanel = new JPanel();
		patientPerscriptionPanel.setBounds(12, 24, 430, 80);
		patientPerscriptionPanel.setBorder(BorderFactory.createTitledBorder("Current Patient"));
		patientPerscriptionGeneralPanel.add(patientPerscriptionPanel);
		patientPerscriptionPanel.setLayout(null);
		
		//perscripPatientCurrentComboBoxModel = new DefaultComboBoxModel<ComboItem>();
		comboBoxCurrentPatient = new JComboBox<ComboItem>(allPatientComboBoxModel);
		comboBoxCurrentPatient.addActionListener(new ComboListener("patientPerscriptions"));
		comboBoxCurrentPatient.setBounds(12, 30, 325, 24);
		patientPerscriptionPanel.add(comboBoxCurrentPatient);
		
		JPanel patientPerscriptionListPanel = new JPanel();
		patientPerscriptionListPanel.setBounds(12, 116, 884, 499);
		patientPerscriptionListPanel.setBorder(BorderFactory.createTitledBorder("Patient's Perscriptions Information"));
		patientPerscriptionGeneralPanel.add(patientPerscriptionListPanel);
		patientPerscriptionListPanel.setLayout(null);				
		
		JScrollPane patientPerscriptionListScrollPanel = new JScrollPane();
		patientPerscriptionListScrollPanel.setBounds(24, 24, 848, 408);
		patientPerscriptionListPanel.add(patientPerscriptionListScrollPanel);
		
		patientPerscriptionListTableModel = new DefaultTableModel();
		patientPerscriptionListTable = new JTable(patientPerscriptionListTableModel);
		patientPerscriptionListScrollPanel.setViewportView(patientPerscriptionListTable);
		
		patientPerscriptionListTableModel.addColumn("Perscription Id");
		patientPerscriptionListTableModel.addColumn("Drug");
		patientPerscriptionListTableModel.addColumn("Quantity");
		patientPerscriptionListTableModel.addColumn("Date Perscribed");
		patientPerscriptionListTableModel.addColumn("Perscription Status");	
		patientPerscriptionListTableModel.addColumn("Pharmacy");
		setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
				
		JPanel patientPerscriptionManagerTab = new JPanel();
		patientSpecificTab.addTab("Patient Perscription Manager", null, patientPerscriptionManagerTab, null);
		patientPerscriptionManagerTab.setLayout(null);
		
		JPanel patientPerscriptionManagerGeneralPanel = new JPanel();
		patientPerscriptionManagerGeneralPanel.setBounds(12, 12, 908, 627);
		patientPerscriptionManagerGeneralPanel.setBorder(BorderFactory.createTitledBorder("Patient Perscription Manager Information"));
		patientPerscriptionManagerTab.add(patientPerscriptionManagerGeneralPanel);
		patientPerscriptionManagerGeneralPanel.setLayout(null);
		
		JPanel patientPerscriptionManagerPanel = new JPanel();
		patientPerscriptionManagerPanel.setBounds(12, 24, 430, 161);
		patientPerscriptionManagerPanel.setBorder(BorderFactory.createTitledBorder("Current Patient & Unassigned Perscription"));
		patientPerscriptionManagerGeneralPanel.add(patientPerscriptionManagerPanel);
		patientPerscriptionManagerPanel.setLayout(null);
		
		comboBoxPerscriptionManagerCurrentPatient = new JComboBox<ComboItem>(allPatientComboBoxModel);
		comboBoxPerscriptionManagerCurrentPatient.setBounds(12, 28, 406, 24);
		comboBoxPerscriptionManagerCurrentPatient.addActionListener(new ComboListener("unassignedPerscriptionsPatient"));
		patientPerscriptionManagerPanel.add(comboBoxPerscriptionManagerCurrentPatient);
		
		JLabel lblPerscriptionManagerCurrentPatient = new JLabel("Patient");
		lblPerscriptionManagerCurrentPatient.setBounds(12, 63, 70, 15);
		patientPerscriptionManagerPanel.add(lblPerscriptionManagerCurrentPatient);
		
		perscriptionManagerCurrentPerscriptionComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPatientPerscriptionDropDown(
				allPatientComboBoxModel.getElementAt(comboBoxPerscriptionManagerCurrentPatient.getSelectedIndex()).getValue()));		
		comboBoxPerscriptionManagerCurrentPerscription = new JComboBox<ComboItem>(perscriptionManagerCurrentPerscriptionComboBoxModel);
		comboBoxPerscriptionManagerCurrentPerscription.addActionListener(new ComboListener("unassignedPerscriptionsPerscription"));
		comboBoxPerscriptionManagerCurrentPerscription.setBounds(12, 100, 406, 24);
		patientPerscriptionManagerPanel.add(comboBoxPerscriptionManagerCurrentPerscription);
		
		JLabel lblUnassignedPerscription = new JLabel("Unassigned Perscription");
		lblUnassignedPerscription.setBounds(12, 136, 174, 15);
		patientPerscriptionManagerPanel.add(lblUnassignedPerscription);		
		
		JPanel patientPerscriptionManagerPharmaciesPanel = new JPanel();
		patientPerscriptionManagerPharmaciesPanel.setBounds(12, 203, 764, 424);
		patientPerscriptionManagerGeneralPanel.add(patientPerscriptionManagerPharmaciesPanel);
		patientPerscriptionManagerPharmaciesPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Options"));
		patientPerscriptionManagerPharmaciesPanel.setLayout(null);
		
		JScrollPane patientPerscriptionManagerScrollPane = new JScrollPane();
		patientPerscriptionManagerScrollPane.setBounds(12, 23, 707, 303);
		patientPerscriptionManagerPharmaciesPanel.add(patientPerscriptionManagerScrollPane);
		
		patientPerscriptionPharmacyListTableModel = new DefaultTableModel();		
		patientPerscriptionPharmacyListTable = new JTable(patientPerscriptionPharmacyListTableModel);
		patientPerscriptionPharmacyListTable.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		patientPerscriptionManagerScrollPane.setViewportView(patientPerscriptionPharmacyListTable);
		
		patientPerscriptionPharmacyListTableModel.addColumn("Pharmacy");
		patientPerscriptionPharmacyListTableModel.addColumn("Producer");
		patientPerscriptionPharmacyListTableModel.addColumn("Price");
		
		setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
				comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());
				
		JButton btnAssignPharmacy = new JButton("Assign Pharmacy");
		btnAssignPharmacy.addActionListener(new ButtonListener("assignPharmacy"));
		btnAssignPharmacy.setBounds(598, 387, 154, 25);
		patientPerscriptionManagerPharmaciesPanel.add(btnAssignPharmacy);				
		
		JPanel patientInfoTab = new JPanel();
		patientSpecificTab.addTab("Patients's Info", null, patientInfoTab, null);
		patientInfoTab.setLayout(null);
		
		JPanel patientGenInfoShow = new JPanel();
		patientGenInfoShow.setBounds(12, 12, 649, 627);		
		patientGenInfoShow.setBorder(BorderFactory.createTitledBorder("Patient Information"));
		patientInfoTab.add(patientGenInfoShow);
		patientGenInfoShow.setLayout(null);
		
		JButton btnChangePatient = new JButton("Authorize");
		//btnNewpatient.setEnabled(false);
		btnChangePatient.setBounds(374, 590, 117, 25);
		btnChangePatient.addActionListener(new ButtonListener("changePatient"));
		patientGenInfoShow.add(btnChangePatient);
		
		JPanel patientGenInfoPanel = new JPanel();
		patientGenInfoPanel.setBounds(12, 24, 430, 80);
		patientGenInfoPanel.setBorder(BorderFactory.createTitledBorder("Current Patient"));
		patientGenInfoShow.add(patientGenInfoPanel);
		patientGenInfoPanel.setLayout(null);
		
		//perscripPatientCurrentComboBoxModel = new DefaultComboBoxModel<ComboItem>();
		comboBoxCurrentPatientGen = new JComboBox<ComboItem>(allPatientComboBoxModel);
		comboBoxCurrentPatientGen.addActionListener(new ComboListener("patientInfo"));
		comboBoxCurrentPatientGen.setBounds(12, 30, 325, 24);
		patientGenInfoPanel.add(comboBoxCurrentPatientGen);
		
		JPanel patientNameShowPanel = new JPanel();
		patientNameShowPanel.setBounds(12, 140, 334, 74);
		patientNameShowPanel.setBorder(BorderFactory.createTitledBorder("Name"));
		patientGenInfoShow.add(patientNameShowPanel);
		patientNameShowPanel.setLayout(null);		

		patientLastNameShow = new JTextField();
		patientLastNameShow.setBounds(12, 27, 114, 19);
		patientNameShowPanel.add(patientLastNameShow);
		patientLastNameShow.setColumns(10);
		
		patientFirstNameShow = new JTextField();
		patientFirstNameShow.setBounds(131, 27, 114, 19);
		patientNameShowPanel.add(patientFirstNameShow);
		patientFirstNameShow.setColumns(10);
		
		JLabel lblpatientLastShow = new JLabel("Last Name");
		lblpatientLastShow.setBounds(12, 51, 75, 15);
		patientNameShowPanel.add(lblpatientLastShow);
		
		JLabel lblpatientFirstShow = new JLabel("First Name");
		lblpatientFirstShow.setBounds(131, 51, 76, 15);
		patientNameShowPanel.add(lblpatientFirstShow);
		
		JPanel patientSocialShowPanel = new JPanel();
		patientSocialShowPanel.setBounds(12, 226, 334, 87);
		patientSocialShowPanel.setBorder(BorderFactory.createTitledBorder("Social Security Number"));
		patientGenInfoShow.add(patientSocialShowPanel);
		patientSocialShowPanel.setLayout(null);
		
		patientSSNShow = new JTextField();
		patientSSNShow.setEnabled(false);
		patientSSNShow.setEditable(false);
		patientSSNShow.setBounds(12, 30, 114, 19);
		patientSocialShowPanel.add(patientSSNShow);
		patientSSNShow.setColumns(10);
		
		JPanel patientPersonalInfoShowPanel = new JPanel();
		patientPersonalInfoShowPanel.setBounds(12, 325, 334, 130);
		patientPersonalInfoShowPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));
		patientGenInfoShow.add(patientPersonalInfoShowPanel);
		patientPersonalInfoShowPanel.setLayout(null);
		
		patientAddressShow = new JTextField();
		patientAddressShow.setBounds(12, 27, 310, 19);
		patientPersonalInfoShowPanel.add(patientAddressShow);
		patientAddressShow.setColumns(10);
		
		patientAgeShow = new JTextField();
		patientAgeShow.setBounds(12, 73, 114, 19);
		patientPersonalInfoShowPanel.add(patientAgeShow);
		patientAgeShow.setColumns(10);
		
		JLabel lblPatientAddressShow = new JLabel("Address");
		lblPatientAddressShow.setBounds(12, 46, 70, 15);
		patientPersonalInfoShowPanel.add(lblPatientAddressShow);
		
		JLabel lblBirthdayShow = new JLabel("Birthday");
		lblBirthdayShow.setBounds(12, 91, 70, 15);
		patientPersonalInfoShowPanel.add(lblBirthdayShow);
		
		JPanel patientPhysicianPanelShow = new JPanel();
		patientPhysicianPanelShow.setBounds(12, 467, 334, 87);
		patientPhysicianPanelShow.setBorder(BorderFactory.createTitledBorder("Primary Physician"));
		patientGenInfoShow.add(patientPhysicianPanelShow);
		patientPhysicianPanelShow.setLayout(null);	
		
		allDoctorComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllDoctors());
		comboBoxChangePatientPrimaryPhysician = new JComboBox<ComboItem>(allDoctorComboBoxModel);
		comboBoxChangePatientPrimaryPhysician.setBounds(12, 28, 296, 24);
		patientPhysicianPanelShow.add(comboBoxChangePatientPrimaryPhysician);
		
    	setPatientInfoFields(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatientGen.getSelectedIndex()).getValue());
		
		JTabbedPane addPatientsTab = new JTabbedPane(JTabbedPane.TOP);
		patientsTab.addTab("Add..", null, addPatientsTab, null);
		
		JPanel newPatientTab = new JPanel();
		addPatientsTab.addTab("New Patient", null, newPatientTab, null);
		newPatientTab.setLayout(null);
		
		JPanel patientGenInfo = new JPanel();
		patientGenInfo.setBounds(12, 12, 649, 627);		
		patientGenInfo.setBorder(BorderFactory.createTitledBorder("New Patient Information"));
		newPatientTab.add(patientGenInfo);
		patientGenInfo.setLayout(null);
		
		JPanel patientNamePanel = new JPanel();
		patientNamePanel.setBounds(12, 29, 334, 74);
		patientNamePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		patientGenInfo.add(patientNamePanel);
		patientNamePanel.setLayout(null);
		
		patientLastName = new JTextField();
		patientLastName.setBounds(12, 27, 114, 19);
		patientNamePanel.add(patientLastName);
		patientLastName.setColumns(10);
		
		patientFirstName = new JTextField();
		patientFirstName.setBounds(131, 27, 114, 19);
		patientNamePanel.add(patientFirstName);
		patientFirstName.setColumns(10);
		
		JLabel lblpatientLast = new JLabel("Last Name");
		lblpatientLast.setBounds(12, 51, 75, 15);
		patientNamePanel.add(lblpatientLast);
		
		JLabel lblpatientFirst = new JLabel("First Name");
		lblpatientFirst.setBounds(131, 51, 76, 15);
		patientNamePanel.add(lblpatientFirst);
		
		JPanel patientSocialPanel = new JPanel();
		patientSocialPanel.setBounds(12, 115, 334, 87);
		patientSocialPanel.setBorder(BorderFactory.createTitledBorder("Social Security Number"));
		patientGenInfo.add(patientSocialPanel);
		patientSocialPanel.setLayout(null);
		
		patientSSN = new JTextField();
		patientSSN.setBounds(12, 30, 114, 19);
		patientSocialPanel.add(patientSSN);
		patientSSN.setColumns(10);
		
		JLabel lblPatientSocialFormat = new JLabel("XXXXXXXX");
		lblPatientSocialFormat.setForeground(Color.GRAY);
		lblPatientSocialFormat.setBounds(12, 60, 207, 15);
		patientSocialPanel.add(lblPatientSocialFormat);			
		
		JButton btnNewpatient = new JButton("Authorize");
		//btnNewpatient.setEnabled(false);
		btnNewpatient.setBounds(374, 590, 117, 25);
		btnNewpatient.addActionListener(new ButtonListener("newPatient"));
		patientGenInfo.add(btnNewpatient);
		
		JLabel lblAllFieldsRequired = new JLabel("*All Fields Required");
		lblAllFieldsRequired.setForeground(Color.RED);
		lblAllFieldsRequired.setBounds(374, 563, 147, 15);
		patientGenInfo.add(lblAllFieldsRequired);
		
		//JButton btnClear = new JButton("Clear");
		//btnClear.setBounds(520, 590, 117, 25);
		//patientGenInfo.add(btnClear);
		
		JPanel patientPersonalInfoPanel = new JPanel();
		patientPersonalInfoPanel.setBounds(12, 214, 334, 130);
		patientPersonalInfoPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));
		patientGenInfo.add(patientPersonalInfoPanel);
		patientPersonalInfoPanel.setLayout(null);
		
		patientAddress = new JTextField();
		patientAddress.setBounds(12, 27, 310, 19);
		patientPersonalInfoPanel.add(patientAddress);
		patientAddress.setColumns(10);
		
		patientBirthday = new JTextField();
		patientBirthday.setBounds(12, 73, 114, 19);
		patientPersonalInfoPanel.add(patientBirthday);
		patientBirthday.setColumns(10);
		
		JLabel lblPatientAddress = new JLabel("Address");
		lblPatientAddress.setBounds(12, 46, 70, 15);
		patientPersonalInfoPanel.add(lblPatientAddress);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(12, 91, 70, 15);
		patientPersonalInfoPanel.add(lblAge);
		
		JPanel patientPhysicianPanel = new JPanel();
		patientPhysicianPanel.setBounds(12, 356, 334, 87);
		patientPhysicianPanel.setBorder(BorderFactory.createTitledBorder("Primary Physician"));
		patientGenInfo.add(patientPhysicianPanel);
		patientPhysicianPanel.setLayout(null);
		
		comboBoxPrimaryPhysician = new JComboBox<ComboItem>(allDoctorComboBoxModel);
		comboBoxPrimaryPhysician.setBounds(12, 28, 296, 24);
		patientPhysicianPanel.add(comboBoxPrimaryPhysician);
		
		JLabel lblChooseOneDoctor = new JLabel("Choose One");
		lblChooseOneDoctor.setForeground(Color.GRAY);
		lblChooseOneDoctor.setBounds(22, 64, 175, 15);
		patientPhysicianPanel.add(lblChooseOneDoctor);
		
		JTabbedPane doctorsTab = new JTabbedPane(JTabbedPane.TOP);
		doctorsTab.addChangeListener(new TabListener());
		mainTabbedPane.addTab("Physicians", null, doctorsTab, null);
		
		JPanel generalDoctorTab = new JPanel();
		doctorsTab.addTab("General", null, generalDoctorTab, null);
		generalDoctorTab.setLayout(null);
		
		JPanel generalDoctorPanel = new JPanel();
		generalDoctorPanel.setBounds(12, 12, 1108, 654);
		generalDoctorPanel.setBorder(BorderFactory.createTitledBorder("General Physician Information"));
		generalDoctorTab.add(generalDoctorPanel);
		generalDoctorPanel.setLayout(null);
		
		JPanel mainDoctorPanel = new JPanel();
		mainDoctorPanel.setBounds(12, 35, 806, 561);
		mainDoctorPanel.setBorder(BorderFactory.createTitledBorder("Physician Portal"));
		generalDoctorPanel.add(mainDoctorPanel);
		mainDoctorPanel.setLayout(null);
		
		JScrollPane mainDoctorScrollPanel = new JScrollPane();
		mainDoctorScrollPanel.setBounds(12, 62, 782, 429);	
		mainDoctorPanel.add(mainDoctorScrollPanel);
		
		mainDoctorTableModel = new DefaultTableModel();
		mainDoctorTable = new JTable(mainDoctorTableModel);
		mainDoctorScrollPanel.setViewportView(mainDoctorTable);
		
		mainDoctorTableModel.addColumn("SSN");
		mainDoctorTableModel.addColumn("Name");
		mainDoctorTableModel.addColumn("Specialty");
		mainDoctorTableModel.addColumn("Years Experience");		
		
		setMainDoctorTable();
		
		JButton btnRemoveDoctor = new JButton("Remove Physician");
		btnRemoveDoctor.setBounds(12, 25, 165, 25);
		btnRemoveDoctor.addActionListener(new ButtonListener("removeDoctor"));
		mainDoctorPanel.add(btnRemoveDoctor);		
		
		JPanel perscribeTab = new JPanel();
		doctorsTab.addTab("Percribe", null, perscribeTab, null);
		perscribeTab.setLayout(null);
		
		JPanel perscriptionGenInfo = new JPanel();
		perscriptionGenInfo.setBounds(12, 12, 649, 627);		
		perscriptionGenInfo.setBorder(BorderFactory.createTitledBorder("New Perscription Information"));
		perscribeTab.add(perscriptionGenInfo);
		perscriptionGenInfo.setLayout(null);
		
		JPanel perscribingPartiesPanel = new JPanel();
		perscribingPartiesPanel.setBounds(12, 22, 416, 293);
		perscribingPartiesPanel.setBorder(BorderFactory.createTitledBorder("Perscribing Parties"));
		perscriptionGenInfo.add(perscribingPartiesPanel);
		perscribingPartiesPanel.setLayout(null);
		
		JPanel doctorPanel = new JPanel();
		doctorPanel.setBounds(12, 45, 376, 94);
		doctorPanel.setBorder(BorderFactory.createTitledBorder("Physician"));
		perscribingPartiesPanel.add(doctorPanel);
		doctorPanel.setLayout(null);		
		
		comboBoxDoctorPerscribe = new JComboBox<ComboItem>(allDoctorComboBoxModel);
		comboBoxDoctorPerscribe.setBounds(12, 35, 352, 24);
		comboBoxDoctorPerscribe.setName("Doctor Perscribe");
		comboBoxDoctorPerscribe.addActionListener (new ComboListener("perscribingDoctor"));
		doctorPanel.add(comboBoxDoctorPerscribe);		
		
		JPanel patientPanel = new JPanel();
		patientPanel.setBounds(12, 151, 376, 94);
		patientPanel.setBorder(BorderFactory.createTitledBorder("Patient"));
		perscribingPartiesPanel.add(patientPanel);
		patientPanel.setLayout(null);
		
		perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(
				getPerscriptPatient(allDoctorComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
		comboBoxPatientPerscribe = new JComboBox<ComboItem>(perscripPatientComboBoxModel);		
		comboBoxPatientPerscribe.setBounds(12, 35, 352, 24);
		patientPanel.add(comboBoxPatientPerscribe);
		
		JButton btnNewPerscription = new JButton("Authorize");
		//btnNewPerscription.setEnabled(false);
		btnNewPerscription.addActionListener(new ButtonListener("newPerscription"));
		btnNewPerscription.setBounds(374, 590, 117, 25);
		perscriptionGenInfo.add(btnNewPerscription);
		
		JLabel lblPerscriptionAllFieldsRequired = new JLabel("*All Fields Required");
		lblPerscriptionAllFieldsRequired.setForeground(Color.RED);
		lblPerscriptionAllFieldsRequired.setBounds(374, 563, 147, 15);
		perscriptionGenInfo.add(lblPerscriptionAllFieldsRequired);
		
		//JButton btnClearPerscription = new JButton("Clear");
		//btnClearPerscription.setBounds(520, 590, 117, 25);
		//perscriptionGenInfo.add(btnClearPerscription);	
		
		JPanel pharmacuticalGenPanel = new JPanel();
		pharmacuticalGenPanel.setBounds(12, 327, 416, 210);
		pharmacuticalGenPanel.setBorder(BorderFactory.createTitledBorder("Pharmaceuticals"));
		perscriptionGenInfo.add(pharmacuticalGenPanel);
		pharmacuticalGenPanel.setLayout(null);
		
		JPanel perscribedDrugPanel = new JPanel();
		perscribedDrugPanel.setBounds(12, 27, 392, 104);
		perscribedDrugPanel.setBorder(BorderFactory.createTitledBorder("Drug"));
		pharmacuticalGenPanel.add(perscribedDrugPanel);
		perscribedDrugPanel.setLayout(null);
		
		perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
		comboBoxDrugPerscribe = new JComboBox<ComboItem>(perscripDrugComboBoxModel);
		comboBoxDrugPerscribe.setBounds(12, 42, 368, 24);
		perscribedDrugPanel.add(comboBoxDrugPerscribe);
		
		SpinnerNumberModel perscriptionQuantityModel = new SpinnerNumberModel(0,0,100,1);
		perscriptionQuantity = new JSpinner(perscriptionQuantityModel);
		perscriptionQuantity.setBounds(350, 143, 50, 20);		
		pharmacuticalGenPanel.add(perscriptionQuantity);
		
		JLabel lblQuantityDrugPerscription = new JLabel("Quantity");
		lblQuantityDrugPerscription.setBounds(334, 169, 70, 15);
		pharmacuticalGenPanel.add(lblQuantityDrugPerscription);
		
		JPanel doctorInfoTab = new JPanel();
		doctorsTab.addTab("Physican Info", null, doctorInfoTab, null);
		doctorInfoTab.setLayout(null);
		
		
		JPanel doctorGenGenInfoShow = new JPanel();
		doctorGenGenInfoShow.setBounds(12, 12, 649, 627);		
		doctorGenGenInfoShow.setBorder(BorderFactory.createTitledBorder("Physican Information"));
		doctorInfoTab.add(doctorGenGenInfoShow);
		doctorGenGenInfoShow.setLayout(null);		
		
		JButton btnChangeDoctor = new JButton("Authorize");
		//btnNewpatient.setEnabled(false);
		btnChangeDoctor.setBounds(374, 590, 117, 25);
		btnChangeDoctor.addActionListener(new ButtonListener("changeDoctor"));
		doctorGenGenInfoShow.add(btnChangeDoctor);
		
		JPanel currentDoctorGenInfoPanel = new JPanel();
		currentDoctorGenInfoPanel.setBounds(12, 24, 344, 80);
		currentDoctorGenInfoPanel.setBorder(BorderFactory.createTitledBorder("Current Physican"));
		doctorGenGenInfoShow.add(currentDoctorGenInfoPanel);
		currentDoctorGenInfoPanel.setLayout(null);
		
		comboBoxCurrentDoctorGen = new JComboBox<ComboItem>(allDoctorComboBoxModel);
		comboBoxCurrentDoctorGen.addActionListener(new ComboListener("doctorInfo"));
		comboBoxCurrentDoctorGen.setBounds(12, 30, 325, 24);
		currentDoctorGenInfoPanel.add(comboBoxCurrentDoctorGen);
		
		JPanel doctorNameShowPanel = new JPanel();
		doctorNameShowPanel.setBounds(22, 116, 334, 74);
		doctorNameShowPanel.setBorder(BorderFactory.createTitledBorder("Name"));
		doctorGenGenInfoShow.add(doctorNameShowPanel);
		doctorNameShowPanel.setLayout(null);
		
		docLastNameShow = new JTextField();
		docLastNameShow.setBounds(12, 27, 114, 19);
		doctorNameShowPanel.add(docLastNameShow);
		docLastNameShow.setColumns(10);
		
		docFirstNameShow = new JTextField();
		docFirstNameShow.setBounds(131, 27, 114, 19);
		doctorNameShowPanel.add(docFirstNameShow);
		docFirstNameShow.setColumns(10);
		
		JLabel lblDocLastShow = new JLabel("Last Name");
		lblDocLastShow.setBounds(12, 51, 75, 15);
		doctorNameShowPanel.add(lblDocLastShow);
		
		JLabel lblDocFirstShow = new JLabel("First Name");
		lblDocFirstShow.setBounds(131, 51, 76, 15);
		doctorNameShowPanel.add(lblDocFirstShow);
		
		JPanel doctorSocialPanelShow = new JPanel();
		doctorSocialPanelShow.setBounds(22, 202, 334, 87);		
		doctorSocialPanelShow.setBorder(BorderFactory.createTitledBorder("Social Security Number"));
		doctorGenGenInfoShow.add(doctorSocialPanelShow);
		doctorSocialPanelShow.setLayout(null);
		
		docSSNShow = new JTextField();
		docSSNShow.setBounds(12, 30, 114, 19);
		docSSNShow.setEnabled(false);
		doctorSocialPanelShow.add(docSSNShow);
		docSSNShow.setColumns(10);	
		
		JPanel experienceShowPanel = new JPanel();
		experienceShowPanel.setBounds(22, 306, 334, 152);
		experienceShowPanel.setBorder(BorderFactory.createTitledBorder("Professional Experience"));
		doctorGenGenInfoShow.add(experienceShowPanel);
		experienceShowPanel.setLayout(null);
		
		docSpecialtyShow = new JTextField();
		docSpecialtyShow.setBounds(12, 27, 234, 19);
		experienceShowPanel.add(docSpecialtyShow);
		docSpecialtyShow.setColumns(10);
		
		SpinnerNumberModel doctorExperienceShowModel = new SpinnerNumberModel(0,0,100,1);
		doctorExperienceShow = new JSpinner(doctorExperienceShowModel);
		doctorExperienceShow.setBounds(12, 100, 53, 20);
		experienceShowPanel.add(doctorExperienceShow);
		
		JLabel lblSpecialtyShow = new JLabel("Specialty");
		lblSpecialtyShow.setBounds(12, 53, 70, 15);
		experienceShowPanel.add(lblSpecialtyShow);
		
		JLabel lblYearsExperienceShow = new JLabel("Years Experience");
		lblYearsExperienceShow.setBounds(12, 125, 156, 15);
		experienceShowPanel.add(lblYearsExperienceShow);
		
		setDoctorInfoFields(allDoctorComboBoxModel.getElementAt(comboBoxCurrentDoctorGen.getSelectedIndex()).getValue());
		
		
		JTabbedPane addDoctorsTab = new JTabbedPane(JTabbedPane.TOP);
		doctorsTab.addTab("Add..", null, addDoctorsTab, null);
		
		JPanel newDoctorTab = new JPanel();
		addDoctorsTab.addTab("New Physician", null, newDoctorTab, null);
		newDoctorTab.setLayout(null);
		
		JPanel doctorGenInfo = new JPanel();
		doctorGenInfo.setBounds(12, 12, 649, 627);		
		doctorGenInfo.setBorder(BorderFactory.createTitledBorder("New Physician Information"));
		newDoctorTab.add(doctorGenInfo);
		doctorGenInfo.setLayout(null);
		
		JPanel doctorNamePanel = new JPanel();
		doctorNamePanel.setBounds(12, 29, 334, 74);
		doctorNamePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		doctorGenInfo.add(doctorNamePanel);
		doctorNamePanel.setLayout(null);
		
		docLastName = new JTextField();
		docLastName.setBounds(12, 27, 114, 19);
		doctorNamePanel.add(docLastName);
		docLastName.setColumns(10);
		
		docFirstName = new JTextField();
		docFirstName.setBounds(131, 27, 114, 19);
		doctorNamePanel.add(docFirstName);
		docFirstName.setColumns(10);
		
		JLabel lblDocLast = new JLabel("Last Name");
		lblDocLast.setBounds(12, 51, 75, 15);
		doctorNamePanel.add(lblDocLast);
		
		JLabel lblDocFirst = new JLabel("First Name");
		lblDocFirst.setBounds(131, 51, 76, 15);
		doctorNamePanel.add(lblDocFirst);
		
		JPanel doctorSocialPanel = new JPanel();
		doctorSocialPanel.setBounds(12, 115, 334, 87);
		doctorSocialPanel.setBorder(BorderFactory.createTitledBorder("Social Security Number"));
		doctorGenInfo.add(doctorSocialPanel);
		doctorSocialPanel.setLayout(null);
		
		docSSN = new JTextField();
		docSSN.setBounds(12, 30, 114, 19);
		doctorSocialPanel.add(docSSN);
		docSSN.setColumns(10);
		
		JLabel lblDoctorSocialFormat = new JLabel("XXXXXXXX");
		lblDoctorSocialFormat.setForeground(Color.GRAY);
		lblDoctorSocialFormat.setBounds(12, 60, 207, 15);
		doctorSocialPanel.add(lblDoctorSocialFormat);
		
		JPanel experiencePanel = new JPanel();
		experiencePanel.setBounds(12, 219, 334, 152);
		experiencePanel.setBorder(BorderFactory.createTitledBorder("Professional Experience"));
		doctorGenInfo.add(experiencePanel);
		experiencePanel.setLayout(null);
		
		docSpecialty = new JTextField();
		docSpecialty.setBounds(12, 27, 234, 19);
		experiencePanel.add(docSpecialty);
		docSpecialty.setColumns(10);
		
		SpinnerNumberModel doctorExperienceModel = new SpinnerNumberModel(0,0,100,1);
		doctorExperience = new JSpinner(doctorExperienceModel);
		doctorExperience.setBounds(12, 100, 53, 20);
		experiencePanel.add(doctorExperience);
		
		JLabel lblSpecialty = new JLabel("Specialty");
		lblSpecialty.setBounds(12, 53, 70, 15);
		experiencePanel.add(lblSpecialty);
		
		JLabel lblYearsExperience = new JLabel("Years Experience");
		lblYearsExperience.setBounds(12, 125, 156, 15);
		experiencePanel.add(lblYearsExperience);
		
		JButton btnNewDoctor = new JButton("Authorize");
		//btnNewDoctor.setEnabled(false);
		btnNewDoctor.addActionListener(new ButtonListener("newDoctor"));
		btnNewDoctor.setBounds(374, 590, 117, 25);
		doctorGenInfo.add(btnNewDoctor);
		
		JLabel lblDoctorAllFieldsRequired = new JLabel("*All Fields Required");
		lblDoctorAllFieldsRequired.setForeground(Color.RED);
		lblDoctorAllFieldsRequired.setBounds(374, 563, 147, 15);
		doctorGenInfo.add(lblDoctorAllFieldsRequired);
		
		//JButton btnClearDoctor = new JButton("Clear");
		//btnClearDoctor.setBounds(520, 590, 117, 25);
		//doctorGenInfo.add(btnClearDoctor);
		
		JTabbedPane pharmacuticalsTab = new JTabbedPane(JTabbedPane.TOP);
		pharmacuticalsTab.addChangeListener(new TabListener());
		mainTabbedPane.addTab("Pharmaceuticals", null, pharmacuticalsTab, null);
		
		JPanel generalDrugTab = new JPanel();
		pharmacuticalsTab.addTab("General Drug", null, generalDrugTab, null);
		generalDrugTab.setLayout(null);
		
		JPanel generalDrugPanel = new JPanel();
		generalDrugPanel.setBounds(12, 12, 1622, 654);
		generalDrugPanel.setBorder(BorderFactory.createTitledBorder("General Drug Information"));
		generalDrugTab.add(generalDrugPanel);
		generalDrugPanel.setLayout(null);
		
		JPanel mainDrugPanel = new JPanel();
		mainDrugPanel.setBounds(12, 35, 806, 607);
		mainDrugPanel.setBorder(BorderFactory.createTitledBorder("Drug Portal"));
		generalDrugPanel.add(mainDrugPanel);
		mainDrugPanel.setLayout(null);
		
		JScrollPane mainDrugScrollPanel = new JScrollPane();
		mainDrugScrollPanel.setBounds(12, 62, 782, 429);	
		mainDrugPanel.add(mainDrugScrollPanel);
		
		mainDrugTableModel = new DefaultTableModel();
		mainDrugTableModelMostExpensive = new DefaultTableModel();
		mainDrugTable = new JTable(mainDrugTableModel);
		mainDrugScrollPanel.setViewportView(mainDrugTable);
		
		mainDrugTableModel.addColumn("Trade Name");
		mainDrugTableModel.addColumn("Producer");
		mainDrugTableModel.addColumn("Formula");
		setMainDrugTable();
		
		mainDrugTableModelMostExpensive.addColumn("Trade Name");
		mainDrugTableModelMostExpensive.addColumn("Producer");
		mainDrugTableModelMostExpensive.addColumn("Formula");
		mainDrugTableModelMostExpensive.addColumn("Sold At");
		mainDrugTableModelMostExpensive.addColumn("Price");
		
		JButton btnRemoveDrug = new JButton("Remove Drug");
		btnRemoveDrug.setBounds(12, 25, 140, 25);
		btnRemoveDrug.addActionListener(new ButtonListener("removeDrug"));
		mainDrugPanel.add(btnRemoveDrug);			
		
		JPanel viewMainDrugPanel = new JPanel();
		viewMainDrugPanel.setBounds(22, 502, 322, 75);
		viewMainDrugPanel.setBorder(BorderFactory.createTitledBorder("View Drug Options"));
		mainDrugPanel.add(viewMainDrugPanel);
		viewMainDrugPanel.setLayout(null);
		
		maindrugViewGroup = new ButtonGroup();		
		JRadioButton rdbtnAllDatabaseDrugs = new JRadioButton("All");
		maindrugViewGroup.add(rdbtnAllDatabaseDrugs);
		maindrugViewGroup.setSelected(rdbtnAllDatabaseDrugs.getModel(), true);
		rdbtnAllDatabaseDrugs.setBounds(8, 23, 149, 23);
		rdbtnAllDatabaseDrugs.addActionListener(new RadioListener("mainDrug"));
		viewMainDrugPanel.add(rdbtnAllDatabaseDrugs);
		
		JRadioButton rdbtnMostExpensive = new JRadioButton("Most Expensive");
		maindrugViewGroup.add(rdbtnMostExpensive);
		rdbtnMostExpensive.setBounds(8, 44, 149, 23);
		rdbtnMostExpensive.addActionListener(new RadioListener("mainDrug"));
		viewMainDrugPanel.add(rdbtnMostExpensive);
		
		JTabbedPane pharmacyTab = new JTabbedPane(JTabbedPane.TOP);
		pharmacyTab.addChangeListener(new TabListener());
		pharmacuticalsTab.addTab("Pharmacies", null, pharmacyTab, null);
		
		JPanel generalPharmacyTab = new JPanel();
		pharmacyTab.addTab("General", null, generalPharmacyTab, null);
		generalPharmacyTab.setLayout(null);
		
		JPanel generalPharmacyPanel = new JPanel();
		generalPharmacyPanel.setBounds(12, 12, 1103, 654);
		generalPharmacyPanel.setBorder(BorderFactory.createTitledBorder("General Pharmacy Information"));
		generalPharmacyTab.add(generalPharmacyPanel);
		generalPharmacyPanel.setLayout(null);
		
		JPanel mainPharmacyPanel = new JPanel();
		mainPharmacyPanel.setBounds(12, 35, 806, 561);
		mainPharmacyPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Portal"));
		generalPharmacyPanel.add(mainPharmacyPanel);
		mainPharmacyPanel.setLayout(null);
		
		JScrollPane mainPharmacyScrollPanel = new JScrollPane();
		mainPharmacyScrollPanel.setBounds(12, 62, 782, 429);	
		mainPharmacyPanel.add(mainPharmacyScrollPanel);
		
		mainPharmacyTableModel = new DefaultTableModel();
		mainPharmacyTable = new JTable(mainPharmacyTableModel);
		mainPharmacyTable.setBorder(BorderFactory.createLoweredBevelBorder());
		mainPharmacyScrollPanel.setViewportView(mainPharmacyTable);
		
		mainPharmacyTableModel.addColumn("Pharmacy Name");
		mainPharmacyTableModel.addColumn("Pharmacy\'s Address");
		mainPharmacyTableModel.addColumn("Pharmacy\'s Phone Number");
		setMainPharmacyTable();
				
		JButton btnRemovePharmacy = new JButton("Remove Pharmacy");
		btnRemovePharmacy.setBounds(12, 25, 175, 25);
		btnRemovePharmacy.addActionListener(new ButtonListener("removePharmacy"));
		mainPharmacyPanel.add(btnRemovePharmacy);	
		
		JPanel pharmacyPerscriptionsTab = new JPanel();
		pharmacyTab.addTab("Pharmacy Perscriptions", null, pharmacyPerscriptionsTab, null);
		pharmacyPerscriptionsTab.setLayout(null);
		
		JPanel generalPharmacyPerscriptionsPanel = new JPanel();
		generalPharmacyPerscriptionsPanel.setBounds(12, 12, 888, 627);
		generalPharmacyPerscriptionsPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Perscription Information"));
		pharmacyPerscriptionsTab.add(generalPharmacyPerscriptionsPanel);
		generalPharmacyPerscriptionsPanel.setLayout(null);
		
		JPanel currentPharmacyPerscriptionsPanel = new JPanel();
		currentPharmacyPerscriptionsPanel.setBounds(12, 30, 361, 69);
		currentPharmacyPerscriptionsPanel.setBorder(BorderFactory.createTitledBorder("Current Pharmacy"));
		generalPharmacyPerscriptionsPanel.add(currentPharmacyPerscriptionsPanel);
		currentPharmacyPerscriptionsPanel.setLayout(null);
		
		//currentPharmacyPerscriptionsComboBoxModel = new DefaultComboBoxModel<ComboItem>();
		comboBoxCurrentPharmacyPerscriptions = new JComboBox<ComboItem>(allPharmacyComboBoxModel);
		comboBoxCurrentPharmacyPerscriptions.addActionListener(new ComboListener("pharmacyPerscriptions"));
		comboBoxCurrentPharmacyPerscriptions.setBounds(12, 30, 325, 24);
		currentPharmacyPerscriptionsPanel.add(comboBoxCurrentPharmacyPerscriptions);
		
		JPanel pharmacyPerscriptionsViewPanel = new JPanel();
		pharmacyPerscriptionsViewPanel.setBounds(12, 111, 864, 504);
		pharmacyPerscriptionsViewPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy's Perscriptions"));
		generalPharmacyPerscriptionsPanel.add(pharmacyPerscriptionsViewPanel);
		pharmacyPerscriptionsViewPanel.setLayout(null);
		
		JScrollPane pharmacyPerscriptionsViewScrollPane = new JScrollPane();
		pharmacyPerscriptionsViewScrollPane.setBounds(12, 27, 840, 378);
		pharmacyPerscriptionsViewPanel.add(pharmacyPerscriptionsViewScrollPane);
		
		pharmacyPerscriptionsViewTableModel = new DefaultTableModel();
		pharmacyPerscriptionsViewTable = new JTable(pharmacyPerscriptionsViewTableModel);
		pharmacyPerscriptionsViewScrollPane.setViewportView(pharmacyPerscriptionsViewTable);
		
		pharmacyPerscriptionsViewTableModel.addColumn("Perscrip. Num");
		pharmacyPerscriptionsViewTableModel.addColumn("Patient");
		pharmacyPerscriptionsViewTableModel.addColumn("Drug");
		pharmacyPerscriptionsViewTableModel.addColumn("Drug Producer");
		pharmacyPerscriptionsViewTableModel.addColumn("Quantiy");
		pharmacyPerscriptionsViewTableModel.addColumn("Status");		
		
		JPanel perscriptionViewOptionsPanel = new JPanel();
		perscriptionViewOptionsPanel.setBounds(12, 417, 376, 75);
		perscriptionViewOptionsPanel.setBorder(BorderFactory.createTitledBorder("View Perscriptions By"));
		pharmacyPerscriptionsViewPanel.add(perscriptionViewOptionsPanel);
		perscriptionViewOptionsPanel.setLayout(null);
		
		viewPerscriptionGroup = new ButtonGroup();
		
		JRadioButton rdbtnAllPerscriptions = new JRadioButton("All");
		rdbtnAllPerscriptions.setBounds(8, 23, 149, 23);
		viewPerscriptionGroup.add(rdbtnAllPerscriptions);
		viewPerscriptionGroup.setSelected(rdbtnAllPerscriptions.getModel(), true);
		rdbtnAllPerscriptions.addActionListener(new RadioListener("viewPerscriptionStatus"));;
		perscriptionViewOptionsPanel.add(rdbtnAllPerscriptions);
		
		JRadioButton rdbtnNotProcessedPerscriptions = new JRadioButton("Not Processed");
		rdbtnNotProcessedPerscriptions.setBounds(8, 44, 149, 23);
		rdbtnNotProcessedPerscriptions.addActionListener(new RadioListener("viewPerscriptionStatus"));
		viewPerscriptionGroup.add(rdbtnNotProcessedPerscriptions);
		perscriptionViewOptionsPanel.add(rdbtnNotProcessedPerscriptions);
		
		JRadioButton rdbtnNewlyCompletedPerscriptions = new JRadioButton("Newly Completed");
		rdbtnNewlyCompletedPerscriptions.setBounds(161, 23, 149, 23);
		rdbtnNewlyCompletedPerscriptions.addActionListener(new RadioListener("viewPerscriptionStatus"));
		viewPerscriptionGroup.add(rdbtnNewlyCompletedPerscriptions);
		perscriptionViewOptionsPanel.add(rdbtnNewlyCompletedPerscriptions);
		
		JRadioButton rdbtnreadytogo = new JRadioButton("\"Ready-to-Go\"");
		rdbtnreadytogo.setBounds(161, 44, 149, 23);
		rdbtnreadytogo.addActionListener(new RadioListener("viewPerscriptionStatus"));
		viewPerscriptionGroup.add(rdbtnreadytogo);
		perscriptionViewOptionsPanel.add(rdbtnreadytogo);
		
		setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
				comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
		
		JButton btnManagePerscription = new JButton("Remove Perscription");
		btnManagePerscription.setBounds(671, 467, 181, 25);
		btnManagePerscription.addActionListener(new ButtonListener("removePerscription"));
		pharmacyPerscriptionsViewPanel.add(btnManagePerscription);
		
		JPanel perscriptionManagerTab = new JPanel();
		pharmacyTab.addTab("Perscription Manager", null, perscriptionManagerTab, null);
		perscriptionManagerTab.setLayout(null);
		
		JPanel generalPerscriptionManagerPanel = new JPanel();
		generalPerscriptionManagerPanel.setBounds(12, 12, 888, 627);
		generalPerscriptionManagerPanel.setBorder(BorderFactory.createTitledBorder("Perscription Manager Information"));
		perscriptionManagerTab.add(generalPerscriptionManagerPanel);
		generalPerscriptionManagerPanel.setLayout(null);
		
		JPanel currentPerscriptionPanel = new JPanel();
		currentPerscriptionPanel.setBounds(12, 30, 361, 69);
		currentPerscriptionPanel.setBorder(BorderFactory.createTitledBorder("Current Pharmacy"));
		generalPerscriptionManagerPanel.add(currentPerscriptionPanel);
		currentPerscriptionPanel.setLayout(null);
		
		//currentPerscriptionsComboBoxModel = new DefaultComboBoxModel<ComboItem>();
		comboBoxCurrentPharmacyPerscriptionManager = new JComboBox<ComboItem>(allPharmacyComboBoxModel);
		comboBoxCurrentPharmacyPerscriptionManager.addActionListener(new ComboListener("perscriptionManger"));
		comboBoxCurrentPharmacyPerscriptionManager.setBounds(12, 30, 325, 24);
		currentPerscriptionPanel.add(comboBoxCurrentPharmacyPerscriptionManager);
		
		JPanel perscriptionsViewPanel = new JPanel();
		perscriptionsViewPanel.setBounds(12, 111, 864, 504);
		perscriptionsViewPanel.setBorder(BorderFactory.createTitledBorder("Perscriptions"));
		generalPerscriptionManagerPanel.add(perscriptionsViewPanel);
		perscriptionsViewPanel.setLayout(null);
		
		JScrollPane perscriptionsViewScrollPane = new JScrollPane();
		perscriptionsViewScrollPane.setBounds(12, 27, 840, 378);
		perscriptionsViewPanel.add(perscriptionsViewScrollPane);
		
		pharmacyPerscriptionMangerTableModel = new DefaultTableModel();
		pharmacyPerscriptionMangerTable = new JTable(pharmacyPerscriptionMangerTableModel);
		pharmacyPerscriptionMangerTable.setBorder(BorderFactory.createLoweredBevelBorder());
		perscriptionsViewScrollPane.setViewportView(pharmacyPerscriptionMangerTable);
		
		pharmacyPerscriptionMangerTableModel.addColumn("Perscription");
		pharmacyPerscriptionMangerTableModel.addColumn("Patient");
		pharmacyPerscriptionMangerTableModel.addColumn("Drug");
		pharmacyPerscriptionMangerTableModel.addColumn("Drug Producer");
		pharmacyPerscriptionMangerTableModel.addColumn("Quantity");
		pharmacyPerscriptionMangerTableModel.addColumn("Status");
		
		setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
				comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
		
		JPanel perscriptionManagerOptionsPanel = new JPanel();
		perscriptionManagerOptionsPanel.setBounds(12, 417, 421, 75);
		perscriptionManagerOptionsPanel.setBorder(BorderFactory.createTitledBorder("Assign Perscription Value"));
		perscriptionsViewPanel.add(perscriptionManagerOptionsPanel);
		perscriptionManagerOptionsPanel.setLayout(null);
		
		managePerscriptionGroup = new ButtonGroup();
		
		JRadioButton rdbtnProcessing = new JRadioButton("Processing");
		rdbtnProcessing.setBounds(8, 23, 149, 23);
		managePerscriptionGroup.add(rdbtnProcessing);
		managePerscriptionGroup.setSelected(rdbtnProcessing.getModel(), true);
		perscriptionManagerOptionsPanel.add(rdbtnProcessing);
		
		JRadioButton rdbtnProcessed = new JRadioButton("Ready-To-Go");
		rdbtnProcessed.setBounds(8, 44, 149, 23);
		managePerscriptionGroup.add(rdbtnProcessed);
		perscriptionManagerOptionsPanel.add(rdbtnProcessed);
		
		JRadioButton rdbtnCompletedPerscriptions = new JRadioButton("Picked Up");
		rdbtnCompletedPerscriptions.setBounds(161, 23, 125, 23);
		managePerscriptionGroup.add(rdbtnCompletedPerscriptions);
		perscriptionManagerOptionsPanel.add(rdbtnCompletedPerscriptions);
		
		JButton btnUpdatePerscription = new JButton("Assign Value");
		btnUpdatePerscription.addActionListener(new ButtonListener("updatePerscription"));
		btnUpdatePerscription.setBounds(284, 43, 125, 25);
		perscriptionManagerOptionsPanel.add(btnUpdatePerscription);
		
		JPanel pharmacyDrugsTab = new JPanel();
		pharmacyTab.addTab("Pharmacy Drugs", null, pharmacyDrugsTab, null);
		pharmacyDrugsTab.setLayout(null);
		
		JPanel generalPharmacyDrugsPanel = new JPanel();
		generalPharmacyDrugsPanel.setBounds(12, 12, 888, 627);
		generalPharmacyDrugsPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Drug Information"));
		pharmacyDrugsTab.add(generalPharmacyDrugsPanel);
		generalPharmacyDrugsPanel.setLayout(null);		
				
		JPanel currentPharmacyDrugsPanel = new JPanel();
		currentPharmacyDrugsPanel.setBounds(12, 30, 361, 69);
		currentPharmacyDrugsPanel.setBorder(BorderFactory.createTitledBorder("Current Pharmacy"));
		generalPharmacyDrugsPanel.add(currentPharmacyDrugsPanel);
		currentPharmacyDrugsPanel.setLayout(null);
		
		//currentPharmacyDrugsComboBoxModel = new DefaultComboBoxModel<ComboItem>();
		comboBoxCurrentPharmacyDrugs = new JComboBox<ComboItem>(allPharmacyComboBoxModel);
		comboBoxCurrentPharmacyDrugs.addActionListener(new ComboListener("pharmacyDrugs"));
		comboBoxCurrentPharmacyDrugs.setBounds(12, 30, 325, 24);
		currentPharmacyDrugsPanel.add(comboBoxCurrentPharmacyDrugs);
		
		JPanel pharmacyDrugsViewPanel = new JPanel();
		pharmacyDrugsViewPanel.setBounds(12, 111, 864, 504);
		pharmacyDrugsViewPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy's Drugs"));
		generalPharmacyDrugsPanel.add(pharmacyDrugsViewPanel);
		pharmacyDrugsViewPanel.setLayout(null);
		
		JScrollPane pharmacyDrugsViewScrollPane = new JScrollPane();
		pharmacyDrugsViewScrollPane.setBounds(12, 27, 840, 378);
		pharmacyDrugsViewPanel.add(pharmacyDrugsViewScrollPane);
		
		pharmacyDrugsViewTableModel = new DefaultTableModel();
		pharmacyDrugsViewTable = new JTable(pharmacyDrugsViewTableModel);
		pharmacyDrugsViewScrollPane.setViewportView(pharmacyDrugsViewTable);
		
		pharmacyDrugsViewTableModel.addColumn("Drug");
		pharmacyDrugsViewTableModel.addColumn("Drug Producer");
		pharmacyDrugsViewTableModel.addColumn("Price");
		
		
		setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
						comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
		
		pharmacyDrugsViewCompetitorsTableModel = new DefaultTableModel();
		pharmacyDrugsViewCompetitorsTableModel.addColumn("Drug");
		pharmacyDrugsViewCompetitorsTableModel.addColumn("Drug Producer");
		pharmacyDrugsViewCompetitorsTableModel.addColumn("Rival Pharmacy");
		pharmacyDrugsViewCompetitorsTableModel.addColumn("Price");
		pharmacyDrugsViewCompetitorsTableModel.addColumn("Phone Number");
		
		JPanel drugViewOptionsPanel = new JPanel();
		drugViewOptionsPanel.setBounds(12, 417, 462, 75);
		drugViewOptionsPanel.setBorder(BorderFactory.createTitledBorder("View Drugs"));
		pharmacyDrugsViewPanel.add(drugViewOptionsPanel);
		drugViewOptionsPanel.setLayout(null);	
		
		drugViewGroup = new ButtonGroup();		
		JRadioButton rdbtnAllDrugs = new JRadioButton("All");
		drugViewGroup.add(rdbtnAllDrugs);
		drugViewGroup.setSelected(rdbtnAllDrugs.getModel(), true);
		rdbtnAllDrugs.setBounds(8, 23, 149, 23);
		rdbtnAllDrugs.addActionListener(new RadioListener("viewDrugs"));
		drugViewOptionsPanel.add(rdbtnAllDrugs);
		
		JRadioButton rdbtnNotPriced = new JRadioButton("Not Priced");
		drugViewGroup.add(rdbtnNotPriced);
		rdbtnNotPriced.setBounds(8, 44, 149, 23);
		rdbtnNotPriced.addActionListener(new RadioListener("viewDrugs"));
		drugViewOptionsPanel.add(rdbtnNotPriced);
		
		JRadioButton rdbtnCompetitors = new JRadioButton("Competitior\'s Similar Drugs");
		drugViewGroup.add(rdbtnCompetitors);
		rdbtnCompetitors.setBounds(161, 23, 228, 23);
		rdbtnCompetitors.addActionListener(new RadioListener("viewDrugs"));
		drugViewOptionsPanel.add(rdbtnCompetitors);
		
		JPanel pharmacyPriceDrugPanel = new JPanel();
		pharmacyPriceDrugPanel.setBounds(486, 417, 366, 75);
		pharmacyPriceDrugPanel.setBorder(BorderFactory.createTitledBorder("Drug Pricing"));
		pharmacyDrugsViewPanel.add(pharmacyPriceDrugPanel);
		pharmacyPriceDrugPanel.setLayout(null);
		
		SpinnerNumberModel drugPriceModel = new SpinnerNumberModel(0,0,100,1);
		drugPrice = new JSpinner(drugPriceModel);
		drugPrice.setBounds(172, 29, 53, 20);
		pharmacyPriceDrugPanel.add(drugPrice);
		
		btnPriceDrug = new JButton("Price Drug");
		btnPriceDrug.setBounds(237, 29, 117, 25);
		btnPriceDrug.addActionListener(new ButtonListener("priceDrug"));
		pharmacyPriceDrugPanel.add(btnPriceDrug);
		
		//notPricedDrug = new JTextField();
		//notPricedDrug.setEnabled(false);
		//notPricedDrug.setEditable(false);
		//notPricedDrug.setBounds(22, 29, 163, 19);
		//pharmacyPriceDrugPanel.add(notPricedDrug);
		//notPricedDrug.setColumns(10);
		
		//JLabel lblDrug = new JLabel("Drug");
		//lblDrug.setBounds(22, 48, 70, 15);
		//pharmacyPriceDrugPanel.add(lblDrug);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(197, 48, 70, 15);
		pharmacyPriceDrugPanel.add(lblPrice);
		
		JTabbedPane pharmacyGenInfoTab = new JTabbedPane(JTabbedPane.TOP);
		pharmacyTab.addTab("Pharmacy Info", null, pharmacyGenInfoTab, null);
		
		JPanel changePharmacyTab = new JPanel();
		pharmacyGenInfoTab.addTab("New Pharmacy", null, changePharmacyTab, null);
		changePharmacyTab.setLayout(null);
		
		JPanel pharmacyGenChangeInfo = new JPanel();
		pharmacyGenChangeInfo.setBounds(12, 12, 640, 612);			
		pharmacyGenChangeInfo.setBorder(BorderFactory.createTitledBorder("Pharmacy Information"));
		changePharmacyTab.add(pharmacyGenChangeInfo);
		pharmacyGenChangeInfo.setLayout(null);
		
		JPanel pharmNameChangePanel = new JPanel();
		pharmNameChangePanel.setBounds(12, 29, 334, 74);
		pharmNameChangePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		pharmacyGenChangeInfo.add(pharmNameChangePanel);
		pharmNameChangePanel.setLayout(null);		
		
		comboBoxPharmInfo = new JComboBox<ComboItem>(allPharmacyComboBoxModel);
		comboBoxPharmInfo.setBounds(12, 35, 310, 24);
		comboBoxPharmInfo.addActionListener(new ComboListener("pharmacyInfo"));
		pharmNameChangePanel.add(comboBoxPharmInfo);
		
		JPanel pharmAddressChangePanel = new JPanel();
		pharmAddressChangePanel.setBounds(12, 115, 334, 74);
		pharmAddressChangePanel.setBorder(BorderFactory.createTitledBorder("Business Address"));
		pharmacyGenChangeInfo.add(pharmAddressChangePanel);
		pharmAddressChangePanel.setLayout(null);
		
		pharmAddressChange = new JTextField();
		pharmAddressChange.setBounds(12, 31, 310, 19);
		pharmAddressChangePanel.add(pharmAddressChange);
		pharmAddressChange.setColumns(10);
		
		JPanel pharmPhoneChangePanel = new JPanel();
		pharmPhoneChangePanel.setBounds(12, 216, 334, 74);
		pharmPhoneChangePanel.setBorder(BorderFactory.createTitledBorder("Business Phone"));
		pharmacyGenChangeInfo.add(pharmPhoneChangePanel);
		pharmPhoneChangePanel.setLayout(null);
		
		pharmPhoneChange = new JTextField();
		pharmPhoneChange.setBounds(12, 26, 150, 19);
		pharmPhoneChangePanel.add(pharmPhoneChange);
		pharmPhoneChange.setColumns(10);
		
		JButton btnChangePharmacy = new JButton("Authorize");
		//btnNewPharmacy.setEnabled(false);
		btnChangePharmacy.addActionListener(new ButtonListener("changePharmacy"));
		btnChangePharmacy.setBounds(365, 575, 117, 25);
		pharmacyGenChangeInfo.add(btnChangePharmacy);
		
		setPharmacyInfoFields(allPharmacyComboBoxModel.getElementAt(comboBoxPharmInfo.getSelectedIndex()).getValue());
		
		JTabbedPane addPharmacyTab = new JTabbedPane(JTabbedPane.TOP);
		pharmacyTab.addTab("Add..", null, addPharmacyTab, null);
		
		JPanel newPharmacyTab = new JPanel();
		addPharmacyTab.addTab("New Pharmacy", null, newPharmacyTab, null);
		newPharmacyTab.setLayout(null);
		
		JPanel pharmacyGenInfo = new JPanel();
		pharmacyGenInfo.setBounds(12, 12, 640, 612);			
		pharmacyGenInfo.setBorder(BorderFactory.createTitledBorder("New Pharmacy Information"));
		newPharmacyTab.add(pharmacyGenInfo);
		pharmacyGenInfo.setLayout(null);
		
		JPanel pharmNamePanel = new JPanel();
		pharmNamePanel.setBounds(12, 29, 334, 74);
		pharmNamePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		pharmacyGenInfo.add(pharmNamePanel);
		pharmNamePanel.setLayout(null);
		
		pharmName = new JTextField();
		pharmName.setBounds(12, 31, 310, 19);
		pharmNamePanel.add(pharmName);
		pharmName.setColumns(10);
		
		JPanel pharmAddressPanel = new JPanel();
		pharmAddressPanel.setBounds(12, 115, 334, 74);
		pharmAddressPanel.setBorder(BorderFactory.createTitledBorder("Business Address"));
		pharmacyGenInfo.add(pharmAddressPanel);
		pharmAddressPanel.setLayout(null);
		
		pharmAddress = new JTextField();
		pharmAddress.setBounds(12, 31, 310, 19);
		pharmAddressPanel.add(pharmAddress);
		pharmAddress.setColumns(10);
		
		JPanel pharmPhonePanel = new JPanel();
		pharmPhonePanel.setBounds(12, 216, 334, 74);
		pharmPhonePanel.setBorder(BorderFactory.createTitledBorder("Business Phone"));
		pharmacyGenInfo.add(pharmPhonePanel);
		pharmPhonePanel.setLayout(null);
		
		pharmPhone = new JTextField();
		pharmPhone.setBounds(12, 26, 150, 19);
		pharmPhonePanel.add(pharmPhone);
		pharmPhone.setColumns(10);
		
		JButton btnNewPharmacy = new JButton("Authorize");
		//btnNewPharmacy.setEnabled(false);
		btnNewPharmacy.addActionListener(new ButtonListener("newPharmacy"));
		btnNewPharmacy.setBounds(365, 575, 117, 25);
		pharmacyGenInfo.add(btnNewPharmacy);
		
		JLabel lblPharmacyAllFieldsRequired = new JLabel("*All Fields Required");
		lblPharmacyAllFieldsRequired.setForeground(Color.RED);
		lblPharmacyAllFieldsRequired.setBounds(365, 548, 147, 15);
		pharmacyGenInfo.add(lblPharmacyAllFieldsRequired);
		
		//JButton btnClearPharmacy = new JButton("Clear");
		//btnClearPharmacy.setBounds(511, 575, 117, 25);
		//pharmacyGenInfo.add(btnClearPharmacy);	
		
		JTabbedPane pharmacyCompanyTab = new JTabbedPane(JTabbedPane.TOP);
		pharmacyCompanyTab.addChangeListener(new TabListener());
		pharmacuticalsTab.addTab("Pharmacy Companies", null, pharmacyCompanyTab, null);
		
		JPanel generalPharmacyCompanyTab = new JPanel();
		pharmacyCompanyTab.addTab("General", null, generalPharmacyCompanyTab, null);
		generalPharmacyCompanyTab.setLayout(null);
		
		JPanel generalPharmacyCompanyPanel = new JPanel();
		generalPharmacyCompanyPanel.setBounds(12, 12, 1103, 654);
		generalPharmacyCompanyPanel.setBorder(BorderFactory.createTitledBorder("General Pharmacy Company Information"));
		generalPharmacyCompanyTab.add(generalPharmacyCompanyPanel);
		generalPharmacyCompanyPanel.setLayout(null);
		
		JPanel mainPharmacyCompanyPanel = new JPanel();
		mainPharmacyCompanyPanel.setBounds(12, 35, 806, 561);
		mainPharmacyCompanyPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Company Portal"));
		generalPharmacyCompanyPanel.add(mainPharmacyCompanyPanel);
		mainPharmacyCompanyPanel.setLayout(null);
		
		JScrollPane mainPharmacyCompanyScrollPanel = new JScrollPane();
		mainPharmacyCompanyScrollPanel.setBounds(12, 62, 782, 429);	
		mainPharmacyCompanyPanel.add(mainPharmacyCompanyScrollPanel);
		
		mainPharmacyCompanyTableModel = new DefaultTableModel();
		mainPharmacyCompanyTable = new JTable(mainPharmacyCompanyTableModel);
		mainPharmacyCompanyTable.setBorder(BorderFactory.createLoweredBevelBorder());
		mainPharmacyCompanyScrollPanel.setViewportView(mainPharmacyCompanyTable);
		
		mainPharmacyCompanyTableModel.addColumn("Pharmacy Company");
		mainPharmacyCompanyTableModel.addColumn("Pharmacy Company\'s Phone number");
		setMainPharmacyCompanyTable();
		
		JButton btnRemovePharmacyCompany = new JButton("Remove Pharmacy Company");
		btnRemovePharmacyCompany.setBounds(12, 25, 255, 25);
		btnRemovePharmacyCompany.addActionListener(new ButtonListener("removePharmacyCompany"));
		mainPharmacyCompanyPanel.add(btnRemovePharmacyCompany);		
		

		/**
		 * 
		 */
		
		
		JTabbedPane changePharmCompTab = new JTabbedPane(JTabbedPane.TOP);
		changePharmCompTab.addChangeListener(new TabListener());
		pharmacyCompanyTab.addTab("Pharmacy Company Info", null, changePharmCompTab, null);
		
		JPanel changeDrugTab = new JPanel();
		changePharmCompTab.addTab("Drug Info", null, changeDrugTab, null);
		changeDrugTab.setLayout(null);
		
		JPanel drugGenInfoChange = new JPanel();
		drugGenInfoChange.setBounds(12, 12, 640, 612);			
		drugGenInfoChange.setBorder(BorderFactory.createTitledBorder("Drug Information"));
		changeDrugTab.add(drugGenInfoChange);
		drugGenInfoChange.setLayout(null);
		
		JPanel drugNameChangePanel = new JPanel();
		drugNameChangePanel.setBounds(12, 29, 334, 74);
		drugNameChangePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		drugGenInfoChange.add(drugNameChangePanel);
		drugNameChangePanel.setLayout(null);
		
		//drugNameShow = new JTextField();
		//drugNameShow.setBounds(12, 27, 310, 19);
		//drugNameChangePanel.add(drugNameShow);
		//drugNameShow.setColumns(10);
		
		JButton btnChangeDrug = new JButton("Authorize");
		//btnNewDrug.setEnabled(false);
		btnChangeDrug.addActionListener(new ButtonListener("changeDrug"));
		btnChangeDrug.setBounds(365, 575, 117, 25);
		drugGenInfoChange.add(btnChangeDrug);

		JPanel drugFormulaChangePanel = new JPanel();
		drugFormulaChangePanel.setBounds(12, 115, 334, 74);
		drugFormulaChangePanel.setBorder(BorderFactory.createTitledBorder("Drug Formula"));
		drugGenInfoChange.add(drugFormulaChangePanel);
		drugFormulaChangePanel.setLayout(null);
		
		drugFormulaChange = new JTextField();
		drugFormulaChange.setBounds(12, 29, 310, 19);
		drugFormulaChangePanel.add(drugFormulaChange);
		drugFormulaChange.setColumns(10);
		
		JPanel drugPharmacyCompanyShowPanel = new JPanel();
		drugPharmacyCompanyShowPanel.setBounds(12, 201, 334, 74);
		drugPharmacyCompanyShowPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Company Producer"));
		drugGenInfoChange.add(drugPharmacyCompanyShowPanel);
		drugPharmacyCompanyShowPanel.setLayout(null);
		
		comboBoxPharmacyCompanyChangeDrug = new JComboBox<ComboItem>(allPharmacyCompanyComboBoxModel);
		comboBoxPharmacyCompanyChangeDrug.setBounds(12, 28, 296, 24);
		comboBoxPharmacyCompanyChangeDrug.addActionListener(new ComboListener("drugCompInfo"));
		drugPharmacyCompanyShowPanel.add(comboBoxPharmacyCompanyChangeDrug);
		
		comboBoxDrugChange = new JComboBox<ComboItem>(getDrugDropDown(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompanyChangeDrug.getSelectedIndex()).getValue()));
		comboBoxDrugChange.setBounds(12, 28, 296, 24);
		comboBoxDrugChange.addActionListener(new ComboListener("drugInfo"));
		drugNameChangePanel.add(comboBoxDrugChange);
		
		setDrugInfoFields(comboBoxDrugChange.getModel().getElementAt(comboBoxDrugChange.getSelectedIndex()).getValue());
		
		JPanel updatePharmCompTab = new JPanel();
		changePharmCompTab.addTab("Pharmacy Company Info", null, updatePharmCompTab, null);
		updatePharmCompTab.setLayout(null);
		
		JPanel pharmacyCompanyGenInfoChange = new JPanel();
		pharmacyCompanyGenInfoChange.setBounds(12, 12, 640, 612);			
		pharmacyCompanyGenInfoChange.setBorder(BorderFactory.createTitledBorder("Pharmacy Company Information"));
		updatePharmCompTab.add(pharmacyCompanyGenInfoChange);
		pharmacyCompanyGenInfoChange.setLayout(null);
		
		JPanel pharmCompNameChangePanel = new JPanel();
		pharmCompNameChangePanel.setBounds(12, 29, 334, 74);
		pharmCompNameChangePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		pharmacyCompanyGenInfoChange.add(pharmCompNameChangePanel);
		pharmCompNameChangePanel.setLayout(null);
		
		comboBoxPharmacyCompanyChange = new JComboBox<ComboItem>(allPharmacyCompanyComboBoxModel);
		comboBoxPharmacyCompanyChange.setBounds(12, 28, 296, 24);
		comboBoxPharmacyCompanyChange.addActionListener(new ComboListener("pharmacyCompanyInfo"));
		pharmCompNameChangePanel.add(comboBoxPharmacyCompanyChange);
		
		//pharmCompNameShow = new JTextField();
		//pharmCompNameShow.setBounds(12, 31, 310, 19);
		//pharmCompNameChangePanel.add(pharmCompNameShow);
		//pharmCompNameShow.setColumns(10);
		
		JPanel pharmCompPhoneShowPanel = new JPanel();
		pharmCompPhoneShowPanel.setBounds(12, 132, 334, 74);
		pharmCompPhoneShowPanel.setBorder(BorderFactory.createTitledBorder("Phone Number"));
		pharmacyCompanyGenInfoChange.add(pharmCompPhoneShowPanel);
		pharmCompPhoneShowPanel.setLayout(null);
		
		pharmCompPhoneShow = new JTextField();
		pharmCompPhoneShow.setBounds(12, 30, 170, 19);
		pharmCompPhoneShowPanel.add(pharmCompPhoneShow);
		pharmCompPhoneShow.setColumns(10);
		
    	setPharmacyCompanyInfoFields(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompanyChange.getSelectedIndex()).getValue());
		
		JButton btnChangePharmComp = new JButton("Authorize");
		//btnNewPharmComp.setEnabled(false);
		btnChangePharmComp.setBounds(365, 575, 117, 25);
		btnChangePharmComp.addActionListener(new ButtonListener("changePharmacyCompany"));
		pharmacyCompanyGenInfoChange.add(btnChangePharmComp);		

		
		/**
		 * 
		 */

		
		JTabbedPane addPharmCompTab = new JTabbedPane(JTabbedPane.TOP);
		addPharmCompTab.addChangeListener(new TabListener());
		pharmacyCompanyTab.addTab("Add..", null, addPharmCompTab, null);
		
		JPanel newDrugTab = new JPanel();
		addPharmCompTab.addTab("New Drug", null, newDrugTab, null);
		newDrugTab.setLayout(null);
		
		JPanel drugGenInfo = new JPanel();
		drugGenInfo.setBounds(12, 12, 640, 612);			
		drugGenInfo.setBorder(BorderFactory.createTitledBorder("New Drug Information"));
		newDrugTab.add(drugGenInfo);
		drugGenInfo.setLayout(null);
		
		JPanel drugNamePanel = new JPanel();
		drugNamePanel.setBounds(12, 29, 334, 74);
		drugNamePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		drugGenInfo.add(drugNamePanel);
		drugNamePanel.setLayout(null);
		
		drugName = new JTextField();
		drugName.setBounds(12, 27, 310, 19);
		drugNamePanel.add(drugName);
		drugName.setColumns(10);
		
		JButton btnNewDrug = new JButton("Authorize");
		//btnNewDrug.setEnabled(false);
		btnNewDrug.addActionListener(new ButtonListener("newDrug"));
		btnNewDrug.setBounds(365, 575, 117, 25);
		drugGenInfo.add(btnNewDrug);
		
		JLabel lblAllFieldsRequiredDrug = new JLabel("*All Fields Required");
		lblAllFieldsRequiredDrug.setForeground(Color.RED);
		lblAllFieldsRequiredDrug.setBounds(365, 548, 147, 15);
		drugGenInfo.add(lblAllFieldsRequiredDrug);
		
		//JButton btnClearDrug = new JButton("Clear");
		//btnClearDrug.setBounds(511, 575, 117, 25);
		//drugGenInfo.add(btnClearDrug);
		
		JPanel drugFormulaPanel = new JPanel();
		drugFormulaPanel.setBounds(12, 115, 334, 74);
		drugFormulaPanel.setBorder(BorderFactory.createTitledBorder("Drug Formula"));
		drugGenInfo.add(drugFormulaPanel);
		drugFormulaPanel.setLayout(null);
		
		drugFormula = new JTextField();
		drugFormula.setBounds(12, 29, 310, 19);
		drugFormulaPanel.add(drugFormula);
		drugFormula.setColumns(10);
		
		JPanel drugPharmacyCompanyPanel = new JPanel();
		drugPharmacyCompanyPanel.setBounds(12, 201, 334, 74);
		drugPharmacyCompanyPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Company Producer"));
		drugGenInfo.add(drugPharmacyCompanyPanel);
		drugPharmacyCompanyPanel.setLayout(null);
		
		comboBoxPharmacyCompany = new JComboBox<ComboItem>(allPharmacyCompanyComboBoxModel);
		comboBoxPharmacyCompany.setBounds(12, 28, 296, 24);
		drugPharmacyCompanyPanel.add(comboBoxPharmacyCompany);
		
		JPanel newPharmCompTab = new JPanel();
		addPharmCompTab.addTab("New Pharmacy Company", null, newPharmCompTab, null);
		newPharmCompTab.setLayout(null);
		
		JPanel pharmacyCompanyGenInfo = new JPanel();
		pharmacyCompanyGenInfo.setBounds(12, 12, 640, 612);			
		pharmacyCompanyGenInfo.setBorder(BorderFactory.createTitledBorder("New Pharmacy Company Information"));
		newPharmCompTab.add(pharmacyCompanyGenInfo);
		pharmacyCompanyGenInfo.setLayout(null);
		
		JPanel pharmCompNamePanel = new JPanel();
		pharmCompNamePanel.setBounds(12, 29, 334, 74);
		pharmCompNamePanel.setBorder(BorderFactory.createTitledBorder("Name"));
		pharmacyCompanyGenInfo.add(pharmCompNamePanel);
		pharmCompNamePanel.setLayout(null);
		
		pharmCompName = new JTextField();
		pharmCompName.setBounds(12, 31, 310, 19);
		pharmCompNamePanel.add(pharmCompName);
		pharmCompName.setColumns(10);
		
		JPanel pharmCompPhonePanel = new JPanel();
		pharmCompPhonePanel.setBounds(12, 132, 334, 74);
		pharmCompPhonePanel.setBorder(BorderFactory.createTitledBorder("Phone Number"));
		pharmacyCompanyGenInfo.add(pharmCompPhonePanel);
		pharmCompPhonePanel.setLayout(null);
		
		pharmCompPhone = new JTextField();
		pharmCompPhone.setBounds(12, 30, 170, 19);
		pharmCompPhonePanel.add(pharmCompPhone);
		pharmCompPhone.setColumns(10);
		
		JButton btnNewPharmComp = new JButton("Authorize");
		//btnNewPharmComp.setEnabled(false);
		btnNewPharmComp.setBounds(365, 575, 117, 25);
		btnNewPharmComp.addActionListener(new ButtonListener("newPharmacyCompany"));
		pharmacyCompanyGenInfo.add(btnNewPharmComp);
		
		JLabel lblAllFieldsRequiredPharmComp = new JLabel("*All Fields Required");
		lblAllFieldsRequiredPharmComp.setForeground(Color.RED);
		lblAllFieldsRequiredPharmComp.setBounds(365, 548, 147, 15);
		pharmacyCompanyGenInfo.add(lblAllFieldsRequiredPharmComp);
		
		//JButton btnClearPharmComp = new JButton("Clear");
		//btnClearPharmComp.setBounds(511, 575, 117, 25);
		//pharmacyCompanyGenInfo.add(btnClearPharmComp);
		
		JTabbedPane contractsTab = new JTabbedPane(JTabbedPane.TOP);
		contractsTab.addChangeListener(new TabListener());
		mainTabbedPane.addTab("Contracts", null, contractsTab, null);
		
		JPanel generalContractsTab = new JPanel();
		contractsTab.addTab("General", null, generalContractsTab, null);
		generalContractsTab.setLayout(null);
		
		JPanel generalContractsPanel = new JPanel();
		generalContractsPanel.setBounds(12, 12, 1108, 654);
		generalContractsPanel.setBorder(BorderFactory.createTitledBorder("General Contract Information"));
		generalContractsTab.add(generalContractsPanel);
		generalContractsPanel.setLayout(null);
		
		JPanel mainContractPanel = new JPanel();
		mainContractPanel.setBounds(12, 35, 806, 561);
		mainContractPanel.setBorder(BorderFactory.createTitledBorder("Contract Portal"));
		generalContractsPanel.add(mainContractPanel);
		mainContractPanel.setLayout(null);			
		
		JScrollPane mainContractScrollPanel = new JScrollPane();
		mainContractScrollPanel.setBounds(12, 62, 782, 429);
		mainContractPanel.add(mainContractScrollPanel);
		
		mainContractTableModel = new DefaultTableModel();
		mainContractTable = new JTable(mainContractTableModel);			
		mainContractTable.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		mainContractScrollPanel.setViewportView(mainContractTable);
		
		mainContractTableModel.addColumn("Pharmacy");
		mainContractTableModel.addColumn("Pharmacy Company");
		mainContractTableModel.addColumn("Start Date");
		mainContractTableModel.addColumn("End Date");
		mainContractTableModel.addColumn("Supervisor");		
		setMainContractTable();
		
		JButton btnRemoveContract = new JButton("Remove Contract");
		btnRemoveContract.setBounds(12, 25, 155, 25);
		btnRemoveContract.addActionListener(new ButtonListener("removeContract"));
		mainContractPanel.add(btnRemoveContract);
		
		//JButton btnViewContractDetails = new JButton("View Details");
		//btnViewContractDetails.setBounds(640, 503, 154, 25);
		//mainContractPanel.add(btnViewContractDetails);
		
		JPanel contractDetailsTab = new JPanel();
		//contractDetailsTab.setEnabled(false);
		contractsTab.addTab("Contract Details", null, contractDetailsTab, null);
		contractDetailsTab.setLayout(null);
		
		JPanel contractGenInfoChange = new JPanel();
		contractGenInfoChange.setBounds(12, 12, 1092, 627);		
		contractGenInfoChange.setBorder(BorderFactory.createTitledBorder("Contract Information"));
		contractDetailsTab.add(contractGenInfoChange);
		contractGenInfoChange.setLayout(null);		
		
		JButton btnSaveContractChanges = new JButton("Save Changes");
		btnSaveContractChanges.addActionListener(new ButtonListener("changeContract"));
		//btnSaveContractChanges.setEnabled(false);
		btnSaveContractChanges.setBounds(817, 577, 145, 25);
		contractGenInfoChange.add(btnSaveContractChanges);
		
		//JLabel lblAllFieldsRequiredContractChange = new JLabel("*All Fields Required");
		//lblAllFieldsRequiredContractChange.setForeground(Color.RED);
		//lblAllFieldsRequiredContractChange.setBounds(817, 550, 147, 15);
		//contractGenInfoChange.add(lblAllFieldsRequiredContractChange);
		
		//JButton btnClearContractChange = new JButton("Clear");
		//btnClearContractChange.setBounds(963, 577, 117, 25);
		//contractGenInfoChange.add(btnClearContractChange);		
		
		JPanel contractingPartiesChangePanel = new JPanel();
		contractingPartiesChangePanel.setBounds(12, 22, 416, 293);
		contractingPartiesChangePanel.setBorder(BorderFactory.createTitledBorder("Contracting Parties"));
		contractGenInfoChange.add(contractingPartiesChangePanel);
		contractingPartiesChangePanel.setLayout(null);
		
		JPanel pharmacyChangePanel = new JPanel();
		pharmacyChangePanel.setBounds(12, 45, 376, 94);
		pharmacyChangePanel.setBorder(BorderFactory.createTitledBorder("Pharmacy"));
		contractingPartiesChangePanel.add(pharmacyChangePanel);
		pharmacyChangePanel.setLayout(null);
		
		comboBoxPharmContractChange = new JComboBox<ComboItem>(allPharmacyComboBoxModel);
		comboBoxPharmContractChange.setBounds(12, 35, 352, 24);
		comboBoxPharmContractChange.addActionListener(new ComboListener("contractInfoPharmacy"));
		pharmacyChangePanel.add(comboBoxPharmContractChange);
		
		JPanel pharmCompChangePanel = new JPanel();
		pharmCompChangePanel.setBounds(12, 151, 376, 94);
		pharmCompChangePanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Company"));
		contractingPartiesChangePanel.add(pharmCompChangePanel);
		pharmCompChangePanel.setLayout(null);
		
		pharmCompContractChangeComboBoxModel = new DefaultComboBoxModel<ComboItem>(getContractedPharmaciesDropDown(
				allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()));
		comboBoxPharmCompContractChange = new JComboBox<ComboItem>(pharmCompContractChangeComboBoxModel);
		comboBoxPharmCompContractChange.addActionListener(new ComboListener("contractInfoPharmacyCompany"));
		comboBoxPharmCompContractChange.setBounds(12, 35, 352, 24);
		pharmCompChangePanel.add(comboBoxPharmCompContractChange);
		
		JPanel supervisorChangePanel = new JPanel();
		supervisorChangePanel.setBounds(12, 327, 416, 129);
		supervisorChangePanel.setBorder(BorderFactory.createTitledBorder("Contract Supervisor"));
		contractGenInfoChange.add(supervisorChangePanel);
		supervisorChangePanel.setLayout(null);
		
		supervisorChangeLastName = new JTextField();
		supervisorChangeLastName.setBounds(12, 54, 184, 19);
		supervisorChangePanel.add(supervisorChangeLastName);
		supervisorChangeLastName.setColumns(10);
		
		supervisorChangeFirstName = new JTextField();
		supervisorChangeFirstName.setBounds(208, 54, 186, 19);
		supervisorChangePanel.add(supervisorChangeFirstName);
		supervisorChangeFirstName.setColumns(10);
		
		JLabel lblLastNameChange = new JLabel("Last Name");
		lblLastNameChange.setBounds(12, 74, 124, 15);
		supervisorChangePanel.add(lblLastNameChange);
		
		JLabel lblFirstNameSupervisorChange = new JLabel("First Name");
		lblFirstNameSupervisorChange.setBounds(208, 74, 135, 15);
		supervisorChangePanel.add(lblFirstNameSupervisorChange);
		
		JPanel contractTextChangePanel = new JPanel();
		contractTextChangePanel.setBounds(440, 22, 640, 434);
		contractTextChangePanel.setBorder(BorderFactory.createTitledBorder("Contracting Terms"));
		contractGenInfoChange.add(contractTextChangePanel);
		contractTextChangePanel.setLayout(null);
		
		contractTermsChange = new JTextArea();
		contractTermsChange.setBounds(12, 35, 616, 379);
		contractTermsChange.setEditable(false);
		contractTermsChange.setBorder(BorderFactory.createLoweredBevelBorder());
		contractTextChangePanel.add(contractTermsChange);
		
		JPanel contractLengthChangePanel = new JPanel();
		contractLengthChangePanel.setBounds(12, 468, 416, 129);
		contractLengthChangePanel.setBorder(BorderFactory.createTitledBorder("Contracting Period"));
		contractGenInfoChange.add(contractLengthChangePanel);
		contractLengthChangePanel.setLayout(null);
		
		contractStartDateChange = new JTextField();
		contractStartDateChange.setBounds(12, 47, 184, 20);
		contractStartDateChange.setEnabled(false);
		contractLengthChangePanel.add(contractStartDateChange);
		
		contractEndDateChange = new JTextField();
		contractEndDateChange.setBounds(208, 47, 184, 20);
		contractEndDateChange.setEnabled(false);
		contractLengthChangePanel.add(contractEndDateChange);
		
		JLabel lblStartDateChange = new JLabel("Start Date");
		lblStartDateChange.setBounds(22, 79, 124, 15);
		contractLengthChangePanel.add(lblStartDateChange);
		
		JLabel lblEndDateChange = new JLabel("End Date");
		lblEndDateChange.setBounds(218, 79, 135, 15);
		contractLengthChangePanel.add(lblEndDateChange);
		
		setContractInfoFields(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue(),
    			comboBoxPharmCompContractChange.getModel().getElementAt(comboBoxPharmCompContractChange.getSelectedIndex()).getValue());
		
		JTabbedPane addContractsTab = new JTabbedPane(JTabbedPane.TOP);
		addContractsTab.addChangeListener(new TabListener());
		contractsTab.addTab("Add..", null, addContractsTab, null);
		
		JPanel newContractTab = new JPanel();
		addContractsTab.addTab("New Contract", null, newContractTab, null);
		newContractTab.setLayout(null);
		
		JPanel contractGenInfo = new JPanel();
		contractGenInfo.setBounds(12, 12, 1092, 627);		
		contractGenInfo.setBorder(BorderFactory.createTitledBorder("New Contract Information"));
		newContractTab.add(contractGenInfo);
		contractGenInfo.setLayout(null);			
		
		JButton btnNewContract = new JButton("Authorize");
		//btnNewContract.setEnabled(false);
		btnNewContract.setBounds(817, 577, 117, 25);
		btnNewContract.addActionListener(new ButtonListener("newContract"));
		contractGenInfo.add(btnNewContract);
		
		JLabel lblAllFieldsRequiredContract = new JLabel("*All Fields Required");
		lblAllFieldsRequiredContract.setForeground(Color.RED);
		lblAllFieldsRequiredContract.setBounds(817, 550, 147, 15);
		contractGenInfo.add(lblAllFieldsRequiredContract);
		
		//JButton btnClearContract = new JButton("Clear");
		//btnClearContract.setBounds(963, 577, 117, 25);
		//contractGenInfo.add(btnClearContract);		
		
		JPanel contractingPartiesPanel = new JPanel();
		contractingPartiesPanel.setBounds(12, 22, 416, 293);
		contractingPartiesPanel.setBorder(BorderFactory.createTitledBorder("Contracting Parties"));
		contractGenInfo.add(contractingPartiesPanel);
		contractingPartiesPanel.setLayout(null);
		
		JPanel pharmacyPanel = new JPanel();
		pharmacyPanel.setBounds(12, 45, 376, 94);
		pharmacyPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy"));
		contractingPartiesPanel.add(pharmacyPanel);
		pharmacyPanel.setLayout(null);
		
		comboBoxPharmContract = new JComboBox<ComboItem>(allPharmacyComboBoxModel);
		comboBoxPharmContract.setBounds(12, 35, 352, 24);
		comboBoxPharmContract.addActionListener(new ComboListener("changePharmacyContract"));
		pharmacyPanel.add(comboBoxPharmContract);
		
		JPanel pharmCompPanel = new JPanel();
		pharmCompPanel.setBounds(12, 151, 376, 94);
		pharmCompPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy Company"));
		contractingPartiesPanel.add(pharmCompPanel);
		pharmCompPanel.setLayout(null);
		
		comboBoxPharmCompContract = new JComboBox<ComboItem>(getContractPharmacyCompanyDropDown(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue()));
		comboBoxPharmCompContract.setBounds(12, 35, 352, 24);
		pharmCompPanel.add(comboBoxPharmCompContract);
		
		JPanel supervisorPanel = new JPanel();
		supervisorPanel.setBounds(12, 327, 416, 129);
		supervisorPanel.setBorder(BorderFactory.createTitledBorder("Contract Supervisor"));
		contractGenInfo.add(supervisorPanel);
		supervisorPanel.setLayout(null);
		
		supervisorLastName = new JTextField();
		supervisorLastName.setBounds(12, 54, 184, 19);
		supervisorPanel.add(supervisorLastName);
		supervisorLastName.setColumns(10);
		
		supervisorFirstName = new JTextField();
		supervisorFirstName.setBounds(208, 54, 186, 19);
		supervisorPanel.add(supervisorFirstName);
		supervisorFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(12, 74, 124, 15);
		supervisorPanel.add(lblLastName);
		
		JLabel lblFirstNameSupervisor = new JLabel("First Name");
		lblFirstNameSupervisor.setBounds(208, 74, 135, 15);
		supervisorPanel.add(lblFirstNameSupervisor);
		
		JPanel contractTextPanel = new JPanel();
		contractTextPanel.setBounds(440, 22, 640, 434);
		contractTextPanel.setBorder(BorderFactory.createTitledBorder("Contracting Terms"));
		contractGenInfo.add(contractTextPanel);
		contractTextPanel.setLayout(null);
		
		contractTerms = new JTextArea();
		contractTerms.setBounds(12, 35, 616, 379);
		contractTerms.setBorder(BorderFactory.createLoweredBevelBorder());
		contractTextPanel.add(contractTerms);
		
		JPanel contractLengthPanel = new JPanel();
		contractLengthPanel.setBounds(12, 468, 416, 129);
		contractLengthPanel.setBorder(BorderFactory.createTitledBorder("Contracting Period"));
		contractGenInfo.add(contractLengthPanel);
		contractLengthPanel.setLayout(null);
		
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		cal.add(Calendar.YEAR, -50);
		Date startDate = cal.getTime();
		cal.add(Calendar.YEAR, 100);
		Date endDate = cal.getTime();
		
		SpinnerDateModel contractStartDateModel = new SpinnerDateModel(now,startDate,endDate,Calendar.YEAR);
		contractStartDate = new JSpinner(contractStartDateModel);
		contractStartDate.setBounds(12, 47, 184, 20);
		//contractStartDate.setEditor(new JSpinner.DateEditor(contractStartDate, "mm/dd/yyy"));
		contractLengthPanel.add(contractStartDate);
		
		SpinnerDateModel contractEndDateModel = new SpinnerDateModel(now,startDate,endDate,Calendar.YEAR);
		contractEndDate = new JSpinner(contractEndDateModel);
		contractEndDate.setBounds(208, 47, 184, 20);
		//contractEndDate.setEditor(new JSpinner.DateEditor(contractEndDate, "mm/dd/yyy"));
		contractLengthPanel.add(contractEndDate);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(22, 79, 124, 15);
		contractLengthPanel.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(218, 79, 135, 15);
		contractLengthPanel.add(lblEndDate);
	}
	
	/******************************************************
	 * Data Control Functions
	 * @return
	 ******************************************************
	 */	
	private void setMainPatientTable(){
		if (mainPatientTableModel.getRowCount() > 0) {
		    for (int i = mainPatientTableModel.getRowCount() - 1; i > -1; i--) {
		    	mainPatientTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getAllPatients();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainPatientTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],data[i][4]});
			}		
		}
	}
	private void setMainDoctorTable(){
		if (mainDoctorTableModel.getRowCount() > 0) {
		    for (int i = mainDoctorTableModel.getRowCount() - 1; i > -1; i--) {
		    	mainDoctorTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getAllDoctors();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainDoctorTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3]});
			}		
		}
	}
	private void setMainDrugTable(){
		if (mainDrugTableModel.getRowCount() > 0) {
		    for (int i = mainDrugTableModel.getRowCount() - 1; i > -1; i--) {
		    	mainDrugTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getAllDrugs();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainDrugTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2]});
			}		
		}
		mainDrugTable.setModel(mainDrugTableModel);
	}
	private void setMostExpensiveDrugTable(){
		if (mainDrugTableModelMostExpensive.getRowCount() > 0) {
		    for (int i = mainDrugTableModelMostExpensive.getRowCount() - 1; i > -1; i--) {
		    	mainDrugTableModelMostExpensive.removeRow(i);
		    }
		}
		String[][] data = dataManager.getMostExpensiveDrugs();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainDrugTableModelMostExpensive.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],data[i][4]});
			}		
		}
		mainDrugTable.setModel(mainDrugTableModelMostExpensive);
	}
	private void setMainPharmacyTable(){
		if (mainPharmacyTableModel.getRowCount() > 0) {
		    for (int i = mainPharmacyTableModel.getRowCount() - 1; i > -1; i--) {
		    	mainPharmacyTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getAllPharmacies();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainPharmacyTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2]});
			}		
		}
	}
	private void setMainPharmacyCompanyTable(){
		if (mainPharmacyCompanyTableModel.getRowCount() > 0) {
		    for (int i = mainPharmacyCompanyTableModel.getRowCount() - 1; i > -1; i--) {
		    	mainPharmacyCompanyTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getAllPharmacyCompanies();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainPharmacyCompanyTableModel.addRow(new Object[]{data[i][0],data[i][1]});
			}		
		}
	}
	private void setMainContractTable(){
		if (mainContractTableModel.getRowCount() > 0) {
		    for (int i = mainContractTableModel.getRowCount() - 1; i > -1; i--) {
		    	mainContractTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getAllContracts();
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				mainContractTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],data[i][4]});
			}		
		}
	}
	private void setPatientPerscriptionListTableModel(String patientSSN){
		if (patientPerscriptionListTableModel.getRowCount() > 0) {
		    for (int i = patientPerscriptionListTableModel.getRowCount() - 1; i > -1; i--) {
		    	patientPerscriptionListTableModel.removeRow(i);
		    }
		}
		String[][] data = dataManager.getPatientPerscriptions(patientSSN);
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				patientPerscriptionListTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],getPerscriptionStatus(data[i][4]),data[i][5]});
			}		
		}
	}
	private void setPatientPerscriptionPharmacyListTableModel(String drugName){
		if (patientPerscriptionPharmacyListTableModel.getRowCount() > 0) {
		    for (int i = patientPerscriptionPharmacyListTableModel.getRowCount() - 1; i > -1; i--) {
		    	patientPerscriptionPharmacyListTableModel.removeRow(i);
		    }
		}
		if(drugName.equals(""))
			return;
		String[][] data = dataManager.getDrugPharmacyOptions(drugName);
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				patientPerscriptionPharmacyListTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3]});
			}		
		}
	}	
	private void setPharmacyPerscriptionMangerTableModel(String pharmName){
		if (pharmacyPerscriptionMangerTableModel.getRowCount() > 0) {
		    for (int i = pharmacyPerscriptionMangerTableModel.getRowCount() - 1; i > -1; i--) {
		    	pharmacyPerscriptionMangerTableModel.removeRow(i);
		    }
		}
		if(pharmName.equals(""))
			return;
		String[][] data = dataManager.getPharmacyPerscriptionsViewTable(pharmName);
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				pharmacyPerscriptionMangerTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],data[i][4],getPerscriptionStatus(data[i][5])});
			}		
		}
	}
	private void setPharmacyDrugsViewTable(String pharmName){
		if (pharmacyDrugsViewTableModel.getRowCount() > 0) {
		    for (int i = pharmacyDrugsViewTableModel.getRowCount() - 1; i > -1; i--) {
		    	pharmacyDrugsViewTableModel.removeRow(i);
		    }
		}
		if(pharmName.equals(""))
			return;
		String[][] data = dataManager.getPharmacyDrugsViewTable(pharmName);
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				pharmacyDrugsViewTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2]});
			}
			pharmacyDrugsViewTable.setModel(pharmacyDrugsViewTableModel);		
		}
	}
	private void setPharmacyDrugsViewNotPricedTable(String pharmName){
		if (pharmacyDrugsViewTableModel.getRowCount() > 0) {
		    for (int i = pharmacyDrugsViewTableModel.getRowCount() - 1; i > -1; i--) {
		    	pharmacyDrugsViewTableModel.removeRow(i);
		    }
		}
		if(pharmName.equals(""))
			return;
		String[][] data = dataManager.getPharmacyDrugsViewNotPricedTable(pharmName);
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				pharmacyDrugsViewTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2]});
			}
			pharmacyDrugsViewTable.setModel(pharmacyDrugsViewTableModel);		
		}
	}
	
	
	private void setPharmacyDrugsViewCompetitiorsTable(String pharmName){
		if (pharmacyDrugsViewCompetitorsTableModel.getRowCount() > 0) {
		    for (int i = pharmacyDrugsViewCompetitorsTableModel.getRowCount() - 1; i > -1; i--) {
		    	pharmacyDrugsViewCompetitorsTableModel.removeRow(i);
		    }
		}
		if(pharmName.equals(""))
			return;
		String[][] data = dataManager.getPharmacyDrugsViewCompetitorsTable(pharmName);
		if(data.length != 0){			
			for(int i = 0; i < data.length; i++){
				pharmacyDrugsViewCompetitorsTableModel.addRow(new Object[]{data[i][0],data[i][2],data[i][3],data[i][3],data[i][4]});
			}		
			pharmacyDrugsViewTable.setModel(pharmacyDrugsViewCompetitorsTableModel);
		}
	}
	
	private void setPharmacyPerscriptionsViewTable(String pharmName){
		if (pharmacyPerscriptionsViewTableModel.getRowCount() > 0) {
		    for (int i = pharmacyPerscriptionsViewTableModel.getRowCount() - 1; i > -1; i--) {
		    	pharmacyPerscriptionsViewTableModel.removeRow(i);
		    }
		}
		if(pharmName.equals(""))
			return;
		String[][] data = null;
		switch(getSelectedButtonText(viewPerscriptionGroup)){
		case "All":
			data = dataManager.getPharmacyPerscriptionsViewTable(pharmName);
			break;
		case "Newly Completed":
			data = dataManager.getPharmacyPerscriptionsViewReadyTodayTable(pharmName);
			break;
		case "\"Ready-to-Go\"":
			data = dataManager.getPharmacyPerscriptionsViewReadyTable(pharmName);
			break;
		case "Not Processed":
			data = dataManager.getPharmacyPerscriptionsViewNotProcTable(pharmName);
			break;
		default:
			break;				
	
		}
		 
		if(data.length != 0){
			for(int i = 0; i < data.length; i++){
				pharmacyPerscriptionsViewTableModel.addRow(new Object[]{data[i][0],data[i][1],data[i][2],data[i][3],data[i][4],getPerscriptionStatus(data[i][5])});
			}		
			pharmacyPerscriptionsViewTable.setModel(pharmacyPerscriptionsViewTableModel);
		}
	}
	
	private void setPatientInfoFields(String patientSSN){
		String[] data = dataManager.getSinglePatientInfo(patientSSN);
		patientFirstNameShow.setText(null);
		patientLastNameShow.setText(null);
		patientSSNShow.setText(null);
		patientAgeShow.setText(null);
		patientAddressShow.setText(null);
		
		/**
		 * Find out something to do fancy with doctor, also add it to the update query
		 */
		if(data.length != 0){
			patientFirstNameShow.setText(data[0]);
			patientLastNameShow.setText(data[1]);
			patientSSNShow.setText(patientSSN);
			patientAgeShow.setText(data[3]);
			patientAddressShow.setText(data[2]);
			for(int i = 0; i < comboBoxChangePatientPrimaryPhysician.getModel().getSize(); i++){
				String temp = comboBoxChangePatientPrimaryPhysician.getModel().getElementAt(i).getValue();
				if(temp.equals(data[4])){
					comboBoxChangePatientPrimaryPhysician.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	private void setDoctorInfoFields(String doctorSSN){
		String[] data = dataManager.getSingleDoctorInfo(doctorSSN);
		docFirstNameShow.setText(null);
		docLastNameShow.setText(null);
		docSSNShow.setText(null);
		docSpecialtyShow.setText(null);
		doctorExperienceShow.setValue(0);
		if(data.length != 0){
			docFirstNameShow.setText(data[0]);
			docLastNameShow.setText(data[1]);
			docSSNShow.setText(doctorSSN);
			docSpecialtyShow.setText(data[2]);			
			doctorExperienceShow.setValue(Integer.parseInt(data[3]));
			
		}
	}	
	private void setPharmacyInfoFields(String pharmName){
		String[] data = dataManager.getSinglePharmacyInfo(pharmName);
		pharmAddressChange.setText(null);
		pharmPhoneChange.setText(null);	
		if(data.length != 0){
			pharmAddressChange.setText(data[0]);
			pharmPhoneChange.setText(data[1]);			
		}
	}	
	private void setPharmacyCompanyInfoFields(String pharmCompName){
		String[] data = dataManager.getSinglePharmacyCompanyInfo(pharmCompName);		
		pharmCompPhoneShow.setText(null);	
		if(data.length != 0){			
			pharmCompPhoneShow.setText(data[0]);			
		}
	}
	private void setDrugInfoFields(String drugName){
		String[] data = dataManager.getSingleDrugInfo(drugName);		
		drugFormulaChange.setText(null);	
		if(data.length != 0){			
			drugFormulaChange.setText(data[0]);			
		}
	}
	private void setContractInfoFields(String pharmName, String pharmCompName){
		String[] data = dataManager.getSingleContractInfo(pharmName,pharmCompName);		
		drugFormulaChange.setText(null);	
		if(data.length > 2){			
			contractTermsChange.setText(data[0]);
			supervisorChangeFirstName.setText(data[1].substring(0, data[1].indexOf(' ')));
			supervisorChangeLastName.setText(data[1].substring(data[1].indexOf(' ')));
			contractStartDateChange.setText(data[2]);
			contractEndDateChange.setText(data[3]);
		}
	}
	private Vector<ComboItem> getAllDoctors(){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getAllDoctorList();
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i][1], data[i][0]));			
		}
		return items;
		
	}
	private Vector<ComboItem> getAllPatients(){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getAllPatientList();
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i][1], data[i][0]));			
		}
		return items;
		
	}
	private Vector<ComboItem> getAllPharmacies(){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getAllPharmacyList();
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i][0], data[i][0]));			
		}
		return items;
		
	}
	private Vector<ComboItem> getAllPharmacyCompanies(){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getAllPharmacyCompanyList();
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i][0], data[i][0]));			
		}
		return items;
		
	}	
	/*private Vector<ComboItem> getContractedPharmacyCompanies(String pharmacyName){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getContractedPharmacyCompanies(pharmacyName);
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i][1], data[i][0]));			
		}
		return items;
		
	}*/
	private Vector<ComboItem> getPerscriptPatient(String doctorSSN){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getPatientList(doctorSSN);
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i][1],data[i][0]));
		}
		return items;
		
	}
	private Vector<ComboItem> getDinstinctDrug(){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[] data = dataManager.getUniqueDrug();
		for(int i = 0; i < data.length; i++){
			items.add(new ComboItem(data[i]));
		}
		return items;
	}
	private Vector<ComboItem> getPatientPerscriptionDropDown(String patientSSN){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[][] data = dataManager.getPatientPerscriptionDropDowList(patientSSN);
		if(data.length == 0){			
			items.add(new ComboItem("","No Unassigned Perscriptions!"));
			return items;
		}		
		for(int i = 0; i < data.length; i++){			
			items.add(new ComboItem(data[i][1],data[i][0]));
		}
		return items;
	}
	private Vector<ComboItem> getContractPharmacyCompanyDropDown(String pharmName){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[] data = dataManager.getContractingPharmacyCompanyDropDownList(pharmName);
		if(data.length == 0){			
			items.add(new ComboItem("","No Companies Already Contracted With!"));
			return items;
		}		
		for(int i = 0; i < data.length; i++){			
			items.add(new ComboItem(data[i]));
		}
		return items;
	}
	private Vector<ComboItem> getDrugDropDown(String pharmCompName){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[] data = dataManager.getDrugDropDownList(pharmCompName);
		if(data.length == 0){			
			items.add(new ComboItem("","No Drugs!"));
			return items;
		}		
		for(int i = 0; i < data.length; i++){			
			items.add(new ComboItem(data[i]));
		}
		return items;
	}
	private Vector<ComboItem> getContractedPharmaciesDropDown(String pharmName){
		Vector<ComboItem> items = new Vector<ComboItem>();
		String[] data = dataManager.getContractedPharmaciesDropDown(pharmName);
		if(data.length == 0){			
			items.add(new ComboItem("","No Companies Contracted With!"));
			return items;
		}		
		for(int i = 0; i < data.length; i++){			
			items.add(new ComboItem(data[i]));
		}
		return items;
	}
	
	private String createNewPatient(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Patients(patient_ssn,Personal_First_Name,Personal_Last_Name,Address,Age,Primary_Doctor_ssn) VALUES (");
		query.append(patientSSN.getText());
		query.append(", \'");
		query.append(patientFirstName.getText() + "\', \'");
		query.append(patientLastName.getText() + "\', \'");
		query.append(patientAddress.getText() + "\', ");
		query.append(patientBirthday.getText() + ", ");
		query.append(allDoctorComboBoxModel.getElementAt(comboBoxPrimaryPhysician.getSelectedIndex()).getValue());
		query.append(")");		
		return query.toString();
	}
	private String createNewDoctor(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Doctors(ssn,Personal_First_Name,Personal_Last_Name,Specialty,Experience) VALUES (");
		query.append(docSSN.getText());
		query.append(", \'");
		query.append(docFirstName.getText() + "\', \'");
		query.append(docLastName.getText() + "\', \'");
		query.append(docSpecialty.getText() + "\', ");
		query.append(doctorExperience.getValue());		
		query.append(")");		
		return query.toString();
	}
	private String createNewPharmacyCompany(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Pharmacy_Company(pharmacy_company_name,Phone_Number) VALUES (\'");
		query.append(pharmCompName.getText());
		query.append("\', ");
		query.append(pharmCompPhone.getText());		
		query.append(")");		
		return query.toString();
	}
	private String createNewPharmacy(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Pharmacy(pharmacy_name,Address,Phone_Number) VALUES (\'");
		query.append(pharmName.getText());
		query.append("\', \'");
		query.append(pharmAddress.getText() + "\', ");
		query.append(pharmPhone.getText());		
		query.append(")");		
		return query.toString();
	}
	private String createNewDrug(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Make_Drug(Drug_Name,Pharm_Comp,formula) VALUES (\'");
		query.append(drugName.getText());
		query.append("\', \'");
		query.append(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompany.getSelectedIndex()).getValue() + "\', \'");
		query.append(drugFormula.getText() + "\'");		
		query.append(")");		
		return query.toString();
	}
	private String createNewPerscription(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Perscriptions(Perscription_Seq_Id, Patient_SSN, Pharm_Drug, Pharmacy, Pharmacy_company, Doctor_SSN, Perscribed_Date,Quantity,Status,drop_off_time, completed_time,process_time) VALUES (Perscription_Seq_Id.NEXTVAL,");
		query.append(perscripPatientComboBoxModel.getElementAt(comboBoxPatientPerscribe.getSelectedIndex()).getValue());
		query.append(", \'");
		query.append(perscripDrugComboBoxModel.getElementAt(comboBoxDrugPerscribe.getSelectedIndex()).getValue());
		query.append("\', NULL, NULL, ");
		query.append(allDoctorComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue());
		query.append(", sysdate, ");
		query.append(perscriptionQuantity.getValue());
		query.append(", -1, NULL, ");			
		query.append("NULL,null)");		
		return query.toString();
	}
	
	private String createNewContract(){
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO Contracts(Pharm_Name,Pharm_Comp,Text,Supervisor,Start_Date,End_Date) VALUES ('");
		query.append(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue());
		query.append("\', \'");		
		query.append(comboBoxPharmCompContract.getModel().getElementAt(comboBoxPharmCompContract.getSelectedIndex()).getValue());
		query.append("\', \'");		
		query.append(contractTerms.getText());
		query.append("\', \'");		
		query.append(supervisorFirstName.getText());
		query.append(" ");
		query.append(supervisorLastName.getText());
		query.append("\', to_date(\'");
		query.append(DATE_FORMAT.format(contractStartDate.getValue()));
		query.append("\',\'dd-MM-yyyy\'), to_date(\'");	
		query.append(DATE_FORMAT.format(contractEndDate.getValue()));
		query.append("\',\'dd-MM-yyyy\'))");		
		return query.toString();
	}
	
	private String createContractNewDrugs(){
		/**
		 * insert into pharm_sells (pharmacy_drug_name, pharmacy, pharm_comp) select md.drug_name, 'City Pharmacy' pharm, md.pharm_comp from make_drug md where md.pharm_comp = 'Big Pharmacy Company 1';
		 */
		StringBuilder query = new StringBuilder();
		query.append("insert into pharm_sells (pharmacy_drug_name, pharmacy, pharm_comp) select md.drug_name, \'");		
		query.append(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue());
		query.append("\' pharm, md.pharm_comp from make_drug md where md.pharm_comp = \'");		
		query.append(comboBoxPharmCompContract.getModel().getElementAt(comboBoxPharmCompContract.getSelectedIndex()).getValue());
		query.append("\'");
		
		return query.toString();
	}
	
    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (@SuppressWarnings("rawtypes")
		Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    private int getStatus(String radioText){
    	switch(radioText){
    	case "Processing":
    		return 1;
    	case "Ready-To-Go":
    		return 2;
    	case "Picked Up":
    		return 3;
    	default:
    	    return 0;
    	}
    }
    private String getPerscriptionStatus(String status){
    	if(status == null)
    		return "Unassigned";
    	switch(status){
    	case "0":
    		return "Waiting Processing";
    	case "1":
    		return "Processing";
    	case "2":
    		return "Ready-To-Go";
    	case "3":
    		return "Picked Up";
    	default:
    	    return "Unassigned";
    	}
    }
	/****************************************************************/
	
	/**
	 * Closses
	 * @author pidgeonsquish
	 *
	 */
	private final class ComboListener implements ActionListener {
		private String name;
		public ComboListener(String name){
			this.name = name;
		}
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {
		    if (name.equals("unassignedPerscriptionsPatient")){
			    perscriptionManagerCurrentPerscriptionComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPatientPerscriptionDropDown(
						allPatientComboBoxModel.getElementAt(comboBoxPerscriptionManagerCurrentPatient.getSelectedIndex()).getValue()));
			    comboBoxPerscriptionManagerCurrentPerscription.setModel(perscriptionManagerCurrentPerscriptionComboBoxModel);
				setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
						comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());
		    }
		    else if(name.equals("unassignedPerscriptionsPerscription")){
		    	setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
						comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());
		    }
		    else if(name.equals("perscribingDoctor")){
		    	perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(
						getPerscriptPatient(allDoctorComboBoxModel.getElementAt(((JComboBox) e.getSource()).getSelectedIndex()).getValue()));
		    	comboBoxPatientPerscribe.setModel(perscripPatientComboBoxModel);
		    }
		    else if (name.equals("pharmacyDrugs")){
		    	setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
						comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("perscriptionManger")){
		    	setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
						comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("pharmacyPerscriptions")){
		    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
						comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("patientPerscriptions")){
				setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("patientInfo")){
		    	setPatientInfoFields(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatientGen.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("doctorInfo")){
		    	setDoctorInfoFields(allDoctorComboBoxModel.getElementAt(comboBoxCurrentDoctorGen.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("pharmacyInfo")){
		    	setPharmacyInfoFields(allPharmacyComboBoxModel.getElementAt(comboBoxPharmInfo.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("changePharmacyContract")){
		    	DefaultComboBoxModel<ComboItem> tempModel = new DefaultComboBoxModel<ComboItem>(getContractPharmacyCompanyDropDown(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue()));
		    	comboBoxPharmCompContract.setModel(tempModel);
		    }
		    else if (name.equals("pharmacyCompanyInfo")){
		    	setPharmacyCompanyInfoFields(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompanyChange.getSelectedIndex()).getValue());
		    }
		    else if (name.equals("drugCompInfo")){
		    	DefaultComboBoxModel<ComboItem> temp = new DefaultComboBoxModel<ComboItem>(getDrugDropDown(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompanyChangeDrug.getSelectedIndex()).getValue()));
		    	comboBoxDrugChange.setModel(temp);
		    }
		    else if (name.equals("drugInfo")){		    	
		    	setDrugInfoFields(comboBoxDrugChange.getModel().getElementAt(comboBoxDrugChange.getSelectedIndex()).getValue());		    	
		    }
		    else if (name.equals("contractInfoPharmacy")){
		    	setContractInfoFields(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue(),
		    			comboBoxPharmCompContractChange.getModel().getElementAt(comboBoxPharmCompContractChange.getSelectedIndex()).getValue());
		    	pharmCompContractChangeComboBoxModel = new DefaultComboBoxModel<ComboItem>(getContractedPharmaciesDropDown(
						allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()));
				comboBoxPharmCompContractChange.setModel(pharmCompContractChangeComboBoxModel);
		    }
		    else if (name.equals("contractInfoPharmacyCompany")){
		    	setContractInfoFields(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue(),
		    			comboBoxPharmCompContractChange.getModel().getElementAt(comboBoxPharmCompContractChange.getSelectedIndex()).getValue());
		    }
		}
	}
	private final class RadioListener implements ActionListener {
		private String name;
		public RadioListener(String name){
			this.name = name;
		}
		public void actionPerformed(ActionEvent e) {
			if(name.equals("mainDrug")){
				switch(getSelectedButtonText(maindrugViewGroup)){
					case "All":
						setMainDrugTable();
						break;
					case "Most Expensive":
						setMostExpensiveDrugTable();
						break;
					default:
						break;
				}
			}
			if(name.equals("viewDrugs")){
				switch(getSelectedButtonText(drugViewGroup)){
					case "Competitior\'s Similar Drugs":
						if(btnPriceDrug.isEnabled()){
							btnPriceDrug.setEnabled(false);
						}
						setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "All":
						if(!btnPriceDrug.isEnabled()){
							btnPriceDrug.setEnabled(true);
						}
						setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "Not Priced":	
						if(!btnPriceDrug.isEnabled()){
							btnPriceDrug.setEnabled(true);
						}
						setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					default:
						break;						
					
				}				
			}
			if (name.equals("viewPerscriptionStatus")){
				setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
						comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
			}
		}
	}
	private final class ButtonListener implements ActionListener {
		private String name;
		public ButtonListener(String name){
			this.name = name;
		}
		public void actionPerformed(ActionEvent e) {			
			if(name.equals("newPatient")){
				dataManager.runQuery(createNewPatient());
				setMainPatientTable();
				allPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPatients());
				perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPerscriptPatient(
						allPatientComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
				comboBoxCurrentPatientGen.setModel(allPatientComboBoxModel);
				comboBoxCurrentPatient.setModel(allPatientComboBoxModel);
				comboBoxPerscriptionManagerCurrentPatient.setModel(allPatientComboBoxModel);
				setPatientInfoFields(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatientGen.getSelectedIndex()).getValue());
			}
			else if(name.equals("newDoctor")){
				dataManager.runQuery(createNewDoctor());
				setMainDoctorTable();
				allDoctorComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllDoctors());
				comboBoxPrimaryPhysician.setModel(allDoctorComboBoxModel);
				comboBoxDoctorPerscribe.setModel(allDoctorComboBoxModel);
				comboBoxCurrentDoctorGen.setModel(allDoctorComboBoxModel);
				perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(
						getPerscriptPatient(allDoctorComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));

			}
			else if(name.equals("newPharmacyCompany")){
				dataManager.runQuery(createNewPharmacyCompany());
				setMainPharmacyCompanyTable();
				allPharmacyCompanyComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPharmacyCompanies());
				comboBoxPharmacyCompanyChange.setModel(allPharmacyCompanyComboBoxModel);
				comboBoxPharmacyCompany.setModel(allPharmacyCompanyComboBoxModel);

			}
			else if(name.equals("newPharmacy")){
				dataManager.runQuery(createNewPharmacy());
				setMainPharmacyTable();
				allPharmacyComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPharmacies());
				comboBoxCurrentPharmacyPerscriptions.setModel(allPharmacyComboBoxModel);
				comboBoxCurrentPharmacyPerscriptionManager.setModel(allPharmacyComboBoxModel);
				comboBoxCurrentPharmacyDrugs.setModel(allPharmacyComboBoxModel);
				comboBoxPharmInfo.setModel(allPharmacyComboBoxModel);
				comboBoxPharmContractChange.setModel(allPharmacyComboBoxModel);
				comboBoxPharmContract.setModel(allPharmacyComboBoxModel);

			}
			else if(name.equals("newDrug")){
				/**
				 * Need to update pharmacies contracted with pharmcomp.
				 * So update sells with no priced drugs.
				 */
				dataManager.runQuery(createNewDrug());
				setMainDrugTable();
				StringBuilder query = new StringBuilder();
				query.append("insert into pharm_sells (pharmacy_drug_name,pharmacy,pharm_comp,price) select \'");
				query.append(drugName.getText());
				query.append("\' new_drug, pharm_name, pharm_comp, null price from contracts where pharm_comp = \'");
				query.append(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompany.getSelectedIndex()).getValue());
				query.append("\'");
				dataManager.runQuery(query.toString());
				perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
				comboBoxDrugPerscribe.setModel(perscripDrugComboBoxModel);
				setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
						comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
				
				
			}
			else if(name.equals("newContract")){
				/**
				 * Test these please
				 */				
				dataManager.runQuery(createNewContract());
				dataManager.runQuery(createContractNewDrugs());
				setMainContractTable();
		    	DefaultComboBoxModel<ComboItem> tempModel = new DefaultComboBoxModel<ComboItem>(getContractPharmacyCompanyDropDown(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue()));
		    	comboBoxPharmCompContract.setModel(tempModel);
		    	pharmCompContractChangeComboBoxModel = new DefaultComboBoxModel<ComboItem>(getContractedPharmaciesDropDown(
						allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()));
				comboBoxPharmCompContractChange.setModel(pharmCompContractChangeComboBoxModel);
				switch(getSelectedButtonText(drugViewGroup)){
				case "Competitior\'s Similar Drugs":
					setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					break;
				case "All":
					setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					break;
				case "Not Priced":
					setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					break;
				default:
					break;				
			
				}	
			}
			else if(name.equals("newPerscription")){
				dataManager.runQuery(createNewPerscription());
				perscriptionManagerCurrentPerscriptionComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPatientPerscriptionDropDown(
						allPatientComboBoxModel.getElementAt(comboBoxPerscriptionManagerCurrentPatient.getSelectedIndex()).getValue()));
			    comboBoxPerscriptionManagerCurrentPerscription.setModel(perscriptionManagerCurrentPerscriptionComboBoxModel);
				setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
						comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());

			}
			else if(name.equals("assignPharmacy")){
				StringBuilder query = new StringBuilder();
				query.append("update perscriptions set status = 0, pharmacy = \'");
				query.append(patientPerscriptionPharmacyListTableModel.getValueAt(
						patientPerscriptionPharmacyListTable.getSelectedRow(), 0));
				query.append("\', pharmacy_company = \'");
				query.append(patientPerscriptionPharmacyListTableModel.getValueAt(
						patientPerscriptionPharmacyListTable.getSelectedRow(), 1));
				query.append("\' where perscription_seq_id = ");
				query.append(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
						comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getLabel());
				dataManager.runQuery(query.toString());
				
				/**
				 * Run Data Refresh rules please
				 * combobox and pharmacytables
				 */
				perscriptionManagerCurrentPerscriptionComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPatientPerscriptionDropDown(
						allPatientComboBoxModel.getElementAt(comboBoxPerscriptionManagerCurrentPatient.getSelectedIndex()).getValue()));
				comboBoxPerscriptionManagerCurrentPerscription.setModel(perscriptionManagerCurrentPerscriptionComboBoxModel);
				//setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
				//		comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());
				setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
						comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());
				
			}
			else if(name.equals("updatePerscription")){
				if(pharmacyPerscriptionMangerTable.getSelectedRow() > -1){
					StringBuilder query = new StringBuilder();
					query.append("update perscriptions set status = ");
					int status = getStatus(getSelectedButtonText(managePerscriptionGroup));
					query.append(status);
					switch (status){
						case 1:
							query.append(", process_time = sysdate, completed_time = null, drop_off_time = null");
							break;
						case 2:
							query.append(", completed_time = sysdate, drop_off_time = null ");
							break;
						case 3:
							query.append(", drop_off_time = sysdate ");
							break;
						default:
							break;
					}
					query.append(" where perscription_seq_id = ");
					query.append(pharmacyPerscriptionMangerTableModel.getValueAt(pharmacyPerscriptionMangerTable.getSelectedRow(), 0));					
					dataManager.runQuery(query.toString());
			    	setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());

				}
			}
			else if(name.equals("priceDrug")){
				if(pharmacyDrugsViewTable.getSelectedRow() > -1){
					StringBuilder query = new StringBuilder();
					query.append("update pharm_sells set price = ");
					query.append(drugPrice.getValue());
					query.append(" where pharmacy_drug_name = \'");
					query.append(pharmacyDrugsViewTableModel.getValueAt(pharmacyDrugsViewTable.getSelectedRow(), 0));
					query.append("\' and pharmacy = \'");
					query.append(allPharmacyComboBoxModel.getElementAt(comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					query.append("\' and pharm_comp = \'");
					query.append(pharmacyDrugsViewTableModel.getValueAt(pharmacyDrugsViewTable.getSelectedRow(), 1));
					query.append("\'");
					dataManager.runQuery(query.toString());
					switch(getSelectedButtonText(drugViewGroup)){
						case "Competitior\'s Similar Drugs":
							setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
									comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
							break;
						case "All":
							setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
									comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
							break;
						case "Not Priced":
							setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
									comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
							break;
						default:
							break;				
					
					}	
				}
			}
			else if (name.equals("changePatient")){
				StringBuilder query = new StringBuilder();
				query.append("update patients set personal_first_name = \'");				
				query.append(patientFirstNameShow.getText() + "\',");
				query.append(" personal_last_name = \'");
				query.append(patientLastNameShow.getText() + "\'");
				query.append(", address = \'");
				query.append(patientAddressShow.getText() + "\', ");
				query.append(" age = ");
				query.append(patientAgeShow.getText() + " ");
				/**
				 * Don't forget about doctor :)
				 */
				query.append(", primary_doctor_ssn = \'");
				query.append(comboBoxChangePatientPrimaryPhysician.getModel().getElementAt(comboBoxChangePatientPrimaryPhysician.getSelectedIndex()).getValue()).append("\' ");
				query.append(" where patient_ssn = ");
				query.append(patientSSNShow.getText());		
				dataManager.runQuery(query.toString());
				allPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPatients());
				setMainPatientTable();
				perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPerscriptPatient(
						allPatientComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
				comboBoxCurrentPatientGen.setModel(allPatientComboBoxModel);
				comboBoxCurrentPatient.setModel(allPatientComboBoxModel);
				comboBoxPerscriptionManagerCurrentPatient.setModel(allPatientComboBoxModel);
				setPatientInfoFields(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatientGen.getSelectedIndex()).getValue());
				
				
			}
			else if (name.equals("changeDoctor")){
				StringBuilder query = new StringBuilder();
				query.append("update doctors set personal_first_name =\'");
				query.append(docFirstNameShow.getText());
				query.append("\',personal_last_name = \'");
				query.append(docLastNameShow.getText());
				query.append("\', specialty = \'");
				query.append(docSpecialtyShow.getText());
				query.append("\', experience = ");
				query.append(doctorExperienceShow.getValue());
				query.append(" where ssn = ");
				query.append(allDoctorComboBoxModel.getElementAt(comboBoxCurrentDoctorGen.getSelectedIndex()).getValue());
				dataManager.runQuery(query.toString());
				setMainDoctorTable();
				allDoctorComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllDoctors());
				comboBoxPrimaryPhysician.setModel(allDoctorComboBoxModel);
				comboBoxDoctorPerscribe.setModel(allDoctorComboBoxModel);
				comboBoxCurrentDoctorGen.setModel(allDoctorComboBoxModel);
				perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(
						getPerscriptPatient(allDoctorComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
				
			}
			else if (name.equals("changePharmacy")){
				StringBuilder query = new StringBuilder();
				query.append("update pharmacy set address =\'");
				query.append(pharmAddressChange.getText());
				query.append("\', phone_number = \'");
				query.append(pharmPhoneChange.getText());
				query.append("\' where pharmacy_name = \'");
				query.append(allPharmacyComboBoxModel.getElementAt(comboBoxPharmInfo.getSelectedIndex()).getValue());
				query.append("\'");
				dataManager.runQuery(query.toString());
				setMainPharmacyTable();
				comboBoxCurrentPharmacyPerscriptions.setModel(allPharmacyComboBoxModel);
				comboBoxCurrentPharmacyPerscriptionManager.setModel(allPharmacyComboBoxModel);
				comboBoxCurrentPharmacyDrugs.setModel(allPharmacyComboBoxModel);
				comboBoxPharmInfo.setModel(allPharmacyComboBoxModel);
				comboBoxPharmContractChange.setModel(allPharmacyComboBoxModel);
				comboBoxPharmContract.setModel(allPharmacyComboBoxModel);
			}
			else if (name.equals("changePharmacyCompany")){
				StringBuilder query = new StringBuilder();
				query.append("Update pharmacy_company set phone_number = ");
				query.append(pharmCompPhoneShow.getText());
				query.append(" where pharmacy_company_name = \'");
				query.append(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompanyChange.getSelectedIndex()).getValue());
				query.append("\'");
				dataManager.runQuery(query.toString());
				setMainPharmacyCompanyTable();
			}
			else if (name.equals("changeDrug")){
				StringBuilder query = new StringBuilder();
				query.append("update make_drug set formula = \'");
				query.append(drugFormulaChange.getText());
				query.append("\' where pharm_comp = \'");
				query.append(allPharmacyCompanyComboBoxModel.getElementAt(comboBoxPharmacyCompanyChangeDrug.getSelectedIndex()).getValue());
				query.append("\' and drug_name = \'");
				query.append(comboBoxDrugChange.getModel().getElementAt(comboBoxDrugChange.getSelectedIndex()).getValue());
				query.append("\'");
				dataManager.runQuery(query.toString());
				setMainDrugTable();
			}
			else if (name.equals("changeContract")){
				StringBuilder query = new StringBuilder();
				query.append("update contracts set supervisor =\'");
				query.append(supervisorChangeFirstName.getText()).append(" ");
				query.append(supervisorChangeLastName.getText()).append("\'");
				query.append("where pharm_name = \'");
				query.append(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()).append("\' and pharm_comp = \'");
				query.append(comboBoxPharmCompContractChange.getModel().getElementAt(comboBoxPharmCompContractChange.getSelectedIndex()).getValue()).append("\'");
				dataManager.runQuery(query.toString());
			}
			else if(name.equals("removePatient")){
				int row = mainPatientTable.getSelectedRow();
				if(row > -1){
					StringBuilder query = new StringBuilder();
					query.append("delete from patients where patient_ssn = ");
					query.append(mainPatientTable.getValueAt(row, 0));
					dataManager.runQuery(query.toString());
					StringBuilder query2 = new StringBuilder();
					query2.append("delete from perscriptions where patient_ssn = ");
					query2.append(mainPatientTable.getValueAt(row, 0));
					dataManager.runQuery(query2.toString());
					allPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPatients());
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());					
					setMainPatientTable();
					perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPerscriptPatient(
							allPatientComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
					comboBoxCurrentPatientGen.setModel(allPatientComboBoxModel);
					comboBoxCurrentPatient.setModel(allPatientComboBoxModel);
					comboBoxPerscriptionManagerCurrentPatient.setModel(allPatientComboBoxModel);
					setPatientInfoFields(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatientGen.getSelectedIndex()).getValue());
				}
				
			}
			else if(name.equals("removeDoctor")){
				int row = mainDoctorTable.getSelectedRow();
				if(row > -1){
					StringBuilder query1, query2, query3, query4,query5,query6;
					query2 = new StringBuilder();
					query2.append("delete from perscriptions where patient_ssn in");
					query2.append("(select p.patient_ssn from patients p, doctors d where p.primary_doctor_ssn = d.ssn and d.ssn = ");
					query2.append(mainDoctorTable.getValueAt(row,0)).append(")");
					dataManager.runQuery(query2.toString());
					query1 = new StringBuilder();
					query1.append("delete from patients where primary_doctor_ssn =");
					query1.append(mainDoctorTable.getValueAt(row,0));
					dataManager.runQuery(query1.toString());
					query3 = new StringBuilder();
					query3.append("delete from doctors where ssn =");
					query3.append(mainDoctorTable.getValueAt(row,0));
					dataManager.runQuery(query3.toString());
					
					//remove perscription
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
					
					//remove patient
					allPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPatients());
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());					
					setMainPatientTable();
					perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPerscriptPatient(
							allPatientComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
					comboBoxCurrentPatientGen.setModel(allPatientComboBoxModel);
					comboBoxCurrentPatient.setModel(allPatientComboBoxModel);
					comboBoxPerscriptionManagerCurrentPatient.setModel(allPatientComboBoxModel);
					setPatientInfoFields(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatientGen.getSelectedIndex()).getValue());
					
					//remove doctor
					setMainDoctorTable();
					allDoctorComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllDoctors());
					comboBoxPrimaryPhysician.setModel(allDoctorComboBoxModel);
					comboBoxDoctorPerscribe.setModel(allDoctorComboBoxModel);
					comboBoxCurrentDoctorGen.setModel(allDoctorComboBoxModel);
					perscripPatientComboBoxModel = new DefaultComboBoxModel<ComboItem>(
							getPerscriptPatient(allDoctorComboBoxModel.getElementAt(comboBoxDoctorPerscribe.getSelectedIndex()).getValue()));
					
				}
				
			}
			else if(name.equals("removePerscription")){
				if(pharmacyPerscriptionsViewTable.getSelectedRow() > -1){
					StringBuilder query = new StringBuilder();
					query.append("delete from perscriptions where perscription_seq_id =");
					query.append(pharmacyPerscriptionsViewTable.getValueAt(pharmacyPerscriptionsViewTable.getSelectedRow(),0));
					dataManager.runQuery(query.toString());
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());					
				}
				
			}
			else if(name.equals("removeDrug")){
				if(mainDrugTable.getSelectedRow() > -1){
					StringBuilder query1, query2,query4;
					query1 = new StringBuilder();
					query1.append("delete from pharm_sells where pharmacy_drug_name = \'");
					query1.append(mainDrugTable.getValueAt(mainDrugTable.getSelectedRow(), 0)).append("\' and pharm_comp =\'");
					query1.append(mainDrugTable.getValueAt(mainDrugTable.getSelectedRow(), 1)).append("\'");
					query2 = new StringBuilder();
					query2.append("delete from make_drug where drug_name = \'");
					query2.append(mainDrugTable.getValueAt(mainDrugTable.getSelectedRow(), 0)).append("\' and pharm_comp =\'");
					query2.append(mainDrugTable.getValueAt(mainDrugTable.getSelectedRow(), 1)).append("\'");
					query4 = new StringBuilder();
					query4.append("delete from Perscriptions where pharm_drug = \'");
					query1.append(mainDrugTable.getValueAt(mainDrugTable.getSelectedRow(), 0)).append("\' and pharmacy_company =\'");
					query1.append(mainDrugTable.getValueAt(mainDrugTable.getSelectedRow(), 1)).append("\'");
					dataManager.runQuery(query1.toString());
					dataManager.runQuery(query2.toString());
					dataManager.runQuery(query4.toString());
					perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
					comboBoxDrugPerscribe.setModel(perscripDrugComboBoxModel);
					setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					setMainDrugTable();
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
					perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
					comboBoxDrugPerscribe.setModel(perscripDrugComboBoxModel);
					setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					setMainDrugTable();
					switch(getSelectedButtonText(drugViewGroup)){
					case "Competitior\'s Similar Drugs":
						setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "All":
						setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "Not Priced":
						setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					default:
						break;				
				
					}
					
					
				}
			}
			else if(name.equals("removePharmacy")){
				int row = mainPharmacyTable.getSelectedRow();
				if(row > -1){
					StringBuilder query1, query2, query3, query4;
					query1 = new StringBuilder();
					query1.append("delete from perscriptions where pharmacy = \'");
					query1.append(mainPharmacyTable.getValueAt(row, 0)).append("\'");
					dataManager.runQuery(query1.toString());
					query3 = new StringBuilder();
					query3.append("delete from contracts where pharm_name = \'");
					query3.append(mainPharmacyTable.getValueAt(row, 0)).append("\'");
					dataManager.runQuery(query3.toString());
					query4 = new StringBuilder();
					query4.append("delete from pharm_sells where pharmacy = \'");
					query4.append(mainPharmacyTable.getValueAt(row, 0)).append("\'");
					dataManager.runQuery(query4.toString());
					query2 = new StringBuilder();
					query2.append("delete from pharmacy where pharmacy_name = \'");
					query2.append(mainPharmacyTable.getValueAt(row, 0)).append("\'");
					dataManager.runQuery(query2.toString());
					setMainPharmacyTable();
					allPharmacyComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPharmacies());
					comboBoxCurrentPharmacyPerscriptions.setModel(allPharmacyComboBoxModel);
					comboBoxCurrentPharmacyPerscriptionManager.setModel(allPharmacyComboBoxModel);
					comboBoxCurrentPharmacyDrugs.setModel(allPharmacyComboBoxModel);
					comboBoxPharmInfo.setModel(allPharmacyComboBoxModel);
					comboBoxPharmContractChange.setModel(allPharmacyComboBoxModel);
					comboBoxPharmContract.setModel(allPharmacyComboBoxModel);
					setMainContractTable();
			    	DefaultComboBoxModel<ComboItem> tempModel = new DefaultComboBoxModel<ComboItem>(getContractPharmacyCompanyDropDown(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue()));
			    	comboBoxPharmCompContract.setModel(tempModel);
			    	pharmCompContractChangeComboBoxModel = new DefaultComboBoxModel<ComboItem>(getContractedPharmaciesDropDown(
							allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()));
					comboBoxPharmCompContractChange.setModel(pharmCompContractChangeComboBoxModel);
					switch(getSelectedButtonText(drugViewGroup)){
					case "Competitior\'s Similar Drugs":
						setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "All":
						setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "Not Priced":
						setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					default:
						break;				
				
					}	
					perscriptionManagerCurrentPerscriptionComboBoxModel = new DefaultComboBoxModel<ComboItem>(getPatientPerscriptionDropDown(
							allPatientComboBoxModel.getElementAt(comboBoxPerscriptionManagerCurrentPatient.getSelectedIndex()).getValue()));
				    comboBoxPerscriptionManagerCurrentPerscription.setModel(perscriptionManagerCurrentPerscriptionComboBoxModel);
					setPatientPerscriptionPharmacyListTableModel(perscriptionManagerCurrentPerscriptionComboBoxModel.getElementAt(
							comboBoxPerscriptionManagerCurrentPerscription.getSelectedIndex()).getValue());
					perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
					comboBoxDrugPerscribe.setModel(perscripDrugComboBoxModel);
					setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
					
					
				}				
			}
			else if(name.equals("removePharmacyCompany")){
				int row = mainPharmacyCompanyTable.getSelectedRow();
				if(row > -1){
					StringBuilder query1,query2,query3,query4,query5;
					query1 = new StringBuilder();
					query1.append("delete from contracts where pharm_comp = \'");
					query1.append(mainPharmacyCompanyTable.getValueAt(row,0)).append("\'");
					dataManager.runQuery(query1.toString());
					query2 = new StringBuilder();
					query2.append("delete from perscriptions where pharmacy_company =\'");
					query2.append(mainPharmacyCompanyTable.getValueAt(row,0)).append("\'");
					dataManager.runQuery(query2.toString());
					query3 = new StringBuilder();
					query3.append("delete from pharm_sells where pharm_comp = \'");
					query3.append(mainPharmacyCompanyTable.getValueAt(row,0)).append("\'");
					dataManager.runQuery(query3.toString());
					query4 = new StringBuilder();
					query4.append("delete from make_drug where pharm_comp = \'");
					query4.append(mainPharmacyCompanyTable.getValueAt(row,0)).append("\'");
					dataManager.runQuery(query4.toString());
					query5 = new StringBuilder();
					query5.append("delete from pharmacy_company where pharmacy_company_name = \'");
					query5.append(mainPharmacyCompanyTable.getValueAt(row,0)).append("\'");
					dataManager.runQuery(query5.toString());
					
					//remove drug
					perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
					comboBoxDrugPerscribe.setModel(perscripDrugComboBoxModel);
					setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
					setMainDrugTable();
					switch(getSelectedButtonText(drugViewGroup)){
					case "Competitior\'s Similar Drugs":
						setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "All":
						setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "Not Priced":
						setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					default:
						break;				
				
					}
					//remove perscription
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
					//remove pharmacyCompany
					setMainPharmacyCompanyTable();
					allPharmacyCompanyComboBoxModel = new DefaultComboBoxModel<ComboItem>(getAllPharmacyCompanies());
					comboBoxPharmacyCompanyChange.setModel(allPharmacyCompanyComboBoxModel);
					comboBoxPharmacyCompany.setModel(allPharmacyCompanyComboBoxModel);
					//removeContract
					setMainContractTable();
			    	DefaultComboBoxModel<ComboItem> tempModel = new DefaultComboBoxModel<ComboItem>(getContractPharmacyCompanyDropDown(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue()));
			    	comboBoxPharmCompContract.setModel(tempModel);
			    	pharmCompContractChangeComboBoxModel = new DefaultComboBoxModel<ComboItem>(getContractedPharmaciesDropDown(
							allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()));
					comboBoxPharmCompContractChange.setModel(pharmCompContractChangeComboBoxModel);					
					
				}
				
			}
			else if(name.equals("removeContract")){
				int row = mainContractTable.getSelectedRow();
				if(row > -1){
					StringBuilder query1, query2,query3,query4,query5;
					query1 = new StringBuilder();
					query1.append("delete from pharm_sells where pharmacy =\'");
					query1.append(mainContractTable.getValueAt(row,0)).append("\' and pharm_comp =\'");
					query1.append(mainContractTable.getValueAt(row, 1)).append("\'");
					dataManager.runQuery(query1.toString());
					query2 = new StringBuilder();
					query2.append("delete from contracts where pharm_name = \'");
					query2.append(mainContractTable.getValueAt(row,0)).append("\' and pharm_comp =\'");
					query2.append(mainContractTable.getValueAt(row, 1)).append("\'");
					dataManager.runQuery(query2.toString());
					//query3 = new StringBuilder();
					//query3.append("delete from pharm_sells where pharmacy =\'");
					//query3.append(mainContractTable.getValueAt(row,0)).append("\' and pharm_comp =\'");
					//query3.append(mainContractTable.getValueAt(row, 1)).append("\'");
					//System.out.println(query3.toString());
					query4 = new StringBuilder();
					query4.append("delete from perscriptions where pharmacy = \'");
					query4.append(mainContractTable.getValueAt(row,0)).append("\' and pharmacy_company =\'");
					query4.append(mainContractTable.getValueAt(row, 1)).append("\'");
					dataManager.runQuery(query4.toString());					
					
					//removeSellDrugs
					perscripDrugComboBoxModel = new DefaultComboBoxModel<ComboItem>(getDinstinctDrug());
					comboBoxDrugPerscribe.setModel(perscripDrugComboBoxModel);
					switch(getSelectedButtonText(drugViewGroup)){
					case "Competitior\'s Similar Drugs":
						setPharmacyDrugsViewCompetitiorsTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "All":
						setPharmacyDrugsViewTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					case "Not Priced":
						setPharmacyDrugsViewNotPricedTable(allPharmacyComboBoxModel.getElementAt(
								comboBoxCurrentPharmacyDrugs.getSelectedIndex()).getValue());
						break;
					default:
						break;				
				
					}
					
					//removeContract
					setMainContractTable();
			    	DefaultComboBoxModel<ComboItem> tempModel = new DefaultComboBoxModel<ComboItem>(getContractPharmacyCompanyDropDown(allPharmacyComboBoxModel.getElementAt(comboBoxPharmContract.getSelectedIndex()).getValue()));
			    	comboBoxPharmCompContract.setModel(tempModel);
			    	pharmCompContractChangeComboBoxModel = new DefaultComboBoxModel<ComboItem>(getContractedPharmaciesDropDown(
							allPharmacyComboBoxModel.getElementAt(comboBoxPharmContractChange.getSelectedIndex()).getValue()));
					comboBoxPharmCompContractChange.setModel(pharmCompContractChangeComboBoxModel);
					
					//removePerscriptions
					setPharmacyPerscriptionMangerTableModel(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptionManager.getSelectedIndex()).getValue());
			    	setPharmacyPerscriptionsViewTable(allPharmacyComboBoxModel.getElementAt(
							comboBoxCurrentPharmacyPerscriptions.getSelectedIndex()).getValue());
					setPatientPerscriptionListTableModel(allPatientComboBoxModel.getElementAt(comboBoxCurrentPatient.getSelectedIndex()).getValue());
					
					
				}				
			}
		}
	}
	private final class TabListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub	
			
		}
	}
	
	private final class ComboItem {
	    private String value;
	    private String label;

	    public ComboItem(String value, String label) {
	        this.value = value;
	        this.label = label;
	    }
	    
	    public ComboItem(String value){
	    	this.value = value;
	    	this.label = value;
	    }

	    public String getValue() {
	        return this.value;
	    }

	    public String getLabel() {
	        return this.label;
	    }

	    @Override
	    public String toString() {
	        return label;
	    }
	
	}
}
