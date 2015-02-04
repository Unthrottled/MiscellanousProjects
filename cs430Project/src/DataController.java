import java.sql.SQLException;

import oracle.jdbc.OracleResultSet;




public class DataController {

	private OracleConnection jdbc;
	
	public DataController(){
		jdbc = new OracleConnection();
	}
	
	public String[][] getAllPatients(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from patients");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select patient_ssn, "
					+ "p.personal_first_name || ' ' || p.personal_last_name patient_name,"
					+ "age,"
					+ "address,"
					+ "d.personal_first_name || ' ' || d.personal_last_name doctor_name"
					+ " from patients p, doctors d "
					+ "where "
					+ "d.ssn = p.primary_doctor_ssn "+
					"order by patient_ssn asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = "Dr. " + resultSet.getString(5);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getAllDoctors(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from doctors");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select ssn, "
					+ "d.personal_first_name || ' ' || d.personal_last_name patient_name,"
					+ "specialty,"
					+ "experience "
					+ " from doctors d "					
					+"order by ssn asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = "Dr. " + resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getAllDrugs(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from make_drug");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select drug_name, "
					+ "pharm_comp,"
					+ "formula "
					+ " from make_drug "					
					+"order by drug_name, pharm_comp asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getAllPharmacies(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from pharmacy");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select pharmacy_name, "
					+ "address, "
					+ "phone_number"
					+ " from pharmacy "					
					+"order by pharmacy_name asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getAllPharmacyCompanies(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from pharmacy_company");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select pharmacy_company_name, "
					+ "phone_number"
					+ " from pharmacy_company "					
					+"order by pharmacy_company_name asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);										
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getMostExpensiveDrugs(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from make_drug md, pharm_sells ps " +
" where ps.pharmacy_drug_name = md.drug_name and ps.pharm_comp = md.pharm_comp and nvl(ps.price,0) >= ALL (select nvl(ps2.price,0) from pharm_sells ps2 where " 
+ " ps2.pharmacy_drug_name = ps.pharmacy_drug_name)");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "select ps.pharmacy_drug_name,ps.pharm_comp,md.formula,ps.pharmacy,nvl(ps.price, 0) from make_drug md, pharm_sells ps " +
" where ps.pharmacy_drug_name = md.drug_name and ps.pharm_comp = md.pharm_comp and nvl(ps.price,0) >= ALL (select nvl(ps2.price,0) from pharm_sells ps2 where" 
+ " ps2.pharmacy_drug_name = ps.pharmacy_drug_name) order by ps.pharmacy_drug_name asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getAllContracts(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from contracts");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select pharm_name, "
					+ "pharm_comp,"
					+ "start_date,"
					+ "end_date, "
					+ "supervisor"
					+ " from contracts "					
					+"order by pharm_name asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getPharmacyPerscriptionsViewTable(String pharmacyName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from perscriptions where "
					+ " pharmacy = \'" + pharmacyName + "\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][6];
			resultSet.close();
			String query = "Select per.perscription_seq_id, "
					+ "pat.personal_first_name || ' ' || pat.personal_last_name patient_name,"
					+ "per.pharm_drug,"
					+ "per.pharmacy_company, "
					+ "per.Quantity,"
					+ "per.status"
					+ " from perscriptions per, patients pat where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" per.patient_ssn = pat.patient_ssn "
					+" order by perscription_seq_id asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					queryResults[i][5] = resultSet.getString(6);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getPharmacyPerscriptionsViewNotProcTable(String pharmacyName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*)"
					+ " from perscriptions per, patients pat where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" per.patient_ssn = pat.patient_ssn and status = 0 ");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][6];
			resultSet.close();
			String query = "Select per.perscription_seq_id, "
					+ "pat.personal_first_name || ' ' || pat.personal_last_name patient_name,"
					+ "per.pharm_drug,"
					+ "per.pharmacy_company, "
					+ "per.Quantity,"
					+ "per.status"
					+ " from perscriptions per, patients pat where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" per.patient_ssn = pat.patient_ssn and status = 0 "
					+" order by perscription_seq_id asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					queryResults[i][5] = resultSet.getString(6);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getPharmacyPerscriptionsViewReadyTodayTable(String pharmacyName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) "
					+ " from perscriptions per, patients pat where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" per.patient_ssn = pat.patient_ssn and per.completed_time >= trunc(sysdate)");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][6];
			resultSet.close();
			String query = "Select per.perscription_seq_id, "
					+ "pat.personal_first_name || ' ' || pat.personal_last_name patient_name,"
					+ "per.pharm_drug,"
					+ "per.pharmacy_company, "
					+ "per.Quantity,"
					+ "per.status"
					+ " from perscriptions per, patients pat where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" per.patient_ssn = pat.patient_ssn and per.completed_time >= trunc(sysdate) "
					+" order by perscription_seq_id asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					queryResults[i][5] = resultSet.getString(6);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getPharmacyPerscriptionsViewReadyTable(String pharmacyName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from perscriptions per where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" status = 2");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][6];
			resultSet.close();
			String query = "Select per.perscription_seq_id, "
					+ "pat.personal_first_name || ' ' || pat.personal_last_name patient_name,"
					+ "per.pharm_drug,"
					+ "per.pharmacy_company, "
					+ "per.Quantity,"
					+ "per.status"
					+ " from perscriptions per, patients pat where "
					+ " per.pharmacy = \'" + pharmacyName + "\' and "
					+" per.patient_ssn = pat.patient_ssn and status = 2"
					+" order by perscription_seq_id asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					queryResults[i][5] = resultSet.getString(6);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getPharmacyPerscriptionsManagerTable(String pharmacyName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from perscriptions where "
					+ " pharmacy = \'" + pharmacyName + "\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select per.perscription_seq_id, "
					+ "per.pharm_drug,"
					+ "per.pharmacy_company, "
					+ "per.Quantity,"
					+ "per.status"
					+ " from perscriptions per where "
					+ " per.pharmacy = \'" + pharmacyName + "\'  "
					+" order by perscription_seq_id asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getPatientPerscriptions(String patientSSN){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from perscriptions "+ "where "
					+ "Patient_SSN = "+ patientSSN);
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][6];
			resultSet.close();
			String query = "Select Perscription_Seq_Id, " +					
					"Pharm_Drug,"
					+ "Quantity, "
					+ "Perscribed_Date, "
					+ "status,"
					+ "nvl(pharmacy, \'No Pharmacy\'), pharmacy "
					+ " from Perscriptions "
					+ "where "
					+ "Patient_SSN = "+ patientSSN +
					"order by Perscription_Seq_Id asc";			
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					queryResults[i][5] = resultSet.getString(6);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getDrugPharmacyOptions(String drugName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*)" + " from Pharm_Sells "
					+ "where "
					+ "Pharmacy_Drug_Name = \'"+ drugName +
					"\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select Pharmacy, " +					
					"Pharm_Comp,"
					+ "Price "					
					+ " from Pharm_Sells "
					+ "where "
					+ "Pharmacy_Drug_Name = \'"+ drugName +
					"\' Group by pharmacy,pharm_comp, price order by Pharmacy, price asc";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getPharmacyDrugsViewTable(String pharmName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*)" + " from Pharm_Sells "
					+ "where "
					+ "Pharmacy = \'"+ pharmName +
					"\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select pharmacy_drug_name, " +					
					"Pharm_Comp,"
					+ "Price "					
					+ " from Pharm_Sells "
					+ "where "
					+ "Pharmacy = \'"+ pharmName +
					"\'"; // Group by pharmacy_drug_name,pharm_comp, price order by Pharmacy, price asc";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getPharmacyDrugsViewNotPricedTable(String pharmName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*)" + " from Pharm_Sells "
					+ "where "
					+ "Pharmacy = \'"+ pharmName +
					"\' and price is null");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select pharmacy_drug_name, " +					
					"Pharm_Comp,"
					+ "Price "					
					+ " from Pharm_Sells "
					+ "where "
					+ "Pharmacy = \'"+ pharmName +
					"\' and price is null"; // Group by pharmacy_drug_name,pharm_comp, price order by Pharmacy, price asc";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getPharmacyDrugsViewCompetitorsTable(String pharmName){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*)" + " from Pharm_Sells "
					+ "where "
					+ "Pharmacy != \'" + pharmName + "\' and Pharmacy_Drug_Name in (Select p2.pharmacy_drug_name from pharm_sells p2 where p2.Pharmacy = \'"+ pharmName +"\')");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][5];
			resultSet.close();
			String query = "Select p1.pharmacy_drug_name, p1.Pharmacy, " +					
					"p1.Pharm_Comp,"
					+ "p1.Price, pharm.phone_number "					
					+ " from Pharm_Sells p1, pharmacy pharm "
					+ "where "
					+ "p1.Pharmacy = pharm.pharmacy_name and p1.Pharmacy != \'" + pharmName + "\' and p1.Pharmacy_Drug_Name in (Select p2.pharmacy_drug_name from pharm_sells p2 where p2.Pharmacy = \'"+ pharmName +"\')";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					queryResults[i][2] = resultSet.getString(3);
					queryResults[i][3] = resultSet.getString(4);
					queryResults[i][4] = resultSet.getString(5);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getAllDoctorList(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from doctors");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][2];
			resultSet.close();
			String query = "Select " 			
					+ "d.personal_first_name || ' ' || d.personal_last_name doctor_name,"
					+ "d.ssn"
					+ " from doctors d ";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = "Dr. " + resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getAllPatientList(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from patients");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][2];
			resultSet.close();
			String query = "Select " 			
					+ "d.personal_first_name || ' ' || d.personal_last_name doctor_name,"
					+ "d.patient_ssn"
					+ " from patients d ";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[][] getAllPharmacyList(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from pharmacy");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][2];
			resultSet.close();
			String query = "Select " 			
					+ "pharmacy_name"
					+ " from pharmacy ";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getAllPharmacyCompanyList(){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from pharmacy_company");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][2];
			resultSet.close();
			String query = "Select " 			
					+ "pharmacy_company_name"
					+ " from pharmacy_company ";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getPatientPerscriptionDropDowList(String patientSSN){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from Perscriptions where "+ patientSSN + " = Patient_SSN "
					+ "and status = -1");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][2];
			resultSet.close();
			String query = "Select " 			
					+ "Perscription_Seq_Id, pharm_drug"
					+ " from Perscriptions where "+ patientSSN + " = Patient_SSN"
					+ " and status = -1";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getContractingPharmacyCompanyDropDownList(String pharmName){
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from pharmacy_company where pharmacy_company_name not in (select pharm_comp " +
					"from contracts where pharm_name = \'" + pharmName + "\')");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select " 			
					+ "pharmacy_company_name s "
					+ "from pharmacy_company where pharmacy_company_name not in (select pharm_comp " +
							"from contracts where pharm_name = \'" + pharmName + "\')";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getContractedPharmaciesDropDown(String pharmName){
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from contracts where pharm_name = \'" + pharmName + "\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select " 			
					+ "pharm_comp s " +
					"from contracts where pharm_name = \'" + pharmName + "\'";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getDrugDropDownList(String pharmCompName){
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) " +
					"from make_drug where pharm_comp = \'" + pharmCompName + "\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select " 			
					+ "drug_name s "
					+ "from make_drug where pharm_comp = \'" + pharmCompName + "\'";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getNonContractedPharmacyCompanyDropDownList(String pharmName){
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from pharmacy_company where pharmacy_company_name not in (select pharm_comp " +
					"from contracts where pharm_name = \'" + pharmName + "\')");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select " 			
					+ "pharmacy_company_name"
					+ "from pharmacy_company where pharmacy_company_name not in (select pharm_comp " +
							"from contracts where pharm_name = \'" + pharmName + "\')";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getContractedPharmacyDropDownList(){
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(distinct pharmacy_name) from contracts");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select distinct " 			
					+ "pharmacy_name"
					+ "from contracts";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getContractedPharmacyCompanyDropDownList(String pharmName){
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(distinct pharmacy_company_name) from contracts where pharmacy_name = \'" + pharmName + "\'");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select distinct " 			
					+ "pharmacy_name"
					+ "from contracts";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getSinglePatientInfo(String patientSSN){
		String[] queryResults = null;
		OracleResultSet resultSet;	
		try {
			queryResults = new String[5];			
			String query = "Select personal_first_name,personal_last_name,address,age,primary_doctor_ssn " 			
					+ "from patients where patient_ssn = " + patientSSN;
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[0] = resultSet.getString(1);
					queryResults[1] = resultSet.getString(2);
					queryResults[2] = resultSet.getString(3);
					queryResults[3] = resultSet.getString(4);
					queryResults[4] = resultSet.getString(5);				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getSingleDoctorInfo(String doctorSSN){
		String[] queryResults = null;
		OracleResultSet resultSet;	
		try {
			queryResults = new String[4];			
			String query = "Select personal_first_name,personal_last_name,specialty,experience " 			
					+ "from doctors where ssn = " + doctorSSN;
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[0] = resultSet.getString(1);
					queryResults[1] = resultSet.getString(2);
					queryResults[2] = resultSet.getString(3);
					queryResults[3] = resultSet.getString(4);								
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getSingleContractInfo(String pharmName, String pharmCompName){
		String[] queryResults = null;
		OracleResultSet resultSet;	
		try {
			queryResults = new String[4];			
			String query = "select text, supervisor, start_date,end_date from contracts where pharm_name = \'" + 
			pharmName + "\' and pharm_comp = \'" + pharmCompName + "\'";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[0] = resultSet.getString(1);
					queryResults[1] = resultSet.getString(2);
					queryResults[2] = resultSet.getString(3);
					queryResults[3] = resultSet.getString(4);								
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getSinglePharmacyInfo(String pharmName){
		String[] queryResults = null;
		OracleResultSet resultSet;	
		try {
			queryResults = new String[4];			
			String query = "Select address,phone_number " 			
					+ "from pharmacy where pharmacy_name = \'" + pharmName +"\'";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[0] = resultSet.getString(1);
					queryResults[1] = resultSet.getString(2);									
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getSinglePharmacyCompanyInfo(String pharmCompName){
		String[] queryResults = null;
		OracleResultSet resultSet;	
		try {
			queryResults = new String[1];			
			String query = "Select phone_number " 			
					+ "from pharmacy_company where pharmacy_company_name = \'" + pharmCompName +"\'";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[0] = resultSet.getString(1);														
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[] getSingleDrugInfo(String drugName){
		String[] queryResults = null;
		OracleResultSet resultSet;	
		try {
			queryResults = new String[1];			
			String query = "Select formula " 			
					+ "from make_drug where drug_name = \'" + drugName +"\'";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[0] = resultSet.getString(1);														
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}
	public String[][] getPatientList(String doctorSSN){
		String[][] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("Select count(*) from patients where "+ doctorSSN + " = primary_doctor_ssn");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))][2];
			resultSet.close();
			String query = "Select " 			
					+ "p.personal_first_name || ' ' || p.personal_last_name patient_name,"
					+ "p.patient_ssn"
					+ " from patients p where "+ doctorSSN + " = primary_doctor_ssn";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i][0] = resultSet.getString(1);
					queryResults[i][1] = resultSet.getString(2);
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;		
	}	
	public String[] getUniqueDrug(){		
		String[] queryResults = null;
		OracleResultSet resultSet;		
		int i = 0;		
		try {
			resultSet = jdbc.queryDataBase("select count( distinct drug_name) from make_drug");
			resultSet.next();
			queryResults = new String[(resultSet.getInt(1))];
			resultSet.close();
			String query = "Select distinct " 			
					+ "drug_name"
					+ " from make_drug order by drug_name asc";
			resultSet = jdbc.queryDataBase(query);			
			while(resultSet.next()){					
					queryResults[i] = resultSet.getString(1);					
					i++;				
			}
			resultSet.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		return queryResults;
	}
	public boolean addNewPatient(String query){
	OracleResultSet resultSet = jdbc.queryDataBase(query);	
	return true;
	}
	public boolean runQuery(String query){
	OracleResultSet resultSet = jdbc.queryDataBase(query);	
	try {
		resultSet.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
	}
}
